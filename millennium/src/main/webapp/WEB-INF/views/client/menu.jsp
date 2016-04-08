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
	
<title>Millennium | Menu</title>
</head>
<body>

<div class="menu">
	<header>
	
		<div class="menu-head">
			<div class="number">
				<h3>4</h3>
			</div>
			<div class="menu-order">
				<a href="${pageContext.request.contextPath}/cart"><h3>Basket</h3></a>
			</div>
			<h1>Millennium Pizza</h1>
		</div>
		
		</header>
		<div class="h-menu">
		<h1>MENU:</h1>
		</div>
		<div class="wrapper">
			<div class="menu-left">
				
			</div>
		
			<div class="menu-right">
				
			</div>
  
		<div class="menu-center">
				<div class="menu-center1">
				
					<div class="wrapp1">
						
						<div class="img-w1">
						<a href="pizzaAll"></a>
						</div>
						
						<h1>Pizza</h1>
					</div>
					<div class="wrapp2">
						
						<div class="img-w2"><a href="#"></a></div>
						
						<h1>Dessert</h1>
					</div>
					
					<div class="wrapp3">
						
						<div class="img-w3"><a href="#"></a></div>
						
						<h1>Lunch</h1>
					</div>
					
					<div class="wrapp4">
						
						<div class="img-w4"><a href="#"></a></div>
						
						<h1>Drinks</h1>
					</div>
				
				</div>
			
				<div class="menu-center2">
				
				</div>
			
			
		</div>
			
		</div>
	
	<div class="home">
	<a href="${pageContext.request.contextPath}/index">Home</a>
	</div>
		
		
		</div>
		
	


</body>
</html>