var dockerApp = angular.module('dockerApp', ['ngAnimate']);

dockerApp.controller('dockerController', function ($scope, $http) {

    var urlBase = "";
    $http.defaults.headers.post["Content-Type"] = "application/json";

    //add a new task
    $scope.doDockerize = function doDockerize() {
        $http.post(urlBase + '/dockerize', JSON.stringify({
            "repoName": $scope.repoName, "branch": $scope.branch})
           ).success(function (data, status, headers) {
            console.log("Task Submittes............. ");
        });

    }


});