var API_Classroom = "http://localhost:8081/api/vi/Classroom";
var API_Teachers   = "http://localhost:8081/api/vi/Teachers";

app.controller("Classroom-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.Classrooms = [];
    $scope.parents = [];

    $scope.form = {};
    $scope.loading = function () {
        $http.get(`${API_Classroom}/getAllClassroom`).then((resp) => {
            $scope.Classrooms = resp.data;
        });
    };
    $scope.loadingTeachers = function () {
        $http.get(`${API_Teachers}/getAllTeachers`).then((resp) => {
            $scope.parents = resp.data;
        });
    };

    // loading
    $scope.loading();
    $scope.loadingTeachers();

    // Sửa
    $scope.edit = function (Classroom) {
        $scope.form = angular.copy(Classroom);
    };

    // Tạo
    $scope.create = function () {
        var Classroom = angular.copy($scope.form);
        $http
            .post(`${API_Classroom}/insert`, Classroom)
            .then((resp) => {
                $scope.Classroom.push(resp.data);
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
        var Classroom = angular.copy($scope.form);
        $http
            .put(`${API_Classroom}/${Classroom.maLop}`, Classroom)
            .then((resp) => {
                var index = $scope.Classroom.findIndex(
                    (p) => p.maLop == Classroom.maLop
                );
                $scope.Classroom[index] = Classroom;
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
    $scope.delete = function (Classroom) {
        $http
            .delete(`${API_Classroom}/${Classroom.maLop}`)
            .then((resp) => {
                var index = $scope.Classroom.findIndex(
                    (p) => p.maLop == Classroom.maLop
                );
                $scope.Classroom.splice(index, 1);
                $scope.reset();
                alert("Xóa thành công");
                $scope.loading();
            })
            .catch((error) => {
                alert("Lỗi xóa");
                console.log("Error", error);
            });
    };

    $scope.reset = function () {
        $scope.form = {};
    };

    $scope.findID = function (Classroom) {
        console.log(`${Classroom.maLop}`);
        $http
            .get(`${API_Classroom}/maLop=${Classroom.maLop}`)
            .then((resp) => {
                var index = $scope.Classroom.findIndex(
                    (p) => p.maLop == Classroom.maLop
                );
                $scope.Classroom[index] = Classroom;
                $scope.Classroom = resp.data;
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
                    let Classroom = {
                        maLop : row.getCell(1).value,
                        tenLop: row.getCell(2).value,
                        khoi: row.getCell(3).value,
                        year: row.getCell(4).value,
                        maGV: row.getCell(5).value,
                        maGiaoVu: row.getCell(6).value
                    }
                    var url = API_Classroom+'/insert';
                    $http.post(url,Classroom).then(resp =>{
                        console.log("Success",resp.data);
                        alert("Thêm Thành Công");
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
