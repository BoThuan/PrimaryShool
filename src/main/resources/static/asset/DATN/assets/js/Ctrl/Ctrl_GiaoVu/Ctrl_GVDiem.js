var API_Results = "http://localhost:8081/api/vi/Results";

app.controller("Results-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.Results = [];
    $scope.form = {};
    
    $scope.loading = function () {
        $http.get(`${API_Results}/getAllResults`).then((resp) => {
            $scope.Results = resp.data;
        });
    };
    $scope.loading();
    // Sửa
    $scope.edit = function (Results) {
        $scope.form = angular.copy(Results);
    };

    // Tạo
    $scope.create = function () {
        var Results = angular.copy($scope.form);
        $http
            .post(`${API_Results}/insert`, Results)
            .then((resp) => {
                $scope.Resultss.push(resp.data);
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
        var Results = angular.copy($scope.form);
        $http
            .put(`${API_Results}/${Results.maKQ}`, Results)
            .then((resp) => {
                var index = $scope.Results.findIndex(
                    (p) => p.maKQ == Results.maKQ
                );
                $scope.Results[index] = Results;
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
    $scope.delete = function (Results) {
        $http
            .delete(`${API_Results}/${Results.maKQ}`)
            .then((resp) => {
                var index = $scope.Results.findIndex(
                    (p) => p.maKQ == Results.maKQ
                );
                $scope.Results.splice(index, 1);
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

    $scope.findID = function (Results) {
        console.log(`${Results.maKQ}`);
        $http
            .get(`${API_Results}/mahs=${Results.maKQ}`)
            .then((resp) => {
                var index = $scope.Results.findIndex(
                    (p) => p.maKQ == Results.maKQ
                );
                $scope.Results[index] = Results;
                $scope.Results = resp.data;
            })
            .catch((err) => {
                alert("Lỗi");
                console.log(err);
            });
    };

    $scope.import = function(files){
        var reader = new FileReader();
        reader.onloadend = async () => {
            //=> reader.result
            var workbook = new ExcelJS.Workbook();
            await workbook.xlsx.load(reader.result);
            const worksheet = workbook.getWorksheet('Sheet1');
            worksheet.eachRow((row,index) =>{
                if(index>1){
                    let student = {
                        maKQ : row.getCell(1).value,
                        tenGiaoVu : row.getCell(2).value,
                        chucVu : row.getCell(3).value,
                        ngaySinh : row.getCell(4).value,
                        gioiTinh: true && row.getCell(5).value,
                        email : row.getCell(6).value,
                        sdt : row.getCell(7).value,
                        diaChi : row.getCell(8).value,
                        ghiChu : row.getCell(9).value,
                        hinh : row.getCell(10).value,

                    }
                    var url = API_Results+'/insert';
                    $http.post(url,student).then(resp =>{
                        console.log("Success",resp.data);
                        $scope.loading();
                    }).catch(error =>{
                        console.log("Error",error);
                        alert(error);
                    })
                }
            })
        };
        reader.readAsArrayBuffer(files[0]);
    }
});
