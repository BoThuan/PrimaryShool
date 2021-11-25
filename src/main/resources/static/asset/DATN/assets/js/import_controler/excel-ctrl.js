var app= angular.module("app",[]);
app.controller("student-ctrl",function($scope, $http){
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
                        subclass: row.getCell(7).value,
                        parents: row.getCell(8).value,
                        Hinh: row.getCell(9).value,
                    }
                    var url = "http://localhost:8081/api/vi/Students/insert";
                    $http.post(url,student).then(resp =>{
                        console.log("Success",resp.data);
                    }).catch(error =>{
                        console.log("Error",error);
                    })
                }
            })
        };
        reader.readAsArrayBuffer(files[0]);
    }
})