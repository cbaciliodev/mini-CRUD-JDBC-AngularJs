<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app='updateApp'>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="Update.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update user details</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form ng-controller="userController" ng-submit="updateUser()">
		Enter Customer id : <input type="text" name="customerid" ng-model="id" /><br>
		<br> User Name : <input type="text" name="name"
			ng-model="userName"><br> <br> Phone : <input
			type="text" name="phone" ng-model="phone"><br> <br>
		Country : <select name="country" id="country" ng-model="country">
			<option value="India">India</option>
			<option value="Japan">Japan</option>
			<option value="Australia">Australia</option>
			<option value="China">China</option>
			<option value="SriLanka">Sri Lanka</option>
		</select> <br> <br> Address :<input type="text" name="address"
			ng-model="address"><br> <br> Gender : <input
			type="radio" name="gender" value="Male" ng-model="gender">Male
		<input type="radio" name="gender" value="Female" ng-model="gender">Female<br>
		<br>
		<button class="btn btn-primary">Submit</button>
		&nbsp;&nbsp;<input type="reset" value="Reset">
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
	<br>
</body>
</html>