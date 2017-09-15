import angular from 'angular';

angular.module('hospitalAbnormalExamination', [])
  .controller('hospitalAbnormalExaminationController', ['$scope', '$http', function($scope, $http) {
    getPatientInfo();
    $scope.pageNum = 1;
    $scope.pageNums = [];
    var allData = {};
    $scope.mlfaes = [];


    //请求所有数据，计算出总页数。
    $http({
      method: 'GET',
      url: 'api/mlfae/all/' + sessionStorage.getItem('mlPatientId')
    }).then(function(response) {

      allData = response.data;
      
      //计算页数
      for (var a = 1; a <= response.data.length / 5; a++) {
        $scope.pageNums.push(a);
      }
      if (response.data.length % 5 != 0) {
        $scope.pageNums.push(Math.ceil(response.data.length / 5));
      }

      //设置默认显示的数据
      if(response.data.length >= 5){
        for(var b = 0; b < 5; b++) {
          $scope.mlfaes.push(response.data[b]);
        }
      }else{
        $scope.mlfaes.push(response.data);
      }

    });



    //根据页数显示数据
    $scope.testFun = function(num) {
      $scope.mlfaes.length = 0;
      for(var a=(num-1)*5+1, b = 0; a<=num*5&&a<=allData.length&&b<5; a++, b++){
        $scope.mlfaes.push(allData[a-1]);
      }
    };

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