var API_Ministry = "http://localhost:8081/api/vi/Ministry";

app.controller("Ministry-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.ministrys = [];
    $scope.form = {};
    
    $scope.loading = function () {
        $http.get(`${API_Ministry}/getAllMinistry`).then((resp) => {
            $scope.ministrys = resp.data;
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
            .post(`${API_Ministry}/insert`, ministry)
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
            .put(`${API_Ministry}/${ministry.maGiaoVu}`, ministry)
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
            .delete(`${API_Ministry}/${ministry.maGiaoVu}`)
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
            .get(`${API_Ministry}/mahs=${ministry.maGiaoVu}`)
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
                        maGiaoVu : row.getCell(1).value,
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
                    var url = API_Ministry+'/insert';
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
