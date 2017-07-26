import angular from 'angular';
import ngFileUpload from 'ng-file-upload';

angular.module('hospital', [ngFileUpload])

.config(['localStorageServiceProvider', function(localStorageServiceProvider) {

  localStorageServiceProvider
    .setPrefix('login')
    .setStorageType('sessionStorage')
    .setNotify(true, true);

}])


.controller('hospitalController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', 'Upload', function($scope, $http, $state, $rootScope, localStorageService, Upload) {
  var hospital1 = localStorageService.get('hospital');
  $scope.image = hospital1.image_url;
  $scope.hospital_name = hospital1.hospitalName;
  $scope.hospital_address = hospital1.address;
  $scope.hospital_addressDetail = hospital1.addressDetail;
  $scope.hospital_telephone = hospital1.telephone;
  $scope.hospital_specialMajor = hospital1.specialMajor;
  $scope.hospital_troducution = hospital1.introduction;
  $scope.hospital_manageRange = hospital1.manageRange;
  $scope.hospitalId = hospital1.id;
  var hospital = {};
  $scope.submitReview = function() {
    dealGraph();
  };

  /**
   *医院图片处理
   */
  function dealGraph() {
    uploadPic($scope.image);
  }


  /**
   *医院图片上传
   */
  function uploadPic(picFile) {
    if (typeof picFile == typeof '') {
      hospital.hospitalName = $scope.hospital_name;
      hospital.address = $scope.hospital_address;
      hospital.addressDetail = $scope.hospital_addressDetail;
      hospital.telephone = $scope.hospital_telphone;
      hospital.specialMajor = $scope.hospital_specialMajor;
      hospital.manageRange = $scope.hospital_manageRange;
      hospital.troduction = $scope.hospital_troducution;
      hospital.image_url = picFile;
      hospital.id = $scope.hospitalId;
      $http({
        method: 'PUT',
        url: '/api/hospitals',
        data: hospital
      }).then(function success() {
        $scope.alertMessage1 = '修改医院成功';
        $('#messageModal1').modal('show');
      }, function failed() {
        $scope.alertMessage1 = '修改医院失败,稍后再试';
        $('#messageModal1').modal('show');
      });
    } else {
      Upload.upload({
        url: '/api/hospitals/upload',
        data: {
          file: picFile
        }
      }).then(function success(response) {
        $scope.imageName = response.data;
        hospital.hospitalName = $scope.hospital_name;
        hospital.address = $scope.hospital_address;
        hospital.addressDetail = $scope.hospital_addressDetail;
        hospital.telephone = $scope.hospital_telphone;
        hospital.specialMajor = $scope.hospital_specialMajor;
        hospital.manageRange = $scope.hospital_manageRange;
        hospital.troduction = $scope.hospital_troducution;
        hospital.image_url = '/hospital/image/' + $scope.imageName + '.jpg';
        hospital.id = $scope.hospitalId;
        $http({
          method: 'PUT',
          url: '/api/hospitals',
          data: hospital
        }).then(function success() {
          $scope.alertMessage1 = '修改医院成功';
          $('#messageModal1').modal('show');
        }, function failed() {
          $scope.alertMessage1 = '修改医院失败,稍后再试';
          $('#messageModal1').modal('show');
        });
      });
    }
  }

  $scope.delete_hospital = function() {
    $http({
      method: 'DELETE',
      url: '/api/hospitals/' + $scope.hospitalId
    }).then(function success() {
      $('#remove_projectModal').modal('hide');
      $scope.alertMessage1 = '删除医院成功';
      $('#messageModal1').modal('show');
    });
  };

}]);