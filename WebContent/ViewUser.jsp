<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app='viewApp'>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="View.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User details</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form ng-controller="userController" ng-submit="viewUser()">

		Enter Customer id :<br> <input type="text" name="customerid"
			ng-model="customerId" /> <input type="submit" name="submit">
		<div ng-show="flag && flag2">
		User Name : {{userName}}<br>
		User Contact : {{userContact}}<br>
		User Address : {{userAdd}}<br>
		User Gender : {{userGender}}<br>
		User Country : {{userCountry}}<br>
		</div>
		<div ng-show="!flag2" ng-hide="flag">
		{{msg}}
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>