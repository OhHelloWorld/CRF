'use strict';

import angular from 'angular';
import uiBootstrap from 'angular-ui-bootstrap';
import '../commons/page.js';

var home = angular.module('home', [uiBootstrap, 'page']);

home.controller('homeController', ['$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {
  $scope.url = '/api/patient';

  $scope.patientClick = function(patient) {
    $rootScope.patientId = patient.id;
    window.location.href = 'http://localhost:9000/main.html#!/patientInfo?' + patient.id;
  };

  $scope.query = function(){
    $scope.url='/api/patient/q?queryStr='+$scope.queryStr;
  };
}]);