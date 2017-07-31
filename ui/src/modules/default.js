import angular from 'angular';

angular.module('default', [])
  .controller('defaultController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    loginStatus();

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }
  }]);