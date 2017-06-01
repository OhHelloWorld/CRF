'use strict';

import angular from 'angular';

var phyAChe = angular.module('phyAChe', []);

phyAChe.controller('phyACheController', ['$scope', '$http', function($scope, $http) {


  $scope.tabTitle = '肝功能';
  $scope.addTabActive = function(str1, str2){
    $('.tab-pane').removeClass('active');
    $(str1).addClass('active');
    $scope.tabTitle = str2;
    // $scope.tabTitle = $(str).val;
  };


}]);
