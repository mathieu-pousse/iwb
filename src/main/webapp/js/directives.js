'use strict';

/* Directives */

application.directive('autoComplete', function($timeout) {
    return function(scope, iElement, iAttributes) {
        iElement.autocomplete({
            source: scope[iAttributes.uiItems],
            select: function() {
                $timeout(function() {
                    iElement.trigger('input');
                }, 0);
            }
        });
    };
});