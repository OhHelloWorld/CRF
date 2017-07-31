import angular from 'angular';
import '../entries/main.js';

angular.module('simpleAIH', [])
  .controller('simpleAIHController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    loginStatus();
    $scope.judgeGoHome();
    $scope.simpleAIHClick();
    $scope.changeMenuStatus();
    $scope.ANAover = function() {
      $scope.ana_sma_show = true;
    };
    $scope.ANAleave = function() {
      $scope.ana_sma_show = false;
    };
    $scope.ANASMAover = function() {
      $scope.ana__sma_show = true;
    };
    $scope.ANASMAleave = function() {
      $scope.ana__sma_show = false;
    };
    $scope.antilkmover = function() {
      $scope.antilkm_show = true;
    };
    $scope.antilkmleave = function() {
      $scope.antilkm_show = false;
    };
    $scope.antislaover = function() {
      $scope.antisla_show = true;
    };
    $scope.antislaleave = function() {
      $scope.antisla_show = false;
    };
    $scope.igGover = function() {
      $scope.igG_show = true;
    };
    $scope.igGleave = function() {
      $scope.igG_show = false;
    };
    $scope.liverover = function() {
      $scope.liver_show = true;
    };
    $scope.liverleave = function() {
      $scope.liver_show = false;
    };
    $scope.liver1rover = function() {
      $scope.liver1_show = true;
    };
    $scope.liver1leave = function() {
      $scope.liver1_show = false;
    };
    $scope.resultover = function() {
      $scope.resultShow = true;
    };
    $scope.resultleave = function() {
      $scope.resultShow = false;
    };

    var simpleAIH = {};
    get();
    getPatientInfo();

    //“保存”按钮点击事件
    $scope.save = function() {
      if (!($scope.anasma1 && $scope.anasma2 && $scope.antiLkm && $scope.antiSla && $scope.igG && $scope.liver && $scope.eliminateViralHepatitis)) {
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

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }

    function initializeModal() {
      $('#modalButton1').removeClass('hide');
      $('#modalButton2').removeClass('hide');
    }

    function save() {
      simpleAIH.patientId = sessionStorage.getItem('patientId');
      simpleAIH.anasma1 = $scope.anasma1;
      simpleAIH.anasma2 = $scope.anasma2;
      simpleAIH.antiLkm = $scope.antiLkm;
      simpleAIH.antiSla = $scope.antiSla;
      simpleAIH.igG = $scope.igG;
      simpleAIH.liver = $scope.liver;
      simpleAIH.eliminateViralHepatitis = $scope.eliminateViralHepatitis;
      judgeScore($scope.anasma1, $scope.anasma2, $scope.antiLkm, $scope.antiSla, $scope.igG, $scope.liver, $scope.eliminateViralHepatitis);
      if ($scope.buttonContent1 == '取消') {
        simpleAIH.complete = false;
      } else {
        simpleAIH.complete = true;
      }
      $http({
        url: '/api/simpleAIH',
        method: 'POST',
        data: simpleAIH
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
        url: '/api/simpleAIH/' + sessionStorage.getItem('patientId'),
      }).then(function success(response) {
        var res = response.data;
        $scope.anasma1 = res.anasma1;
        $scope.anasma2 = res.anasma2;
        $scope.antiLkm = res.antiLkm;
        $scope.antiSla = res.antiSla;
        $scope.igG = res.igG;
        $scope.liver = res.liver;
        $scope.eliminateViralHepatitis = res.eliminateViralHepatitis;
        $scope.result = res.result;
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

    function judgeScore(anasma1, anasma2, antiLkm, antiSla, igG, liver, eliminateViralHepatitis) {
      $scope.result = 0;
      var temp = 0;
      anasma1 == 1 ? $scope.result += 0 : $scope.result += 1;
      anasma2 == 1 ? temp += 0 : (anasma2 == 2 ? temp += 1 : temp += 2);
      antiLkm == 1 ? temp += 0 : temp += 2;
      antiSla == 1 ? temp += 0 : temp += 2;
      if (temp >= 2) {
        $scope.result += 2;
      } else {
        $scope.result += temp;
      }
      igG == 1 ? $scope.result += 1 : $scope.result += 2;
      liver == 1 ? $scope.result += 1 : $scope.result += 2;
      eliminateViralHepatitis == 1 ? $scope.result += 0 : $scope.result += 2;
      simpleAIH.result = $scope.result;
    }
  }]);