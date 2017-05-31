'use strict';

import angular from 'angular';

var phyAChe = angular.module('phyAChe', []);

phyAChe.controller('phyACheController', ['$scope', '$http', function($scope, $http) {

  $scope.tabTitle = 'xxxx';
  $scope.addTabActive = function(str){
    $('.tab-pane').removeClass('active');
    $(str).addClass('active');
    // $scope.tabTitle = $(str).val;
  };


}]);
