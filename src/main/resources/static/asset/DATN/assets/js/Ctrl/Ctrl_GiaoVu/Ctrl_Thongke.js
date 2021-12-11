var API_Students = "http://localhost:8081/api/vi/Students";

app.controller("thongke-ctrl", function ($scope, $http) {
    $scope.date = new Date();
    $scope.TongHS = '';
    
    $scope.loading = function () {
        $http.get(`${API_Students}/getCountStudents`).then((resp) => {
            $scope.TongHS = resp.data;
            console.log($scope.TongHS)
        });
    };
    $scope.loading();
});
