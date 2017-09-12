import angular from 'angular';

angular.module('hospitalAbnormalExamination', [])
  .controller('hospitalAbnormalExaminationController', ['$scope', '$http', 'localStorageService', function($scope, $http, localStorageService) {

    $http({
      method: 'GET',
      url: 'api/mlfae/all/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      $scope.mlfaes = response.data;
    });

    $(function () {
      $('#example2').DataTable({
        'paging': true,
        'lengthChange': false,
        'searching': false,
        'ordering': false,
        'info': false,
        'autoWidth': false
      });
    });
  }]);