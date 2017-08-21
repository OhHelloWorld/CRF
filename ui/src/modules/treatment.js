import angular from 'angular';
import '../entries/main.js';

angular.module('treatment', ['chart.js', 'main'])
  .controller('treatmentController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    loginStatus();
    $scope.judgeGoHome();
    var treatment = {};
    var chineseMedicine = {};
    $scope.treatmentClick();
    $scope.changeMenuStatus();
    getPatientInfo();
    $('#datepicker').datepicker({
      autoclose: true
    });
    getTreatment();
    getChineseMedicine();

    function testfunction(testnumber) {
      $scope.labels.length = 0;
      for (var a = 0; a <= testnumber; a++) {
        $scope.labels.push(a);
      }
    }
    var dateArray = [];
    var dosageArray = [];
    $scope.labels = ['疗程一', '疗程二', '疗程三', '疗程四', '疗程五', '疗程六', '疗程七'];
    $scope.series = ['日剂量'];
    $scope.data = [
      [0, 0, 0, 0, 0, 0, 0]
    ];

    $scope.datasetOverride = [{
      yAxisID: 'y-axis-1'
    }];
    $scope.options = {
      scales: {
        yAxes: [{
          id: 'y-axis-1',
          type: 'linear',
          display: true,
          position: 'left'
        }]
      }
    };

    function loginStatus() {
      if (!localStorageService.get('user')) {
        window.location.href = '/login.html';
      }
    }
    $scope.chartChange = function() {
      testfunction(1);
      switch ($scope.chartSelect) {
        case '1':
          {
            getQdsDose();
            break;
          }
        case '2':
          {
            getQdslDose();
            break;
          }
        case '3':
          {
            getJjqDose();
            break;
          }
        case '4':
          {
            getBdndDose();
            break;
          }
        case '5':
          {
            getLcplDose();
            break;
          }
        case '6':
          {
            getMtxDose();
            break;
          }
        case '7':
          {
            getCysaDose();
            break;
          }
        case '8':
          {
            getCtxDose();
            break;
          }
        case '9':
          {
            getMtmkDose();
            break;
          }
        case '10':
          {
            getQsxsDose();
            break;
          }
        case '11':
          {
            getXqydDose();
            break;
          }
        case '12':
          {
            getFnbtDose();
            break;
          }
        case '13':
          {
            getBzbtDose();
            break;
          }
      }
    };

    for (var j = 1; j < 19; j++) {
      $('#datepicker' + j).datepicker({
        autoclose: true
      });
    }

    $scope.die = function() {
      if ($scope.dieOption == 'die') {
        $scope.isDie = true;
      } else {
        $scope.isDie = false;
      }
    };

    $scope.confirm = function() {
      if ($scope.buttonContent1 == '否' && $scope.buttonContent2 == '是') {
        $('#infoModal').modal('hide');
        $state.go('home');
      }
    };

    $scope.chooseqds = function() {
      $scope.qds1 = false;
      $scope.qds2 = true;
    };
    $scope.removeqds = function() {
      $scope.qds1 = true;
      $scope.qds2 = false;
      $scope.qdsTime = undefined;
      $scope.qdsDose = undefined;
      $scope.qdsHeal = undefined;
    };
    $scope.chooseqdsl = function() {
      $scope.qdsl1 = false;
      $scope.qdsl2 = true;
    };
    $scope.removeqdsl = function() {
      $scope.qdsl1 = true;
      $scope.qdsl2 = false;
      $scope.qdslTime = undefined;
      $scope.qdslDose = undefined;
      $scope.qdslHeal = undefined;
    };
    $scope.choosejjq = function() {
      $scope.jjq1 = false;
      $scope.jjq2 = true;
    };
    $scope.removejjq = function() {
      $scope.jjq1 = true;
      $scope.jjq2 = false;
      $scope.jjqTime = undefined;
      $scope.jjqDose = undefined;
      $scope.jjqHeal = undefined;
    };
    $scope.choosebdnd = function() {
      $scope.bdnd1 = false;
      $scope.bdnd2 = true;
    };
    $scope.removebdnd = function() {
      $scope.bdnd1 = true;
      $scope.bdnd2 = false;
      $scope.bdndTime = undefined;
      $scope.bdndDose = undefined;
      $scope.bdndHeal = undefined;
    };
    $scope.chooselcpl = function() {
      $scope.lcpl1 = false;
      $scope.lcpl2 = true;
    };
    $scope.removelcpl = function() {
      $scope.lcpl1 = true;
      $scope.lcpl2 = false;
      $scope.lcplTime = undefined;
      $scope.lcplDose = undefined;
      $scope.lcplHeal = undefined;
    };
    $scope.choosemtx = function() {
      $scope.mtx1 = false;
      $scope.mtx2 = true;
    };
    $scope.removemtx = function() {
      $scope.mtx1 = true;
      $scope.mtx2 = false;
      $scope.mtxTime = undefined;
      $scope.mtxDose = undefined;
      $scope.mtxHeal = undefined;
    };
    $scope.choosecysa = function() {
      $scope.cysa1 = false;
      $scope.cysa2 = true;
    };
    $scope.removecysa = function() {
      $scope.cysa1 = true;
      $scope.cysa2 = false;
      $scope.cysaTime = undefined;
      $scope.cysaDose = undefined;
      $scope.cysaHeal = undefined;
    };
    $scope.choosectx = function() {
      $scope.ctx1 = false;
      $scope.ctx2 = true;
    };
    $scope.removectx = function() {
      $scope.ctx1 = true;
      $scope.ctx2 = false;
      $scope.ctxTime = undefined;
      $scope.ctxDose = undefined;
      $scope.ctxHeal = undefined;
    };
    $scope.choosemtmk = function() {
      $scope.mtmk1 = false;
      $scope.mtmk2 = true;
    };
    $scope.removemtmk = function() {
      $scope.mtmk1 = true;
      $scope.mtmk2 = false;
      $scope.mtmkTime = undefined;
      $scope.mtmkDose = undefined;
      $scope.mtmkHeal = undefined;
    };
    $scope.chooseqsxs = function() {
      $scope.qsxs1 = false;
      $scope.qsxs2 = true;
    };
    $scope.removeqsxs = function() {
      $scope.qsxs1 = true;
      $scope.qsxs2 = false;
      $scope.qsxsTime = undefined;
      $scope.qsxsDose = undefined;
      $scope.qsxsHeal = undefined;
    };
    $scope.choosexqyd = function() {
      $scope.xqyd1 = false;
      $scope.xqyd2 = true;
    };
    $scope.removexqyd = function() {
      $scope.xqyd1 = true;
      $scope.xqyd2 = false;
      $scope.xqydTime = undefined;
      $scope.xqydDose = undefined;
      $scope.xqydHeal = undefined;
    };
    $scope.choosefnbt = function() {
      $scope.fnbt1 = false;
      $scope.fnbt2 = true;
    };
    $scope.removefnbt = function() {
      $scope.fnbt1 = true;
      $scope.fnbt2 = false;
      $scope.fnbtTime = undefined;
      $scope.fnbtDose = undefined;
      $scope.fnbtHeal = undefined;
    };
    $scope.choosebzbt = function() {
      $scope.bzbt1 = false;
      $scope.bzbt2 = true;
    };
    $scope.removebzbt = function() {
      $scope.bzbt1 = true;
      $scope.bzbt2 = false;
      $scope.bzbtTime = undefined;
      $scope.bzbtDose = undefined;
      $scope.bzbtHeal = undefined;
    };
    $scope.choosegyz = function() {
      $scope.gyz1 = false;
      $scope.gyz2 = true;
    };
    $scope.removegyz = function() {
      $scope.gyz1 = true;
      $scope.gyz2 = false;
      $scope.gyzTime = undefined;
    };

    $scope.save = function() {
      var judge = true;
      treatment.patientId = sessionStorage.getItem('patientId');
      treatment.qdsTime = new Date($scope.qdsTime);
      treatment.qdsDose = $scope.qdsDose;
      treatment.qdsHeal = $scope.qdsHeal;
      treatment.qdslTime = new Date($scope.qdslTime);
      treatment.qdslDose = $scope.qdslDose;
      treatment.qdslHeal = $scope.qdslHeal;
      treatment.jjqTime = new Date($scope.jjqTime);
      treatment.jjqDose = $scope.jjqDose;
      treatment.jjqHeal = $scope.jjqHeal;
      treatment.bdndTime = new Date($scope.bdndTime);
      treatment.bdndDose = $scope.bdndDose;
      treatment.bdndHeal = $scope.bdndHeal;
      treatment.lcplTime = new Date($scope.lcplTime);
      treatment.lcplDose = $scope.lcplDose;
      treatment.lcplHeal = $scope.lcplHeal;
      treatment.mtxTime = new Date($scope.mtxTime);
      treatment.mtxDose = $scope.mtxDose;
      treatment.mtxHeal = $scope.mtxHeal;
      treatment.cysaTime = new Date($scope.cysaTime);
      treatment.cysaDose = $scope.cysaDose;
      treatment.cysaHeal = $scope.cysaHeal;
      treatment.ctxTime = new Date($scope.ctxTime);
      treatment.ctxDose = $scope.ctxDose;
      treatment.ctxHeal = $scope.ctxHeal;
      treatment.mtmkTime = new Date($scope.mtmkTime);
      treatment.mtmkDose = $scope.mtmkDose;
      treatment.mtmkHeal = $scope.mtmkHeal;
      treatment.qsxsTime = new Date($scope.qsxsTime);
      treatment.qsxsDose = $scope.qsxsDose;
      treatment.qsxsHeal = $scope.qsxsHeal;
      treatment.xqydTime = new Date($scope.xqydTime);
      treatment.xqydDose = $scope.xqydDose;
      treatment.xqydHeal = $scope.xqydHeal;
      treatment.fnbtTime = new Date($scope.fnbtTime);
      treatment.fnbtDose = $scope.fnbtDose;
      treatment.fnbtHeal = $scope.fnbtHeal;
      treatment.bzbtTime = new Date($scope.bzbtTime);
      treatment.bzbtDose = $scope.bzbtDose;
      treatment.bzbtHeal = $scope.bzbtHeal;
      treatment.gyzTime = new Date($scope.gyzTime);
      treatment.gyzDetails = new Date($scope.gyzDetTime);
      treatment.gyzResult = $scope.dieOption;
      treatment.gyzReason = $scope.gyzReason;
      treatment.followUp = $scope.follow;
      treatment.followUpDate = new Date($scope.followUpDate);
      treatment.complete = true;

      chineseMedicine.patientId = sessionStorage.getItem('patientId');
      chineseMedicine.chineseMedicineTime = new Date($scope.chineseMedicineTime);
      chineseMedicine.chineseMedicineFormulasDose = $scope.chineseMedicineDose;
      chineseMedicine.chineseMedicineHeal = $scope.chineseMedicineHeal;
      chineseMedicine.aProprietaryMedicineTime = new Date($scope.aProprietaryMedicineTime);
      chineseMedicine.aProprietaryMedicineName = $scope.aProprietaryMedicineName;
      chineseMedicine.aProprietaryMedicineHeal = $scope.aProprietaryMedicineHeal;
      chineseMedicine.bProprietaryMedicineTime = new Date($scope.bProprietaryMedicineTime);
      chineseMedicine.bProprietaryMedicineName = $scope.bProprietaryMedicineName;
      chineseMedicine.bProprietaryMedicineHeal = $scope.bProprietaryMedicineHeal;
      chineseMedicine.followUp = $scope.follow;
      chineseMedicine.followUpDate = new Date($scope.followUpDate);
      chineseMedicine.complete = true;

      if (!sessionStorage.getItem('followTreatId')) {
        $http({
          method: 'POST',
          url: '/api/treatment',
          data: treatment
        }).then(function success() {
          judge = true;
        }, function fail() {
          judge = false;
        });

        $http({
          method: 'POST',
          url: '/api/medicine',
          data: chineseMedicine
        }).then(function success() {
          if (judge == true) {
            $scope.changeMenuStatus();
            initializeModal();
            $('#modalButton1').addClass('hide');
            $('#modalButton2').addClass('hide');
            // $scope.buttonContent2 = '确认';
            $scope.information = '保存成功';
            $('#infoModal').modal({
              keyboard: true
            });
          } else {
            initializeModal();
            $('#modalButton1').addClass('hide');
            $('#modalButton2').addClass('hide');
            $scope.information = '保存失败';
            $('#infoModal').modal({
              keyboard: true
            });
          }
        }, function fail() {
          initializeModal();
          $('#modalButton1').addClass('hide');
          $scope.buttonContent2 = '确认';
          $scope.information = '保存失败';
          $('#infoModal').modal({
            keyboard: true
          });
        });
      } else {
        treatment.id = sessionStorage.getItem('followTreatId');
        treatment.followUp = true;
        treatment.followUpDate = new Date($scope.followUpDate);
        $http({
          method: 'PUT',
          url: '/api/treatment',
          data: treatment
        }).then(function success() {
          initializeModal();
          $('#modalButton1').addClass('hide');
          $('#modalButton2').addClass('hide');
          // $scope.buttonContent2 = '确认';
          $scope.information = '保存成功';
          $('#infoModal').modal({
            keyboard: true
          });
        }, function fail() {
          initializeModal();
          $('#modalButton1').addClass('hide');
          $scope.buttonContent2 = '确认';
          $scope.information = '保存失败';
          $('#infoModal').modal({
            keyboard: true
          });
        });
      }
    };


    function getTreatment() {
      if (!sessionStorage.getItem('followTreatId')) {
        $http({
          method: 'GET',
          url: '/api/treatment/' + sessionStorage.getItem('patientId')
        }).then(function success(response) {
          giveResultToScope(response);
        });
      } else {
        $http({
          method: 'GET',
          url: '/api/treatment/singleFollow/' + sessionStorage.getItem('followTreatId')
        }).then(function success(response) {
          giveResultToScope(response);
        });
      }
    }

    function giveResultToScope(response) {
      var res = response.data;
      $scope.patientId = sessionStorage.getItem('patientId');
      $scope.followUpDate = res.followUpDate;
      if (res.qdsTime) {
        var date = new Date(res.qdsTime);
        $scope.qdsTime = formatDate(date);
        $scope.qdsDose = res.qdsDose;
        $scope.qdsHeal = res.qdsHeal;
        $scope.qds1 = false;
        $scope.qds2 = true;
      } else {
        $scope.qds1 = true;
        $scope.qds2 = false;
      }
      if (res.qdslTime) {
        date = new Date(res.qdslTime);
        $scope.qdslTime = formatDate(date);
        $scope.qdslDose = res.qdslDose;
        $scope.qdslHeal = res.qdslHeal;
        $scope.qdsl1 = false;
        $scope.qdsl2 = true;
      } else {
        $scope.qdsl1 = true;
        $scope.qdsl2 = false;
      }
      if (res.jjqTime) {
        date = new Date(res.jjqTime);
        $scope.jjqTime = formatDate(date);
        $scope.jjqDose = res.jjqDose;
        $scope.jjqHeal = res.jjqHeal;
        $scope.jjq1 = false;
        $scope.jjq2 = true;
      } else {
        $scope.jjq1 = true;
        $scope.jjq2 = false;
      }
      if (res.bdndTime) {
        date = new Date(res.bdndTime);
        $scope.bdndTime = formatDate(date);
        $scope.bdndDose = res.bdndDose;
        $scope.bdndHeal = res.bdndHeal;
        $scope.bdnd1 = false;
        $scope.bdnd2 = true;
      } else {
        $scope.bdnd1 = true;
        $scope.bdnd2 = false;
      }
      if (res.lcplTime) {
        date = new Date(res.lcplTime);
        $scope.lcplTime = formatDate(date);
        $scope.lcplDose = res.lcplDose;
        $scope.lcplHeal = res.lcplHeal;
        $scope.lcpl1 = false;
        $scope.lcpl2 = true;
      } else {
        $scope.lcpl1 = true;
        $scope.lcpl2 = false;
      }
      if (res.mtxTime) {
        date = new Date(res.mtxTime);
        $scope.mtxTime = formatDate(date);
        $scope.mtxDose = res.mtxDose;
        $scope.mtxHeal = res.mtxHeal;
        $scope.mtx1 = false;
        $scope.mtx2 = true;
      } else {
        $scope.mtx1 = true;
        $scope.mtx2 = false;
      }
      if (res.cysaTime) {
        date = new Date(res.cysaTime);
        $scope.cysaTime = formatDate(date);
        $scope.cysaDose = res.cysaDose;
        $scope.cysaHeal = res.cysaHeal;
        $scope.cysa1 = false;
        $scope.cysa2 = true;
      } else {
        $scope.cysa1 = true;
        $scope.cysa2 = false;
      }
      if (res.ctxTime) {
        date = new Date(res.ctxTime);
        $scope.ctxTime = formatDate(date);
        $scope.ctxDose = res.ctxDose;
        $scope.ctxHeal = res.ctxHeal;
        $scope.ctx1 = false;
        $scope.ctx2 = true;
      } else {
        $scope.ctx1 = true;
        $scope.ctx2 = false;
      }
      if (res.mtmkTime) {
        date = new Date(res.mtmkTime);
        $scope.mtmkTime = formatDate(date);
        $scope.mtmkDose = res.mtmkDose;
        $scope.mtmkHeal = res.mtmkHeal;
        $scope.mtmk1 = false;
        $scope.mtmk2 = true;
      } else {
        $scope.mtmk1 = true;
        $scope.mtmk2 = false;
      }
      if (res.qsxsTime) {
        date = new Date(res.qsxsTime);
        $scope.qsxsTime = formatDate(date);
        $scope.qsxsDose = res.qsxsDose;
        $scope.qsxsHeal = res.qsxsHeal;
        $scope.qsxs1 = false;
        $scope.qsxs2 = true;
      } else {
        $scope.qsxs1 = true;
        $scope.qsxs2 = false;
      }
      if (res.xqydTime) {
        date = new Date(res.xqydTime);
        $scope.xqydTime = formatDate(date);
        $scope.xqydDose = res.xqydDose;
        $scope.xqydHeal = res.xqydHeal;
        $scope.xqyd1 = false;
        $scope.xqyd2 = true;
      } else {
        $scope.xqyd1 = true;
        $scope.xqyd2 = false;
      }
      if (res.fnbtTime) {
        date = new Date(res.fnbtTime);
        $scope.fnbtTime = formatDate(date);
        $scope.fnbtDose = res.fnbtDose;
        $scope.fnbtHeal = res.fnbtHeal;
        $scope.fnbt1 = false;
        $scope.fnbt2 = true;
      } else {
        $scope.fnbt1 = true;
        $scope.fnbt2 = false;
      }
      if (res.bzbtTime) {
        date = new Date(res.bzbtTime);
        $scope.bzbtTime = formatDate(date);
        $scope.bzbtDose = res.bzbtDose;
        $scope.bzbtHeal = res.bzbtHeal;
        $scope.bzbt1 = false;
        $scope.bzbt2 = true;
      } else {
        $scope.bzbt1 = true;
        $scope.bzbt2 = false;
      }
      if (res.gyzTime) {
        date = new Date(res.gyzTime);
        var date1 = new Date(res.gyzDetails);
        $scope.gyzTime = formatDate(date);
        $scope.gyzDetTime = formatDate(date1);
        $scope.dieOption = res.gyzResult;
        if (res.gyzResult == 'die') {
          $scope.isDie = true;
          $scope.gyzReason = res.gyzReason;
        } else {
          $scope.isDie = false;
        }
        $scope.gyz1 = false;
        $scope.gyz2 = true;
      } else {
        $scope.gyz1 = true;
        $scope.gyz2 = false;
        $scope.isDie = false;
      }
    }

    function getChineseMedicine() {
      $http({
        method: 'GET',
        url: '/api/medicine/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        var res = response.data;
        if (res.chineseMedicineTime) {
          $scope.chineseMedicineTime = formatDate(new Date(res.chineseMedicineTime));
        }
        $scope.chineseMedicineDose = res.chineseMedicineFormulasDose;
        $scope.chineseMedicineHeal = res.chineseMedicineHeal;
        if (res.aProprietaryMedicineTime) {
          $scope.aProprietaryMedicineTime = formatDate(new Date(res.aProprietaryMedicineTime));
        }
        $scope.aProprietaryMedicineName = res.aProprietaryMedicineName;
        $scope.aProprietaryMedicineHeal = res.aProprietaryMedicineHeal;
        if (res.bProprietaryMedicineTime) {
          $scope.bProprietaryMedicineTime = formatDate(new Date(res.bProprietaryMedicineTime));
        }
        $scope.bProprietaryMedicineName = res.bProprietaryMedicineName;
        $scope.bProprietaryMedicineHeal = res.bProprietaryMedicineHeal;
      });
    }


    $scope.$watch('follow', function() {
      if ($scope.follow) {
        $scope.followDateShow = true;
        $scope.qdsTime = undefined;
        $scope.qdsDose = undefined;
        $scope.qdsHeal = undefined;
        $scope.qdslTime = undefined;
        $scope.qdslDose = undefined;
        $scope.qdslHeal = undefined;
        $scope.jjqTime = undefined;
        $scope.jjqDose = undefined;
        $scope.jjqHeal = undefined;
        $scope.bdndTime = undefined;
        $scope.bdndDose = undefined;
        $scope.bdndHeal = undefined;
        $scope.lcplTime = undefined;
        $scope.lcplDose = undefined;
        $scope.lcplHeal = undefined;
        $scope.mtxTime = undefined;
        $scope.mtxDose = undefined;
        $scope.mtxHeal = undefined;
        $scope.cysaTime = undefined;
        $scope.cysaDose = undefined;
        $scope.cysaHeal = undefined;
        $scope.ctxTime = undefined;
        $scope.ctxDose = undefined;
        $scope.ctxHeal = undefined;
        $scope.mtmkTime = undefined;
        $scope.mtmkDose = undefined;
        $scope.mtmkHeal = undefined;
        $scope.qsxsTime = undefined;
        $scope.qsxsDose = undefined;
        $scope.qsxsHeal = undefined;
        $scope.xqydTime = undefined;
        $scope.xqydDose = undefined;
        $scope.xqydHeal = undefined;
        $scope.fnbtTime = undefined;
        $scope.fnbtDose = undefined;
        $scope.fnbtHeal = undefined;
        $scope.bzbtTime = undefined;
        $scope.bzbtDose = undefined;
        $scope.bzbtHeal = undefined;
        $scope.gyzTime = undefined;
        $scope.gyzDetTime = undefined;
        $scope.dieOption = undefined;
        $scope.gyzReason = undefined;
        $scope.chineseMedicineTime = undefined;
        $scope.chineseMedicineDose = undefined;
        $scope.chineseMedicineHeal = undefined;
        $scope.aProprietaryMedicineTime = undefined;
        $scope.aProprietaryMedicineName = undefined;
        $scope.aProprietaryMedicineHeal = undefined;
        $scope.bProprietaryMedicineTime = undefined;
        $scope.bProprietaryMedicineName = undefined;
        $scope.bProprietaryMedicineHeal = undefined;
      }
    });

    $scope.layout = function() {
      initializeModal();
      $scope.buttonContent1 = '否';
      $scope.buttonContent2 = '是';
      $scope.information = '是否退出至录入首页';
      $('#infoModal').modal({
        keyboard: true
      });
    };

    function formatDate(myDate) {
      return myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate();
    }

    function initializeModal() {
      $('#modalButton1').removeClass('hide');
      $('#modalButton2').removeClass('hide');
      $scope.buttonContent1 = '';
      $scope.buttonContent2 = '';
    }

    function getPatientInfo() {
      $http({
        method: 'GET',
        url: '/api/patient/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.patientName = response.data.name;
        $scope.patientNumber = response.data.identifier;
      });
    }

    function getQdsDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/getQdsDate/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        var dat = response.data;

        // for(var s : dat) {
        //   $scope.labels.push(s.split("$")[0]);
        //   $scope.data.push(s.split("$")[1]);
        // }

        for (var i = 0; i < dat.length; i++) {
          $scope.labels.push(dat[i].split('$')[0]);
          $scope.data.push(dat[i].split('$')[1]);
        }

        // $scope.data = response.data;
      });
    }

    function getQdslDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/qdsl/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getJjqDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/jjq/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getBdndDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/bdnd/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getLcplDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/lcpl/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getMtxDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/mtx/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getCysaDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/cysa/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getCtxDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/ctx/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getMtmkDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/mtmk/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getQsxsDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/qsxs/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getXqydDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/xqyd/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getFnbtDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/fnbt/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }

    function getBzbtDose() {
      $http({
        method: 'GET',
        url: '/api/treatment/bzbt/' + sessionStorage.getItem('patientId')
      }).then(function success(response) {
        $scope.data = response.data;
      });
    }


  }]);