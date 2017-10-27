import angular from 'angular';

angular.module('biologicalSamples', [])
  .controller('biologicalSamplesController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    var mlBiologicalSamples = {};
    getMlPatient();
    $scope.save = function() {
      mlBiologicalSamples.patientId = sessionStorage.getItem('mlPatientId');
      mlBiologicalSamples.biologicalSamples = '';
      if ($scope.biologicalSamples1) {
        mlBiologicalSamples.biologicalSamples += ' 血清';
      }
      if ($scope.biologicalSamples2) {
        mlBiologicalSamples.biologicalSamples += ' 血浆';
      }
      if ($scope.biologicalSamples3) {
        mlBiologicalSamples.biologicalSamples += ' 组织';
      }
      if ($scope.biologicalSamples4) {
        mlBiologicalSamples.biologicalSamples += ' 尿液';
      }
      if ($scope.biologicalSamples5) {
        mlBiologicalSamples.biologicalSamples += ' 药物';
      }
      if ($scope.biologicalSamples6) {
        mlBiologicalSamples.biologicalSamples += ' 其他';
      }

      mlBiologicalSamples.num1 = $scope.num1;
      mlBiologicalSamples.num2 = $scope.num2;
      mlBiologicalSamples.num3 = $scope.num3;
      mlBiologicalSamples.num4 = $scope.num4;
      mlBiologicalSamples.num5 = $scope.num5;
      mlBiologicalSamples.num6 = $scope.num6;

      mlBiologicalSamples.remark1 = $scope.remark1;
      mlBiologicalSamples.remark2 = $scope.remark2;
      mlBiologicalSamples.remark3 = $scope.remark3;
      mlBiologicalSamples.remark4 = $scope.remark4;
      mlBiologicalSamples.remark5 = $scope.remark5;
      mlBiologicalSamples.remark6 = $scope.remark6;      

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
        var data = response.data;
        var responseBio = data.biologicalSamples.split(' ');
        if (responseBio.indexOf('血清') != -1) {
          $scope.biologicalSamples1 = true;
        }
        if (responseBio.indexOf('血浆') != -1) {
          $scope.biologicalSamples2 = true;
        }
        if (responseBio.indexOf('组织') != -1) {
          $scope.biologicalSamples3 = true;
        }
        if (responseBio.indexOf('尿液') != -1) {
          $scope.biologicalSamples4 = true;
        }
        if (responseBio.indexOf('药物') != -1) {
          $scope.biologicalSamples5 = true;
        }
        if (responseBio.indexOf('其他') != -1) {
          $scope.biologicalSamples6 = true;
        }

        $scope.num1 = data.num1;
        $scope.num2 = data.num2;
        $scope.num3 = data.num3;
        $scope.num4 = data.num4;
        $scope.num5 = data.num5;
        $scope.num6 = data.num6;
      
        $scope.remark1 = data.remark1;
        $scope.remark2 = data.remark2;
        $scope.remark3 = data.remark3;
        $scope.remark4 = data.remark4;
        $scope.remark5 = data.remark5;
        $scope.remark6 = data.remark6;
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