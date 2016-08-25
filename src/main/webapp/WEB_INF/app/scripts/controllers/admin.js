'use strict';

/**
 * @ngdoc function
 * @name organiserApp.controller:AdminCtrl
 * @description
 * # AdminCtrl
 * Controller of the organiserApp
 */
angular.module('organiserApp')
  .controller('AdminCtrl', function () {
    var AdminCtrl = this;
    this.events = [
      {
        name: 'Event 1',
        yes: 5,
        maybe: 6,
        no: 5,
        required: 12
      },
      {
        name: 'Event 2',
        yes: 10,
        maybe: 3,
        no: 1,
        required: 12
      },
      {
        name: 'Event 3',
        yes: 12,
        maybe: 1,
        no: 2,
        required: 12
      },
      {
        name: 'Event 4',
        yes: 1,
        maybe: 2,
        no: 6,
        required: 8
      }
    ];
  });
