import angular from 'angular';

angular.module('firstAbnormalExamination', [])
  .controller('firstAbnormalExaminationController', ['$scope', '$http', function ($scope, $http) {

    $scope.titleName = '肝脏生化检查';
    
    $scope.addTabActive = function (str1, str2) {
      $('.tab-pane').removeClass('active');
      $(str1).addClass('active');
      $scope.titleName = str2;
    };


    $scope.showSaveModal = function() {
      var allData = {};
      allData.patientId = sessionStorage.getItem('mlPatientId');
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
        methods: 'POST',
        url: '/api/mlfae/',
        data: allData
      }).then(function(){
        alert('success');
        $scope.justModalContent = '操作成功';
        $('#justModal').modal('show');
      });
    };


    // $http({
    //   methods: 'GET',
    //   url: ''
    // }).then(function(response) {
    //   var responseData = response.data;
    //   $scope.alt = responseData.alt;
    //   $scope.ast = responseData.ast;
    //   $scope.ggt = responseData.ggt;
    //   $scope.alp = responseData.alp;
    //   $scope.bileAcid = responseData.bileAcid;
    //   $scope.tbil = responseData.tbil;
    //   $scope.dbil = responseData.dbil;
    //   $scope.tp = responseData.tp;
    //   $scope.alb = responseData.alb;
    //   $scope.scr = responseData.scr;
    //   $scope.bun = responseData.bun;
    //   $scope.plasmaGlucose = responseData.plasmaGlucose;
    //   $scope.pt = responseData.pt;
    //   $scope.inr = responseData.inr;
    //   $scope.afp = responseData.afp;
    // });

  }]);