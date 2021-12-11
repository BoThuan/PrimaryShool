var app = angular.module("myApp", ["ngRoute"]);
app.run(function ($http, $rootScope, $timeout) {
    $rootScope.maGiaoVien = getCookie("maGiaoVien");
    $rootScope.TenGiaoVien = getCookie("TenGiaoVien");
    $rootScope.emailGiaoVien = getCookie("emailGiaoVien");
    $rootScope.sdtGiaoVien = getCookie("sdtGiaoVien");
  });

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
        ;
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