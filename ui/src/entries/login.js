'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/js/icheck.min.js';
import '../lib/blue.css';

import angular from 'angular';

var login = angular.module('login',[]);

login.controller('loginController', ['$scope', '$http', function($scope, $http){

  $('input').iCheck({
    checkboxClass: 'icheckbox_square-blue',
    radioClass: 'iradio_square-blue',
    increaseArea: '20%' // optional
  });

  $scope.login = function() {
    window.location.href = 'http://localhost:9000/main.html#!/home';
  };

}]);
