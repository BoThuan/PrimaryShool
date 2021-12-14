var API_Students = "http://localhost:8081/api/vi/Students";
var API_Parents = "http://localhost:8081/api/vi/Parents";

app.controller("Student-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.students = [];
    $scope.parents = [];
    $scope.ma = '';

    $scope.form = {};
    $scope.countStudent = '';
    $scope.loading = function () {
        $http.get(`${API_Students}/getAllStudents`).then((resp) => {
            $scope.students = resp.data;
        });
    };
    $scope.loadingParent = function () {
        $http.get(`${API_Parents}/getAllParents`).then((resp) => {
            $scope.parents = resp.data;
        });
    };

    // loading
    $scope.loading();
    $scope.loadingParent();

    // Sửa
    $scope.edit = function (student) {
        $scope.form = angular.copy(student);
    };

    // Tạo
    $scope.create = function () {
        var student = angular.copy($scope.form);
        $http
            .post(`${API_Students}/insert`, student)
            .then((resp) => {
                $scope.students.push(resp.data);
                $scope.loading();
                $scope.reset();
                alert("Thêm mới thành công");
                $scope.loading();
            })
            .catch((error) => {
                alert("Lỗi");
                console.log("Error", error);
            });
    };

    // Cập nhập
    $scope.update = function () {
        var student = angular.copy($scope.form);
        $http
            .put(`${API_Students}/${student.maHS}`, student)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maHS == student.maHS
                );
                $scope.students[index] = student;
                $scope.loading();
                $scope.reset();
                alert("Cập nhập thành công");
                $scope.loading();
            })
            .catch((error) => {
                alert("Lỗi");
                console.log("Error", error);
            });
    };

    // Xóa
    $scope.delete = function (student) {
        $http
            .delete(`${API_Students}/${student.maHS}`)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maHS == student.maHS
                );
                $scope.students.splice(index, 1);
                $scope.reset();
                alert("Xóa thành công");
                $scope.loading();
            })
            .catch((error) => {
                alert("Lỗi xóat");
                console.log("Error", error);
            });
    };

    $scope.reset = function () {
        $scope.form = {};
    };

    $scope.findID = function (student) {
        console.log(`${student.maHS}`);
        $http
            .get(`${API_Students}/mahs=${student.maHS}`)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maHS == student.maHS
                );
                $scope.students[index] = student;
                $scope.students = resp.data;
            })
            .catch((err) => {
                alert("Lỗi");
                console.log(err);
            });
    };

    $scope.hienthi = function (student) {
        $scope.form = angular.copy(student);
        var mahocsinh = student.maHS;
        console.log(mahocsinh)
        var trangthai = document.getElementById("content").style.display
        if (trangthai == 'none'&& mahocsinh != $scope.ma | mahocsinh == $scope.ma ) {
            document.getElementById("content").style.display = 'block';
            console.log("đổi trạng thái")
            $scope.ma = mahocsinh;
        }
        else if (trangthai == 'block' && mahocsinh != $scope.ma) {
            $scope.ma = mahocsinh;
            console.log("oke chạy được")
        }
        else { document.getElementById("content").style.display = 'none'; }
    };

    $scope.import = function (files) {
        var reader = new FileReader();
        reader.onloadend = async () => {
            //=> reader.result
            var workbook = new ExcelJS.Workbook();
            await workbook.xlsx.load(reader.result);
            const worksheet = workbook.getWorksheet('Sheet1');
            worksheet.eachRow((row, index) => {
                if (index > 1) {
                    let student = {
                        maHS: row.getCell(1).value,
                        tenHS: row.getCell(2).value,
                        ngaySinh: +row.getCell(3).value,
                        gioiTinh: true && row.getCell(4).value,
                        diaChi: row.getCell(5).value,
                        ghiChu: row.getCell(6).value,
                        Hinh: row.getCell(7).value,
                    }
                    var url = API_Students + '/insert';
                    $http.post(url, student).then(resp => {
                        console.log("Success", resp.data);
                        alert("Thêm Thành Công");
                        $scope.loading();
                    }).catch(error => {
                        console.log("Error", error);
                        alert(error);
                    })
                }
            })
        };
        reader.readAsArrayBuffer(files[0]);
    }
});
