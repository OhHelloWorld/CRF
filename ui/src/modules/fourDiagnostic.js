import angular from 'angular';

angular.module('fourDiagnostic', [])
  .controller('fourDiagnosticController', ['$scope', '$http', function($scope, $http) {
    $scope.save = function() {
      if (($scope.fatigue && $scope.skinItching && $scope.twoEyesDry &&
          $scope.blurredVision && $scope.depression && $scope.irritability &&
          $scope.insomnia && $scope.easyWakeUp && $scope.tinnitus && $scope.dryMouth && $scope.mouthPain &&
          $scope.badBreath && $scope.nausea && $scope.belching && $scope.abdominalDistention && $scope.flankPainStinging &&
          $scope.flankPainSwell && $scope.flankPainDull && $scope.flankPainDiscomfort && $scope.anorexia && $scope.aphrodisiacCold &&
          $scope.limb && $scope.backacheFootSoft && $scope.handFootFanHot && $scope.urineYellow && $scope.constipation && $scope.looseStools &&
          $scope.perspiration && $scope.nightSweats && $scope.lowerExtremityEdema && $scope.faceDull && $scope.eyeYellow && $scope.bodyYellow &&
          $scope.spiderNevus && $scope.liverPalm && $scope.abdominalVeins && $scope.yellowTumor) != undefined) {
        $http({
          method: 'POST',
          url: '/api/fourDiagnosticInfor'
        }).then(function success() {
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
      } else {
        $scope.confirmInfo = '填写尚不完整，是否保存？';
        $('#confirmModal').modal({
          keyboard: true
        });
      }
    };
    $scope.confirm = function() {

    };
  }]);