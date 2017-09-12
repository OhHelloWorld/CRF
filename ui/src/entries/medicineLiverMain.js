'use strict';

import '../../node_modules/bootstrap/dist/css/bootstrap.css';
import '../lib/css/css/AdminLTE.min.css';
import '../lib/css/css/skins/skin-blue.min.css';
import '../../node_modules/bootstrap/dist/js/bootstrap.min.js';
import '../lib/js/dataTables.bootstrap.min.js';
import '../../node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css';
import '../../node_modules/angular-ui-bootstrap/src/datepicker/datepicker.js';
import '../../node_modules/bootstrap-datepicker/js/bootstrap-datepicker.js';
import '../../node_modules/chart.js';
import '../../node_modules/angular-chart.js';
import '../lib/css/js/app.min.js';
import '../lib/js/demo.js';
import '../lib/js/jquery.slimscroll.min.js';
import '../lib/js/fastclick.js';


import '../../node_modules/angular-bootstrap-checkbox';


import '../modules/mlHome.js';
import '../modules/mlPatientInfo.js';
import '../modules/mlPatientOverview.js';
import '../modules/diseaseHistory.js';
import '../modules/allergyHistory.js';
import '../modules/drink.js';
import '../modules/drugHistory.js';
import '../modules/symptoms.js';
import '../modules/firstAbnormalExamination.js';
import '../modules/hospitalAbnormalExamination.js';
import '../modules/excludeOther.js';
import '../modules/routineBlood.js';
import '../modules/imagingEndoscopy.js';
import '../modules/liverHistological.js';
import '../modules/liverInjury.js';
import '../modules/mlTreatment.js';
import '../modules/diseaseOutcome.js';
import '../modules/biologicalSamples.js';

import angular from 'angular';
import uiRouter from 'angular-ui-router';

import LocalStorageModule from 'angular-local-storage';

var medicineLiverMain = angular.module('medicineLiverMain', [uiRouter, LocalStorageModule,'mlHome','mlPatientInfo','diseaseHistory','allergyHistory','drink','drugHistory','symptoms','firstAbnormalExamination','hospitalAbnormalExamination','excludeOther','routineBlood','imagingEndoscopy','liverHistological','liverInjury','mlTreatment','diseaseOutcome','biologicalSamples']);

medicineLiverMain.config(['$stateProvider', '$urlRouterProvider', 'localStorageServiceProvider', function($stateProvider, $urlRouterProvider, localStorageServiceProvider) {

  $urlRouterProvider.when('', '/mlHome');

  $stateProvider.state('mlPatientInfo', {
    url: '/mlPatientInfo',
    template: require('../templates/mlPatientInfo.html'),
  })
  .state('mlHome', {
    url: '/mlHome',
    template: require('../templates/mlHome.html')
  })
  .state('diseaseHistory', {
    url: '/diseaseHistory',
    template: require('../templates/diseaseHistory.html')
  })
  .state('allergyHistory', {
    url: '/allergyHistory',
    template: require('../templates/allergyHistory.html')
  })
  .state('drink', {
    url: '/drink',
    template: require('../templates/drink.html')
  })
  .state('drugHistory', {
    url: '/drugHistory',
    template: require('../templates/drugHistory.html')
  })
  .state('symptoms', {
    url: '/symptoms',
    template: require('../templates/symptoms.html')
  })
  .state('firstAbnormalExamination', {
    url: '/firstAbnormalExamination',
    template: require('../templates/firstAbnormalExamination.html')
  })
  .state('hospitalAbnormalExamination', {
    url: '/hospitalAbnormalExamination',
    template: require('../templates/hospitalAbnormalExamination.html')
  })
  .state('excludeOther', {
    url: '/excludeOther',
    template: require('../templates/excludeOther.html')
  })
  .state('routineBlood', {
    url: '/routineBlood',
    template: require('../templates/routineBlood.html')
  })
  .state('mlPatientOverview', {
    url: '/mlPatientOverview',
    template: require('../templates/mlPatientOverview.html')
  })
  .state('imagingEndoscopy', {
    url: '/imagingEndoscopy',
    template: require('../templates/imagingEndoscopy.html')
  })
  .state('liverHistological', {
    url: '/liverHistological',
    template: require('../templates/liverHistological.html')
  })
  .state('liverInjury', {
    url: '/liverInjury',
    template: require('../templates/liverInjury.html')
  })
  .state('mlTreatment', {
    url: '/mlTreatment',
    template: require('../templates/mlTreatment.html')
  })
  .state('diseaseOutcome', {
    url: '/diseaseOutcome',
    template: require('../templates/diseaseOutcome.html')
  })
  .state('biologicalSamples', {
    url: '/biologicalSamples',
    template: require('../templates/biologicalSamples.html')
  });

  localStorageServiceProvider
  .setPrefix('login')
  .setStorageType('sessionStorage')
  .setNotify(true, true);

}]);

medicineLiverMain.controller('medicineLiverMainController', ['$scope', '$http', '$rootScope', '$state', 'localStorageService', function($scope, $http, $rootScope, $state, localStorageService) {
  loginStatus();
  $scope.mlHomeClick = function() {
    $('li').removeClass('active');
    $('#li1').addClass('active');
  };

  $scope.mlPatientMenuClick = function() {
    $('li').removeClass('active');
    $('#li2').addClass('active');
    changeStatus();
  };

  $scope.mlPatientMenuClick1 = function() {
    $('li').removeClass('active');
    $('#li12').addClass('active');
    changeStatus();
  };

  $scope.mlChangeMenuStatus = function() {
    changeStatus();
  };

  $scope.diseaseHistoryClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_disease_history').popover('toggle');
      setTimeout(function() {
        $('#a_disease_history').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li3').addClass('active');
      $state.go('diseaseHistory');
    }
  };

  $scope.allergyClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_allergy').popover('toggle');
      setTimeout(function() {
        $('#a_allergy').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li4').addClass('active');
      $state.go('allergyHistory');
    }
  };

  $scope.drinkClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_drink').popover('toggle');
      setTimeout(function() {
        $('#a_drink').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li5').addClass('active');
      $state.go('drink');
    }
  };

  $scope.drugHistoryClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_drug_history').popover('toggle');
      setTimeout(function() {
        $('#a_drug_history').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li6').addClass('active');
      $state.go('drugHistory');
    }
  };

  $scope.symptomsClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_symptoms').popover('toggle');
      setTimeout(function() {
        $('#a_symptoms').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li7').addClass('active');
      $state.go('symptoms');
    }
  };

  $scope.firstAbnormalExaminationClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_first_abnormal_examination').popover('toggle');
      setTimeout(function() {
        $('#a_first_abnormal_examination').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li8').addClass('active');
      $state.go('firstAbnormalExamination');
    }
  };

  $scope.hospitalAbnormalExaminationClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_hospital_abnormal_examination').popover('toggle');
      setTimeout(function() {
        $('#a_hospital_abnormal_examination').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li9').addClass('active');
      $('#tab1').addClass('active');
      $state.go('hospitalAbnormalExamination');
    }
  };

  $scope.excludeOtherClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_exclude_other').popover('toggle');
      setTimeout(function() {
        $('#a_exclude_other').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li10').addClass('active');
      $state.go('excludeOther');
    }
  };

  $scope.routineBloodClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_routine_blood').popover('toggle');
      setTimeout(function() {
        $('#a_routine_blood').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li11').addClass('active');
      $state.go('routineBlood');
    }
  };

  $scope.imagingEndoscopyClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_imaging_endoscopy').popover('toggle');
      setTimeout(function() {
        $('#a_imaging_endoscopy').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li12').addClass('active');
      $state.go('imagingEndoscopy');
    }
  };

  $scope.liverHistologicalClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_liver_histological').popover('toggle');
      setTimeout(function() {
        $('#a_liver_histological').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li13').addClass('active');
      $state.go('liverHistological');
    }
  };

  $scope.liverInjuryClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_liver_injury').popover('toggle');
      setTimeout(function() {
        $('#a_liver_injury').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li14').addClass('active');
      $state.go('liverInjury');
    }
  };
  $scope.mlTreatmentClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_ml_treatment').popover('toggle');
      setTimeout(function() {
        $('#a_ml_treatment').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li15').addClass('active');
      $state.go('mlTreatment');
    }
  };

  $scope.diseaseOutcomeClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_disease_outcome').popover('toggle');
      setTimeout(function() {
        $('#a_disease_outcome').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li16').addClass('active');
      $state.go('diseaseOutcome');
    }
  };

  $scope.biologicalSamplesClick = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $('#a_biological_samples').popover('toggle');
      setTimeout(function() {
        $('#a_biological_samples').popover('hide');
      }, 1500);
    } else {
      $('li').removeClass('active');
      $('#li17').addClass('active');
      $state.go('biologicalSamples');
    }
  };
  

  $scope.judgeGoHome = function() {
    if (!sessionStorage.getItem('mlPatientId')) {
      $state.go('mlHome');
    }
  };

  function changeStatus() {
    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/diseaseHistory/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#diseaseHistoryMenuNo').addClass('hide');
          $('#diseaseHistoryMenuYes').removeClass('hide');
        } else {
          $('#diseaseHistoryMenuYes').addClass('hide');
          $('#diseaseHistoryMenuNo').removeClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/allergyHistory/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#allergyMenuYes').removeClass('hide');
          $('#allergyMenuNo').addClass('hide');
        } else {
          $('#allergyMenuNo').removeClass('hide');
          $('#allergyMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/drink/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#drinkMenuYes').removeClass('hide');
          $('#drinkMenuNo').addClass('hide');
        } else {
          $('#drinkMenuNo').removeClass('hide');
          $('#drinkMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/drugHistory/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#drugHistoryMenuYes').removeClass('hide');
          $('#drugHistoryMenuNo').addClass('hide');
        } else {
          $('#drugHistoryMenuNo').removeClass('hide');
          $('#drugHistoryMenuYes').addClass('hide');
        }
      }).catch(function err() {});



      $http({
        method: 'GET',
        url: '/api/symptoms/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#symptomsMenuYes').removeClass('hide');
          $('#symptomsMenuNo').addClass('hide');
        } else {
          $('#symptomsMenuNo').removeClass('hide');
          $('#symptomsMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/firstAbnormalExamination/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#firstAbnormalExaminationMenuYes').removeClass('hide');
          $('#firstAbnormalExaminationMenuNo').addClass('hide');
        } else {
          $('#firstAbnormalExaminationMenuNo').removeClass('hide');
          $('#firstAbnormalExaminationMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/hospitalAbnormalExamination/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#hospitalAbnormalExaminationMenuYes').removeClass('hide');
          $('#hospitalAbnormalExaminationMenuNo').addClass('hide');
        } else {
          $('#hospitalAbnormalExaminationMenuNo').removeClass('hide');
          $('#hospitalAbnormalExaminationMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/imagingEndoscopy/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#imagingEndoscopyMenuYes').removeClass('hide');
          $('#imagingEndoscopyMenuNo').addClass('hide');
        } else {
          $('#imagingEndoscopyMenuNo').removeClass('hide');
          $('#imagingEndoscopyMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/excludeOther/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#excludeOtherMenuYes').removeClass('hide');
          $('#excludeOtherMenuNo').addClass('hide');
        } else {
          $('#excludeOtherMenuNo').removeClass('hide');
          $('#excludeOtherMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/routineBlood/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#routineBloodMenuYes').removeClass('hide');
          $('#routineBloodMenuNo').addClass('hide');
        } else {
          $('#routineBloodMenuNo').removeClass('hide');
          $('#routineBloodMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/liverHistological/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#liverHistologicalMenuYes').removeClass('hide');
          $('#liverHistologicalMenuNo').addClass('hide');
        } else {
          $('#liverHistologicalMenuNo').removeClass('hide');
          $('#liverHistologicalMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/mlTreatment/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#mlTreatmentMenuYes').removeClass('hide');
          $('#mlTreatmentMenuNo').addClass('hide');
        } else {
          $('#mlTreatmentMenuNo').removeClass('hide');
          $('#mlTreatmentMenuYes').addClass('hide');
        }
      }).catch(function err() {});

      $http({
        method: 'GET',
        url: '/api/diseaseOutcome/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#diseaseOutcomeMenuYes').removeClass('hide');
          $('#diseaseOutcomeMenuNo').addClass('hide');
        } else {
          $('#diseaseOutcomeMenuNo').removeClass('hide');
          $('#diseaseOutcomeMenuYes').addClass('hide');
        }
      }).catch(function err() {});
      
      $http({
        method: 'GET',
        url: '/api/biologicalSamples/complete/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        if (response.data) {
          $('#biologicalSamplesMenuYes').removeClass('hide');
          $('#biologicalSamplesMenuNo').addClass('hide');
        } else {
          $('#biologicalSamplesMenuNo').removeClass('hide');
          $('#biologicalSamplesMenuYes').addClass('hide');
        }
      }).catch(function err() {});

    }
  }

  function loginStatus() {
    if (!localStorageService.get('user')) {
      window.location.href = '/login.html';
    }
  }

}]);