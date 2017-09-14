import angular from 'angular';

angular.module('excludeOther', [])
  .controller('excludeOtherController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    $('#datepicker1').datepicker({
      autoclose: true
    });
    $('#datepicker2').datepicker({
      autoclose: true
    });
    $('#datepicker3').datepicker({
      autoclose: true
    });
    $('#datepicker4').datepicker({
      autoclose: true
    });
    $('#datepicker5').datepicker({
      autoclose: true
    });
    $('#datepicker6').datepicker({
      autoclose: true
    });
    $('#datepicker7').datepicker({
      autoclose: true
    });
    $('#datepicker8').datepicker({
      autoclose: true
    });
    $('#datepicker9').datepicker({
      autoclose: true
    });
    $('#datepicker10').datepicker({
      autoclose: true
    });
  }]);