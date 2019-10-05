<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration System</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<script type="text/javascript">
		document.getElementById("home").style.visibility = 'hidden';
	</script>
	<ol type="1">

		<li><a href="AddUser.jsp">Add User </a></li>
		<li><a href="ViewUser.jsp">View User Details</a></li>
		<li><a href="UpdateUser.jsp">Update User details</a></li>
		<li><a href="DeleteUser.jsp">Delete User details</a></li>
	</ol>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>