import angular from 'angular';
import ngFileUpload from 'ng-file-upload';

angular.module('imagingEndoscopy', [ngFileUpload])
  .controller('imagingEndoscopyController', ['$scope', '$http', '$state', 'localStorageService', 'Upload', function($scope, $http, $state, localStorageService, Upload) {
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
      allDate.fibroscanEsophagealGastricVarices = $scope.fibroscanEsophagealGastricVarices;

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
      allDate.complete = true;
      if ($scope.image == $scope.imageName) {
        allDate.image = $scope.tempImage;
        $http({
          method: 'POST',
          url: '/api/iesc/',
          data: allDate
        }).then(function() {
          $scope.justModalContent = '操作成功';
          $('#justModal').modal('show');
        }, function() {
          $scope.justModalContent = '操作失败';
          $('#justModal').modal('show');
        });
      } else {
        saveImg(allDate);
      }
    };



    $http({
      method: 'GET',
      url: '/api/iesc/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {
      var allData = response.data;

      if (allData.image) {
        $scope.image = '/api/image/' + allData.image + '.jpg';
        $scope.imageName = '/api/image/' + allData.image + '.jpg';
        $scope.tempImage = allData.image;
      } else {
        $scope.image = undefined;
      }

      $scope.liverBultrasound = allData.liverBultrasound;
      $scope.liverBultrasoundDate = checkToPre(allData.liverBultrasoundDate);
      if (allData.liverBultrasoundBiliaryTract) {
        $scope.liverBultrasoundBiliaryTract = allData.liverBultrasoundBiliaryTract;
      } else {
        $scope.liverBultrasoundBiliaryTract = 1;
      }
      if (allData.liverBultrasoundEsophagealGastricVarices) {
        $scope.liverBultrasoundEsophagealGastricVarices = allData.liverBultrasoundEsophagealGastricVarices;
      } else {
        $scope.liverBultrasoundEsophagealGastricVarices = 1;
      }
      $scope.liverCt = allData.liverCt;
      $scope.liverCtDate = checkToPre(allData.liverCtDate);
      if (allData.liverCtBiliaryTract) {
        $scope.liverCtBiliaryTract = allData.liverCtBiliaryTract;
      } else {
        $scope.liverCtBiliaryTract = 1;
      }
      if (allData.liverCtEsophagealGastricVarices) {
        $scope.liverCtEsophagealGastricVarices = allData.liverCtEsophagealGastricVarices;
      } else {
        $scope.liverCtEsophagealGastricVarices = 1;
      }
      $scope.liverMri = allData.liverMri;
      $scope.liverMriDate = checkToPre(allData.liverMriDate);
      if (allData.liverMriBiliaryTract) {
        $scope.liverMriBiliaryTract = allData.liverMriBiliaryTract;
      } else {
        $scope.liverMriBiliaryTract = 1;
      }
      if (allData.liverMriEsophagealGastricVarices) {
        $scope.liverMriEsophagealGastricVarices = allData.liverMriEsophagealGastricVarices;
      } else {
        $scope.liverMriEsophagealGastricVarices = 1;
      }
      $scope.fibroscan = allData.fibroscan;
      $scope.fibroscanDate = checkToPre(allData.fibroscanDate);
      if (allData.fibroscanBiliaryTract) {
        $scope.fibroscanBiliaryTract = allData.fibroscanBiliaryTract;
      } else {
        $scope.fibroscanBiliaryTract = 1;
      }
      if ($scope.fibroscanEsophagealGastricVarices) {
        $scope.fibroscanEsophagealGastricVarices = allData.fibroscanEsophagealGastricVarices;
      } else {
        $scope.fibroscanEsophagealGastricVarices = 1;
      }

      $scope.ercp = allData.ercp;
      $scope.ercpDate = checkToPre(allData.ercpDate);
      if (allData.ercpBiliaryTract) {
        $scope.ercpBiliaryTract = allData.ercpBiliaryTract;
      } else {
        $scope.ercpBiliaryTract = 1;
      }
      if (allData.ercpEsophagealGastricVarices) {
        $scope.ercpEsophagealGastricVarices = allData.ercpEsophagealGastricVarices;
      } else {
        $scope.ercpEsophagealGastricVarices = 1;
      }

      $scope.mrcp = allData.mrcp;
      $scope.mrcpDate = checkToPre(allData.mrcpDate);
      if (allData.mrcpBiliaryTract) {
        $scope.mrcpBiliaryTract = allData.mrcpBiliaryTract;
      } else {
        $scope.mrcpBiliaryTract = 1;
      }
      if (allData.mrcpEsophagealGastricVarices) {
        $scope.mrcpEsophagealGastricVarices = allData.mrcpEsophagealGastricVarices;
      } else {
        $scope.mrcpEsophagealGastricVarices = 1;
      }

      $scope.gastroscope = allData.gastroscope;
      $scope.gastroscopeDate = checkToPre(allData.gastroscopeDate);
      if (allData.gastroscopeBiliaryTract) {
        $scope.gastroscopeBiliaryTract = allData.gastroscopeBiliaryTract;
      } else {
        $scope.gastroscopeBiliaryTract = 1;
      }
      if (allData.gastroscopeEsophagealGastricVarices) {
        $scope.gastroscopeEsophagealGastricVarices = allData.gastroscopeEsophagealGastricVarices;
      } else {
        $scope.gastroscopeEsophagealGastricVarices = 1;
      }

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

    function saveImg(allDate) {
      Upload.upload({
        url: '/api/iesc/upload',
        data: {
          file: $scope.image
        }
      }).then(function success(response) {
        allDate.image = response.data;
        $http({
          method: 'POST',
          url: '/api/iesc/',
          data: allDate
        }).then(function() {
          $scope.justModalContent = '操作成功';
          $('#justModal').modal('show');
        }, function() {
          $scope.justModalContent = '操作失败';
          $('#justModal').modal('show');
        });
      });
    }



  }]);