'use strict';

var singleUploadForm        = document.querySelector('#singleUploadForm');
var singleFileUploadInput   = document.querySelector('#singleFileUploadInput');
var singleFileUploadError   = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');

function getCookie(cname) {
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function uploadSingleFile(file) {

    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/uploadFile");

    xhr.setRequestHeader('X-XSRF-TOKEN', getCookie('XSRF-TOKEN'));

    xhr.onload = function() {

        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {

            singleFileUploadError.style.display   = "none";
            singleFileUploadSuccess.innerHTML     = "<p class='text-success'>Plik wgrany prawidłowo i oczekuje teraz na weryfikacje</p><p>pobierz : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response.message) || "wystąpił błąd";
        }
    }

    xhr.send(formData);
}

singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);