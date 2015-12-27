angular.module("calculatorApp", [])

.controller("defaultCtrl", function ($scope) {

    $scope.sum = 0;
    $scope.string = "[***]\\\c:\n1,5&* ***9|1<>";

    $scope.addString = function (string) {

        if (string == "") {
            string = 0;
        }
        else {
            string = string.match(/\d/g);
        }

        for (var i = 0; i < string.length; i++) {
            $scope.sum = $scope.sum + +string[i];
        }

        return $scope.sum;
    }
})