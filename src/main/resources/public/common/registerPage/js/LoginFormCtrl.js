angular.module("mainApp").controller('LoginFormCtrl',function($scope,$rootScope,$location,loginService){
    $scope.loginUser = function(user){
        $rootScope.user.username =  user.username;
        $rootScope.user.logindata = user.username+":"+user.password
        $location.path('/survey');
    }
    $scope.getRegisterForm = function(){

        $location.path('/register');
    }
});