'use strict';

var singleUploadForm        = document.querySelector('#singleUploadForm');
var singleFileUploadInput   = document.querySelector('#singleFileUploadInput');
var singleFileUploadError   = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');

function uploadSingleFile(file) {

    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();

    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {

        var response = JSON.parse(xhr.responseText);
        if(xhr.status == 200) {

            singleFileUploadError.style.display   = "none";
            singleFileUploadSuccess.innerHTML     = "<p>File uploaded successfully.</p><p>download : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
            singleFileUploadSuccess.style.display = "block";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response.message) || "an error occurred";
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