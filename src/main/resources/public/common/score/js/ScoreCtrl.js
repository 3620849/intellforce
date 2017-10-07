angular.module("mainApp").controller('ScoreCtrl',function($scope,$rootScope,scoreService){
    (function() {
        scoreService.getScore();
    })();
    $rootScope.$on('score:updated', function(){
        $scope.score = scoreService.score;
    });
});