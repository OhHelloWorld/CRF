'use strict';

import angular from 'angular';

var patientInfo = angular.module('patientInfo', []);

patientInfo.controller('patientInfoController', ['$scope', '$http', function($scope, $http) {


  $('#datepicker').datepicker({
    autoclose: true
  });

  $('#datepicker2').datepicker({
    autoclose: true
  });

 
  //新建
  $http({
    method:'POST',
    url:''
  }).then(function(){
    alert('post successed!!');
  });
}]);
