import angular from 'angular';

angular.module('createHospital', [])
  .controller('createHospitalController', ['$scope', '$http', '$state', '$rootScope', function($scope, $http, $state, $rootScope) {
    $scope.image ='src/lib/images/hospital1.jpg';

    var hospital = {};
    $scope.submitReview = function(){
      hospital.hospitalName = $scope.hospital_name;
      hospital.address = $scope.hospital_address;
      hospital.addressDetail = $scope.hospital_addressDetail
      hospital.telphone = $scope.hospital_telphone;
      hospital.specialMajor = $scope.hospital_specialMajor;
      hospital.manageRange = $scope.hospital_manageRange;
      hospital.image = $scope.image;

      $http({
        method:'POST',
        url:'/api/hospitals/newHospital',
        data:hospital
      }).then(function success() {
        dealGraph();
        $scope.alertMessage = '创建医院成功';
        $('#messageModal').modal('show');
      }, function failed() {
        $scope.alertMessage = '创建医院失败,稍后再试';
        $('#messageModal').modal('show');
      });


    };


    
    /**
    *医院图片处理
    */
    function dealGraph(){
      if((typeof $scope.image) == (typeof '')){

      }else{
        uploadPic($scope.image, $scope.hospitalName, 'hospital');
      }
    }


    /**
    *医院图片上传
    */
    function uploadPic(picFile, hospitalName, imageType) {
      picFile.upload = Upload.upload({
        url: '/users/uploadImage/' + hospitalName + '/' + imageType,
        data: {file: picFile}
      }).then(function success() {

      });
    };
    
  }]);










