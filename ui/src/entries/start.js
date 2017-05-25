'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';


import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../modules/noStep.js';
var main = angular.module('main', [uiRouter, 'noStep']);

main.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.when('', '/noStep');

  $stateProvider.state('firstStep', {
    url: '/firstStep',
    template: require('../templates/firstStep.html'),
    controller: 'firstStepController'
  })
    .state('noStep', {
      url: '/noStep',
      template: require('../templates/noStep.html')
    });
}]);

main.controller('mainController', ['$scope', '$http', function($scope, $http) {



}]);