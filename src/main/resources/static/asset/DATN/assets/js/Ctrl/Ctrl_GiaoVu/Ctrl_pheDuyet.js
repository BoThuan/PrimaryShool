var API_Approve = "http://localhost:8081/api/vi/Approve";

app.controller("Approve-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.Approves = [];
    $scope.form = {};
    $scope.loading = function () {
        $http.get(`${API_Approve}/getAllApprove`).then((resp) => {
            $scope.Approves = resp.data;
        });
    };
    $scope.loading();
    // Sửa
    $scope.edit = function (Approve) {
        $scope.form = angular.copy(Approve);
    };

    // Tạo
    $scope.create = function () {
        var Approve = angular.copy($scope.form);
        $http
            .post(`${API_Approve}/insert`, Approve)
            .then((resp) => {
                $scope.Approves.push(resp.data);
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
        var Approve = angular.copy($scope.form);
        $http
            .put(`${API_Approve}/${Approve.maPD}`, Approve)
            .then((resp) => {
                var index = $scope.Approves.findIndex(
                    (p) => p.maPD == Approve.maPD
                );
                $scope.Approves[index] = Approve;
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
    $scope.delete = function (Approve) {
        $http
            .delete(`${API_Approve}/${Approve.maPD}`)
            .then((resp) => {
                var index = $scope.Approves.findIndex(
                    (p) => p.maPD == Approve.maPD
                );
                $scope.Approves.splice(index, 1);
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

    $scope.findID = function (Approve) {
        console.log(`${Approve.maPD}`);
        $http
            .get(`${API_Approve}/mahs=${Approve.maPD}`)
            .then((resp) => {
                var index = $scope.Approves.findIndex(
                    (p) => p.maPD == Approve.maPD
                );
                $scope.Approves[index] = Approve;
                $scope.Approves = resp.data;
            })
            .catch((err) => {
                alert("Lỗi");
                console.log(err);
            });
    };
});
