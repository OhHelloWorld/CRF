'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/blue.css';
import 'angular-base64';

import angular from 'angular';

var register = angular.module('register',['base64']);

register.controller('registerController', ['$scope', '$http', '$base64', '$rootScope', function($scope, $http, $base64, $rootScope){

  $scope.check = false;
  $scope.button_disable = true;

  $http({
    method:'GET',
    url:'/api/hospitals'
  }).then(function success(response) {
    $scope.hospitals = response.data;
  }, function failed() {

  });

  $scope.judgeAccount = function(){
    if(!$scope.account){
      $scope.judgeAccountExist = true;
    }else{
      $scope.judgeAccountExist = false;
    }
    
  };

  $scope.judgePassword = function(){
    if(!$scope.password){
      $scope.judgePasswordExist = true;
    }else{
      $scope.judgePasswordExist = false;
    }
  };

  $scope.judgeRealName = function(){
    if(!$scope.realName){
      $scope.judgeRealNameExist = true;
    }else{
      $scope.judgeRealNameExist = false;
    }
  };

  $scope.judgeSure_password = function(){
    if(!$scope.sure_password){
      $scope.judgeSurePasswordExist = true;
      $scope.judgePasswordEqual = false;
    }else if($scope.sure_password !== $scope.password){
      $scope.judgeSurePasswordExist = false;
      $scope.judgePasswordEqual = true;
    }else{
      $scope.judgeSurePasswordExist = false;
      $scope.judgePasswordEqual = false;
    }
  };

  $scope.judgeHospital = function(hospital){
    if(!$scope.hospital || $scope.hospital === '--选择所属医院--'){
      $scope.judgeHospitalExist = true;
    }else{
      $scope.judgeHospitalExist = false;
    }
    $scope.hospital = hospital;
  };

  $scope.tol = function(){
    if($scope.check){
      $scope.button_disable = false;
    }else{
      $scope.button_disable = true;
    }
  };
  
  var user = {};
  $scope.register = function(){
    if($scope.judgeAccountExist === false && $scope.judgePasswordExist === false && $scope.judgePasswordEqual === false && $scope.judgeAccountAlready === false &&
      $scope.judgeSurePasswordExist === false && $scope.judgeHospitalExist === false){
      user.account = $scope.account;
      user.password = $base64.encode($scope.password);
      user.realName = $scope.realName;
      user.email = $scope.email;
      user.hospital = $scope.hospital;

      $http({
        method: 'POST',
        url: '/api/users',
        data: user
      }).then(function success(resp) {
        $scope.judgeAccountAlready = false;
        window.location.href = '/login.html';
      }, function failed() {
        $scope.judgeAccountAlready = true;
      });
    }
  };
  
}]);










