var app = angular.module('myApp', ['ngRoute']);
app.config(function ($routeProvider) {
	$routeProvider
	// giao vien
		.when('/thongbao', {
			templateUrl: './assets/views/GiaoVien/Thongbao.html',
		})
		.when('/HS', {
			templateUrl: './assets/views/GiaoVien/HS.html',
		})
		.when('/diemDanh', {
			templateUrl: './assets/views/GiaoVien/DiemDanh.html',
		})
		.when('/GVDiem', {
			templateUrl: './assets/views/GiaoVien/GVDiem.html',
		})
		.when('/CGL', {
			templateUrl: './assets/views/GiaoVien/CGL.html',
		})
		.when('/GVCN', {
			templateUrl: './assets/views/GiaoVien/GVCN.html',
		})
		;
});

var api = "http://localhost:8081/api/vi/Students";
app.controller("student-ctrl", function ($scope, $http) {
	$scope.students = [];
	$scope.form = {};
	$scope.loading = function () {
	  $http.get(`${api}/getAllStudents`).then(resp => {
		$scope.students = resp.data;
	  });
	}
  
	$scope.loading();
   
	// Sửa
	$scope.edit = function (student) {
	  $scope.form = angular.copy(student);
	}
  
	// Tạo 
	$scope.create = function () {
	  var student = angular.copy($scope.form);
	  $http.post(`${api}/insert`, student).then(resp => {
		$scope.students.push(resp.data);
		$scope.loading();
		$scope.reset();
		alert("Thêm mới thành công");
	  }).catch(error => {
		alert("Lỗi");
		console.log("Error", error);
	  })
	}
  
	// Cập nhập
	$scope.update = function () {
	  var student = angular.copy($scope.form);
	  $http.put(`${api}/${student.maPH}`, student).then(resp => {
		var index = $scope.students.findIndex(p => p.maPH == student.maPH);
		$scope.students[index] = student;
		$scope.loading();
		$scope.reset();
		alert("Cập nhậtthành công");
	  }).catch(error => {
		alert("Lỗi");
		console.log("Error", error);
	  })
	}
  
	// Xóa
	$scope.delete = function (student) {
	  $http.delete(`${api}/${student.maPH}`).then(resp => {
		  var index = $scope.students.findIndex(p => p.maPH == student.maPH);
		  $scope.students.splice(index, 1);
		  $scope.reset();
		  alert("Xóa thành công");
	  }).catch(error => {
		  alert("Lỗi xóat");
		  console.log("Error", error);
	  })
	}
  
	$scope.reset = function () {
	  $scope.form = {};
	}
  
	$scope.findID = function (student) {
	  console.log(`${student.maPH}`)
	  $http.get(`${api}/mahs=${student.maPH}`).then((resp) => {
		  var index = $scope.students.findIndex(p => p.maPH == student.maPH);
		  $scope.students[index] = student;
		  $scope.students = resp.data;
	  }).catch((err) => {
		alert("Lỗi")
		console.log(err)
	  });
	}
  
  });
