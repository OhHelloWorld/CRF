import angular from 'angular';
import '../entries/main.js';

angular.module('liverPathology', ['main'])
  .controller('liverPathologyController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    loginStatus();
    $scope.judgeGoHome();
    getChoose();
    var liverPathology = {};
    var ishakData = {};
    var haiData = {};
    $scope.liverPathologyClick();
    $scope.changeMenuStatus();

    $('#datepickerliver').datepicker({
      autoclose: true
    });

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
      } else if (!($scope.leaf && $scope.interfacial && $scope.portal && $scope.lymphocyte && $scope.fibrous && $scope.inflammation && $scope.hepatocellular && $scope.rose && $scope.hbs && $scope.hbc && $scope.hcv && $scope.other && $scope.diagnosis && $scope.mark) && $scope.gs) {
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

    $scope.changeChoose = function() {
      switch ($scope.chooseModel) {
        case (1):
          {
            // if ($scope.ishak || $scope.hai) {
            //   initializeModal();
            //   $('#modalButton1').addClass('hide');
            //   $scope.buttonContent1 = '';
            //   $scope.buttonContent2 = '确认';
            //   $scope.information = '您只需填写一份评分系统';
            //   $('#infoModal').modal({
            //     keyboard: true
            //   });
            // } else {
            $scope.gs = true;
            $scope.ishak = false;
            $scope.hai = false;
            // }
            break;
          }
        case (2):
          {
            // if ($scope.gs || $scope.hai) {
            //   initializeModal();
            //   $('#modalButton1').addClass('hide');
            //   $scope.buttonContent1 = '';
            //   $scope.buttonContent2 = '确认';
            //   $scope.information = '您只需填写一份评分系统';
            //   $('#infoModal').modal({
            //     keyboard: true
            //   });
            // } else {
            $scope.gs = false;
            $scope.ishak = true;
            $scope.hai = false;
            // }
            break;
          }
        case (3):
          {
            // if ($scope.gs || $scope.ishak) {
            //   initializeModal();
            //   $('#modalButton1').addClass('hide');
            //   $scope.buttonContent1 = '';
            //   $scope.buttonContent2 = '确认';
            //   $scope.information = '您只需填写一份评分系统';
            //   $('#infoModal').modal({
            //     keyboard: true
            //   });
            // } else {
            $scope.gs = false;
            $scope.ishak = false;
            $scope.hai = true;
            // }
            break;
          }
      }
      get();
    };

    function initializeModal() {
      $('#modalButton1').removeClass('hide');
      $('#modalButton2').removeClass('hide');
    }

    function save() {
      if ($scope.gs) {
        liverPathology.patientId = sessionStorage.getItem('patientId');
        liverPathology.addDate = new Date($scope.addDate);
        liverPathology.inflammationLeaflets = $scope.leaf;
        liverPathology.interfacialInflammation = $scope.interfacial;
        liverPathology.portalAreaInflammation = $scope.portal;
        liverPathology.lymphocytePlasmaCellInfiltration = $scope.lymphocyte;
        liverPathology.fibrousTissueHyperplasia = $scope.fibrous;
        liverPathology.inflammationBileDuct = $scope.inflammation;
        liverPathology.hepatocellularSteatosis = $scope.hepatocellular;
        liverPathology.roseSample = $scope.rose;
        liverPathology.hbsAg = $scope.hbs;
        liverPathology.hbcAg = $scope.hbc;
        liverPathology.hcv = $scope.hcv;
        liverPathology.other = $scope.other;
        liverPathology.diagnosis = $scope.diagnosis;
        liverPathology.choose = true;
        liverPathology.remarks = $scope.mark;
        if ($scope.buttonContent1 == '取消') {
          liverPathology.complete = false;
        } else {
          liverPathology.complete = true;
        }
        $http({
          url: '/api/liverPathology',
          method: 'POST',
          data: liverPathology
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
      } else if ($scope.ishak) {
        ishakData.patientId = sessionStorage.getItem('patientId');
        ishakData.addDate = new Date($scope.addDate);
        ishakData.portalAreaInflammation = $scope.portalAreaInflammation;
        ishakData.lobularMobility = $scope.lobularMobility;
        ishakData.interfaceInflammation = $scope.interfaceInflammation;
        ishakData.confluentNecrosis = $scope.confluentNecrosis;
        ishakData.fibrosis = $scope.fibrosis;
        ishakData.choose = true;
        $http({
          url: '/api/ishak',
          method: 'POST',
          data: ishakData
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
      } else if ($scope.hai) {
        haiData.patientId = sessionStorage.getItem('patientId');
        haiData.addDate = new Date($scope.addDate);
        haiData.portalAreaInflammation = $scope.portalAreaInflammation;
        haiData.lobularMobility = $scope.lobularMobility;
        haiData.interfaceInflammation = $scope.interfaceInflammation;
        haiData.choose = true;
        $http({
          url: '/api/hai',
          method: 'POST',
          data: haiData
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
    }

    function get() {
      if ($scope.gs) {
        $http({
          method: 'GET',
          url: '/api/liverPathology/' + sessionStorage.getItem('patientId'),
        }).then(function success(response) {
          var res = response.data;
          if (!res.addDate) {
            $scope.addDate = undefined;
          } else {
            var myDate = new Date(res.addDate);
            $scope.addDate = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
          }
          $scope.leaf = res.inflammationLeaflets;
          $scope.interfacial = res.interfacialInflammation;
          $scope.portal = res.portalAreaInflammation;
          $scope.lymphocyte = res.lymphocytePlasmaCellInfiltration;
          $scope.fibrous = res.fibrousTissueHyperplasia;
          $scope.inflammation = res.inflammationBileDuct;
          $scope.hepatocellular = res.hepatocellularSteatosis;
          $scope.rose = res.roseSample;
          $scope.hbs = res.hbsAg;
          $scope.hbc = res.hbcAg;
          $scope.hcv = res.hcv;
          $scope.other = res.other;
          $scope.diagnosis = res.diagnosis;
          $scope.mark = res.remarks;
        });
      } else if ($scope.ishak) {
        $http({
          method: 'GET',
          url: '/api/ishak/' + sessionStorage.getItem('patientId'),
        }).then(function success(response) {
          var res = response.data;
          if (!res.addDate) {
            $scope.addDate = undefined;
          } else {
            var myDate = new Date(res.addDate);
            $scope.addDate = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
          }
          $scope.portalAreaInflammation = res.portalAreaInflammation;
          $scope.lobularMobility = res.lobularMobility;
          $scope.interfaceInflammation = res.interfaceInflammation;
          $scope.confluentNecrosis = res.confluentNecrosis;
          $scope.fibrosis = res.fibrosis;
        });
      } else if ($scope.hai) {
        $http({
          method: 'GET',
          url: '/api/hai/' + sessionStorage.getItem('patientId'),
        }).then(function success(response) {
          var res = response.data;
          if (!res.addDate) {
            $scope.addDate = undefined;
          } else {
            var myDate = new Date(res.addDate);
            $scope.addDate = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
          }
          $scope.portalAreaInflammation = res.portalAreaInflammation;
          $scope.lobularMobility = res.lobularMobility;
          $scope.interfaceInflammation = res.interfaceInflammation;
        });
      }
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

    function getChoose() {
      $http({
        method: 'GET',
        url: '/api/liverPathology/choose/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        var chooseList = response.data;
        if (chooseList[0]) {
          $scope.gs = true;
          $scope.ishak = false;
          $scope.hai = false;
          $scope.chooseModel = 1;
        } else if (chooseList[1]) {
          $scope.gs = false;
          $scope.ishak = true;
          $scope.hai = false;
          $scope.chooseModel = 2;
        } else if (chooseList[2]) {
          $scope.gs = false;
          $scope.ishak = false;
          $scope.hai = true;
          $scope.chooseModel = 3;
        } else {
          $scope.gs = true;
          $scope.ishak = false;
          $scope.hai = false;
          $scope.chooseModel = 1;
        }
      });
    }

  }]);