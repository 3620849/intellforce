angular.module("mainApp").controller('RegisterFormCtrl',function($scope,$rootScope,$location,loginService){
$scope.registerUser = function(user){
    loginService.register(user);
    $rootScope.user.username =  user.username;
    $rootScope.user.logindata = user.username+":"+user.password
    $location.path('/survey');
}
});