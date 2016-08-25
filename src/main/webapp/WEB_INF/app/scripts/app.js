'use strict';


angular.module('organiserApp', [
  'ngCookies',
  'ui.router',
  'angularMoment'
])
.config(function ($stateProvider, $urlRouterProvider) {
  //delete $httpProvider.defaults.headers.common['X-Requested-With'];
  $urlRouterProvider.otherwise('/user');
  $stateProvider
    .state('index', {
      url: '/',
      templateUrl: 'views/main.html',
      controller:'MainCtrl'
    })
    .state('user', {
      url: '/user',
      templateUrl: 'views/user.html',
      controller: 'UserCtrl',
      controllerAs: 'UserCtrl'
    })
    .state('admin', {
      url: '/admin',
      templateUrl: 'views/admin.html',
      controller:'AdminCtrl',
      controllerAs: 'AdminCtrl'
    })
    .state('account', {
      url: '/account',
      templateUrl: 'views/account.html',
      controller:'AccountCtrl'
    })
    .state('about', {
      url: '/about',
      templateUrl: 'views/about.html',
      controller:'AboutCtrl'
    })
});
