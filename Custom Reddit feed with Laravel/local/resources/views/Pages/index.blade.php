@extends('default')

@section('content')
<div class="panel panel-default">
   <div class="panel-heading">Add reddit</div>
   <div class="panel-body">
    <label>Subreddit name</label>
        <input type="text" class="form-control" id="url" value="funny">
        <label>View Type</label>
        <select id="type" class="form-control">
        <option value="text">Titles</option>
        <option value="images">Titles and Images</option>
        </select>
            <a href="javascript:void(0);" id="addReddit" class="btn btn-success">
            Toevoegen
            </a>
        <div id="loader" style="width: 100px; display: none; margin: 0 auto;">
        <img src="<?=URL::to('/');?>/assets/img/loader.gif" />
        </div>
   </div>
</div>
<meta name="csrf-token" content="{{{ csrf_token() }}}" />
<div class="row" id="content"></div>

@stop

@section('css')
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
@stop

@section('js')
<script> var WEBROOT = '<?=URL::to('/');?>'; </script>
 <script src="<?=URL::to('/');?>/assets/js/curlScript.js"></script>
@stop
