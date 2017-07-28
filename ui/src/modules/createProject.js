import angular from 'angular';


angular.module('createProject', [])
  .controller('createProjectController', ['$scope', '$http', function($scope, $http) {

    $scope.addActive = function(str) {
      $('#basicData').removeClass('active');
      $('#collectData').removeClass('active');
      if (str === 'basicData') {
        $('#basicData').addClass('active');
        $scope.level1 = true;
        $scope.level2 = false;
      }
      if (str === 'collectData') {
        $('#collectData').addClass('active');
        $scope.level1 = false;
        $scope.level2 = true;
      }
    };

    $scope.submit1 = function() {
      var project = {};
      project.projectName = $scope.projectName;
      project.introduction = $scope.introduction;
      $http({
        method: 'POST',
        url: '/api/projects',
        data: project
      }).then(function success() {
        alert('创建项目成功');
      },function fail(){
        alert('创建项目失败');
      });
    };



  }]);