import angular from 'angular';

angular.module('readMessage', [])
  .controller('readMessageController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
  
    $scope.readMessage = localStorageService.get('message');
    message_status($scope.readMessage.id);
    $scope.receiveName = '接受邀请'; 
    $scope.refuseName = '拒绝邀请';   

    $scope.receive_invite = function(){
      console.log(localStorageService.get('message').content.split(':')[0]);
      $http({
        method: 'POST',
        url: '/api/projects/acceptInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response){
        $rootScope.alertMessage = '已成功接受邀请';
        $('#messageModal').modal('show');
        $scope.receiveName = '已接受邀请'; 
        $('#refuse').addClass('hide');
        $scope.receiveDisabled = true;
      }, function failCallback(response){
      
      });

    };

    $scope.refuse_invite = function(){
      $http({
        method: 'POST',
        url: '/api/projects/rejectInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response){
        $rootScope.alertMessage = '已成功拒绝邀请';
        $('#messageModal').modal('show');
        $scope.refuseName = '已拒绝邀请';
        $('#receive').addClass('hide');
        $scope.refuseDisabled = true;
      }, function failCallback(response){
      
      });

    }

    function message_status(messageId){
      $http({
        method: 'GET',
        url: '/api/message/' + messageId
      }).then(function successCallback(response){
        
      }, function failCallback(response){
      
      });

    }

  }]).filter('isRead', function(){
    return function(status) {
      if(status) {
        return "已读"
      }else {
        return "未读"
      }
    } 
  })