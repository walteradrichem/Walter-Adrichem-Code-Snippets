<?php

App::uses('AuthComponent', 'Controller/Component');

class PostTypeRelation extends AppModel {

    public $name = 'PostTypeRelation';
    public $useTable = 'post_type_relations';

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

}

?>
