'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../lib/css/js/app.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import '../../node_modules/bootstrap/js/modal.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';

var hospitalDetail = angular.module('hospitalDetail', [uiRouter]);

hospitalDetail.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.when('', '/hospitalDetailDefault');

  $stateProvider.state('hospitalDetailDefault', {
    url: '/hospitalDetailDefault',
    template: require('../templates/hospitalDetailDefault.html')
  });


}]);

hospitalDetail.controller('hospitalDetailController', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {


}]);
