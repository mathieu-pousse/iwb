"use strict";

// Declare app level module which depends on filters, and services
var application = angular.module("iwb", ["ngRoute"]);

application.config(["$routeProvider", function($routeProvider) {
    $routeProvider.when("/home", {templateUrl: "fragments/home.html", controller: SearchController});
    $routeProvider.when("/products/search", {templateUrl: "fragments/products.html", controller: ProductsController});
    $routeProvider.when("/products/id/:id", {templateUrl: "fragments/product.html", controller: ProductController});
    $routeProvider.otherwise({redirectTo : "/home"});
  }]);
