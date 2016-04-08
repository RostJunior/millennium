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

<title>Pizza</title>
</head>
<body>
		<header>
			<div class="number">
				<h3>4</h3>
			</div>
			
			<div class="menu-order">
				<a href="${pageContext.request.contextPath}/cart"><h3>Basket</h3></a>
			</div>
			
			<div>
			<h1>Millennium Pizza</h1>
			</div>
			
	</header>
	
	
	<div class="pizza">
			<div class="slider_pizza">
			
			
			</div>
			
			<c:forEach items="${allPizza}" var="pizza">
				<form action="pizzaAll/${pizza.id}" method="POST" enctype = "multipart/form-data" >
					<div class="menu-pizza">
		
				<div class="photo-pizza">
					<a href="#">
						<img width="300" height="300" border="0" src="<c:url value="resources/img/${pizza.namePhoto}"/>" alt="${pizza.namePhoto}" title="${pizza.namePhoto}"/>
					</a>	
				</div>
						
				<div class="title-pizza">
					<h1>${pizza.name}</h1>
					<hr/>
				</div>
		
				<div class="describe-pizza">
					<h3>COMPOSITION:</h3>
					<p>${pizza.describe}</p>
				</div>
		
		
				<div class="order-pizza">
					<div class="size">
						<h3>${pizza.standart}</h3>
					</div>
					
						<div class="price">
							<h4>${pizza.price}.00 UAH</h4>
						</div>
					
					<div class="number">
						<p>number</p>
						<input type="number" name="count" min="1" max="50" value="1" required/>
					</div>
					
					<div class="addOrder">
						<button type="submit" class="toOrder">To Order</button>
					</div>
				
				</div>
		
	
	
	</div>
				
	</form>
			</c:forEach>	
	
	</div>
<div class="foot">
		<div class="home">
	<a href="${pageContext.request.contextPath}/index">Home</a>
	<a href="${pageContext.request.contextPath}/menuClients">Menu</a>
	<a href="${pageContext.request.contextPath}/contact">Contact</a>
	</div>
	
</div>
</body>
</html>