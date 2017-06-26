import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../lib/css/project.css';
import '../commons/page.js';
import '../../node_modules/chart.js/dist/Chart.min.js';
import '../../node_modules/angular-chart.js/dist/angular-chart.min.js';

angular.module('project', [uiRouter, 'chart.js'])
  .config(['ChartJsProvider', 'localStorageServiceProvider', function(ChartJsProvider, localStorageServiceProvider) {
    ChartJsProvider.setOptions({ colors : [ '#949FB1', '#4D5360'] });

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])

  .controller('projectController', ['$scope', '$http', '$state', function($scope, $http, $state) {

  }])

  .controller('projectDefaultController', ['$scope', '$http', '$state', function($scope, $http, $state) {

    $scope.labels = ['男病例患者', '女病例患者', '已保存病例', '已提交病例', '所有病例', '所在医院病例', '所在医院男病例', '所在医院女病例'];
    $scope.data = [65, 55, 35, 50, 80, 60, 55, 45,0];
    $scope.positals = [
                        {'name':'上海书馆', 'address':'大笔大道1号', 'telephone':'1391372189'},
                        {'name':'上海书馆', 'address':'大笔大道1号', 'telephone':'1391372189'},
                        {'name':'上海书馆', 'address':'大笔大道1号', 'telephone':'1391372189'},
                        {'name':'上海书馆', 'address':'大笔大道1号', 'telephone':'1391372189'},
                        {'name':'上海书馆', 'address':'大笔大道1号', 'telephone':'1391372189'}
    ]

    $scope.click_hospital = function(hospital){ 
   
      localStorageService.set('hospital', hospital);

    }
  }])

  .controller('projectCaseController', ['$scope', '$http', '$state', '$stateParams', function($scope, $http, $state, $stateParams) {
    $scope.positals = [
                        {'name':'病例1', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例2', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例3', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例4', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例5', 'address':'发烧，咽炎', 'telephone':'2015-06-25'}
    ]

    console.log($stateParams.project_searchInput);

    /* $http({
      method: 'GET',
      url: '/projecCases/' + $stateParams.project_searchInput  
    }).then(function successCallback(response){

    }, function failCallback(repsonse){
       console.log('暂时没有相关数据！')
    });
 */


  }])

  .controller('hospitalDefaultController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    $scope.positals = [
                        {'name':'病例1', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例2', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例3', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例4', 'address':'发烧，咽炎', 'telephone':'2015-06-25'},
                        {'name':'病例5', 'address':'发烧，咽炎', 'telephone':'2015-06-25'}
    ]
  }]);


















