'use strict';

import angular from 'angular';
import uiBootstrap from 'angular-ui-bootstrap';

var app = angular.module('page', [uiBootstrap]);
app.directive('myDirective', function() {
  return {
    restrict: 'AE',
    scope: {
      url: '@',
      permissions: '@',
      getData: '='
    },
    template: '<ul uib-pagination total-items="bigTotalItems" ng-model="bigCurrentPage" max-size="maxSize" previous-text="上一页" next-text="下一页" last-text="尾页" first-text="首页" class="pagination-sm" boundary-links="true" force-ellipses="true"  num-pages="numPages"></ul>',
    controller: ['$scope', '$http', function($scope, $http) {
      $scope.maxSize = 5;
      $scope.bigTotalItems = 0;
      $scope.bigCurrentPage = 1;
      if ($scope.url != 'false') {
        $http({
          method: 'GET',
          url: $scope.url
        }).then(function successCallback(response) {
          $scope.bigTotalItems = response.data.totalNumber * 10;
          if (response.data.totalNumber <= 1) {
            $scope.getData = response.data.content;
          } else {
            $scope.getData = response.data.content;
            $('.page').removeClass('ng-hide');
          }
        });
      }


      var nowPage = $scope.bigCurrentPage;
      var peTotalPage = 0;
      $(window).scroll(function() {
        if (($(window).scrollTop() + $(window).height()) >= $(document).height() * 0.95 && $(document).width() <= 980 && peTotalPage !== nowPage + 1) {
          $http({
            method: 'GET',
            url: $scope.url + '?page=' + nowPage
          }).then(function successCallback(response) {

            peTotalPage = response.data.content.totalNumber;
            var c = response.data.content;
            if (c !== null) {
              for (var x in c) {
                $scope.getData.push(c[x]);
              }
              nowPage++;
            }
          });
        }
      });


      $scope.$watch('bigCurrentPage', function(newValue, oldValue) {
        var currentPage = $scope.bigCurrentPage - 1;
        if (newValue != oldValue && $(document).width() > 980) {
          $http({
            method: 'GET',
            url: $scope.url + '?page=' + currentPage
          }).then(function successCallback(response) {
            $scope.bigTotalItems = response.data.totalNumber * 10;
            if (response.data.totalNumber <= 1) {
              $scope.getData = response.data.content;
            } else {
              $scope.getData = response.data.content;
              $('.page').removeClass('ng-hide');
            }
          });
        }

      });

      $scope.$watch('url', function(newValue, oldValue) {
        $scope.bigCurrentPage = 1;
        if (newValue != oldValue) {
          $http({
            method: 'GET',
            url: $scope.url
          }).then(function successCallback(response) {
            $scope.bigTotalItems = response.data.totalNumber * 10;
            if (response.data.totalNumber <= 1) {
              $scope.getData = response.data.content;
            } else {
              $scope.getData = response.data.content;
              $('.page').removeClass('ng-hide');
            }
          });

        }
      });
    }]
  };
});