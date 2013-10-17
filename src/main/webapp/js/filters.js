'use strict';

/* Filters */

application.filter("packageBy", function () {
    return function (input, size) {
        if (!Array.isArray(input)) {
            // ignore silently
            return input;
        }
        var result = [];
        for (var i = 0; i < input.length; i++) {
            if (i % size == 0) {
                result.push([]);
            }
            result[result.length - 1].push(input[i]);
        }
        return result;
    };
});