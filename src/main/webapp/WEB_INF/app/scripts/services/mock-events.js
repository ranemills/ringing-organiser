'use strict';

/**
 * @ngdoc service
 * @name organiserApp.MockData
 * @description
 * # MockData
 * Constant in the organiserApp.
 */
angular.module('organiserApp')
  .constant('MockEvents', [
    {
      name: 'Event 1',
      type: 'quarter',
      date: "2016-09-11",
      location: "Christ Church",
      yes: 5,
      maybe: 6,
      no: 5,
      required: 12,
      description: "Standard Sunday quarter"
    },
    {
      name: 'Event 2',
      type: 'peal',
      location: "Christ Church",
      yes: 10,
      maybe: 3,
      no: 1,
      required: 12
    },
    {
      name: 'Event 3',
      type: 'general',
      location: "Christ Church",
      yes: 12,
      maybe: 1,
      no: 2,
      required: 12
    },
    {
      name: 'Event 4',
      location: "Merton",
      type: 'peal',
      yes: 1,
      maybe: 2,
      no: 6,
      required: 8
    },
    {
      name: 'Event 4',
      location: "Magdalen",
      type: 'peal',
      yes: 1,
      maybe: 2,
      no: 6,
      required: 8
    }
  ]);
