import angular from 'angular';

angular.module('mlTreatment', [])
  .controller('mlTreatmentController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {
    getMlPatient();
    var mlTreatment = {};

    $scope.genericNameObj = {};
    $scope.tradeNameObj = {};
    $scope.detailMethodObj = {};
    $scope.doseObj = {};
    $scope.detailStartDateObj = {};
    $scope.detailEndDateObj = {};
    $scope.categoryObj = {};

    $scope.cnTradeNameObj = {};
    $scope.cnMethodObj = {};
    $scope.cnDoseObj = {};
    $scope.cnStartDateObj = {};
    $scope.cnEndDateObj = {};

    $scope.methodObj = {};
    $scope.methodDetailObj = {};
    $scope.otherStartDateObj = {};
    $scope.otherEndDateObj = {};

    $scope.medicineLiverTreatmentDetailDTOS = [];
    $scope.medicineLiverTreatmentCnDTOS = [];
    $scope.medicineLiverTreatmentOtherDTOS = [];

    $('#detailStartDate').datepicker({
      autoclose: true
    });
    $('#detailEndDate').datepicker({
      autoclose: true
    });
    $('#cnStartDate').datepicker({
      autoclose: true
    });
    $('#cnEndDate').datepicker({
      autoclose: true
    });
    $('#otherStartDate').datepicker({
      autoclose: true
    });
    $('#otherEndDate').datepicker({
      autoclose: true
    });

    var detailCount = 0;
    var cnCount = 0;
    var otherCount = 0;

    $scope.addDetail = function() {
      detailCount += 1;
      var template = `<div class="col-md-12">&nbsp</div>
      <div class="col-sm-3">
        <div class="input-group">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div>
        <input class="form-control" ng-model="genericNameObj[` + detailCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div>
        <input class="form-control" ng-model="tradeNameObj[` + detailCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div>
        <select ng-model="detailMethodObj[` + detailCount + `]" class="form-control">
          <option value="1">口服</option>
          <option value="2">皮下注射</option>
          <option value="3">直肠给药</option>
          <option value="4">滴注</option>
          <option value="5">鼻腔给药</option>
          <option value="6">吸入给药</option>
          <option value="7">静脉注射</option>
          <option value="8">局部给药</option>
          <option value="9">肌肉注射</option>
          <option value="10">静脉滴注</option>
          <option value="11">雾化吸入</option>
          <option value="12">其他</option>
          <option value="13">不详</option>
        </select></div>
      </div>
      
      <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 用药种类</i>
                    </div>
                    <select class="form-control" ng-model="categoryObj[` + detailCount + `]">
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
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div>
        <input class="form-control" ng-model="doseObj[` + detailCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group date">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div>
        <input class="form-control" id="detailStartDate` + detailCount + `" ng-model="detailStartDateObj[` + detailCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 结束日期</i></div>
        <input class="form-control" id="detailEndDate` + detailCount + `" ng-model="detailEndDateObj[` + detailCount + `]"></div>
      </div>`;
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#treatmentDetail');
      $('#detailStartDate' + detailCount).datepicker({
        autoclose: true
      });
      $('#detailEndDate' + detailCount).datepicker({
        autoclose: true
      });
    };

    $scope.addCn = function() {
      cnCount += 1;
      var template = `<div class="col-md-12">&nbsp</div>
                <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 组成成分（g）商品名</i>
                    </div>
                    <input class="form-control" ng-model="cnTradeNameObj[` + cnCount + `]">
                  </div>
                </div>
                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 给药途径</i>
                    </div>
                    <select ng-model="cnMethodObj[` + cnCount + `]" class="form-control">
                      <option value="1">口服</option>
                      <option value="2">皮下注射</option>
                      <option value="9">肌肉注射</option>
                      <option value="10">静脉滴注</option>
                      <option value="12">其他</option>
                      <option value="13">不详</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 日剂量</i>
                    </div>
                    <input class="form-control" ng-model="cnDoseObj[` + cnCount + `]">
                  </div>
                </div>

                <div class="col-sm-3 col-md-offset-6">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 开始日期</i>
                    </div>
                    <input class="form-control" id="cnStartDate` + cnCount + `" ng-model="cnStartDateObj[` + cnCount + `]">
                  </div>
                </div>
                
                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 结束日期</i>
                    </div>
                    <input class="form-control" id="cnEndDate` + cnCount + `" ng-model="cnEndDateObj[` + cnCount + `]">
                  </div>
                </div>`;

      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#cnMedicine');
      $('#cnStartDate' + cnCount).datepicker({
        autoclose: true
      });
      $('#cnEndDate' + cnCount).datepicker({
        autoclose: true
      });
    };

    $scope.addOther = function() {
      otherCount += 1;
      var template = `<div class="col-md-12">&nbsp</div>
      <div class="col-sm-3">
        <div class="input-group">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗措施</i></div>
        <input class="form-control" ng-model="methodObj[` + otherCount + `]"></div>
      </div>
      
      <div class="col-sm-3">
        <div class="input-group">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗措施详述</i></div>
        <input type="text" class="form-control" ng-model="methodDetailObj[` + otherCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group date">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div>
        <input class="form-control" id="otherStartDate` + otherCount + `" ng-model="otherStartDateObj[` + otherCount + `]"></div>
      </div>

      <div class="col-sm-3">
        <div class="input-group date">
        <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 结束日期</i></div>
        <input class="form-control" id="otherEndDate` + otherCount + `" ng-model="otherEndDateObj[` + otherCount + `]"></div>
      </div>`;

      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#treatmentOther');
      $('#otherStartDate' + otherCount).datepicker({
        autoclose: true
      });
      $('#otherEndDate' + otherCount).datepicker({
        autoclose: true
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlTreatment/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;

        $scope.treatment = data.treatment;
        $scope.complete = data.complete;

        if (data.medicineLiverTreatmentDetailDTOS.length != 0) {
          if (data.medicineLiverTreatmentDetailDTOS.length == 1) {
            detailCount = 0;
          } else {
            detailCount = data.medicineLiverTreatmentDetailDTOS.length - 1;
          }
          $scope.genericName = data.medicineLiverTreatmentDetailDTOS[0].genericName;
          $scope.tradeName = data.medicineLiverTreatmentDetailDTOS[0].tradeName;
          $scope.detailMethod = data.medicineLiverTreatmentDetailDTOS[0].detailMethod;
          $scope.dose = data.medicineLiverTreatmentDetailDTOS[0].dose;
          $scope.category = data.medicineLiverTreatmentDetailDTOS[0].category;
          (function(data) {
            var detailStartDate = new Date(data.medicineLiverTreatmentDetailDTOS[0].detailStartDate);
            var detailEndDate = new Date(data.medicineLiverTreatmentDetailDTOS[0].detailEndDate);
            $scope.detailStartDate = detailStartDate.getFullYear() + '-' + (detailStartDate.getMonth() + 1) + '-' + detailStartDate.getDate();
            $scope.detailEndDate = detailEndDate.getFullYear() + '-' + (detailEndDate.getMonth() + 1) + '-' + detailEndDate.getDate();
          })(data);
        } else {
          detailCount = 0;
        }

        if (data.medicineLiverTreatmentCnDTOS.length != 0) {
          if (data.medicineLiverTreatmentCnDTOS == 1) {
            cnCount = 0;
          } else {
            cnCount = data.medicineLiverTreatmentCnDTOS.length - 1;
          }
          $scope.cnTradeName = data.medicineLiverTreatmentCnDTOS[0].cnTradeName;
          $scope.cnMethod = data.medicineLiverTreatmentCnDTOS[0].cnMethod;
          $scope.cnDose = data.medicineLiverTreatmentCnDTOS[0].cnDose;
          (function(data) {
            var cnStartDate = new Date(data.medicineLiverTreatmentCnDTOS[0].cnStartDate);
            var cnEndDate = new Date(data.medicineLiverTreatmentCnDTOS[0].cnEndDate);
            $scope.cnStartDate = cnStartDate.getFullYear() + '-' + (cnStartDate.getMonth() + 1) + '-' + cnStartDate.getDate();
            $scope.cnEndDate = cnEndDate.getFullYear() + '-' + (cnEndDate.getMonth() + 1) + '-' + cnEndDate.getDate();
          })(data);
        } else {
          cnCount = 0;
        }

        if (data.medicineLiverTreatmentOtherDTOS.length != 0) {
          if (data.medicineLiverTreatmentOtherDTOS == 1) {
            otherCount = 0;
          } else {
            otherCount = data.medicineLiverTreatmentOtherDTOS.length - 1;
          }
          $scope.method = data.medicineLiverTreatmentOtherDTOS[0].method;
          $scope.methodDetail = data.medicineLiverTreatmentOtherDTOS[0].methodDetail;
          (function(data) {
            var otherStartDate = new Date(data.medicineLiverTreatmentOtherDTOS[0].otherStartDate);
            var otherEndDate = new Date(data.medicineLiverTreatmentOtherDTOS[0].otherEndDate);
            $scope.otherStartDate = otherStartDate.getFullYear() + '-' + (otherStartDate.getMonth() + 1) + '-' + otherStartDate.getDate();
            $scope.otherEndDate = otherEndDate.getFullYear() + '-' + (otherEndDate.getMonth() + 1) + '-' + otherEndDate.getDate();
          })(data);
        } else {
          otherCount = 0;
        }

        for (var i = 1; i < data.medicineLiverTreatmentDetailDTOS.length; i++) {
          var template = `<div class="col-md-12">&nbsp</div>
          <div class="col-sm-3">
            <div class="input-group">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 通用名</i></div>
            <input class="form-control" ng-model="genericNameObj[` + i + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 商品名</i></div>
            <input class="form-control" ng-model="tradeNameObj[` + i + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 用药方法</i></div>
            <select ng-model="detailMethodObj[` + i + `]" class="form-control">
              <option value="1">口服</option>
              <option value="2">皮下注射</option>
              <option value="3">直肠给药</option>
              <option value="4">滴注</option>
              <option value="5">鼻腔给药</option>
              <option value="6">吸入给药</option>
              <option value="7">静脉注射</option>
              <option value="8">局部给药</option>
              <option value="9">肌肉注射</option>
              <option value="10">静脉滴注</option>
              <option value="11">雾化吸入</option>
              <option value="12">其他</option>
              <option value="13">不详</option>
            </select></div>
          </div>
          
          <div class="col-sm-3">
                      <div class="input-group">
                        <div class="input-group-addon">
                          <i style="font-style: inherit;"> &ensp; 用药种类</i>
                        </div>
                        <select class="form-control" ng-model="categoryObj[` + i + `]">
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
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 日剂量</i></div>
            <input class="form-control" ng-model="doseObj[` + i + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group date">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div>
            <input class="form-control" id="detailStartDate` + i + `" ng-model="detailStartDateObj[` + i + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 结束日期</i></div>
            <input class="form-control" id="detailEndDate` + i + `" ng-model="detailEndDateObj[` + i + `]"></div>
          </div>`;
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('#treatmentDetail');
          $('#detailStartDate' + i).datepicker({
            autoclose: true
          });
          $('#detailEndDate' + i).datepicker({
            autoclose: true
          });
          $scope.genericNameObj[i] = ((data.medicineLiverTreatmentDetailDTOS)[i]).genericName;
          $scope.tradeNameObj[i] = ((data.medicineLiverTreatmentDetailDTOS)[i]).tradeName;
          $scope.detailMethodObj[i] = ((data.medicineLiverTreatmentDetailDTOS)[i]).detailMethod;
          $scope.doseObj[i] = ((data.medicineLiverTreatmentDetailDTOS)[i]).dose;
          $scope.categoryObj[i] = data.medicineLiverTreatmentDetailDTOS[i].category;
          (function(data) {
            var detailStartDate = new Date(((data.medicineLiverTreatmentDetailDTOS[i])).detailStartDate);
            var detailEndDate = new Date(((data.medicineLiverTreatmentDetailDTOS[i])).detailEndDate);
            $scope.detailStartDateObj[i] = detailStartDate.getFullYear() + '-' + (detailStartDate.getMonth() + 1) + '-' + detailStartDate.getDate();
            $scope.detailEndDateObj[i] = detailEndDate.getFullYear() + '-' + (detailEndDate.getMonth() + 1) + '-' + detailEndDate.getDate();
          })(data);
        }


        for (var k = 1; k < data.medicineLiverTreatmentCnDTOS.length; k++) {
          var template2 = `<div class="col-md-12">&nbsp</div>
          <div class="col-sm-6">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 组成成分（g）商品名</i>
                    </div>
                    <input class="form-control" ng-model="cnTradeNameObj[` + k + `]">
                  </div>
                </div>
                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 给药途径</i>
                    </div>
                    <select ng-model="cnMethodObj[` + k + `]" class="form-control">
                      <option value="1">口服</option>
                      <option value="2">皮下注射</option>
                      <option value="9">肌肉注射</option>
                      <option value="10">静脉滴注</option>
                      <option value="12">其他</option>
                      <option value="13">不详</option>
                    </select>
                  </div>
                </div>

                <div class="col-sm-3">
                  <div class="input-group">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 日剂量</i>
                    </div>
                    <input class="form-control" ng-model="cnDoseObj[` + k + `]">
                  </div>
                </div>

                <div class="col-sm-3 col-md-offset-6">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 开始日期</i>
                    </div>
                    <input class="form-control" id="cnStartDate` + k + `" ng-model="cnStartDateObj[` + k + `]">
                  </div>
                </div>
                
                <div class="col-sm-3">
                  <div class="input-group date">
                    <div class="input-group-addon">
                      <i style="font-style: inherit;"> &ensp; 结束日期</i>
                    </div>
                    <input class="form-control" id="cnEndDate` + k + `" ng-model="cnEndDateObj[` + k + `]">
                  </div>
                </div>`;
          var compileFn2 = $compile(template2);
          var dom2 = compileFn2($scope);
          dom2.appendTo('#cnMedicine');
          $('#cnStartDate' + k).datepicker({
            autoclose: true
          });
          $('#cnEndDate' + k).datepicker({
            autoclose: true
          });
          $scope.cnTradeNameObj[k] = data.medicineLiverTreatmentCnDTOS[k].cnTradeName;
          $scope.cnMethodObj[k] = data.medicineLiverTreatmentCnDTOS[k].cnMethod;
          $scope.cnDoseObj[k] = data.medicineLiverTreatmentCnDTOS[k].cnDose;
          (function(data) {
            var cnStartDate = new Date(((data.medicineLiverTreatmentCnDTOS)[k]).cnStartDate);
            var cnEndDate = new Date(((data.medicineLiverTreatmentCnDTOS)[k]).cnEndDate);
            $scope.cnStartDateObj[k] = cnStartDate.getFullYear() + '-' + (cnStartDate.getMonth() + 1) + '-' + cnStartDate.getDate();
            $scope.cnEndDateObj[k] = cnEndDate.getFullYear() + '-' + (cnEndDate.getMonth() + 1) + '-' + cnEndDate.getDate();
          })(data);
        }

        for (var j = 1; j < data.medicineLiverTreatmentOtherDTOS.length; j++) {
          var template1 = `<div class="col-md-12">&nbsp</div>
          <div class="col-sm-3">
            <div class="input-group">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗措施</i></div>
            <input class="form-control" ng-model="methodObj[` + j + `]"></div>
          </div>
          
          <div class="col-sm-3">
            <div class="input-group">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治疗措施详述</i></div>
            <input type="text" class="form-control" ng-model="methodDetailObj[` + j + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group date">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 开始日期</i></div>
            <input class="form-control" id="otherStartDate` + j + `" ng-model="otherStartDateObj[` + j + `]"></div>
          </div>

          <div class="col-sm-3">
            <div class="input-group date">
            <div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 结束日期</i></div>
            <input class="form-control" id="otherEndDate` + j + `" ng-model="otherEndDateObj[` + j + `]"></div>
          </div>`;
          var compileFn1 = $compile(template1);
          var dom1 = compileFn1($scope);
          dom1.appendTo('#treatmentOther');
          $('#otherStartDate' + j).datepicker({
            autoclose: true
          });
          $('#otherEndDate' + j).datepicker({
            autoclose: true
          });
          $scope.methodObj[j] = ((data.medicineLiverTreatmentOtherDTOS)[j]).method;
          $scope.methodDetailObj[j] = ((data.medicineLiverTreatmentOtherDTOS)[j]).methodDetail;
          (function(data) {
            var otherStartDate = new Date(((data.medicineLiverTreatmentOtherDTOS[j])).otherStartDate);
            var otherEndDate = new Date(((data.medicineLiverTreatmentOtherDTOS[j])).otherEndDate);
            $scope.otherStartDateObj[j] = otherStartDate.getFullYear() + '-' + (otherStartDate.getMonth() + 1) + '-' + otherStartDate.getDate();
            $scope.otherEndDateObj[j] = otherEndDate.getFullYear() + '-' + (otherEndDate.getMonth() + 1) + '-' + otherEndDate.getDate();
          })(data);
        }
      });
    }

    $scope.save = function() {
      mlTreatment.medicineLiverTreatmentDetailDTOS = [];
      mlTreatment.medicineLiverTreatmentCnDTOS = [];
      mlTreatment.medicineLiverTreatmentOtherDTOS = [];
      mlTreatment.treatment = $scope.treatment;
      mlTreatment.patientId = sessionStorage.getItem('mlPatientId');
      mlTreatment.complete = true;

      if ($scope.genericName != undefined) {
        mlTreatment.medicineLiverTreatmentDetailDTOS.push({
          genericName: $scope.genericName,
          tradeName: $scope.tradeName,
          detailMethod: $scope.detailMethod,
          dose: $scope.dose,
          category: $scope.category,
          detailStartDate: new Date($scope.detailStartDate),
          detailEndDate: new Date($scope.detailEndDate)
            // id: $scope.detailId,
        });
      }

      if ($scope.cnTradeName != undefined) {
        mlTreatment.medicineLiverTreatmentCnDTOS.push({
          cnTradeName: $scope.cnTradeName,
          cnMethod: $scope.cnMethod,
          cnDose: $scope.cnDose,
          cnStartDate: new Date($scope.cnStartDate),
          cnEndDate: new Date($scope.cnEndDate)
        });
      }


      if ($scope.method != undefined) {
        mlTreatment.medicineLiverTreatmentOtherDTOS.push({
          method: $scope.method,
          methodDetail: $scope.methodDetail,
          otherStartDate: new Date($scope.otherStartDate),
          otherEndDate: new Date($scope.otherEndDate)
        });
      }

      for (var i = 1; i <= detailCount; i++) {
        mlTreatment.medicineLiverTreatmentDetailDTOS.push({
          // id: ($scope.detailIdObj[i + 1]),
          genericName: $scope.genericNameObj[i],
          tradeName: $scope.tradeNameObj[i],
          detailMethod: $scope.detailMethodObj[i],
          dose: $scope.doseObj[i],
          category: $scope.categoryObj[i],
          detailStartDate: new Date($scope.detailStartDateObj[i]),
          detailEndDate: new Date($scope.detailEndDateObj[i])
        });
      }

      for (var k = 1; k <= cnCount; k++) {
        mlTreatment.medicineLiverTreatmentCnDTOS.push({
          cnTradeName: $scope.cnTradeNameObj[k],
          cnMethod: $scope.cnMethodObj[k],
          cnDose: $scope.cnDoseObj[k],
          cnStartDate: new Date($scope.cnStartDateObj[k]),
          cnEndDate: new Date($scope.cnEndDateObj[k])
        });
      }

      for (var j = 1; j <= otherCount; j++) {
        mlTreatment.medicineLiverTreatmentOtherDTOS.push({
          // id: ($scope.detailIdObj[i + 1]),
          method: $scope.methodObj[j],
          methodDetail: $scope.methodDetailObj[j],
          otherStartDate: new Date($scope.otherStartDateObj[j]),
          otherEndDate: new Date($scope.otherEndDateObj[j])
        });
      }
      $http({
        method: 'POST',
        url: '/api/mlTreatment',
        data: mlTreatment
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