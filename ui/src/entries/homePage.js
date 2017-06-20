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

import '../modules/project.js';
import '../modules/default.js';
import '../modules/invite.js';
import '../modules/projectSetting.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';

var homePage = angular.module('homePage', [uiRouter, 'default', 'project', 'invite', 'projectSetting']);

homePage.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.when('', '/default');

  $stateProvider.state('default', {
    url: '/default',
    template: require('../templates/default.html'),
    controller: 'defaultController'
  })
  .state('project', {
    url: '/project',
    template: require('../templates/project.html'),
    controller: 'projectController'
  })
  .state('project.projectDefault', {
    url: '/projetDefault',
    template: require('../templates/project/projectDefault.html'),
    controller: 'projectDefaultController'
  })
  .state('project.projectCase', {
    url: '/projectCase',
    template: require('../templates/project/caseIllness.html'),
    controller: 'projectCaseController'
  })
  .state('invite',{
    url:'/invite',
    template:require('../templates/invite.html'),
    controller: 'inviteController'
  })
  .state('projectSetting',{
    url:'/projectSetting',
    template:require('../templates/projectSetting.html'),
    controller: 'projectSettingController'
  });


}]);

homePage.controller('homePageController', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {

  var project1 = {
    name: '测试项目'
  };
  var project2 = {
    name: '测试项目2'
  };
  var project3 = {
    name: '测试项目3' 
  }; 

  $scope.projects = [project1, project2, project3];
  sessionStorage.setItem('permission',['邀请联合发起人','邀请分中心研究者','邀请录入员']);

}]);