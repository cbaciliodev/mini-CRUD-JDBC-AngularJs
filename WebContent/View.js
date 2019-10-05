angular
		.module("viewApp", [])
		.controller(
				"userController",
				function($scope, $http) {
					$scope.customerId = '';
					$scope.flag=0;
					$scope.flag2=1;
					$scope.viewUser = function() {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/User_Registration/UserController",
									data : {
										'source' : 'viewuser',
										'id' : $scope.customerId
									}
								}).then(
								function(response) {

									if (angular.equals(
											response.data.split(',')[0],
											'"success')) {
										$scope.flag=1;
										$scope.flag2=1;
										$scope.userName=response.data.split(',')[1];
										$scope.userContact=response.data.split(',')[2];
										$scope.userAdd=response.data.split(',')[3];
										$scope.userGender=response.data.split(',')[4];
										$scope.userCountry=response.data.split(',')[5];
									} else{
										$scope.flag=0;
										$scope.flag2=0;
										$scope.msg="No Such User Exists";
									}
								});
					};
				});