var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        // giao vien
        .when("/thongbao", {
            templateUrl: "./assets/views/GiaoVien/Thongbao.html",
        })
        .when("/HS", {
            templateUrl: "./assets/views/GiaoVien/HS.html",
            controller: "student-ctrl",
        })
        .when("/diemDanh", {
            templateUrl: "./assets/views/GiaoVien/DiemDanh.html",
        })
        .when("/GVDiem", {
            templateUrl: "./assets/views/GiaoVien/GVDiem.html",
        })
        .when("/CGL", {
            templateUrl: "./assets/views/GiaoVien/CGL.html",
        })
        .when("/GVCN", {
            templateUrl: "./assets/views/GiaoVien/GVCN.html",
        });
});

