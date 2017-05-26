'use strict';

import angular from 'angular';

var patientInfo = angular.module('patientInfo', []);

patientInfo.controller('patientInfoController', ['$scope', '$http', '$state', function($scope, $http, $state) {


  $('#datepicker').datepicker({
    autoclose: true
  });

  $('#datepicker2').datepicker({
    autoclose: true
  });


  //新建
  // $http({
  //   method:'POST',
  //   url:''
  // }).then(function(){
  //   alert('post successed!!');
  // });
  //save button
  $scope.showNextModel = function(){
    if(true){
      $('#myModal').modal('show');
    }
  };

  $scope.exsitEdit = function(){
    $('#existModal').modal('toggle');
    // window.location.href = index.html;
    setTimeout(function () {
      $state.go('home');
    }, 1000);

  };
}]);
