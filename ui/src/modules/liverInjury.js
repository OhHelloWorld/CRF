import angular from 'angular';

angular.module('liverInjury', [])
  .controller('liverInjuryController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    var mlLiverInjury = {};

    getMlPatient();
    getLiverInjury();

    $scope.$watch('alt', function() {
      if ($scope.alt && $scope.alp) {
        $scope.r = $scope.alt / $scope.alp;
      }
    });
    $scope.$watch('alp', function() {
      if ($scope.alt && $scope.alp) {
        $scope.r = $scope.alt / $scope.alp;
      }
    });
    $scope.$watch('r', function() {
      if ($scope.r >= 5.0) {
        $scope.liverInjuryType = '肝细胞型';
      } else if ($scope.r <= 2.0) {
        $scope.liverInjuryType = '胆汁淤积型';
      } else if ($scope.r > 2.0 && $scope.r < 5.0) {
        $scope.liverInjuryType = '混合型';
      }
    });

    $scope.save = function() {
      judge();
      mlLiverInjury.ascites = $scope.ascites;
      mlLiverInjury.hepaticEncephalopathy = $scope.hepaticEncephalopathy;
      mlLiverInjury.extendInr = $scope.extendInr;
      mlLiverInjury.failure = $scope.failure;
      mlLiverInjury.extendHospitalStay = $scope.extendHospitalStay;
      mlLiverInjury.medicine = $scope.medicine;
      mlLiverInjury.alt = $scope.alt;
      mlLiverInjury.alp = $scope.alp;
      mlLiverInjury.r = $scope.r;
      mlLiverInjury.liverInjuryType = $scope.liverInjuryType;
      mlLiverInjury.medicineStart = $scope.medicineStart;
      mlLiverInjury.withdrawalStart = $scope.withdrawalStart;
      mlLiverInjury.stopMedicine = $scope.stopMedicine;
      mlLiverInjury.continueMedicine = $scope.continueMedicine;
      mlLiverInjury.drinkPregnancy = $scope.drinkPregnancy;
      mlLiverInjury.age = $scope.age;
      mlLiverInjury.withMedicine = $scope.withMedicine;
      mlLiverInjury.otherLiverInjuryReason = $scope.otherLiverInjuryReason;
      mlLiverInjury.pastLiverInjuryInformation = $scope.pastLiverInjuryInformation;
      mlLiverInjury.reMedicineResponse = $scope.reMedicineResponse;
      mlLiverInjury.rucam = $scope.rucam;
      mlLiverInjury.complete = true;
      mlLiverInjury.patientId = sessionStorage.getItem('mlPatientId');
      $http({
        method: 'POST',
        url: '/api/mlLiverInjury',
        data: mlLiverInjury
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    $scope.layout = function() {
      $state.go('mlHome');
    };

    function getLiverInjury() {
      $http({
        method: 'GET',
        url: '/api/mlLiverInjury/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.ascites = data.ascites;
        $scope.hepaticEncephalopathy = data.hepaticEncephalopathy;
        $scope.extendInr = data.extendInr;
        $scope.failure = data.failure;
        $scope.extendHospitalStay = data.extendHospitalStay;
        $scope.medicine = data.medicine;
        $scope.alt = data.alt;
        $scope.alp = data.alp;
        $scope.r = data.r;
        $scope.liverInjuryType = data.liverInjuryType;
        $scope.medicineStart = data.medicineStart;
        $scope.withdrawalStart = data.withdrawalStart;
        $scope.stopMedicine = data.stopMedicine;
        $scope.continueMedicine = data.continueMedicine;
        $scope.drinkPregnancy = data.drinkPregnancy;
        $scope.age = data.age;
        $scope.withMedicine = data.withMedicine;
        $scope.otherLiverInjuryReason = data.otherLiverInjuryReason;
        $scope.pastLiverInjuryInformation = data.pastLiverInjuryInformation;
        $scope.reMedicineResponse = data.reMedicineResponse;
        $scope.rucam = data.rucam;
        judge();
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

    function judge() {
      $scope.rucam = 0;
      if ($scope.medicineStart == 1) {
        $scope.rucam += 2;
      } else if ($scope.medicineStart == 2) {
        $scope.rucam += 1;
      }

      if ($scope.withdrawalStart == 1) {
        $scope.rucam += 1;
      }

      if ($scope.stopMedicine == 1) {
        $scope.rucam += 3;
      } else if ($scope.stopMedicine == 2) {
        $scope.rucam += 2;
      } else if ($scope.stopMedicine == 3) {
        $scope.rucam += 1;
      } else if ($scope.stopMedicine == 5) {
        $scope.rucam -= 2;
      }

      if ($scope.drinkPregnancy == 1) {
        $scope.rucam += 1;
      }

      if ($scope.age == 1) {
        $scope.rucam += 1;
      }

      if ($scope.withMedicine == 2) {
        $scope.rucam -= 1;
      } else if ($scope.withMedicine == 3) {
        $scope.rucam -= 2;
      } else if ($scope.withMedicine == 4) {
        $scope.rucam -= 3;
      }

      if ($scope.otherLiverInjuryReason == 1) {
        $scope.rucam += 2;
      } else if ($scope.otherLiverInjuryReason == 2) {
        $scope.rucam += 1;
      } else if ($scope.otherLiverInjuryReason == 4) {
        $scope.rucam -= 2;
      } else if ($scope.otherLiverInjuryReason == 5) {
        $scope.rucam -= 3;
      }

      if ($scope.pastLiverInjuryInformation == 1) {
        $scope.rucam += 2;
      } else if ($scope.pastLiverInjuryInformation == 2) {
        $scope.rucam += 1;
      }

      if ($scope.reMedicineResponse == 1) {
        $scope.rucam += 3;
      } else if ($scope.reMedicineResponse == 2) {
        $scope.rucam += 1;
      } else if ($scope.reMedicineResponse == 3) {
        $scope.rucam -= 2;
      }

      if($scope.rucam > 8){
        $scope.result = '极可能';
      }else if($scope.rucam >=6 && $scope.rucam <=8){
        $scope.result='很可能';
      }else if($scope.rucam >=3 && $scope.rucam <=5){
        $scope.result = '可能';
      }else if($scope.rucam >=1 && $scope.rucam <=2){
        $scope.result = '不太可能';
      }else if($scope.rucam <=0){
        $scope.result = '可排除';
      }

    }
  }]);