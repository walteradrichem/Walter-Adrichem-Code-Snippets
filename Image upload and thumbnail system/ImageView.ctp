<div class="row">
    <div class="col-md-8">
        <blockquote class="specialBlock" >
            <h1>Gallerij <a href="javascript:void(0):" onclick="$('#addImage').toggle('fast');" class="btn btn-success">
                    <span class="glyphicon glyphicon-plus"></span> Toevoegen
                </a>
            </h1>
        </blockquote>
    </div>
</div>
<div class="row" id="addImage" style="display:none;">
    <div class="col-md-8">
        <?php
        echo $this->Form->create('Image', array('type' => 'file'));
        echo $this->Form->input('files.', array('type' => 'file', 'multiple'));
        echo $this->element('selectList');
        echo $this->Form->end('Upload');
        ?>
    </div>
</div>
<hr/>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"></h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-hover dataTable" style="background-color: white;">
                    <thead>
                        <tr>
                            <th>Titel</th>
                            <th>Datum</th>
                            <th>Openen</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php foreach ($images as $image) { ?>
                            <tr>
                                <td> <h4><?= $image['Image']['name'] ?></h4></td>
                                <td >  <?php echo date('d/m/Y', strtotime($image['Image']['date'])); ?></td>
                                <td><a class="btn btn-block btn-default" href="javascript:void(0);" onclick="showImage('<?= $image['Image']['name'] ?>');"><span class="glyphicon glyphicon-plus-sign"></span>Openen</a></td>
                            </tr>
                        <?php } ?>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>