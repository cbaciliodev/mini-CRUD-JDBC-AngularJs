angular.module("addApp", []).controller(
		"userController",
		function($scope, $http) {
			$scope.userName = '';
			$scope.phone = '';
			$scope.address = '';
			$scope.country = '';
			$scope.gender = '';

			$scope.addUser = function() {
				$http({
					method : "POST",
					url : "UserController",
					data : {
						'source' : 'adduser',
						'name' : $scope.userName,
						'phone' : $scope.phone,
						'address' : $scope.address,
						'country' : $scope.country,
						'gender' : $scope.gender
					}
				}).then(
						function(response) {
							console.log(response.data.split(','));
							if (angular.equals(response.data.split(',')[0],
									'"success')) {
								alert("Customer id: "
										+ response.data.split(',')[1]
												.split('"')[0]);
								location.href = "success.jsp";
							} else {

								location.href = "failure.jsp";
							}
						});
			};
		});