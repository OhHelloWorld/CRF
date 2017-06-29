import angular from 'angular';

angular.module('createHospital', [])
  .controller('createHospitalController', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
    $scope.image ='src/lib/images/hospital1.jpg';
  }]);