<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>


<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	
	<link href="<c:url value="https://fonts.googleapis.com/css?family=Playfair+Display:900italic"/>" rel='stylesheet' type='text/css'>


<title>Kitchen Order</title>
</head>
<body>
<div>
<h1>Order №: ${numberOrder}</h1>
</div>
<table>
<thead>
			<tr>
				<th class="basketImg">Photo</th>
				<th>Product</th>
				<th>Describe</th>
				<th>Type</th>
				<th>Count</th>
				<th>Total</th>
				
			</tr>
		</thead>
<tbody>
<c:forEach items="${orderCart}" var="cart">
	<tr>
					<td class="basketImg">
					<img src="<c:url value="/resources/img/${cart.product.namePhoto}"/>" alt="${cart.product.namePhoto}" title="${cart.product.namePhoto}"/>
					</td>
					<td>${cart.product.name} </td>
					<td>${cart.product.type.name}</td>
					<td>${cart.product.describe} </td>
					<td>${cart.count}</td>
					<td>${cart.totalPrice} UAH</td>
					
										
	</tr>
</c:forEach>

</tbody>
</table>
<div>
<a href="${pageContext.request.contextPath}/confirm/${numberOrder}">confirm</a></div>
</body>
</html>