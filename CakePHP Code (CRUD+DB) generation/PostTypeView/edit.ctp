<div class="row">
    <div class="col-md-6">
            <a href="<?=$this->webroot?>relations" class="btn btn-block btn-success">Manage relations</a>
    </div>
    <div class="col-md-6">
            <a href="<?=$this->webroot?>posttypefield/all/<?=$this->data['PostType']['id']?>" class="btn btn-block btn-info">Manage fields</a>
    </div>
</div><hr/>
<div class="row">
    <div class="col-sm-12">
    
<?php echo $this->Form->create('PostType');?>
<?php echo $this->Form->input('singular_name');?>
<?php echo $this->Form->input('plural_name');?>
<?php echo $this->Form->input('type');?>
<?php echo $this->Form->input('description');?>
<?php echo $this->Form->end();?>



    </div>
    </div>
