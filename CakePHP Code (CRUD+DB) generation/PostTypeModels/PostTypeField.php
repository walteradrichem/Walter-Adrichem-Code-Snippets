<?php

App::uses('AuthComponent', 'Controller/Component');

class PostTypeField extends AppModel {

    public $name = 'PostTypeField';
    public $useTable = 'post_type_fields';

    public function beforeSave($options = array()) {
        if (isset($this->data[$this->alias]['password']) && !empty($this->data[$this->alias]['password'])) {
            $this->data[$this->alias]['password'] = AuthComponent::password($this->data[$this->alias]['password']);
            return true;
        }
    }

    public $belongsTo = array(
        'PostType' => array(
            'className' => 'PostType',
            'foreignKey' => 'id'
        )
    );

    function getFields($id) {
        $data = $this->find('all', array(
            'conditions' => array(
                'PostTypeField.post_type_id' => $id,
            ),
            'order' => array('PostTypeField.sort DESC'),
        ));
        return $data;
    }

}

?>
