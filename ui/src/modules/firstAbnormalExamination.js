import angular from 'angular';

angular.module('firstAbnormalExamination', [])
    .controller('firstAbnormalExaminationController', ['$scope', '$http', '$state', function($scope, $http, $state) {
        getPatientInfo();
        getFirstData();
        $('#datepicker1').datepicker({
            autoclose: true
        });

        $('#datepicker2').datepicker({
            autoclose: true
        });

        $('#datepicker3').datepicker({
            autoclose: true
        });

        $('#datepicker4').datepicker({
            autoclose: true
        });

        $('#datepicker5').datepicker({
            autoclose: true
        });

        // 06/14/2017 ==> 2017-06-14
        // function formatDateFromBack(date) {
        //   var dateArr = date.split('/');
        //   var year = dateArr[2];
        //   var month = dateArr[0];
        //   var day = dateArr[1];
        //   return year + '-' + month + '-' + day;
        // }

        //检查日期字段需要满足的情况
        // function checkDate(condition1) {
        //   if (!condition1) {
        //     return condition1;
        //   } else {
        //     if (condition1.includes('-')) {
        //       return condition1;
        //     } else {
        //       return formatDateFromBack(condition1);
        //     }
        //   }
        // }


        //保存数据
        $scope.showSaveModal = function() {
            var allDatc = {};
            allDatc.patientId = sessionStorage.getItem('mlPatientId');
            allDatc.tab1CheckDate = new Date($scope.tab1CheckDate);
            allDatc.tab2CheckDate = new Date($scope.tab2CheckDate);
            allDatc.tab3CheckDate = new Date($scope.tab3CheckDate);
            allDatc.tab4CheckDate = new Date($scope.tab4CheckDate);
            allDatc.tab5CheckDate = new Date($scope.tab5CheckDate);
            allDatc.alt = $scope.alt;
            allDatc.ast = $scope.ast;
            allDatc.ggt = $scope.ggt;
            allDatc.alp = $scope.alp;
            allDatc.bileAcid = $scope.bileAcid;
            allDatc.tbil = $scope.tbil;
            allDatc.dbil = $scope.dbil;
            allDatc.tp = $scope.tp;
            allDatc.alb = $scope.alb;
            allDatc.scr = $scope.scr;
            allDatc.bun = $scope.bun;
            allDatc.plasmaGlucose = $scope.plasmaGlucose;
            allDatc.pt = $scope.pt;
            allDatc.inr = $scope.inr;
            allDatc.afp = $scope.afp;
            allDatc.first = true;
            allDatc.complete = true;
            $http({
                method: 'POST',
                url: '/api/mlfae/',
                data: allDatc
            }).then(function() {
                $scope.justModalContent = '操作成功';
                $('#justModal').modal('show');
            }, function() {
                $scope.justModalContent = '操作失败';
                $('#justModal').modal('show');
            });
        };

        $scope.layout = function() {
            $state.go('mlHome');
        };

        function getFirstData() {
            if (sessionStorage.getItem('mlPatientId')) {
                $http({
                    url: '/api/mlfae/first/' + sessionStorage.getItem('mlPatientId'),
                    method: 'GET'
                }).then(function success(response) {
                    var data = response.data;
                    if (data.tab1CheckDate) {
                        $scope.tab1CheckDate = showDate(new Date(data.tab1CheckDate));
                    }
                    if (data.tab2CheckDate) {
                        $scope.tab2CheckDate = showDate(new Date(data.tab2CheckDate));
                    }
                    if (data.tab3CheckDate) {
                        $scope.tab3CheckDate = showDate(new Date(data.tab3CheckDate));
                    }
                    if (data.tab4CheckDate) {
                        $scope.tab4CheckDate = showDate(new Date(data.tab4CheckDate));
                    }
                    if (data.tab5CheckDate) {
                        $scope.tab5CheckDate = showDate(new Date(data.tab5CheckDate));
                    }

                    $scope.alt = data.alt;
                    $scope.ast = data.ast;
                    $scope.ggt = data.ggt;
                    $scope.alp = data.alp;
                    $scope.bileAcid = data.bileAcid;
                    $scope.tbil = data.tbil;
                    $scope.dbil = data.dbil;
                    $scope.tp = data.tp;
                    $scope.alb = data.alb;
                    $scope.scr = data.scr;
                    $scope.bun = data.bun;
                    $scope.plasmaGlucose = data.plasmaGlucose;
                    $scope.pt = data.pt;
                    $scope.inr = data.inr;
                    $scope.afp = data.afp;
                });
            }
        }

        function getPatientInfo() {
            $http({
                method: 'GET',
                url: '/api/mlPatient/' + sessionStorage.getItem('mlPatientId')
            }).then(function success(response) {
                $scope.patientName = response.data.name;
                $scope.patientNumber = response.data.identifier;
            });
        }

        function showDate(date) {
            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
        }


    }]);