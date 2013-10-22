"use strict";

var __SERVICE_BASE_URL = "/services/";

application.factory("LocationsResource", function ($resource) {
    var baseUrl = __SERVICE_BASE_URL + "locations/:locationId";
    return $resource(baseUrl, {}, {
        findAll: {method: "GET", params: {locationId: ""}, isArray: true},
        query: {method: "GET"},
        save: {method: "POST"},
        update: {method: "PUT", params: {locationId: "@id"}},
        remove: {method: "DELETE", params: {locationId: "@id"}},
        search: {method: "GET", params: {locationId: "search"}, isArray: true}
    });
});
