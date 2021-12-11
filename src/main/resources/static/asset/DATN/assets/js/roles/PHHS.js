var API_Students = "http://localhost:8081/api/vi/Students";
var API_Approve = "http://localhost:8081/api/vi/Approve";

//http://localhost:8081/api/vi/Students/SDTphuhuynh/0321654987

var app = angular.module("myApp", ["ngRoute"]);

app.run(function ($http, $rootScope, $timeout) {
  $rootScope.TenHocSinh = getCookie("Tenhocsinh");
  $rootScope.sdtPhuhuynh = getCookie("sdtphuhuynh");

  var cookies = document.cookie.split(";");
  if ($rootScope.TenHocSinh == "" || cookies.length < 2) {
    window.location = "./Login_phuhuynh.html";
  }
});
app.config(function ($routeProvider) {
  $routeProvider
    // giao vien
    .when("/", {
      templateUrl: "./assets/views/phuhuynh/thongtin.html",
    })
    .when("/diem", {
      templateUrl: "./assets/views/phuhuynh/diem.html",
    })
    .when("/pheduyet", {
      templateUrl: "./assets/views/phuhuynh/guiphanhoi.html",
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

  $scope.Approves = [];
  $scope.form = {};
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
      window.location = "./Login_phuhuynh.html";
    }
  };
  $scope.logout = function () {
    if ($scope.sdt) {
      window.localStorage.clear();
      document.cookie = `sdtphuhuynh=`;
      window.location = "./Login_phuhuynh.html";
    }
  };

  $scope.guiphanhoi = function () {
    var Approve = angular.copy($scope.form);
    console.log(Object.keys(Approve).length);
    if (Object.keys(Approve).length != 0) {
      $http
        .post(`${API_Approve}/insert`, Approve)
        .then((resp) => {
          $scope.Approves.push(resp.data);
          $scope.loading();
          $scope.form = {};
          alert("Gửi thành công");
        })
        .catch((error) => {
          alert("Lỗi");
          console.log("Error", error);
        });
    } else {
      alert("Khong co dữ liệu");
    }
  };

  // khu vục chạy hàm
  setInterval($scope.autoloading(), 300);
});

const getCookie = (cookie_name) => {
  // Construct a RegExp object as to include the variable name
  const re = new RegExp(`(?<=${cookie_name}=)[^;]*`);
  try {
    return document.cookie.match(re)[0]; // Will raise TypeError if cookie is not found
  } catch {
    return "No Data";
  }
};
