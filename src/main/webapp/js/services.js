"use strict";

var services = angular.module("iwb.services", ["ngResource"]);
services.value("version", "0.1");

services.factory("ProductsResource", function ($resource) {
    return $resource("services/products/search?q=:query", {}, {
        search: {method: "GET"}
    });
});
