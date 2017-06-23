'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../lib/css/css/alt/AdminLTE-select2.min.css';

import '../lib/css/js/app.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import '../../node_modules/bootstrap/js/modal.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../modules/home.js';
import '../modules/fourDiagnostic.js';
import '../modules/patientInfo.js';
import '../modules/phyAChe.js';
import '../modules/tonguePulse.js';

var main = angular.module('main', [uiRouter, 'home', 'fourDiagnostic', 'patientInfo', 'phyAChe', 'tonguePulse']);

main.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.when('', '/home');

  $stateProvider.state('patientInfo', {
    url: '/patientInfo',
    template: require('../templates/patientInfo.html'),
  })
    .state('home', {
      url: '/home',
      template: require('../templates/home.html')
    })
    .state('fourDiagnostic', {
      url: '/fourDiagnostic',
      template: require('../templates/fourDiagnostic.html')
    })
    .state('phyAChe', {
      url: '/phyAChe',
      template: require('../templates/phyAChe.html')
    })
    .state('tonguePulse', {
      url: '/tonguePulse',
      template: require('../templates/tonguePulse.html')
    });

}]);

main.controller('mainController', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {

  $scope.projects = ['project1', 'project2', 'project3'];

  $scope.homeClick = function() {
    $('li').removeClass('active');
    $('#li1').addClass('active');
  };

  $scope.patientMenuClick = function() {
    $('li').removeClass('active');
    $('#li2').addClass('active');
    changeStatus();
  };

  $scope.changeMenuStatus = function() {
    changeStatus();
  };

  $scope.fourClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_four').popover('toggle');
      setTimeout(function() {
        $('#a_four').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li3').addClass('active');
      $state.go('fourDiagnostic');
    }
  };

  $scope.tongueClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_tongue').popover('toggle');
      setTimeout(function() {
        $('#a_tongue').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li4').addClass('active');
      $state.go('tonguePulse');
    }
  };

  $scope.phyClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_phy').popover('toggle');
      setTimeout(function() {
        $('#a_phy').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li5').addClass('active');
      $state.go('phyAChe');
    }
  };

  function changeStatus() {
    if (sessionStorage.getItem('patientId')) {
      $http({
        method: 'GET',
        url: '/api/fourDiagnosticInfor/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#fourMenuNo').addClass('hide');
          $('#fourMenuYes').removeClass('hide');
        } else {
          $('#fourMenuYes').addClass('hide');
          $('#fourMenuNo').removeClass('hide');
        }
      });

      $http({
        method: 'GET',
        url: '/api/tonguePulse/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#tongueMenuYes').removeClass('hide');
          $('#tongueMenuNo').addClass('hide');
        } else {
          $('#tongueMenuNo').removeClass('hide');
          $('#tongueMenuYes').addClass('hide');
        }
      });

      $http({
        method: 'GET',
        url: '/api/physical/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#phyMenuYes').removeClass('hide');
          $('#phyMenuNo').addClass('hide');
        } else {
          $('#phyMenuNo').removeClass('hide');
          $('#phyMenuYes').addClass('hide');
        }
      });
    }
  }

}]);
