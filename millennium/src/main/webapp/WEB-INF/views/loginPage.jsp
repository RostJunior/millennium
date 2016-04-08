<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>


<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	
	<link href="<c:url value="https://fonts.googleapis.com/css?family=Playfair+Display:900italic"/>" rel='stylesheet' type='text/css'>

<title>Login</title>
</head>

<body>
<div class="loginPage">

		<c:if test="${'fail' eq param.auth}">
		<h2 style="color: red">Wrong username or password</h2>
		</c:if>
		
		
<form action="login" method="POST">
		<label>Login:</label><br> 	
		<input type="text" name="loginUser"
			placeholder="enter your login" required><br> 
			<label>Password:</label><br>
		<input type="password" name="passwordUser" placeholder="your password"
			required><br>
			<br/>
			
		<button type="submit">E n t e r</button>
	</form>
	
	</div>
</body>
</html>