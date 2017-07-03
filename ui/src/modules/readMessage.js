import angular from 'angular';

angular.module('readMessage', [])
  .controller('readMessageController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
  
    $scope.readMessage = localStorageService.get('message');


    $scope.receive_invite = function(){
      console.log(localStorageService.get('message').content.split(':')[0]);
      $http({
        method: 'POST',
        url: '/api/projects/acceptInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response){
        $rootScope.alertMessage = '已成功接受邀请';
        $('#messageModal').modal('show');
      }, function failCallback(response){
      
      });

    };

    $scope.refuse_invite = function(){
      $http({
        method: 'POST',
        url: '/api/projects/acceptInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response){
        $rootScope.alertMessage = '已成功拒绝邀请';
        $('#messageModal').modal('show');
      }, function failCallback(response){
      
      });



    }



  }]);