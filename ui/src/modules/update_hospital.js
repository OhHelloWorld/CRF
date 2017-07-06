import angular from 'angular';

angular.module('updateHospital', [])

  .config(['localStorageServiceProvider', function(localStorageServiceProvider) {

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])

  .controller('updateHospitalController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
    $scope.hospitals = [];

    $scope.url = '/api/hospitals';


    /**
    *点击某个项目的某家医院，将其数据序列化到本地库中
    */
    $scope.click_hospital = function(hospital){  
      localStorageService.set('hospital', hospital);
    };

  }]);