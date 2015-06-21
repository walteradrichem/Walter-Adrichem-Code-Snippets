function addRedditText(url,CSRF_TOKEN){
    $.ajax({
        url: 'redditText',
        type: 'POST',
        data: {_token: CSRF_TOKEN, url: url},
        dataType: 'JSON',
        error : function(data){
           $('#content').prepend('<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12"><div class="panel panel-default"><div class="panel-heading"><h3>'+url+'</h3></div><div class="panel-body">'+data['responseText']+'</div></div></div>');
        }
    });
}
function addRedditImages(url,CSRF_TOKEN){
    $.ajax({
        url: 'redditImages',
        type: 'POST',
        data: {_token: CSRF_TOKEN, url: url},
        dataType: 'JSON',
        error : function(data){
            $('#content').prepend('<div class="col-lg-6 col-md-8 col-sm-12 col-xs-12"><div class="panel panel-default"><div class="panel-heading"><h3>'+url+'</h3></div><div class="panel-body">'+data['responseText']+'</div></div></div>');
        }
    });
}


$( "#addReddit" ).click(function() {

    $('#loader').fadeIn('fast');
    var CSRF_TOKEN = $('meta[name="csrf-token"]').attr('content');
    var url = $('#url').val();
    var viewType = $('#type').val();

    if(viewType == 'text'){
        addRedditText(url,CSRF_TOKEN);
    }else{
        addRedditImages(url,CSRF_TOKEN);
    }
    $('#loader').fadeOut('slow');

});