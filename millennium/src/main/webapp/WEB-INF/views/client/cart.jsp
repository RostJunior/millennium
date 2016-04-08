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

<title>Millennium | Order</title>
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

<div>
			<div class="slider_cart">
			
			
			</div>
			
	<c:if test="${'error' eq param.newCarts}">
		<h1 style="color: red">YOUR SHOPPING CART IS EMPRTY!</h1>
	</c:if>

<div>
	<h1>Basket</h1>
	
</div>

<form action="${pageContext.request.contextPath}/orderNew" method="POST">

<table class="cart-table">
	<thead>
			<tr>
				<th class="basketImg">Photo</th>
				<th>Product</th>
				<th>Type</th>
				<th>Count</th>
				<th>Price</th>
				<th>Total</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

<c:forEach items="${cart}" var="cart">
<tr>
					<td class="basketImg">
					<img src="<c:url value="/resources/img/${cart.product.namePhoto}"/>" alt="${cart.product.namePhoto}" title="${cart.product.namePhoto}"/>
					</td>
					<td>${cart.product.name} </td>
					<td>${cart.product.type.name}</td>
					<td>${cart.count}</td>
					<td>${cart.product.price} UAH</td>
					<td>${cart.totalPrice} UAH</td>
					<td><a href="deleteCart/${cart.idTemp}" title="delete">X</a></td>
										
				</tr>

	<div>
	
	
	<h2> ${cart}</h2>
	
	
	</div>


</c:forEach>
</tbody>
   
   </table>
   <div class="cartnull">${cartNull}</div>
	<h1 class="total"> The total purchase amount:  ${total} UAH</h1>
	
	<button class="but-order">Make an ORDER</button>
	
	</form>
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