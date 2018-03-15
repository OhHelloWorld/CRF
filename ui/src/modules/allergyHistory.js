import angular from 'angular';

angular.module('allergyHistory', [])
    .controller('allergyHistoryController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {

        getMlPatient();
        getAllergy();

        $scope.layout = function() {
            $state.go('mlHome');
        };

        var allergyHistory = {};
        $scope.allergenObj = {};
        $scope.descriptionObj = {};
        $scope.medicineLiverAllergyHistoryDetailDTOS = [];

        var count = 0;

        $scope.addAllergy = function() {
            count += 1;
            var template = `<div><div class="box-body form-group">
                    <div class="input-group">
                        <span class="input-group-addon">过敏原（过敏物质）</span>
                        <input type="text" class="form-control" ng-model="allergenObj[` + count + `]">
                    </div>
                </div>
                <div class="box-body form-group">
                    <div class="input-group">
                        <span class="input-group-addon">补充说明</span>
                        <input type="text" class="form-control" ng-model="descriptionObj[` + count + `]">
                    </div>
                </div>
                </div>`;
            var compileFn = $compile(template);
            var dom = compileFn($scope);
            dom.appendTo('#allergy');
        };

        function getAllergy() {
            $http({
                method: 'GET',
                url: '/api/mlAllergyHistory/' + sessionStorage.getItem('mlPatientId')
            }).then(function success(response) {
                var data1 = response.data;
                $scope.allergyHistory = data1.allergyHistory;
                if (data1.medicineLiverAllergyHistoryDetailDTOS.length == 0 || data1.medicineLiverAllergyHistoryDetailDTOS.length == 1) {
                    count = 0;
                } else {
                    count = data1.medicineLiverAllergyHistoryDetailDTOS.length - 1;
                }

                if (data1.medicineLiverAllergyHistoryDetailDTOS.length != 0) {
                    $scope.allergen = data1.medicineLiverAllergyHistoryDetailDTOS[0].allergen;
                    $scope.description = data1.medicineLiverAllergyHistoryDetailDTOS[0].description;
                }

                for (var i = 1; i < data1.medicineLiverAllergyHistoryDetailDTOS.length; i++) {
                    var template = `<div><div class="box-body form-group">
                    <div class="input-group">
                        <span class="input-group-addon">过敏原（过敏物质）</span>
                        <input type="text" class="form-control" ng-model="allergenObj[` + i + `]">
                    </div>
                </div>
                <div class="box-body form-group">
                    <div class="input-group">
                        <span class="input-group-addon">补充说明</span>
                        <input type="text" class="form-control" ng-model="descriptionObj[` + i + `]">
                    </div>
                </div>
                </div>`;
                    var compileFn = $compile(template);
                    var dom = compileFn($scope);
                    dom.appendTo('#allergy');
                    $scope.allergenObj[i] = data1.medicineLiverAllergyHistoryDetailDTOS[i].allergen;
                    $scope.descriptionObj[i] = data1.medicineLiverAllergyHistoryDetailDTOS[i].description;
                }
            });
        }

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

        $scope.save = function() {
            allergyHistory.medicineLiverAllergyHistoryDetailDTOS = [];
            allergyHistory.patientId = sessionStorage.getItem('mlPatientId');
            allergyHistory.allergyHistory = $scope.allergyHistory;
            allergyHistory.complete = true;
            if ($scope.allergen != undefined) {
                allergyHistory.medicineLiverAllergyHistoryDetailDTOS.push({
                    allergen: $scope.allergen,
                    description: $scope.description,
                });
            }
            for (var i = 1; i <= count; i++) {
                allergyHistory.medicineLiverAllergyHistoryDetailDTOS.push({
                    allergen: ($scope.allergenObj[i]),
                    description: ($scope.descriptionObj[i]),
                });
            }
            $http({
                method: 'POST',
                url: '/api/mlAllergyHistory',
                data: allergyHistory
            }).then(function success() {
                $('#myModal').modal();
            });
        };
    }]);