import angular from 'angular';

angular.module('routineBlood', [])
  .controller('routineBloodController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

    $('#datepicker1').datepicker({
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
      if (!condition2) {
        return condition2;
      } else {
        return toPre(condition2);
      }
    }

    $scope.test = function() {
      var allData = {};
      allData.patientId = sessionStorage.getItem('mlPatientId');
      allData.routineBloodDate = checkDate($scope.routineBloodDate);
      allData.wbc = $scope.wbc;
      allData.hb = $scope.hb;
      allData.totalHemoglobin = $scope.totalHemoglobin;
      allData.plt = $scope.plt;
      allData.neutrophil = $scope.neutrophil;
      allData.eosinophil = $scope.eosinophil;

      $http({
        method: 'POST',
        url: 'api/routineBlood/',
        data: allData
      }).then(function() {
        $scope.justModalContent = '操作成功';
        $('#justModal').modal('show');
      }, function() {
        $scope.justModalContent = '操作异常';
        $('#justModal').modal('show');
      });
    };


    $http({
      method: 'GET',
      url: 'api/routineBlood/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      var allData = response.data;
      $scope.routineBloodDate = checkToPre(allData.routineBloodDate);
      $scope.wbc = allData.wbc;
      $scope.hb = allData.hb;
      $scope.totalHemoglobin =allData.totalHemoglobin;
      $scope.plt = allData.plt;
      $scope.neutrophil = allData.neutrophil;
      $scope.eosinophil = allData.eosinophil;
    }, function() {
      $scope.justModalContent = '数据获取异常';
      $('#justModal').modal('show');
    });


  }]);