'use strict';

/* Controllers */

/* Home fragment */
SearchController.$inject = ["$scope", "$location"];
function SearchController($scope, $location) {
    $scope.popular = ["tissu", "pringles", "coca cola"];

    $scope.query = "";

    $scope.search = function () {
        $location.path('/products/search').search({q: $scope.query});
    }
}

/* Products list fragment */
ProductsController.$inject = ["$scope", "$route", "$location"];
function ProductsController($scope, $route, $location) {
    $scope.query = $route.current.params.q;
    $scope.totalKnownProducts = 38000 + Math.floor(Math.random() * 1000);
    $scope.products = [
        {"id": 10000001,
            "ean13": "",
            "name": "delichoc",
            "description": "voici le delichoc package !!! yip yop",
            "image": "delichoc.png",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000002,
            "ean13": "",
            "name": "delichoc2",
            "description": "voic2i le delichoc package !!! yip yop",
            "image": "d2elichoc.png",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000003,
            "ean13": "",
            "name": "delich3oc",
            "description": "voici33 le delichoc package !!! yip yop",
            "image": "delichoc.png",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000004,
            "ean13": "",
            "name": "delichoc4",
            "description": "voici le delichoc package !!!444 yip yop",
            "image": "delichoc.png",
            "tags": ["food", "buiscuit", "chocolat"]
        }
    ];

}

/* Product fragment */
ProductController.$inject = ["$scope", "$filter"];
function ProductController($scope, $filter) {
    $scope.strippedComponents = function () {
        console.log("inthat");
        var stripped = [];
        for (var i = 0; i < $scope.product.components.length; i++) {
            if (i % 3 == 0) {
                stripped.push([]);
            }
            stripped[stripped.length - 1].push($scope.product.components[i]);
        }
    }

    $scope.product = {id: 10000001,
        ean13: "",
        name: "product",
        description: "voici le delichoc package !!! yip yop",
        image: "delichoc.png",
        tags: ["food", "buiscuit", "chocolat"],
        components: [
            {
                name: "emballage carton",
                material: "cardboard",
                image: null,
                secondlife: {
                    recyclable: true,
                    bincolor: "yellow",
                    findlocation: ""
                }
            },
            {
                name: "film plastique transparent",
                material: "transparent-food-ready-plastic",
                image: null,
                secondlife: {
                    recyclable: false,
                    bincolor: "green",
                    findlocation: ""
                }
            }                ,
            {
                name: "barquette",
                material: "opaque-food-ready-plastic",
                image: null,
                secondlife: {
                    recyclable: false,
                    bincolor: "green",
                    findlocation: ""
                }
            },
            {
                name: "biscuit",
                material: "food",
                image: null,
                secondlife: {
                    recyclable: false,
                    bincolor: "black",
                    findlocation: ""
                }
            }
        ]
    };
    $scope.components = $filter("packageBy")($scope.product.components, 3);
}
