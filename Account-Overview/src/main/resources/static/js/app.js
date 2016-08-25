var accountsApp = angular.module('accountsApp', []);
accountsApp.controller('accountsController', function ($scope,$http) {
 $http.defaults.headers.post["Content-Type"] = "application/json";
 $http.defaults.headers.put = {
         'Access-Control-Allow-Origin': '*',
         'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
         'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
         };
         $scope.paymentaccounts = [];
         $scope.savingsaccounts = [];
    function findAllPaymentAccounts() {
        $http.get('http://localhost:32502/payments').
            success(function (data) {
                 $scope.paymentaccounts =  data;
                 console.log ("$scope.paymentaccounts " + $scope.paymentaccounts);
            });
    };
    function findAllSavingsAccounts() {
            $http.get('http://localhost:32503/savings').
                success(function (data) {
                     $scope.savingsaccounts =  data;
                     console.log ("$scope.savingsaccounts " + $scope.savingsaccounts);
                });
        };
    findAllPaymentAccounts();
    findAllSavingsAccounts();
    });