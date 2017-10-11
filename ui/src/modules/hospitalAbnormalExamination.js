import angular from 'angular';

angular.module('hospitalAbnormalExamination', [])
  .controller('hospitalAbnormalExaminationController', ['$scope', '$http', function($scope, $http) {
    getPatientInfo();
    getHosData();
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

    var allData = {};

    // $scope.checkModel = function(str) {
    //   cleanData();
    //   $(str).removeClass('hide');
    //   if(str == '#checkModel'){
    //     $('#saveButton').addClass('disabled');
    //     $scope.pageNums.length = 0;
    //     configPage();
    //     $('#inputModel1').addClass('hide');
    //     $('#inputModel2').addClass('hide');
    //     $('#inputModel3').addClass('hide');
    //     $('#inputModel4').addClass('hide');
    //     $('#inputModel5').addClass('hide');

    //     $('#checkModel1').removeClass('hide');
    //     $('#checkModel2').removeClass('hide');
    //     $('#checkModel3').removeClass('hide');
    //     $('#checkModel4').removeClass('hide');
    //     $('#checkModel5').removeClass('hide');
    //   }else{
    //     $('#saveButton').removeClass('disabled');
    //     $scope.mlfaes.length = 0;
    //     $('#checkModel1').addClass('hide');
    //     $('#checkModel2').addClass('hide');
    //     $('#checkModel3').addClass('hide');
    //     $('#checkModel4').addClass('hide');
    //     $('#checkModel5').addClass('hide');

    //     $('#inputModel1').removeClass('hide');
    //     $('#inputModel2').removeClass('hide');
    //     $('#inputModel3').removeClass('hide');
    //     $('#inputModel4').removeClass('hide');
    //     $('#inputModel5').removeClass('hide');
    //   }
    // };

    //请求所有数据，计算出总页数。
    // $http({
    //   method: 'GET',
    //   url: 'api/mlfae/all/nofirst/' + sessionStorage.getItem('mlPatientId')
    // }).then(function(response) {
    //   allData = response.data;
    //   configPage();
    // });


    // function configPage() {
    //   //计算页数
    //   for (var a = 1; a <= allData.length / 5; a++) {
    //     $scope.pageNums.push(a);
    //   }
    //   if (allData.length % 5 != 0) {
    //     $scope.pageNums.push(Math.ceil(allData.length / 5));
    //   }

    //   //设置默认显示的数据
    //   if (allData.length >= 5) {
    //     for (var b = 0; b < 5; b++) {
    //       $scope.mlfaes.push(allData[b]);
    //     }
    //   } else {
    //     $scope.mlfaes = allData;
    //   }
    // }



    //根据页数显示数据
    // $scope.testFun = function(num) {
    //   $scope.mlfaes.length = 0;
    //   for(var a=(num-1)*5+1, b = 0; a<=num*5&&a<=allData.length&&b<5; a++, b++){
    //     $scope.mlfaes.push(allData[a-1]);
    //   }
    // };

    // 06/14/2017 ==> 2017-06-14
    function formatDateFromBack(date) {
      var dateArr = date.split('/');
      var year = dateArr[2];
      var month = dateArr[0];
      var day = dateArr[1];
      return year + '-' + month + '-' + day;
    }

    //检查日期字段需要满足的情况
    function checkDate(condition1) {
      if (!condition1) {
        return condition1;
      } else {
        if (condition1.includes('-')) {
          return condition1;
        } else {
          return formatDateFromBack(condition1);
        }
      }
    }

    function formatDate(date) {
      var time = new Date(date);
      if (time.toString() != 'Invalid Date') {
        return time.getFullYear() + '-' + (time.getMonth() + 1) + '-' + time.getDate();
      } else {
        return undefined;
      }
    }

    //切换模式数据清空
    // function cleanData() {
    //   $scope.tab1CheckDate = undefined;
    //   $scope.alt = '';
    //   $scope.ast = '';
    //   $scope.ggt = '';
    //   $scope.alp = '';
    //   $scope.bileAcid = '';
    //   $scope.tbil = '';
    //   $scope.dbil = '';
    //   $scope.tp = '';
    //   $scope.alb = '';
    //   $scope.tab2CheckDate = undefined;
    //   $scope.scr = '';
    //   $scope.bun = '';
    //   $scope.tab3CheckDate = undefined;
    //   $scope.plasmaGlucose = '';
    //   $scope.tab4CheckDate = undefined;
    //   $scope.pt = '';
    //   $scope.inr = '';
    //   $scope.tab5CheckDate = undefined;
    //   $scope.afp = '';
    // }

    //保存数据
    $scope.showSaveModal = function() {
      var allDatc = {};
      allDatc.patientId = sessionStorage.getItem('mlPatientId');
      allDatc.tab1CheckDate = checkDate($scope.tab1CheckDate);
      allDatc.tab2CheckDate = checkDate($scope.tab2CheckDate);
      allDatc.tab3CheckDate = checkDate($scope.tab3CheckDate);
      allDatc.tab4CheckDate = checkDate($scope.tab4CheckDate);
      allDatc.tab5CheckDate = checkDate($scope.tab5CheckDate);
      allDatc.alt = $scope.alt;
      allDatc.ast = $scope.ast;
      allDatc.ggt = $scope.ggt;
      allDatc.alp = $scope.alp;
      allDatc.bileAcid = $scope.bileAcid;
      allDatc.tbil = $scope.tbil;
      allDatc.dbil = $scope.dbil;
      allDatc.tp = $scope.tp;
      allDatc.alb = $scope.alb;
      allDatc.scr = $scope.scr;
      allDatc.bun = $scope.bun;
      allDatc.plasmaGlucose = $scope.plasmaGlucose;
      allDatc.pt = $scope.pt;
      allDatc.inr = $scope.inr;
      allDatc.afp = $scope.afp;
      allDatc.first = false;
      allDatc.complete = true;
      $http({
        method: 'POST',
        url: '/api/mlfae/',
        data: allDatc
      }).then(function() {
        $scope.justModalContent = '操作成功';
        $('#justModal').modal('show');
      }, function() {
        $scope.justModalContent = '操作失败';
        $('#justModal').modal('show');
      });
    };

    function getHosData() {
      if (sessionStorage.getItem('mlPatientId')) {
        $http({
          url: '/api/mlfae/hos/' + sessionStorage.getItem('mlPatientId'),
          method: 'GET'
        }).then(function success(response) {
          var data = response.data;
          $scope.tab1CheckDate = formatDate(data.tab1CheckDate);
          $scope.tab2CheckDate = formatDate(data.tab2CheckDate);
          $scope.tab3CheckDate = formatDate(data.tab3CheckDate);
          $scope.tab4CheckDate = formatDate(data.tab4CheckDate);
          $scope.tab5CheckDate = formatDate(data.tab5CheckDate);
          $scope.alt = data.alt;
          $scope.ast = data.ast;
          $scope.ggt = data.ggt;
          $scope.alp = data.alp;
          $scope.bileAcid = data.bileAcid;
          $scope.tbil = data.tbil;
          $scope.dbil = data.dbil;
          $scope.tp = data.tp;
          $scope.alb = data.alb;
          $scope.scr = data.scr;
          $scope.bun = data.bun;
          $scope.plasmaGlucose = data.plasmaGlucose;
          $scope.pt = data.pt;
          $scope.inr = data.inr;
          $scope.afp = data.afp;
        });
      }
    }

    function getPatientInfo() {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        $scope.patientName = response.data.name;
        $scope.patientNumber = response.data.identifier;
      });
    }

  }]);