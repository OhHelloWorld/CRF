import angular from 'angular';

angular.module('firstAbnormalExamination', [])
  .controller('firstAbnormalExaminationController', ['$scope', '$http', function ($scope, $http) {

    $scope.titleName = '肝脏生化检查';

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

    $scope.addTabActive = function (str1, str2, str3) {
      $('.tab-pane').removeClass('active');
      $(str1).addClass('active');
      $scope.titleName = str2;
      $('.1').addClass('hide');
      $(str3).removeClass('hide');
    };

    // 06/14/2017 ==> 2017-06-14
    function formatDateFromBack(date) {
      var dateArr = date.split('/');
      var year = dateArr[2];
      var month = dateArr[0];
      var day = dateArr[1];
      return year + '-' + month + '-' + day;
    }

    //毫秒转换年月日
    function toPre(date) {
      var unixTimestamp = new Date(date);
      return unixTimestamp.getFullYear() + '-' + (unixTimestamp.getMonth() + 1) + '-' + unixTimestamp.getDate();
    }

    //检查日期字段需要满足的情况
    function checkDate( condition1) {
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

    $scope.showSaveModal = function() {
      var allData = {};
      allData.patientId = sessionStorage.getItem('mlPatientId');
      allData.tab1CheckDate = checkDate($scope.tab1CheckDate);
      allData.tab2CheckDate = checkDate($scope.tab2CheckDate);
      allData.tab3CheckDate = checkDate($scope.tab3CheckDate);
      allData.tab4CheckDate = checkDate($scope.tab4CheckDate);
      allData.tab5CheckDate = checkDate($scope.tab5CheckDate);
      allData.alt = $scope.alt;
      allData.ast = $scope.ast;
      allData.ggt = $scope.ggt;
      allData.alp = $scope.alp;
      allData.bileAcid = $scope.bileAcid; 
      allData.tbil = $scope.tbil;
      allData.dbil = $scope.dbil;
      allData.tp = $scope.tp;
      allData.alb = $scope.alb; 
      allData.scr = $scope.scr;
      allData.bun = $scope.bun;
      allData.plasmaGlucose = $scope.plasmaGlucose;
      allData.pt = $scope.pt;
      allData.inr = $scope.inr;
      allData.afp = $scope.afp;
      console.log(allData);
      $http({
        method: 'POST',
        url: '/api/mlfae/',
        data: allData
      }).then(function(){
        $scope.justModalContent = '操作成功';
        $('#justModal').modal('show');
      }, function() {
        $scope.justModalContent = '操作失败';
        $('#justModal').modal('show');
      });
    };

    $http({
      methods: 'GET',
      url: '/api/mlfae/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      var responseData = response.data;
      if(responseData.tab1CheckDate){
        $scope.tab1CheckDate = toPre(responseData.tab1CheckDate);
      }
      if (responseData.tab2CheckDate) {
        $scope.tab2CheckDate = toPre(responseData.tab2CheckDate);
      }
      if (responseData.tab3CheckDate) {
        $scope.tab3CheckDate = toPre(responseData.tab3CheckDate);
      }
      if (responseData.tab4CheckDate) {
        $scope.tab4CheckDate = toPre(responseData.tab4CheckDate);
      }
      if (responseData.tab5CheckDate) {
        $scope.tab5CheckDate = toPre(responseData.tab5CheckDate);
      }
      $scope.alt = responseData.alt;
      $scope.ast = responseData.ast;
      $scope.ggt = responseData.ggt;
      $scope.alp = responseData.alp;
      $scope.bileAcid = responseData.bileAcid;
      $scope.tbil = responseData.tbil;
      $scope.dbil = responseData.dbil;
      $scope.tp = responseData.tp;
      $scope.alb = responseData.alb;
      $scope.scr = responseData.scr;
      $scope.bun = responseData.bun;
      $scope.plasmaGlucose = responseData.plasmaGlucose;
      $scope.pt = responseData.pt;
      $scope.inr = responseData.inr;
      $scope.afp = responseData.afp;
    });


  }]);