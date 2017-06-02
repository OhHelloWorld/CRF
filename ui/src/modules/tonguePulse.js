import angular from 'angular';

angular.module('tonguePulse', [])
  .controller('tonguePulseController', ['$scope', '$http','$state', function($scope, $http,$state) {
    var isSave = false;
    $scope.tongueShowClick = function() {
      if ($scope.cb10) {
        $scope.tongueShow = true;
      } else {
        $scope.tongueShow = false;
      }
    };
    $scope.mossyShowClick = function() {
      if ($scope.cb33) {
        $scope.mossyShow = true;
      } else {
        $scope.mossyShow = false;
      }
    };
    $scope.tongueColorShowClick = function() {
      if ($scope.cb40) {
        $scope.tongueColorShow = true;
      } else {
        $scope.tongueColorShow = false;
      }
    };

    $scope.myConfirm = function(flag) {
      var tonguePulse = {};
      judge($scope.cb1, 1, tonguePulse);
      judge($scope.cb2, 2, tonguePulse);
      judge($scope.cb3, 3, tonguePulse);
      judge($scope.cb4, 4, tonguePulse);
      judge($scope.cb5, 5, tonguePulse);
      judge($scope.cb6, 6, tonguePulse);
      judge($scope.cb7, 7, tonguePulse);
      judge($scope.cb8, 8, tonguePulse);
      judge($scope.cb9, 9, tonguePulse);
      judge($scope.cb10, 10, tonguePulse);
      judge($scope.cb11, 11, tonguePulse);
      judge($scope.cb12, 12, tonguePulse);
      judge($scope.cb13, 13, tonguePulse);
      judge($scope.cb14, 14, tonguePulse);
      judge($scope.cb15, 15, tonguePulse);
      judge($scope.cb16, 16, tonguePulse);
      judge($scope.cb17, 17, tonguePulse);
      judge($scope.cb18, 18, tonguePulse);
      judge($scope.cb19, 19, tonguePulse);
      judge($scope.cb20, 20, tonguePulse);
      judge($scope.cb21, 21, tonguePulse);
      judge($scope.cb22, 22, tonguePulse);
      judge($scope.cb23, 23, tonguePulse);
      judge($scope.cb24, 24, tonguePulse);
      judge($scope.cb25, 25, tonguePulse);
      judge($scope.cb26, 26, tonguePulse);
      judge($scope.cb27, 27, tonguePulse);
      judge($scope.cb28, 28, tonguePulse);
      judge($scope.cb29, 29, tonguePulse);
      judge($scope.cb30, 30, tonguePulse);
      judge($scope.cb31, 31, tonguePulse);
      judge($scope.cb32, 32, tonguePulse);
      judge($scope.cb33, 33, tonguePulse);
      judge($scope.cb34, 34, tonguePulse);
      judge($scope.cb35, 35, tonguePulse);
      judge($scope.cb36, 36, tonguePulse);
      judge($scope.cb37, 37, tonguePulse);
      judge($scope.cb38, 38, tonguePulse);
      judge($scope.cb39, 39, tonguePulse);
      judge($scope.cb40, 40, tonguePulse);
      judge($scope.cb41, 41, tonguePulse);
      judge($scope.cb42, 42, tonguePulse);
      judge($scope.cb43, 43, tonguePulse);
      judge($scope.cb44, 44, tonguePulse);
      judge($scope.cb45, 45, tonguePulse);
      judge($scope.cb46, 46, tonguePulse);
      judge($scope.cb47, 47, tonguePulse);
      judge($scope.cb48, 48, tonguePulse);
      judge($scope.cb49, 49, tonguePulse);
      judge($scope.cb50, 50, tonguePulse);
      judge($scope.cb51, 51, tonguePulse);
      judge($scope.cb52, 52, tonguePulse);
      judge($scope.cb53, 53, tonguePulse);
      judge($scope.cb54, 54, tonguePulse);
      judge($scope.cb55, 55, tonguePulse);
      judge($scope.cb56, 56, tonguePulse);
      judge($scope.cb57, 57, tonguePulse);
      judge($scope.cb58, 58, tonguePulse);
      judge($scope.cb59, 59, tonguePulse);
      judge($scope.cb60, 60, tonguePulse);
      judge($scope.cb61, 61, tonguePulse);
      judge($scope.cb62, 62, tonguePulse);
      judge($scope.cb63, 63, tonguePulse);
      judge($scope.cb64, 64, tonguePulse);
      judge($scope.cb65, 65, tonguePulse);
      judge($scope.cb66, 66, tonguePulse);
      judge($scope.cb67, 67, tonguePulse);
      judge($scope.cb68, 68, tonguePulse);
      judge($scope.cb69, 69, tonguePulse);
      judge($scope.cb70, 70, tonguePulse);
      judge($scope.cb71, 71, tonguePulse);
      judge($scope.cb72, 72, tonguePulse);
      judge($scope.cb73, 73, tonguePulse);
      if(flag == 0){
        tonguePulse.complete = false;
      }else if(flag == 1){
        tonguePulse.complete = true;
      }
      console.log(tonguePulse);
      $http({
        method: 'POST',
        url: '/api/tonguePulse',
        data: tonguePulse
      }).then(function success() {
        isSave = true;
        $scope.information = '保存成功！';
        $('#infoModal').modal({
          keyboard: true
        });
      }, function fail() {
        $scope.information = '保存失败！';
        $('#infoModal').modal({
          keyboard: true
        });
      });
    };

    $scope.save = function() {
      if (isSave) {
        $scope.information = '您已保存，请勿重复操作,谢谢';
        $('#infoModal').modal({
          keyboard: true
        });
      } else if (!($scope.cb1 || $scope.cb2 || $scope.cb3 || $scope.cb4 || $scope.cb5 || $scope.cb6 || $scope.cb7 || $scope.cb8) 
          || !($scope.cb9 || $scope.cb10) 
          || !($scope.cb11 || $scope.cb12 || $scope.cb13 || $scope.cb14 || $scope.cb15 || $scope.cb16 || $scope.cb17 || $scope.cb18) 
          || !($scope.cb19 || $scope.cb20 || $scope.cb21 || $scope.cb22 || $scope.cb23 || $scope.cb24 || $scope.cb25 || $scope.cb26 || $scope.cb27 || $scope.cb28 || $scope.cb29 || $scope.cb30 || $scope.cb31) 
          || !($scope.cb32 || $scope.cb33) 
          || !($scope.cb34 || $scope.cb35 || $scope.cb36 || $scope.cb37 || $scope.cb38) 
          || !($scope.cb39 || $scope.cb40) 
          || !($scope.cb41 || $scope.cb42 || $scope.cb43) 
          || !($scope.cb44 || $scope.cb45 || $scope.cb46 || $scope.cb47 || $scope.cb48 || $scope.cb49 || $scope.cb50 || $scope.cb51 || $scope.cb52 || $scope.cb53 || $scope.cb54 || $scope.cb55 || $scope.cb56 || $scope.cb57 || $scope.cb58) 
          || !($scope.cb59 || $scope.cb60 || $scope.cb61 || $scope.cb62 || $scope.cb63 || $scope.cb64 || $scope.cb65 || $scope.cb66 || $scope.cb67 || $scope.cb68 || $scope.cb69 || $scope.cb70 || $scope.cb71 || $scope.cb72 || $scope.cb73)) { 
        $scope.confirmInfo = '填写尚不完整，是否保存？';
        $('#confirmModal').modal({
          keyboard: true
        });
      }else if((!$scope.tongueDescription && $scope.tongueShow) || (!$scope.mossyDes && $scope.mossyShow) || (!$scope.tongueColorDes && $scope.tongueColorShow)){
        $scope.information = '请注明部位！';
        $('#infoModal').modal({
          keyboard: true
        });
      }else{
        $scope.myConfirm(1);
      }
    };

    $scope.next = function() {
      if (isSave) {
        $state.go('phyAChe');
      } else {
        $scope.nextInfo= '进入下一步将失去还未保存的内容，是否继续？';
        $('#nextModal').modal({
          keyboard: true
        });
      }
    };

    $scope.out = function(){
      if(isSave){
        $state.go('home');
      }else{
        $scope.outmation = '继续退出将失去未保存的内容，是否继续';
        $('#outModel').modal({
          keyboard:true
        });
      }
    };

    $scope.outSure = function(){
      $('#outModel').modal('hide');
      $state.go('home');
    };

    $scope.confirmNext = function(){
      $('#nextModal').modal('hide');
      $state.go('phyAChe');
    };


    function judge(status, number, tonguePulse) {
      if(tonguePulse.tongue == undefined){
        tonguePulse.tongue = '';
      }
      if(tonguePulse.tonguePart == undefined){
        tonguePulse.tonguePart = '';
      }
      if(tonguePulse.tonguePartialDescription == undefined){
        tonguePulse.tonguePartialDescription = '';
      }
      if(tonguePulse.tongueBody == undefined){
        tonguePulse.tongueBody = '';
      }
      if(tonguePulse.mossy == undefined){
        tonguePulse.mossy = '';
      }
      if(tonguePulse.mossyPart == undefined){
        tonguePulse.mossyPart = '';
      }
      if(tonguePulse.mossyPartialDescription == undefined){
        tonguePulse.mossyPartialDescription = '';
      }
      if(tonguePulse.tongueColor == undefined){
        tonguePulse.tongueColor = '';
      }
      if(tonguePulse.tongueColorPart == undefined){
        tonguePulse.tongueColorPart = '';
      }
      if(tonguePulse.tongueColorPartialDescription == undefined){
        tonguePulse.tongueColorPartialDescription = '';
      }
      if(tonguePulse.sublingualVaricoseVeins == undefined){
        tonguePulse.sublingualVaricoseVeins = '';
      }
      if(tonguePulse.leftPulse == undefined){
        tonguePulse.leftPulse = '';
      }
      if(tonguePulse.rightPulse == undefined){
        tonguePulse.rightPulse = '';
      }
      if (number == 1 && status == true) {
        tonguePulse.tongue += ',淡红';
        return;
      }
      if (number == 2 && status == true) {
        tonguePulse.tongue += ',淡白';
        return;
      }
      if (number == 3 && status == true) {
        tonguePulse.tongue += ',淡紫';
        return;
      }
      if (number == 4 && status == true) {
        tonguePulse.tongue += ',红';
        return;
      }
      if (number == 5 && status == true) {
        tonguePulse.tongue += ',绛';
        return;
      }
      if (number == 6 && status == true) {
        tonguePulse.tongue += ',青';
        return;
      }
      if (number == 7 && status == true) {
        tonguePulse.tongue += ',紫暗';
        return;
      }
      if (number == 8 && status == true) {
        tonguePulse.tongue += ',瘀点瘀斑';
        return;
      }
      if (number == 9 && status == true) {
        tonguePulse.tonguePart += ',全舌';
        return;
      }
      if (number == 10 && status == true) {
        tonguePulse.tonguePart += ',局部';
        tonguePulse.tonguePartialDescription = $scope.tongueDescription;
        return;
      }
      if (number == 11 && status == true) {
        tonguePulse.tongueBody += ',荣';
        return;
      }
      if (number == 12 && status == true) {
        tonguePulse.tongueBody += ',枯';
        return;
      }
      if (number == 13 && status == true) {
        tonguePulse.tongueBody += ',瘦';
        return;
      }
      if (number == 14 && status == true) {
        tonguePulse.tongueBody += ',胖';
        return;
      }
      if (number == 15 && status == true) {
        tonguePulse.tongueBody += ',齿痕';
        return;
      }
      if (number == 16 && status == true) {
        tonguePulse.tongueBody += ',点刺';
        return;
      }
      if (number == 17 && status == true) {
        tonguePulse.tongueBody += ',裂纹';
        return;
      }
      if (number == 18 && status == true) {
        tonguePulse.tongueBody += ',舌体瘀斑';
        return;
      }
      if (number == 19 && status == true) {
        tonguePulse.mossy += ',薄';
        return;
      }
      if (number == 20 && status == true) {
        tonguePulse.mossy += ',厚';
        return;
      }
      if (number == 21 && status == true) {
        tonguePulse.mossy += ',润';
        return;
      }
      if (number == 22 && status == true) {
        tonguePulse.mossy += ',少津';
        return;
      }
      if (number == 23 && status == true) {
        tonguePulse.mossy += ',燥';
        return;
      }
      if (number == 24 && status == true) {
        tonguePulse.mossy += ',糙';
        return;
      }
      if (number == 25 && status == true) {
        tonguePulse.mossy += ',焦';
        return;
      }
      if (number == 26 && status == true) {
        tonguePulse.mossy += ',枯';
        return;
      }
      if (number == 27 && status == true) {
        tonguePulse.mossy += ',腻';
        return;
      }
      if (number == 28 && status == true) {
        tonguePulse.mossy += ',腐';
        return;
      }
      if (number == 29 && status == true) {
        tonguePulse.mossy += ',剥';
        return;
      }
      if (number == 30 && status == true) {
        tonguePulse.mossy += ',类剥';
        return;
      }
      if (number == 31 && status == true) {
        tonguePulse.mossy += ',无苔';
        return;
      }
      if (number == 32 && status == true) {
        tonguePulse.mossyPart += ',全舌';
        return;
      }
      if (number == 33 && status == true) {
        tonguePulse.mossyPart += ',局部';
        tonguePulse.mossyPartialDescription = $scope.mossyDes;
        return;
      }
      if (number == 34 && status == true) {
        tonguePulse.tongueColor += ',白';
        return;
      }
      if (number == 35 && status == true) {
        tonguePulse.tongueColor += ',略黄';
        return;
      }
      if (number == 36 && status == true) {
        tonguePulse.tongueColor += ',黄';
        return;
      }
      if (number == 37 && status == true) {
        tonguePulse.tongueColor += ',灰';
        return;
      }
      if (number == 38 && status == true) {
        tonguePulse.tongueColor += ',黑';
        return;
      }
      if (number == 39 && status == true) {
        tonguePulse.tongueColorPart += ',全舌';
        return;
      }
      if (number == 40 && status == true) {
        tonguePulse.tongueColorPart += ',局部';
        tonguePulse.tongueColorPartialDescription = $scope.tongueColorDes;
        return;
      }
      if (number == 41 && status == true) {
        tonguePulse.sublingualVaricoseVeins += ',正常';
        return;
      }
      if (number == 42 && status == true) {
        tonguePulse.sublingualVaricoseVeins += ',轻微';
        return;
      }
      if (number == 43 && status == true) {
        tonguePulse.sublingualVaricoseVeins += ',明显';
        return;
      }
      if (number == 44 && status == true) {
        tonguePulse.leftPulse += ',浮';
        return;
      }
      if (number == 45 && status == true) {
        tonguePulse.leftPulse += ',沉';
        return;
      }
      if (number == 46 && status == true) {
        tonguePulse.leftPulse += ',弦';
        return;
      }
      if (number == 47 && status == true) {
        tonguePulse.leftPulse += ',滑';
        return;
      }
      if (number == 48 && status == true) {
        tonguePulse.leftPulse += ',细';
        return;
      }
      if (number == 49 && status == true) {
        tonguePulse.leftPulse += ',数';
        return;
      }
      if (number == 50 && status == true) {
        tonguePulse.leftPulse += ',濡';
        return;
      }
      if (number == 51 && status == true) {
        tonguePulse.leftPulse += ',缓';
        return;
      }
      if (number == 52 && status == true) {
        tonguePulse.leftPulse += ',涩';
        return;
      }
      if (number == 53 && status == true) {
        tonguePulse.leftPulse += ',迟';
        return;
      }
      if (number == 54 && status == true) {
        tonguePulse.leftPulse += ',长';
        return;
      }
      if (number == 55 && status == true) {
        tonguePulse.leftPulse += ',短';
        return;
      }
      if (number == 56 && status == true) {
        tonguePulse.leftPulse += ',虚';
        return;
      }
      if (number == 57 && status == true) {
        tonguePulse.leftPulse += ',弱';
        return;
      }
      if (number == 58 && status == true) {
        tonguePulse.leftPulse += ',结代';
        return;
      }
      if (number == 59 && status == true) {
        tonguePulse.rightPulse += ',浮';
        return;
      }
      if (number == 60 && status == true) {
        tonguePulse.rightPulse += ',沉';
        return;
      }
      if (number == 61 && status == true) {
        tonguePulse.rightPulse += ',弦';
        return;
      }
      if (number == 62 && status == true) {
        tonguePulse.rightPulse += ',滑';
        return;
      }
      if (number == 63 && status == true) {
        tonguePulse.rightPulse += ',细';
        return;
      }
      if (number == 64 && status == true) {
        tonguePulse.rightPulse += ',数';
        return;
      }
      if (number == 65 && status == true) {
        tonguePulse.rightPulse += ',濡';
        return;
      }
      if (number == 66 && status == true) {
        tonguePulse.rightPulse += ',缓';
        return;
      }
      if (number == 67 && status == true) {
        tonguePulse.rightPulse += ',涩';
        return;
      }
      if (number == 68 && status == true) {
        tonguePulse.rightPulse += ',迟';
        return;
      }
      if (number == 69 && status == true) {
        tonguePulse.rightPulse += ',长';
        return;
      }
      if (number == 70 && status == true) {
        tonguePulse.rightPulse += ',短';
        return;
      }
      if (number == 71 && status == true) {
        tonguePulse.rightPulse += ',虚';
        return;
      }
      if (number == 72 && status == true) {
        tonguePulse.rightPulse += ',弱';
        return;
      }
      if (number == 73 && status == true) {
        tonguePulse.rightPulse += ',结代';
        return;
      }
    }
  }]);