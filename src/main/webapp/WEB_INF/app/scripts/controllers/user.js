'use strict';

/**
 * @ngdoc function
 * @name organiserApp.controller:UserCtrl
 * @description
 * # UserCtrl
 * Controller of the organiserApp
 */
angular.module('organiserApp')
  .controller('UserCtrl', function () {
    var UserCtrl = this;
    UserCtrl.events = [
      {
        name: 'Event 1',
        date: moment().format('LL'),
        location: 'My House'
      },
      {
        name: 'Event 2',
        date: moment().add('5', 'days').format('LL'),
        location: 'His House'
      },
      {
        name: 'Event 3',
        date: moment().add('10', 'days').format('LL'),
        location: 'Their House'
      }
    ];
  });
