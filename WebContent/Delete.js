angular
		.module("deleteApp", [])
		.controller(
				"userController",
				function($scope, $http) {
					$scope.customerId = '';

					$scope.deleteUser = function() {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/User_Registration/UserController",
									data : {
										'source' : 'deleteuser',
										'id' : $scope.customerId
									}
								}).then(function(response) {
							if (angular.equals(response.data, '"success"'))
								location.href = "success.jsp";
							else
								location.href = "failure.jsp";
						});
					};
				});