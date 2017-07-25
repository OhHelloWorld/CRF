import angular from 'angular';


angular.module('createProject', [])
  .controller('createProjectController', ['$scope', '$http', function($scope, $http){
    
  	$scope.addActive = function(str) {
  		$('#basicData').removeClass('active');
  		$('#collectData').removeClass('active');
  		if(str === 'basicData') {
  		$('#basicData').addClass('active');
  		}
  		if(str === 'collectData') {
  		$('#collectData').addClass('active');
  		}
  	}



  }]);
