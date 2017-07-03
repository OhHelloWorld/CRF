import angular from 'angular';

angular.module('hospital', [])

  .config(['localStorageServiceProvider', function(localStorageServiceProvider) {

    localStorageServiceProvider
      .setPrefix('login')
      .setStorageType('sessionStorage')
      .setNotify(true, true);
  
  }])


  .controller('hospitalController', ['$scope', '$http', '$state', '$rootScope', 'localStorageService', function($scope, $http, $state, $rootScope, localStorageService) {

    var hospiatl = localStorageService.set('hospital', hospital);
    $scope.image = hospiatl.image_url;
    $scope.hospital_name = hospiatl.hospitalName;
    $scope.hospital_address = hospiatl.address;
    $scope.hospital_addressDetail = hospiatl.addressDetail;
    $scope.hospital_telphone = telphone;
    $scope.hospital_specialMajor = specialMajor;
    $scope.hospital_troducution = troduction;

    var hospital = {};
    $scope.submitReview = function(){
      dealGraph();
      hospital.hospitalName = $scope.hospital_name;
      hospital.address = $scope.hospital_address;
      hospital.addressDetail = $scope.hospital_addressDetail;
      hospital.telphone = $scope.hospital_telphone;
      hospital.specialMajor = $scope.hospital_specialMajor;
      hospital.manageRange = $scope.hospital_manageRange;
      hospital.troduction = $scope.hospital_troducution;
      hospital.image_url = '/hospital/image/' + $scope.imageName + '.jpg';

      $http({
        method:'POST',
        url:'/api/hospitals',
        data:hospital
      }).then(function success() {    
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
        $scope.imageName = 'src/lib/images/hospital1.jpg';
      }else{
        uploadPic($scope.image);
      }
    }


    /**
    *医院图片上传
    */
    function uploadPic(picFile) {
      picFile.upload = Upload.upload({
        url: '/api/hospitals/upload',
        data: {file: picFile}
      }).then(function success(response) {
        $scope.imageName = response.data;
      });
    };
    
  }]);