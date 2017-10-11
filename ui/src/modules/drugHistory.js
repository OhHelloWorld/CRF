import angular from 'angular';

angular.module('drugHistory', [])
  .controller('drugHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {

    getMlPatient();
    var drugHistory = {};
    $scope.genericNameObj = {};
    $scope.tradeNameObj = {};
    $scope.treatComplaintObj = {};
    $scope.medicationMethodObj = {};
    $scope.doseObj = {};
    $scope.beginDateObj = {};
    $scope.drugWithdrawalObj = {};
    $scope.drugWithdrawalDateObj = {};
    $scope.decrementObj = {};
    $scope.drugExposureObj = {};
    $scope.exposureLiverDamageObj = {};
    $scope.medicineLiverSuspectedDrugDetailDTOS = [];
    $('#beginDate').datepicker({
      autoclose: true
    });
    $('#drugWithdrawalDate').datepicker({
      autoclose: true
    });
    var count = 0;

    $scope.addDrug = function() {
      count += 1;
      var template = '<div class="col-sm-12">&nbsp</div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div><input class="form-control" ng-model="genericNameObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div><input class="form-control" ng-model="tradeNameObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗疾病</i></div><input class="form-control" ng-model="treatComplaintObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div><select class="form-control" ng-model="medicationMethodObj[' + count + ']"><option value="1">口服</option><option value="2">皮下注射</option><option value="3">直肠给药</option><option value="4">滴注</option><option value="5">鼻腔给药</option><option value="6">吸入给药</option><option value="7">静脉注射</option><option value="8">局部给药</option><option value="9">肌肉注射</option><option value="10">静脉滴注</option><option value="11">雾化吸入</option><option value="12">其他</option><option value="13">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div><input class="form-control" ng-model="doseObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div><input class="form-control pull-right" id="beginDate' + count + '" ng-model="beginDateObj[' + count + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div><select class="form-control" ng-model="drugWithDrawalObj[' + count + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div><input class="form-control pull-right" id="drugWithdrawalDate' + count + '" ng-model="drugWithdrawalDateObj[' + count + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div><select class="form-control" ng-model="decrementObj[' + count + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div><select class="form-control" ng-model="drugExposureObj[' + count + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div><select class="form-control" ng-model="exposureLiverDamageObj[' + count + ']"><option value="1">是</option><option value="2">否</option><option value="3">未知</option></select></div></div>';
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#drug');
      $('#beginDate' + count).datepicker({
        autoclose: true
      });
      $('#drugWithdrawalDate' + count).datepicker({
        autoclose: true
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlDrug/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.complete = data.complete;

        if (data.medicineLiverSuspectedDrugDetailDTOS.length != 0) {
          if (data.medicineLiverSuspectedDrugDetailDTOS.length == 1) {
            count = 0;
          } else {
            count = data.medicineLiverSuspectedDrugDetailDTOS.length - 1;
          }
          $scope.genericName = data.medicineLiverSuspectedDrugDetailDTOS[0].genericName;
          $scope.tradeName = data.medicineLiverSuspectedDrugDetailDTOS[0].tradeName;
          $scope.treatComplaint = data.medicineLiverSuspectedDrugDetailDTOS[0].treatComplaint;
          $scope.dose = data.medicineLiverSuspectedDrugDetailDTOS[0].dose;
          $scope.medicationMethod = data.medicineLiverSuspectedDrugDetailDTOS[0].medicationMethod;
          $scope.drugWithDrawal = data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithDrawal;
          $scope.decrement = data.medicineLiverSuspectedDrugDetailDTOS[0].decrement;
          $scope.drugExposure = data.medicineLiverSuspectedDrugDetailDTOS[0].drugExposure;
          $scope.exposureLiverDamage = data.medicineLiverSuspectedDrugDetailDTOS[0].exposureLiverDamage;
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].beginDate);
            $scope.beginDate = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithDrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithDrawalDate);
            $scope.drugWithDrawalDate = drugWithDrawalDate.getFullYear() + '-' + (drugWithDrawalDate.getMonth() + 1) + '-' + drugWithDrawalDate.getDate();
          })(data);
        } else {
          count = 0;
        }

        for (var i = 1; i < data.medicineLiverSuspectedDrugDetailDTOS.length; i++) {
          var template = '<div class="col-sm-12">&nbsp</div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div><input class="form-control" ng-model="genericNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div><input class="form-control" ng-model="tradeNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗疾病</i></div><input class="form-control" ng-model="treatComplaintObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div><select class="form-control" ng-model="medicationMethodObj[' + i + ']"><option value="1">口服</option><option value="2">皮下注射</option><option value="3">直肠给药</option><option value="4">滴注</option><option value="5">鼻腔给药</option><option value="6">吸入给药</option><option value="7">静脉注射</option><option value="8">局部给药</option><option value="9">肌肉注射</option><option value="10">静脉滴注</option><option value="11">雾化吸入</option><option value="12">其他</option><option value="13">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div><input class="form-control" ng-model="doseObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div><input class="form-control pull-right" id="beginDate' + i + '" ng-model="beginDateObj[' + i + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div><select class="form-control" ng-model="drugWithdrawalObj[' + i + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div><input class="form-control pull-right" id="drugWithdrawalDate' + i + '" ng-model="drugWithdrawalDateObj[' + i + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div><select class="form-control" ng-model="decrementObj[' + i + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div><select class="form-control" ng-model="drugExposureObj[' + i + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div><select class="form-control" ng-model="exposureLiverDamageObj[' + i + ']"><option value="1">是</option><option value="2">否</option><option value="3">不详</option></select></div></div>';
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('#drug');
          $('#beginDate' + count).datepicker({
            autoclose: true
          });
          $('#drugWithdrawalDate' + count).datepicker({
            autoclose: true
          });
          $scope.genericNameObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].genericName;
          $scope.tradeNameObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].tradeName;
          $scope.treatComplaintObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].treatComplaint;
          $scope.doseObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].dose;
          $scope.medicationMethodObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].medicationMethod;
          $scope.drugWithdrawalObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithDrawal;
          $scope.decrementObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].decrement;
          $scope.drugExposureObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugExposure;
          $scope.exposureLiverDamageObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].exposureLiverDamage;
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].beginDate);
            $scope.beginDateObj[i] = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithDrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithDrawalDate);
            $scope.drugWithdrawalDateObj[i] = drugWithDrawalDate.getFullYear() + '-' + (drugWithDrawalDate.getMonth() + 1) + '-' + drugWithDrawalDate.getDate();
          })(data);
        }
      });
    }

    $scope.save = function() {
      drugHistory.medicineLiverSuspectedDrugDetailDTOS = [];
      drugHistory.patientId = sessionStorage.getItem('mlPatientId');
      drugHistory.complete = true;

      if ($scope.genericName != undefined) {
        drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
          genericName: $scope.genericName,
          tradeName: $scope.tradeName,
          treatComplaint: $scope.treatComplaint,
          medicationMethod: $scope.medicationMethod,
          dose: $scope.dose,
          beginDate: new Date($scope.beginDate),
          drugWithDrawal: $scope.drugWithDrawal,
          drugWithDrawalDate: new Date($scope.drugWithDrawalDate),
          decrement: $scope.decrement,
          drugExposure: $scope.drugExposure,
          exposureLiverDamage: $scope.exposureLiverDamage
        });
      }
      for (var i = 1; i <= count; i++) {
        drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
          // id: ($scope.detailIdObj[i + 1]),
          genericName: $scope.genericNameObj[i],
          tradeName: $scope.tradeNameObj[i],
          treatComplaint: $scope.treatComplaintObj[i],
          medicationMethod: $scope.medicationMethodObj[i],
          dose: $scope.doseObj[i],
          beginDate: new Date($scope.beginDateObj[i]),
          drugWithDrawal: $scope.drugWithdrawalObj[i],
          drugWithDrawalDate: new Date($scope.drugWithdrawalDateObj[i]),
          decrement: $scope.decrementObj[i],
          drugExposure: $scope.drugExposureObj[i],
          exposureLiverDamage: $scope.exposureLiverDamageObj[i]
        });
      }
      $http({
        method: 'POST',
        url: '/api/mlDrug',
        data: drugHistory
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    function getMlPatient() {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data2 = response.data;
        $scope.patientName = data2.name;
        $scope.patientNumber = data2.identifier;
      });
    }
  }]);