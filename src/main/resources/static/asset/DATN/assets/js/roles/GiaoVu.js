var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        // giao vien
        .when("/QLGV", {
            templateUrl: "./assets/views/GiaoVu/QLGV.html",
            controller: "GiaoVu-Ctrl",
        })
        .when("/QLNS", {
            templateUrl: "./assets/views/GiaoVu/QLNS.html",
        })
        .when("/QLLop", {
            templateUrl: "./assets/views/GiaoVu/QLLop.html",
        })
        .when("/QLHS", {
            templateUrl: "./assets/views/GiaoVu/QLHS.html",
        })
        .when("/pheduyet", {
            templateUrl: "./assets/views/GiaoVu/pheduyet.html",
        });
    // .when("/CGL", {
    //     templateUrl: "./assets/views/GiaoVien/CGL.html",
    // })
    // .when("/GVCN", {
    //     templateUrl: "./assets/views/GiaoVien/GVCN.html",
    // })
});
