<?php

App::uses('AuthComponent', 'Controller/Component');

class CodeLayout extends AppModel {

    public $name = 'CodeLayout';
    public $useTable = 'default_code_layouts';

    public function beforeSave($options = array()) {
        if (isset($this->data[$this->alias]['password']) && !empty($this->data[$this->alias]['password'])) {
            $this->data[$this->alias]['password'] = AuthComponent::password($this->data[$this->alias]['password']);

            return true;
        }
    }

    public $validate = array(
        'model_name' => array(
            array(
                'rule' => array('notEmpty'),
                'message' => 'A singular name is required.'
            )
        ),
        'content' => array(
            array(
                'rule' => array('notEmpty'),
                'message' => 'A plural name is required.'
            )
        ),
    );


}

?>
