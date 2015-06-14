<?php

App::uses('AuthComponent', 'Controller/Component');

class PostType extends AppModel {

    public $name = 'PostType';
    public $useTable = 'post_types';

    public function beforeSave($options = array()) {
        if (isset($this->data[$this->alias]['password']) && !empty($this->data[$this->alias]['password'])) {
            $this->data[$this->alias]['password'] = AuthComponent::password($this->data[$this->alias]['password']);

            return true;
        }
    }

      
   public $hasMany = array(
        'PostTypeField' => array(
            'className' => 'PostTypeField',
            'foreignKey' => 'post_type_id'
        ),
        'PostTypeRelation' => array(
            'className' => 'PostTypeRelation',
            'foreignKey' => 'post_type_id'
        )
    );
    public $validate = array(
        'singular_name' => array(
            array(
                'rule' => array('notEmpty'),
                'message' => 'A singular name is required.'
            ),
            array(
                'rule' => 'isUnique',
                'message' => 'This singular name already exists.'
            )
        ),
        'plural_name' => array(
            array(
                'rule' => array('notEmpty'),
                'message' => 'A plural name is required.'
            ),
            array(
                'rule' => 'isUnique',
                'message' => 'This plural name already exists.'
            )
        ),
    );

function getPostTypeByName($name){
       $data = $this->find('first', array(
            'conditions' => array(
                'PostType.singular_name' => $name,
            ),
        ));
             return $data['PostType']['id'];
    
}
}

?>
