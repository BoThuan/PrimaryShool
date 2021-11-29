var API_Results = "http://localhost:8081/api/vi/Results";

app.controller("Result-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.results = [];
    $scope.form = {};
    $scope.maKQ = '';
    $scope.loading = function () {
        $http.get(`${API_Results}/getAllResults`).then((resp) => {
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
            .post(`${API_Results}/insert`, result)
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

    $scope.reset = function () {
        $scope.form = {};
    };

    
    // Cập nhập
    $scope.result = function () {
        var result = angular.copy($scope.form);
        $http
            .put(`${API_Results}/${result.maKQ}`, result)
            .then((resp) => {
                var index = $scope.results.findIndex(
                    (p) => p.maKQ == result.maKQ
                );
                $scope.results[index] = result;
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
    $scope.delete = function (result) {
        $http
            .delete(`${API_Results}/${result.maKQ}`)
            .then((resp) => {
                var index = $scope.results.findIndex(
                    (p) => p.maKQ == result.maKQ
                );
                $scope.results.splice(index, 1);
                $scope.reset();
                alert("Xóa thành công");
            })
            .catch((error) => {
                alert("Lỗi xóat");
                console.log("Error", error);
            });
    };
})
