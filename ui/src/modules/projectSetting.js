import angular from 'angular';

angular.module('projectSetting', [])
  .controller('projectSettingController', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
    $scope.status_button = '打开数据收集';
    $scope.statusButton = true;
    $scope.write_projectStatus = function(){
      if($scope.statusButton){
        $rootScope.alertMessage = '已关闭数据收集功能';
        $('#messageModal').modal('show');
        $scope.status_button = '打开数据收集';
        $scope.statusButton = false;
      }else{
        $rootScope.alertMessage = '已打开数据收集功能';
        $('#messageModal').modal('show');
        $scope.status_button = '暂停数据收集';
        $scope.statusButton = true;
      }
    }
  }]);