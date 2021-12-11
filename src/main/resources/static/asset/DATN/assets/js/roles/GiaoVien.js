var app = angular.module("myApp", ["ngRoute"]);
app.run(function ($http, $rootScope, $timeout) {
  $rootScope.maGiaoVien = getCookie("maGiaoVien");
  $rootScope.TenGiaoVien = getCookie("TenGiaoVien");
  $rootScope.emailGiaoVien = getCookie("emailGiaoVien");
  $rootScope.sdtGiaoVien = getCookie("sdtGiaoVien");
  if ($rootScope.maGiaoVien == "") {
    window.location = "./login_nhansu.html";
  }
});

app.config(function ($routeProvider) {
  $routeProvider
    // giao vien
    .when("/", {
      templateUrl: "./assets/views/GiaoVien/Thongbao.html",
      controller: "Approve-ctrl",
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
    .when("/pheduyet", {
      templateUrl: "./assets/views/GiaoVu/pheduyet.html",
      controller: "Approve-ctrl",
    });
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

function logout() {
  window.localStorage.clear();
  setCookie("maGiaoVien", "");
  setCookie("TenGiaoVien", "");
  setCookie("emailGiaoVien", "");
  setCookie("sdtGiaoVien", "");
  window.location = "./login_nhansu.html";
}

function setCookie(name, value, days) {
  var expires = "";
  if (days) {
    var date = new Date();
    date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
    expires = "; expires=" + date.toUTCString();
  }
  document.cookie = name + "=" + (value || "") + expires + "; path=/";
}
