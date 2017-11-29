import angular from 'angular';

angular.module('mlFour', [])
  .controller('mlFourController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    getMlPatient();
    getMlFour();
    var mlFour = {};
    $scope.save = function() {
      mlFour.tongueGloss = $scope.tongueGloss;
      mlFour.tongueColor = $scope.tongueColor;
      mlFour.tongueNature = $scope.tongueNature;
      mlFour.tongueNaturePart = $scope.tongueNaturePart;
      mlFour.tongueBody = $scope.tongueBody;
      mlFour.mossNature = $scope.mossNature;
      mlFour.mossNaturePart = $scope.mossNaturePart;
      mlFour.mossColor = $scope.mossColor;
      mlFour.mossColorPart = $scope.mossColorPart;
      mlFour.sublingualVein = $scope.sublingualVein;
      mlFour.leftVein = $scope.leftVein;
      mlFour.rightVein = $scope.rightVein;

      mlFour.fatigue = $scope.fatigue;
      mlFour.skinItching = $scope.skinItching;
      mlFour.twoEyesDry = $scope.twoEyesDry;
      mlFour.blurredVision = $scope.blurredVision;
      mlFour.depression = $scope.depression;
      mlFour.irritability = $scope.irritability;
      mlFour.insomnia = $scope.insomnia;
      mlFour.easyWakeUp = $scope.easyWakeUp;
      mlFour.tinnitus = $scope.tinnitus;
      mlFour.dryMouth = $scope.dryMouth;
      mlFour.mouthPain = $scope.mouthPain;
      mlFour.badBreath = $scope.badBreath;
      mlFour.nausea = $scope.nausea;
      mlFour.belching = $scope.belching;
      mlFour.abdominalDistention = $scope.abdominalDistention;
      mlFour.flankPain = $scope.flankPain;
      mlFour.flankPainPersist = $scope.flankPainPersist;
      mlFour.anorexia = $scope.anorexia;
      mlFour.aphrodisiacCold = $scope.aphrodisiacCold;
      mlFour.limb = $scope.limb;
      mlFour.backacheFootSoft = $scope.backacheFootSoft;
      mlFour.handFootFanHot = $scope.handFootFanHot;
      mlFour.urineYellow = $scope.urineYellow;
      mlFour.constipation = $scope.constipation;
      mlFour.looseStools = $scope.looseStools;
      mlFour.sweat = $scope.sweat;
      mlFour.sweatPersist = $scope.sweatPersist;
      mlFour.lowerExtremityEdema = $scope.lowerExtremityEdema;
      mlFour.faceDull = $scope.faceDull;
      mlFour.eyeYellow = $scope.eyeYellow;
      mlFour.bodyYellow = $scope.bodyYellow;
      mlFour.spiderNevus = $scope.spiderNevus;
      mlFour.liverPalm = $scope.liverPalm;
      mlFour.abdominalVeins = $scope.abdominalVeins;
      mlFour.yellowTumor = $scope.yellowTumor;
      mlFour.complete = true;

      $http({
        url: '/api/mlFour',
        method: 'POST',
        data: mlFour
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    function getMlFour() {
      $http({
        method: 'GET',
        url: '/api/mlFour/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(res) {
        var data = res.data;
        if (data != null) {
          $scope.tongueGloss = data.tongueGloss;
          $scope.tongueColor = data.tongueColor;
          $scope.tongueNature = data.tongueNature;
          $scope.tongueNaturePart = data.tongueNaturePart;
          $scope.tongueBody = data.tongueBody;
          $scope.mossNature = data.mossNature;
          $scope.mossNaturePart = data.mossNaturePart;
          $scope.mossColor = data.mossColor;
          $scope.mossColorPart = data.mossColorPart;
          $scope.sublingualVein = data.sublingualVein;
          $scope.leftVein = data.leftVein;
          $scope.rightVein = data.rightVein;

          $scope.fatigue = data.fatigue;
          $scope.skinItching = data.skinItching;
          $scope.twoEyesDry = data.twoEyesDry;
          $scope.blurredVision = data.blurredVision;
          $scope.depression = data.depression;
          $scope.irritability = data.irritability;
          $scope.insomnia = data.insomnia;
          $scope.easyWakeUp = data.easyWakeUp;
          $scope.tinnitus = data.tinnitus;
          $scope.dryMouth = data.dryMouth;
          $scope.mouthPain = data.mouthPain;
          $scope.badBreath = data.badBreath;
          $scope.nausea = data.nausea;
          $scope.belching = data.belching;
          $scope.abdominalDistention = data.abdominalDistention;
          $scope.flankPain = data.flankPain;
          $scope.flankPainPersist = data.flankPainPersist;
          $scope.anorexia = data.anorexia;
          $scope.aphrodisiacCold = data.aphrodisiacCold;
          $scope.limb = data.limb;
          $scope.backacheFootSoft = data.backacheFootSoft;
          $scope.handFootFanHot = data.handFootFanHot;
          $scope.urineYellow = data.urineYellow;
          $scope.constipation = data.constipation;
          $scope.looseStools = data.looseStools;
          $scope.sweat = data.sweat;
          $scope.sweatPersist = data.sweatPersist;
          $scope.lowerExtremityEdema = data.lowerExtremityEdema;
          $scope.faceDull = data.faceDull;
          $scope.eyeYellow = data.eyeYellow;
          $scope.bodyYellow = data.bodyYellow;
          $scope.spiderNevus = data.spiderNevus;
          $scope.liverPalm = data.liverPalm;
          $scope.abdominalVeins = data.abdominalVeins;
          $scope.yellowTumor = data.yellowTumor;
        }
      });
    }



    function getMlPatient() {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data2 = response.data;
        $scope.patientName = data2.name;
        $scope.patientNumber = data2.identifier;
      });
    }

    $scope.layout = function() {
      $state.go('mlHome');
    };
  }]);