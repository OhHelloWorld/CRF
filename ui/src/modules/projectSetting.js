import angular from 'angular';

angular.module('projectSetting', [])
  .controller('projectSettingController', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
    $scope.status_button = '开启项目录入';
    $scope.statusButton = true;
    $scope.write_projectStatus = function(){
      if($scope.statusButton){
        $rootScope.alertMessage = '已关闭项目录入功能';
        $('#messageModal').modal('show');
        $scope.status_button = '开启项目录入';
        $scope.statusButton = false;
      }else{
        $rootScope.alertMessage = '已开启项目录入功能';
        $('#messageModal').modal('show');
        $scope.status_button = '关闭项目录入';
        $scope.statusButton = true;
      }
    }
  }]);