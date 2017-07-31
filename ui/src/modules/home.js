'use strict';

import angular from 'angular';
import uiBootstrap from 'angular-ui-bootstrap';
import '../commons/page.js';
import '../entries/main.js';

var home = angular.module('home', [uiBootstrap, 'page', 'main']);

home.controller('homeController', ['$scope', '$http', '$rootScope', '$state', 'localStorageService', function($scope, $http, $rootScope, $state, localStorageService) {
  loginStatus();
  $scope.url = '/api/patient';
  $scope.changeMenuStatus();
  $scope.patientClick = function(patient) {
    sessionStorage.setItem('patientId', patient.id);
    $scope.patientMenuClick();
    location.reload('true');
    $state.go('patientInfo');
  };

  $scope.query = function() {
    $scope.url = '/api/patient/q?queryStr=' + $scope.queryStr;
  };

  $scope.all = function() {
    $scope.url = '/api/patient';
  };

  $scope.addPatient = function() {
    sessionStorage.removeItem('patientId');
    $('#fourMenuYes').hide();
    $('#fourMenuNo').hide();
    $('#tongueMenuYes').hide();
    $('#tongueMenuNo').hide();
    $('#phyMenuYes').hide();
    $('#phyMenuNo').hide();
    $('#liverMenuYes').hide();
    $('#liverMenuNo').hide();
    $('#boneMenuYes').hide();
    $('#boneMenuNo').hide();
    $('#simAIHMenuYes').hide();
    $('#simAIHMenuNo').hide();
    $('#comAIHMenuYes').hide();
    $('#comAIHMenuNo').hide();
    $('#treatMenuYes').hide();
    $('#treatMenuNo').hide();
    $('#finalDiagnosisMenuYes').hide();
    $('#finalDiagnosisMenuNo').hide();
    $state.go('patientInfo');
  };

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }
}]);