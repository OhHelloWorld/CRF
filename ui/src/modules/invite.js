import angular from 'angular';

angular.module('invite', [])
  .controller('inviteController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    if (sessionStorage.getItem('permission').indexOf('邀请联合发起人') === -1) {
      $('#co-sponsor').addClass('hide');
    }
    if (sessionStorage.getItem('permission').indexOf('邀请DM（数据管理员）') === -1) {
      $('#data-manager').addClass('hide');
    }
    if (sessionStorage.getItem('permission').indexOf('邀请分中心研究者') === -1) {
      $('sub-center-researcher').addClass('hide');
    }
    if (sessionStorage.getItem('permission').indexOf('邀请CRA（临床监查员）') === -1) {
      $('#clinical-examiner').addClass('hide');
    }
    if (sessionStorage.getItem('permission').indexOf('邀请录入员') === -1) {
      $('#reporter').addClass('hide');
    }
    if (sessionStorage.getItem('permission').indexOf('踢出人员') === -1) {
      $('#kicked-out').addClass('hide');
    }
  }]);