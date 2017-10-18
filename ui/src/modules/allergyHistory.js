import angular from 'angular';

angular.module('allergyHistory', [])
  .controller('allergyHistoryController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    var mlAllergyHistory = {};
    getMlPatient();
    getAllergy();
    $scope.save = function() {
      mlAllergyHistory.patientId = sessionStorage.getItem('mlPatientId');
      mlAllergyHistory.allergyHistory = $scope.allergyHistory;
      mlAllergyHistory.allergen = $scope.allergen;
      mlAllergyHistory.description = $scope.description;
      mlAllergyHistory.complete = true;
      $http({
        method:'POST',
        url:'/api/mlAllergyHistory',
        data:mlAllergyHistory
      }).then(function success(){
        $('#myModal').modal();
      });
    };

    $scope.layout = function() {
      $state.go('mlHome');
    };

    function getAllergy(){
      $http({
        method:'GET',
        url:'/api/mlAllergyHistory/'+sessionStorage.getItem('mlPatientId')
      }).then(function success(response){
        var data1 = response.data;
        $scope.allergyHistory = data1.allergyHistory;
        $scope.allergen = data1.allergen;
        $scope.description = data1.description;
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