var dockerApp = angular.module('dockerApp', ['ngAnimate']);

dockerApp.controller('dockerController', function ($scope, $http) {

    var urlBase = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";
    $scope.requestSuccess = 0;

    //add a new task
    $scope.doDockerize = function doDockerize() {
     $scope.requestSuccess = 0;
        $http.post(urlBase + '/dockerize', JSON.stringify({
            "repoName": $scope.repoName, "branch": $scope.branch})
           ).success(function (data, status, headers) {
            console.log("Task Submitted............. ");
            $scope.requestSuccess = 1;
        });

    }


});