angular.module("mainApp").controller('SurveyFormCtrl', function ($scope, $rootScope, $location, surveyService) {
    $scope.answer = {"questionId": 1};

    $scope.next = function () {
        if ($scope.answer.questionId < 5) {
            surveyService.sendAnswer($scope.answer);
            surveyService.getQuestion($scope.answer.questionId+1);
        }
        else {
            surveyService.sendAnswer($scope.answer);
            $location.path('/score');
        }
    };
    $scope.back = function () {
        if ($scope.answer.questionId > 1) {
            surveyService.getQuestion($scope.answer.questionId - 1);
            $scope.answer.questionId -= 1
        } else {
            $location.path('/login');
        }
    };
    (function () {
        surveyService.getQuestion($scope.answer.questionId);
    })();
    $rootScope.$on('question:updated', function () {
        $scope.questionQ = surveyService.question;
        $scope.answer.questionId = $scope.questionQ.id;

    });

});