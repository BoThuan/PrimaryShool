var API_Teachers = "http://localhost:8081/api/vi/Teachers";

app.controller('Teacher-Ctrl', function ($scope, $http) {
    $scope.teachers = [];
    $scope.form = {};

    $scope.loading = function () {
        $http.get(`${API_Teachers}/getAllTeachers`).then((resp) => {
            $scope.teachers = resp.data;
        });
    };

    $scope.loading();

    // Sửa
    $scope.edit = function (teacher) {
        $scope.form = angular.copy(teacher);
    };

    // Xoa trang
    $scope.reset = function () {
        $scope.form = {};
    };

    // Tạo
    $scope.create = function () {
        var teacher = angular.copy($scope.form);
        $http
            .post(`${API_Teachers}/insert`, teacher)
            .then((resp) => {
                $scope.teachers.push(resp.data);
                $scope.loading();
                $scope.reset();
                alert("Thêm mới thành công");
            })
            .catch((error) => {
                alert("Lỗi");
                console.log("Error", error);
            });
    };

    // Xóa
    $scope.delete = function (teacher) {
        $http
            .delete(`${API_Teachers}/${teacher.maGV}`)
            .then((resp) => {
                var index = $scope.teachers.findIndex(
                    (p) => p.maGV == teacher.maGV
                );
                $scope.teachers.splice(index, 1);
                $scope.reset();
                alert("Xóa thành công");
            })
            .catch((error) => {
                alert("Lỗi xóat");
                console.log("Error", error);
            });
    };

    // Cập nhập
    $scope.update = function () {
        var teacher = angular.copy($scope.form);
        $http
            .put(`${API_Teachers}/${teacher.maGV}`, teacher)
            .then((resp) => {
                var index = $scope.teachers.findIndex(
                    (p) => p.maGV == teacher.maGV
                );
                $scope.teachers[index] = teacher;
                $scope.loading();
                $scope.reset();
                alert("Cập nhật thành công");
            })
            .catch((error) => {
                alert("Lỗi");
                console.log("Error", error);
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
                        maGV : row.getCell(1).value,
                        tenGV: row.getCell(2).value,
                        ngaySinh: +row.getCell(6).value,
                        gioiTinh: true && row.getCell(8).value,
                        diaChi: row.getCell(5).value,
                        ghiChu: row.getCell(9).value,
                        hinh: row.getCell(7).value,
                        sdt: row.getCell(3).value,
                        email: row.getCell(4).value,
                    }
                    var url = "http://localhost:8081/API_Teachers/vi/Teachers/insert";
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
})