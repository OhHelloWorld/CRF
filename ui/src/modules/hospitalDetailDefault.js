'use strict';

import angular from 'angular';

var hospitalDetail = angular.module('hospitalDetail', []);

hospitalDetail.controller('hospitalDetailController', ['$scope', 'localStorageService', function($scope, localStorageService) {
  loginStatus();

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }
}]);