import angular from 'angular';
import '../entries/main.js';

angular.module('finalDiagnosis', ['ui.checkbox', 'main'])
  .controller('finalDiagnosisController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    loginStatus();
    getPatientInfo();
    $scope.judgeGoHome();
    $scope.finalDiagnosisClick();
    $scope.changeMenuStatus();

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }
    //显示数据
    $http({
      method: 'GET',
      url: '/api/finalDiagnosisSpecialCircumstances/' + sessionStorage.getItem('patientId')
    }).then(function(response) {
      var finalDiagnosis = response.data;
      $scope.pbcClinicalStage = finalDiagnosis.pbcClinicalStage;
      $scope.aihClinicalStage = finalDiagnosis.aihClinicalStage;
      $scope.children = finalDiagnosis.children;
      $scope.gestationPeriod = finalDiagnosis.gestationPeriod;
      $scope.repeatedRelapse = finalDiagnosis.repeatedRelapse;
      $scope.resistantToSteroidTreatment = finalDiagnosis.resistantToSteroidTreatment;
      $scope.patientsWithChronicHepatitisB = finalDiagnosis.patientsWithChronicHepatitisB;
      $scope.patientsWithChronicHepatitisC = finalDiagnosis.patientsWithChronicHepatitisC;
      $scope.overlappingAIHPBC = finalDiagnosis.overlappingAIHPBC;
      $scope.overlappingAIHPSC = finalDiagnosis.overlappingAIHPSC;
      $scope.autoimmuneCholangitis = finalDiagnosis.autoimmuneCholangitis;
      $scope.finalDiagnosisOther = finalDiagnosis.finalDiagnosisOther;
    });

    //保存数据
    $scope.commit = function() {

      var finalDiagnosis = {};
      finalDiagnosis.patientId = sessionStorage.getItem('patientId');
      finalDiagnosis.pbcClinicalStage = $scope.pbcClinicalStage;
      finalDiagnosis.aihClinicalStage = $scope.aihClinicalStage;
      finalDiagnosis.children = !!$scope.children;
      finalDiagnosis.gestationPeriod = !!$scope.gestationPeriod;
      finalDiagnosis.repeatedRelapse = !!$scope.repeatedRelapse;
      finalDiagnosis.resistantToSteroidTreatment = !!$scope.repeatedRelapse;
      finalDiagnosis.patientsWithChronicHepatitisB = !!$scope.patientsWithChronicHepatitisB;
      finalDiagnosis.patientsWithChronicHepatitisC = !!$scope.patientsWithChronicHepatitisC;
      finalDiagnosis.overlappingAIHPBC = !!$scope.overlappingAIHPBC;
      finalDiagnosis.overlappingAIHPSC = !!$scope.overlappingAIHPSC;
      finalDiagnosis.autoimmuneCholangitis = !!$scope.autoimmuneCholangitis;
      finalDiagnosis.finalDiagnosisOther = !!$scope.finalDiagnosisOther;
      finalDiagnosis.complete = true;
      $http({
        method: 'POST',
        url: '/api/finalDiagnosisSpecialCircumstances',
        data: finalDiagnosis
      }).then(function success() {
        $scope.changeMenuStatus();
        $scope.justModalContent = '保存成功！';
        $('#justModal').modal('show');
      }, function fail() {
        $scope.justModalContent = '保存失败！';
        $('#justModal').modal('show');
      });
    };

    $scope.layout = function() {
      $state.go('home');
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