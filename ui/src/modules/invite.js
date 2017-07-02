import angular from 'angular';

angular.module('invite', [])
  .controller('inviteController', ['$scope', '$http', '$state', function($scope, $http, $state) {
   

    // var invitedUsers = [];
    // $scope.invitedUrl = ''

   $scope.users = function() {
     console.log(2333);
     $state.go('inviteUsers');
   }
  

     var users = []; 
     $scope.url = '/api/users';
     console.log(users);



  }]);