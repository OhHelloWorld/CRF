import angular from 'angular';

angular.module('tonguePulse', [])
  .controller('tonguePulseController', ['$scope', '$http', function($scope, $http) {
    $scope.tongueShowClick = function() {
      if ($scope.cb10) {
        $scope.tongueShow = true;
      } else {
        $scope.tongueShow = false;
      }
    };
    $scope.mossyShowClick = function() {
      if ($scope.cb33) {
        $scope.mossyShow = true;
      } else {
        $scope.mossyShow = false;
      }
    };
    $scope.tongueColorShowClick = function() {
      if ($scope.cb40) {
        $scope.tongueColorShow = true;
      } else {
        $scope.tongueColorShow = false;
      }
    };
  }]);