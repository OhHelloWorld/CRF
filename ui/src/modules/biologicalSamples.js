import angular from 'angular';

angular.module('biologicalSamples', [])
  .controller('biologicalSamplesController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    var mlBiologicalSamples = {};
    getMlPatient();
    $scope.save = function() {
      mlBiologicalSamples.patientId = sessionStorage.getItem('mlPatientId');
      mlBiologicalSamples.biologicalSamples = '';
      if ($scope.biologicalSamples1) {
        mlBiologicalSamples.biologicalSamples += ' 否';
      }
      if ($scope.biologicalSamples2) {
        mlBiologicalSamples.biologicalSamples += ' 是';
      }
      if ($scope.biologicalSamples3) {
        mlBiologicalSamples.biologicalSamples += ' 血清';
      }
      if ($scope.biologicalSamples4) {
        mlBiologicalSamples.biologicalSamples += ' 血浆';
      }
      if ($scope.biologicalSamples5) {
        mlBiologicalSamples.biologicalSamples += ' 组织学';
      }
      if ($scope.biologicalSamples6) {
        mlBiologicalSamples.biologicalSamples += ' 尿液';
      }
      if ($scope.biologicalSamples7) {
        mlBiologicalSamples.biologicalSamples += ' 不详';
      }
      mlBiologicalSamples.complete = true;

      $http({
        method:'POST',
        url:'/api/mlBiologicalSamples',
        data:mlBiologicalSamples
      }).then(function success(){
        $('#myModal').modal();
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlBiologicalSamples/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var responseBio = response.data.biologicalSamples.split(' ');
        if (responseBio.indexOf('否') != -1) {
          $scope.biologicalSamples1 = true;
        }
        if (responseBio.indexOf('是') != -1) {
          $scope.biologicalSamples2 = true;
        }
        if (responseBio.indexOf('血清') != -1) {
          $scope.biologicalSamples3 = true;
        }
        if (responseBio.indexOf('血浆') != -1) {
          $scope.biologicalSamples4 = true;
        }
        if (responseBio.indexOf('组织学') != -1) {
          $scope.biologicalSamples5 = true;
        }
        if (responseBio.indexOf('尿液') != -1) {
          $scope.biologicalSamples6 = true;
        }
        if (responseBio.indexOf('不详') != -1) {
          $scope.biologicalSamples7 = true;
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