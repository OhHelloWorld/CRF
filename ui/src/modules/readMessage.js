import angular from 'angular';

angular.module('readMessage', [])
  .controller('readMessageController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
  
    $scope.readMessage = localStorageService.get('message');


  }]);