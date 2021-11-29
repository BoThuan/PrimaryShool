var API_Students = "http://localhost:8081/api/vi/Students";

var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
  $routeProvider
    // giao vien
    .when("/thongtin", {
      templateUrl: "./assets/views/phuhuynh/thongtin.html",
    })
    .when("/diem", {
      templateUrl: "./assets/views/phuhuynh/diem.html",
    });
});

app.controller("try-Ctrl", function ($scope, $http) {
  var cookies = document.cookie
    .split(";")
    .map((cookie) => cookie.split("="))
    .reduce(
      (accumulator, [key, value]) => ({
        ...accumulator,
        [key.trim()]: decodeURIComponent(value),
      }),
      {}
    );
    $scope.sdt = cookies.sdtphuhuynh;
    $scope.mahs = cookies.mahs;
    console.log($scope.mahs)
    $scope.loading = function () {
        $http.get(`${API_Students}/mahs=${$scope.mahs}`).then((resp) => {
            $scope.students = resp.data;
            console.log($scope.students.data)
        });
    };
    $scope.loading();
});
