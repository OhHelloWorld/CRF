import angular from 'angular';

angular.module('drugHistory', [])
  .controller('drugHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {

    getMlPatient();
    var drugHistory = {};

    //西药
    $scope.genericNameObj = {};
    $scope.tradeNameObj = {};
    $scope.drugClassificationObj = {};
    $scope.medicationMethodObj = {};
    $scope.doseObj = {};
    $scope.beginDateObj = {};
    $scope.drugWithdrawalObj = {};
    $scope.drugWithdrawalDateObj = {};
    $scope.decrementObj = {};
    $scope.drugExposureObj = {};
    $scope.exposureLiverDamageObj = {};
    $scope.manufactorObj = {};
    $scope.medicineLiverSuspectedDrugDetailDTOS = [];

    //中成药
    $scope.proNameObj = {};
    $scope.proManufactorObj = {};
    $scope.constituteObj = {};
    $scope.suspendConstituteObj = {};
    $scope.proDoseObj = {};
    $scope.proBeginTimeObj = {};
    $scope.proEndTimeObj = {};
    $scope.proCategoryObj = {};

    //中草药
    $scope.herbalNameObj = {};
    $scope.herbalDoseObj = {};
    $scope.herbalBeginTimeObj = {};
    $scope.herbalEndTimeObj = {};
    $scope.buyFromObj = {};
    $scope.herbalCategoryObj = {};

    //可疑中药
    $scope.susNameObj = {};
    $scope.sampleObj = {};
    $scope.numberObj = {};
    $scope.susCategoryObj = {};

    $('#beginDate').datepicker({
      autoclose: true
    });
    $('#drugWithdrawalDate').datepicker({
      autoclose: true
    });
    $('#proBeginTime').datepicker({
      autoclose: true
    });
    $('#proEndTime').datepicker({
      autoclose: true
    });
    $('#herbalBeginTime').datepicker({
      autoclose: true
    });
    $('#herbalEndTime').datepicker({
      autoclose: true
    });

    var count = 0;
    var proCount = 0;
    var herbalCount = 0;
    var susCount = 0;

    $scope.addDrug = function() {
      count += 1;
      var template = `<div class="col-sm-12">&nbsp</div>
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon">
                        <i style="font-style: inherit;"> &ensp; 通用名</i>
                        </div>
                        <input class="form-control" ng-model="genericNameObj[` + count + `]"></div>
                      </div>
                      
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon">
                        <i style="font-style: inherit;"> &ensp; 商品名</i>
                        </div>
                        <input class="form-control" ng-model="tradeNameObj[` + count + `]"></div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 厂家及批号</i></div>
                        <input class="form-control" ng-model="manufactorObj[` + count + `]"></div>
                      </div>
                      
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 药物分类</i>
                        </div>
                        <select class="form-control" ng-model="drugClassificationObj[` + count + `]">
                          <option value="非甾体类抗炎药">非甾体类抗炎药</option>
                          <option value="抗感染药物（包括抗结核药物）">抗感染药物（包括抗结核药物）</option>
                          <option value="抗肿瘤药物">抗肿瘤药物</option>
                          <option value="中枢神经系统用药">中枢神经系统用药</option>
                          <option value="心血管系统用药">心血管系统用药</option>
                          <option value="代谢性疾病用药">代谢性疾病用药</option>
                          <option value="激素类药物">激素类药物</option>
                          <option value="生物制剂">生物制剂</option>
                          <option value="中药">中药</option>
                          <option value="保健品">保健品</option>
                          <option value="其他">其他</option>
                        </select>
                        </div>
                      </div>

                      <div class="col-sm-3">
                      <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i>
                        </div>
                        <select class="form-control" ng-model="medicationMethodObj[` + count + `]">
                          <option value="口服">口服</option>
                          <option value="皮下注射">皮下注射</option>
                          <option value="直肠给药">直肠给药</option>
                          <option value="滴注">滴注</option>
                          <option value="鼻腔给药">鼻腔给药</option>
                          <option value="吸入给药">吸入给药</option>
                          <option value="静脉注射">静脉注射</option>
                          <option value="局部给药">局部给药</option>
                          <option value="肌肉注射">肌肉注射</option>
                          <option value="静脉滴注">静脉滴注</option>
                          <option value="雾化吸入">雾化吸入</option>
                          <option value="其他">其他</option>
                          <option value="不详">不详</option>
                        </select>
                        </div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i>
                        </div>
                        <input class="form-control" ng-model="doseObj[` + count + `]"></div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group date">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i>
                        </div>
                        <input class="form-control pull-right" id="beginDate` + count + `" ng-model="beginDateObj[` + count + `]">
                        </div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div>
                        <select class="form-control" ng-model="drugWithdrawalObj[` + count + `]">
                          <option value="是">是</option><option value="否">否</option>
                          <option value="不详">不详</option>
                        </select>
                        </div>
                      </div>

                    <div class="col-sm-3">
                      <div class="input-group date">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div>
                      <input class="form-control pull-right" id="drugWithdrawalDate` + count + `" ng-model="drugWithdrawalDateObj[` + count + `]" ></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div>
                      <select class="form-control" ng-model="decrementObj[` + count + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="不详">不详</option>
                      </select></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div>
                      <select class="form-control" ng-model="drugExposureObj[` + count + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="不详">不详</option>
                      </select></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div>
                      <select class="form-control" ng-model="exposureLiverDamageObj[` + count + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="未知">未知</option>
                      </select>
                      </div>
                    </div>
                    `;

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

    $scope.addPro = function() {
      proCount += 1;
      var template = `<div class="col-md-12">&nbsp</div><div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 名称</i>
                    </div>
                    <input class="form-control" ng-model="proNameObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 厂家</i>
                    </div>
                    <input class="form-control" ng-model="proManufactorObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="proCategoryObj[` + proCount + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 成分</i>
                    </div>
                    <input class="form-control" ng-model="constituteObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 可疑成分</i>
                    </div>
                    <input class="form-control" ng-model="suspendConstituteObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 日剂量</i>
                    </div>
                    <input class="form-control" ng-model="proDoseObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 始服时间</i>
                    </div>
                    <input id="proBeginTime` + proCount + `" class="form-control" ng-model="proBeginTimeObj[` + proCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 停服时间</i>
                    </div>
                    <input id="proEndTime` + proCount + `" class="form-control" ng-model="proEndTimeObj[` + proCount + `]">
                  </div>
                </div>`;
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#proprietary');
      $('#proBeginTime' + proCount).datepicker({
        autoclose: true
      });
      $('#proEndTime' + proCount).datepicker({
        autoclose: true
      });
    };

    $scope.addHerbal = function() {
      herbalCount += 1;
      var template = `<div class="col-md-12">&nbsp</div><div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 组方</i>
                    </div>
                    <input class="form-control" ng-model="herbalNameObj[` + herbalCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 用量（g）</i>
                    </div>
                    <input class="form-control" ng-model="herbalDoseObj[` + herbalCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="herbalCategoryObj[` + herbalCount + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 草药购自</i>
                    </div>
                    <input class="form-control" ng-model="buyFromObj[` + herbalCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 始服时间</i>
                    </div>
                    <input id="herbalBeginTime` + herbalCount + `" class="form-control" ng-model="herbalBeginTimeObj[` + herbalCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 停服时间</i>
                    </div>
                    <input id="herbalEndTime` + herbalCount + `" class="form-control" ng-model="herbalEndTimeObj[` + herbalCount + `]">
                  </div>
                </div>`;
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#herbal');
      $('#herbalBeginTime' + herbalCount).datepicker({
        autoclose: true
      });
      $('#herbalEndTime' + herbalCount).datepicker({
        autoclose: true
      });
    };

    $scope.addSus = function() {
      susCount += 1;
      var template = `<div class="col-md-12">&nbsp</div>
                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 可疑药名</i>
                    </div>
                    <input class="form-control" ng-model="susNameObj[` + susCount + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="susCategoryObj[` + susCount + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 样本</i>
                    </div>
                    <select class="form-control" ng-model="sampleObj[` + susCount + `]">
                      <option value="√留样">√留样</option>
                      <option value="×未留样">×未留样</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 编号</i>
                    </div>
                    <input class="form-control" ng-model="numberObj[` + susCount + `]">
                  </div>
                </div>`;
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#suspend');
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlDrug/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.complete = data.complete;

        if (data.medicineLiverSuspectedDrugDetailDTOS.length >= 1) {
          if (data.medicineLiverSuspectedDrugDetailDTOS.length != 1) {
            count = data.medicineLiverSuspectedDrugDetailDTOS.length - 1;
          } else {
            count = 0;
          }
          $scope.genericName = data.medicineLiverSuspectedDrugDetailDTOS[0].genericName;
          $scope.tradeName = data.medicineLiverSuspectedDrugDetailDTOS[0].tradeName;
          $scope.drugClassification = data.medicineLiverSuspectedDrugDetailDTOS[0].drugClassification;
          $scope.dose = data.medicineLiverSuspectedDrugDetailDTOS[0].dose;
          $scope.medicationMethod = data.medicineLiverSuspectedDrugDetailDTOS[0].medicationMethod;
          $scope.drugWithDrawal = data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithDrawal;
          $scope.decrement = data.medicineLiverSuspectedDrugDetailDTOS[0].decrement;
          $scope.drugExposure = data.medicineLiverSuspectedDrugDetailDTOS[0].drugExposure;
          $scope.exposureLiverDamage = data.medicineLiverSuspectedDrugDetailDTOS[0].exposureLiverDamage;
          $scope.manufactor = data.medicineLiverSuspectedDrugDetailDTOS[0].manufactor;
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].beginDate);
            $scope.beginDate = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithDrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[0].drugWithDrawalDate);
            $scope.drugWithDrawalDate = drugWithDrawalDate.getFullYear() + '-' + (drugWithDrawalDate.getMonth() + 1) + '-' + drugWithDrawalDate.getDate();
          })(data);
        } else {
          count = 0;
        }

        if (data.mlProprietaryChineseMedicineDTOS.length >= 1) {
          if (data.mlProprietaryChineseMedicineDTOS.length != 1) {
            proCount = data.mlProprietaryChineseMedicineDTOS.length - 1;
          } else {
            proCount = 0;
          }
          $scope.proName = data.mlProprietaryChineseMedicineDTOS[0].proName;
          $scope.proManufactor = data.mlProprietaryChineseMedicineDTOS[0].proManufactor;
          $scope.constitute = data.mlProprietaryChineseMedicineDTOS[0].constitute;
          $scope.suspendConstitute = data.mlProprietaryChineseMedicineDTOS[0].suspendConstitute;
          $scope.proDose = data.mlProprietaryChineseMedicineDTOS[0].proDose;
          $scope.proCategory = data.mlProprietaryChineseMedicineDTOS[0].proCategory;
          (function(data) {
            var beginTime = new Date(data.mlProprietaryChineseMedicineDTOS[0].proBeginTime);
            var endTime = new Date(data.mlProprietaryChineseMedicineDTOS[0].proEndTime);
            $scope.proBeginTime = beginTime.getFullYear() + '-' + (beginTime.getMonth() + 1) + '-' + beginTime.getDate();
            $scope.proEndTime = endTime.getFullYear() + '-' + (endTime.getMonth() + 1) + '-' + endTime.getDate();
          })(data);
        } else {
          count == 0;
        }

        if (data.mlChineseHerbalMedicineDTOS.length >= 1) {
          if (data.mlChineseHerbalMedicineDTOS.length != 1) {
            herbalCount = data.mlChineseHerbalMedicineDTOS.length - 1;
          } else {
            herbalCount = 0;
          }
          $scope.herbalName = data.mlChineseHerbalMedicineDTOS[0].herbalName;
          $scope.herbalDose = data.mlChineseHerbalMedicineDTOS[0].herbalDose;
          $scope.buyFrom = data.mlChineseHerbalMedicineDTOS[0].buyFrom;
          $scope.herbalCategory = data.mlChineseHerbalMedicineDTOS[0].herbalCategory;
          (function(data) {
            var beginTime = new Date(data.mlChineseHerbalMedicineDTOS[0].herbalBeginTime);
            var endTime = new Date(data.mlChineseHerbalMedicineDTOS[0].herbalEndTime);
            $scope.herbalBeginTime = beginTime.getFullYear() + '-' + (beginTime.getMonth() + 1) + '-' + beginTime.getDate();
            $scope.herbalEndTime = endTime.getFullYear() + '-' + (endTime.getMonth() + 1) + '-' + endTime.getDate();
          })(data);
        } else {
          herbalCount = 0;
        }

        if (data.mlSuspendChineseMedicineDTOS.length >= 1) {
          if (data.mlSuspendChineseMedicineDTOS.length != 1) {
            susCount = data.mlSuspendChineseMedicineDTOS.length - 1;
          } else {
            susCount = 0;
          }
          $scope.susName = data.mlSuspendChineseMedicineDTOS[0].susName;
          $scope.sample = data.mlSuspendChineseMedicineDTOS[0].sample;
          $scope.number = data.mlSuspendChineseMedicineDTOS[0].number;
          $scope.susCategory = data.mlSuspendChineseMedicineDTOS[0].susCategory;
        } else {
          susCount = 0;
        }


        for (var i = 1; i < data.medicineLiverSuspectedDrugDetailDTOS.length; i++) {
          var template = `<div class="col-sm-12">&nbsp</div>
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon">
                        <i style="font-style: inherit;"> &ensp; 通用名</i>
                        </div>
                        <input class="form-control" ng-model="genericNameObj[` + i + `]"></div>
                      </div>
                      
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon">
                        <i style="font-style: inherit;"> &ensp; 商品名</i>
                        </div>
                        <input class="form-control" ng-model="tradeNameObj[` + i + `]"></div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 厂家及批号</i></div>
                        <input class="form-control" ng-model="manufactorObj[` + i + `]"></div>
                      </div>
                      
                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 药物分类</i>
                        </div>
                        <select class="form-control" ng-model="drugClassificationObj[` + i + `]">
                          <option value="非甾体类抗炎药">非甾体类抗炎药</option>
                          <option value="抗感染药物（包括抗结核药物）">抗感染药物（包括抗结核药物）</option>
                          <option value="抗肿瘤药物">抗肿瘤药物</option>
                          <option value="中枢神经系统用药">中枢神经系统用药</option>
                          <option value="心血管系统用药">心血管系统用药</option>
                          <option value="代谢性疾病用药">代谢性疾病用药</option>
                          <option value="激素类药物">激素类药物</option>
                          <option value="生物制剂">生物制剂</option>
                          <option value="中药">中药</option>
                          <option value="保健品">保健品</option>
                          <option value="其他">其他</option>
                        </select>
                        </div>
                      </div>

                      <div class="col-sm-3">
                      <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i>
                        </div>
                        <select class="form-control" ng-model="medicationMethodObj[` + i + `]">
                          <option value="口服">口服</option>
                          <option value="皮下注射">皮下注射</option>
                          <option value="直肠给药">直肠给药</option>
                          <option value="滴注">滴注</option>
                          <option value="鼻腔给药">鼻腔给药</option>
                          <option value="吸入给药">吸入给药</option>
                          <option value="静脉注射">静脉注射</option>
                          <option value="局部给药">局部给药</option>
                          <option value="肌肉注射">肌肉注射</option>
                          <option value="静脉滴注">静脉滴注</option>
                          <option value="雾化吸入">雾化吸入</option>
                          <option value="其他">其他</option>
                          <option value="不详">不详</option>
                        </select>
                        </div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i>
                        </div>
                        <input class="form-control" ng-model="doseObj[` + i + `]"></div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group date">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i>
                        </div>
                        <input class="form-control pull-right" id="beginDate` + i + `" ng-model="beginDateObj[` + i + `]">
                        </div>
                      </div>

                      <div class="col-sm-3">
                        <div class="input-group">
                        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否停药</i></div>
                        <select class="form-control" ng-model="drugWithdrawalObj[` + i + `]">
                          <option value="是">是</option><option value="否">否</option>
                          <option value="不详">不详</option>
                        </select>
                        </div>
                      </div>

                    <div class="col-sm-3">
                      <div class="input-group date">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 停药日期</i></div>
                      <input class="form-control pull-right" id="drugWithdrawalDate` + i + `" ng-model="drugWithdrawalDateObj[` + i + `]" ></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否减量</i></div>
                      <select class="form-control" ng-model="decrementObj[` + i + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="不详">不详</option>
                      </select></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往该药暴露史</i></div>
                      <select class="form-control" ng-model="drugExposureObj[` + i + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="不详">不详</option>
                      </select></div>
                    </div>

                    <div class="col-sm-3">
                      <div class="input-group">
                      <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 既往暴露引起肝损</i></div>
                      <select class="form-control" ng-model="exposureLiverDamageObj[` + i + `]">
                        <option value="是">是</option><option value="否">否</option>
                        <option value="未知">未知</option>
                      </select>
                      </div>
                    </div>
                    `;
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('#drug');
          $('#beginDate' + i).datepicker({
            autoclose: true
          });
          $('#drugWithdrawalDate' + i).datepicker({
            autoclose: true
          });
          $scope.genericNameObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].genericName;
          $scope.tradeNameObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].tradeName;
          $scope.drugClassificationObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugClassification;
          $scope.doseObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].dose;
          $scope.medicationMethodObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].medicationMethod;
          $scope.drugWithdrawalObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithDrawal;
          $scope.decrementObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].decrement;
          $scope.drugExposureObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].drugExposure;
          $scope.exposureLiverDamageObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].exposureLiverDamage;
          $scope.manufactorObj[i] = data.medicineLiverSuspectedDrugDetailDTOS[i].manufactor;
          (function(data) {
            var beginDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].beginDate);
            $scope.beginDateObj[i] = beginDate.getFullYear() + '-' + (beginDate.getMonth() + 1) + '-' + beginDate.getDate();
            var drugWithDrawalDate = new Date(data.medicineLiverSuspectedDrugDetailDTOS[i].drugWithDrawalDate);
            $scope.drugWithdrawalDateObj[i] = drugWithDrawalDate.getFullYear() + '-' + (drugWithDrawalDate.getMonth() + 1) + '-' + drugWithDrawalDate.getDate();
          })(data);
        }

        for (var j = 1; j < data.mlProprietaryChineseMedicineDTOS.length; j++) {
          var proTemplate = `<div class="col-md-12">&nbsp</div><div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 名称</i>
                    </div>
                    <input class="form-control" ng-model="proNameObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 厂家</i>
                    </div>
                    <input class="form-control" ng-model="proManufactorObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="proCategoryObj[` + j + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 成分</i>
                    </div>
                    <input class="form-control" ng-model="constituteObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 可疑成分</i>
                    </div>
                    <input class="form-control" ng-model="suspendConstituteObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 日剂量</i>
                    </div>
                    <input class="form-control" ng-model="proDoseObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 始服时间</i>
                    </div>
                    <input id="proBeginTime` + j + `" class="form-control" ng-model="proBeginTimeObj[` + j + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 停服时间</i>
                    </div>
                    <input id="proEndTime` + j + `" class="form-control" ng-model="proEndTimeObj[` + j + `]">
                  </div>
                </div>`;
          var proCompileFn = $compile(proTemplate);
          var proDom = proCompileFn($scope);
          proDom.appendTo('#proprietary');
          $('#proBeginTime' + j).datepicker({
            autoclose: true
          });
          $('#proEndTime' + j).datepicker({
            autoclose: true
          });
          $scope.proNameObj[j] = data.mlProprietaryChineseMedicineDTOS[j].proName;
          $scope.proManufactorObj[j] = data.mlProprietaryChineseMedicineDTOS[j].proManufactor;
          $scope.constituteObj[j] = data.mlProprietaryChineseMedicineDTOS[j].constitute;
          $scope.suspendConstituteObj[j] = data.mlProprietaryChineseMedicineDTOS[j].constitute;
          $scope.proDoseObj[j] = data.mlProprietaryChineseMedicineDTOS[j].proDose;
          $scope.proCategoryObj[j] = data.mlProprietaryChineseMedicineDTOS[j].proCategory;
          (function(data) {
            var beginTime = new Date(data.mlProprietaryChineseMedicineDTOS[j].proBeginTime);
            var endTime = new Date(data.mlProprietaryChineseMedicineDTOS[j].proEndTime);
            $scope.proBeginTimeObj[j] = beginTime.getFullYear() + '-' + (beginTime.getMonth() + 1) + '-' + beginTime.getDate();
            $scope.proEndTimeObj[j] = endTime.getFullYear() + '-' + (endTime.getMonth() + 1) + '-' + endTime.getDate();
          })(data);
        }

        for (var k = 1; k < data.mlChineseHerbalMedicineDTOS.length; k++) {
          var herbalTemplate = `<div class="col-sm-12">&nbsp</div><div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 组方</i>
                    </div>
                    <input class="form-control" ng-model="herbalNameObj[` + k + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 用量（g）</i>
                    </div>
                    <input class="form-control" ng-model="herbalDoseObj[` + k + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="herbalCategoryObj[` + k + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 草药购自</i>
                    </div>
                    <input class="form-control" ng-model="buyFromObj[` + k + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 始服时间</i>
                    </div>
                    <input id="herbalBeginTime` + k + `" class="form-control" ng-model="herbalBeginTimeObj[` + k + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 停服时间</i>
                    </div>
                    <input id="herbalEndTime` + k + `" class="form-control" ng-model="herbalEndTimeObj[` + k + `]">
                  </div>
                </div>`;
          var herbalCompileFn = $compile(herbalTemplate);
          var herbalDom = herbalCompileFn($scope);
          herbalDom.appendTo('#herbal');
          $('#herbalBeginTime' + k).datepicker({
            autoclose: true
          });
          $('#herbalEndTime' + k).datepicker({
            autoclose: true
          });
          $scope.herbalNameObj[k] = data.mlChineseHerbalMedicineDTOS[k].herbalName;
          $scope.herbalDoseObj[k] = data.mlChineseHerbalMedicineDTOS[k].herbalDose;
          $scope.buyFromObj[k] = data.mlChineseHerbalMedicineDTOS[k].buyFrom;
          $scope.herbalCategoryObj[k] = data.mlChineseHerbalMedicineDTOS[k].herbalCategory;
          (function(data) {
            var beginTime = new Date(data.mlChineseHerbalMedicineDTOS[k].herbalBeginTime);
            var endTime = new Date(data.mlChineseHerbalMedicineDTOS[k].herbalEndTime);
            $scope.herbalBeginTimeObj[k] = beginTime.getFullYear() + '-' + (beginTime.getMonth() + 1) + '-' + beginTime.getDate();
            $scope.herbalEndTimeObj[k] = endTime.getFullYear() + '-' + (endTime.getMonth() + 1) + '-' + endTime.getDate();
          })(data);
        }

        for (var m = 1; m < data.mlSuspendChineseMedicineDTOS.length; m++) {
          var susTemplate = `<div class="col-sm-12">&nbsp</div>
                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 可疑药名</i>
                    </div>
                    <input class="form-control" ng-model="susNameObj[` + m + `]">
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 中药类别</i>
                    </div>
                    <select class="form-control" ng-model="susCategoryObj[` + m + `]">
                      <option value="解表药">解表药</option>
                      <option value="清热药">清热药</option>
                      <option value="泻下药">泻下药</option>
                      <option value="祛风湿药">祛风湿药</option>
                      <option value="化湿药">化湿药</option>
                      <option value="利湿药">利湿药</option>
                      <option value="温里药">温里药</option>
                      <option value="行气药">行气药</option>
                      <option value="消食药">消食药</option>
                      <option value="驱虫药">驱虫药</option>
                      <option value="止血药">止血药</option>
                      <option value="活血药">活血药</option>
                      <option value="化痰药">化痰药</option>
                      <option value="止咳平喘药">止咳平喘药</option>
                      <option value="安神药">安神药</option>
                      <option value="平肝熄风药">平肝熄风药</option>
                      <option value="开窍药">开窍药</option>
                      <option value="补虚药">补虚药</option>
                      <option value="收涩药">收涩药</option>
                      <option value="外用药">外用药</option>
                      <option value="其他">其他</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 样本</i>
                    </div>
                    <select class="form-control" ng-model="sampleObj[` + m + `]">
                      <option value="√留样">√留样</option>
                      <option value="×未留样">×未留样</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 编号</i>
                    </div>
                    <input class="form-control" ng-model="numberObj[` + m + `]">
                  </div>
                </div>`;
          var susCompileFn = $compile(susTemplate);
          var susDom = susCompileFn($scope);
          susDom.appendTo('#suspend');
          $scope.susNameObj[m] = data.mlSuspendChineseMedicineDTOS[m].susName;
          $scope.sampleObj[m] = data.mlSuspendChineseMedicineDTOS[m].sample;
          $scope.numberObj[m] = data.mlSuspendChineseMedicineDTOS[m].number;
          $scope.susCategoryObj[m] = data.mlSuspendChineseMedicineDTOS[m].susCategory;
        }

      });
    }

    $scope.save = function() {
      drugHistory.medicineLiverSuspectedDrugDetailDTOS = [];
      drugHistory.mlProprietaryChineseMedicineDTOS = [];
      drugHistory.mlChineseHerbalMedicineDTOS = [];
      drugHistory.mlSuspendChineseMedicineDTOS = [];
      drugHistory.patientId = sessionStorage.getItem('mlPatientId');
      drugHistory.complete = true;

      if ($scope.genericName) {
        drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
          genericName: $scope.genericName,
          tradeName: $scope.tradeName,
          drugClassification: $scope.drugClassification,
          medicationMethod: $scope.medicationMethod,
          dose: $scope.dose,
          beginDate: new Date($scope.beginDate),
          drugWithDrawal: $scope.drugWithDrawal,
          drugWithDrawalDate: new Date($scope.drugWithDrawalDate),
          decrement: $scope.decrement,
          drugExposure: $scope.drugExposure,
          exposureLiverDamage: $scope.exposureLiverDamage,
          manufactor: $scope.manufactor
        });
      }

      if ($scope.proName) {
        drugHistory.mlProprietaryChineseMedicineDTOS.push({
          proName: $scope.proName,
          proManufactor: $scope.proManufactor,
          constitute: $scope.constitute,
          suspendConstitute: $scope.suspendConstitute,
          proDose: $scope.proDose,
          proBeginTime: new Date($scope.proBeginTime),
          proEndTime: new Date($scope.proEndTime),
          proCategory: $scope.proCategory
        });
      }

      if ($scope.herbalName) {
        drugHistory.mlChineseHerbalMedicineDTOS.push({
          herbalName: $scope.herbalName,
          herbalDose: $scope.herbalDose,
          buyFrom: $scope.buyFrom,
          herbalBeginTime: new Date($scope.herbalBeginTime),
          herbalEndTime: new Date($scope.herbalEndTime),
          herbalCategory: $scope.herbalCategory
        });
      }

      if ($scope.susName) {
        drugHistory.mlSuspendChineseMedicineDTOS.push({
          susName: $scope.susName,
          sample: $scope.sample,
          number: $scope.number,
          susCategory: $scope.susCategory
        });
      }

      for (var i = 1; i <= count; i++) {
        drugHistory.medicineLiverSuspectedDrugDetailDTOS.push({
          // id: ($scope.detailIdObj[i + 1]),
          genericName: $scope.genericNameObj[i],
          tradeName: $scope.tradeNameObj[i],
          drugClassification: $scope.drugClassificationObj[i],
          medicationMethod: $scope.medicationMethodObj[i],
          dose: $scope.doseObj[i],
          beginDate: new Date($scope.beginDateObj[i]),
          drugWithDrawal: $scope.drugWithdrawalObj[i],
          drugWithDrawalDate: new Date($scope.drugWithdrawalDateObj[i]),
          decrement: $scope.decrementObj[i],
          drugExposure: $scope.drugExposureObj[i],
          exposureLiverDamage: $scope.exposureLiverDamageObj[i],
          manufactor: $scope.manufactorObj[i]
        });
      }

      for (var j = 1; j <= proCount; j++) {
        drugHistory.mlProprietaryChineseMedicineDTOS.push({
          proName: $scope.proNameObj[j],
          proManufactor: $scope.proManufactorObj[j],
          constitute: $scope.constituteObj[j],
          suspendConstitute: $scope.suspendConstituteObj[j],
          proDose: $scope.proDoseObj[j],
          proCategory: $scope.proCategoryObj[j],
          proBeginTime: new Date($scope.proBeginTimeObj[j]),
          proEndTime: new Date($scope.proEndTimeObj[j])
        });
      }

      for (var k = 1; k <= herbalCount; k++) {
        drugHistory.mlChineseHerbalMedicineDTOS.push({
          herbalName: $scope.herbalNameObj[k],
          herbalDose: $scope.herbalDoseObj[k],
          buyFrom: $scope.buyFromObj[k],
          herbalCategory: $scope.herbalCategoryObj[k],
          herbalBeginTime: new Date($scope.herbalBeginTimeObj[k]),
          herbalEndTime: new Date($scope.herbalEndTimeObj[k])
        });
      }

      for (var m = 1; m <= susCount; m++) {
        drugHistory.mlSuspendChineseMedicineDTOS.push({
          susName: $scope.susNameObj[m],
          sample: $scope.sampleObj[m],
          number: $scope.numberObj[m],
          susCategory: $scope.susCategoryObj[m]
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