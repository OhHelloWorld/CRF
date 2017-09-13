import angular from 'angular';

angular.module('diseaseOutcome', ['ui.checkbox'])
  .controller('diseaseOutcomeController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    var mlDiseaseOutcome = {};
    getMlPatient();
    $scope.save = function() {
      mlDiseaseOutcome.patientId = sessionStorage.getItem('mlPatientId');
      mlDiseaseOutcome.outcome = '';
      if ($scope.outcome1) {
        mlDiseaseOutcome.outcome += ' 痊愈';
      }
      if ($scope.outcome2) {
        mlDiseaseOutcome.outcome += ' 好转';
      }
      if ($scope.outcome3) {
        mlDiseaseOutcome.outcome += ' 恶化';
      }
      if ($scope.outcome4) {
        mlDiseaseOutcome.outcome += ' 进展为肝衰竭';
      }
      if ($scope.outcome5) {
        mlDiseaseOutcome.outcome += ' 接受肝移植';
      }
      if ($scope.outcome6) {
        mlDiseaseOutcome.outcome += ' 死亡';
      }
      if ($scope.outcome7) {
        mlDiseaseOutcome.outcome += ' 无变化';
      }
      if ($scope.outcome8) {
        mlDiseaseOutcome.outcome += ' 不详';
      }
      mlDiseaseOutcome.complete = true;
      $http({
        method: 'POST',
        url: '/api/diseaseOutcome',
        data: mlDiseaseOutcome
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/diseaseOutcome/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var outcome = response.data.outcome.split(' ');
        if (outcome.indexOf('痊愈') != -1) {
          $scope.outcome1 = true;
        }
        if (outcome.indexOf('好转') != -1) {
          $scope.outcome2 = true;
        }
        if (outcome.indexOf('恶化') != -1) {
          $scope.outcome3 = true;
        }
        if (outcome.indexOf('进展为肝衰竭') != -1) {
          $scope.outcome4 = true;
        }
        if (outcome.indexOf('接受肝移植') != -1) {
          $scope.outcome5 = true;
        }
        if (outcome.indexOf('死亡') != -1) {
          $scope.outcome6 = true;
        }
        if (outcome.indexOf('无变化') != -1) {
          $scope.outcome7 = true;
        }
        if (outcome.indexOf('不详') != -1) {
          $scope.outcome8 = true;
        }
      });
    }

    $scope.layout = function() {
      $state.go('mlHome');
    };

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