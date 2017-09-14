import angular from 'angular';

angular.module('liverInjury', [])
  .controller('liverInjuryController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    var mlLiverInjury = {};

    getMlPatient();
    getLiverInjury();
    
    $scope.save = function() {
      mlLiverInjury.ascites = $scope.ascites;
      mlLiverInjury.hepaticEncephalopathy = $scope.hepaticEncephalopathy;
      mlLiverInjury.extendInr = $scope.extendInr;
      mlLiverInjury.failure = $scope.failure;
      mlLiverInjury.extendHospitalStay = $scope.extendHospitalStay;
      mlLiverInjury.rucam = $scope.rucam;
      mlLiverInjury.complete = true;
      mlLiverInjury.patientId = sessionStorage.getItem('mlPatientId');
      $http({
        method:'POST',
        url:'/api/mlLiverInjury',
        data:mlLiverInjury
      }).then(function success(){
        $('#myModal').modal();
      });
    };

    $scope.layout = function(){
      $state.go('mlHome');
    };

    function getLiverInjury(){
      $http({
        method:'GET',
        url:'/api/mlLiverInjury/'+sessionStorage.getItem('mlPatientId')
      }).then(function success(response){
        var data = response.data;
        $scope.ascites = data.ascites;
        $scope.hepaticEncephalopathy = data.hepaticEncephalopathy;
        $scope.extendInr = data.extendInr;
        $scope.failure = data.failure;
        $scope.extendHospitalStay = data.extendHospitalStay;
        $scope.rucam = data.rucam;
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
  }]);