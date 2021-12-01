var app = angular.module("app", []);
      app.controller("app-Ctrl", function ($scope, $http) {
        $scope.radom = Math.floor(100000 + Math.random() * 900000);
        $scope.hocsinh = [];

        $scope.loading = function () {
          $http
            .get("http://localhost:8081/api/vi/Students/getAllStudents")
            .then(function (resp) {
              $scope.hocsinh = resp.data;
            });
        };

        $scope.loading();

        $scope.login = function () {
          var sdtphuHuynh = $scope.sdtphuHuynh;
          var pass = $scope.mkphuHuynh;
          var OPT = $scope.OTP;
          $scope.loading();

          $scope.hocsinh.forEach(function (hocsinh) {
            if (
              sdtphuHuynh == hocsinh.sdtphuHuynh &&
              pass == hocsinh.sdtphuHuynh && OPT == $scope.radom
            ) {
              localStorage.setItem("sdtphuhuynh", sdtphuHuynh);
              localStorage.getItem("sdtphuhuynh");
              document.cookie = `sdtphuhuynh=${sdtphuHuynh}`;
              window.location = "/src/main/resources/static/asset/DATN/PHHS.html";
              console.log("ok");
            } else {
              msg = "Sai Số điện thoại hoặc mật khẩu";
              console.log(msg);
            }
          });
        };
      });