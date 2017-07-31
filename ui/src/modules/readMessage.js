import angular from 'angular';

angular.module('readMessage', [])
  .controller('readMessageController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {
    loginStatus();
    $scope.readMessage = localStorageService.get('message');
    $scope.content = $scope.readMessage.content;
    message_status($scope.readMessage.id);
    judgeStatus();

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }
    $scope.receive_invite = function() {
      console.log(localStorageService.get('message').content.split(':')[0]);
      $http({
        method: 'POST',
        url: '/api/projects/acceptInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response) {
        $rootScope.alertMessage = '已成功接受邀请';
        $('#messageModal').modal('show');
        $scope.receiveName = '已接受邀请';
        $('#refuse').addClass('hide');
        $scope.receiveDisabled = true;
      }, function failCallback(response) {

      });

    };

    $scope.refuse_invite = function() {
      $http({
        method: 'POST',
        url: '/api/projects/rejectInv?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response) {
        $rootScope.alertMessage = '已成功拒绝邀请';
        $('#messageModal').modal('show');
        $scope.refuseName = '已拒绝邀请';
        $('#receive').addClass('hide');
        $scope.refuseDisabled = true;
      }, function failCallback(response) {

      });

    };

    function message_status(messageId) {
      $http({
        method: 'GET',
        url: '/api/message/' + messageId
      }).then(function successCallback(response) {
        $scope.readMessage = response.data;
      }, function failCallback(response) {

      });

    }

    function judgeStatus() {
      $http({
        method: 'GET',
        url: '/api/projects/invited?userId=' + localStorageService.get('user').id + '&&projectName=' + localStorageService.get('message').content.split(':')[0]
      }).then(function successCallback(response) {
        $scope.readStatus = response.data;
        if ($scope.readStatus === '未选择') {
          $scope.receiveName = '接受邀请';
          $scope.refuseName = '拒绝邀请';
        } else if ($scope.readStatus === '拒绝') {
          $scope.refuseName = '已拒绝邀请';
          $('#receive').addClass('hide');
          $scope.refuseDisabled = true;
        } else if ($scope.readStatus === '接受') {
          $scope.receiveName = '已接受邀请';
          $('#refuse').addClass('hide');
          $scope.receiveDisabled = true;
        }
      }, function failCallback(response) {

      });

    }

  }]).filter('isRead', function() {
    return function(status) {
      if (status) {
        return '已读';
      } else {
        return '未读';
      }
    };
  });