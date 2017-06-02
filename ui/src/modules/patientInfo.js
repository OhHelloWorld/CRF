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
  $scope.judgeName = function() {
    if($scope.name == undefined || $scope.name == '') {
      // $('#inputName').popover('hide');
      // $('#inputName').removeAttr('data-content');
      $('#inputName').attr('data-content', '姓名不能为空');
      $('#inputName').popover('show');
      return;
    }
    if($scope.name.length < 2 || $scope.name.length >10) {
      // $('#inputName').popover('hide');
      // $('#inputName').removeAttr('data-content');
      $('#inputName').attr('data-content', '长度不符合要求');
      $('#inputName').popover('show');
      return;
    }
    // $('#inputName').popover('hide');
    // $('#inputName').removeAttr('data-content');
  };

  $scope.showNextModel = function(){
    if(true){
      $('#myModal').modal('show');
    }
  };

  $scope.showExistModal = function(){
    $('#existModal').modal('show');
  };

  $scope.exsitEdit = function(){
    $('#existModal').modal('toggle');
    // window.location.href = index.html;
    setTimeout(function () {
      $state.go('home');
    }, 1000);

  };
}]);
