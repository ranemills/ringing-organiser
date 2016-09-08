'use strict';

/**
 * @ngdoc function
 * @name organiserApp.controller:AdminCtrl
 * @description
 * # AdminCtrl
 * Controller of the organiserApp
 */
angular.module('organiserApp')
  .controller('AdminCtrl', function (MockEvents) {
    var AdminCtrl = this;
    this.events = MockEvents;

    this.eventDates = [
      "2016-09-11",
      "2016-09-12",
      "2016-09-13",
      "2016-09-14"
    ];

    this.eventLocations  = [
      "Magdalen",
      "Christ Church",
      "Merton"
    ];

  });
