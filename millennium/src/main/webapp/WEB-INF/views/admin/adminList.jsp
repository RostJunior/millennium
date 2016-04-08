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

<title>AdminList</title>
</head>
<body>
<header>
				
			<div>
			<h1>Millennium Administration</h1>
			</div>
			
</header>
<div class="lists">
<div>
<img alt="Millennium" src="<c:url value="/resources/img/Millennium.JPG"/>"/>
</div>

<div class="adminList">

<a href="adminProduct">Products</a>

<a href="adminUsers">Users</a>

<a href="#">Orders</a>

</div>

</div>
<div class="home">
	<a href="index">Home</a>
	</div>
</body>
</html>