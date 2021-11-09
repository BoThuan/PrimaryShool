var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        // giao vien
        .when("/thongbao", {
            templateUrl: "./assets/views/GiaoVien/Thongbao.html",
        })
        .when("/HS", {
            templateUrl: "./assets/views/GiaoVien/HS.html",
            controller: "hocsinhCrtl",
        })
        .when("/diemDanh", {
            templateUrl: "./assets/views/GiaoVien/DiemDanh.html",
        })
        .when("/GVDiem", {
            templateUrl: "./assets/views/GiaoVien/GVDiem.html",
        })
        .when("/CGL", {
            templateUrl: "./assets/views/GiaoVien/CGL.html",
        })
        .when("/GVCN", {
            templateUrl: "./assets/views/GiaoVien/GVCN.html",
        });
});

var api = "http://localhost:8081/api/vi/Students";
app.controller("student-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.students = [];
    $scope.form = {};
    $scope.loading = function () {
        $http.get(`${api}/getAllStudents`).then((resp) => {
            $scope.students = resp.data;
        });
    };
    $scope.loading();
    // Sửa
    $scope.edit = function (student) {
        $scope.form = angular.copy(student);
    };

    // Tạo
    $scope.create = function () {
        var student = angular.copy($scope.form);
        $http
            .post(`${api}/insert`, student)
            .then((resp) => {
                $scope.students.push(resp.data);
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
        var student = angular.copy($scope.form);
        $http
            .put(`${api}/${student.maPH}`, student)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maPH == student.maPH
                );
                $scope.students[index] = student;
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
    $scope.delete = function (student) {
        $http
            .delete(`${api}/${student.maPH}`)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maPH == student.maPH
                );
                $scope.students.splice(index, 1);
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

    $scope.findID = function (student) {
        console.log(`${student.maPH}`);
        $http
            .get(`${api}/mahs=${student.maPH}`)
            .then((resp) => {
                var index = $scope.students.findIndex(
                    (p) => p.maPH == student.maPH
                );
                $scope.students[index] = student;
                $scope.students = resp.data;
            })
            .catch((err) => {
                alert("Lỗi");
                console.log(err);
            });
    };
});
function popup() {
    const open_abc = document.getElementById("open_abc");
    const modal_container = document.getElementById("modal_container");
    const close__modal = document.getElementById("close__modal");

    // for(var i = 0; i < open_abc.length; i++) {
    // 	open_abc[i].onclick = function(){
    // 		console.log(open_abc[i])
    // 	}
    // open_abc[i].addEventListener('click',() => {
    // modal_container.classList.add('show');

    // 	});
    // }

    open_abc.addEventListener("click", () => {
        modal_container.classList.add("show");
    });

    close__modal.addEventListener("click", () => {
        modal_container.classList.remove("show");
    });

    // const getMaHS = document.getElementById("mahs").innerText;
    // const code_abc = (document.getElementById("info__textbox--code").value =
    //     getMaHS);
}
