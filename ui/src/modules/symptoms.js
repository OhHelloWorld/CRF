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
      autoclose:true
    });

    $('#disappearDate').datepicker({
      autoclose:true
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
        count = data.medicineLiverSymptomsOtherDTOs.length - 1;

        $scope.liverInjury = data.liverInjury;
        $scope.weak = data.weak;
        $scope.weakDischarge = data.weakDischarge;
        $scope.anorexia = data.anorexia;
        $scope.anorexiaDischarge = data.anorexiaDischarge;
        $scope.abdominalDistention = data.abdominalDistention;
        $scope.abdominalDistentionBeginDate = showDate(new Date(data.abdominalDistentionBeginDate));
        $scope.abdominalDistentionDisappearDate = showDate(new Date(data.abdominalDistentionDisappearDate));
        $scope.abdominalDistentionDischarge = data.abdominalDistentionDischarge;
        $scope.jaundice = data.jaundice;
        $scope.jaundiceBeginDate = showDate(new Date(data.jaundiceBeginDate));
        $scope.jaundiceDisappearDate = showDate(new Date(data.jaundiceDisappearDate));
        $scope.jaundiceDischarge = data.jaundiceDischarge;
        $scope.nausea = data.nausea;
        $scope.nauseaBeginDate = showDate(new Date(data.nauseaBeginDate));
        $scope.nauseaDisappearDate = showDate(new Date(data.nauseaDisappearDate));
        $scope.nauseaDischarge = data.nauseaDischarge;
        $scope.weakBeginDate = showDate(new Date(data.weakBeginDate));
        $scope.weakDisappearDate = showDate(new Date(data.weakDisappearDate));
        $scope.anorexiaBeginDate = showDate(new Date(data.anorexiaBeginDate));
        $scope.anorexiaDisappearDate = showDate(new Date(data.anorexiaDisappearDate));
        $scope.vomit = data.vomit;
        $scope.vomitBeginDate = showDate(new Date(data.vomitBeginDate));
        $scope.vomitDisappearDate = showDate(new Date(data.vomitDisappearDate));
        $scope.vomitDischarge = data.vomitDischarge;
        $scope.gingivalBleeding = data.gingivalBleeding;
        $scope.gingivalBleedingBeginDate = showDate(new Date(data.gingivalBleedingBeginDate));
        $scope.gingivalBleedingDisappearDate = showDate(new Date(data.gingivalBleedingDisappearDate));
        $scope.gingivalBleedingDischarge = data.gingivalBleedingDischarge;
        $scope.epistaxis = data.epistaxis;
        $scope.epistaxisBeginDate = showDate(new Date(data.epistaxisBeginDate));
        $scope.epistaxisDisappearDate = showDate(new Date(data.epistaxisDisappearDate));
        $scope.epistaxisDischarge = data.epistaxisDischarge;
        $scope.liverPain = data.liverPain;
        $scope.liverPainBeginDate = showDate(new Date(data.liverPainBeginDate));
        $scope.liverPainDisappearDate = showDate(new Date(data.liverPainDisappearDate));
        $scope.liverPainDischarge = data.liverPainDischarge;
        $scope.hepatomegaly = data.hepatomegaly;
        $scope.hepatomegalyBeginDate = showDate(new Date(data.hepatomegalyBeginDate));
        $scope.hepatomegalyDisappearDate = showDate(new Date(data.hepatomegalyDisappearDate));
        $scope.hepatomegalyDischarge = data.hepatomegalyDischarge;
        $scope.splenomegaly = data.splenomegaly;
        $scope.splenomegalyBeginDate = showDate(new Date(data.splenomegalyBeginDate));
        $scope.splenomegalyDisappearDate = showDate(new Date(data.splenomegalyDisappearDate));
        $scope.splenomegalyDischarge = data.splenomegalyDischarge;
        $scope.fever = data.fever;
        $scope.feverBeginDate = showDate(new Date(data.feverBeginDate));
        $scope.feverDisappearDate = showDate(new Date(data.feverDisappearDate));
        $scope.feverDischarge = data.feverDischarge;
        $scope.rash = data.rash;
        $scope.rashBeginDate = showDate(new Date(data.rashBeginDate));
        $scope.rashDisappearDate = showDate(new Date(data.rashDisappearDate));
        $scope.rashDischarge = data.rashDischarge;
        $scope.arthralgia = data.arthralgia;
        $scope.arthralgiaBeginDate = showDate(new Date(data.arthralgiaBeginDate));
        $scope.arthralgiaDisappearDate = showDate(new Date(data.arthralgiaDisappearDate));
        $scope.arthralgiaDischarge = data.arthralgiaDischarge;
        $scope.skinItch = data.skinItch;
        $scope.skinItchBeginDate = showDate(new Date(data.skinItchBeginDate));
        $scope.skinItchDisappearDate = showDate(new Date(data.skinItchDisappearDate));
        $scope.skinItchDischarge = data.skinItchDischarge;
        $scope.complete = data.complete;

        if (data.medicineLiverSymptomsOtherDTOs.length != 0) {
          $scope.name = data.medicineLiverSymptomsOtherDTOs[0].name;
          $scope.description = data.medicineLiverSymptomsOtherDTOs[0].description;
          $scope.beginDate = showDate(new Date((data.medicineLiverSymptomsOtherDTOs[0]).beginDate));
          $scope.disappearDate = showDate(new Date((data.medicineLiverSymptomsOtherDTOs[0]).disappearDate));
          $scope.dischargeSymptoms = data.medicineLiverSymptomsOtherDTOs[0].dischargeSymptoms;
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

          $scope.beginDateObj[i] = showDate(new Date((data.medicineLiverSymptomsOtherDTOs[i]).beginDate));
          $scope.disappearDateObj[i] = showDate(new Date((data.medicineLiverSymptomsOtherDTOs[i]).disappearDate));
        }
      });
    }

    $scope.save = function() {
      mlSymptoms.medicineLiverSymptomsOtherDTOs = [];
      mlSymptoms.patientId = sessionStorage.getItem('mlPatientId');
      mlSymptoms.liverInjury = $scope.liverInjury;
      mlSymptoms.weak = $scope.weak;
      mlSymptoms.weakDischarge = $scope.weakDischarge;
      mlSymptoms.anorexia = $scope.anorexia;
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
      mlSymptoms.weakBeginDate = new Date($scope.weakBeginDate);
      mlSymptoms.weakDisappearDate = new Date($scope.weakDisappearDate);
      mlSymptoms.anorexiaBeginDate = new Date($scope.anorexiaBeginDate);
      mlSymptoms.anorexiaDisappearDate = new Date($scope.anorexiaDisappearDate);
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

      mlSymptoms.medicineLiverSymptomsOtherDTOs.push({
        name: $scope.name,
        description: $scope.description,
        beginDate: new Date($scope.beginDate),
        disappearDate: new Date($scope.disappearDate),
        dischargeSymptoms: $scope.dischargeSymptoms
      });
      for (var i = 0; i < count; i++) {
        mlSymptoms.medicineLiverSymptomsOtherDTOs.push({
          // id: ($scope.detailIdObj[i + 1]),
          name: $scope.nameObj[i + 1],
          description: $scope.descriptionObj[i + 1],
          beginDate: new Date($scope.beginDateObj[i + 1]),
          disappearDate: new Date($scope.disappearDateObj[i + 1]),
          dischargeSymptoms: $scope.dischargeSymptomsObj[i + 1]
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
      return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
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