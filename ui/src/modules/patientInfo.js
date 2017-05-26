'use strict';

import angular from 'angular';
import '../lib/js/jquery.min.js';

var patientInfo = angular.module('patientInfo', []);

patientInfo.controller('patientInfoController', ['$scope', '$http', function($scope, $http) {
  $('#datepicker').datepicker({
    autoclose: true
  });

}]);
