var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/xemdiem", {
            templateUrl: "./assets/views/phuhuynh/xemdiem.html",
            controller: "results-ctrl",
        })
        .when("/guiphanhoi", {
            templateUrl: "./assets/views/phuhuynh/guiphanhoi.html",
        });
});

