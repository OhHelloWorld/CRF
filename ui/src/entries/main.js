'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../lib/css/js/app.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import '../../node_modules/chart.js';
import '../../node_modules/angular-chart.js';
// import '../../node_modules/bootstrap/js/modal.js';
import '../../node_modules/angular-bootstrap-checkbox';

import angular from 'angular';
import uiRouter from 'angular-ui-router';
import '../modules/home.js';
import '../modules/fourDiagnostic.js';
import '../modules/patientInfo.js';
import '../modules/phyAChe.js';
import '../modules/tonguePulse.js';
import '../modules/liverPathology.js';
import '../modules/boneDensity.js';
import '../modules/simpleAIH.js';
import '../modules/complexAIH.js';
import '../modules/treatment.js';
import '../modules/finalDiagnosis.js';
import '../modules/patientOverview.js';
import LocalStorageModule from 'angular-local-storage';

var main = angular.module('main', [uiRouter, LocalStorageModule, 'home', 'fourDiagnostic', 'patientInfo', 'phyAChe', 'tonguePulse', 'liverPathology', 'boneDensity', 'simpleAIH', 'complexAIH', 'treatment', 'finalDiagnosis', 'patientOverview']);

main.config(['$stateProvider', '$urlRouterProvider', 'localStorageServiceProvider', function($stateProvider, $urlRouterProvider, localStorageServiceProvider) {

  $urlRouterProvider.when('', '/home');

  $stateProvider.state('patientInfo', {
      url: '/patientInfo',
      template: require('../templates/patientInfo.html'),
    })
    .state('home', {
      url: '/home',
      template: require('../templates/home.html')
    })
    .state('fourDiagnostic', {
      url: '/fourDiagnostic',
      template: require('../templates/fourDiagnostic.html')
    })
    .state('phyAChe', {
      url: '/phyAChe',
      template: require('../templates/phyAChe.html')
    })
    .state('tonguePulse', {
      url: '/tonguePulse',
      template: require('../templates/tonguePulse.html')
    })
    .state('liverPathology', {
      url: '/liverPathology',
      template: require('../templates/liverPathology.html')
    })
    .state('boneDensity', {
      url: '/boneDensity',
      template: require('../templates/boneDensity.html')
    })
    .state('simpleAIH', {
      url: '/simpleAIH',
      template: require('../templates/simpleAIH.html')
    })
    .state('complexAIH', {
      url: '/complexAIH',
      template: require('../templates/complexAIH.html')
    })
    .state('treatment', {
      url: '/treatment',
      template: require('../templates/treatment.html')
    })
    .state('finalDiagnosis', {
      url: '/finalDiagnosis',
      template: require('../templates/finalDiagnosis.html')
    })
    .state('patientOverview', {
      url: '/patientOverview',
      template: require('../templates/patientOverview.html')
    });

  localStorageServiceProvider
    .setPrefix('login')
    .setStorageType('sessionStorage')
    .setNotify(true, true);

}]);

main.controller('mainController', ['$scope', '$http', '$rootScope', '$state', 'localStorageService', function($scope, $http, $rootScope, $state, localStorageService) {
  loginStatus();
  $scope.homeClick = function() {
    $('li').removeClass('active');
    $('#li1').addClass('active');
  };

  $scope.patientMenuClick = function() {
    $('li').removeClass('active');
    $('#li2').addClass('active');
    changeStatus();
  };

  $scope.patientMenuClick1 = function() {
    $('li').removeClass('active');
    $('#li12').addClass('active');
    changeStatus();
  };

  $scope.changeMenuStatus = function() {
    changeStatus();
  };

  $scope.fourClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_four').popover('toggle');
      setTimeout(function() {
        $('#a_four').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li3').addClass('active');
      $state.go('fourDiagnostic');
    }
  };

  $scope.tongueClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_tongue').popover('toggle');
      setTimeout(function() {
        $('#a_tongue').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li4').addClass('active');
      $state.go('tonguePulse');
    }
  };

  $scope.phyClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_phy').popover('toggle');
      setTimeout(function() {
        $('#a_phy').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li5').addClass('active');
      $state.go('phyAChe');
    }
  };

  $scope.liverPathologyClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_liver').popover('toggle');
      setTimeout(function() {
        $('#a_liver').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li6').addClass('active');
      $state.go('liverPathology');
    }
  };

  $scope.boneDensityClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_bone').popover('toggle');
      setTimeout(function() {
        $('#a_bone').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li7').addClass('active');
      $state.go('boneDensity');
    }
  };

  $scope.simpleAIHClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_simple').popover('toggle');
      setTimeout(function() {
        $('#a_simple').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li8').addClass('active');
      $state.go('simpleAIH');
    }
  };

  $scope.complexAIHClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_complex').popover('toggle');
      setTimeout(function() {
        $('#a_complex').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li9').addClass('active');
      $('#tab1').addClass('active');
      $state.go('complexAIH');
    }
  };

  $scope.treatmentClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_treat').popover('toggle');
      setTimeout(function() {
        $('#a_treat').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li10').addClass('active');
      $state.go('treatment');
    }
  };

  $scope.finalDiagnosisClick = function() {
    if (!sessionStorage.getItem('patientId')) {
      $('#a_final').popover('toggle');
      setTimeout(function() {
        $('#a_final').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li11').addClass('active');
      $state.go('finalDiagnosis');
    }
  };

  $scope.judgeGoHome = function() {
    if (!sessionStorage.getItem('patientId')) {
      $state.go('home');
    }
  };

  function changeStatus() {
    if (sessionStorage.getItem('patientId')) {
      $http({
        method: 'GET',
        url: '/api/fourDiagnosticInfor/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#fourMenuNo').addClass('hide');
          $('#fourMenuYes').removeClass('hide');
        } else {
          $('#fourMenuYes').addClass('hide');
          $('#fourMenuNo').removeClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/tonguePulse/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#tongueMenuYes').removeClass('hide');
          $('#tongueMenuNo').addClass('hide');
        } else {
          $('#tongueMenuNo').removeClass('hide');
          $('#tongueMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/physical/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#phyMenuYes').removeClass('hide');
          $('#phyMenuNo').addClass('hide');
        } else {
          $('#phyMenuNo').removeClass('hide');
          $('#phyMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/boneDensity/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#boneMenuYes').removeClass('hide');
          $('#boneMenuNo').addClass('hide');
        } else {
          $('#boneMenuNo').removeClass('hide');
          $('#boneMenuYes').addClass('hide');
        }
      }).catch(function err() {});



      $http({
        method: 'GET',
        url: '/api/complexAIHBeforeTreatment/complete/' + sessionStorage.getItem('patientId')
      }).then(function success() {
        $http({
          method: 'GET',
          url: '/api/complexAIHAfterTreatment/complete/' + sessionStorage.getItem('patientId')
        }).then(function success(response) {
          if (response.data) {
            $('#comAIHMenuYes').removeClass('hide');
            $('#comAIHMenuNo').addClass('hide');
          } else {
            $('#comAIHMenuNo').removeClass('hide');
            $('#comAIHMenuYes').addClass('hide');
          }
        }).catch(function err() {});
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/simpleAIH/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#simAIHMenuYes').removeClass('hide');
          $('#simAIHMenuNo').addClass('hide');
        } else {
          $('#simAIHMenuNo').removeClass('hide');
          $('#simAIHMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/finalDiagnosisSpecialCircumstances/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#finalDiagnosisMenuYes').removeClass('hide');
          $('#finalDiagnosisMenuNo').addClass('hide');
        } else {
          $('#finalDiagnosisMenuNo').removeClass('hide');
          $('#finalDiagnosisMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/liverPathology/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#liverMenuYes').removeClass('hide');
          $('#liverMenuNo').addClass('hide');
        } else {
          $('#liverMenuNo').removeClass('hide');
          $('#liverMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/medicine/complete/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        if (response.data) {
          $('#treatMenuYes').removeClass('hide');
          $('#treatMenuNo').addClass('hide');
        } else {
          $('#treatMenuNo').removeClass('hide');
          $('#treatMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/treatment/complete/' + sessionStorage.getItem('patientId')
      }).then(function success() {
        $http({
          method: 'GET',
          url: '/api/medicine/complete/' + sessionStorage.getItem('patientId')
        }).then(function success(response) {
          if (response.data) {
            $('#treatMenuYes').removeClass('hide');
            $('#treatMenuNo').addClass('hide');
          } else {
            $('#treatMenuNo').removeClass('hide');
            $('#treatMenuYes').addClass('hide');
          }
        }).catch(function err() {});
      }).catch(function err() {});

    }
  }

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }

}]);