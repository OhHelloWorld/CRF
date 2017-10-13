import angular from 'angular';

angular.module('diseaseHistory', [])
  .controller('diseaseHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {

    var diseaseHistory = {};
    $scope.diseaseNameObj = {};
    $scope.diseaseTypeObj = {};
    $scope.existenceObj = {};
    $scope.preMedicineObj = {};
    $scope.medicineLiverDiseaseHistoryDetailDTOS = [];

    getMlPatient();

    $scope.$watch('otherHistory', function() {
      if ($scope.otherHistory == 1) {
        $scope.diseaseShow = false;
      } else if ($scope.otherHistory == 2) {
        $scope.diseaseShow = true;
      }
    });

    $scope.$watch('epidemicTourism', function() {
      if ($scope.epidemicTourism == 1) {
        $scope.epi = false;
      } else if ($scope.epidemicTourism == 2) {
        $scope.epi = true;
      }
    });

    var count = 0;

    $scope.addDisease = function() {
      count += 1;
      var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病种类</i></div><select class="form-control" ng-model="diseaseTypeObj[' + count + ']"><option value="呼吸系统疾病">呼吸系统疾病</option><option value="消化系统疾病">消化系统疾病</option><option value="循环系统疾病">循环系统疾病</option><option value="泌尿系统疾病">泌尿系统疾病</option><option value="血液系统疾病">血液系统疾病</option><option value="内分泌系统疾病">内分泌系统疾病</option><option value="新成代谢疾病">新成代谢疾病</option><option value="淋巴系统疾病">淋巴系统疾病</option><option value="神经精神系统疾病">神经精神系统疾病</option><option value="结缔组织疾病">结缔组织疾病</option><option value="妇产科疾病">妇产科疾病</option><option value="儿科疾病">儿科疾病</option><option value="耳鼻喉科疾病">耳鼻喉科疾病</option><option value="眼科疾病">眼科疾病</option><option value="口腔科疾病">口腔科疾病</option><option value="伤骨科疾病">伤骨科疾病</option><option value="皮肤科疾病">皮肤科疾病</option><option value="肿瘤科疾病">肿瘤科疾病</option><option value="传染病与性病">传染病与性病</option><option value="寄生虫疾病">寄生虫疾病</option><option value="男性不育性疾病">男性不育性疾病</option><option value="女性不孕性疾病">女性不孕性疾病</option><option value="男性生殖系统疾病">男性生殖系统疾病</option><option value="疑难杂症">疑难杂症</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病名称</i></div><input class="form-control" ng-model="diseaseNameObj[' + count + ']"></div></div><div class="col-md-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否痊愈</i></div><select ng-model="existenceObj[' + count + ']" class="form-control"><option value="1">是</option><option value="2">否</option></select></div></div><div class="col-md-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 曾用药（药名）</i></div><input class="form-control" ng-model="preMedicineObj[' + count + ']"></div></div>';
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#disease');
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlDiseaseHistory/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.otherHistory = data.otherHistory;
        $scope.pastDisease = data.pastDisease;
        $scope.epidemicTourism = data.epidemicTourism;
        $scope.epidemicText = data.epidemicText;
        var personHistory = data.personHistory.split(' ');
        if(personHistory.indexOf('饮酒')!=-1){
          $scope.oneDrink = true;
        }
        if(personHistory.indexOf('吸烟')!=-1){
          $scope.oneSmoke = true;
        }
        if(personHistory.indexOf('过敏')!=-1){
          $scope.oneAllergy = true;
        }
        if(personHistory.indexOf('感染')!=-1){
          $scope.oneInfect = true;
        }
        if(personHistory.indexOf('手术')!=-1){
          $scope.oneOpera = true;
        }

        if (data.medicineLiverDiseaseHistoryDetailDTOS.length == 0 || data.medicineLiverDiseaseHistoryDetailDTOS.length == 1) {
          count = 0;
        } else {
          count = data.medicineLiverDiseaseHistoryDetailDTOS.length - 1;
        }

        if (data.medicineLiverDiseaseHistoryDetailDTOS.length != 0) {
          $scope.diseaseName = data.medicineLiverDiseaseHistoryDetailDTOS[0].diseaseName;
          $scope.existence = data.medicineLiverDiseaseHistoryDetailDTOS[0].existence;
          $scope.diseaseType = data.medicineLiverDiseaseHistoryDetailDTOS[0].diseaseType;
          $scope.preMedicine = data.medicineLiverDiseaseHistoryDetailDTOS[0].preMedicine;
        }

        for (var i = 1; i < data.medicineLiverDiseaseHistoryDetailDTOS.length; i++) {
          var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病种类</i></div><select class="form-control" ng-model="diseaseTypeObj[' + count + ']"><option value="呼吸系统疾病">呼吸系统疾病</option><option value="消化系统疾病">消化系统疾病</option><option value="循环系统疾病">循环系统疾病</option><option value="泌尿系统疾病">泌尿系统疾病</option><option value="血液系统疾病">血液系统疾病</option><option value="内分泌系统疾病">内分泌系统疾病</option><option value="新成代谢疾病">新成代谢疾病</option><option value="淋巴系统疾病">淋巴系统疾病</option><option value="神经精神系统疾病">神经精神系统疾病</option><option value="结缔组织疾病">结缔组织疾病</option><option value="妇产科疾病">妇产科疾病</option><option value="儿科疾病">儿科疾病</option><option value="耳鼻喉科疾病">耳鼻喉科疾病</option><option value="眼科疾病">眼科疾病</option><option value="口腔科疾病">口腔科疾病</option><option value="伤骨科疾病">伤骨科疾病</option><option value="皮肤科疾病">皮肤科疾病</option><option value="肿瘤科疾病">肿瘤科疾病</option><option value="传染病与性病">传染病与性病</option><option value="寄生虫疾病">寄生虫疾病</option><option value="男性不育性疾病">男性不育性疾病</option><option value="女性不孕性疾病">女性不孕性疾病</option><option value="男性生殖系统疾病">男性生殖系统疾病</option><option value="疑难杂症">疑难杂症</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病名称</i></div><input class="form-control" ng-model="diseaseNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否痊愈</i></div><select ng-model="existenceObj[' + i + ']" class="form-control"><option value="1">是</option><option value="2">否</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 曾用药（药名）</i></div><input class="form-control" ng-model="preMedicineObj[' + i + ']"></div></div>';
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('#disease');
          $scope.diseaseNameObj[i] = data.medicineLiverDiseaseHistoryDetailDTOS[i].diseaseName;
          $scope.existenceObj[i] = data.medicineLiverDiseaseHistoryDetailDTOS[i].existence;
          $scope.diseaseTypeObj[i] = data.medicineLiverDiseaseHistoryDetailDTOS[i].diseaseType;
          $scope.preMedicineObj[i] = data.medicineLiverDiseaseHistoryDetailDTOS[i].preMedicine;
        }
      });
    }

    $scope.save = function() {
      diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS = [];
      diseaseHistory.otherHistory = $scope.otherHistory;
      diseaseHistory.pastDisease = $scope.pastDisease;
      diseaseHistory.epidemicTourism = $scope.epidemicTourism;
      diseaseHistory.epidemicText = $scope.epidemicText;
      diseaseHistory.patientId = sessionStorage.getItem('mlPatientId');
      diseaseHistory.complete = true;
      diseaseHistory.personHistory = '';
      if($scope.oneDrink){
        diseaseHistory.personHistory += ' 饮酒';
      }
      if($scope.oneSmoke){
        diseaseHistory.personHistory += ' 吸烟';
      }
      if($scope.oneAllergy){
        diseaseHistory.personHistory += ' 过敏';
      }
      if($scope.oneInfect){
        diseaseHistory.personHistory += ' 感染';
      }
      if($scope.oneOpera){
        diseaseHistory.personHistory += ' 手术';
      }

      if ($scope.diseaseType != undefined) {
        diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS.push({
          diseaseName: $scope.diseaseName,
          existence: $scope.existence,
          diseaseType: $scope.diseaseType,
          preMedicine: $scope.preMedicine
        });
      }
      for (var i = 1; i <= count; i++) {
        diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS.push({
          diseaseName: ($scope.diseaseNameObj[i]),
          existence: ($scope.existenceObj[i]),
          diseaseType: ($scope.diseaseTypeObj[i]),
          preMedicine: ($scope.preMedicineObj[i])
        });
      }
      $http({
        method: 'POST',
        url: '/api/mlDiseaseHistory',
        data: diseaseHistory
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    $scope.layout = function() {
      $state.go('mlHome');
    };

    function getMlPatient() {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.patientName = data.name;
        $scope.patientNumber = data.identifier;
      });
    }
  }]);