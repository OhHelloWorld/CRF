'use strict';

import angular from 'angular';
import uiBootstrap from 'angular-ui-bootstrap';
import '../commons/page.js';


var home = angular.module('home', [uiBootstrap]);

home.controller('homeController', ['$scope', '$http', function($scope, $http) {
  $scope.url = '/api/patient';
}]);
