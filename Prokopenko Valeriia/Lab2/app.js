angular.module("defaultApp", [])

.controller("defaultCtrl", function ($scope) {

    var control = document.getElementById("chooseFile");
    control.addEventListener("change", function (event) {     
        files = control.files;

            for (var i = 0; i < files.length; i++) {

            var reader = new FileReader();
            reader.onload = function (event) {               
                var contents = event.target.result;
                console.log(contents);
            };

            reader.onerror = function (event) {
                console.log("Cannot read file! Code:  " + event.target.error.code);
            };
            reader.readAsText(files[0]);
        }
    }, false);
})