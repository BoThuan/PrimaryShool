var app = angular.module("app", []);
app.controller("app-Ctrl", function ($scope, $http) {
  $scope.radom = Math.floor(100000 + Math.random() * 900000);
  $scope.hocsinh = [];
  $scope.error = "";
      $scope.sdt_giaovu = "Vui Lòng nhập số điện thoại";
      $scope.matkhau = "Vui Lòng nhập mật khẩu (Số điện thoại)";
      $scope.captcha = "Vui Lòng nhập CAPTCHA";

  $scope.login = function () {
    $scope.null = true;
    //lấy dữ liệu
    var sdtphuHuynh = $scope.sdtphuHuynh;
    var sdt = $scope.mkphuHuynh;
    var OPT = $scope.OTP;

    var vnf_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;

    if (sdtphuHuynh == null) {
      $scope.sdt_giaovu = `Số điện thoại trống`;
      $scope.null = false;
    } else if (vnf_regex.test(sdtphuHuynh) == false) {
      $scope.OTP = "";
      $scope.sdt_giaovu = `Số điện thoại của bạn không đúng định dạng!`;
      $scope.null = false;
    }
    if (sdt == null) {
      $scope.matkhau = `Mật khẩu trống`;
      $scope.null = false;
    }
    if (OPT == null) {
      $scope.captcha = `CAPTCHA trống`;
      $scope.null = false;
    } else if (OPT != $scope.radom) {
      $scope.captcha = `CAPTCHA không khớp`;
      $scope.null = false;
      $scope.OTP = "";
      $scope.radom = Math.floor(100000 + Math.random() * 900000);
    }

    if ($scope.null == false) {} else {
      //gọi dự liệu từ database
      $http
        .get(`http://localhost:8081/api/vi/Students/SDTphuhuynh/${sdtphuHuynh}`)
        .then(function (resp) {
          $scope.phuhuynh = resp.data;

          
          if (resp.status == 200) {
            if ($scope.phuhuynh.status == 404) {
              $scope.error = `Tài Khoản ${sdtphuHuynh} không tồn tại`;
              $scope.sdt_giaovu = "Vui Lòng nhập lại Số điện thoại";
              $scope.matkhau = "Vui Lòng nhập lại mật khẩu (Số điện thoại)";
              $scope.captcha = "Vui Lòng nhập lại CAPTCHA";
              $scope.radom = Math.floor(100000 + Math.random() * 900000);
              sdtgiaovu = "";
              sdt = "";
              OTP = "";
              $scope.sdt = "";
              $scope.mk = "";
              $scope.OTP = "";
            } else {
              $scope.datasdt = $scope.phuhuynh.data.sdtphuHuynh;
            if (
              sdtphuHuynh == $scope.datasdt &&
              sdt == $scope.datasdt &&
              OPT == $scope.radom
            ) {
              //http://localhost:8081/api/vi/Ministry/SDT/0329000687
              $scope.setCookie("Tenhocsinh", $scope.phuhuynh.data.tenHS, 1);
              $scope.setCookie(
                "sdtphuhuynh",
                $scope.phuhuynh.data.sdtphuHuynh,
                1
              );

              window.location = "./PHHS.html";
              console.log("ok");
            } else {
              console.log("Wrong");
              $scope.deleteAllCookies();
            }}
          } else {
            console.log("Không thể lấy dữ liệu");
          }
        });
    }
  };

  $scope.setCookie = function (cname, cvalue, exdays = 999) {
    var d = new Date();
    d.setTime(d.getTime() + exdays * 24 * 60 * 60 * 1000);
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  };
});
