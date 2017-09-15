import angular from 'angular';

angular.module('imagingEndoscopy', [])
  .controller('imagingEndoscopyController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {

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
      
      var allDate = {};
      allDate.patientId = sessionStorage.getItem('mlPatientId');
      allDate.liverBultrasoundDate = checkDate($scope.liverBultrasoundDate);
      allDate.liverBultrasound = $scope.liverBultrasound;
      allDate.liverBultrasoundBiliaryTract = $scope.liverBultrasoundBiliaryTract;
      allDate.liverBultrasoundEsophagealGastricVarices = $scope.liverBultrasoundEsophagealGastricVarices;

      allDate.liverCt = $scope.liverCt;
      allDate.liverCtDate = checkDate($scope.liverCtDate);
      allDate.liverCtBiliaryTract = $scope.liverCtBiliaryTract;
      allDate.liverCtEsophagealGastricVarices = $scope.liverCtEsophagealGastricVarices;

      allDate.liverMri = $scope.liverMri;
      allDate.liverMriDate = checkDate($scope.liverMriDate);
      allDate.liverMriBiliaryTract = $scope.liverMriBiliaryTract;
      allDate.liverMriEsophagealGastricVarices = $scope.liverMriEsophagealGastricVarices;

      allDate.fibroscan = $scope.fibroscan;
      allDate.fibroscanDate = checkDate($scope.fibroscanDate);
      allDate.fibroscanBiliaryTract = $scope.fibroscanBiliaryTract;
      allDate.fibroscan_esophageal_gastric_varices = $scope.fibroscan_esophageal_gastric_varices;

      allDate.ercp = $scope.ercp;
      allDate.ercpDate = checkDate($scope.ercpDate);
      allDate.ercpBiliaryTract = $scope.ercpBiliaryTract;
      allDate.ercpEsophagealGastricVarices = $scope.ercpEsophagealGastricVarices;

      allDate.mrcp = $scope.mrcp;
      allDate.mrcpDate = checkDate($scope.mrcpDate);
      allDate.mrcpBiliaryTract = $scope.mrcpBiliaryTract;
      allDate.mrcpEsophagealGastricVarices = $scope.mrcpEsophagealGastricVarices;

      allDate.gastroscope = $scope.gastroscope;
      allDate.gastroscopeDate = checkDate($scope.gastroscopeDate);
      allDate.gastroscopeBiliaryTract = $scope.gastroscopeBiliaryTract;
      allDate.gastroscopeEsophagealGastricVarices = $scope.gastroscopeEsophagealGastricVarices;
      $http({
        method: 'POST',
        url: '/api/iesc/',
        data: allDate
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
      url: 'api/iesc/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      var allData = response.data;

      $scope.liverBultrasound = allData.liverBultrasound;
      $scope.liverBultrasoundDate = checkToPre(allData.liverBultrasoundDate);
      $scope.liverBultrasoundBiliaryTract = allData.liverBultrasoundBiliaryTract;
      $scope.liverBultrasoundEsophagealGastricVarices = allData.liverBultrasoundEsophagealGastricVarices;

      $scope.liverCt = allData.liverCt;
      $scope.liverCtDate = checkToPre(allData.liverCtDate);
      $scope.liverCtBiliaryTract = allData.liverCtBiliaryTract;
      $scope.liverCtEsophagealGastricVarices = allData.liverCtEsophagealGastricVarices;

      $scope.liverMri = allData.liverMri;
      $scope.liverMriDate = checkToPre(allData.liverMriDate);
      $scope.liverMriBiliaryTract = allData.liverMriBiliaryTract;
      $scope.liverMriEsophagealGastricVarices = allData.liverMriEsophagealGastricVarices;

      $scope.fibroscan = allData.fibroscan;
      $scope.fibroscanDate = checkToPre(allData.fibroscanDate);
      $scope.fibroscanBiliaryTract = allData.fibroscanBiliaryTract;
      $scope.fibroscan_esophageal_gastric_varices = allData.fibroscan_esophageal_gastric_varices;

      $scope.ercp = allData.ercp;
      $scope.ercpDate = checkToPre(allData.ercpDate);
      $scope.ercpBiliaryTract = allData.ercpBiliaryTract;
      $scope.ercpEsophagealGastricVarices = allData.ercpEsophagealGastricVarices;

      $scope.mrcp = allData.mrcp;
      $scope.mrcpDate = checkToPre(allData.mrcpDate);
      $scope.mrcpBiliaryTract = allData.mrcpBiliaryTract;
      $scope.mrcpEsophagealGastricVarices = allData.mrcpEsophagealGastricVarices;

      $scope.gastroscope = allData.gastroscope;
      $scope.gastroscopeDate = checkToPre(allData.gastroscopeDate);
      $scope.gastroscopeBiliaryTract = allData.gastroscopeBiliaryTract;
      $scope.gastroscopeEsophagealGastricVarices = allData.gastroscopeEsophagealGastricVarices;

    }, function () {
      $scope.justModalContent = '数据获取异常';
      $('#justModal').modal('show');
    });




  }]);