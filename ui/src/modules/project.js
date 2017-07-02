import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../lib/css/project.css';
import '../commons/page.js';
import '../../node_modules/chart.js/dist/Chart.min.js';
import '../../node_modules/angular-chart.js/dist/angular-chart.min.js';

angular.module('project', [uiRouter, 'chart.js', 'page'])
  .config(['ChartJsProvider', 'localStorageServiceProvider', function(ChartJsProvider, localStorageServiceProvider) {
    ChartJsProvider.setOptions({ colors : [ '#949FB1', '#4D5360'] });

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])

  .controller('projectController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    
    $scope.click_project = localStorageService.get('project');


  }])

  .controller('projectDefaultController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    
    
    
    $scope.labels = ['男病例患者', '女病例患者', '已保存病例', '已提交病例', '所有病例', '所在医院病例', '所在医院男病例', '所在医院女病例'];
    $scope.data = [65, 55, 35, 50, 80, 60, 55, 45,0];
    

    //得到该项目的所有医院
    $scope.url = '/api/projects/' + localStorageService.get('project').id + '/hospital';  

    /**
    *点击某个项目的某家医院，将其数据序列化到本地库中
    */
    $scope.click_hospital = function(hospital){  
      localStorageService.set('hospital', hospital);
    };


  }])

  .controller('projectCaseController', ['$scope', '$http', '$state', '$stateParams', 'localStorageService', function($scope, $http, $state, $stateParams, localStorageService) {
    $scope.Illnesses = [
                        {'identifier':'1213468', 'name':'张三', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'李四', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'秦大柱', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'马云飞', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'赵天成', 'gender':'男', 'age':'25'}
    ]

    $scope.url = '/searchCases/' + $stateParams.project_searchInput + localStorageService.get('project').id;


  }])

  .controller('hospitalDefaultController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    writeIllnessPermission();

    $scope.Illnesses = [
                        {'identifier':'1213468', 'name':'张三', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'李四', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'秦大柱', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'马云飞', 'gender':'男', 'age':'25'},
                        {'identifier':'1213468', 'name':'赵天成', 'gender':'男', 'age':'25'}
    ]

    $scope.url = '/projectCases/' + localStorageService.get('hospital').id + localStorageService.get('project').id;


    /**
    *病例录入权限判断，然后进行控制
    */
    function writeIllnessPermission(){
      if(localStorageService.get('project').role.permissions.contains('病例录入')){

      }else{
        $('#writeIllness').addClass('ng-hide');
      }

    };


  }]);


















