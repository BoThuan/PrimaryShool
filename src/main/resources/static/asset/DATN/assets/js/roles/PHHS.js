var API_Students = "http://localhost:8081/api/vi/Students";
var API_Approve = "http://localhost:8081/api/vi/Approve";
var API_Results = "http://localhost:8081/api/vi/Results";
var API_License = 'http://localhost:8081/api/vi/License';

//http://localhost:8081/api/vi/Students/SDTphuhuynh/0321654987

var app = angular.module("myApp", ["ngRoute"]);

// app.run(function ($http, $rootScope, $timeout) {
//   $rootScope.TenHocSinh = getCookie("Tenhocsinh");
//   $rootScope.sdtPhuhuynh = getCookie("sdtphuhuynh");

//   var cookies = document.cookie.split(";");
//   if ($rootScope.TenHocSinh == "" || cookies.length < 2) {
//     window.location = "./Login_phuhuynh.html";
//   }
// });
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
    })
    .when("/thoikhoabieu", {
      templateUrl: "./assets/views/phuhuynh/thoikhoabieu.html",
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

  $scope.License = [];
  $scope.students = [];
  let DiemTB = [];
  $scope.info_students = [];
  $scope.results = [];
  var mahs = "";
  $scope.form = {};
  $scope.sdt = cookies.sdtphuhuynh;
  //$scope.mahs = cookies.mahs;
  //console.log($scope.mahs);

  $scope.loading = function () {
    // lấy sdt phụ huynh từ cookie
    $scope.sdt = cookies.sdtphuhuynh;
    $http.get(`${API_Students}/SDTphuhuynh/${$scope.sdt}`).then((resp) => {
      $scope.students = resp.data;
      mahs = $scope.students.data.maHS;
      $scope.tenPH = $scope.students.data.parents.tenPH
      $scope.maPH = $scope.students.data.parents.maPH
      console.log($scope.students.data.parents.maPH);
      $scope.form = {tennguoigui: $scope.maPH ,ngaygui: date, duyet: false};
    });
  };

  $scope.form = function () {

  };
  $scope.autoloading = function () {
    if ($scope.sdt) {
      $scope.loading();
      $http
        .get(`http://localhost:8081/api/vi/Results/mahs/HS0001`)
        .then((resp) => {
          $scope.results = resp.data;
          $scope.info_students = $scope.results[0];
          console.log($scope.results.length);
          for (let i = 0; i < $scope.results.length; i++) {
            diem =
              ($scope.results[i].diemKT +
                ($scope.results[i].diemGiuak1 + $scope.results[i].diemCuoik1) /
                  2 +
                ($scope.results[i].diemGiuak2 + $scope.results[i].diemCuoik2) /
                  2) /
              3;
            DiemTB.push(diem);
          }
          $scope.DiemTBHS = (DiemTB[0]+DiemTB[1]+DiemTB[2])/3
          
        });
    } else {
      // window.location = "./Login_phuhuynh.html";
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
    var License = angular.copy($scope.form);
    console.log(License);
    if (Object.keys(License).length != 0) {
      $http
        .post(`${API_License}/1`, License)
        .then((resp) => {
          $scope.License.push(resp.data);
          $scope.loading();
          $scope.form = {tennguoigui: time ,};
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

var today = new Date();
var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
var date = today.getFullYear()+'-'+today.getDate()+'-'+(today.getMonth()+1);
