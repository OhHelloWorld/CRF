'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../lib/css/js/app.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import '../lib/css/css/fullcalendar/fullcalendar.min.css';
import '../lib/css/css/fullcalendar/fullcalendar.print.css';
import '../lib/css/js/fullcalendar/fullcalendar.min.js';
import 'angular-base64';
import ngFileUpload from 'ng-file-upload';


import '../modules/project.js';
import '../modules/default.js';
import '../modules/invite.js';
import '../modules/projectSetting.js';
import '../modules/message.js';
import '../modules/create_hospital.js';
import '../modules/update_hospital.js';
import '../modules/hospital.js';
import '../modules/readMessage.js';
import '../modules/createProject.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';
import LocalStorageModule from 'angular-local-storage';

var homePage = angular.module('homePage', [uiRouter, LocalStorageModule, ngFileUpload, 'base64', 'default', 'project', 'invite', 'projectSetting', 'message', 'readMessage', 'createHospital', 'updateHospital', 'hospital', 'createProject']);

homePage.config(['$stateProvider', '$urlRouterProvider', 'localStorageServiceProvider', function($stateProvider, $urlRouterProvider, localStorageServiceProvider) {

  $urlRouterProvider.when('', '/default');

  $stateProvider.state('default', {
    url: '/default',
    template: require('../templates/default.html'),
    controller: 'defaultController'
  })
    .state('message', {
      url: '/message',
      template: require('../templates/message.html'),
      controller: 'messageController'
    })
    .state('readMessage', {
      url: '/readMessage',
      template: require('../templates/readMessage.html'),
      controller: 'readMessageController'
    })
    .state('createProject', {
      url: '/createProject',
      template: require('../templates/createProject.html'),
      controller: 'createProjectController'
    })
    .state('createHospital', {
      url: '/createHospital',
      template: require('../templates/create_hospital.html'),
      controller: 'createHospitalController'
    })
    .state('updateHospital', {
      url: '/updateHospital',
      template: require('../templates/update_hospital.html'),
      controller: 'updateHospitalController'
    })
    .state('hospital', {
      url: '/hospital',
      template: require('../templates/hospital.html'),
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
      params: {
        'project_searchInput': null
      },
      template: require('../templates/project/caseIllness.html'),
      controller: 'projectCaseController'
    })
    .state('project.hospitalDefault', {
      url: '/hospitalDefault',
      template: require('../templates/project/hospitalDefault.html'),
      controller: 'hospitalDefaultController'
    })
    .state('invite', {
      url: '/invite',
      template: require('../templates/invite.html'),
      controller: 'inviteController'
    })
    .state('projectSetting', {
      url: '/projectSetting',
      template: require('../templates/projectSetting.html'),
      controller: 'projectSettingController'
    })
    .state('inviteUsers', {
      url: '/inviteUsers',
      template: require('../templates/userList.html'),
      controller: 'inviteController'
    });

  localStorageServiceProvider
    .setPrefix('login')
    .setStorageType('sessionStorage')
    .setNotify(true, true);


}]);

homePage.controller('homePageController', ['$base64', '$scope', '$http', '$rootScope', '$state', 'localStorageService', function($base64, $scope, $http, $rootScope, $state, localStorageService) {
  loginStatus();
  getMessageInfos();
  $scope.user = localStorageService.get('user');

  sysPermission();
  getProjectList();

  $scope.projects = [];
  $scope.invitePermissions = [];
  $scope.digustPermissions = [];
  $scope.settingPermissions = [];

  $scope.changePass = function() {
    $('#changePassModal').modal({
      keyboard: true
    });
  };

  $scope.intoProject = function(project){
    if(project.id == 1){
      window.open('main.html');
    }else if(project.id == 2){
      window.open('medicineLiverMain.html');
    }
  };

  $scope.confirmChangePass = function() {
    var authKey = $base64.encode($scope.user.account + ':' + $scope.oldPassword);
    $http({
      method: 'GET',
      url: '/api/login',
      headers: {
        'Authorization': 'Basic ' + authKey
      }
    }).then(function success() {
      if ($scope.newPasswordAgain != $scope.newPassword) {
        alert('两次密码输入不一致');
      } else {
        var newUser = {};
        newUser.id = $scope.user.id;
        newUser.password = $scope.newPassword;
        $http({
          method: 'POST',
          url: '/api/users/changePassword',
          data: newUser
        }).then(function success() {
          $scope.sign_out();
        }, function fail() {
          alert('修改密码失败');
        });
      }
    }, function fail() {
      alert('旧密码错误');
    });
  };

  /**
   *获取未读邀请消息
   */
  function getMessageInfos() {
    $http({
      method: 'GET',
      url: '/api/message/noRead'
    }).then(function successCallback(response) {
      $scope.messageInfos = response.data;
      $scope.newMessageCount = response.data.length;
    }, function failCallback() {

    });

  }

  /**
   *进入单个未读信息
   */
  $scope.clickMessage = function(messageInfo) {
    localStorageService.set('message', messageInfo);
  };


  /**
   *对每个项目下的权限进行判断，（邀请，调整项目表，项目设置）
   */
  function projectListPermission() {
    angular.forEach($scope.projects, function(data, index) {
      if (data.currentUserPermissionInProject.contains('邀请')) {
        $scope.invitePermissions[index] = true;
      } else {
        $scope.invitePermissions[index] = false;
      }
      if (data.currentUserPermissionInProject.contains('编辑项目相关内容')) {
        $scope.digustPermissions[index] = true;
      } else {
        $scope.digustPermissions[index] = false;
      }
      if (data.currentUserPermissionInProject.contains('项目设置')) {
        $scope.settingPermissions[index] = true;
      } else {
        $scope.settingPermissions[index] = false;
      }
    });

  }


  /**
   *对系统的的权限进行判断，（普通用户，管理员）
   */
  function sysPermission() {
    angular.forEach(localStorageService.get('sysPermissions'), function(data) {
      if (data.sysPermissionName === '医院信息') {
        $scope.hospitalPermission = true;
      }
    });

  }



  /**
   *设置该账户当前点击的项目，并将该账户在该项目下的权限也保存在project对象里
   */
  $scope.click_project = function(project) {
    localStorageService.set('project', project);
    $state.go('project');
  };

  /**
   *左侧栏对项目进行搜索
   */
  $scope.search_project = function() {

    $http({
      method: 'GET',
      url: '/api/projects/msg?msg=' + $scope.search_projectName
    }).then(function successCallback(response) {
      $scope.projects = response.data;
      getProjectPermission();
    }, function failCallback() {

    });

  };

  /**
   *对是否登录进入首页进行判断，（未登录跳回登陆页面）
   */
  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }

  /**
   *请求得到该用户的所有项目
   */
  function getProjectList() {
    $http({
      method: 'GET',
      url: '/api/projects'
    }).then(function successCallback(response) {
      $scope.projects = response.data;
      getProjectPermission();
    }, function failCallback() {

    });
  }


  /**
   *过滤用户每个项目下的权限
   */
  function getProjectPermission() {
    angular.forEach($scope.projects, function(data) {
      var projectPermissionName = [];
      angular.forEach(data.currentUserPermissionInProject, function(permission_data) {
        projectPermissionName.push(permission_data.projectPermissionName);
      });
      data.currentUserPermissionInProject = projectPermissionName;
    });
    projectListPermission();
  }

  $scope.sign_out = function() {
    $http({
      method: 'GET',
      url: '/api/logout'
    }).then(function successCallback() {
      localStorageService.set('user',null);
      window.location.href = '/login.html';
    }, function failCallback() {

    });

  };


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