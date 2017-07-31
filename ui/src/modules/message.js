import angular from 'angular';

angular.module('message', [])
  .controller('messageController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {

    loginStatus();
    /**
     *邀请消息接受
     */
    $scope.messages = [];
    $scope.url = '/api/message/user';

    $scope.click_message = function(message) {
      localStorageService.set('message', message);
    };

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }

  }]);