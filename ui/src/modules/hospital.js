import angular from 'angular';

angular.module('hospital', [])

  .config(['localStorageServiceProvider', function(localStorageServiceProvider) {

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])


  .controller('hospitalController', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
    $scope.image ='src/lib/images/hospital1.jpg';
    $scope.hospital = {'name':'上海曙光医院', 'address':'上海', 'addressDetail':'上海浦东新区', 
                       'telphone':'15554226489', 'specialMajor':'医疗机构', 'manageRange':'病例研究以及共享'};

  }]);