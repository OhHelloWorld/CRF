import angular from 'angular';
import '../entries/main.js';

angular.module('boneDensity', ['main'])
  .controller('boneDensityController', ['$scope', '$http', '$state', function($scope, $http, $state) {

    $scope.judgeGoHome();

    var boneDensity = {};
    $('#datepicker').datepicker({
      autoclose: true
    });

    $scope.boneDensityClick();
    $scope.changeMenuStatus();

    get();
    getPatientInfo();

    //“保存”按钮点击事件
    $scope.save = function() {
      if (!$scope.addDate) {
        initializeModal();
        $('#modalButton1').addClass('hide');
        $scope.buttonContent1 = '';
        $scope.buttonContent2 = '确认';
        $scope.information = '请输入日期';
        $('#infoModal').modal({
          keyboard: true
        });
        return false;
      } else if (!($scope.lumbarSpine && $scope.lumbarSpineT && $scope.femoralNeck && $scope.femoralNeckT && $scope.bigTrochanter && $scope.bigTrochanterT && $scope.fullHip && $scope.fullHipT && $scope.diagnosis && $scope.remarks)) {

        initializeModal();
        $scope.buttonContent1 = '取消';
        $scope.buttonContent2 = '确认';
        $scope.information = '您尚未填写完整，是否保存？';
        $('#infoModal').modal({
          keyboard: true
        });
      } else {
        save();
      }
    };

    $scope.layout = function() {
      initializeModal();
      $scope.buttonContent1 = '否';
      $scope.buttonContent2 = '是';
      $scope.information = '退出将失去未保存的内容，是否退出';
      $('#infoModal').modal({
        keyboard: true
      });
    };

    $scope.confirm = function() {
      if ($scope.buttonContent1 == '取消') {
        save();
      } else if ($scope.buttonContent1 == '否') {
        $('#infoModal').modal('hide');
        $state.go('home');
      } else {
        return;
      }
    };

    $scope.$watch('follow', function() {
      if ($scope.follow) {
        $scope.lumbarSpine = undefined;
        $scope.lumbarSpineT = undefined;
        $scope.femoralNeck = undefined;
        $scope.femoralNeckT = undefined;
        $scope.bigTrochanter = undefined;
        $scope.bigTrochanterT = undefined;
        $scope.fullHip = undefined;
        $scope.fullHipT = undefined;
        $scope.diagnosis = undefined;
        $scope.remarks = undefined;
      } else {
        get();
      }
    });

    function initializeModal() {
      $('#modalButton1').removeClass('hide');
      $('#modalButton2').removeClass('hide');
    }

    function save() {
      boneDensity.patientId = sessionStorage.getItem('patientId');
      boneDensity.measuringTime = new Date($scope.addDate);
      boneDensity.lumbarSpine = $scope.lumbarSpine;
      boneDensity.lumbarSpineT = $scope.lumbarSpineT;
      boneDensity.femoralNeck = $scope.femoralNeck;
      boneDensity.femoralNeckT = $scope.femoralNeckT;
      boneDensity.bigTrochanter = $scope.bigTrochanter;
      boneDensity.bigTrochanterT = $scope.bigTrochanterT;
      boneDensity.fullHip = $scope.fullHip;
      boneDensity.fullHipT = $scope.fullHipT;
      boneDensity.diagnosis = $scope.diagnosis;
      boneDensity.remarks = $scope.remarks;
      boneDensity.followUp = $scope.follow;
      boneDensity.followUpDate = new Date($scope.addDate);
      if ($scope.buttonContent1 == '取消') {
        boneDensity.complete = false;
      } else {
        boneDensity.complete = true;
      }
      $http({
        url: '/api/boneDensity',
        method: 'POST',
        data: boneDensity
      }).then(function success() {
        $scope.changeMenuStatus();
        initializeModal();
        $('#modalButton1').addClass('hide');
        $('#modalButton2').addClass('hide');
        $scope.information = '保存成功';
        $('#infoModal').modal({
          keyboard: true
        });
      }, function fail() {
        initializeModal();
        $('#modalButton1').addClass('hide');
        $('#modalButton2').addClass('hide');
        $scope.information = '保存失败';
        $('#infoModal').modal({
          keyboard: true
        });
      });
    }

    function get() {
      $http({
        method: 'GET',
        url: '/api/boneDensity/' + sessionStorage.getItem('patientId'),
      }).then(function success(response) {
        var res = response.data;
        if (!res.measuringTime) {
          $scope.addDate = undefined;
        } else {
          var myDate = new Date(res.measuringTime);
          $scope.addDate = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
        }
        $scope.lumbarSpine = res.lumbarSpine;
        $scope.lumbarSpineT = res.lumbarSpineT;
        $scope.femoralNeck = res.femoralNeck;
        $scope.femoralNeckT = res.femoralNeckT;
        $scope.bigTrochanter = res.bigTrochanter;
        $scope.bigTrochanterT = res.bigTrochanterT;
        $scope.fullHip = res.fullHip;
        $scope.fullHipT = res.fullHipT;
        $scope.diagnosis = res.diagnosis;
        $scope.remarks = res.remarks;
        //  $scope.followUp = boneDensity.followUp;
        //  $scope.followUpDate =  boneDensity.followUpDate;
      }, function fail() {

      });
    }

    function getPatientInfo() {
      $http({
        method: 'GET',
        url: '/api/patient/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.patientName = response.data.name;
        $scope.patientNumber = response.data.identifier;
      });
    }
  }]);