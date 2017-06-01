import angular from 'angular';

angular.module('fourDiagnostic', [])
  .controller('fourDiagnosticController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    var fourDiagnosticInformation = {};
    var isSave = false;
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

    $scope.confirmNext = function(){
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
      }else{
        return data;
      }
    }
  }]);