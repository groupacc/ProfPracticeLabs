//function handleFile(event) {
//    var control = document.getElementById("chooseFile");
//    control.addEventListener("change", function (event) {
//        files = control.files;

//        //var files = event.target.files;
//        for (var i = 0; i < files.length; i++) {

//            var reader = new FileReader();
//            reader.onload = function (event) {
//                var contents = event.target.result;
//                console.log(contents);
//                //var contents = document.createElement("div");
//                //contents.innerHTML = event.target.result;
//                //document.getElementById('out').insertBefore(contents, null);
//            };

//            reader.onerror = function (event) {
//                console.log("Cannot read file! Code:  " + event.target.error.code);
//            };
//            reader.readAsText(files[0]);
//        }
//    })

//    document.addEventListener('DOMContentLoaded', function () {
//        document.getElementById("chooseFile").addEventListener("click", handleFile, false);
//    })
//}

var contents;
var arrayString = new Array();
var array = new Array();

window.onload = (function handleFile() {

    var control = document.getElementById("chooseFile");
    control.addEventListener("change", function (event) {
        files = control.files;

        for (var i = 0; i < files.length; i++) {

            var reader = new FileReader();
            reader.onload = function (event) {
                contents = event.target.result;
                console.log(contents);
            };

            reader.onerror = function (event) {
                console.log("Cannot read file! Code:  " + event.target.error.code);
            };
            reader.readAsText(files[0]);
        }
    }, false);
});

function processText() {
    while (contents.indexOf("\n") > -1) {
    String(contents).trim();
    while (contents.indexOf("  ") > -1) {
        contents = contents.replace("  ", " ").replace("-", " ");
    }

   
        contents = String(contents).trim().split(" ", 8);
        if (String(contents).match("^[0-9]{1,3}") | String(contents).match("^[0-9]{1,2}.")) {
            array.push(contents);
        }
    
        }
    console.log(contents);
    for (var i = 0; i < arrayString.length; i++) {

        console.log(array[arrayString[i]]);
    }

}





