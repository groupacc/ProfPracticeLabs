describe("Controller Test", function () {

    var mockScope = {};
    var controller;

    beforeEach(angular.mock.module("calculatorApp"));

    beforeEach(angular.mock.inject(function ($controller, $rootScope) {
        
        mockScope = $rootScope.$new();

        controller = $controller("defaultCtrl", {
            $scope: mockScope

        });

        mockScope.sum = 0; 
    }));

    it("Sum creation", function () {
        expect(mockScope.sum).toEqual(0);
    })

    it("Adding values", function () {
        mockScope.addString(mockScope.string);
        expect(mockScope.sum).toEqual(16); 
    });
})