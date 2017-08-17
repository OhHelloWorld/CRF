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
  for (var i = 1; i < 72; i++) {
    $('#datepicker' + i).datepicker({
      autoclose: true
    });
  }


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
      $scope.totalBileAcidDate = undefined;
      $scope.liverFunctionAlbuminDate = undefined;
      $scope.liverFunctionGlobulinDate = undefined;
      $scope.liverFunctionALTDate = undefined;
      $scope.liverFunctionASTDate = undefined;
      $scope.liverFunctionGGTDate = undefined;
      $scope.liverFunctionALPDate = undefined;
      $scope.liverFunctionTotalCholesterolDate = undefined;
      $scope.liverFunctionTotalBilirubinDate = undefined;
      $scope.liverFunctionDirectBilirubinDate = undefined;
      $scope.liverFunctionRglobulinDate = undefined;
      $scope.renalFunctionBUNDate = undefined;
      $scope.renalFunctionCrDate = undefined;
      $scope.clottingPTDate = undefined;
      $scope.clottingINRDate = undefined;
      $scope.bloodRoutineRBCDate = undefined;
      $scope.bloodRoutineHbDate = undefined;
      $scope.bloodRoutineWBCDate = undefined;
      $scope.bloodRoutineNeutrophilsDate = undefined;
      $scope.bloodRoutineLymphocytesDate = undefined;
      $scope.bloodRoutineEosinophilsDate = undefined;
      $scope.bloodRoutinePlateletsDate = undefined;
      $scope.liverDiseaseAutoantibodiesAMADate = undefined;
      $scope.liverDiseaseAutoantibodiesAMAM2Date = undefined;
      $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate = undefined;
      $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate = undefined;
      $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate = undefined;
      $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate = undefined;
      $scope.liverDiseaseAutoantibodiesOtherDate = undefined;
      $scope.aNAHomogeneousDate = undefined;
      $scope.aNAParticleDate = undefined;
      $scope.aNAPeripheralDate = undefined;
      $scope.aNANucleolusDate = undefined;
      $scope.aNANucleolusEnhancementDate = undefined;
      $scope.aNANuclearDate = undefined;
      $scope.aNACentromereDate = undefined;
      $scope.aNAOtherDate = undefined;
      $scope.humoralImmunityIgGDate = undefined;
      $scope.humoralImmunityIgADate = undefined;
      $scope.humoralImmunityIgMDate = undefined;
      $scope.humoralImmunityImmuneComplexfDate = undefined;
      $scope.humoralImmunityComplementC3Date = undefined;
      $scope.humoralImmunityComplementC4Date = undefined;
      $scope.humoralImmunityIgEDate = undefined;
      $scope.humoralImmunityKlightChainDate = undefined;
      $scope.humoralImmunityNlightChainDate = undefined;
      $scope.cellularImmunityCD3Date = undefined;
      $scope.cellularImmunityCD4Date = undefined;
      $scope.cellularImmunityCD8Date = undefined;
      $scope.cellularImmunityCD56Date = undefined;
      $scope.cellularImmunityCD2Date = undefined;
      $scope.cellularImmunityCD4CD8Date = undefined;
      $scope.liverHardnessFibroscanDate = undefined;
      $scope.liverHardnessFibrotestDate = undefined;
      $scope.copperProteinDate = undefined;
      $scope.aFPDate = undefined;
      $scope.carcinoembryonicAntigenCEADate = undefined;
      $scope.ca125Date = undefined;
      $scope.hbsagDate = undefined;
      $scope.hbsabDate = undefined;
      $scope.hbeagDate = undefined;
      $scope.hbeabDate = undefined;
      $scope.hbcabDate = undefined;
      $scope.hbvRnaDate = undefined;
      $scope.antiHCVantibodyDate = undefined;
      $scope.hcvRnaDate = undefined;
      $scope.proteinDate = undefined;
      $scope.redBloodCellDate = undefined;
      $scope.whiteBloodCellDate = undefined;
      $scope.bilirubinDate = undefined;
      $scope.ca199Date = undefined;
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

    physicalChemicalInspection.totalBileAcidDate = new Date($scope.totalBileAcidDate);
    physicalChemicalInspection.liverFunctionAlbuminDate = new Date($scope.liverFunctionAlbuminDate);
    physicalChemicalInspection.liverFunctionGlobulinDate = new Date($scope.liverFunctionGlobulinDate);
    physicalChemicalInspection.liverFunctionALTDate = new Date($scope.liverFunctionALTDate);
    physicalChemicalInspection.liverFunctionASTDate = new Date($scope.liverFunctionASTDate);
    physicalChemicalInspection.liverFunctionGGTDate = new Date($scope.liverFunctionGGTDate);
    physicalChemicalInspection.liverFunctionALPDate = new Date($scope.liverFunctionALPDate);
    physicalChemicalInspection.liverFunctionTotalCholesterolDate = new Date($scope.liverFunctionTotalCholesterolDate);
    physicalChemicalInspection.liverFunctionTotalBilirubinDate = new Date($scope.liverFunctionTotalBilirubinDate);
    physicalChemicalInspection.liverFunctionDirectBilirubinDate = new Date($scope.liverFunctionDirectBilirubinDate);
    physicalChemicalInspection.liverFunctionRglobulinDate = new Date($scope.liverFunctionRglobulinDate);
    physicalChemicalInspection.renalFunctionBUNDate = new Date($scope.renalFunctionBUNDate);
    physicalChemicalInspection.renalFunctionCrDate = new Date($scope.renalFunctionCrDate);
    physicalChemicalInspection.clottingPTDate = new Date($scope.clottingPTDate);
    physicalChemicalInspection.clottingINRDate = new Date($scope.clottingINRDate);
    physicalChemicalInspection.bloodRoutineRBCDate = new Date($scope.bloodRoutineRBCDate);
    physicalChemicalInspection.bloodRoutineHbDate = new Date($scope.bloodRoutineHbDate);
    physicalChemicalInspection.bloodRoutineWBCDate = new Date($scope.bloodRoutineWBCDate);
    physicalChemicalInspection.bloodRoutineNeutrophilsDate = new Date($scope.bloodRoutineNeutrophilsDate);
    physicalChemicalInspection.bloodRoutineLymphocytesDate = new Date($scope.bloodRoutineLymphocytesDate);
    physicalChemicalInspection.bloodRoutineEosinophilsDate = new Date($scope.bloodRoutineEosinophilsDate);
    physicalChemicalInspection.bloodRoutinePlateletsDate = new Date($scope.bloodRoutinePlateletsDate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesAMADate = new Date($scope.liverDiseaseAutoantibodiesAMADate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesAMAM2Date = new Date($scope.liverDiseaseAutoantibodiesAMAM2Date);
    physicalChemicalInspection.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate = new Date($scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate = new Date($scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate = new Date($scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate = new Date($scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate);
    physicalChemicalInspection.liverDiseaseAutoantibodiesOtherDate = new Date($scope.liverDiseaseAutoantibodiesOtherDate);
    physicalChemicalInspection.aNAHomogeneousDate = new Date($scope.anaHomogeneousDate);
    physicalChemicalInspection.aNAParticleDate = new Date($scope.anaParticleDate);
    physicalChemicalInspection.aNAPeripheralDate = new Date($scope.anaPeripheralDate);
    physicalChemicalInspection.aNANucleolusDate = new Date($scope.anaNucleolusDate);
    physicalChemicalInspection.aNANucleolusEnhancementDate = new Date($scope.anaNucleolusEnhancementDate);
    physicalChemicalInspection.aNANuclearDate = new Date($scope.anaNuclearDate);
    physicalChemicalInspection.aNACentromereDate = new Date($scope.anaCentromereDate);
    physicalChemicalInspection.aNAOtherDate = new Date($scope.anaOtherDate);
    physicalChemicalInspection.humoralImmunityIgGDate = new Date($scope.humoralImmunityIgGDate);
    physicalChemicalInspection.humoralImmunityIgADate = new Date($scope.humoralImmunityIgADate);
    physicalChemicalInspection.humoralImmunityIgMDate = new Date($scope.humoralImmunityIgMDate);
    physicalChemicalInspection.humoralImmunityImmuneComplexfDate = new Date($scope.humoralImmunityImmuneComplexfDate);
    physicalChemicalInspection.humoralImmunityComplementC3Date = new Date($scope.humoralImmunityComplementC3Date);
    physicalChemicalInspection.humoralImmunityComplementC4Date = new Date($scope.humoralImmunityComplementC4Date);
    physicalChemicalInspection.humoralImmunityIgEDate = new Date($scope.humoralImmunityIgEDate);
    physicalChemicalInspection.humoralImmunityKlightChainDate = new Date($scope.humoralImmunityKlightChainDate);
    physicalChemicalInspection.humoralImmunityNlightChainDate = new Date($scope.humoralImmunityNlightChainDate);
    physicalChemicalInspection.cellularImmunityCD3Date = new Date($scope.cellularImmunityCD3Date);
    physicalChemicalInspection.cellularImmunityCD4Date = new Date($scope.cellularImmunityCD4Date);
    physicalChemicalInspection.cellularImmunityCD8Date = new Date($scope.cellularImmunityCD8Date);
    physicalChemicalInspection.cellularImmunityCD56Date = new Date($scope.cellularImmunityCD56Date);
    physicalChemicalInspection.cellularImmunityCD2Date = new Date($scope.cellularImmunityCD2Date);
    physicalChemicalInspection.cellularImmunityCD4CD8Date = new Date($scope.cellularImmunityCD4CD8Date);
    physicalChemicalInspection.liverHardnessFibroscanDate = new Date($scope.liverHardnessFibroscanDate);
    physicalChemicalInspection.liverHardnessFibrotestDate = new Date($scope.liverHardnessFibrotestDate);
    physicalChemicalInspection.copperProteinDate = new Date($scope.copperProteinDate);
    physicalChemicalInspection.aFPDate = new Date($scope.aFPDate);
    physicalChemicalInspection.carcinoembryonicAntigenCEADate = new Date($scope.carcinoembryonicAntigenCEADate);
    physicalChemicalInspection.ca125Date = new Date($scope.ca125Date);
    physicalChemicalInspection.hbsagDate = new Date($scope.hbsagDate);
    physicalChemicalInspection.hbsabDate = new Date($scope.hbsabDate);
    physicalChemicalInspection.hbeagDate = new Date($scope.hbeagDate);
    physicalChemicalInspection.hbeabDate = new Date($scope.hbeabDate);
    physicalChemicalInspection.hbcabDate = new Date($scope.hbcabDate);
    physicalChemicalInspection.hbvRnaDate = new Date($scope.hbvRnaDate);
    physicalChemicalInspection.antiHCVantibodyDate = new Date($scope.antiHCVantibodyDate);
    physicalChemicalInspection.hcvRnaDate = new Date($scope.hcvRnaDate);
    physicalChemicalInspection.proteinDate = new Date($scope.proteinDate);
    physicalChemicalInspection.redBloodCellDate = new Date($scope.redBloodCellDate);
    physicalChemicalInspection.whiteBloodCellDate = new Date($scope.whiteBloodCellDate);
    physicalChemicalInspection.bilirubinDate = new Date($scope.bilirubinDate);
    physicalChemicalInspection.ca199Date = new Date($scope.ca199Date);


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


      $scope.totalBileAcidDate = formatDate(physicalChemicalInspection.totalBileAcidDate);
      $scope.liverFunctionAlbuminDate = formatDate(physicalChemicalInspection.liverFunctionAlbuminDate);
      $scope.liverFunctionGlobulinDate = formatDate(physicalChemicalInspection.liverFunctionGlobulinDate);
      $scope.liverFunctionALTDate = formatDate(physicalChemicalInspection.liverFunctionALTDate);
      $scope.liverFunctionASTDate = formatDate(physicalChemicalInspection.liverFunctionASTDate);
      $scope.liverFunctionGGTDate = formatDate(physicalChemicalInspection.liverFunctionGGTDate);
      $scope.liverFunctionALPDate = formatDate(physicalChemicalInspection.liverFunctionALPDate);
      $scope.liverFunctionTotalCholesterolDate = formatDate(physicalChemicalInspection.liverFunctionTotalCholesterolDate);
      $scope.liverFunctionTotalBilirubinDate = formatDate(physicalChemicalInspection.liverFunctionTotalBilirubinDate);
      $scope.liverFunctionDirectBilirubinDate = formatDate(physicalChemicalInspection.liverFunctionDirectBilirubinDate);
      $scope.liverFunctionRglobulinDate = formatDate(physicalChemicalInspection.liverFunctionRglobulinDate);
      $scope.renalFunctionBUNDate = formatDate(physicalChemicalInspection.renalFunctionBUNDate);
      $scope.renalFunctionCrDate = formatDate(physicalChemicalInspection.renalFunctionCrDate);
      $scope.clottingPTDate = formatDate(physicalChemicalInspection.clottingPTDate);
      $scope.clottingINRDate = formatDate(physicalChemicalInspection.clottingINRDate);
      $scope.bloodRoutineRBCDate = formatDate(physicalChemicalInspection.bloodRoutineRBCDate);
      $scope.bloodRoutineHbDate = formatDate(physicalChemicalInspection.bloodRoutineHbDate);
      $scope.bloodRoutineWBCDate = formatDate(physicalChemicalInspection.bloodRoutineWBCDate);
      $scope.bloodRoutineNeutrophilsDate = formatDate(physicalChemicalInspection.bloodRoutineNeutrophilsDate);
      $scope.bloodRoutineLymphocytesDate = formatDate(physicalChemicalInspection.bloodRoutineLymphocytesDate);
      $scope.bloodRoutineEosinophilsDate = formatDate(physicalChemicalInspection.bloodRoutineEosinophilsDate);
      $scope.bloodRoutinePlateletsDate = formatDate(physicalChemicalInspection.bloodRoutinePlateletsDate);
      $scope.liverDiseaseAutoantibodiesAMADate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesAMADate);
      $scope.liverDiseaseAutoantibodiesAMAM2Date = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesAMAM2Date);
      $scope.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesAntiSmoothMuscleAntibodyDate);
      $scope.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesLiverKidneyMicrosomalbodiesDate);
      $scope.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesHepatocyteSoluteAntigenDate);
      $scope.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesSolubleLiverPancreaticgenDate);
      $scope.liverDiseaseAutoantibodiesOtherDate = formatDate(physicalChemicalInspection.liverDiseaseAutoantibodiesOtherDate);
      $scope.anaHomogeneousDate = formatDate(physicalChemicalInspection.aNAHomogeneousDate);
      $scope.anaParticleDate = formatDate(physicalChemicalInspection.aNAParticleDate);
      $scope.anaPeripheralDate = formatDate(physicalChemicalInspection.aNAPeripheralDate);
      $scope.anaNucleolusDate = formatDate(physicalChemicalInspection.aNANucleolusDate);
      $scope.anaNucleolusEnhancementDate = formatDate(physicalChemicalInspection.aNANucleolusEnhancementDate);
      $scope.anaNuclearDate = formatDate(physicalChemicalInspection.aNANuclearDate);
      $scope.anaCentromereDate = formatDate(physicalChemicalInspection.aNACentromereDate);
      $scope.anaOtherDate = formatDate(physicalChemicalInspection.aNAOtherDate);
      $scope.humoralImmunityIgGDate = formatDate(physicalChemicalInspection.humoralImmunityIgGDate);
      $scope.humoralImmunityIgADate = formatDate(physicalChemicalInspection.humoralImmunityIgADate);
      $scope.humoralImmunityIgMDate = formatDate(physicalChemicalInspection.humoralImmunityIgMDate);
      $scope.humoralImmunityImmuneComplexfDate = formatDate(physicalChemicalInspection.humoralImmunityImmuneComplexfDate);
      $scope.humoralImmunityComplementC3Date = formatDate(physicalChemicalInspection.humoralImmunityComplementC3Date);
      $scope.humoralImmunityComplementC4Date = formatDate(physicalChemicalInspection.humoralImmunityComplementC4Date);
      $scope.humoralImmunityIgEDate = formatDate(physicalChemicalInspection.humoralImmunityIgEDate);
      $scope.humoralImmunityKlightChainDate = formatDate(physicalChemicalInspection.humoralImmunityKlightChainDate);
      $scope.humoralImmunityNlightChainDate = formatDate(physicalChemicalInspection.humoralImmunityNlightChainDate);
      $scope.cellularImmunityCD3Date = formatDate(physicalChemicalInspection.cellularImmunityCD3Date);
      $scope.cellularImmunityCD4Date = formatDate(physicalChemicalInspection.cellularImmunityCD4Date);
      $scope.cellularImmunityCD8Date = formatDate(physicalChemicalInspection.cellularImmunityCD8Date);
      $scope.cellularImmunityCD56Date = formatDate(physicalChemicalInspection.cellularImmunityCD56Date);
      $scope.cellularImmunityCD2Date = formatDate(physicalChemicalInspection.cellularImmunityCD2Date);
      $scope.cellularImmunityCD4CD8Date = formatDate(physicalChemicalInspection.cellularImmunityCD4CD8Date);
      $scope.liverHardnessFibroscanDate = formatDate(physicalChemicalInspection.liverHardnessFibroscanDate);
      $scope.liverHardnessFibrotestDate = formatDate(physicalChemicalInspection.liverHardnessFibrotestDate);
      $scope.copperProteinDate = formatDate(physicalChemicalInspection.copperProteinDate);
      $scope.aFPDate = formatDate(physicalChemicalInspection.aFPDate);
      $scope.carcinoembryonicAntigenCEADate = formatDate(physicalChemicalInspection.carcinoembryonicAntigenCEADate);
      $scope.ca125Date = formatDate(physicalChemicalInspection.ca125Date);
      $scope.hbsagDate = formatDate(physicalChemicalInspection.hbsagDate);
      $scope.hbsabDate = formatDate(physicalChemicalInspection.hbsabDate);
      $scope.hbeagDate = formatDate(physicalChemicalInspection.hbeagDate);
      $scope.hbeabDate = formatDate(physicalChemicalInspection.hbeabDate);
      $scope.hbcabDate = formatDate(physicalChemicalInspection.hbcabDate);
      $scope.hbvRnaDate = formatDate(physicalChemicalInspection.hbvRnaDate);
      $scope.antiHCVantibodyDate = formatDate(physicalChemicalInspection.antiHCVantibodyDate);
      $scope.hcvRnaDate = formatDate(physicalChemicalInspection.hcvRnaDate);
      $scope.proteinDate = formatDate(physicalChemicalInspection.proteinDate);
      $scope.redBloodCellDate = formatDate(physicalChemicalInspection.redBloodCellDate);
      $scope.whiteBloodCellDate = formatDate(physicalChemicalInspection.whiteBloodCellDate);
      $scope.bilirubinDate = formatDate(physicalChemicalInspection.bilirubinDate);
      $scope.ca199Date = formatDate(physicalChemicalInspection.ca199Date);

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

  function formatDate(myDate) {
    if (myDate) {
      var myTime = new Date(myDate);
      return myTime.getFullYear() + '-' + (myTime.getMonth() + 1) + '-' + myTime.getDate();
    } else {
      return undefined;
    }

  }

}]);