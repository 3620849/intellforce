var app = angular.module("mainApp", ['ngRoute']);
app.controller("AppCtrl", function ($scope, $rootScope) {
    $rootScope.user = {};
});
app.config(function ($routeProvider) {
    $routeProvider
        .when('/survey', {
            templateUrl: 'common/survey/SurveyForm.html',
            controller: 'SurveyFormCtrl'
        })
        .when('/', {
            templateUrl: 'common/registerPage/LoginForm.html',
            controller: 'LoginFormCtrl'
        })
        .when('/register', {
            templateUrl: 'common/registerPage/RegisterForm.html',
            controller: 'RegisterFormCtrl'
        })
        .when('/score', {
            templateUrl: 'common/score/Score.html',
            controller: 'ScoreCtrl'
        })
        .when('/accessDenied', {
            templateUrl: 'common/main/accessDeniedPage.html'
        })
        .otherwise({ redirectTo: '/' });
});
    /*.run(['$rootScope', '$location', '$http',
    function ($rootScope, $location) {
        $rootScope.$on('$locationChangeStart', function (event, next, current) {

                $location.path('/login');

        });
    }]);*/