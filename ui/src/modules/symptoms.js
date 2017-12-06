import angular from 'angular';

angular.module('symptoms', [])
  .controller('symptomsController', ['$scope', '$http', '$state', 'localStorageService', '$compile', function($scope, $http, $state, localStorageService, $compile) {
    getMlPatient();

    var mlSymptoms = {};
    $scope.nameObj = {};
    $scope.descriptionObj = {};
    $scope.beginDateObj = {};
    $scope.disappearDateObj = {};
    $scope.dischargeSymptomsObj = {};
    $scope.medicineLiverSymptomsOtherDTOs = [];
    for (var i = 1; i <= 30; i++) {
      $('#datepicker' + i).datepicker({
        autoclose: true
      });
    }

    $('#beginDate').datepicker({
      autoclose: true
    });

    $('#disappearDate').datepicker({
      autoclose: true
    });

    var count = 0;

    $scope.addSymptoms = function() {
      count += 1;
      var template = '<tr><td><input type="text" ng-model="nameObj[' + count + ']" class="form-control" placeholder="其他体征名"></td><td><input type="text" ng-model="descriptionObj[' + count + ']" class="form-control" placeholder="描述"></td><td><input class="form-control" id="beginDate' + count + '" ng-model="beginDateObj[' + count + ']" placeholder="开始时间"></td><td><input class="form-control" id="disappearDate' + count + '" ng-model="disappearDateObj[' + count + ']" placeholder="结束时间"></td><td><input type="text" ng-model="dischargeSymptomsObj[' + count + ']" class="form-control" placeholder="出院时表现"></td></tr>';
      var compileFn = $compile(template);
      var dom = compileFn($scope);
      dom.appendTo('.table');
      $('#beginDate' + count).datepicker({
        autoclose: true
      });
      $('#disappearDate' + count).datepicker({
        autoclose: true
      });
    };

    if (sessionStorage.getItem('mlPatientId')) {
      $http({
        method: 'GET',
        url: '/api/mlSymptoms/' + sessionStorage.getItem('mlPatientId')
      }).then(function success(response) {
        var data = response.data;

        $scope.liverInjury = data.liverInjury;
        $scope.weak = data.weak;
        $scope.weakBeginDate = showDate(data.weakBeginDate);
        $scope.weakDisappearDate = showDate(data.weakDisappearDate);
        $scope.weakDischarge = data.weakDischarge;
        $scope.anorexia = data.anorexia;
        $scope.anorexiaBeginDate = showDate(data.anorexiaBeginDate);
        $scope.anorexiaDisappearDate = showDate(data.anorexiaDisappearDate);
        $scope.anorexiaDischarge = data.anorexiaDischarge;
        $scope.abdominalDistention = data.abdominalDistention;
        $scope.abdominalDistentionBeginDate = showDate(data.abdominalDistentionBeginDate);
        $scope.abdominalDistentionDisappearDate = showDate(data.abdominalDistentionDisappearDate);
        $scope.abdominalDistentionDischarge = data.abdominalDistentionDischarge;
        $scope.jaundice = data.jaundice;
        $scope.jaundiceBeginDate = showDate(data.jaundiceBeginDate);
        $scope.jaundiceDisappearDate = showDate(data.jaundiceDisappearDate);
        $scope.jaundiceDischarge = data.jaundiceDischarge;
        $scope.nausea = data.nausea;
        $scope.nauseaBeginDate = showDate(data.nauseaBeginDate);
        $scope.nauseaDisappearDate = showDate(data.nauseaDisappearDate);
        $scope.nauseaDischarge = data.nauseaDischarge;
        $scope.vomit = data.vomit;
        $scope.vomitBeginDate = showDate(data.vomitBeginDate);
        $scope.vomitDisappearDate = showDate(data.vomitDisappearDate);
        $scope.vomitDischarge = data.vomitDischarge;
        $scope.gingivalBleeding = data.gingivalBleeding;
        $scope.gingivalBleedingBeginDate = showDate(data.gingivalBleedingBeginDate);
        $scope.gingivalBleedingDisappearDate = showDate(data.gingivalBleedingDisappearDate);
        $scope.gingivalBleedingDischarge = data.gingivalBleedingDischarge;
        $scope.epistaxis = data.epistaxis;
        $scope.epistaxisBeginDate = showDate(data.epistaxisBeginDate);
        $scope.epistaxisDisappearDate = showDate(data.epistaxisDisappearDate);
        $scope.epistaxisDischarge = data.epistaxisDischarge;
        $scope.liverPain = data.liverPain;
        $scope.liverPainBeginDate = showDate(data.liverPainBeginDate);
        $scope.liverPainDisappearDate = showDate(data.liverPainDisappearDate);
        $scope.liverPainDischarge = data.liverPainDischarge;
        $scope.hepatomegaly = data.hepatomegaly;
        $scope.hepatomegalyBeginDate = showDate(data.hepatomegalyBeginDate);
        $scope.hepatomegalyDisappearDate = showDate(data.hepatomegalyDisappearDate);
        $scope.hepatomegalyDischarge = data.hepatomegalyDischarge;
        $scope.splenomegaly = data.splenomegaly;
        $scope.splenomegalyBeginDate = showDate(data.splenomegalyBeginDate);
        $scope.splenomegalyDisappearDate = showDate(data.splenomegalyDisappearDate);
        $scope.splenomegalyDischarge = data.splenomegalyDischarge;
        $scope.fever = data.fever;
        $scope.feverBeginDate = showDate(data.feverBeginDate);
        $scope.feverDisappearDate = showDate(data.feverDisappearDate);
        $scope.feverDischarge = data.feverDischarge;
        $scope.rash = data.rash;
        $scope.rashBeginDate = showDate(data.rashBeginDate);
        $scope.rashDisappearDate = showDate(data.rashDisappearDate);
        $scope.rashDischarge = data.rashDischarge;
        $scope.arthralgia = data.arthralgia;
        $scope.arthralgiaBeginDate = showDate(data.arthralgiaBeginDate);
        $scope.arthralgiaDisappearDate = showDate(data.arthralgiaDisappearDate);
        $scope.arthralgiaDischarge = data.arthralgiaDischarge;
        $scope.skinItch = data.skinItch;
        $scope.skinItchBeginDate = showDate(data.skinItchBeginDate);
        $scope.skinItchDisappearDate = showDate(data.skinItchDisappearDate);
        $scope.skinItchDischarge = data.skinItchDischarge;
        $scope.complete = data.complete;

        if (data.medicineLiverSymptomsOtherDTOs.length != 0) {
          if (data.medicineLiverSymptomsOtherDTOs.length == 1) {
            count = 0;
          } else {
            count = data.medicineLiverSymptomsOtherDTOs.length - 1;
          }
          $scope.name = data.medicineLiverSymptomsOtherDTOs[0].name;
          $scope.description = data.medicineLiverSymptomsOtherDTOs[0].description;
          $scope.beginDate = showDate((data.medicineLiverSymptomsOtherDTOs[0]).beginDate);
          $scope.disappearDate = showDate((data.medicineLiverSymptomsOtherDTOs[0]).disappearDate);
          $scope.dischargeSymptoms = data.medicineLiverSymptomsOtherDTOs[0].dischargeSymptoms;
        } else {
          count = 0;
        }

        for (var i = 1; i < data.medicineLiverSymptomsOtherDTOs.length; i++) {
          var template = '<tr><td><input type="text" ng-model="nameObj[' + i + ']" class="form-control" placeholder="其他体征名"></td><td><input type="text" ng-model="descriptionObj[' + i + ']" class="form-control" placeholder="描述"></td><td><input class="form-control" id="beginDate' + i + '" ng-model="beginDateObj[' + i + ']" placeholder="开始时间"></td><td><input class="form-control" id="disappearDate' + i + '" ng-model="disappearDateObj[' + i + ']" placeholder="结束时间"></td><td><input type="text" ng-model="dischargeSymptomsObj[' + i + ']" class="form-control" placeholder="出院时表现"></td></tr>';
          var compileFn = $compile(template);
          var dom = compileFn($scope);
          dom.appendTo('.table');
          $('#beginDate' + count).datepicker({
            autoclose: true
          });
          $('#disappearDate' + count).datepicker({
            autoclose: true
          });
          $scope.nameObj[i] = data.medicineLiverSymptomsOtherDTOs[i].name;
          $scope.descriptionObj[i] = data.medicineLiverSymptomsOtherDTOs[i].description;
          $scope.dischargeSymptomsObj[i] = data.medicineLiverSymptomsOtherDTOs[i].dischargeSymptoms;

          $scope.beginDateObj[i] = showDate((data.medicineLiverSymptomsOtherDTOs[i]).beginDate);
          $scope.disappearDateObj[i] = showDate((data.medicineLiverSymptomsOtherDTOs[i]).disappearDate);
        }
      });
    }

    $scope.save = function() {
      mlSymptoms.medicineLiverSymptomsOtherDTOs = [];
      mlSymptoms.patientId = sessionStorage.getItem('mlPatientId');
      mlSymptoms.liverInjury = $scope.liverInjury;
      mlSymptoms.weak = $scope.weak;
      mlSymptoms.weakBeginDate = new Date($scope.weakBeginDate);
      mlSymptoms.weakDisappearDate = new Date($scope.weakDisappearDate);
      mlSymptoms.weakDischarge = $scope.weakDischarge;
      mlSymptoms.anorexia = $scope.anorexia;
      mlSymptoms.anorexiaBeginDate = new Date($scope.anorexiaBeginDate);
      mlSymptoms.anorexiaDisappearDate = new Date($scope.anorexiaDisappearDate);
      mlSymptoms.anorexiaDischarge = $scope.anorexiaDischarge;
      mlSymptoms.abdominalDistention = $scope.abdominalDistention;
      mlSymptoms.abdominalDistentionBeginDate = new Date($scope.abdominalDistentionBeginDate);
      mlSymptoms.abdominalDistentionDisappearDate = new Date($scope.abdominalDistentionDisappearDate);
      mlSymptoms.abdominalDistentionDischarge = $scope.abdominalDistentionDischarge;
      mlSymptoms.jaundice = $scope.jaundice;
      mlSymptoms.jaundiceBeginDate = new Date($scope.jaundiceBeginDate);
      mlSymptoms.jaundiceDisappearDate = new Date($scope.jaundiceDisappearDate);
      mlSymptoms.jaundiceDischarge = $scope.jaundiceDischarge;
      mlSymptoms.nausea = $scope.nausea;
      mlSymptoms.nauseaBeginDate = new Date($scope.nauseaBeginDate);
      mlSymptoms.nauseaDisappearDate = new Date($scope.nauseaDisappearDate);
      mlSymptoms.nauseaDischarge = $scope.nauseaDischarge;
      mlSymptoms.vomit = $scope.vomit;
      mlSymptoms.vomitBeginDate = new Date($scope.vomitBeginDate);
      mlSymptoms.vomitDisappearDate = new Date($scope.vomitDisappearDate);
      mlSymptoms.vomitDischarge = $scope.vomitDischarge;
      mlSymptoms.gingivalBleeding = $scope.gingivalBleeding;
      mlSymptoms.gingivalBleedingBeginDate = new Date($scope.gingivalBleedingBeginDate);
      mlSymptoms.gingivalBleedingDisappearDate = new Date($scope.gingivalBleedingDisappearDate);
      mlSymptoms.gingivalBleedingDischarge = $scope.gingivalBleedingDischarge;
      mlSymptoms.epistaxis = $scope.epistaxis;
      mlSymptoms.epistaxisBeginDate = new Date($scope.epistaxisBeginDate);
      mlSymptoms.epistaxisDisappearDate = new Date($scope.epistaxisDisappearDate);
      mlSymptoms.epistaxisDischarge = $scope.epistaxisDischarge;
      mlSymptoms.liverPain = $scope.liverPain;
      mlSymptoms.liverPainBeginDate = new Date($scope.liverPainBeginDate);
      mlSymptoms.liverPainDisappearDate = new Date($scope.liverPainDisappearDate);
      mlSymptoms.liverPainDischarge = $scope.liverPainDischarge;
      mlSymptoms.hepatomegaly = $scope.hepatomegaly;
      mlSymptoms.hepatomegalyBeginDate = new Date($scope.hepatomegalyBeginDate);
      mlSymptoms.hepatomegalyDisappearDate = new Date($scope.hepatomegalyDisappearDate);
      mlSymptoms.hepatomegalyDischarge = $scope.hepatomegalyDischarge;
      mlSymptoms.splenomegaly = $scope.splenomegaly;
      mlSymptoms.splenomegalyBeginDate = new Date($scope.splenomegalyBeginDate);
      mlSymptoms.splenomegalyDisappearDate = new Date($scope.splenomegalyDisappearDate);
      mlSymptoms.splenomegalyDischarge = $scope.splenomegalyDischarge;
      mlSymptoms.fever = $scope.fever;
      mlSymptoms.feverBeginDate = new Date($scope.feverBeginDate);
      mlSymptoms.feverDisappearDate = new Date($scope.feverDisappearDate);
      mlSymptoms.feverDischarge = $scope.feverDischarge;
      mlSymptoms.rash = $scope.rash;
      mlSymptoms.rashBeginDate = new Date($scope.rashBeginDate);
      mlSymptoms.rashDisappearDate = new Date($scope.rashDisappearDate);
      mlSymptoms.rashDischarge = $scope.rashDischarge;
      mlSymptoms.arthralgia = $scope.arthralgia;
      mlSymptoms.arthralgiaBeginDate = new Date($scope.arthralgiaBeginDate);
      mlSymptoms.arthralgiaDisappearDate = new Date($scope.arthralgiaDisappearDate);
      mlSymptoms.arthralgiaDischarge = $scope.arthralgiaDischarge;
      mlSymptoms.skinItch = $scope.skinItch;
      mlSymptoms.skinItchBeginDate = new Date($scope.skinItchBeginDate);
      mlSymptoms.skinItchDisappearDate = new Date($scope.skinItchDisappearDate);
      mlSymptoms.skinItchDischarge = $scope.skinItchDischarge;
      mlSymptoms.complete = true;

      if ($scope.name != undefined) {
        mlSymptoms.medicineLiverSymptomsOtherDTOs.push({
          name: $scope.name,
          description: $scope.description,
          beginDate: new Date($scope.beginDate),
          disappearDate: new Date($scope.disappearDate),
          dischargeSymptoms: $scope.dischargeSymptoms
        });
      }
      for (var i = 1; i <= count; i++) {
        mlSymptoms.medicineLiverSymptomsOtherDTOs.push({
          // id: ($scope.detailIdObj[i + 1]),
          name: $scope.nameObj[i],
          description: $scope.descriptionObj[i],
          beginDate: new Date($scope.beginDateObj[i]),
          disappearDate: new Date($scope.disappearDateObj[i]),
          dischargeSymptoms: $scope.dischargeSymptomsObj[i]
        });
      }
      $http({
        method: 'POST',
        url: '/api/mlSymptoms',
        data: mlSymptoms
      }).then(function success() {
        $('#myModal').modal();
      });
    };

    function showDate(date) {
      if (date > 0) {
        var showDate = new Date(date);
        return showDate.getFullYear() + '-' + (showDate.getMonth() + 1) + '-' + showDate.getDate();
      }
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