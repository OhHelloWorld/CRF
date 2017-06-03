import angular from 'angular';
import '../entries/main.js';

angular.module('fourDiagnostic', [])
  .controller('fourDiagnosticController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    var fourDiagnosticInformation = {};
    var isSave = false;
    $scope.fourClick();
    getPatientInfo();
    getFourDiaInfo();
    $scope.save = function() {
      var judgeComplete = $scope.fatigue && $scope.skinItching && $scope.twoEyesDry &&
        $scope.blurredVision && $scope.depression && $scope.irritability &&
        $scope.insomnia && $scope.easyWakeUp && $scope.tinnitus && $scope.dryMouth && $scope.mouthPain &&
        $scope.badBreath && $scope.nausea && $scope.belching && $scope.abdominalDistention && $scope.flankPainStinging &&
        $scope.flankPainSwell && $scope.flankPainDull && $scope.flankPainDiscomfort && $scope.anorexia && $scope.aphrodisiacCold &&
        $scope.limb && $scope.backacheFootSoft && $scope.handFootFanHot && $scope.urineYellow && $scope.constipation && $scope.looseStools &&
        $scope.perspiration && $scope.nightSweats && $scope.lowerExtremityEdema && $scope.faceDull && $scope.eyeYellow && $scope.bodyYellow &&
        $scope.spiderNevus && $scope.liverPalm && $scope.abdominalVeins && $scope.yellowTumor;
      if (isSave) {
        $scope.information = '您已保存，请勿重复操作,谢谢';
        $('#infoModal').modal({
          keyboard: true
        });
      } else {
        if (judgeComplete != undefined) {
          saveFourDia();
        } else {
          $scope.confirmInfo = '填写尚不完整，是否保存？';
          $('#confirmModal').modal({
            keyboard: true
          });
        }
      }
    };
    $scope.next = function() {
      var judgeComplete = $scope.fatigue && $scope.skinItching && $scope.twoEyesDry &&
        $scope.blurredVision && $scope.depression && $scope.irritability &&
        $scope.insomnia && $scope.easyWakeUp && $scope.tinnitus && $scope.dryMouth && $scope.mouthPain &&
        $scope.badBreath && $scope.nausea && $scope.belching && $scope.abdominalDistention && $scope.flankPainStinging &&
        $scope.flankPainSwell && $scope.flankPainDull && $scope.flankPainDiscomfort && $scope.anorexia && $scope.aphrodisiacCold &&
        $scope.limb && $scope.backacheFootSoft && $scope.handFootFanHot && $scope.urineYellow && $scope.constipation && $scope.looseStools &&
        $scope.perspiration && $scope.nightSweats && $scope.lowerExtremityEdema && $scope.faceDull && $scope.eyeYellow && $scope.bodyYellow &&
        $scope.spiderNevus && $scope.liverPalm && $scope.abdominalVeins && $scope.yellowTumor;
      if (isSave) {
        $state.go('tonguePulse');
      } else {
        if (judgeComplete != undefined) {
          saveFourDia();
          $state.go('tonguePulse');
        } else {
          $scope.nextInfo = '进入下一步将失去还未保存的内容，是否继续？';
          $('#nextModal').modal({
            keyboard: true
          });
        }
      }
    };

    $scope.confirmNext = function() {
      $('#nextModal').modal('hide');
      $state.go('tonguePulse');
    };

    $scope.out = function() {
      if (isSave) {
        $state.go('home');
      } else {
        $scope.outmation = '继续退出将失去未保存的内容，是否继续？';
        $('#outModal').modal({
          keyboard: true
        });
      }
    };

    $scope.confirm = function() {
      saveFourDia();
    };

    $scope.outSure = function() {
      $('#outModal').modal('hide');
      $state.go('home');
    };

    function saveFourDia() {
      var judgeComplete = $scope.fatigue && $scope.skinItching && $scope.twoEyesDry &&
        $scope.blurredVision && $scope.depression && $scope.irritability &&
        $scope.insomnia && $scope.easyWakeUp && $scope.tinnitus && $scope.dryMouth && $scope.mouthPain &&
        $scope.badBreath && $scope.nausea && $scope.belching && $scope.abdominalDistention && $scope.flankPainStinging &&
        $scope.flankPainSwell && $scope.flankPainDull && $scope.flankPainDiscomfort && $scope.anorexia && $scope.aphrodisiacCold &&
        $scope.limb && $scope.backacheFootSoft && $scope.handFootFanHot && $scope.urineYellow && $scope.constipation && $scope.looseStools &&
        $scope.perspiration && $scope.nightSweats && $scope.lowerExtremityEdema && $scope.faceDull && $scope.eyeYellow && $scope.bodyYellow &&
        $scope.spiderNevus && $scope.liverPalm && $scope.abdominalVeins && $scope.yellowTumor;
      fourDiagnosticInformation.fatigue = formatFourDia($scope.fatigue);
      fourDiagnosticInformation.patientId = sessionStorage.getItem('patientId');
      fourDiagnosticInformation.skinItching = formatFourDia($scope.skinItching);
      fourDiagnosticInformation.twoEyesDry = formatFourDia($scope.twoEyesDry);
      fourDiagnosticInformation.blurredVision = formatFourDia($scope.blurredVision);
      fourDiagnosticInformation.depression = formatFourDia($scope.depression);
      fourDiagnosticInformation.irritability = formatFourDia($scope.irritability);
      fourDiagnosticInformation.insomnia = formatFourDia($scope.insomnia);
      fourDiagnosticInformation.easyWakeUp = formatFourDia($scope.easyWakeUp);
      fourDiagnosticInformation.tinnitus = formatFourDia($scope.tinnitus);
      fourDiagnosticInformation.dryMouth = formatFourDia($scope.dryMouth);
      fourDiagnosticInformation.mouthPain = formatFourDia($scope.mouthPain);
      fourDiagnosticInformation.badBreath = formatFourDia($scope.badBreath);
      fourDiagnosticInformation.nausea = formatFourDia($scope.nausea);
      fourDiagnosticInformation.belching = formatFourDia($scope.belching);
      fourDiagnosticInformation.abdominalDistention = formatFourDia($scope.abdominalDistention);
      fourDiagnosticInformation.flankPainStinging = formatFourDia($scope.flankPainStinging);
      fourDiagnosticInformation.flankPainSwell = formatFourDia($scope.flankPainSwell);
      fourDiagnosticInformation.flankPainDull = formatFourDia($scope.flankPainDull);
      fourDiagnosticInformation.flankPainDiscomfort = formatFourDia($scope.flankPainDiscomfort);
      fourDiagnosticInformation.anorexia = formatFourDia($scope.anorexia);
      fourDiagnosticInformation.aphrodisiacCold = formatFourDia($scope.aphrodisiacCold);
      fourDiagnosticInformation.limb = formatFourDia($scope.limb);
      fourDiagnosticInformation.backacheFootSoft = formatFourDia($scope.backacheFootSoft);
      fourDiagnosticInformation.handFootFanHot = formatFourDia($scope.handFootFanHot);
      fourDiagnosticInformation.urineYellow = formatFourDia($scope.urineYellow);
      fourDiagnosticInformation.constipation = formatFourDia($scope.constipation);
      fourDiagnosticInformation.looseStools = formatFourDia($scope.looseStools);
      fourDiagnosticInformation.perspiration = formatFourDia($scope.perspiration);
      fourDiagnosticInformation.nightSweats = formatFourDia($scope.nightSweats);
      fourDiagnosticInformation.lowerExtremityEdema = formatFourDia($scope.lowerExtremityEdema);
      fourDiagnosticInformation.faceDull = formatFourDia($scope.faceDull);
      fourDiagnosticInformation.eyeYellow = formatFourDia($scope.eyeYellow);
      fourDiagnosticInformation.bodyYellow = formatFourDia($scope.bodyYellow);
      fourDiagnosticInformation.spiderNevus = formatFourDia($scope.spiderNevus);
      fourDiagnosticInformation.liverPalm = formatFourDia($scope.liverPalm);
      fourDiagnosticInformation.abdominalVeins = formatFourDia($scope.abdominalVeins);
      fourDiagnosticInformation.yellowTumor = formatFourDia($scope.yellowTumor);
      if (judgeComplete == undefined) {
        fourDiagnosticInformation.complete = false;
      } else {
        fourDiagnosticInformation.complete = true;
      }
      $http({
        method: 'POST',
        url: '/api/fourDiagnosticInfor',
        data: fourDiagnosticInformation
      }).then(function success() {
        isSave = true;
        $scope.information = '保存成功！';
        $('#infoModal').modal({
          keyboard: true
        });
      }, function fail() {
        $scope.information = '保存失败！';
        $('#infoModal').modal({
          keyboard: true
        });
      });
    }

    function formatFourDia(data) {
      if (data === undefined) {
        data = -1;
      } else {
        return data;
      }
    }

    function getFourDiaInfo() {
      $http({
        method: 'GET',
        url: '/api/fourDiagnosticInfor/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.fatigue = response.data.fatigue;
        $scope.skinItching = response.data.skinItching;
        $scope.twoEyesDry = response.data.twoEyesDry;
        $scope.blurredVision = response.data.blurredVision;
        $scope.depression = response.data.depression;
        $scope.irritability = response.data.irritability;
        $scope.insomnia = response.data.insomnia;
        $scope.easyWakeUp = response.data.easyWakeUp;
        $scope.tinnitus = response.data.tinnitus;
        $scope.dryMouth = response.data.dryMouth;
        $scope.mouthPain = response.data.mouthPain;
        $scope.badBreath = response.data.badBreath;
        $scope.nausea = response.data.nausea;
        $scope.belching = response.data.belching;
        $scope.abdominalDistention = response.data.abdominalDistention;
        $scope.flankPainStinging = response.data.flankPainStinging;
        $scope.flankPainSwell = response.data.flankPainSwell;
        $scope.flankPainDull = response.data.flankPainDull;
        $scope.flankPainDiscomfort = response.data.flankPainDiscomfort;
        $scope.anorexia = response.data.anorexia;
        $scope.aphrodisiacCold = response.data.aphrodisiacCold;
        $scope.limb = response.data.limb;
        $scope.backacheFootSoft = response.data.backacheFootSoft;
        $scope.handFootFanHot = response.data.handFootFanHot;
        $scope.urineYellow = response.data.urineYellow;
        $scope.constipation = response.data.constipation;
        $scope.looseStools = response.data.looseStools;
        $scope.perspiration = response.data.perspiration;
        $scope.nightSweats = response.data.nightSweats;
        $scope.lowerExtremityEdema = response.data.lowerExtremityEdema;
        $scope.faceDull = response.data.faceDull;
        $scope.eyeYellow = response.data.eyeYellow;
        $scope.bodyYellow = response.data.bodyYellow;
        $scope.spiderNevus = response.data.spiderNevus;
        $scope.liverPalm = response.data.liverPalm;
        $scope.abdominalVeins = response.data.abdominalVeins;
        $scope.yellowTumor = response.data.yellowTumor;
      });
    }

    function getPatientInfo() {
      $http({
        method: 'GET',
        url: '/api/patient/'+sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.patientName = response.data.name;
        $scope.patientNumber = response.data.identifier;
      });
    }

  }]);