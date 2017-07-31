import angular from 'angular';
import '../entries/main.js';

angular.module('complexAIH', ['main'])
  .controller('complexAIHController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    loginStatus();
    $scope.judgeGoHome();
    $scope.complexAIHClick();
    $scope.beforeShow = true;
    $scope.afterShow = false;
    $('#tab1').addClass('active');
    $scope.changeMenuStatus();
    $scope.before = function() {
      $('#tab1').addClass('active');
      $('#tab2').removeClass('active');
      $scope.beforeShow = true;
      $scope.afterShow = false;
    };
    $scope.after = function() {
      $('#tab2').addClass('active');
      $('#tab1').removeClass('active');
      $scope.beforeShow = false;
      $scope.afterShow = true;
    };

    var complexAIHBeforeTreatment = {};
    var complexAIHAfterTreatment = {};

    get();
    getPatientInfo();

    //“保存”按钮点击事件
    $scope.save = function() {
      if ($scope.beforeShow == true) {
        if (!($scope.beforeSex && $scope.beforeHistoryDrugs && $scope.beforeAlpAst && $scope.beforeAlcoholIntake && $scope.beforeSerumGlobulinNormal && $scope.beforeLiverCheck && $scope.beforeOtherImmune && $scope.beforeAna && $scope.beforeAma && $scope.beforeHepatitis && $scope.beforeOtherAvailable)) {
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
      } else {
        if (!($scope.afterSex && $scope.afterHistoryDrugs && $scope.afterAlpAst && $scope.afterAlcoholIntake && $scope.afterSerumGlobulinNormal && $scope.afterLiverCheck && $scope.afterOtherImmune && $scope.afterAna && $scope.afterAma && $scope.afterHepatitis && $scope.afterOtherAvailable && $scope.response)) {
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

    function initializeModal() {
      $('#modalButton1').removeClass('hide');
      $('#modalButton2').removeClass('hide');
    }

    function save() {
      if ($scope.beforeShow == true) {
        complexAIHBeforeTreatment.patientId = sessionStorage.getItem('patientId');
        complexAIHBeforeTreatment.woman = $scope.beforeSex;
        complexAIHBeforeTreatment.historyDrugs = $scope.beforeHistoryDrugs;
        complexAIHBeforeTreatment.aLPAST = $scope.beforeAlpAst;
        complexAIHBeforeTreatment.alcoholIntake = $scope.beforeAlcoholIntake;
        complexAIHBeforeTreatment.serumGlobulinNormal = $scope.beforeSerumGlobulinNormal;
        complexAIHBeforeTreatment.liverCheck = $scope.beforeLiverCheck;
        complexAIHBeforeTreatment.ana = $scope.beforeAna;
        complexAIHBeforeTreatment.otherImmuneDiseases = $scope.beforeOtherImmune;
        complexAIHBeforeTreatment.amaPositive = $scope.beforeAma;
        complexAIHBeforeTreatment.otherAvailableParameters = $scope.beforeOtherAvailable;
        complexAIHBeforeTreatment.hepatitisVirusMarkers = $scope.beforeHepatitis;
        // complexAIHBeforeTreatment.followUp = $scope.beforeFollowUp;
        // complexAIHBeforeTreatment.followUpDate = $scope.beforeFollowUpDate;
        if ($scope.buttonContent1 == '取消') {
          complexAIHBeforeTreatment.complete = false;
        } else {
          complexAIHBeforeTreatment.complete = true;
        }
        $http({
          url: '/api/complexAIHBeforeTreatment',
          method: 'POST',
          data: complexAIHBeforeTreatment
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
      } else {
        complexAIHAfterTreatment.patientId = sessionStorage.getItem('patientId');
        complexAIHAfterTreatment.woman = $scope.afterSex;
        complexAIHAfterTreatment.historyDrugs = $scope.afterHistoryDrugs;
        complexAIHAfterTreatment.aLPAST = $scope.afterAlpAst;
        complexAIHAfterTreatment.alcoholIntake = $scope.afterAlcoholIntake;
        complexAIHAfterTreatment.serumGlobulinNormal = $scope.afterSerumGlobulinNormal;
        complexAIHAfterTreatment.liverCheck = $scope.afterLiverCheck;
        complexAIHAfterTreatment.ana = $scope.afterAna;
        complexAIHAfterTreatment.otherImmuneDiseases = $scope.afterOtherImmune;
        complexAIHAfterTreatment.amaPositive = $scope.afterAma;
        complexAIHAfterTreatment.otherAvailableParameters = $scope.afterOtherAvailable;
        complexAIHAfterTreatment.hepatitisVirusMarkers = $scope.afterHepatitis;
        complexAIHAfterTreatment.responseTreatment = $scope.response;
        // complexAIHAfterTreatment.followUp = $scope.afterFollowUp;
        // complexAIHAfterTreatment.followUpDate = $scope.afterFollowUpDate;
        if ($scope.buttonContent1 == '取消') {
          complexAIHAfterTreatment.complete = false;
        } else {
          complexAIHAfterTreatment.complete = true;
        }
        $http({
          url: '/api/complexAIHAfterTreatment',
          method: 'POST',
          data: complexAIHAfterTreatment
        }).then(function success() {
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

    }

    function get() {
      $http({
        method: 'GET',
        url: '/api/complexAIHBeforeTreatment/' + sessionStorage.getItem('patientId'),
      }).then(function success(response) {
        var res = response.data;
        $scope.beforeSex = res.woman;
        $scope.beforeHistoryDrugs = res.historyDrugs;
        $scope.beforeAlpAst = res.aLPAST;
        $scope.beforeAlcoholIntake = res.alcoholIntake;
        $scope.beforeSerumGlobulinNormal = res.serumGlobulinNormal;
        $scope.beforeLiverCheck = res.liverCheck;
        $scope.beforeAna = res.ana;
        $scope.beforeOtherImmune = res.otherImmuneDiseases;
        $scope.beforeAma = res.amaPositive;
        $scope.beforeOtherAvailable = res.otherAvailableParameters;
        $scope.beforeHepatitis = res.hepatitisVirusMarkers;
        //  $scope.followUp = res.followUp;
        //  $scope.followUpDate =  res.followUpDate;
      }, function fail() {

      });
      $http({
        method: 'GET',
        url: '/api/complexAIHAfterTreatment/' + sessionStorage.getItem('patientId'),
      }).then(function success(response) {
        var res = response.data;
        $scope.afterSex = res.woman;
        $scope.afterHistoryDrugs = res.historyDrugs;
        $scope.afterAlpAst = res.aLPAST;
        $scope.afterAlcoholIntake = res.alcoholIntake;
        $scope.afterSerumGlobulinNormal = res.serumGlobulinNormal;
        $scope.afterLiverCheck = res.liverCheck;
        $scope.afterAna = res.ana;
        $scope.afterOtherImmune = res.otherImmuneDiseases;
        $scope.afterAma = res.amaPositive;
        $scope.afterOtherAvailable = res.otherAvailableParameters;
        $scope.afterHepatitis = res.hepatitisVirusMarkers;
        $scope.response = res.responseTreatment;
        //  $scope.followUp = res.followUp;
        //  $scope.followUpDate =  res.followUpDate;
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

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }

  }]);