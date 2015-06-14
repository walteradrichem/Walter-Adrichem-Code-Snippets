<div class="alert alert-danger">
    <b>Field and relation changes have been made!      <a href="javascript:void(0);" onclick="confirmDel(1, 1);" class="btn btn-danger">
            <i class="fa fa-exclamation"></i>
            Regenerate Website
        </a></b>
</div>
<table class="table table-responsive table-bordered table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>created</th>
            <th>modified</th>
            <th>Message</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <?php foreach ($data as $dat) { ?>
            <tr id="row_<?= $dat['PostType']['id'] ?>">
                <td><?= $dat['PostType']['singular_name'] ?></td>
                <td><?= $dat['PostType']['type'] ?></td>
                <td><?= $dat['PostType']['created'] ?></td>
                <td><?= $dat['PostType']['modified'] ?></td>        
                <td>
                    <?php if ($dat['PostType']['changes_made'] == 1 && $dat['PostType']['generated'] == 1) { ?>
                        <label href="<?= $this->webroot ?>posttype/edit/<?= $dat['PostType']['id'] ?>" class="label label-lg label-danger">
                            <i class="fa fa-exclamation"></i>
                            Changes made 
                        </label>   <?php } else { ?> <label href="<?= $this->webroot ?>posttype/edit/<?= $dat['PostType']['id'] ?>" class="label label-lg label-success">
                            <i class="fa fa-thumbs-o-up"></i>
                            Nothing to report 
                        </label>  <?php } ?>  </td>

                <td>
                    <a href="<?= $this->webroot ?>posttype/edit/<?= $dat['PostType']['id'] ?>" class="btn btn-info">
                        Edit
                    </a>
                </td>
                <td>
                    <a href="javascript:void(0);" class="btn btn-danger" onclick="confirmDel(<?= $dat['PostType']['id'] ?>, 0);">
                        Delete
                    </a>
                </td>
            </tr>
        <?php } ?>
    </tbody>
</table>
<script>
    var id;
    var posttype;
    function confirmDel(delId, type) {
        if (type == 1) {
            posttype = 'generate';
            $('#modal').modal('show');
        } else {
            posttype = 'delete';
            $('#modal_del').modal('show');
        }
        id = delId;
    }
    function postAction() {
        if (posttype == 'delete') {
            $.ajax({
                type: "POST",
                url: '<?= $this->webroot ?>PostType/delete/' + id,
                success: function () {
                    $('#row_' + id).toggle();
                    $('#modal_del').modal('hide');
                    location.reload();
                }
            });
        } else {
            $.ajax({
                type: "POST",
                url: '<?= $this->webroot ?>PostType/generate/' + id,
                success: function () {
                    $('#modal').modal('hide');
                    location.reload();
                }
            });
        }

    }
</script>
<div class="modal fade" id="modal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal">Confirm Website generation</h4>
            </div>
            <div class="modal-body">
                Are you sure? Because structure and field changes have been made all of your data will be deleted in the proces!!
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" onclick="postAction();">Confirm Generation</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="modal_del" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal">Confirm</h4>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" onclick="postAction();">Confirm</button>
            </div>
        </div>
    </div>
</div>
