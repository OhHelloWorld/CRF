'use strict';

import angular from 'angular';
import uiBootstrap from 'angular-ui-bootstrap';
import '../commons/page.js';
import '../entries/main.js';

var home = angular.module('home', [uiBootstrap, 'page', 'main']);

home.controller('homeController', ['$scope', '$http', '$rootScope', '$state', 'localStorageService', function($scope, $http, $rootScope, $state, localStorageService) {
  loginStatus();
  $scope.url = '/api/patient/project/1';
  $scope.changeMenuStatus();
  $scope.patientClick = function(patient) {
    sessionStorage.setItem('patientId', patient.id);
    $scope.patientMenuClick();
    location.reload('true');
    $state.go('patientInfo');
  };

  $scope.query = function() {
    $scope.url = '/api/patient/1/q?queryStr=' + $scope.queryStr;
  };

  $scope.all = function() {
    $scope.url = '/api/patient/project/1';
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

  $scope.createExcel = function() {
    $scope.information = '正在导出，请稍候...';
    $scope.buttonShow = false;
    $('#infoModal').modal({
      keyboard: true
    });
    $http({
      method: 'POST',
      url: '/api/excel'
    }).then(function success() {
      $('#infoModal').modal('hide');
      $scope.information = '导出成功';
      $scope.buttonShow = true;
      $scope.buttonContent = '确认';
      $('#infoModal').modal({
        keyboard: true
      });
      // var excelUrl = 'http://sggb.navyblue.cn/excelDown/' + localStorageService.get('user').realName + 'patientInformation.xlsx';
      var excelUrl = 'localhost:8080/excelDown/' + localStorageService.get('user').realName + 'patientInformation.xlsx';
      console.log(excelUrl);
      window.open(excelUrl);
    }, function fail() {
      $('#infoModal').modal('hide');
      $scope.information = '导出出错，请稍候再试';
      $scope.buttonShow = true;
      $scope.buttonContent = '确认';
      $('#infoModal').modal({
        keyboard: true
      });
    });
  };

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }
}]);