import angular from 'angular';

angular.module('excludeOther', [])
  .controller('excludeOtherController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
    getPatientInfo();
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

    //后台数据检查后显示
    function checkToPre(condition2) {
      if(!condition2){
        return condition2;
      }else{
        return toPre(condition2);
      }
    }


    $scope.showSaveModal = function () {
      var allData = {};
      allData.patientId = sessionStorage.getItem('mlPatientId');
      allData.antiHav = $scope.antiHav;
      allData.hbvdna = $scope.hbvdna;
      allData.antihcv = $scope.antihcv;
      allData.hcvrna = $scope.hcvrna;
      allData.mononucleosis = $scope.Mononucleosis;
      allData.rheumatoid = $scope.rheumatoid;
      allData.ceruloplasmin = $scope.ceruloplasmin;
      allData.hbsag = $scope.hbsag;
      allData.hbsab = $scope.hbsab;
      allData.hbcab = $scope.hbcab;
      allData.hbeag = $scope.hbeag;
      allData.hbeab = $scope.hbeab;
      allData.ana = $scope.ana;
      allData.ama = $scope.ama;
      allData.amam2 = $scope.amam2;
      allData.sma = $scope.sma;
      allData.lkm = $scope.lkm;
      allData.cytomegalovirus = $scope.cytomegalovirus;
      allData.ebviruses = $scope.ebviruses;
      allData.herpesSimplex = $scope.herpesSimplex;
      allData.complete = true;
      allData.antiHavDate = checkDate($scope.antiHavDate);
      allData.hbvdnaDate = checkDate($scope.hbvdnaDate);
      allData.antihcvDate = checkDate($scope.antihcvDate);
      allData.hcvrnaDate = checkDate($scope.hcvrnaDate);
      allData.mononucleosisDate = checkDate($scope.MononucleosisDate);
      allData.rheumatoidDate = checkDate($scope.rheumatoidDate);
      allData.ceruloplasminDate = checkDate($scope.ceruloplasminDate);
      allData.hepatitisBFiveDate = checkDate($scope.hepatitisBFiveDate);
      allData.autoimmuneAntibodyDate = checkDate($scope.autoimmuneAntibodyDate);
      allData.otherVirusCheckDate = checkDate($scope.otherVirusCheckDate);
      $http({
        method: 'POST',
        url: '/api/exclude/',
        data: allData
      }).then(function () {
        $scope.justModalContent = '操作成功';
        $('#justModal').modal('show');
      }, function () {
        $scope.justModalContent = '操作失败';
        $('#justModal').modal('show');
      });
    };


    $http({
      method: 'GET',
      url: 'api/exclude/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      var getData ={};
      getData = response.data;
      $scope.antiHav = getData.antiHav;
      $scope.hbvdna = getData.hbvdna;
      $scope.antihcv = getData.antihcv;
      $scope.hcvrna = getData.hcvrna;
      $scope.Mononucleosis = getData.mononucleosis;
      $scope.rheumatoid = getData.rheumatoid;
      $scope.ceruloplasmin = getData.ceruloplasmin;
      $scope.hbsag = getData.hbsag;
      $scope.hbsab = getData.hbsab;
      $scope.hbcab = getData.hbcab;
      $scope.hbeag = getData.hbeag;
      $scope.hbeab = getData.hbeab;
      $scope.ana = getData.ana;
      $scope.ama = getData.ama;
      $scope.amam2 = getData.amam2;
      $scope.sma = getData.sma;
      $scope.lkm = getData.lkm;
      $scope.cytomegalovirus = getData.cytomegalovirus;
      $scope.ebviruses = getData.ebviruses;
      $scope.herpesSimplex = getData.herpesSimplex;
      $scope.antiHavDate = checkToPre(getData.antiHavDate);
      $scope.hbvdnaDate = checkToPre(getData.hbvdnaDate);
      $scope.antihcvDate = checkToPre(getData.antihcvDate);
      $scope.hcvrnaDate = checkToPre(getData.hcvrnaDate);
      $scope.MononucleosisDate = checkToPre(getData.mononucleosisDate);
      $scope.rheumatoidDate = checkToPre(getData.rheumatoidDate);
      $scope.ceruloplasminDate = checkToPre(getData.ceruloplasminDate);
      $scope.hepatitisBFiveDate = checkToPre(getData.hepatitisBFiveDate);
      $scope.autoimmuneAntibodyDate = checkToPre(getData.autoimmuneAntibodyDate);
      $scope.otherVirusCheckDate = checkToPre(getData.otherVirusCheckDate);
    });

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



