if (window.location.hash == '#_=_') {
  history.replaceState? history.replaceState(null, null, window.location.href.split('#')[0]) : window.location.hash = '';
}

var searchUserVal = document.querySelector('#searchVal');

$.get( "/user", function(data) {
    $("#user").html(data.userAuthentication.details.name);
        $(".unauthenticated").hide()
        $(".authenticated").show()
    })
    .done(function() {
    })
    .fail(function() {
    })
    .always(function() {
});

var logout = function() {
    $.post("/logout", function() {
      $("#user").html('');
      $(".unauthenticated").show();
      $(".authenticated").hide();
    })
     .done(function() {
       window.location.href = "https://knowj.javaleader.pl";
     })
     .fail(function(xhr, status, error) {
       alert(xhr.responseText);
     })
     .always(function() {
       alert( "finished" );
     });
}

var search = function() {
 $.get("/search?searchUserVal="+searchUserVal.value, function(data) {
    })
    .done(function(data) {
        $("#search").load("/search?searchUserVal="+searchUserVal.value);
          $('html, body').animate({
                    scrollTop: $("#search").offset().top
                }, 2000);
    })
   .fail(function(xhr, status, error) {
       alert(xhr.responseText);
     })
   .always(function() {
    });
}

$.ajaxSetup({
    beforeSend : function(xhr, settings) {
      if (settings.type == 'POST' || settings.type == 'PUT'
          || settings.type == 'DELETE') {
        if (!(/^http:.*/.test(settings.url) || /^https:.*/
            .test(settings.url))) {
          // Only send the token to relative URLs i.e. locally.
          xhr.setRequestHeader("X-XSRF-TOKEN",
              Cookies.get('XSRF-TOKEN'));
        }
      }
    }
});

searchForm.addEventListener('submit', function(event){
    event.preventDefault();
}, true);