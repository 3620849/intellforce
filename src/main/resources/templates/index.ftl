<!DOCTYPE html>
<html lang="en" ng-app="mainApp">
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap core CSS -->
    <link href="lib/bootstrap-4.0.0-beta/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body ng-controller="AppCtrl">
 <div class="row" ng-view></div>
</body>
<script type="text/javascript" src="lib/angular.js"></script>
<script type="text/javascript" src="lib/angular-route.min.js"></script>
<script type="text/javascript" src="common/main/main.js"></script>
<script src="lib/jquery-3.2.1.slim.js"</script>
<script src="lib/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
<script src="lib/bootstrap-4.0.0-beta/assets/js/vendor/popper.min.js"></script>
<script src="lib/bootstrap-4.0.0-beta/dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="lib/bootstrap-4.0.0-beta/assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="common/registerPage/js/LoginFormCtrl.js"></script>
<script src="common/registerPage/js/LoginService.js"></script>
<script src="common/survey/js/SurveyService.js"></script>
<script src="common/registerPage/js/RegisterFormCtrl.js"></script>
<script src="common/survey/js/SurveyFormCtrl.js"></script>
<script src="common/score/js/ScoreCtrl.js"></script>
<script src="common/score/js/ScoreService.js"></script>
</html>