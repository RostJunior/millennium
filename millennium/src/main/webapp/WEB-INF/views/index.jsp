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


<title>MILLENNIUM | Welcome!</title>
</head>
<body>

<!--Header -->
		
		<header>
			<div>
			<h3>Welcome to Millennium pizza and have a nice day!</h3>
			</div>
		</header>
		
		<!--END Header -->
		<div class="greeting">
		<div class="left-client">
			<a href="menuClients"><span>The Pizzeria</span></a>
		</div>
		
		<div class="kitchen-right">
			<a href="kitchenList"><span>The Kitchen</span></a>
		</div>
		
		<div class="contact">
			<a href="contact"><span>Contact</span></a>
		</div>
		
		<div class="administration">
			<a href="adminList"><span>Administration</span></a>
		</div>
	
	</div>
	
	
	<div class="logout">
	<a href="logout">Вихід</a>
	</div>
		<!--Footer 
		<footer>
		<h2>FOOTER</h2>
		</footer>
		END Footer -->
		
	</body>


</body>
</html>