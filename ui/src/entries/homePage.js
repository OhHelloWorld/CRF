'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../lib/css/js/app.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import ngFileUpload from 'ng-file-upload';


import '../modules/project.js';
import '../modules/default.js';
import '../modules/invite.js';
import '../modules/projectSetting.js';
import '../modules/message.js';
import '../modules/create_hospital.js';
import '../modules/update_hospital.js';
import '../modules/hospital.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';
import LocalStorageModule from 'angular-local-storage';

var homePage = angular.module('homePage', [uiRouter, LocalStorageModule, ngFileUpload, 'default', 'project', 'invite', 'projectSetting', 'message', 'createHospital', 'updateHospital', 'hospital']);

homePage.config(['$stateProvider', '$urlRouterProvider', 'localStorageServiceProvider', function($stateProvider, $urlRouterProvider, localStorageServiceProvider) {

  $urlRouterProvider.when('', '/default');

  $stateProvider.state('default', {
    url: '/default',
    template: require('../templates/default.html'),
    controller: 'defaultController'
  })
  .state('message',{
    url:'/message',
    template:require('../templates/message.html'),
    controller: 'messageController'
  })
  .state('createHospital',{
    url:'/createHospital',
    template:require('../templates/create_hospital.html'),
    controller: 'createHospitalController'
  })
  .state('updateHospital',{
    url:'/updateHospital',
    template:require('../templates/update_hospital.html'),
    controller: 'updateHospitalController'
  }) 
  .state('hospital',{
    url:'/hospital',
    template:require('../templates/hospital.html'),
    controller: 'hospitalController'
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
    params: {'project_searchInput' : null},
    template: require('../templates/project/caseIllness.html'),
    controller: 'projectCaseController'
  })
  .state('project.hospitalDefault', {
    url: '/hospitalDefault',
    template: require('../templates/project/hospitalDefault.html'),
    controller: 'hospitalDefaultController'
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
  })
  .state('inviteUsers',{
    url:'/inviteUsers',
    template:require('../templates/userList.html'),
    controller: 'inviteController'
  });

  localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);


}]);

homePage.controller('homePageController', ['$scope', '$http', '$rootScope', '$state', 'localStorageService', function($scope, $http, $rootScope, $state, localStorageService) {
  
  sysPermission();
  getProjectList();
  
  $scope.projects = [];
  $scope.invitePermissions = [];
  $scope.digustPermissions = [];
  $scope.settingPermissions = [];
  

  /**
  *对每个项目下的权限进行判断，（邀请，调整项目表，项目设置）
  */
  function projectListPermission(){
    angular.forEach($scope.projects, function(data, index){
      if(data.currentUserPermissionInProject.contains('邀请')){
        $scope.invitePermissions[index] = true;
      }else{
        $scope.invitePermissions[index] = false;
      }
      if(data.currentUserPermissionInProject.contains('编辑项目相关内容')){
        $scope.digustPermissions[index] = true;
      }else{
        $scope.digustPermissions[index] = false;
      }
      if(data.currentUserPermissionInProject.contains('项目设置')){
        $scope.settingPermissions[index] = true;
      }else{
        $scope.settingPermissions[index] = false;
      }
    });

  } 


  /**
  *对系统的的权限进行判断，（普通用户，管理员）
  */
  function sysPermission(){
    angular.forEach(localStorageService.get('sysPermissions'), function(data){
      if(data.sysPermissionName === '医院信息'){
        $scope.hospitalPermission = true;
      }
    });

  }  

  

  /**
   *设置该账户当前点击的项目，并将该账户在该项目下的权限也保存在project对象里
   */
  $scope.click_project = function(project){
    localStorageService.set('project', project);
  }

  /**
   *左侧栏对项目进行搜索
   */
  $scope.search_project = function(){

    $http({
      method: 'GET',
      url: '/search_projectName'
    }).then(function successCallback(response){
      $scope.projects = response.data;
      projectListPermission();
    }, function failCallback(response){
      
    });

  }

  /**
  *对是否登录进入首页进行判断，（未登录跳回登陆页面）
  */
  function loginStatus(){
    if(!localStorageService.get('user')){
      window.location.href = '/login.html';
    }
  }   

  /**
  *请求得到该用户的所有项目
  */
  function getProjectList(){
    $http({
      method: 'GET',
      url: '/api/projects'
    }).then(function successCallback(response){
      $scope.projects = response.data;
      console.log(response.data);
      getProjectPermission();
    }, function failCallback(response){
      
    });
  }   


  /**
  *过滤用户每个项目下的权限
  */  
  function getProjectPermission(){    
    angular.forEach($scope.projects, function(data){
      var projectPermissionName = [];
      angular.forEach(data.currentUserPermissionInProject, function(permission_data){
        projectPermissionName.push(permission_data.projectPermissionName);
      });
      data.currentUserPermissionInProject = projectPermissionName;
    });
    projectListPermission();
  }   


}]);

Array.prototype.contains = function(obj) {
  var i = this.length;
  while (i--) {
    if (this[i] === obj) {
      return true;
    }
  }
  return false;
};





