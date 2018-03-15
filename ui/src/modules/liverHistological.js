import angular from 'angular';

angular.module('liverHistological', [])
    .controller('liverHistologicalController', ['$scope', '$http', '$state', 'localStorageService', function($scope, $http, $state, localStorageService) {
        getLiverHistological();
        getMlPatient();

        var mlLiverHistological = {};

        $scope.diliClick = function(num) {
            $('#dili' + num).popover('toggle');
        };

        $scope.save = function() {
            mlLiverHistological.patientId = sessionStorage.getItem('mlPatientId');
            mlLiverHistological.interfaceHepatitis = $scope.interfaceHepatitis;
            mlLiverHistological.confluentNecrosis = $scope.confluentNecrosis;
            mlLiverHistological.focal = $scope.focal;
            mlLiverHistological.portalInflammation = $scope.portalInflammation;
            mlLiverHistological.fibrosis = $scope.fibrosis;
            mlLiverHistological.severity = $scope.severity;
            mlLiverHistological.done = $scope.done;
            mlLiverHistological.complete = true;
            $http({
                method: 'POST',
                url: '/api/mlLiverHistological',
                data: mlLiverHistological
            }).then(function success() {
                $('#myModal').modal();
            });
        };

        function getLiverHistological() {
            $http({
                method: 'GET',
                url: '/api/mlLiverHistological/' + sessionStorage.getItem('mlPatientId')
            }).then(function success(response) {
                var data = response.data;
                $scope.interfaceHepatitis = data.interfaceHepatitis;
                $scope.confluentNecrosis = data.confluentNecrosis;
                $scope.focal = data.focal;
                $scope.portalInflammation = data.portalInflammation;
                $scope.fibrosis = data.fibrosis;
                $scope.severity = data.severity;
                $scope.done = data.done;
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
    }]);