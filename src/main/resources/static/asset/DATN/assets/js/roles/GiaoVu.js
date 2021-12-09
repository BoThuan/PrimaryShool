var app = angular.module("myApp", ["ngRoute"]);
app.run(function ($http, $rootScope, $timeout) {
  $rootScope.maGiaoVu = getCookie("maGiaoVu");
  $rootScope.TenGiaoVu = getCookie("TenGiaoVu");
  $rootScope.emailGiaoVu = getCookie("emailGiaoVu");
  $rootScope.sdtGiaoVu = getCookie("sdtGiaoVu");
});

app.config(function ($routeProvider) {
  $routeProvider
    // giao vu
    .when("/", {
      templateUrl: "./assets/views/GiaoVu/thongke.html",
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
  deleteAllCookies();
  window.location = "./login_nhansu.html";
}

function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}
