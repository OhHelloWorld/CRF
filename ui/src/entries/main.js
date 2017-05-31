'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
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

var main = angular.module('main', [uiRouter, 'home', 'fourDiagnostic', 'patientInfo', 'phyAChe','tonguePulse']);

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

main.controller('mainController', ['$scope', '$http', function($scope, $http) {



}]);
