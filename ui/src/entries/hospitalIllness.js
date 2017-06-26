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
import LocalStorageModule from 'angular-local-storage';

var hospitalCase = angular.module('hospitalCase', [LocalStorageModule]);

hospitalCase.config(['localStorageServiceProvider', function(localStorageServiceProvider) {

  localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);


}]);

hospitalCase.controller('hospitalCaseController', ['$scope', '$http', '$rootScope', 'localStorageService', function($scope, $http, $rootScope, localStorageService) {

  var project1 = {
    name: '测试项目',
    id: 1
  };
  var project2 = {
    name: '测试项目2',
    id: 2
  };
  var project3 = {
    name: '测试项目3',
    id: 3
  }; 

  $scope.projects = [project1, project2, project3];

  /**
   *设置该账户当前点击的项目，并将该账户在该项目下的权限也保存在project对象里
   */
  $scope.click_project = function(project){
    localStorageService.set('project', project);
  }


  $scope.search_project = function(){

   /*  $http({
      method: 'GET',
      url: '/search_projectName'
    }).then(function successCallback(response){


    }, function failCallback(response){
      console.log('没有找到相关项目！');
    });
 */
  }

  

}]);





