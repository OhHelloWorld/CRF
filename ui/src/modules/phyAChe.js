'use strict';

import angular from 'angular';
import '../entries/main.js';

var phyAChe = angular.module('phyAChe', ['main']);

phyAChe.controller('phyACheController', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {

  var physicalChemicalInspection = {};
  $scope.modalContent = '您确定要保存所有修改吗？';
  $scope.tabTitle = '肝功能';
  getPatientInfo();
  $scope.addTabActive = function(str1, str2) {
    $('.tab-pane').removeClass('active');
    $(str1).addClass('active');
    $scope.tabTitle = str2;
    // $scope.tabTitle = $(str).val;
  };

  $scope.showSaveModal = function() {
    $('#saveModal').modal('show');
  };

  //save some messages
  // $scope.saveSomeMessage = function() {
  //   //1st
  //   $http({
  //     method:'Post',
  //     url:'/api/physical/'
  //   });
  // };



  //get patientInfo by id
  $http({
    method:'GET',
    url:'api/physical/' + sessionStorage.getItem('patientId')
  }).then(function(response) {
    physicalChemicalInspection = response.data;
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
    $scope.twoEyesDry = physicalChemicalInspection.twoEyesDry;
    $scope.liverHardnessFibroscan = physicalChemicalInspection.liverHardnessFibroscan;
    $scope.liverHardnessFibrotest = physicalChemicalInspection.liverHardnessFibrotest;
    $scope.liverPuncturePathology = physicalChemicalInspection.liverPuncturePathology;

  });

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
    physicalChemicalInspection.twoEyesDry = $scope.twoEyesDry;
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
    physicalChemicalInspection.ctmri = $scope.cTMRI;
    physicalChemicalInspection.liverHardnessFibroscan = $scope.liverHardnessFibroscan;
    physicalChemicalInspection.liverHardnessFibrotest = $scope.liverHardnessFibrotest;
    physicalChemicalInspection.liverPuncturePathology = $scope.liverPuncturePathology;

    $http({
      method: 'POST',
      url:'/api/physical',
      data: physicalChemicalInspection
    }).then(function() {
      $scope.modalContent = '保存成功，即将跳转至首页！';
      $('#saveModal').modal('hide');
      setTimeout(function(){
        $state.go('home');
      }, 1000);

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

}]);
