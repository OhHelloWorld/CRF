'use strict';

import angular from 'angular';
import '../entries/main.js';

var patientInfo = angular.module('patientInfo', ['main']);

patientInfo.controller('patientInfoController', ['$scope', '$http', '$state', function($scope, $http, $state) {

  if(sessionStorage.getItem('patientId')) {
    $scope.myModalContent = '确认修改基本资料吗？';
  }else{
    $scope.myModalContent = '确认提交吗？';
  }
  var patient = {};
  $scope.patientMenuClick();

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

  //姓名失焦事件
  $scope.judgeName = function() {
    if($scope.name == undefined || $scope.name == '') {
      $('#inputName').removeAttr('data-content');
      $('#inputName').attr('data-content', '不能为空');
      $('#inputName').popover('show');
    }else if($scope.name.length < 2 || $scope.name.length >10) {
      $('#inputName').removeAttr('data-content');
      $('#inputName').attr('data-content', '长度不符合要求');
      $('#inputName').popover('show');
    }else{
      $('#inputName').removeAttr('data-content');
      $('#inputName').attr('data-content', '');
    }
  };

  //姓名失焦事件
  // $scope.judgeGender = function() {
  //   if($scope.gender == undefined || $scope.gender == '') {
  //     $('#inputGender').removeAttr('data-content');
  //     $('#inputGender').attr('data-content', '不能为空');
  //     $('#inputGender').popover('show');
  //   }else if($scope.gender.length < 2 || $scope.gender.length >10) {
  //     $('#inputGenderinputGender').removeAttr('data-content');
  //     $('#inputGender').attr('data-content', '长度不符合要求');
  //     $('#inputGender').popover('show');
  //   }else{
  //     $('#inputGender').removeAttr('data-content');
  //     $('#inputGender').attr('data-content', '');
  //   }
  // };

  $scope.showNextModel = function() {
    $('#myModal').modal('show');
  };

  $scope.showExistModal = function() {
    $('#existModal').modal('show');
  };

  $scope.exsitEdit = function() {
    $('#existModal').modal('toggle');
    // window.location.href = index.html;
    setTimeout(function() {
      $state.go('home');
    }, 1000);
  };

  //毫秒转换年月日
  function toPre(date) {
    var unixTimestamp = new Date(date);
    return (unixTimestamp.getMonth() + 1) + '/' + unixTimestamp.getDate() + '/' + unixTimestamp.getFullYear();
  }

  // 06/14/2017 ==> 2017-06-14
  function formatDateFromBack(date) {
    var dateArr = date.split('/');
    var year = dateArr[2];
    var month = dateArr[0];
    var day = dateArr[1];
    return year + '-' + month + '-' + day;
  }

  //非创建用户按钮    取个人信息
  if(sessionStorage.getItem('patientId')) {
    $http({
      method:'GET',
      url:'api/patient/' + sessionStorage.getItem('patientId')
    }).then(function(response){
      patient = response.data;
      $scope.name = patient.name;
      $scope.gender = patient.gender;
      $scope.age = patient.age;
      $scope.height = patient.height;
      $scope.weight = patient.weight;
      $scope.smoke = patient.smoke;
      $scope.drink = patient.drink;
      $scope.familyHistory = patient.familyHistory;
      $scope.hepatitisDiagnosisTime = toPre(patient.hepatitisDiagnosisTime);
      $scope.cirrhosisDiagnosisTime = toPre(patient.cirrhosisDiagnosisTime);
      $scope.westernMedicineDiagnosis = patient.westernMedicineDiagnosis;
      $scope.chineseMedicineDiagnosis = patient.chineseMedicineDiagnosis;
      $scope.westernMedicineTreatment = patient.westernMedicineTreatment;
      $scope.chineseMedicineTreatment = patient.chineseMedicineTreatment;
    });
  }
  //保存 --> 确定  按钮
  $scope.commit = function() {
    patient.name = $scope.name;
    patient.gender = $scope.gender;
    patient.age = $scope.age;
    patient.height = $scope.height;
    patient.weight = $scope.weight;
    patient.smoke = $scope.smoke;
    patient.drink = $scope.drink;
    patient.familyHistory = $scope.familyHistory;
    patient.hepatitisDiagnosisTime = formatDateFromBack($scope.hepatitisDiagnosisTime);
    patient.cirrhosisDiagnosisTime = formatDateFromBack($scope.cirrhosisDiagnosisTime);
    patient.westernMedicineDiagnosis = $scope.westernMedicineDiagnosis;
    patient.chineseMedicineDiagnosis = $scope.chineseMedicineDiagnosis;
    patient.westernMedicineTreatment = $scope.westernMedicineTreatment;
    patient.chineseMedicineTreatment = $scope.chineseMedicineTreatment;
    // console.log('$scope.smoke ==>' + $scope.smoke);
    if(!sessionStorage.getItem('patientId')) {
      $http({
        method:'POST',
        url:'/api/patient',
        data: patient
      }).then(function(response) {
        sessionStorage.setItem('patientId', response.data);
        $('#mymodal').modal('hide');
        $scope.justModalContent = '操作成功！';
        setTimeout(function(){
          $('#justModal').modal('show');
        }, 500);
      });
    }else{
      patient.id = sessionStorage.getItem('patientId');
      $http({
        method:'PUT',
        url:'api/patient',
        data: patient
      }).then(function(){
        $('#mymodal').modal('hide');
        $scope.justModalContent = '基本资料更新成功！';
        setTimeout(function(){
          $('#justModal').modal('show');
        }, 500);
      });
    }
  };



}]);
