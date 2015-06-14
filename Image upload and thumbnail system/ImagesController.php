<?php

App::uses('AppController', 'Controller');

class ImagesController extends AppController {

    public function index() {

        $this->loadModel('Image');
        if ($this->request->is('post')) {
            $data = array();
            $this->Image->create();
            $arr_length = count($this->data) + 1;
            if ($arr_length != 0) {
                for ($i = 0; $i < $arr_length; $i++) {
                    if (!empty($this->data['Image']['files'][$i])) {
                        $file = $this->data['Image']['files'][$i];
                        $splitName = explode('.', $file['name']);
                        $newname = $splitName[0] . '_' . $this->generateRandomString(4) . '.' . $splitName[1];

                        move_uploaded_file($file['tmp_name'], WWW_ROOT . 'img/uploads/' . $newname);

                        $this->Image->createSmallThumbnail($newname);
                        $this->Image->createMediumThumbnail($newname);
                        $this->Image->createBigThumbnail($newname);
                        $this->Image->createSliderImg($newname);

                        $data[] = array(
                            'name' => $newname,
                            'category' => $this->data['category'],
                            'type' => $this->data['type'],
                            'date' => date("Y-m-d H:i:s"),
                            'active' => 1,
                        );
                    }
                }
                $this->Image->saveMany($data, array('deep' => true));
                $this->Session->setFlash("Gelukt.", 'flash_success');
                return $this->redirect(array('controller' => 'admin', 'action' => 'images'));
            }
        } else {
            $this->Session->setFlash("Geen foto's geselecteerd.", 'flash_fail');
            return $this->redirect(array('controller' => 'admin', 'action' => 'images'));
        }

        $this->set('images', $this->Image->find('all', array(
                    'order' => array('Image.date DESC'),
        )));
        $this->set('hasDataTabless', true);
        $this->render('Images/images');
    }

}

?>