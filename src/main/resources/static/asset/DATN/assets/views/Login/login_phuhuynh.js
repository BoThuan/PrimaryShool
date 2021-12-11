var app = angular.module("app", []);
      app.controller("app-Ctrl", function ($scope, $http) {
        $scope.radom = Math.floor(100000 + Math.random() * 900000);
        $scope.hocsinh = [];

        $scope.login = function () {
          //lấy dữ liệu
          var sdtphuHuynh = $scope.sdtphuHuynh;
          var sdt = $scope.mkphuHuynh;
          var OPT = $scope.OTP;
  
          //gọi dự liệu từ database
          $http
            .get(`http://localhost:8081/api/vi/Students/SDTphuhuynh/${sdtphuHuynh}`)
            .then(function (resp) {
              $scope.phuhuynh = resp.data;
              console.log($scope.phuhuynh.data.sdtphuHuynh);
              console.log($scope.phuhuynh.status);
  
              $scope.datasdt = $scope.phuhuynh.data.sdtphuHuynh;
              if (resp.status == 200) {
                if (
                  sdtphuHuynh == $scope.datasdt &&
                  sdt == $scope.datasdt &&
                  OPT == $scope.radom
                ) {
                  //http://localhost:8081/api/vi/Ministry/SDT/0329000687             
                  $scope.setCookie("Tenhocsinh", $scope.phuhuynh.data.tenHS, 1);
                  $scope.setCookie("sdtphuhuynh", $scope.phuhuynh.data.sdtphuHuynh, 1);
  
                  window.location = "./PHHS.html";
                  console.log("ok");
                } else {
                  console.log("Wrong");
                  $scope.deleteAllCookies();
                }
              } else {
                console.log("Không thể lấy dữ liệu");
              }
            });
        };

        $scope.setCookie = function (cname, cvalue, exdays = 999) {
          var d = new Date();
          d.setTime(d.getTime() + exdays * 24 * 60 * 60 * 1000);
          var expires = "expires=" + d.toUTCString();
          document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
        };
      });