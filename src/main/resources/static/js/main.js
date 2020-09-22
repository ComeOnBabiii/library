$(document).ready(function(){

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemove .dBtn").attr('href',href);
    });

});
