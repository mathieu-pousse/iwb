"use strict";

// Declare app level module which depends on filters, and services
var application = angular.module("iwb", ["ngRoute", "ngResource"]);

application.config(["$routeProvider", function($routeProvider) {
    $routeProvider.when("/home", {templateUrl: "fragments/home.html"});
    $routeProvider.when("/project", {templateUrl: "fragments/project.html"});
    $routeProvider.when("/statistics", {templateUrl: "fragments/statistics.html"});
    $routeProvider.when("/search", {templateUrl: "fragments/search.html", controller: SearchController});
    $routeProvider.when("/products/search", {templateUrl: "fragments/products.html", controller: ProductsController});
    $routeProvider.when("/products/id/:id", {templateUrl: "fragments/product.html", controller: ProductController});
    $routeProvider.otherwise({redirectTo : "/home"});
  }]);
