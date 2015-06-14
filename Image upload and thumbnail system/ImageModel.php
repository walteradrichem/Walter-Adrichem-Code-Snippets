<?php

App::import('Vendor', 'SimpleImage');
App::uses('AuthComponent', 'Controller/Component');

class Image extends AppModel {

    public $name = 'Image';
    public $useTable = 'upload_names';

    public function beforeSave($options = array()) {
        if (isset($this->data[$this->alias]['password']) && !empty($this->data[$this->alias]['password'])) {
            $this->data[$this->alias]['password'] = AuthComponent::password($this->data[$this->alias]['password']);
        }
        return true;
    }

    function createSmallThumbnail($url) {
        if (!file_exists($this->webroot . 'img/thumb/small/' . $url)) {
            if (file_exists($this->webroot . 'img/uploads/' . $url)) {
                $image = new SimpleImage();
                $image->load('img/uploads/' . $url);
                $image->fit_to_width(200);
                $image->save('img/thumb/small/' . $url);
                unset($image);
                return true;
            }
        }
    }

    function createMediumThumbnail($url) {
        if (!file_exists($this->webroot . 'img/thumb/medium/' . $url)) {
            if (file_exists($this->webroot . 'img/uploads/' . $url)) {
                $image = new SimpleImage();
                $image->load('img/uploads/' . $url);
                $image->fit_to_width(400);
                $image->save('img/thumb/medium/' . $url);
                unset($image);
                return true;
            }
        }
    }

    function createBigThumbnail($url) {
        if (!file_exists($this->webroot . 'img/thumb/big/' . $url)) {
            if (file_exists($this->webroot . 'img/uploads/' . $url)) {
                $image = new SimpleImage();
                $image->load('img/uploads/' . $url);
                $image->fit_to_width(1000);
                $image->save('img/thumb/big/' . $url);
                unset($image);
                return true;
            }
        }
    }
    function createSliderImg($url) {
        if (!file_exists($this->webroot . 'img/thumb/slider/' . $url)) {
            if (file_exists($this->webroot . 'img/uploads/' . $url)) {
                $image = new SimpleImage();
                $image->load('img/uploads/' . $url);
                $image->resize(810, 538);
                $image->save('img/thumb/slider/' . $url);
                return true;
            }
        }
    }

    function getAllImagesLimit($limit) {
        $data = $this->find('all', array(
            'order' => array('Image.date DESC'),
            'limit' => $limit,
        ));
        return $data;
    }

}

?>