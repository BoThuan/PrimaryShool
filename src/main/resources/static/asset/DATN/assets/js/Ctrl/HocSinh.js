// app.controller("hocsinhCrtl", function () {
//     var test = [1,2,3,4,5,6,7,8,9];

//     var element = document.getElementById("demo");
    
//     var htmls = test.map(function (value) {
//         return `<tr>
//             <td>${value}</td>
//             <td class="btn">
//                 <button id="open_abc" onclick="popup(${value});">
//                     click me
//                 </button>            
//             </td>
//         </tr>`;
//     })

//     element.innerHTML = htmls.join("\n");
// })

var api = "http://localhost:8081/api/vi/Students";
app.controller("student-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.students = [];
    $scope.form = {};
    $scope.sortType = 'name';
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
            .put(`${api}/update/${student.maPH}`, student)
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
            .delete(`${api}/delete/${student.maPH}`)
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
                        maHS : row.getCell(1).value,
                        tenHS: row.getCell(2).value,
                        ngaySinh: +row.getCell(3).value,
                        gioiTinh: true && row.getCell(4).value,
                        diaChi: row.getCell(5).value,
                        ghiChu: row.getCell(6).value,
                        Hinh: row.getCell(7).value,
                    }
                    var url = "http://localhost:8081/api/vi/Students/insert";
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

function popup(student) {
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
