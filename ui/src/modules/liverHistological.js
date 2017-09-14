import angular from 'angular';

angular.module('liverHistological', [])
  .controller('liverHistologicalController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    getLiverHistological();
    getMlPatient();

    var mlLiverHistological = {};

    $('#liverHistologicalDate').datepicker({
      autoclose:true
    });

    $scope.save = function(){
      mlLiverHistological.patientId = sessionStorage.getItem('mlPatientId');
      mlLiverHistological.liverHistologicalResult = $scope.liverHistologicalResult;
      mlLiverHistological.liverHistologicalDate = new Date($scope.liverHistologicalDate);
      mlLiverHistological.complete = true;

      $http({
        method:'POST',
        url:'/api/mlLiverHistological',
        data:mlLiverHistological
      }).then(function success(){
        $('#myModal').modal();
      });
    };

    function getLiverHistological(){
      $http({
        method:'GET',
        url:'/api/mlLiverHistological/'+sessionStorage.getItem('mlPatientId')
      }).then(function success(response){
        var data = response.data;
        $scope.liverHistologicalResult = data.liverHistologicalResult;
        var date = new Date(data.liverHistologicalDate);
        $scope.liverHistologicalDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
        $scope.complete = data.complete;
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