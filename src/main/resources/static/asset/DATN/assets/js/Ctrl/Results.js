var api = "http://localhost:8081/api/vi/Results";
app.controller("results-ctrl", function ($scope, $http) {
  $scope.date = new Date();
  $scope.results = [];
  $scope.form = {};
  $scope.loading = function () {
    $http.get(`${api}/getAllResults`).then((resp) => {
      $scope.results = resp.data;
    });
  };
  $scope.loading();
  // Sửa
  $scope.edit = function (result) {
    $scope.form = angular.copy(result);
  };

  // Tạo
  $scope.create = function () {
    var result = angular.copy($scope.form);
    
    $http
      .post(`${api}/insert`, result)
      .then((resp) => {
        $scope.results.push(resp.data);
        $scope.loading();
        $scope.reset();
        alert("Thêm mới thành công");
      })
      .catch((error) => {
        alert("Lỗi");
        console.log("Error", error);
      });
  };

  // Cập nhập
  $scope.update = function () {
    var result = angular.copy($scope.form);
    $http
      .put(`${api}/${result.maKQ}`, result)
      .then((resp) => {
        var index = $scope.results.findIndex((p) => p.maKQ == result.maKQ);
        $scope.results[index] = result;
        $scope.loading();
        $scope.reset();
        alert("Cập nhậtthành công");
      })
      .catch((error) => {
        alert("Lỗi");
        console.log("Error", error);
      });
  };

  // Xóa
  $scope.delete = function (result) {
    $http
      .delete(`${api}/${result.maKQ}`)
      .then((resp) => {
        var index = $scope.results.findIndex((p) => p.maKQ == result.maKQ);
        $scope.results.splice(index, 1);
        $scope.reset();
        alert("Xóa thành công");
      })
      .catch((error) => {
        alert("Lỗi xóat");
        console.log("Error", error);
      });
  };

  $scope.reset = function () {
    $scope.form = {};
  };

  $scope.findID = function (result) {
    console.log(`${result.maKQ}`);
    $http
      .get(`${api}/mahs=${result.maKQ}`)
      .then((resp) => {
        var index = $scope.results.findIndex((p) => p.maKQ == result.maKQ);
        $scope.results[index] = result;
        $scope.results = resp.data;
      })
      .catch((err) => {
        alert("Lỗi");
        console.log(err);
      });
  };
});

function check() {
    var disabled_select_Ly_Do = document.getElementById("select_Ly_Do").disabled;
    if (disabled_select_Ly_Do) {
        console.log(disabled_select_Ly_Do)
        document.getElementById("select_Ly_Do").disabled = false;
        document.getElementById("write_Ly_Do").disabled = true;
    } else {
        console.log(disabled_select_Ly_Do)
        document.getElementById("select_Ly_Do").disabled = true;
        document.getElementById("write_Ly_Do").disabled = false;
    }
  }
