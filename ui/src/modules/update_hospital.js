import angular from 'angular';

angular.module('updateHospital', [])

  .config(['localStorageServiceProvider', function(localStorageServiceProvider) {

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])

  .controller('updateHospitalController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
    $scope.hospitals = [
                        {'id':'1', 'name':'上海书馆', 'address_detail':'大笔大道1号', 'telphone':'1391372189'},
                        {'id':'2', 'name':'上海书馆', 'address_detail':'大笔大道1号', 'telphone':'1391372189'},
                        {'id':'3', 'name':'上海书馆', 'address_detail':'大笔大道1号', 'telphone':'1391372189'},
                        {'id':'4', 'name':'上海书馆', 'address_detail':'大笔大道1号', 'telphone':'1391372189'},
                        {'id':'5', 'name':'上海书馆', 'address_detail':'大笔大道1号', 'telphone':'1391372189'}
    ]

    $scope.url = '/projectHospitals';


    /**
    *点击某个项目的某家医院，将其数据序列化到本地库中
    */
    $scope.click_hospital = function(hospital){  
      localStorageService.set('hospital', hospital);
    };

  }]);