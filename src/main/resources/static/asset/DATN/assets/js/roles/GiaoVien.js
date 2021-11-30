var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        // giao vien
        .when("/thongbao", {
            templateUrl: "./assets/views/GiaoVien/Thongbao.html",
        })
        .when("/HS", {
            templateUrl: "./assets/views/GiaoVien/hocsinh.html",
            controller: "Student-ctrl",
        })
        .when("/GVDiem", {
            templateUrl: "./assets/views/GiaoVien/GVDiem.html",
        })
        .when("/CGL", {
            templateUrl: "./assets/views/GiaoVien/CGL.html",
        })
        .when("/GVCN", {
            templateUrl: "./assets/views/GiaoVien/GVCN.html",
        })
        .when("/GVien_phanhoi", {
            templateUrl: "./assets/views/GiaoVien/GVien_phanhoi.html",
        })
        .when("/PH", {
            templateUrl: "./PHHS.html",
        });
});
