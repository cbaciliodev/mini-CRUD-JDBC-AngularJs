angular
		.module("updateApp", [])
		.controller(
				"userController",
				function($scope, $http) {
					$scope.id = '';
					$scope.userName = '';
					$scope.phone = '';
					$scope.address = '';
					$scope.country = '';
					$scope.gender = '';

					$scope.updateUser = function() {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/User_Registration/UserController",
									data : {
										'source' : 'updateuser',
										'id' : $scope.id,
										'name' : $scope.userName,
										'phone' : $scope.phone,
										'address' : $scope.address,
										'country' : $scope.country,
										'gender' : $scope.gender
									}
								}).then(function(response) {
							if (angular.equals(response.data, '"success"'))
								location.href = "success.jsp";
							else
								location.href = "failure.jsp";
						});
					};
				});