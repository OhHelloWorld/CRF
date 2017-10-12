import angular from 'angular';

angular.module('mlPatientOverview', [])
  .controller('mlPatientOverviewController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    if (sessionStorage.getItem('mlPatientId')) {
      loginStatus();
      getMlPatientInfo();
      getAllergy();
      getDiseaseHistory();
      getDrink();
      getDrug();
      getSymptoms();
      getFirst();
      getHosData();
      getExcludeOther();
      getBlood();
      getEndos();
      getLiverHistological();
      getLiverInjury();
      getTreatment();
      getOutcome();
      getSample();

      // getFollowDateList();
    }

    $scope.$watch('see', function() {
      if ($scope.see == '项目') {
        $scope.show1 = true;
        $scope.show2 = false;
      } else {
        $scope.show1 = false;
        $scope.show2 = true;
      }
    });

    function getMlPatientInfo() {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        $scope.mlPatientName = response.data.name;
        $scope.mlPatientNumber = response.data.identifier;
      });
    }

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }

    // $scope.updateFourDia = function() {
    //   sessionStorage.setItem('followFourDiaId', $scope.fourDiaFollow.id);
    //   $state.go('fourDiagnostic');
    // };

    // $scope.updateTongue = function() {
    //   sessionStorage.setItem('followTongueId', $scope.tongueFollow.id);
    //   $state.go('tonguePulse');
    // };

    // $scope.updatePhy = function() {
    //   sessionStorage.setItem('followPhyId', $scope.phyFollow.id);
    //   $state.go('phyAChe');
    // };

    // $scope.updateBone = function() {
    //   sessionStorage.setItem('followBoneId', $scope.boneFollow.id);
    //   $state.go('boneDensity');
    // };

    // $scope.updateTreat = function() {
    //   sessionStorage.setItem('followTreatId', $scope.treatFollow.id);
    //   $state.go('treatment');
    // };

    function getAllergy() {
      $http({
        method: 'GET',
        url: '/api/mlAllergyHistory/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayAllergy(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/fourDiagnosticInfor/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.fourDiaFollowList = response.data;
      // });
    }

    function displayAllergy(response) {
      var allergy = response.data;
      if (allergy.allergyHistory == 1) {
        $scope.allergyHistory = '无';
      } else if (allergy.allergyHistory == 2) {
        $scope.allergyHistory = '有';
      } else if (allergy.allergyHistory == 3) {
        $scope.allergyHistory = '不详';
      }
      $scope.allergen = allergy.allergen;
    }

    function getDiseaseHistory() {
      $http({
        method: 'GET',
        url: '/api/mlDiseaseHistory/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayDisease(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/tonguePulse/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.tongueFollowList = response.data;
      // });
    }

    function displayDisease(response) {
      var diseaseHistory = response.data;
      if (diseaseHistory.otherHistory == 1) {
        $scope.otherHistory = '无';
      } else if (diseaseHistory.otherHistory == 2) {
        $scope.otherHistory = '有';
      }
      if (diseaseHistory.pastDisease == 1) {
        $scope.pastDisease = '无';
      } else if (diseaseHistory.pastDisease == 2) {
        $scope.pastDisease = '有';
      } else if (diseaseHistory.pastDisease == 3) {
        $scope.pastDisease = '不详';
      }
      if (diseaseHistory.epidemicTourism == 1) {
        $scope.epidemicTourism = '无';
      } else if (diseaseHistory.epidemicTourism == 2) {
        $scope.epidemicTourism = '有';
      }
      $scope.epidemicText = diseaseHistory.epidemicText;
      $scope.diseaseHistorys = diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS;
    }

    function getDrink() {
      $http({
        method: 'GET',
        url: '/api/mlDrink/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayDrink(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/physical/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.phyFollowList = response.data;
      // });
    }

    function displayDrink(response) {
      var drink = response.data;
      if (drink.drinkHistory == 1) {
        $scope.drinkHistory = '长期饮酒';
      } else if (drink.drinkHistory == 2) {
        $scope.drinkHistory = '偶尔饮酒';
      } else if (drink.drinkHistory.drinkHistory == 3) {
        $scope.drinkHistory = '不饮酒';
      } else if (drink.drinkHistory.drinkHistory == 4) {
        $scope.drinkHistory = '不详';
      }
      $scope.drinks = drink.medicineLiverDrinkDetailDTOS;
    }

    // function formatDate(myDate) {
    //   if (myDate) {
    //     var myTime = new Date(myDate);
    //     return myTime.getFullYear() + '-' + (myTime.getMonth() + 1) + '-' + myTime.getDate();
    //   } else {
    //     return undefined;
    //   }

    // }

    function getDrug() {
      $http({
        method: 'GET',
        url: '/api/mlDrug/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        $scope.drugs = response.data.medicineLiverSuspectedDrugDetailDTOS;
      });
    }


    function getSymptoms() {
      $http({
        method: 'GET',
        url: '/api/mlSymptoms/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displaySymptoms(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/boneDensity/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.boneFollowList = response.data;
      // });
    }

    function displaySymptoms(response) {
      var symptoms = response.data;
      $scope.symptoms = symptoms.medicineLiverSymptomsOtherDTOs;
      if (symptoms.liverInjury == 1) {
        $scope.liverInjury = '无';
      } else if (symptoms.liverInjury == 2) {
        $scope.liverInjury = '有';
      } else if (symptoms.liverInjury == 3) {
        $scope.liverInjury = '不详';
      }
      if (symptoms.weak == 1) {
        $scope.weak = '轻度';
      } else if (symptoms.weak == 2) {
        $scope.weak = '中度';
      } else if (symptoms.weak == 3) {
        $scope.weak = '重度';
      } else if (symptoms.weak == 4) {
        $scope.weak = '不详';
      }

      if (symptoms.weakDischarge == 1) {
        $scope.weakDischarge = '轻度';
      } else if (symptoms.weakDischarge == 2) {
        $scope.weakDischarge = '中度';
      } else if (symptoms.weakDischarge == 3) {
        $scope.weakDischarge = '重度';
      } else if (symptoms.weakDischarge == 4) {
        $scope.weakDischarge = '不详';
      }

      if (symptoms.anorexia == 1) {
        $scope.anorexia = '轻度';
      } else if (symptoms.anorexia == 2) {
        $scope.anorexia = '中度';
      } else if (symptoms.anorexia == 3) {
        $scope.anorexia = '重度';
      } else if (symptoms.anorexia == 4) {
        $scope.anorexia = '不详';
      }

      if (symptoms.anorexiaDischarge == 1) {
        $scope.anorexiaDischarge = '轻度';
      } else if (symptoms.anorexiaDischarge == 2) {
        $scope.anorexiaDischarge = '中度';
      } else if (symptoms.anorexiaDischarge == 3) {
        $scope.anorexiaDischarge = '重度';
      } else if (symptoms.anorexiaDischarge == 4) {
        $scope.anorexiaDischarge = '不详';
      }

      if (symptoms.abdominalDistention == 1) {
        $scope.abdominalDistention = '轻度';
      } else if (symptoms.abdominalDistention == 2) {
        $scope.abdominalDistention = '中度';
      } else if (symptoms.abdominalDistention == 3) {
        $scope.abdominalDistention = '重度';
      } else if (symptoms.abdominalDistention == 4) {
        $scope.abdominalDistention = '不详';
      }

      if (symptoms.abdominalDistentionDischarge == 1) {
        $scope.abdominalDistentionDischarge = '轻度';
      } else if (symptoms.abdominalDistentionDischarge == 2) {
        $scope.abdominalDistentionDischarge = '中度';
      } else if (symptoms.abdominalDistentionDischarge == 3) {
        $scope.abdominalDistentionDischarge = '重度';
      } else if (symptoms.abdominalDistentionDischarge == 4) {
        $scope.abdominalDistentionDischarge = '不详';
      }

      if (symptoms.jaundice == 1) {
        $scope.jaundice = '轻度';
      } else if (symptoms.jaundice == 2) {
        $scope.jaundice = '中度';
      } else if (symptoms.jaundice == 3) {
        $scope.jaundice = '重度';
      } else if (symptoms.jaundice == 4) {
        $scope.jaundice = '不详';
      }

      if (symptoms.jaundiceDischarge == 1) {
        $scope.jaundiceDischarge = '轻度';
      } else if (symptoms.jaundiceDischarge == 2) {
        $scope.jaundiceDischarge = '中度';
      } else if (symptoms.jaundiceDischarge == 3) {
        $scope.jaundiceDischarge = '重度';
      } else if (symptoms.jaundiceDischarge == 4) {
        $scope.jaundiceDischarge = '不详';
      }

      if (symptoms.nausea == 1) {
        $scope.nausea = '轻度';
      } else if (symptoms.nausea == 2) {
        $scope.nausea = '中度';
      } else if (symptoms.nausea == 3) {
        $scope.nausea = '重度';
      } else if (symptoms.nausea == 4) {
        $scope.nausea = '不详';
      }

      if (symptoms.nauseaDischarge == 1) {
        $scope.nauseaDischarge = '轻度';
      } else if (symptoms.nauseaDischarge == 2) {
        $scope.nauseaDischarge = '中度';
      } else if (symptoms.nauseaDischarge == 3) {
        $scope.nauseaDischarge = '重度';
      } else if (symptoms.nauseaDischarge == 4) {
        $scope.nauseaDischarge = '不详';
      }

      if (symptoms.vomit == 1) {
        $scope.vomit = '轻度';
      } else if (symptoms.vomit == 2) {
        $scope.vomit = '中度';
      } else if (symptoms.vomit == 3) {
        $scope.vomit = '重度';
      } else if (symptoms.vomit == 4) {
        $scope.vomit = '不详';
      }

      if (symptoms.vomitDischarge == 1) {
        $scope.vomitDischarge = '轻度';
      } else if (symptoms.vomitDischarge == 2) {
        $scope.vomitDischarge = '中度';
      } else if (symptoms.vomitDischarge == 3) {
        $scope.vomitDischarge = '重度';
      } else if (symptoms.vomitDischarge == 4) {
        $scope.vomitDischarge = '不详';
      }

      if (symptoms.gingivalBleeding == 1) {
        $scope.gingivalBleeding = '轻度';
      } else if (symptoms.gingivalBleeding == 2) {
        $scope.gingivalBleeding = '中度';
      } else if (symptoms.gingivalBleeding == 3) {
        $scope.gingivalBleeding = '重度';
      } else if (symptoms.gingivalBleeding == 4) {
        $scope.gingivalBleeding = '不详';
      }

      if (symptoms.gingivalBleedingDischarge == 1) {
        $scope.gingivalBleedingDischarge = '轻度';
      } else if (symptoms.gingivalBleedingDischarge == 2) {
        $scope.gingivalBleedingDischarge = '中度';
      } else if (symptoms.gingivalBleedingDischarge == 3) {
        $scope.gingivalBleedingDischarge = '重度';
      } else if (symptoms.gingivalBleedingDischarge == 4) {
        $scope.gingivalBleedingDischarge = '不详';
      }

      if (symptoms.epistaxis == 1) {
        $scope.epistaxis = '轻度';
      } else if (symptoms.epistaxis == 2) {
        $scope.epistaxis = '中度';
      } else if (symptoms.epistaxis == 3) {
        $scope.epistaxis = '重度';
      } else if (symptoms.epistaxis == 4) {
        $scope.epistaxis = '不详';
      }

      if (symptoms.epistaxisDischarge == 1) {
        $scope.epistaxisDischarge = '轻度';
      } else if (symptoms.epistaxisDischarge == 2) {
        $scope.epistaxisDischarge = '中度';
      } else if (symptoms.epistaxisDischarge == 3) {
        $scope.epistaxisDischarge = '重度';
      } else if (symptoms.epistaxisDischarge == 4) {
        $scope.epistaxisDischarge = '不详';
      }

      if (symptoms.liverPain == 1) {
        $scope.liverPain = '轻度';
      } else if (symptoms.liverPain == 2) {
        $scope.liverPain = '中度';
      } else if (symptoms.liverPain == 3) {
        $scope.liverPain = '重度';
      } else if (symptoms.liverPain == 4) {
        $scope.liverPain = '不详';
      }

      if (symptoms.liverPainDischarge == 1) {
        $scope.liverPainDischarge = '轻度';
      } else if (symptoms.liverPainDischarge == 2) {
        $scope.liverPainDischarge = '中度';
      } else if (symptoms.liverPainDischarge == 3) {
        $scope.liverPainDischarge = '重度';
      } else if (symptoms.liverPainDischarge == 4) {
        $scope.liverPainDischarge = '不详';
      }

      if (symptoms.hepatomegaly == 1) {
        $scope.hepatomegaly = '轻度';
      } else if (symptoms.hepatomegaly == 2) {
        $scope.hepatomegaly = '中度';
      } else if (symptoms.hepatomegaly == 3) {
        $scope.hepatomegaly = '重度';
      } else if (symptoms.hepatomegaly == 4) {
        $scope.hepatomegaly = '不详';
      }

      if (symptoms.hepatomegalyDischarge == 1) {
        $scope.hepatomegalyDischarge = '轻度';
      } else if (symptoms.hepatomegalyDischarge == 2) {
        $scope.hepatomegalyDischarge = '中度';
      } else if (symptoms.hepatomegalyDischarge == 3) {
        $scope.hepatomegalyDischarge = '重度';
      } else if (symptoms.hepatomegalyDischarge == 4) {
        $scope.hepatomegalyDischarge = '不详';
      }

      if (symptoms.splenomegaly == 1) {
        $scope.splenomegaly = '轻度';
      } else if (symptoms.splenomegaly == 2) {
        $scope.splenomegaly = '中度';
      } else if (symptoms.splenomegaly == 3) {
        $scope.splenomegaly = '重度';
      } else if (symptoms.splenomegaly == 4) {
        $scope.splenomegaly = '不详';
      }

      if (symptoms.splenomegalyDischarge == 1) {
        $scope.splenomegalyDischarge = '轻度';
      } else if (symptoms.splenomegalyDischarge == 2) {
        $scope.splenomegalyDischarge = '中度';
      } else if (symptoms.splenomegalyDischarge == 3) {
        $scope.splenomegalyDischarge = '重度';
      } else if (symptoms.splenomegalyDischarge == 4) {
        $scope.splenomegalyDischarge = '不详';
      }

      if (symptoms.fever == 1) {
        $scope.fever = '轻度';
      } else if (symptoms.fever == 2) {
        $scope.fever = '中度';
      } else if (symptoms.fever == 3) {
        $scope.fever = '重度';
      } else if (symptoms.fever == 4) {
        $scope.fever = '不详';
      }

      if (symptoms.feverDischarge == 1) {
        $scope.feverDischarge = '轻度';
      } else if (symptoms.feverDischarge == 2) {
        $scope.feverDischarge = '中度';
      } else if (symptoms.feverDischarge == 3) {
        $scope.feverDischarge = '重度';
      } else if (symptoms.feverDischarge == 4) {
        $scope.feverDischarge = '不详';
      }

      if (symptoms.rash == 1) {
        $scope.rash = '轻度';
      } else if (symptoms.rash == 2) {
        $scope.rash = '中度';
      } else if (symptoms.rash == 3) {
        $scope.rash = '重度';
      } else if (symptoms.rash == 4) {
        $scope.rash = '不详';
      }

      if (symptoms.rashDischarge == 1) {
        $scope.rashDischarge = '轻度';
      } else if (symptoms.rashDischarge == 2) {
        $scope.rashDischarge = '中度';
      } else if (symptoms.rashDischarge == 3) {
        $scope.rashDischarge = '重度';
      } else if (symptoms.rashDischarge == 4) {
        $scope.rashDischarge = '不详';
      }

      if (symptoms.arthralgia == 1) {
        $scope.arthralgia = '轻度';
      } else if (symptoms.arthralgia == 2) {
        $scope.arthralgia = '中度';
      } else if (symptoms.arthralgia == 3) {
        $scope.arthralgia = '重度';
      } else if (symptoms.arthralgia == 4) {
        $scope.arthralgia = '不详';
      }

      if (symptoms.arthralgiaDischarge == 1) {
        $scope.arthralgiaDischarge = '轻度';
      } else if (symptoms.arthralgiaDischarge == 2) {
        $scope.arthralgiaDischarge = '中度';
      } else if (symptoms.arthralgiaDischarge == 3) {
        $scope.arthralgiaDischarge = '重度';
      } else if (symptoms.arthralgiaDischarge == 4) {
        $scope.arthralgiaDischarge = '不详';
      }

      if (symptoms.skinItch == 1) {
        $scope.skinItch = '轻度';
      } else if (symptoms.skinItch == 2) {
        $scope.skinItch = '中度';
      } else if (symptoms.skinItch == 3) {
        $scope.skinItch = '重度';
      } else if (symptoms.skinItch == 4) {
        $scope.skinItch = '不详';
      }

      if (symptoms.skinItchDischarge == 1) {
        $scope.skinItchDischarge = '轻度';
      } else if (symptoms.skinItchDischarge == 2) {
        $scope.skinItchDischarge = '中度';
      } else if (symptoms.skinItchDischarge == 3) {
        $scope.skinItchDischarge = '重度';
      } else if (symptoms.skinItchDischarge == 4) {
        $scope.skinItchDischarge = '不详';
      }

      $scope.weakBeginDate = symptoms.weakBeginDate;
      $scope.weakDisappearDate = symptoms.weakDisappearDate;
      $scope.anorexiaBeginDate = symptoms.anorexiaBeginDate;
      $scope.anorexiaDisappearDate = symptoms.anorexiaDisappearDate;
      $scope.abdominalDistentionBeginDate = symptoms.abdominalDistentionBeginDate;
      $scope.abdominalDistentionDisappearDate = symptoms.abdominalDistentionDisappearDate;
      $scope.jaundiceBeginDate = symptoms.jaundiceBeginDate;
      $scope.jaundiceDisappearDate = symptoms.jaundiceDisappearDate;
      $scope.nauseaBeginDate = symptoms.nauseaBeginDate;
      $scope.nauseaDisappearDate = symptoms.nauseaDisappearDate;
      $scope.vomitBeginDate = symptoms.vomitBeginDate;
      $scope.vomitDisappearDate = symptoms.vomitDisappearDate;
      $scope.gingivalBleedingBeginDate = symptoms.gingivalBleedingBeginDate;
      $scope.gingivalBleedingDisappearDate = symptoms.gingivalBleedingDisappearDate;
      $scope.epistaxisBeginDate = symptoms.epistaxisBeginDate;
      $scope.epistaxisDisappearDate = symptoms.epistaxisDisappearDate;
      $scope.liverPainBeginDate = symptoms.liverPainBeginDate;
      $scope.liverPainDisappearDate = symptoms.liverPainDisappearDate;
      $scope.hepatomegalyBeginDate = symptoms.hepatomegalyBeginDate;
      $scope.hepatomegalyDisappearDate = symptoms.hepatomegalyDisappearDate;
      $scope.splenomegalyBeginDate = symptoms.splenomegalyBeginDate;
      $scope.splenomegalyDisappearDate = symptoms.splenomegalyDisappearDate;
      $scope.feverBeginDate = symptoms.feverBeginDate;
      $scope.feverDisappearDate = symptoms.feverDisappearDate;
      $scope.rashBeginDate = symptoms.rashBeginDate;
      $scope.rashDisappearDate = symptoms.rashDisappearDate;
      $scope.arthralgiaBeginDate = symptoms.arthralgiaBeginDate;
      $scope.arthralgiaDisappearDate = symptoms.arthralgiaDisappearDate;
      $scope.skinItchBeginDate = symptoms.skinItchBeginDate;
      $scope.skinItchDisappearDate = symptoms.skinItchDisappearDate;
    }

    function getFirst() {
      $http({
        method: 'GET',
        url: '/api/mlfae/first/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var first = response.data;
        $scope.tab1CheckDate = first.tab1CheckDate;
        $scope.tab2CheckDate = first.tab2CheckDate;
        $scope.tab3CheckDate = first.tab3CheckDate;
        $scope.tab4CheckDate = first.tab4CheckDate;
        $scope.tab5CheckDate = first.tab5CheckDate;
        $scope.alt = first.alt;
        $scope.ast = first.ast;
        $scope.ggt = first.ggt;
        $scope.alp = first.alp;
        $scope.bileAcid = first.bileAcid;
        $scope.tbil = first.tbil;
        $scope.dbil = first.dbil;
        $scope.tp = first.tp;
        $scope.alb = first.alb;
        $scope.scr = first.scr;
        $scope.bun = first.bun;
        $scope.plasmaGlucose = first.plasmaGlucose;
        $scope.pt = first.pt;
        $scope.inr = first.inr;
        $scope.afp = first.afp;
      });
    }


    function getHosData() {
      $http({
        method: 'GET',
        url: '/api/mlfae/hos/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var hos = response.data;
        $scope._tab1CheckDate = hos.tab1CheckDate;
        $scope._tab2CheckDate = hos.tab2CheckDate;
        $scope._tab3CheckDate = hos.tab3CheckDate;
        $scope._tab4CheckDate = hos.tab4CheckDate;
        $scope._tab5CheckDate = hos.tab5CheckDate;
        $scope._alt = hos.alt;
        $scope._ast = hos.ast;
        $scope._ggt = hos.ggt;
        $scope._alp = hos.alp;
        $scope._bileAcid = hos.bileAcid;
        $scope._tbil = hos.tbil;
        $scope._dbil = hos.dbil;
        $scope._tp = hos.tp;
        $scope._alb = hos.alb;
        $scope._scr = hos.scr;
        $scope._bun = hos.bun;
        $scope._plasmaGlucose = hos.plasmaGlucose;
        $scope._pt = hos.pt;
        $scope._inr = hos.inr;
        $scope._afp = hos.afp;
      });

    }


    function getExcludeOther() {
      $http({
        method: 'GET',
        url: '/api/exclude/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var exclude = response.data;
        if (exclude.antiHav == '1') {
          $scope.antiHav = '阴性';
        } else if (exclude.antiHav == '2') {
          $scope.antiHav = '阳性';
        } else if (exclude.antiHav == '3') {
          $scope.antiHav = '未做';
        } else if (exclude.antiHav == '4') {
          $scope.antiHav = '不详';
        } else if (exclude.antiHav == '5') {
          $scope.antiHav = '其他';
        }

        if (exclude.hbvdna == '1') {
          $scope.hbvdna = '阴性';
        } else if (exclude.hbvdna == '2') {
          $scope.hbvdna = '阳性';
        } else if (exclude.hbvdna == '3') {
          $scope.hbvdna = '未做';
        } else if (exclude.hbvdna == '4') {
          $scope.hbvdna = '不详';
        } else if (exclude.hbvdna == '5') {
          $scope.hbvdna = '其他';
        }

        if (exclude.antihcv == '1') {
          $scope.antihcv = '阴性';
        } else if (exclude.antihcv == '2') {
          $scope.antihcv = '阳性';
        } else if (exclude.antihcv == '3') {
          $scope.antihcv = '未做';
        } else if (exclude.antihcv == '4') {
          $scope.antihcv = '不详';
        } else if (exclude.antihcv == '5') {
          $scope.antihcv = '其他';
        }

        if (exclude.hcvrna == '1') {
          $scope.hcvrna = '阴性';
        } else if (exclude.hcvrna == '2') {
          $scope.hcvrna = '阳性';
        } else if (exclude.hcvrna == '3') {
          $scope.hcvrna = '未做';
        } else if (exclude.hcvrna == '4') {
          $scope.hcvrna = '不详';
        } else if (exclude.hcvrna == '5') {
          $scope.hcvrna = '其他';
        }

        if (exclude.mononucleosis == '1') {
          $scope.mononucleosis = '阴性';
        } else if (exclude.mononucleosis == '2') {
          $scope.mononucleosis = '阳性';
        } else if (exclude.mononucleosis == '3') {
          $scope.mononucleosis = '未做';
        } else if (exclude.mononucleosis == '4') {
          $scope.mononucleosis = '不详';
        } else if (exclude.mononucleosis == '5') {
          $scope.mononucleosis = '其他';
        }

        if (exclude.rheumatoid == '1') {
          $scope.rheumatoid = '阴性';
        } else if (exclude.rheumatoid == '2') {
          $scope.rheumatoid = '阳性';
        } else if (exclude.rheumatoid == '3') {
          $scope.rheumatoid = '未做';
        } else if (exclude.rheumatoid == '4') {
          $scope.rheumatoid = '不详';
        } else if (exclude.rheumatoid == '5') {
          $scope.rheumatoid = '其他';
        }

        if (exclude.ceruloplasmin == '1') {
          $scope.ceruloplasmin = '阴性';
        } else if (exclude.ceruloplasmin == '2') {
          $scope.ceruloplasmin = '阳性';
        } else if (exclude.ceruloplasmin == '3') {
          $scope.ceruloplasmin = '未做';
        } else if (exclude.ceruloplasmin == '4') {
          $scope.ceruloplasmin = '不详';
        } else if (exclude.ceruloplasmin == '5') {
          $scope.ceruloplasmin = '其他';
        }

        $scope.antiHavDate = exclude.antiHavDate;
        $scope.hbvdnaDate = exclude.hbvdnaDate;
        $scope.antihcvDate = exclude.antihcvDate;
        $scope.hcvrnaDate = exclude.hcvrnaDate;
        $scope.mononucleosisDate = exclude.mononucleosisDate;
        $scope.rheumatoidDate = exclude.rheumatoidDate;
        $scope.ceruloplasminDate = exclude.ceruloplasminDate;

        if (exclude.hbsag == '1') {
          $scope.hbsag = '阴性';
        } else if (exclude.hbsag == '2') {
          $scope.hbsag = '阳性';
        } else if (exclude.hbsag == '3') {
          $scope.hbsag = '未做';
        } else if (exclude.hbsag == '4') {
          $scope.hbsag = '不详';
        } else if (exclude.hbsag == '5') {
          $scope.hbsag = '其他';
        }

        if (exclude.hbsab == '1') {
          $scope.hbsab = '阴性';
        } else if (exclude.hbsab == '2') {
          $scope.hbsab = '阳性';
        } else if (exclude.hbsab == '3') {
          $scope.hbsab = '未做';
        } else if (exclude.hbsab == '4') {
          $scope.hbsab = '不详';
        } else if (exclude.hbsab == '5') {
          $scope.hbsab = '其他';
        }

        if (exclude.hbcab == '1') {
          $scope.hbcab = '阴性';
        } else if (exclude.hbcab == '2') {
          $scope.hbcab = '阳性';
        } else if (exclude.hbcab == '3') {
          $scope.hbcab = '未做';
        } else if (exclude.hbcab == '4') {
          $scope.hbcab = '不详';
        } else if (exclude.hbcab == '5') {
          $scope.hbcab = '其他';
        }

        if (exclude.hbeag == '1') {
          $scope.hbeag = '阴性';
        } else if (exclude.hbeag == '2') {
          $scope.hbeag = '阳性';
        } else if (exclude.hbeag == '3') {
          $scope.hbeag = '未做';
        } else if (exclude.hbeag == '4') {
          $scope.hbeag = '不详';
        } else if (exclude.hbeag == '5') {
          $scope.hbeag = '其他';
        }

        if (exclude.hbeab == '1') {
          $scope.hbeab = '阴性';
        } else if (exclude.hbeab == '2') {
          $scope.hbeab = '阳性';
        } else if (exclude.hbeab == '3') {
          $scope.hbeab = '未做';
        } else if (exclude.hbeab == '4') {
          $scope.hbeab = '不详';
        } else if (exclude.hbeab == '5') {
          $scope.hbeab = '其他';
        }

        $scope.hepatitisBFiveDate = exclude.hepatitisBFiveDate;

        if (exclude.ana == '1') {
          $scope.ana = '阴性';
        } else if (exclude.ana == '2') {
          $scope.ana = '阳性';
        } else if (exclude.ana == '3') {
          $scope.ana = '未做';
        } else if (exclude.ana == '4') {
          $scope.ana = '不详';
        } else if (exclude.ana == '5') {
          $scope.ana = '其他';
        }

        if (exclude.ama == '1') {
          $scope.ama = '阴性';
        } else if (exclude.ama == '2') {
          $scope.ama = '阳性';
        } else if (exclude.ama == '3') {
          $scope.ama = '未做';
        } else if (exclude.ama == '4') {
          $scope.ama = '不详';
        } else if (exclude.ama == '5') {
          $scope.ama = '其他';
        }

        if (exclude.amam2 == '1') {
          $scope.amam2 = '阴性';
        } else if (exclude.amam2 == '2') {
          $scope.amam2 = '阳性';
        } else if (exclude.amam2 == '3') {
          $scope.amam2 = '未做';
        } else if (exclude.amam2 == '4') {
          $scope.amam2 = '不详';
        } else if (exclude.amam2 == '5') {
          $scope.amam2 = '其他';
        }

        if (exclude.sma == '1') {
          $scope.sma = '阴性';
        } else if (exclude.sma == '2') {
          $scope.sma = '阳性';
        } else if (exclude.sma == '3') {
          $scope.sma = '未做';
        } else if (exclude.sma == '4') {
          $scope.sma = '不详';
        } else if (exclude.sma == '5') {
          $scope.sma = '其他';
        }

        if (exclude.lkm == '1') {
          $scope.lkm = '阴性';
        } else if (exclude.lkm == '2') {
          $scope.lkm = '阳性';
        } else if (exclude.lkm == '3') {
          $scope.lkm = '未做';
        } else if (exclude.lkm == '4') {
          $scope.lkm = '不详';
        } else if (exclude.lkm == '5') {
          $scope.lkm = '其他';
        }

        if (exclude.cytomegalovirus == '1') {
          $scope.cytomegalovirus = '阴性';
        } else if (exclude.cytomegalovirus == '2') {
          $scope.cytomegalovirus = '阳性';
        } else if (exclude.cytomegalovirus == '3') {
          $scope.cytomegalovirus = '未做';
        } else if (exclude.cytomegalovirus == '4') {
          $scope.cytomegalovirus = '不详';
        } else if (exclude.cytomegalovirus == '5') {
          $scope.cytomegalovirus = '其他';
        }

        if (exclude.ebviruses == '1') {
          $scope.ebviruses = '阴性';
        } else if (exclude.ebviruses == '2') {
          $scope.ebviruses = '阳性';
        } else if (exclude.ebviruses == '3') {
          $scope.ebviruses = '未做';
        } else if (exclude.ebviruses == '4') {
          $scope.ebviruses = '不详';
        } else if (exclude.ebviruses == '5') {
          $scope.ebviruses = '其他';
        }

        if (exclude.herpesSimplex == '1') {
          $scope.herpesSimplex = '阴性';
        } else if (exclude.herpesSimplex == '2') {
          $scope.herpesSimplex = '阳性';
        } else if (exclude.herpesSimplex == '3') {
          $scope.herpesSimplex = '未做';
        } else if (exclude.herpesSimplex == '4') {
          $scope.herpesSimplex = '不详';
        } else if (exclude.herpesSimplex == '5') {
          $scope.herpesSimplex = '其他';
        }

        $scope.autoimmuneAntibodyDate = exclude.autoimmuneAntibodyDate;


      });
    }


    function getBlood() {
      $http({
        method: 'GET',
        url: '/api/routineBlood/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayBlood(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/treatment/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.treatFollowList = response.data;
      // });
    }

    function displayBlood(response) {
      var blood = response.data;
      $scope.wbc = blood.wbc;
      $scope.hb = blood.hb;
      $scope.totalHemoglobin = blood.totalHemoglobin;
      $scope.plt = blood.plt;
      $scope.neutrophil = blood.neutrophil;
      $scope.eosinophil = blood.eosinophil;
      $scope.routineBloodDate = blood.routineBloodDate;
    }

    function getEndos() {
      $http({
        method: 'GET',
        url: '/api/iesc/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayEndos(response);
      });

      // $http({
      //   method: 'GET',
      //   url: '/api/medicine/follow/' + sessionStorage.getItem('patientId')
      // }).then(function success(response) {
      //   $scope.medicineFollowList = response.data;
      // });
    }

    function displayEndos(response) {
      var endos = response.data;
      $scope.liverBultrasoundDate = endos.liverBultrasoundDate;
      $scope.image = '/api/image/' + endos.image + '.jpg';
      $scope.imageDescribe = endos.imageDescribe;
      if (endos.liverBultrasound == '1') {
        $scope.liverBultrasound = '肝表面光滑，边缘锐，血管走向清晰';
      } else if (endos.liverBultrasound == '2') {
        $scope.liverBultrasound = '肝表面光滑，回声增粗、增强、分布尚均匀，血管走向清晰';
      } else if (endos.liverBultrasound == '3') {
        $scope.liverBultrasound = '肝表面欠光滑，边缘变钝，回声增粗、增强且分布不均匀，血管走向尚清晰';
      } else if (endos.liverBultrasound == '4') {
        $scope.liverBultrasound = '肝表面粗糙、不规则，回声增密、增粗、增强且分布不均匀，血管走向欠清晰';
      } else if (endos.liverBultrasound == '5') {
        $scope.liverBultrasound = '肝表面呈波浪状（或锯齿状），肝回声增粗、增强且分布不均匀、呈结节状(或斑片状)，肝缘钝化，肝内血管狭窄或粗细不等';
      }

      if (endos.liverBultrasoundBiliaryTract == '1') {
        $scope.liverBultrasoundBiliaryTract = '是';
      } else if (endos.liverBultrasoundBiliaryTract == '2') {
        $scope.liverBultrasoundBiliaryTract = '否';
      } else if (endos.liverBultrasoundBiliaryTract == '3') {
        $scope.liverBultrasoundBiliaryTract = '不适用';
      } else if (endos.liverBultrasoundBiliaryTract == '4') {
        $scope.liverBultrasoundBiliaryTract = '其他';
      }

      if (endos.liverBultrasoundEsophagealGastricVarices == '1') {
        $scope.liverBultrasoundEsophagealGastricVarices = '是';
      } else if (endos.liverBultrasoundEsophagealGastricVarices == '2') {
        $scope.liverBultrasoundEsophagealGastricVarices = '否';
      } else if (endos.liverBultrasoundEsophagealGastricVarices == '3') {
        $scope.liverBultrasoundEsophagealGastricVarices = '不适用';
      } else if (endos.liverBultrasoundEsophagealGastricVarices == '4') {
        $scope.liverBultrasoundEsophagealGastricVarices = '其他';
      }

      if (endos.liverCtBiliaryTract == '1') {
        $scope.liverCtBiliaryTract = '是';
      } else if (endos.liverCtBiliaryTract == '2') {
        $scope.liverCtBiliaryTract = '否';
      } else if (endos.liverCtBiliaryTract == '3') {
        $scope.liverCtBiliaryTract = '不适用';
      } else if (endos.liverCtBiliaryTract == '4') {
        $scope.liverCtBiliaryTract = '其他';
      }

      if (endos.liverCtEsophagealGastricVarices == '1') {
        $scope.liverCtEsophagealGastricVarices = '是';
      } else if (endos.liverCtEsophagealGastricVarices == '2') {
        $scope.liverCtEsophagealGastricVarices = '否';
      } else if (endos.liverCtEsophagealGastricVarices == '3') {
        $scope.liverCtEsophagealGastricVarices = '不适用';
      } else if (endos.liverCtEsophagealGastricVarices == '4') {
        $scope.liverCtEsophagealGastricVarices = '其他';
      }

      if (endos.liverMriBiliaryTract == '1') {
        $scope.liverMriBiliaryTract = '是';
      } else if (endos.liverMriBiliaryTract == '2') {
        $scope.liverMriBiliaryTract = '否';
      } else if (endos.liverMriBiliaryTract == '3') {
        $scope.liverMriBiliaryTract = '不适用';
      } else if (endos.liverMriBiliaryTract == '4') {
        $scope.liverMriBiliaryTract = '其他';
      }

      if (endos.liverMriEsophagealGastricVarices == '1') {
        $scope.liverMriEsophagealGastricVarices = '是';
      } else if (endos.liverMriEsophagealGastricVarices == '2') {
        $scope.liverMriEsophagealGastricVarices = '否';
      } else if (endos.liverMriEsophagealGastricVarices == '3') {
        $scope.liverMriEsophagealGastricVarices = '不适用';
      } else if (endos.liverMriEsophagealGastricVarices == '4') {
        $scope.liverMriEsophagealGastricVarices = '其他';
      }

      if (endos.fibroscanBiliaryTract == '1') {
        $scope.fibroscanBiliaryTract = '是';
      } else if (endos.fibroscanBiliaryTract == '2') {
        $scope.fibroscanBiliaryTract = '否';
      } else if (endos.fibroscanBiliaryTract == '3') {
        $scope.fibroscanBiliaryTract = '不适用';
      } else if (endos.fibroscanBiliaryTract == '4') {
        $scope.fibroscanBiliaryTract = '其他';
      }

      if (endos.fibroscanEsophagealGastricVarices == '1') {
        $scope.fibroscanEsophagealGastricVarices = '是';
      } else if (endos.fibroscanEsophagealGastricVarices == '2') {
        $scope.fibroscanEsophagealGastricVarices = '否';
      } else if (endos.fibroscanEsophagealGastricVarices == '3') {
        $scope.fibroscanEsophagealGastricVarices = '不适用';
      } else if (endos.fibroscanEsophagealGastricVarices == '4') {
        $scope.fibroscanEsophagealGastricVarices = '其他';
      }

      if (endos.ercpBiliaryTract == '1') {
        $scope.ercpBiliaryTract = '是';
      } else if (endos.ercpBiliaryTract == '2') {
        $scope.ercpBiliaryTract = '否';
      } else if (endos.ercpBiliaryTract == '3') {
        $scope.ercpBiliaryTract = '不适用';
      } else if (endos.ercpBiliaryTract == '4') {
        $scope.ercpBiliaryTract = '其他';
      }

      if (endos.ercpEsophagealGastricVarices == '1') {
        $scope.ercpEsophagealGastricVarices = '是';
      } else if (endos.ercpEsophagealGastricVarices == '2') {
        $scope.ercpEsophagealGastricVarices = '否';
      } else if (endos.ercpEsophagealGastricVarices == '3') {
        $scope.ercpEsophagealGastricVarices = '不适用';
      } else if (endos.ercpEsophagealGastricVarices == '4') {
        $scope.ercpEsophagealGastricVarices = '其他';
      }

      if (endos.mrcpBiliaryTract == '1') {
        $scope.mrcpBiliaryTract = '是';
      } else if (endos.mrcpBiliaryTract == '2') {
        $scope.mrcpBiliaryTract = '否';
      } else if (endos.mrcpBiliaryTract == '3') {
        $scope.mrcpBiliaryTract = '不适用';
      } else if (endos.mrcpEsophagealGastricVarices == '4') {
        $scope.mrcpEsophagealGastricVarices = '其他';
      }

      if (endos.mrcpEsophagealGastricVarices == '1') {
        $scope.mrcpEsophagealGastricVarices = '是';
      } else if (endos.mrcpEsophagealGastricVarices == '2') {
        $scope.mrcpEsophagealGastricVarices = '否';
      } else if (endos.mrcpEsophagealGastricVarices == '3') {
        $scope.mrcpEsophagealGastricVarices = '不适用';
      } else if (endos.mrcpEsophagealGastricVarices == '4') {
        $scope.mrcpEsophagealGastricVarices = '其他';
      }

      if (endos.gastroscopeBiliaryTract == '1') {
        $scope.gastroscopeBiliaryTract = '是';
      } else if (endos.gastroscopeBiliaryTract == '2') {
        $scope.gastroscopeBiliaryTract = '否';
      } else if (endos.gastroscopeBiliaryTract == '3') {
        $scope.gastroscopeBiliaryTract = '不适用';
      } else if (endos.gastroscopeBiliaryTract == '4') {
        $scope.gastroscopeBiliaryTract = '其他';
      }

      if (endos.gastroscopeEsophagealGastricVarices == '1') {
        $scope.gastroscopeEsophagealGastricVarices = '是';
      } else if (endos.gastroscopeEsophagealGastricVarices == '2') {
        $scope.gastroscopeEsophagealGastricVarices = '否';
      } else if (endos.gastroscopeEsophagealGastricVarices == '3') {
        $scope.gastroscopeEsophagealGastricVarices = '不适用';
      } else if (endos.gastroscopeEsophagealGastricVarices == '4') {
        $scope.gastroscopeEsophagealGastricVarices = '其他';
      }

      $scope.liverBultrasoundDate = endos.liverBultrasoundDate;
      $scope.liverCtDate = endos.liverCtDate;
      $scope.liverCt = endos.liverCt;
      $scope.liverMriDate = endos.liverMriDate;
      $scope.liverMri = endos.liverMri;
      $scope.fibroscanDate = endos.fibroscanDate;
      $scope.fibroscan = endos.fibroscan;
      $scope.ercpDate = endos.ercpDate;
      $scope.ercp = endos.ercp;
      $scope.mrcpDate = endos.mrcpDate;
      $scope.mrcp = endos.mrcp;
      $scope.gastroscopeDate = endos.gastroscopeDate;
      $scope.gastroscope = endos.gastroscope;

    }

    function getLiverHistological() {
      $http({
        method: 'GET',
        url: '/api/mlLiverHistological/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayHistological(response);
      });
    }

    function displayHistological(response) {
      var histological = response.data;
      $scope.liverHistologicalDate = histological.liverHistologicalDate;
      $scope.liverHistologicalResult = histological.liverHistologicalResult;
    }

    function getLiverInjury() {
      $http({
        method: 'GET',
        url: '/api/mlLiverInjury/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayLiverInjury(response);
      });
    }

    function displayLiverInjury(response) {
      var liverInjury = response.data;
      if (liverInjury.ascites == '1') {
        $scope.ascites = '是';
      } else if (liverInjury.ascites == '2') {
        $scope.ascites = '否';
      } else if (liverInjury.ascites == '3') {
        $scope.ascites = '未知';
      }

      if (liverInjury.hepaticEncephalopathy == '1') {
        $scope.hepaticEncephalopathy = '是';
      } else if (liverInjury.hepaticEncephalopathy == '2') {
        $scope.hepaticEncephalopathy = '否';
      } else if (liverInjury.hepaticEncephalopathy == '3') {
        $scope.hepaticEncephalopathy = '未知';
      }

      if (liverInjury.extendInr == '1') {
        $scope.extendInr = '是';
      } else if (liverInjury.extendInr == '2') {
        $scope.extendInr = '否';
      } else if (liverInjury.extendInr == '3') {
        $scope.extendInr = '未知';
      }

      if (liverInjury.failure == '1') {
        $scope.failure = '是';
      } else if (liverInjury.failure == '2') {
        $scope.failure = '否';
      } else if (liverInjury.failure == '3') {
        $scope.failure = '未知';
      }

      if (liverInjury.extendHospitalStay == '1') {
        $scope.extendHospitalStay = '是';
      } else if (liverInjury.extendHospitalStay == '2') {
        $scope.extendHospitalStay = '否';
      } else if (liverInjury.extendHospitalStay == '3') {
        $scope.extendHospitalStay = '未知';
      }

      $scope.rucam = liverInjury.rucam;
    }

    function getTreatment() {
      $http({
        method: 'GET',
        url: '/api/mlTreatment/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayTreatment(response);
      });
    }

    function displayTreatment(response) {
      var treatment = response.data;
      $scope.treatment = treatment.treatment;
      $scope.treatmentDetails = treatment.medicineLiverTreatmentDetailDTOS;
      $scope.treatmentOthers = treatment.medicineLiverTreatmentOtherDTOS;
    }

    function getOutcome() {
      $http({
        method: 'GET',
        url: '/api/diseaseOutcome/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displayOutcome(response);
      });
    }

    function displayOutcome(response) {
      $scope.outcome = response.data.outcome;
    }


    function getSample() {
      $http({
        method: 'GET',
        url: '/api/mlBiologicalSamples/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        displaySample(response);
      });
    }

    function displaySample(response) {
      $scope.biologicalSamples = response.data.biologicalSamples;
    }


  }]);