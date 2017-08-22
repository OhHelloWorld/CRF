import angular from 'angular';
import LocalStorageModule from 'angular-local-storage';

angular.module('invite', [LocalStorageModule])
  .config(['localStorageServiceProvider', function(localStorageServiceProvider) {
    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);

  }])
  .controller('inviteController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {


    // var invitedUsers = [];
    // $scope.invitedUrl = ''
    loginStatus();
    var inviteUserId;
    var inviteProject;
    var removeUserId;

    $scope.users = function(type) {
      localStorageService.set('type', type);
      $state.go('inviteUsers');
    };

    var inviteUsers = [];
    $scope.inviteUrl = '/api/projects/' + localStorageService.get('project').id + '/users';
    var users = [];
    $scope.url = '/api/projects/' + localStorageService.get('project').id + '/invUsers';

    $scope.backInvite = function() {

      $state.go('invite');

    };

    $scope.getRemoveName = function(name, userId) {
      removeUserId = userId;
      $scope.removeName = name;
    };

    $scope.getInviteName = function(name, userId) {
      inviteUserId = userId;
      $scope.inviteName = name;
    };

    $scope.invite = function() {
      console.log();
      $http({
        method: 'POST',
        url: '/api/projects/Inv?userId=' + inviteUserId + '&hostId=' + localStorageService.get('user').id + '&projectId=' + localStorageService.get('project').id + '&inviteType=' + localStorageService.get('type')
      }).then(function() {
        setTimeout(function() {
          $state.go('invite');
        }, 500);
      }, function() {

      });
    };

    $scope.remove = function() {


      $http({
        method: 'POST',
        url: '/api/projects/demeber?userId=' + removeUserId + '&projectId=' + localStorageService.get('project').id
      }).then(function() {
        setTimeout(function() {
          $state.reload();
        }, 500);
      }, function() {

      });
    };

    $scope.search_users = function() {

      $scope.url = '/api/users/userName/' + $scope.user_searchInput + '/' + localStorageService.get('project').id;
    };

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }
  }]);