import angular from 'angular';

angular.module('mlPatientInfo', [])
  .controller('mlPatientInfoController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {
    var patient = {};
    $scope.intoDiagnosisObj = {};
    $scope.intoDiagnosisDateObj = {};
    $scope.outDiagnosisObj = {};
    $scope.outDiagnosisDateObj = {};
    patient.admissionDiagnosisDTOS = [];
    patient.dischargeDiagnosisDTOS = [];
    $('#birthday').datepicker({
      autoclose: true
    });
    $('#admissionDate').datepicker({
      autoclose: true
    });
    $('#dischargeDate').datepicker({
      autoclose: true
    });
    $('#intoDiagnosisDate').datepicker({
      autoclose: true
    });
    $('#outDiagnosisDate').datepicker({
      autoclose: true
    });

    var intoHosCount = 0;
    var outHosCount = 0;

    $scope.addIntoHos = function() {
      intoHosCount += 1;
      var template1 = '<div class="col-sm-6"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 入院诊断</i></div><input class="form-control" type="text" ng-model="intoDiagnosisObj[' + intoHosCount + ']"></div></div><div class="col-sm-6"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 诊断时间</i></div><input id="intoDiagnosisDate' + intoHosCount + '" class="form-control" ng-model="intoDiagnosisDateObj[' + intoHosCount + ']"></div></div>';
      var compileFn1 = $compile(template1);
      var dom1 = compileFn1($scope);
      dom1.appendTo('#intoHos');
      $('#intoDiagnosisDate' + intoHosCount).datepicker({
        autoclose: true
      });
    };

    $scope.addOutHos = function() {
      outHosCount += 1;
      var template2 = '<div class="col-sm-6"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 出院诊断</i></div><input class="form-control" type="text" ng-model="outDiagnosisObj[' + outHosCount + ']"></div></div><div class="col-sm-6"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 诊断时间</i></div><input id="outDiagnosisDate' + outHosCount + '" class="form-control" ng-model="outDiagnosisDateObj[' + outHosCount + ']"></div></div>';
      var compileFn2 = $compile(template2);
      var dom2 = compileFn2($scope);
      dom2.appendTo('#outHos');
      $('#outDiagnosisDate' + outHosCount).datepicker({
        autoclose: true
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;

        intoHosCount = data.admissionDiagnosisDTOS.length - 1;
        outHosCount = data.dischargeDiagnosisDTOS.length - 1;
        $scope.name = data.name;
        $scope.abbreviation = data.abbreviation;
        $scope.identifier = data.identifier;
        (function(data) {
          var birthday = new Date(data.birthday);
          var admissionDate = new Date(data.admissionDate);
          var dischargeDate = new Date(data.dischargeDate);
          if (data.admissionDiagnosisDTOS.length != 0) {
            var intoDiagnosisDate = new Date(data.admissionDiagnosisDTOS[0].diagnosisDate);
            $scope.intoDiagnosisDate = intoDiagnosisDate.getFullYear() + '-' + (intoDiagnosisDate.getMonth() + 1) + '-' + intoDiagnosisDate.getDate();
          }
          if (data.dischargeDiagnosisDTOS.length != 0) {
            var outDiagnosisDate = new Date(data.dischargeDiagnosisDTOS[0].diagnosisDate);
            $scope.outDiagnosisDate = outDiagnosisDate.getFullYear() + '-' + (outDiagnosisDate.getMonth() + 1) + '-' + outDiagnosisDate.getDate();
          }
          $scope.birthday = birthday.getFullYear() + '-' + (birthday.getMonth() + 1) + '-' + birthday.getDate();
          $scope.admissionDate = admissionDate.getFullYear() + '-' + (admissionDate.getMonth() + 1) + '-' + admissionDate.getDate();
          $scope.dischargeDate = dischargeDate.getFullYear() + '-' + (dischargeDate.getMonth() + 1) + '-' + dischargeDate.getDate();
        })(data);

        $scope.nation = data.nation;
        $scope.weight = data.weight;
        $scope.height = data.height;
        $scope.gender = data.gender;
        $scope.career = data.career;
        $scope.investigateHospital = data.investigateHospital;
        $scope.department = data.department;
        $scope.hospitalizedAge = data.hospitalizedAge;
        $scope.hospitalizedNumber = data.hospitalizedNumber;
        $scope.hospitalizedDepartment = data.hospitalizedDepartment;
        if (data.admissionDiagnosisDTOS.length != 0) {
          $scope.intoDiagnosis = data.admissionDiagnosisDTOS[0].diagnosis;
        }
        if (data.dischargeDiagnosisDTOS.length != 0) {
          $scope.outDiagnosis = data.dischargeDiagnosisDTOS[0].diagnosis;
        }

        for (var i = 1; i < data.admissionDiagnosisDTOS.length; i++) {
          var template1 = '<div class="col-sm-6"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 入院诊断</i></div><input class="form-control" type="text" ng-model="intoDiagnosisObj[' + i + ']"></div></div><div class="col-sm-6"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 诊断时间</i></div><input id="intoDiagnosisDate' + i + '" class="form-control" ng-model="intoDiagnosisDateObj[' + i + ']"></div></div>';
          var compileFn1 = $compile(template1);
          var dom1 = compileFn1($scope);
          dom1.appendTo('#intoHos');
          $('#intoDiagnosisDate' + i).datepicker({
            autoclose: true
          });
          $scope.intoDiagnosisObj[i] = ((data.admissionDiagnosisDTOS)[i]).diagnosis;
          var dynamicDate1 = new Date(((data.admissionDiagnosisDTOS)[i]).diagnosisDate);
          $scope.intoDiagnosisDateObj[i] = dynamicDate1.getFullYear() + '-' + (dynamicDate1.getMonth() + 1) + '-' + dynamicDate1.getDate();
        }

        for (var j = 1; j < data.dischargeDiagnosisDTOS.length; j++) {
          var template2 = '<div class="col-sm-6"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 出院诊断</i></div><input class="form-control" type="text" ng-model="outDiagnosisObj[' + j + ']"></div></div><div class="col-sm-6"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 诊断时间</i></div><input id="outDiagnosisDate' + j + '" class="form-control" ng-model="outDiagnosisDateObj[' + j + ']"></div></div>';
          var compileFn2 = $compile(template2);
          var dom2 = compileFn2($scope);
          dom2.appendTo('#outHos');
          $('#outDiagnosisDate' + j).datepicker({
            autoclose: true
          });
          var dynamicDate2 = new Date(((data.dischargeDiagnosisDTOS)[j]).diagnosisDate);
          $scope.outDiagnosisObj[j] = ((data.dischargeDiagnosisDTOS)[j]).diagnosis;
          $scope.outDiagnosisDateObj[j] = dynamicDate2.getFullYear() + '-' + (dynamicDate2.getMonth() + 1) + '-' + dynamicDate2.getDate();
        }
      });
    }

    $scope.save = function() {
      patient.admissionDiagnosisDTOS = [];
      patient.dischargeDiagnosisDTOS = [];
      patient.name = $scope.name;
      patient.abbreviation = $scope.abbreviation;
      patient.birthday = new Date($scope.birthday);
      patient.nation = $scope.nation;
      patient.weight = $scope.weight;
      patient.height = $scope.height;
      patient.gender = $scope.gender;
      patient.career = $scope.career;
      patient.identifier = $scope.identifier;
      patient.investigateHospital = $scope.investigateHospital;
      patient.department = $scope.department;
      patient.admissionDate = new Date($scope.admissionDate);
      patient.hospitalizedAge = $scope.hospitalizedAge;
      patient.dischargeDate = new Date($scope.dischargeDate);
      patient.hospitalizedNumber = $scope.hospitalizedNumber;
      patient.hospitalizedDepartment = $scope.hospitalizedDepartment;
      patient.admissionDiagnosisDTOS.push({
        diagnosis: $scope.intoDiagnosis,
        diagnosisDate: new Date($scope.intoDiagnosisDate)
      });
      patient.dischargeDiagnosisDTOS.push({
        diagnosis: $scope.outDiagnosis,
        diagnosisDate: new Date($scope.outDiagnosisDate)
      });
      patient.projectId = 2;
      for (var i = 0; i < intoHosCount; i++) {
        patient.admissionDiagnosisDTOS.push({
          diagnosis: ($scope.intoDiagnosisObj[i + 1]),
          diagnosisDate: new Date($scope.intoDiagnosisDateObj[i + 1])
        });
      }
      for (var j = 0; j < outHosCount; j++) {
        patient.dischargeDiagnosisDTOS.push({
          diagnosis: ($scope.outDiagnosisObj[j + 1]),
          diagnosisDate: new Date($scope.outDiagnosisDateObj[j + 1])
        });
      }
      if (!sessionStorage.getItem('mlPatientId')) {
        $http({
          method: 'POST',
          url: '/api/mlPatient',
          data: patient
        }).then(function success() {
          $('#myModal').modal();
        });
      } else {
        patient.id = sessionStorage.getItem('mlPatientId');
        $http({
          method: 'PUT',
          url: '/api/mlPatient',
          data: patient
        }).then(function success() {
          $('#myModal').modal();
        });
      }
    };
  }]);