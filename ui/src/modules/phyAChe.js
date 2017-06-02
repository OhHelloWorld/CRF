'use strict';

import angular from 'angular';

var phyAChe = angular.module('phyAChe', []);

phyAChe.controller('phyACheController', ['$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {

  var physicalChemicalInspection = {};
  $scope.tabTitle = '肝功能';
  $scope.addTabActive = function(str1, str2){
    $('.tab-pane').removeClass('active');
    $(str1).addClass('active');
    $scope.tabTitle = str2;
    // $scope.tabTitle = $(str).val;
  };

  //sent all messages by $http to save
  $scope.allCommit = function(){
    alert('发送请求,保存信息');
  };

  //save some messages
  $scope.saveSomeMessage = function() {
    //1st
    physicalChemicalInspection.totalBileAcid = $scope.totalBileAcid;
    $http({
      method:'Post',
      url:'/api/physical/'
    });
  };

  //save some messages
  $scope.saveSomeMessage = function() {
    physicalChemicalInspection.patientId = $rootScope.patientId;
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
    physicalChemicalInspection.ANAHomogeneous = $scope.ANAHomogeneous;
    physicalChemicalInspection.ANAParticle = $scope.ANAParticle;
    physicalChemicalInspection.ANAPeripheral = $scope.ANAPeripheral;
    physicalChemicalInspection.ANANucleolus = $scope.ANANucleolus;
    physicalChemicalInspection.ANANucleolusEnhancement = $scope.ANANucleolusEnhancement;
    physicalChemicalInspection.ANANuclear = $scope.ANANuclear;
    physicalChemicalInspection.ANACentromere = $scope.ANACentromere;
    physicalChemicalInspection.ANAOther = $scope.ANAOther;
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
    physicalChemicalInspection.CTMRI = $scope.CTMRI;
    physicalChemicalInspection.liverHardnessFibroscan = $scope.liverHardnessFibroscan;
    physicalChemicalInspection.liverHardnessFibrotest = $scope.liverHardnessFibrotest;
    physicalChemicalInspection.liverPuncturePathology = $scope.liverPuncturePathology;

    $http({
      method:'POST',
      url:'/api/physical/',
      data: physicalChemicalInspection
    }).then(function() {
      
    });
  };

}]);
