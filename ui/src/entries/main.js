'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';


import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../modules/home.js';
var main = angular.module('main', [uiRouter, 'home']);

main.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.when('', '/');

  $stateProvider.state('patientInfo', {
    url: '/patientInfo',
    template: require('../templates/patientInfo.html'),
  })
    .state('home', {
      url: '/home',
      template: require('../templates/home.html')
    });
}]);

main.controller('mainController', ['$scope', '$http', function($scope, $http) {



}]);
