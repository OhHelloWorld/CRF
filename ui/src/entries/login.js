'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/js/icheck.min.js';
import '../lib/css/blue.css';
import 'angular-base64';

import angular from 'angular';
import LocalStorageModule from 'angular-local-storage';

var login = angular.module('login',['base64', LocalStorageModule]);

login.config(['localStorageServiceProvider', function(localStorageServiceProvider) {
  
  localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
}]);

login.controller('loginController', ['$scope', '$http', '$base64', 'localStorageService', function($scope, $http, $base64, localStorageService){

  $('input').iCheck({
    checkboxClass: 'icheckbox_square-blue',
    radioClass: 'iradio_square-blue',
    increaseArea: '20%' // optional
  });

  $scope.login = function() {
    var authValue = $base64.encode($scope.account + '#' + $scope.password);
    $http({
      method:'GET',
      url:'/api/login',
      headers:{
        'Authorization' : authValue
      }
    }).then(function success(response){
      var compareResult = response.data;
      localStorageService.set('user', compareResult);
      localStorageService.set('projectList', compareResult);
      $scope.justModalContent = '登录成功，即将跳转！';
      $('#justModal').modal('show');
      setTimeout(function(){
        window.location.href = 'http://localhost:9000/main.html#!/home';
      }, 500);
    }, function failed() {
        $scope.justModalContent = '账号或验证码输入错误，请检查后重新登陆！';
        $('#justModal').modal('show');
    });
  };

}]);
