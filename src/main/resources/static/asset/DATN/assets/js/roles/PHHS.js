var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        // giao vien
        .when("/thongtin", {
            templateUrl: "./assets/views/phuhuynh/thongtin.html",
        })
        .when("/diem", {
            templateUrl: "./assets/views/phuhuynh/diem.html",
        })
        .when("/pheduyet", {
            templateUrl: "./assets/views/phuhuynh/guiphanhoi.html",
        })
        ;
});
