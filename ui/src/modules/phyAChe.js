'use strict';

import angular from 'angular';
import ngFileUpload from 'ng-file-upload';
import '../entries/main.js';

var phyAChe = angular.module('phyAChe', ['main', ngFileUpload]);

phyAChe.controller('phyACheController', ['$scope', '$http', '$rootScope', '$state', 'Upload', 'localStorageService', function($scope, $http, $rootScope, $state, Upload, localStorageService) {
  loginStatus();
  $scope.judgeGoHome();
  var physicalChemicalInspection = {};
  $scope.modalContent = '您确定要保存吗？';
  $scope.tabTitle = '肝功能';
  getPatientInfo();
  $scope.changeMenuStatus();
  $scope.addTabActive = function(str1, str2) {
    $('.tab-pane').removeClass('active');
    $(str1).addClass('active');
    $scope.tabTitle = str2;
    // $scope.tabTitle = $(str).val;
  };

  $('#datepicker').datepicker({
    autoclose: true
  });

  $scope.showSaveModal = function() {
    saveImg($scope.image);
    $('#saveModal').modal('show');
  };

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }

  $scope.$watch('follow', function() {
    if ($scope.follow) {
      $scope.followDateShow = true;
      $scope.totalBileAcid = undefined;
      $scope.liverFunctionAlbumin = undefined;
      $scope.liverFunctionGlobulin = undefined;
      $scope.liverFunctionALT = undefined;
      $scope.liverFunctionAST = undefined;
      $scope.liverFunctionGGT = undefined;
      $scope.liverFunctionALP = undefined;
      $scope.liverFunctionTotalCholesterol = undefined;
      $scope.liverFunctionTotalBilirubin = undefined;
      $scope.liverFunctionDirectBilirubin = undefined;
      $scope.liverFunctionRglobulin = undefined;
      $scope.renalFunctionBUN = undefined;
      $scope.renalFunctionCr = undefined;
      $scope.clottingPT = undefined;
      $scope.clottingINR = undefined;
      $scope.bloodRoutineRBC = undefined;
      $scope.bloodRoutineHb = undefined;
      $scope.bloodRoutineWBC = undefined;
      $scope.bloodRoutineNeutrophils = undefined;
      $scope.bloodRoutineLymphocytes = undefined;
      $scope.bloodRoutineEosinophils = undefined;
      $scope.bloodRoutinePlatelets = undefined;
      $scope.liverDiseaseAutoantibodiesAMA = undefined;
      $scope.liverDiseaseAutoantibodiesAMAM2 = undefined;
      $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody = undefined;
      $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies = undefined;
      $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen = undefined;
      $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen = undefined;
      $scope.liverDiseaseAutoantibodiesOther = undefined;
      $scope.anaHomogeneous = undefined;
      $scope.anaParticle = undefined;
      $scope.anaPeripheral = undefined;
      $scope.anaNucleolus = undefined;
      $scope.anaNucleolusEnhancement = undefined;
      $scope.anaNuclear = undefined;
      $scope.anaCentromere = undefined;
      $scope.anaOther = undefined;
      $scope.humoralImmunityIgG = undefined;
      $scope.humoralImmunityIgA = undefined;
      $scope.humoralImmunityIgM = undefined;
      $scope.humoralImmunityImmuneComplexf = undefined;
      $scope.humoralImmunityComplementC3 = undefined;
      $scope.humoralImmunityComplementC4 = undefined;
      $scope.humoralImmunityIgE = undefined;
      $scope.humoralImmunityKlightChain = undefined;
      $scope.cellularImmunityCD3 = undefined;
      $scope.cellularImmunityCD4 = undefined;
      $scope.cellularImmunityCD8 = undefined;
      $scope.cellularImmunityCD56 = undefined;
      $scope.cellularImmunityCD2 = undefined;
      $scope.humoralImmunityNlightChain = undefined;
      $scope.cellularImmunityCD4CD8 = undefined;
      $scope.rheumaticImmuneRelatedAntibodies = undefined;
      $scope.cTMRI = undefined;
      $scope.liverHardnessFibroscan = undefined;
      $scope.liverHardnessFibrotest = undefined;
      $scope.liverPuncturePathology = undefined;
      $scope.copperProtein = undefined;
      $scope.aFP = undefined;
      $scope.carcinoembryonicAntigenCEA = undefined;
      $scope.ca125 = undefined;
      $scope.hbsag = undefined;
      $scope.hbsab = undefined;
      $scope.hbeag = undefined;
      $scope.hbeab = undefined;
      $scope.hbcab = undefined;
      $scope.hbvRna = undefined;
      $scope.antiHCVantibody = undefined;
      $scope.hcvRna = undefined;
      $scope.protein = undefined;
      $scope.redBloodCell = undefined;
      $scope.whiteBloodCell = undefined;
      $scope.bilirubin = undefined;
      $scope.ca199 = undefined;
    } else {
      $scope.followDateShow = false;
      getPhy();
    }
  });


  //get patientInfo by id
  getPhy();

  //save some messages
  $scope.saveSomeMessage = function() {
    physicalChemicalInspection.totalBileAcid = $scope.totalBileAcid;
    physicalChemicalInspection.patientId = sessionStorage.getItem('patientId');
    physicalChemicalInspection.liverFunctionAlbumin = $scope.liverFunctionAlbumin;
    physicalChemicalInspection.liverFunctionGlobulin = $scope.liverFunctionGlobulin;
    physicalChemicalInspection.liverFunctionALT = $scope.liverFunctionALT;
    physicalChemicalInspection.liverFunctionAST = $scope.liverFunctionAST;
    physicalChemicalInspection.liverFunctionGGT = $scope.liverFunctionGGT;
    physicalChemicalInspection.liverFunctionALP = $scope.liverFunctionALP;
    physicalChemicalInspection.liverFunctionTotalCholesterol = $scope.liverFunctionTotalCholesterol;
    physicalChemicalInspection.liverFunctionTotalBilirubin = $scope.liverFunctionTotalBilirubin;
    physicalChemicalInspection.liverFunctionDirectBilirubin = $scope.liverFunctionDirectBilirubin;
    physicalChemicalInspection.liverFunctionRglobulin = $scope.liverFunctionRglobulin;
    physicalChemicalInspection.renalFunctionBUN = $scope.renalFunctionBUN;
    physicalChemicalInspection.renalFunctionCr = $scope.renalFunctionCr;
    physicalChemicalInspection.clottingPT = $scope.clottingPT;
    physicalChemicalInspection.clottingINR = $scope.clottingINR;
    physicalChemicalInspection.bloodRoutineRBC = $scope.bloodRoutineRBC;
    physicalChemicalInspection.bloodRoutineHb = $scope.bloodRoutineHb;
    physicalChemicalInspection.bloodRoutineWBC = $scope.bloodRoutineWBC;
    physicalChemicalInspection.bloodRoutineNeutrophils = $scope.bloodRoutineNeutrophils;
    physicalChemicalInspection.bloodRoutineLymphocytes = $scope.bloodRoutineLymphocytes;
    physicalChemicalInspection.bloodRoutineEosinophils = $scope.bloodRoutineEosinophils;
    physicalChemicalInspection.bloodRoutinePlatelets = $scope.bloodRoutinePlatelets;
    physicalChemicalInspection.liverDiseaseAutoantibodiesAMA = $scope.liverDiseaseAutoantibodiesAMA;
    physicalChemicalInspection.liverDiseaseAutoantibodiesAMAM2 = $scope.liverDiseaseAutoantibodiesAMAM2;
    physicalChemicalInspection.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody = $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
    physicalChemicalInspection.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies = $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
    physicalChemicalInspection.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen = $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
    physicalChemicalInspection.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen = $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
    physicalChemicalInspection.liverDiseaseAutoantibodiesOther = $scope.liverDiseaseAutoantibodiesOther;
    physicalChemicalInspection.anahomogeneous = $scope.anaHomogeneous;
    physicalChemicalInspection.anaparticle = $scope.anaParticle;
    physicalChemicalInspection.anaperipheral = $scope.anaPeripheral;
    physicalChemicalInspection.ananucleolus = $scope.anaNucleolus;
    physicalChemicalInspection.ananucleolusEnhancement = $scope.anaNucleolusEnhancement;
    physicalChemicalInspection.ananuclear = $scope.anaNuclear;
    physicalChemicalInspection.anacentromere = $scope.anaCentromere;
    physicalChemicalInspection.anaother = $scope.anaOther;
    physicalChemicalInspection.humoralImmunityIgG = $scope.humoralImmunityIgG;
    physicalChemicalInspection.humoralImmunityIgA = $scope.humoralImmunityIgA;
    physicalChemicalInspection.humoralImmunityIgM = $scope.humoralImmunityIgM;
    physicalChemicalInspection.humoralImmunityImmuneComplexf = $scope.humoralImmunityImmuneComplexf;
    physicalChemicalInspection.humoralImmunityComplementC3 = $scope.humoralImmunityComplementC3;
    physicalChemicalInspection.humoralImmunityComplementC4 = $scope.humoralImmunityComplementC4;
    physicalChemicalInspection.humoralImmunityIgE = $scope.humoralImmunityIgE;
    physicalChemicalInspection.humoralImmunityKlightChain = $scope.humoralImmunityKlightChain;
    physicalChemicalInspection.humoralImmunityNlightChain = $scope.humoralImmunityNlightChain;
    physicalChemicalInspection.cellularImmunityCD3 = $scope.cellularImmunityCD3;
    physicalChemicalInspection.cellularImmunityCD4 = $scope.cellularImmunityCD4;
    physicalChemicalInspection.cellularImmunityCD8 = $scope.cellularImmunityCD8;
    physicalChemicalInspection.cellularImmunityCD56 = $scope.cellularImmunityCD56;
    physicalChemicalInspection.cellularImmunityCD2 = $scope.cellularImmunityCD2;
    physicalChemicalInspection.cellularImmunityCD4CD8 = $scope.cellularImmunityCD4CD8;
    physicalChemicalInspection.rheumaticImmuneRelatedAntibodies = $scope.rheumaticImmuneRelatedAntibodies;
    physicalChemicalInspection.copperProtein = $scope.copperProtein;
    physicalChemicalInspection.aFP = $scope.aFP;
    physicalChemicalInspection.carcinoembryonicAntigenCEA = $scope.carcinoembryonicAntigenCEA;
    physicalChemicalInspection.ca199 = $scope.ca199;
    physicalChemicalInspection.ca125 = $scope.ca125;
    physicalChemicalInspection.hbsag = $scope.hbsag;
    physicalChemicalInspection.hbsab = $scope.hbsab;
    physicalChemicalInspection.hbeag = $scope.hbeag;
    physicalChemicalInspection.hbeab = $scope.hbeab;
    physicalChemicalInspection.hbcab = $scope.hbcab;
    physicalChemicalInspection.hbvRna = $scope.hbvRna;
    physicalChemicalInspection.antiHCVantibody = $scope.antiHCVantibody;
    physicalChemicalInspection.hcvRna = $scope.hcvRna;
    physicalChemicalInspection.protein = $scope.protein;
    physicalChemicalInspection.redBloodCell = $scope.redBloodCell;
    physicalChemicalInspection.whiteBloodCell = $scope.whiteBloodCell;
    physicalChemicalInspection.bilirubin = $scope.bilirubin;
    physicalChemicalInspection.copperProtein = $scope.copperProtein;
    physicalChemicalInspection.followUp = $scope.follow;
    physicalChemicalInspection.followUpDate = new Date($scope.followUpDate);
    physicalChemicalInspection.imageUrl = $scope.imageName;


    if (!$scope.cTMRI) {
      physicalChemicalInspection.ctmri = -1;
    } else {
      physicalChemicalInspection.ctmri = $scope.cTMRI;
    }
    physicalChemicalInspection.liverHardnessFibroscan = $scope.liverHardnessFibroscan;
    physicalChemicalInspection.liverHardnessFibrotest = $scope.liverHardnessFibrotest;
    physicalChemicalInspection.liverPuncturePathology = $scope.liverPuncturePathology;
    if ($scope.totalBileAcid && $scope.liverFunctionAlbumin && $scope.liverFunctionGlobulin && $scope.liverFunctionALT && $scope.liverFunctionAST && $scope.liverFunctionGGT && $scope.liverFunctionALP && $scope.liverFunctionTotalCholesterol && $scope.liverFunctionTotalBilirubin && $scope.liverFunctionDirectBilirubin && $scope.liverFunctionRglobulin && $scope.renalFunctionBUN && $scope.renalFunctionCr && $scope.clottingPT && $scope.clottingINR && $scope.bloodRoutineRBC && $scope.bloodRoutineHb && $scope.bloodRoutineWBC && $scope.bloodRoutineNeutrophils && $scope.bloodRoutineLymphocytes && $scope.bloodRoutineEosinophils && $scope.bloodRoutinePlatelets && $scope.liverDiseaseAutoantibodiesAMA && $scope.liverDiseaseAutoantibodiesAMAM2 && $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody && $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies && $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen && $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen && $scope.liverDiseaseAutoantibodiesOther && $scope.anaHomogeneous && $scope.anaParticle && $scope.anaPeripheral && $scope.anaNucleolus && $scope.anaNucleolusEnhancement && $scope.anaNuclear && $scope.anaCentromere && $scope.anaOther && $scope.humoralImmunityIgG && $scope.humoralImmunityIgA && $scope.humoralImmunityIgM && $scope.humoralImmunityImmuneComplexf && $scope.humoralImmunityComplementC3 && $scope.humoralImmunityComplementC4 && $scope.humoralImmunityIgE && $scope.humoralImmunityKlightChain && $scope.humoralImmunityNlightChain && $scope.cellularImmunityCD3 && $scope.cellularImmunityCD4 && $scope.cellularImmunityCD8 && $scope.cellularImmunityCD56 && $scope.cellularImmunityCD2 && $scope.cellularImmunityCD4CD8 && $scope.rheumaticImmuneRelatedAntibodies && $scope.cTMRI && $scope.liverHardnessFibroscan && $scope.liverHardnessFibrotest && $scope.liverPuncturePathology && $scope.aFP && $scope.carcinoembryonicAntigenCEA && $scope.ca199 && $scope.ca125 && $scope.hbsag && $scope.hbsab && $scope.hbeag && $scope.hbcab && $scope.hbvRna && $scope.antiHCVantibody && $scope.hcvRna && $scope.protein && $scope.redBloodCell && $scope.whiteBloodCell && $scope.whiteBloodCell && $scope.bilirubin && $scope.copperProtein) {
      physicalChemicalInspection.complete = true;
    } else {
      physicalChemicalInspection.complete = false;
    }
    $http({
      method: 'POST',
      url: '/api/physical',
      data: physicalChemicalInspection
    }).then(function() {
      $scope.changeMenuStatus();
      $('#saveModal').modal('hide');
      $scope.justModalContent = '保存成功';
      // setTimeout(function() {
      $('#justModal').modal('show');
      //   setTimeout(function() {
      //     $('#justModal').modal('hide');
      //     setTimeout(function() {
      //       $state.go('home');
      //     }, 1000);
      //   }, 1000);
      // }, 1000);

    });
  };

  function getPatientInfo() {
    $http({
      method: 'GET',
      url: '/api/patient/' + sessionStorage.getItem('patientId')
    }).then(function success(response) {
      $scope.patientName = response.data.name;
      $scope.patientNumber = response.data.identifier;
    });
  }

  function getPhy() {
    $http({
      method: 'GET',
      url: 'api/physical/' + sessionStorage.getItem('patientId')
    }).then(function(response) {
      if (response.data != '') {
        physicalChemicalInspection = response.data;
      } else {
        physicalChemicalInspection = {};
      }
      $scope.totalBileAcid = physicalChemicalInspection.totalBileAcid;
      $scope.liverFunctionAlbumin = physicalChemicalInspection.liverFunctionAlbumin;
      $scope.liverFunctionGlobulin = physicalChemicalInspection.liverFunctionGlobulin;
      $scope.liverFunctionALT = physicalChemicalInspection.liverFunctionALT;
      $scope.liverFunctionAST = physicalChemicalInspection.liverFunctionAST;
      $scope.liverFunctionGGT = physicalChemicalInspection.liverFunctionGGT;
      $scope.liverFunctionALP = physicalChemicalInspection.liverFunctionALP;
      $scope.liverFunctionTotalCholesterol = physicalChemicalInspection.liverFunctionTotalCholesterol;
      $scope.liverFunctionTotalBilirubin = physicalChemicalInspection.liverFunctionTotalBilirubin;
      $scope.liverFunctionDirectBilirubin = physicalChemicalInspection.liverFunctionDirectBilirubin;
      $scope.liverFunctionRglobulin = physicalChemicalInspection.liverFunctionRglobulin;
      $scope.renalFunctionBUN = physicalChemicalInspection.renalFunctionBUN;
      $scope.renalFunctionCr = physicalChemicalInspection.renalFunctionCr;
      $scope.clottingPT = physicalChemicalInspection.clottingPT;
      $scope.clottingINR = physicalChemicalInspection.clottingINR;
      $scope.bloodRoutineRBC = physicalChemicalInspection.bloodRoutineRBC;
      $scope.bloodRoutineHb = physicalChemicalInspection.bloodRoutineHb;
      $scope.bloodRoutineWBC = physicalChemicalInspection.bloodRoutineWBC;
      $scope.bloodRoutineNeutrophils = physicalChemicalInspection.bloodRoutineNeutrophils;
      $scope.bloodRoutineLymphocytes = physicalChemicalInspection.bloodRoutineLymphocytes;
      $scope.bloodRoutineEosinophils = physicalChemicalInspection.bloodRoutineEosinophils;
      $scope.bloodRoutinePlatelets = physicalChemicalInspection.bloodRoutinePlatelets;
      $scope.liverDiseaseAutoantibodiesAMA = physicalChemicalInspection.liverDiseaseAutoantibodiesAMA;
      $scope.liverDiseaseAutoantibodiesAMAM2 = physicalChemicalInspection.liverDiseaseAutoantibodiesAMAM2;
      $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody = physicalChemicalInspection.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibody;
      $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies = physicalChemicalInspection.liverDiseaseAutoantibodiesLiverKidneyMicrosomalAntibodies;
      $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen = physicalChemicalInspection.liverDiseaseAutoantibodiesHepatocyteSoluteAntigen;
      $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen = physicalChemicalInspection.liverDiseaseAutoantibodiesSolubleLiverPancreaticAntigen;
      $scope.liverDiseaseAutoantibodiesOther = physicalChemicalInspection.liverDiseaseAutoantibodiesOther;
      $scope.anaHomogeneous = physicalChemicalInspection.anahomogeneous;
      $scope.anaParticle = physicalChemicalInspection.anaparticle;
      $scope.anaPeripheral = physicalChemicalInspection.anaperipheral;
      $scope.anaNucleolus = physicalChemicalInspection.ananucleolus;
      $scope.anaNucleolusEnhancement = physicalChemicalInspection.ananucleolusEnhancement;
      $scope.anaNuclear = physicalChemicalInspection.ananuclear;
      $scope.anaCentromere = physicalChemicalInspection.anacentromere;
      $scope.anaOther = physicalChemicalInspection.anaother;
      $scope.humoralImmunityIgG = physicalChemicalInspection.humoralImmunityIgG;
      $scope.humoralImmunityIgA = physicalChemicalInspection.humoralImmunityIgA;
      $scope.humoralImmunityIgM = physicalChemicalInspection.humoralImmunityIgM;
      $scope.humoralImmunityImmuneComplexf = physicalChemicalInspection.humoralImmunityImmuneComplexf;
      $scope.humoralImmunityComplementC3 = physicalChemicalInspection.humoralImmunityComplementC3;
      $scope.humoralImmunityComplementC4 = physicalChemicalInspection.humoralImmunityComplementC4;
      $scope.humoralImmunityIgE = physicalChemicalInspection.humoralImmunityIgE;
      $scope.humoralImmunityKlightChain = physicalChemicalInspection.humoralImmunityKlightChain;
      $scope.cellularImmunityCD3 = physicalChemicalInspection.cellularImmunityCD3;
      $scope.cellularImmunityCD4 = physicalChemicalInspection.cellularImmunityCD4;
      $scope.cellularImmunityCD8 = physicalChemicalInspection.cellularImmunityCD8;
      $scope.cellularImmunityCD56 = physicalChemicalInspection.cellularImmunityCD56;
      $scope.cellularImmunityCD2 = physicalChemicalInspection.cellularImmunityCD2;
      $scope.humoralImmunityNlightChain = physicalChemicalInspection.humoralImmunityNlightChain;
      $scope.cellularImmunityCD4CD8 = physicalChemicalInspection.cellularImmunityCD4CD8;
      $scope.rheumaticImmuneRelatedAntibodies = physicalChemicalInspection.rheumaticImmuneRelatedAntibodies;
      $scope.cTMRI = physicalChemicalInspection.ctmri;
      $scope.liverHardnessFibroscan = physicalChemicalInspection.liverHardnessFibroscan;
      $scope.liverHardnessFibrotest = physicalChemicalInspection.liverHardnessFibrotest;
      $scope.liverPuncturePathology = physicalChemicalInspection.liverPuncturePathology;
      $scope.copperProtein = physicalChemicalInspection.copperProtein;
      $scope.aFP = physicalChemicalInspection.aFP;
      $scope.carcinoembryonicAntigenCEA = physicalChemicalInspection.carcinoembryonicAntigenCEA;
      $scope.ca125 = physicalChemicalInspection.ca125;
      $scope.hbsag = physicalChemicalInspection.hbsag;
      $scope.hbsab = physicalChemicalInspection.hbsab;
      $scope.hbeag = physicalChemicalInspection.hbeag;
      $scope.hbeab = physicalChemicalInspection.hbeab;
      $scope.hbcab = physicalChemicalInspection.hbcab;
      $scope.hbvRna = physicalChemicalInspection.hbvRna;
      $scope.antiHCVantibody = physicalChemicalInspection.antiHCVantibody;
      $scope.hcvRna = physicalChemicalInspection.hcvRna;
      $scope.protein = physicalChemicalInspection.protein;
      $scope.redBloodCell = physicalChemicalInspection.redBloodCell;
      $scope.whiteBloodCell = physicalChemicalInspection.whiteBloodCell;
      $scope.bilirubin = physicalChemicalInspection.bilirubin;
      $scope.ca199 = physicalChemicalInspection.ca199;
      $scope.image = '/api/image/' + physicalChemicalInspection.imageUrl + '.jpg';

    });
  }

  function saveImg(image) {
    Upload.upload({
      url: '/api/physical/upload',
      data: {
        file: image
      }
    }).then(function success(response) {
      $scope.imageName = response.data;
    });
  }

}]);