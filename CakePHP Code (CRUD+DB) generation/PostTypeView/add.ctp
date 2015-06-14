<div class="row">
    <div class="col-md-12">
        <h2>General information</h2><hr/>
            <div class="alert alert-danger">
            <b>Fields can be added when the general information and options are posted. </b>
        </div>
        <?php echo $this->Form->create('PostType'); ?>
        <?php echo $this->Form->input('singular_name'); ?>
    
        <?php echo $this->Form->input('plural_name'); ?>
        <?php echo $this->Form->input('type'); ?>
        <label>Description</label>
        <?php  echo $this->Form->textarea('description'); ?>
           <h2>Options</h2><hr/>
               <h4>Author Rights</h4> 
        <select class="form-control">
            <option value="">Read</option>
            <option value="">Read and Edit</option>
            <option value="">Create, Read, and Edit</option>
            <option value="">Create, Read, Edit, Delete</option>
        </select>
       <div class="form-group"><input  class="btn btn-success" type="submit" value="Save and add fields"/>
    </div>
</div>