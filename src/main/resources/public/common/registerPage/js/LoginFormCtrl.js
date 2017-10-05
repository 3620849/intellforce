angular.module("mainApp").controller("LoginFormCtrl",function($scope,loginService){
    $scope.loginUser = function(user){
        loginService.login(user);
    }
})