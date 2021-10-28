var api = "http://localhost:8081/api/vi/Parents";

var myApp = angular.module('myApp', []);

myApp.controller("app-ctrl", function ($scope, $http) {
  $scope.items = [];
  $scope.form = {};
  $scope.loading = function () {
    $http.get(`${api}/getallParents`).then(resp => {
      $scope.items = resp.data;
    });
  }

  $scope.loading();
 
  // Sửa
  $scope.edit = function (item) {
    $scope.form = angular.copy(item);
  }

  // Tạo 
  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http.post(`${api}/insert`, item).then(resp => {
      $scope.items.push(resp.data);
      $scope.loading();
      $scope.reset();
      alert("Thêm mới thành công");
    }).catch(error => {
      alert("Lỗi");
      console.log("Error", error);
    })
  }

  // Cập nhập
  $scope.update = function () {
    var item = angular.copy($scope.form);
    $http.put(`${api}/${item.maPH}`, item).then(resp => {
      var index = $scope.items.findIndex(p => p.maPH == item.maPH);
      $scope.items[index] = item;
      $scope.loading();
      $scope.reset();
      alert("Cập nhậtthành công");
    }).catch(error => {
      alert("Lỗi");
      console.log("Error", error);
    })
  }

  // Xóa
  $scope.delete = function (item) {
    $http.delete(`${api}/${item.maPH}`).then(resp => {
        var index = $scope.items.findIndex(p => p.maPH == item.maPH);
        $scope.items.splice(index, 1);
        $scope.reset();
        alert("Xóa thành công");
    }).catch(error => {
        alert("Lỗi xóat");
        console.log("Error", error);
    })
  }

  $scope.reset = function () {
    $scope.form = {};
  }

  $scope.findID = function (item) {
    console.log(`${item.maPH}`)
    $http.get(`${api}/maph=${item.maPH}`).then((resp) => {
        var index = $scope.items.findIndex(p => p.maPH == item.maPH);
        $scope.items[index] = item;
        $scope.items = resp.data;
    }).catch((err) => {
      alert("Lỗi")
      console.log(err)
    });
  }

});