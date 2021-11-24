var api = "http://localhost:8081/api/vi/Ministry";
var myApp = angular.module('myApp', []);

myApp.controller("Ministry-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.ministrys = [];
    $scope.form = {};
    $scope.MaxMaGV = '';
    $scope.loading = function () {
        $http.get(`${api}/getAllMinistry`).then((resp) => {
            $scope.ministrys = resp.data;
        });
        $http.get(`${api}/MaxMaGV`).then((resp) => {
            $scope.MaxMaGV = resp.text;
        });
    };
    $scope.loading();
    // Sửa
    $scope.edit = function (ministry) {
        $scope.form = angular.copy(ministry);
    };

    // Tạo
    $scope.create = function () {
        var ministry = angular.copy($scope.form);
        $http
            .post(`${api}/insert`, ministry)
            .then((resp) => {
                $scope.ministrys.push(resp.data);
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
        var ministry = angular.copy($scope.form);
        $http
            .put(`${api}/${ministry.maGiaoVu}`, ministry)
            .then((resp) => {
                var index = $scope.ministrys.findIndex(
                    (p) => p.maGiaoVu == ministry.maGiaoVu
                );
                $scope.ministrys[index] = ministry;
                $scope.loading();
                $scope.reset();
                alert("Cập nhật thành công");
            })
            .catch((error) => {
                alert("Lỗi");
                console.log("Error", error);
            });
    };

    // Xóa
    $scope.delete = function (ministry) {
        $http
            .delete(`${api}/${ministry.maGiaoVu}`)
            .then((resp) => {
                var index = $scope.ministrys.findIndex(
                    (p) => p.maGiaoVu == ministry.maGiaoVu
                );
                $scope.ministrys.splice(index, 1);
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

    $scope.findID = function (ministry) {
        console.log(`${ministry.maGiaoVu}`);
        $http
            .get(`${api}/mahs=${ministry.maGiaoVu}`)
            .then((resp) => {
                var index = $scope.ministrys.findIndex(
                    (p) => p.maGiaoVu == ministry.maGiaoVu
                );
                $scope.ministrys[index] = ministry;
                $scope.ministrys = resp.data;
            })
            .catch((err) => {
                alert("Lỗi");
                console.log(err);
            });
    };
});
