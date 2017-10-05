var app = angular.module("mainApp", ['ngRoute']);
app.controller("AppCtrl", function ($scope, $rootScope) {
    $rootScope.user = {};
});
app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'common/survey/SurveyForm.html',
            controller: 'SurveyFormCtrl'
        })
        .when('/login', {
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
        .otherwise({ redirectTo: '/login' });
});