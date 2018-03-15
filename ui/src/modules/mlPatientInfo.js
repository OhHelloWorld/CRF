import angular from 'angular';
import '../entries/medicineLiverMain.js';

angular.module('mlPatientInfo', ['medicineLiverMain'])
    .controller('mlPatientInfoController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {
        var patient = {};
        $scope.mlPatientMenuClick();
        $scope.intoDiagnosisObj = {};
        $scope.intoDiagnosisDateObj = {};
        $scope.admissIdObj = {};
        $scope.outDiagnosisObj = {};
        $scope.outDiagnosisDateObj = {};
        $scope.dischargeIdObj = {};
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

        $scope.$watch('height', function() {
            if ($scope.weight && $scope.height) {
                $scope.bmi = ($scope.weight) / ($scope.height / 100 * $scope.height / 100);
            }
        });
        $scope.$watch('weight', function() {
            if ($scope.weight && $scope.height) {
                $scope.bmi = ($scope.weight) / ($scope.height / 100 * $scope.height / 100);
            }
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

                $scope.name = data.name;
                $scope.abbreviation = data.abbreviation;
                $scope.identifier = data.identifier;
                (function(data) {
                    if (data.admissionDiagnosisDTOS.length != 0) {
                        if (data.admissionDiagnosisDTOS.length == 1) {
                            intoHosCount = 0;
                        } else {
                            intoHosCount = data.admissionDiagnosisDTOS.length - 1;
                        }
                        $scope.intoDiagnosisDate = showDate(data.admissionDiagnosisDTOS[0].diagnosisDate);
                    } else {
                        intoHosCount = 0;
                    }
                    if (data.dischargeDiagnosisDTOS.length != 0) {
                        if (data.dischargeDiagnosisDTOS.length == 1) {
                            outHosCount = 0;
                        } else {
                            outHosCount = data.dischargeDiagnosisDTOS.length - 1;
                        }
                        $scope.outDiagnosisDate = showDate(data.dischargeDiagnosisDTOS[0].diagnosisDate);
                    } else {
                        outHosCount = 0;
                    }
                    $scope.birthday = showDate(data.birthday);
                    $scope.admissionDate = showDate(data.admissionDate);
                    $scope.dischargeDate = showDate(data.dischargeDate);
                })(data);

                $scope.nation = data.nation;
                if (data.weight != 0) {
                    $scope.weight = data.weight;
                }
                if (data.height != 0) {
                    $scope.height = data.height;
                }
                $scope.gender = data.gender;
                $scope.career = data.career;
                $scope.hospital = data.hospital;
                $scope.department = data.department;
                if (data.hospitalizedAge != 0) {
                    $scope.hospitalizedAge = data.hospitalizedAge;
                }
                $scope.hospitalizedNumber = data.hospitalizedNumber;
                if (data.admissionDiagnosisDTOS.length != 0) {
                    $scope.intoDiagnosis = data.admissionDiagnosisDTOS[0].diagnosis;
                    $scope.admissId = data.admissionDiagnosisDTOS[0].id;
                }
                if (data.dischargeDiagnosisDTOS.length != 0) {
                    $scope.outDiagnosis = data.dischargeDiagnosisDTOS[0].diagnosis;
                    $scope.dischargeId = data.dischargeDiagnosisDTOS[0].id;
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
                    $scope.admissIdObj[i] = ((data.admissionDiagnosisDTOS)[i]).id;
                    $scope.intoDiagnosisDateObj[i] = showDate(data.admissionDiagnosisDTOS[i].diagnosisDate);
                }
                for (var j = 1; j < data.dischargeDiagnosisDTOS.length; j++) {
                    var template2 = '<div class="col-sm-6"><div class="input-group"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 出院诊断</i></div><input class="form-control" type="text" ng-model="outDiagnosisObj[' + j + ']"></div></div><div class="col-sm-6"><div class="input-group date"><div class="input-group-addon"><i style="font-style: inherit;"> &ensp; 诊断时间</i></div><input id="outDiagnosisDate' + j + '" class="form-control" ng-model="outDiagnosisDateObj[' + j + ']"></div></div>';
                    var compileFn2 = $compile(template2);
                    var dom2 = compileFn2($scope);
                    dom2.appendTo('#outHos');
                    $('#outDiagnosisDate' + j).datepicker({
                        autoclose: true
                    });
                    $scope.outDiagnosisObj[j] = ((data.dischargeDiagnosisDTOS)[j]).diagnosis;
                    $scope.dischargeIdObj[j] = ((data.dischargeDiagnosisDTOS)[j]).id;
                    $scope.outDiagnosisDateObj[j] = showDate(data.dischargeDiagnosisDTOS[j].diagnosisDate);
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
            patient.hospital = $scope.hospital;
            patient.department = $scope.department;
            patient.admissionDate = new Date($scope.admissionDate);
            patient.hospitalizedAge = $scope.hospitalizedAge;
            patient.dischargeDate = new Date($scope.dischargeDate);
            patient.hospitalizedNumber = $scope.hospitalizedNumber;

            if ($scope.intoDiagnosis != undefined) {
                patient.admissionDiagnosisDTOS.push({
                    id: $scope.admissId,
                    diagnosis: $scope.intoDiagnosis,
                    diagnosisDate: new Date($scope.intoDiagnosisDate)
                });
            }
            if ($scope.outDiagnosis != undefined) {
                patient.dischargeDiagnosisDTOS.push({
                    id: $scope.dischargeId,
                    diagnosis: $scope.outDiagnosis,
                    diagnosisDate: new Date($scope.outDiagnosisDate)
                });
            }
            patient.projectId = 2;
            for (var i = 1; i <= intoHosCount; i++) {
                patient.admissionDiagnosisDTOS.push({
                    id: judge($scope.admissIdObj[i]),
                    diagnosis: $scope.intoDiagnosisObj[i],
                    diagnosisDate: new Date($scope.intoDiagnosisDateObj[i])
                });
            }
            for (var j = 1; j <= outHosCount; j++) {
                patient.dischargeDiagnosisDTOS.push({
                    id: judge($scope.dischargeIdObj[j]),
                    diagnosis: ($scope.outDiagnosisObj[j]),
                    diagnosisDate: new Date($scope.outDiagnosisDateObj[j])
                });
            }
            if (!sessionStorage.getItem('mlPatientId')) {
                $http({
                    method: 'POST',
                    url: '/api/mlPatient',
                    data: patient
                }).then(function success(res) {
                    sessionStorage.setItem('mlPatientId', res.data);
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

        $scope.layout = function() {
            $state.go('mlHome');
        };

        function judge(number) {
            if (number == undefined) {
                return 0;
            }
        }

        function showDate(date) {
            if (date > 0) {
                var showDate = new Date(date);
                return showDate.getFullYear() + '-' + (showDate.getMonth() + 1) + '-' + showDate.getDate();
            }
        }
    }]);