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

    $scope.Illnesses = [];
    searchIllness();
   
    function searchIllness(){
      if(!$stateParams.project_searchInput){
        $scope.url = '/api/case/' + localStorageService.get('project').id;
      }else{
        $scope.url = '/api/case/search/' + localStorageService.get('project').id + '/' + $stateParams.project_searchInput;
      }
    };

  }])

  .controller('hospitalDefaultController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    $scope.click_hospital = localStorageService.get('hospital');
    writeIllnessPermission();

    $scope.Illnesses = [];
    $scope.url = '/api/case/' + localStorageService.get('project').id + '/' + localStorageService.get('hospital').id;


    /**
    *病例录入权限判断，然后进行控制
    */
    
    function writeIllnessPermission(){
      if(!(localStorageService.get('project').currentUserPermissionInProject.contains('新增案例'))){
        $('#writeIllness').addClass('ng-hide');
      }
    };




  }]);



Array.prototype.contains = function(obj) {
  var i = this.length;
  while (i--) {
    if (this[i] === obj) {
      return true;
    }
  }
  return false;
};














