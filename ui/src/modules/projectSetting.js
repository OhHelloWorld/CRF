import angular from 'angular';

angular.module('projectSetting', [])
  .controller('projectSettingController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
    $scope.status_button = '打开数据收集';
    $scope.statusButton = localStorageService.get('project').isCollect;
    isCollect();

    $scope.write_projectStatus = function(){
      if($scope.statusButton){
        $http({
          method: 'PUT',
          url: '/api/projects/data?isCollect=false&&projectId=' + localStorageService.get('project').id
        }).then(function successCallback(response){
          $rootScope.alertMessage = '已关闭数据收集功能';
          $('#messageModal').modal('show');
          $scope.status_button = '打开数据收集';
          $scope.statusButton = false;
        }, function failCallback(response){
      
        });
      }else{
        $http({
          method: 'PUT',
          url: '/api/projects/data?isCollect=true&&projectId=' + localStorageService.get('project').id
        }).then(function successCallback(response){
          $rootScope.alertMessage = '已打开数据收集功能';
          $('#messageModal').modal('show');
          $scope.status_button = '暂停数据收集';
          $scope.statusButton = true;
        }, function failCallback(response){
      
        });
      }

    };

    $scope.delete_project = function(){
      $http({
        method: 'GET',
        url: '/api/projects/' + localStorageService.get('project').id
      }).then(function successCallback(response){
        $rootScope.alertMessage = '成功删除项目';
        $('#messageModal').modal('show');
        setTimeout(function(){
          window.location.href = '/homePage.html';
        }, 500);
      }, function failCallback(response){
      
      });

    };


    function isCollect(){
      if($scope.statusButton){
        $scope.status_button = '暂停数据收集';
      }else{
        $scope.status_button = '打开数据收集';
      }
    }

  }]);