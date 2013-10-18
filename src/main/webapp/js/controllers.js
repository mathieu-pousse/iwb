'use strict';

/* Controllers */

/* Home fragment */
SearchController.$inject = ["$scope", "$location"];
function SearchController($scope, $location) {
    $scope.popular = ["tissu", "pringles", "coca cola"];

    $scope.query = "";

    $scope.suggestions = ["dechet", "delichoc", "delichoc coco", "delichoc lait", "delichoc noir", "delichoc speculos", ];

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
            "name": "Délichoc - Chocolat au lait",
            "description": "Chocolat au lait",
            "image": "resources/images/delichoc-blue.jpg",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000002,
            "ean13": "",
            "name": "Délichoc - Chocolat noir",
            "description": "Chocolat noir",
            "image": "resources/images/delichoc-red.jpg",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000003,
            "ean13": "",
            "name": "Délichoc - Spéculos",
            "description": "Au spéculos !!!",
            "image": "resources/images/delichoc-speculos.jpg",
            "tags": ["food", "buiscuit", "chocolat"]
        },
        {"id": 10000004,
            "ean13": "",
            "name": "Délichoc - Coconut party",
            "description": "A la noix de coco",
            "image": "resources/images/delichoc-coco.jpg",
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
        name: "Délichoc - Chocolat au lait",
        description: "Chocolat au lait",
        image: "resources/images/delichoc-blue.jpg",
        tags: ["food", "buiscuit", "chocolat"],
        components: [
            {
                name: "emballage carton",
                material: "cardboard",
                image: "resources/images/slim-cardboard.jpg",
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
                image: "resources/images/opaque-food-ready-plastic.jpg",
                secondlife: {
                    recyclable: false,
                    bincolor: "green",
                    findlocation: ""
                }
            },
            {
                name: "biscuit",
                material: "food",
                image: "resources/images/delichoc.jpg",
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
