import angular from 'angular';

angular.module('hospitalAbnormalExamination', [])
    .controller('hospitalAbnormalExaminationController', ['$scope', '$http', '$state', '$compile', function($scope, $http, $state, $compile) {

        var allDatc = {};

        //肝脏生化检查动态数据
        $scope.altObj = {};
        $scope.astObj = {};
        $scope.ggtObj = {};
        $scope.alpObj = {};
        $scope.bileAcidObj = {};
        $scope.tbilObj = {};
        $scope.dbilObj = {};
        $scope.tpObj = {};
        $scope.albObj = {};
        $scope.tab1CheckDateObj = {};

        //肾功能检查
        $scope.scrObj = {};
        $scope.ureaNitrogenObj = {};
        $scope.tab2CheckDateObj = {};

        //血糖检查
        $scope.plasmaGlucoseObj = {};
        $scope.tab3CheckDateObj = {};

        //凝血功能检查
        $scope.ptObj = {};
        $scope.inrObj = {};
        $scope.tab4CheckDateObj = {};

        //肿瘤标志物检查
        $scope.afpObj = {};
        $scope.tab5CheckDateObj = {};

        //数据集合
        $scope.medicineLiverHospitalAbnormalExaminationLiverDTOS = [];
        $scope.medicineLiverHospitalAbnormalExaminationKidneyDTOS = [];
        $scope.medicineLiverHospitalAbnormalExaminationBsDTOS = [];
        $scope.medicineLiverHospitalAbnormalExaminationCruorDTOS = [];
        $scope.medicineLiverHospitalAbnormalExaminationTumourDTOS = [];

        //计数
        var liverCount = 0;
        var kidneyCount = 0;
        var bsCount = 0;
        var cruorCount = 0;
        var tumourCount = 0;


        getPatientInfo();
        getHosData();
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

        $scope.addLiver = function() {
            liverCount += 1;
            var liverTemplate = `<tr>
                                <td style="text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="liverDatepicker` + liverCount + `" ng-model="tab1CheckDateObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="altObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="astObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ggtObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="alpObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="bileAcidObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="tbilObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="dbilObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="tpObj[` + liverCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="albObj[` + liverCount + `]">
                                </td>
                            </tr>`;
            var liverCompileFn = $compile(liverTemplate);
            var liverDom = liverCompileFn($scope);
            liverDom.appendTo('#liver');
            $('#liverDatepicker' + liverCount).datepicker({
                autoclose: true
            });
        };

        $scope.addKidney = function() {
            kidneyCount += 1;
            var kidneyTemplate = `<tr>
                                <td style=" text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="kidneyDatepicker` + kidneyCount + `" ng-model="tab2CheckDateObj[` + kidneyCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="scrObj[` + kidneyCount + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ureaNitrogenObj[` + kidneyCount + `]">
                                </td>
                            </tr>`;
            var kidneyCompileFn = $compile(kidneyTemplate);
            var kidneyDom = kidneyCompileFn($scope);
            kidneyDom.appendTo('#kidney');
            $('#kidneyDatepicker' + kidneyCount).datepicker({
                autoclose: true
            });
        };

        $scope.addBs = function() {
            bsCount += 1;
            var bsTemplate = `<tr>
                                <td height="38px" style=" text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="bsDatepicker` + bsCount + `" ng-model="tab3CheckDateObj[` + bsCount + `]">
                                </td>
                                <td height="38px" style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="plasmaGlucoseObj[` + bsCount + `]">
                                </td>
                            </tr>`;
            var bsCompileFn = $compile(bsTemplate);
            var bsDom = bsCompileFn($scope);
            bsDom.appendTo('#bs');
            $('#bsDatepicker' + bsCount).datepicker({
                autoclose: true
            });
        };

        $scope.addCruor = function() {
            cruorCount += 1;
            var cruorTemplate = `<tr>
                            <td height="38px" style=" text-align: -webkit-center;">
                                <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="cruorDatepicker` + cruorCount + `" ng-model="tab4CheckDateObj[` + cruorCount + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ptObj[` + cruorCount + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="inrObj[` + cruorCount + `]">
                            </td>
                        </tr>`;
            var cruorCompileFn = $compile(cruorTemplate);
            var cruorDom = cruorCompileFn($scope);
            cruorDom.appendTo('#cruor');
            $('#cruorDatepicker' + cruorCount).datepicker({
                autoclose: true
            });
        };

        $scope.addTumour = function() {
            tumourCount += 1;
            var tumourTemplate = `<tr>
                            <td height="38px" style=" text-align: -webkit-center;">
                                <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="tumourDatepicker` + tumourCount + `" ng-model="tab5CheckDateObj[` + tumourCount + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="afpObj[` + tumourCount + `]">
                            </td>
                        </tr>`;
            var tumourCompileFn = $compile(tumourTemplate);
            var tumourDom = tumourCompileFn($scope);
            tumourDom.appendTo('#tumour');
            $('#tumourDatepicker' + tumourCount).datepicker({
                autoclose: true
            });
        };



        //保存数据
        $scope.showSaveModal = function() {
            allDatc.medicineLiverHospitalAbnormalExaminationLiverDTOS = [];
            allDatc.medicineLiverHospitalAbnormalExaminationKidneyDTOS = [];
            allDatc.medicineLiverHospitalAbnormalExaminationBsDTOS = [];
            allDatc.medicineLiverHospitalAbnormalExaminationCruorDTOS = [];
            allDatc.medicineLiverHospitalAbnormalExaminationTumourDTOS = [];
            allDatc.patientId = sessionStorage.getItem('mlPatientId');
            allDatc.complete = true;

            //肝脏生化检查动态数据绑定
            if ($scope.tab1CheckDate != undefined) {
                allDatc.medicineLiverHospitalAbnormalExaminationLiverDTOS.push({
                    alt: $scope.alt,
                    ast: $scope.ast,
                    ggt: $scope.ggt,
                    alp: $scope.alp,
                    bileAcid: $scope.bileAcid,
                    tbil: $scope.tbil,
                    dbil: $scope.dbil,
                    tp: $scope.tp,
                    alb: $scope.alb,
                    tab1CheckDate: new Date($scope.tab1CheckDate)
                });
            }
            for (var i = 1; i <= liverCount; i++) {
                allDatc.medicineLiverHospitalAbnormalExaminationLiverDTOS.push({
                    alt: $scope.altObj[i],
                    ast: $scope.astObj[i],
                    ggt: $scope.ggtObj[i],
                    alp: $scope.alpObj[i],
                    bileAcid: $scope.bileAcidObj[i],
                    tbil: $scope.tbilObj[i],
                    dbil: $scope.dbilObj[i],
                    tp: $scope.tpObj[i],
                    alb: $scope.albObj[i],
                    tab1CheckDate: new Date($scope.tab1CheckDateObj[i])
                });
            }

            //肾功能检查动态数据绑定
            if ($scope.tab2CheckDate != undefined) {
                allDatc.medicineLiverHospitalAbnormalExaminationKidneyDTOS.push({
                    scr: $scope.scr,
                    ureaNitrogen: $scope.ureaNitrogen,
                    tab2CheckDate: new Date($scope.tab2CheckDate)
                });
            }
            for (var j = 1; j <= kidneyCount; j++) {
                allDatc.medicineLiverHospitalAbnormalExaminationKidneyDTOS.push({
                    scr: $scope.scrObj[j],
                    ureaNitrogen: $scope.ureaNitrogenObj[j],
                    tab2CheckDate: new Date($scope.tab2CheckDateObj[j])
                });
            }

            //血糖检查动态数据绑定
            if ($scope.tab3CheckDate != undefined) {
                allDatc.medicineLiverHospitalAbnormalExaminationBsDTOS.push({
                    plasmaGlucose: $scope.plasmaGlucose,
                    tab3CheckDate: new Date($scope.tab3CheckDate)
                });
            }
            for (var k = 1; k <= bsCount; k++) {
                allDatc.medicineLiverHospitalAbnormalExaminationBsDTOS.push({
                    plasmaGlucose: $scope.plasmaGlucoseObj[k],
                    tab3CheckDate: new Date($scope.tab3CheckDateObj[k])
                });
            }

            //凝血功能动态数据绑定
            if ($scope.tab4CheckDate != undefined) {
                allDatc.medicineLiverHospitalAbnormalExaminationCruorDTOS.push({
                    pt: $scope.pt,
                    inr: $scope.inr,
                    tab4CheckDate: new Date($scope.tab4CheckDate)
                });
            }
            for (var m = 1; m <= cruorCount; m++) {
                allDatc.medicineLiverHospitalAbnormalExaminationCruorDTOS.push({
                    pt: $scope.ptObj[m],
                    inr: $scope.inrObj[m],
                    tab4CheckDate: new Date($scope.tab4CheckDateObj[m])
                });
            }

            //肿瘤标志物动态数据绑定
            if ($scope.tab5CheckDate != undefined) {
                allDatc.medicineLiverHospitalAbnormalExaminationTumourDTOS.push({
                    afp: $scope.afp,
                    tab5CheckDate: new Date($scope.tab5CheckDate)
                });
            }
            for (var n = 1; n <= tumourCount; n++) {
                allDatc.medicineLiverHospitalAbnormalExaminationTumourDTOS.push({
                    afp: $scope.afpObj[n],
                    tab5CheckDate: new Date($scope.tab5CheckDateObj[n])
                });
            }

            $http({
                method: 'POST',
                url: '/api/mlHospitalExam',
                data: allDatc
            }).then(function() {
                $scope.justModalContent = '操作成功';
                $('#justModal').modal('show');
            }, function() {
                $scope.justModalContent = '操作失败';
                $('#justModal').modal('show');
            });
        };

        function getHosData() {
            if (sessionStorage.getItem('mlPatientId')) {
                $http({
                    url: '/api/mlHospitalExam/' + sessionStorage.getItem('mlPatientId'),
                    method: 'GET'
                }).then(function success(response) {
                    var data = response.data;

                    //绑定肝脏生化检查数据
                    if (data.medicineLiverHospitalAbnormalExaminationLiverDTOS.length == 0 || data.medicineLiverHospitalAbnormalExaminationLiverDTOS.length == 1) {
                        liverCount = 0;
                    } else {
                        liverCount = data.medicineLiverHospitalAbnormalExaminationLiverDTOS.length - 1;
                    }
                    if (data.medicineLiverHospitalAbnormalExaminationLiverDTOS.length != 0) {
                        $scope.alt = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].alt;
                        $scope.ast = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].ast;
                        $scope.ggt = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].ggt;
                        $scope.alp = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].alp;
                        $scope.bileAcid = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].bileAcid;
                        $scope.tbil = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].tbil;
                        $scope.dbil = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].dbil;
                        $scope.tp = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].tp;
                        $scope.alb = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].alb;
                        if (data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].tab1CheckDate) {
                            $scope.tab1CheckDate = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationLiverDTOS[0].tab1CheckDate));
                        }
                    }
                    for (var i = 1; i < data.medicineLiverHospitalAbnormalExaminationLiverDTOS.length; i++) {
                        var liverTemplate = `<tr>
                                <td style="text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="liverDatepicker` + i + `" ng-model="tab1CheckDateObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="altObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="astObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ggtObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="alpObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="bileAcidObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="tbilObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="dbilObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="tpObj[` + i + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="albObj[` + i + `]">
                                </td>
                            </tr>`;
                        var liverCompileFn = $compile(liverTemplate);
                        var liverDom = liverCompileFn($scope);
                        liverDom.appendTo('#liver');
                        $('#liverDatepicker' + i).datepicker({
                            autoclose: true
                        });
                        $scope.altObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].alt;
                        $scope.astObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].ast;
                        $scope.ggtObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].ggt;
                        $scope.alpObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].alp;
                        $scope.bileAcidObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].bileAcid;
                        $scope.tbilObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].tbil;
                        $scope.dbilObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].dbil;
                        $scope.tpObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].tp;
                        $scope.albObj[i] = data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].alb;
                        if (data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].tab1CheckDate) {
                            $scope.tab1CheckDateObj[i] = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationLiverDTOS[i].tab1CheckDate));
                        }
                    }

                    //绑定肾功能检查数据
                    if (data.medicineLiverHospitalAbnormalExaminationKidneyDTOS.length == 0 || data.medicineLiverHospitalAbnormalExaminationKidneyDTOS.length == 1) {
                        kidneyCount = 0;
                    } else {
                        kidneyCount = data.medicineLiverHospitalAbnormalExaminationKidneyDTOS.length - 1;
                    }
                    if (data.medicineLiverHospitalAbnormalExaminationKidneyDTOS.length != 0) {
                        $scope.scr = data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[0].scr;
                        $scope.ureaNitrogen = data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[0].ureaNitrogen;
                        if (data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[0].tab2CheckDate) {
                            $scope.tab2CheckDate = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[0].tab2CheckDate));
                        }
                    }
                    for (var j = 1; j < data.medicineLiverHospitalAbnormalExaminationKidneyDTOS.length; j++) {
                        var kidneyTemplate = `<tr>
                                <td style=" text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="kidneyDatepicker` + j + `" ng-model="tab2CheckDateObj[` + j + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="scrObj[` + j + `]">
                                </td>
                                <td style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ureaNitrogenObj[` + j + `]">
                                </td>
                            </tr>`;
                        var kidneyCompileFn = $compile(kidneyTemplate);
                        var kidneyDom = kidneyCompileFn($scope);
                        kidneyDom.appendTo('#kidney');
                        $('#kidneyDatepicker' + j).datepicker({
                            autoclose: close
                        });
                        $scope.scrObj[j] = data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[j].scr;
                        $scope.ureaNitrogenObj[j] = data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[j].ureaNitrogen;
                        if (data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[j].tab2CheckDate) {
                            $scope.tab2CheckDateObj[j] = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationKidneyDTOS[j].tab2CheckDate));
                        }
                    }

                    //绑定血糖检查数据
                    if (data.medicineLiverHospitalAbnormalExaminationBsDTOS.length == 0 || data.medicineLiverHospitalAbnormalExaminationBsDTOS.length == 1) {
                        bsCount = 0;
                    } else {
                        bsCount = data.medicineLiverHospitalAbnormalExaminationBsDTOS.length - 1;
                    }
                    if (data.medicineLiverHospitalAbnormalExaminationBsDTOS.length != 0) {
                        $scope.plasmaGlucose = data.medicineLiverHospitalAbnormalExaminationBsDTOS[0].plasmaGlucose;
                        if (data.medicineLiverHospitalAbnormalExaminationBsDTOS[0].tab3CheckDate) {
                            $scope.tab3CheckDate = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationBsDTOS[0].tab3CheckDate));
                        }
                    }
                    for (var k = 1; k < data.medicineLiverHospitalAbnormalExaminationBsDTOS.length; k++) {
                        var bsTemplate = `<tr>
                                <td height="38px" style=" text-align: -webkit-center;">
                                    <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="bsDatepicker` + k + `" ng-model="tab3CheckDateObj[` + k + `]">
                                </td>
                                <td height="38px" style=" text-align: -webkit-center; ">
                                    <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="plasmaGlucoseObj[` + k + `]">
                                </td>
                            </tr>`;
                        var bsCompileFn = $compile(bsTemplate);
                        var bsDom = bsCompileFn($scope);
                        bsDom.appendTo('#bs');
                        $('#bsDatepicker' + k).datepicker({
                            autoclose: true
                        });
                        $scope.plasmaGlucoseObj[k] = data.medicineLiverHospitalAbnormalExaminationBsDTOS[k].plasmaGlucose;
                        if (data.medicineLiverHospitalAbnormalExaminationBsDTOS[k].tab3CheckDate) {
                            $scope.tab3CheckDateObj[k] = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationBsDTOS[k].tab3CheckDate));
                        }
                    }

                    //绑定凝血功能检查数据
                    if (data.medicineLiverHospitalAbnormalExaminationCruorDTOS.length == 0 || data.medicineLiverHospitalAbnormalExaminationCruorDTOS.length == 1) {
                        cruorCount = 0;
                    } else {
                        cruorCount = data.medicineLiverHospitalAbnormalExaminationCruorDTOS.length - 1;
                    }
                    if (data.medicineLiverHospitalAbnormalExaminationCruorDTOS.length != 0) {
                        $scope.pt = data.medicineLiverHospitalAbnormalExaminationCruorDTOS[0].pt;
                        $scope.inr = data.medicineLiverHospitalAbnormalExaminationCruorDTOS[0].inr;
                        if (data.medicineLiverHospitalAbnormalExaminationCruorDTOS[0].tab4CheckDate) {
                            $scope.tab4CheckDate = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationCruorDTOS[0].tab4CheckDate));
                        }
                    }
                    for (var m = 1; m < data.medicineLiverHospitalAbnormalExaminationCruorDTOS.length; m++) {
                        var cruorTemplate = `<tr>
                            <td height="38px" style=" text-align: -webkit-center;">
                                <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="cruorDatepicker` + m + `" ng-model="tab4CheckDateObj[` + m + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="ptObj[` + m + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="inrObj[` + m + `]">
                            </td>
                        </tr>`;
                        var cruorCompileFn = $compile(cruorTemplate);
                        var cruorDom = cruorCompileFn($scope);
                        cruorDom.appendTo('#cruor');
                        $('#cruorDatepicker' + m).datepicker({
                            autoclose: true
                        });
                        $scope.ptObj[m] = data.medicineLiverHospitalAbnormalExaminationCruorDTOS[m].pt;
                        $scope.inrObj[m] = data.medicineLiverHospitalAbnormalExaminationCruorDTOS[m].inr;
                        if (data.medicineLiverHospitalAbnormalExaminationCruorDTOS[m].tab4CheckDate) {
                            $scope.tab4CheckDateObj[m] = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationCruorDTOS[m].tab4CheckDate));
                        }
                    }

                    //绑定肿瘤标记物检查数据
                    if (data.medicineLiverHospitalAbnormalExaminationTumourDTOS.length == 0 || data.medicineLiverHospitalAbnormalExaminationTumourDTOS.length == 1) {
                        tumourCount = 0;
                    } else {
                        tumourCount = data.medicineLiverHospitalAbnormalExaminationTumourDTOS.length - 1;
                    }
                    if (data.medicineLiverHospitalAbnormalExaminationTumourDTOS.length != 0) {
                        $scope.afp = data.medicineLiverHospitalAbnormalExaminationTumourDTOS[0].afp;
                        if (data.medicineLiverHospitalAbnormalExaminationTumourDTOS[0].tab5CheckDate) {
                            $scope.tab5CheckDate = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationTumourDTOS[0].tab5CheckDate));
                        }
                    }
                    for (var n = 1; n < data.medicineLiverHospitalAbnormalExaminationTumourDTOS.length; n++) {
                        var tumourTemplate = `<tr>
                            <td height="38px" style=" text-align: -webkit-center;">
                                <input type="text" class="form-control pull-right" style="height: 30px;text-align: -webkit-center;" id="tumourDatepicker` + n + `" ng-model="tab5CheckDateObj[` + n + `]">
                            </td>
                            <td height="38px" style=" text-align: -webkit-center; ">
                                <input type="text" style="text-align: -webkit-center;width: 100%;" ng-model="afpObj[` + n + `]">
                            </td>
                        </tr>`;
                        var tumourCompileFn = $compile(tumourTemplate);
                        var tumourDom = tumourCompileFn($scope);
                        tumourDom.appendTo('#tumour');
                        $('tumourDatepicker' + n).datepicker({
                            autoclose: true
                        });
                        $scope.afpObj[n] = data.medicineLiverHospitalAbnormalExaminationTumourDTOS[n].afp;
                        if (data.medicineLiverHospitalAbnormalExaminationTumourDTOS[n].tab5CheckDate) {
                            $scope.tab5CheckDateObj[n] = showDate(new Date(data.medicineLiverHospitalAbnormalExaminationTumourDTOS[n].tab5CheckDate));
                        }
                    }
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

        $scope.layout = function() {
            $state.go('mlHome');
        };

        function showDate(date) {
            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
        }

    }]);