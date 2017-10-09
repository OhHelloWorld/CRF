import angular from 'angular';

angular.module('diseaseHistory', [])
  .controller('diseaseHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {

    $('#diagnosisDate').datepicker({
      autoclose: true
    });
    $('#crueDate').datepicker({
      autoclose: true
    });
    var diseaseHistory = {};
    $scope.diseaseNameObj = {};
    $scope.diagnosisDateObj = {};
    $scope.crueDateObj = {};
    $scope.existenceObj = {};
    $scope.detailIdObj = {};
    $scope.medicineLiverDiseaseHistoryDetailDTOS = [];

    getMlPatient();

    $scope.$watch('otherHistory', function() {
      if ($scope.otherHistory == 1) {
        $scope.diseaseShow = false;
      } else if ($scope.otherHistory == 2) {
        $scope.diseaseShow = true;
      }
    });

    var count = 0;

    $scope.addDisease = function() {
      count += 1;
      var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病名称</i></div><input class="form-control" ng-model="diseaseNameObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 发作/诊断日期</i></div><input class="form-control" id="diagnosisDate' + count + '" ng-model="diagnosisDateObj[' + count + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治愈日期</i></div><input class="form-control" id="crueDate' + count + '" ng-model="crueDateObj[' + count + ']"></div></div><div class="col-md-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否仍然存在</i></div><select ng-model="existenceObj['+count+']" class="form-control"><option value="1">是</option><option value="2">否</option></select></div></div>';
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('#disease');
      $('#diagnosisDate' + count).datepicker({
        autoclose: true
      });
      $('#crueDate' + count).datepicker({
        autoclose: true
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlDiseaseHistory/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;
        $scope.otherHistory = data.otherHistory;
        $scope.pastDisease = data.pastDisease;
        (function(data) {
          if (data.medicineLiverDiseaseHistoryDetailDTOS.length != 0) {
            if(data.medicineLiverDiseaseHistoryDetailDTOS.length == 1){
              count = 0;
            }else{
              count = data.medicineLiverDiseaseHistoryDetailDTOS.length - 1;
            }
            if (data.medicineLiverDiseaseHistoryDetailDTOS[0].diagnosisDate != null) {
              var diagnosisDate = new Date(data.medicineLiverDiseaseHistoryDetailDTOS[0].diagnosisDate);
              $scope.diagnosisDate = diagnosisDate.getFullYear() + '-' + (diagnosisDate.getMonth() + 1) + '-' + diagnosisDate.getDate();
            }
            if (data.medicineLiverDiseaseHistoryDetailDTOS[0].crueDate != null) {
              var crueDate = new Date(data.medicineLiverDiseaseHistoryDetailDTOS[0].crueDate);
              $scope.crueDate = crueDate.getFullYear() + '-' + (crueDate.getMonth() + 1) + '-' + crueDate.getDate();
            }
          }else{
            count = 0;
          }
        })(data);

        if (data.medicineLiverDiseaseHistoryDetailDTOS.length != 0) {
          $scope.diseaseName = data.medicineLiverDiseaseHistoryDetailDTOS[0].diseaseName;
          $scope.existence = data.medicineLiverDiseaseHistoryDetailDTOS[0].existence;
          $scope.detailId = data.medicineLiverDiseaseHistoryDetailDTOS[0].id;
        }

        for (var i = 1; i < data.medicineLiverDiseaseHistoryDetailDTOS.length; i++) {
          var template = '<div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 疾病名称</i></div><input class="form-control" ng-model="diseaseNameObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 发作/诊断日期</i></div><input class="form-control" id="diagnosisDate' + i + '" ng-model="diagnosisDateObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 治愈日期</i></div><input class="form-control" id="crueDate' + i + '" ng-model="crueDateObj[' + i + ']"></div></div><div class="col-sm-3"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 是否仍然存在</i></div><select ng-model="existenceObj['+i+']" class="form-control"><option value="1">是</option><option value="2">否</option></select></div></div>';
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('#disease');
          $('#diagnosisDate' + i).datepicker({
            autoclose: true
          });
          $('#crueDate' + i).datepicker({
            autoclose: true
          });
          $scope.diseaseNameObj[i] = ((data.medicineLiverDiseaseHistoryDetailDTOS)[i]).diseaseName;
          $scope.existenceObj[i] = ((data.medicineLiverDiseaseHistoryDetailDTOS)[i]).existence;
          $scope.detailIdObj[i] = ((data.medicineLiverDiseaseHistoryDetailDTOS[i])).id;
          var diagnosisDate = new Date(((data.medicineLiverDiseaseHistoryDetailDTOS)[i]).diagnosisDate);
          var crueDate = new Date(((data.medicineLiverDiseaseHistoryDetailDTOS)[i]).crueDate);
          $scope.diagnosisDateObj[i] = diagnosisDate.getFullYear() + '-' + (diagnosisDate.getMonth() + 1) + '-' + diagnosisDate.getDate();
          $scope.crueDateObj[i] = crueDate.getFullYear() + '-' + (crueDate.getMonth() + 1) + '-' + crueDate.getDate();
        }
      });
    }

    $scope.save = function() {
      diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS = [];
      diseaseHistory.otherHistory = $scope.otherHistory;
      diseaseHistory.pastDisease = $scope.pastDisease;
      diseaseHistory.patientId = sessionStorage.getItem('mlPatientId');
      diseaseHistory.complete = true;

      diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS.push({
        diseaseName: $scope.diseaseName,
        existence: $scope.existence,
        id: $scope.detailId,
        diagnosisDate: new Date($scope.diagnosisDate),
        crueDate: new Date($scope.crueDate)
      });
      for (var i = 1; i <= count; i++) {
        diseaseHistory.medicineLiverDiseaseHistoryDetailDTOS.push({
          id: ($scope.detailIdObj[i]),
          diseaseName: ($scope.diseaseNameObj[i]),
          existence: ($scope.existenceObj[i]),
          diagnosisDate: new Date($scope.diagnosisDateObj[i]),
          crueDate: new Date($scope.crueDateObj[i])
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