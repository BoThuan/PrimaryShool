var API_Students = "http://localhost:8081/api/vi/Students";
//http://localhost:8081/api/vi/Students/SDTphuhuynh/0321654987

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
  // biến lấy cookie theo cặp {name, value}
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
  //$scope.mahs = cookies.mahs;
  //console.log($scope.mahs);
  $scope.loading = function () {
    // lấy sdt phụ huynh từ cookie
    $scope.sdt = cookies.sdtphuhuynh;
    $http.get(`${API_Students}/SDTphuhuynh/${$scope.sdt}`).then((resp) => {
      $scope.students = resp.data;
      console.log($scope.students.data);
    });
  };
  $scope.autoloading = function () {
    if ($scope.sdt) {
      $scope.loading();
    } else {
      window.location = "./Login_phuHuynh.html";
    }
  };
  $scope.logout = function () {
    if ($scope.sdt) {
      window.localStorage.clear()
      document.cookie = `sdtphuhuynh=`;
      window.location = "./Login_phuHuynh.html";
      
  };}
  

  // khu vục chạy hàm
  setInterval($scope.autoloading(), 300);
});
