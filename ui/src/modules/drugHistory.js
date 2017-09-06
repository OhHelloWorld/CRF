import angular from 'angular';

angular.module('drugHistory', [])
  .controller('drugHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {
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
      var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div><input class="form-control" ng-model="genericNameObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div><input class="form-control" ng-model="tradeNameObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗疾病</i></div><input class="form-control" ng-model="treatComplaintObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div><input class="form-control" ng-model="medicationMethodObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div><input class="form-control" ng-model="doseObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div><input class="form-control pull-right" id="beginDate' + count + '" ng-model="beginDateObj[' + count + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div><input class="form-control" ng-model="drugWithdrawalObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div><input class="form-control pull-right" id="drugWithdrawalDate' + count + '" ng-model="drugWithdrawalDateObj[' + count + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div><input class="form-control" ng-model="decrementObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div><input class="form-control" ng-model="drugExposureObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div><input class="form-control" ng-model="exposureLiverDamageObj[' + count + ']"></div></div>';
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
        count = data.medicineLiverSuspectedDrugDetailDTOS.length - 1;
        $scope.complete = data.complete;

        if (data.medicineLiverSuspectedDrugDetailDTOS.length != 0) {
          $scope.genericName = data.medicineLiverSuspectedDrugDetailDTOS[0].genericName;
          $scope.tradeName = data.medicineLiverSuspectedDrugDetailDTOS[0].tradeName;
          $scope.treatComplaint = data.medicineLiverSuspectedDrugDetailDTOS[0].treatComplaint;
          $scope.dose = data.medicineLiverSuspectedDrugDetailDTOS[0].dose;
          $scope.medicationMethod = data.medicineLiverSuspectedDrugDetailDTOS[0].medicationMethod;
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].beginDate);
            $scope.beginDate = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithdrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithdrawalDate);
            $scope.drugWithdrawalDate = drugWithdrawalDate.getFullYear() + '-' + (drugWithdrawalDate.getMonth + 1) + '-' + drugWithdrawalDate.getDate();
          })(data);
          $scope.drugWithdrawal = data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithdrawal;
          $scope.decrement = data.medicineLiverSuspectedDrugDetailDTOS[0].decrement;
          $scope.drugExposure = data.medicineLiverSuspectedDrugDetailDTOS[0].drugExposure;
          $scope.exposureLiverDamage = data.medicineLiverSuspectedDrugDetailDTOS[0].exposureLiverDamage;
        }

        for (var i = 1; i < data.medicineLiverSuspectedDrugDetailDTOS.length; i++) {
          var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div><input class="form-control" ng-model="genericNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div><input class="form-control" ng-model="tradeNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗疾病</i></div><input class="form-control" ng-model="treatComplaintObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div><input class="form-control" ng-model="medicationMethodObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div><input class="form-control" ng-model="doseObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div><input class="form-control pull-right" id="beginDate' + i + '" ng-model="beginDateObj[' + i + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div><input class="form-control" ng-model="drugWithdrawalObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div><input class="form-control pull-right" id="drugWithdrawalDate' + i + '" ng-model="drugWithdrawalDateObj[' + i + ']" ></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div><input class="form-control" ng-model="decrementObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div><input class="form-control" ng-model="drugExposureObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div><input class="form-control" ng-model="exposureLiverDamageObj[' + i + ']"></div></div>';
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
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].beginDate);
            $scope.beginDateObj[i] = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithdrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithdrawalDate);
            $scope.drugWithdrawalDateObj[i] = drugWithdrawalDate.getFullYear() + '-' + (drugWithdrawalDate.getMonth + 1) + '-' + drugWithdrawalDate.getDate();
          })(data);
          $scope.drugWithdrawalObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithdrawal;
          $scope.decrementObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].decrement;
          $scope.drugExposureObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugExposure;
          $scope.exposureLiverDamageObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].exposureLiverDamage;
        }
      });
    }

    $scope.save = function() {
      drugHistory.medicineLiverSuspectedDrugDetailDTOS = [];
      drugHistory.patientId = sessionStorage.getItem('mlPatientId');
      drugHistory.complete = true;

      drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
        genericName: $scope.genericName,
        tradeName: $scope.tradeName,
        treatComplaint: $scope.treatComplaint,
        medicationMethod: $scope.medicationMethod,
        dose: $scope.dose,
        beginDate: new Date($scope.beginDate),
        drugWithdrawal: $scope.drugWithdrawal,
        drugWithdrawalDate: new Date($scope.drugWithdrawalDate),
        decrement: $scope.decrement,
        drugExposure: $scope.drugExposure,
        exposureLiverDamage: $scope.exposureLiverDamage
      });
      drugHistory.projectId = 2;
      for (var i = 0; i < count; i++) {
        drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
          // id: ($scope.detailIdObj[i + 1]),
          genericName: $scope.genericNameObj[i + 1],
          tradeName: $scope.tradeNameObj[i + 1],
          treatComplaint: $scope.treatComplaintObj[i + 1],
          medicationMethod: $scope.medicationMethodObj[i + 1],
          dose: $scope.doseObj[i + 1],
          beginDate: new Date($scope.beginDateObj[i + 1]),
          drugWithdrawal: $scope.drugWithdrawalObj[i + 1],
          drugWithdrawalDate: new Date($scope.drugWithdrawalDateObj[i + 1]),
          decrement: $scope.decrementObj[i + 1],
          drugExposure: $scope.drugExposureObj[i + 1],
          exposureLiverDamage: $scope.exposureLiverDamageObj[i + 1]
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
  }]);