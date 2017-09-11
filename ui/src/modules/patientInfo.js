'use strict';

import angular from 'angular';
import '../entries/main.js';

var patientInfo = angular.module('patientInfo', ['main']);

patientInfo.controller('patientInfoController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
  loginStatus();
  if (sessionStorage.getItem('patientId')) {
    $scope.myModalContent = '确认修改基本资料吗？';
  } else {
    $scope.myModalContent = '确认提交吗？';
  }
  var patient = {};
  $scope.patientMenuClick();
  $scope.familyHistory = '无';


  $scope.showOthers = function() {
    $scope.showOthersResult = (!$scope.smoke || !$scope.drink || ($scope.familyHistory == '无')) ? false : true;
  };

  $scope.showDatepicker = function() {
    $scope.concurrentDatepicker = !$scope.concurrentAutoDisease == true ? false : true;
  };

  $('#datepicker1').datepicker({
    autoclose: true
  });

  $('#datepicker2').datepicker({
    autoclose: true
  });

  $('#datepicker3').datepicker({
    autoclose: true
  });

  $('#datepicker4').datepicker({
    autoclose: true
  });

  $('#datepicker5').datepicker({
    autoclose: true
  });

  $('#datepicker6').datepicker({
    autoclose: true
  });

  $scope.$watch('height', function() {
    if ($scope.weight && $scope.height) {
      $scope.bmi = ($scope.weight) / ($scope.height / 100 * $scope.height / 100);
    }
  });

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
  if (sessionStorage.getItem('patientId')) {
    $http({
      method: 'GET',
      url: '/api/patient/' + sessionStorage.getItem('patientId')
    }).then(function(response) {
      patient = response.data;
      $scope.name = patient.name;
      $scope.gender = patient.gender;
      $scope.height = patient.height;
      $scope.nation = patient.nation;
      if (patient.birthday) {
        $scope.birthday = toPre(patient.birthday);
      }
      $scope.weight = patient.weight;
      $scope.bmi = patient.bmi;
      $scope.degreeOfEducation = patient.degreeOfEducation;
      if (patient.firstTimeLiverInjury) {
        $scope.firstTimeLiverInjury = toPre(patient.firstTimeLiverInjury);
      }
      $scope.investigateHospital = patient.investigateHospital;
      $scope.telephone = patient.telephone;
      $scope.durationOfVisit = patient.durationOfVisit;
      $scope.firstVisitAge = patient.firstVisitAge;
      if (patient.firstVisitTime) {
        $scope.firstVisitTime = toPre(patient.firstVisitTime);
      }
      $scope.smoke = patient.smoke;
      $scope.drink = patient.drink;
      $scope.familyHistory = patient.familyHistory;
      $scope.smokeDrinkFamHis = patient.smokeDrinkFamHis;
      $scope.concurrentAutoDisease = patient.concurrentAutoDisease;
      if (patient.concurrentAutoDate) {
        $scope.concurrentAutoDate = toPre(patient.concurrentAutoDate);
      }
      $scope.conAutoDisFirstOrNot = patient.conAutoDisFirstOrNot;

      $scope.showOthers();
      $scope.showDatepicker();
    });
  }
  //保存 --> 确定  按钮
  $scope.commit = function() {
    patient.name = $scope.name;
    patient.gender = $scope.gender;
    patient.height = $scope.height;
    patient.nation = $scope.nation;
    console.log($scope.birthday);
    if ($scope.birthday) {
      patient.birthday = formatDateFromBack($scope.birthday);
    }
    patient.weight = $scope.weight;
    patient.bmi = $scope.bmi;
    patient.degreeOfEducation = $scope.degreeOfEducation;
    if ($scope.firstTimeLiverInjury) {
      patient.firstTimeLiverInjury = formatDateFromBack($scope.firstTimeLiverInjury);
    }
    patient.investigateHospital = $scope.investigateHospital;
    patient.telephone = $scope.telephone;
    patient.durationOfVisit = $scope.durationOfVisit;
    patient.firstVisitAge = $scope.firstVisitAge;
    if ($scope.firstVisitTime) {
      patient.firstVisitTime = formatDateFromBack($scope.firstVisitTime);
    }
    patient.smoke = $scope.smoke;
    patient.drink = $scope.drink;
    patient.familyHistory = $scope.familyHistory;
    patient.smokeDrinkFamHis = $scope.smokeDrinkFamHis;
    patient.concurrentAutoDisease = $scope.concurrentAutoDisease;
    if ($scope.concurrentAutoDate) {
      patient.concurrentAutoDate = formatDateFromBack($scope.concurrentAutoDate);
    }
    patient.conAutoDisFirstOrNot = $scope.conAutoDisFirstOrNot;
    patient.projectId = localStorageService.get('project').id;
    patient.complete = true;
    if (!sessionStorage.getItem('patientId')) {
      $http({
        method: 'POST',
        url: '/api/patient',
        data: patient
      }).then(function(response) {
        sessionStorage.setItem('patientId', response.data);
        $('#mymodal').modal('hide');
        $scope.justModalContent = '操作成功！';
        setTimeout(function() {
          $('#justModal').modal('show');
        }, 500);
      });
    } else {
      patient.id = sessionStorage.getItem('patientId');
      $http({
        method: 'PUT',
        url: 'api/patient',
        data: patient
      }).then(function() {
        $('#mymodal').modal('hide');
        $scope.justModalContent = '基本资料更新成功！';
        setTimeout(function() {
          $('#justModal').modal('show');
        }, 500);
      });
    }
  };

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }



}]);