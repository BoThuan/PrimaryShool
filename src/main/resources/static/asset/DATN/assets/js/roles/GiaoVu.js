var app = angular.module("myApp", ["ngRoute"]);
app.run(function ($http, $rootScope, $timeout) {
  $rootScope.maGiaoVu = getCookie("maGiaoVu");
  $rootScope.TenGiaoVu = getCookie("TenGiaoVu");
  $rootScope.emailGiaoVu = getCookie("emailGiaoVu");
  $rootScope.sdtGiaoVu = getCookie("sdtGiaoVu");

  var cookies = document.cookie.split(";");
  if ($rootScope.maGiaoVu == "" || cookies.length < 2) {
    window.location = "./login_nhansu.html";
  }
});

app.config(function ($routeProvider) {
  $routeProvider
    // giao vu
    .when("/", {
      templateUrl: "./assets/views/GiaoVu/thongke.html",
      controller: "thongke-ctrl",
    })
    .when("/QLGV", {
      templateUrl: "./assets/views/GiaoVu/QLGV.html",
      controller: "Teacher-Ctrl",
    })
    .when("/QLNS", {
      templateUrl: "./assets/views/GiaoVu/QLNS.html",
      controller: "Ministry-ctrl",
    })
    .when("/QLLop", {
      templateUrl: "./assets/views/GiaoVu/QLLop.html",
      controller: "Classroom-ctrl",
    })
    .when("/QLHS", {
      templateUrl: "./assets/views/GiaoVu/QLHS.html",
      controller: "Student-ctrl",
    })
    .when("/pheduyet", {
      templateUrl: "./assets/views/GiaoVu/pheduyet.html",
      controller: "Approve-ctrl",
    })
    .when("/baoCao", {
      templateUrl: "./assets/views/GiaoVu/baoCao.html",
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
  setCookie("maGiaoVu", "");
  setCookie("TenGiaoVu", "");
  setCookie("emailGiaoVu", "");
  setCookie("sdtGiaoVu", "");
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
