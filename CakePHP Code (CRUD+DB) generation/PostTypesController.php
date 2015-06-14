<?php

App::uses('AppController', 'Controller');
App::uses('Folder', 'Utility');
App::uses('File', 'Utility');

class PostTypesController extends AppController {

    public $uses = array('PostType', 'CodeLayout');
    public $helpers = array('Form' => array('className' => 'CakeStrapForm'));

    public function index() {
        $this->set('title', 'Post Types');
        $this->set('add_link', 'posttype/add');
        $this->set('data', $this->PostType->find('all'));
    }

    public function add() {


        $this->set('title', 'Add Post Type');
        if ($this->request->is('post')) {
            if (!empty($this->request->data)) {
                if ($this->PostType->save($this->request->data)) {
                    $id = $this->PostType->getLastInsertId();
                    $this->Session->setFlash('Succesfully_added!', 'flash_success');
                } else {
                    $this->Session->setFlash('Something went wrong!', 'flash_fail');
                }
                $this->redirect('/posttypefield/all/' . $id);
            }
        }
    }

    public function edit($id) {
        $this->set('title', 'Edit Post Type');
        $this->set('data', $this->PostType->findById($id));

        if ($this->request->is('post')) {
            if (!empty($this->request->data)) {
                $this->PostType->read(null, $id);
                if ($this->PostType->save($this->request->data)) {
                    $this->Session->setFlash('Succesfully_added!', 'flash_success');
                } else {
                    $this->Session->setFlash('Something went wrong!', 'flash_fail');
                }
            }
        }
    }

    public function generateOppositeRelation($relation_type) {
        if ($relation_type == 'hasMany') {
            $newRel = 'belongsTo';
        } elseif ($relation_type == 'belongsTo') {
            $newRel = 'hasMany';
        } elseif ($relation_type == 'hasOne') {
            $newRel = 'hasOne';
        } else {
            $newRel = $relation_type;
        }
        return $newRel;
    }

    public function setPostTypesArray($all_layouts) {
        $postNames = array();

        foreach ($all_layouts as $all) {
            $postNames[$all['PostType']['id']] = $all['PostType']['singular_name'];
        }
        return $postNames;
    }

    public function generateRelationCode($postNames, $relation) {
        $data = "'" . $postNames[$relation['relation_target']] . "' => array(
                        'className' => '" . $postNames[$relation['relation_target']] . "',
                        'foreignKey' => 'post_type_id'
                    ),";
        return $data;
    }

    public function generateFieldReqCode($field) {
        // Generate Model requirements information
        if ($field['required'] == 0 && $field['isUnique'] == 0) {
               $string .="  ),";
        return $string;}else{
        $field['field_name'] = str_replace(' ', '_', $field['field_name']);
        $string = "'".$field['field_name']."' => array(";        
        if ($field['required'] == 1) {
            $string .= "array(
                'rule' => array('notEmpty'),
                'message' => '" . $field['field_name'] . "is required.'
            ),";
        }
        if ($field['isUnique'] == 1) {
            $string .= "array(
                'rule' => array('isUnique'),
                'message' => 'this " . $field['field_name'] . " already exists.'
            ),";
        }
     
         }
         $string = '';
         return $string;
    }

    public function generateFieldQuery($field) {
        // Generate SQL field coode
        $field['field_name'] = str_replace(' ', '_', $field['field_name']);
        if ($field['field_type'] == 'text') {
            $field['field_type'] = 'varchar(' . $field['char_limit'] . ')';
        }
        if ($field['field_type'] == 'number') {
            $field['field_type'] = 'int(11)';
        }
        $data = "`" . $field['field_name'] . "` " . $field['field_type'] . ",";
        return $data;
    }

    function generateModel($dir, $postType, $modelCodeLayout) {
        $file = new File($dir->pwd() . DS . $postType['PostType']['singular_name'] . '.php');
        $file->write($modelCodeLayout['CodeLayout']['content']);
        $file->close();
    }

    function generateController($dir, $postType, $codelayout) {
        $codelayout['CodeLayout']['content'] = str_replace('||plural||', $postType['PostType']['plural_name'], $codelayout['CodeLayout']['content']);
        $codelayout['CodeLayout']['content'] = str_replace('||singular||', $postType['PostType']['singular_name'], $codelayout['CodeLayout']['content']);
        $file = new File($dir->pwd() . DS . $postType['PostType']['plural_name'] . 'Controller.php');
        $file->write($codelayout['CodeLayout']['content']);
        $file->close();
    }
// Functie moet nog flink verkleint en versimpelt worden. Meer acties doorsturen naar andere functies
    public function generate() {
        $this->autoRender = false;
// moet nog relatie tussen gemaakt worden tussen relatie en target en orgineel
        if ($this->request->is('ajax')) {
            $this->loadModel('CodeLayout');
            $allPostTypes = $this->PostType->find('all');
            // set Code layouts
            $modelCodeLayout = $this->CodeLayout->findById(1);
            $controllerCodeLayout = $this->CodeLayout->findById(2);
            $indexCodeLayout = $this->CodeLayout->findById(3);
            $addCodeLayout = $this->CodeLayout->findById(4);
            $editCodeLayout = $this->CodeLayout->findById(5);
            $viewCodeLayout = $this->CodeLayout->findById(7);
            // set Dirs
            $dir = new Folder('../Model');
            $dirCon = new Folder('../Controller');
            
            $postNames = $this->setPostTypesArray($allPostTypes);

            // set dynamic Arrays
            foreach ($allPostTypes as $postType) {
                ${$postType['PostType']['singular_name'] . '_belongsTo'} = '';
                ${$postType['PostType']['singular_name'] . '_hasMany'} = '';
                ${$postType['PostType']['singular_name'] . '_hasOne'} = '';
                ${$postType['PostType']['singular_name'] . '_hasAndBelongsToMany'} = '';
                ${$postType['PostType']['singular_name'] . '_fields'} = '';
                ${$postType['PostType']['singular_name'] . '_req'} = '';
            }

            foreach ($allPostTypes as $postType) {
                // Create View dir and set Database name
                $dirIndex = new Folder('../View/' . $postType['PostType']['plural_name'], true, 0755);
                $database_name = strtolower($postType['PostType']['plural_name']);
                $database_name = str_replace(' ', '_', $database_name);

                // Generate relations of Posttype
                foreach ($postType['PostTypeRelation'] as $relation) {
                    ${$postNames[$relation['post_type_id']] . '_' . $relation['relation_type']} .= $this->generateRelationCode($postNames, $relation);
                }
                // Backup codelayout before making changes
                $backTemp = $modelCodeLayout['CodeLayout']['content'];
                $backTempCon = $controllerCodeLayout['CodeLayout']['content'];
                $backTempIndex = $indexCodeLayout['CodeLayout']['content'];
                $backTempAdd = $addCodeLayout['CodeLayout']['content'];
                $backTempEdit = $editCodeLayout['CodeLayout']['content'];
                $backTempView = $viewCodeLayout['CodeLayout']['content'];
                
                // Set Model information
                $modelCodeLayout['CodeLayout']['content'] = str_replace('||name||', $postType['PostType']['singular_name'], $modelCodeLayout['CodeLayout']['content']);
                $modelCodeLayout['CodeLayout']['content'] = str_replace('||table_name||', $database_name, $modelCodeLayout['CodeLayout']['content']);
                if (!empty(${$postType['PostType']['singular_name'] . '_belongsTo'})) {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$belongsTo||', 'public $belongsTo = array(' . ${$postType['PostType']['singular_name'] . '_belongsTo'} . ');', $modelCodeLayout['CodeLayout']['content']);
                } else {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$belongsTo||', '', $modelCodeLayout['CodeLayout']['content']);
                }
                if (!empty(${$postType['PostType']['singular_name'] . '_hasMany'})) {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$hasMany||', 'public $hasMany = array(' . ${$postType['PostType']['singular_name'] . '_hasMany'} . ');', $modelCodeLayout['CodeLayout']['content']);
                } else {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$hasMany||', '', $modelCodeLayout['CodeLayout']['content']);
                }
                if (!empty(${$postType['PostType']['singular_name'] . '_hasOne'})) {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$hasOne||', 'public $hasOne = array(' . ${$postType['PostType']['singular_name'] . '_hasOne'} . ');', $modelCodeLayout['CodeLayout']['content']);
                } else {
                    $modelCodeLayout['CodeLayout']['content'] = str_replace('||$hasOne||', '', $modelCodeLayout['CodeLayout']['content']);
                }
                
                // loop Trhrough field
                 foreach ($postType['PostTypeField'] as $field) {
                      // Generate field query
                    ${$postType['PostType']['singular_name'] . '_fields'} .= $this->generateFieldQuery($field);
                    // generate requerments
                    ${$postType['PostType']['singular_name'] . '_req'} .= $this->generateFieldReqCode($field);
                }
                 if (!empty(${$postType['PostType']['singular_name'] . '_req'})) {
                     $modelCodeLayout['CodeLayout']['content'] = str_replace('||validation||', 'public $validate = array(' . ${$postType['PostType']['singular_name'] . '_req'} . ');', $modelCodeLayout['CodeLayout']['content']);$modelCodeLayout['CodeLayout']['content'] = str_replace('||$hasOne||', 'public $hasOne = array(' . ${$postType['PostType']['singular_name'] . '_hasOne'} . ');', $modelCodeLayout['CodeLayout']['content']);
                } else {
                     $modelCodeLayout['CodeLayout']['content'] = str_replace('||validation||', '', $modelCodeLayout['CodeLayout']['content']);
                }
                 
                
                // Write new generated files
                $this->generateModel($dir, $postType, $modelCodeLayout);
                $this->generateController($dirCon, $postType, $controllerCodeLayout);
                $this->generateIndexView($dirIndex, $postType, $indexCodeLayout['CodeLayout']['content']);
                $this->generateAddView($dirIndex, $postType, $addCodeLayout['CodeLayout']['content']);
                $this->generateEditView($dirIndex, $postType, $editCodeLayout['CodeLayout']['content']);
                $this->generateViewView($dirIndex, $postType, $viewCodeLayout['CodeLayout']['content']);
                // Set back backup
                $modelCodeLayout['CodeLayout']['content'] = $backTemp;
                $controllerCodeLayout['CodeLayout']['content'] = $backTempCon;
                $indexCodeLayout['CodeLayout']['content'] = $backTempIndex;
                $addCodeLayout['CodeLayout']['content'] = $backTempAdd;
                $editCodeLayout['CodeLayout']['content'] = $backTempEdit;
                $viewCodeLayout['CodeLayout']['content'] = $backTempView;
               
                // Generate table
                $this->generateDBTable($database_name,${$postType['PostType']['singular_name'] . '_fields'});
                // Set postType Generated
                $this->PostType->read(null, $postType['PostType']['id']);
                $this->PostType->set('generated', 1);
                $this->PostType->save();
            }
        }
        $this->clearCache();
    }

    function generateDBTable($database_name, $queryFields) {
         $this->loadModel('CodeLayout');
          $this->CodeLayout->query('CREATE TABLE IF NOT EXISTS `' . $database_name . '` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  ' . $queryFields . '
      `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;');
    }
    function generateIndexView($dirIndex, $postType, $indexCodeLayout) {
        $indexCodeLayout = str_replace('||singular||', $postType['PostType']['singular_name'], $indexCodeLayout);
        $indexCodeLayout = str_replace('||plural||', $postType['PostType']['plural_name'], $indexCodeLayout);
        $newIndex = new File($dirIndex->pwd() . DS . 'index.ctp');
        $newIndex->write($indexCodeLayout);
        $newIndex->close();
    }

    function generateAddView($dirIndex, $postType, $indexCodeLayout) {
        $indexCodeLayout = str_replace('||singular||', $postType['PostType']['singular_name'], $indexCodeLayout);
        $indexCodeLayout = str_replace('||plural||', $postType['PostType']['plural_name'], $indexCodeLayout);
        $newIndex = new File($dirIndex->pwd() . DS . 'add.ctp');
        $newIndex->write($indexCodeLayout);
        $newIndex->close();
    }

    function generateEditView($dirIndex, $postType, $indexCodeLayout) {
        $indexCodeLayout = str_replace('||singular||', $postType['PostType']['singular_name'], $indexCodeLayout);
        $indexCodeLayout = str_replace('||plural||', $postType['PostType']['plural_name'], $indexCodeLayout);
        $newIndex = new File($dirIndex->pwd() . DS . 'edit.ctp');
        $newIndex->write($indexCodeLayout);
        $newIndex->close();
    }

    function generateViewView($dirIndex, $postType, $indexCodeLayout) {
        $indexCodeLayout = str_replace('||singular||', $postType['PostType']['singular_name'], $indexCodeLayout);
        $indexCodeLayout = str_replace('||plural||', $postType['PostType']['plural_name'], $indexCodeLayout);
        $newIndex = new File($dirIndex->pwd() . DS . 'view.ctp');
        $newIndex->write($indexCodeLayout);
        $newIndex->close();
    }


    public function deleteRelevantFilesAndFolders($data) {
        $singular = $data['PostType']['singular_name'];
        $plural = $data['PostType']['plural_name'];
        $model = new Folder('../Model');
        $con = new Folder('../Controller');
        $view = new Folder('../View/'.$plural);
        
        $model_file = new File($model->pwd() . DS . $singular.'.php');
        $model_file->delete(); // I am deleting this file
        $model_file->close(); 
        $con_file = new File($con->pwd() . DS . $plural.'Controller.php');
        $con_file->delete(); // I am deleting this file
        $con_file->close(); 
        $view->delete();
        
    }
    public function clearCache() {
     $models = new Folder('../tmp/cache/models');
        $per = new Folder('../tmp/cache/persistent');
        $models->delete();
        $per->delete();
        $newModel = new Folder('../tmp/cache/models', true, 0755);
        $newPer = new Folder('../tmp/cache/persistent', true, 0755);
    
    }
      function dropTable( $data) {
           $database_name = strtolower($data['PostType']['plural_name']);
                $database_name = str_replace(' ', '_', $database_name);
         $this->loadModel('CodeLayout');
          $this->CodeLayout->query('DROP TABLE `' . $database_name . '`');
    }
    public function delete($id) {
        $this->autoRender = false;

        if ($this->request->is('ajax')) {
            $this->loadModel('PostTypeRelation');
            $this->loadModel('PostTypeField');
            $data = $this->PostType->findById($id);
            $this->deleteRelevantFilesAndFolders($data);
            $this->dropTable($data);
            $this->PostTypeRelation->deleteAll(array('PostTypeRelation.post_type_id' => $id), false);
            $this->PostTypeField->deleteAll(array('PostTypeField.post_type_id' => $id), false);
            $this->PostType->delete($id);
        }
    }

}
