angular.module('mainApp').factory('loginService',function($http,$rootScope){

    var fact ={

        login: function (user) {
                    $rootScope.user.logindata = user;
                    $rootScope.$broadcast('userLogin:updated');
        },
        register: function (user) {
            $http.post("/register/addUser", user)
                .then(function (data, status, headers, config) {
                }, function (error) {
                    console.log(error.data)
                })
        }
    }
    return fact;
});