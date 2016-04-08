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

<title>adminProducts</title>
</head>
<body>
<header class="adminHead">

<span class="check">
<a href="${pageContext.request.contextPath}/adminProduct">Products</a>
</span>

<a href="${pageContext.request.contextPath}/adminUsers">Users</a>


<a href="#">Orders</a>

</header>

<div class="tableAll">
	

<table class="tableShowProduct">
	
		
		<thead>
			<tr>
				<th> ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Type</th>
				<th>Describe</th>
				<th>Stand.</th>
				<th>Photo</th>
				
				<th></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${productList}" var="prod">
				<tr>
				
				
					<td>${prod.id} </td>
					<td>${prod.name}</td>
					<td>${prod.price}</td>
					<td>${prod.type.name}</td>
					<td>${prod.standart}</td>
					<td class="description">${prod.describe}</td>
					<td class="photoTable">
					
					
					<img src="<c:url value="/resources/img/${prod.namePhoto}"/>" alt="${prod.namePhoto}" title="${prod.namePhoto}"/>
					</td>
										
					<td class="deleteprod"><a href="deleteProduct/${prod.id}">Delete</a></td>
					
					<td class="editdelprod"><a href="editProduct/${prod.id}">Edit</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
<div class="newproduct">	
<a href="adminNewProduct">addProduct</a>

</div>
</div>

<div class="tableTypes">


<table class="typsTable">
		<thead>
			<tr>
					<th height="35px" width="140px"> ID</th>
				<th height="35px" width="140px">Type</th>
				<th height="35px" width="140px"></th>
			</tr>
		</thead>
		
		<tbody>
				
			<c:forEach items="${typeList}" var="type">
				<tr>
					<td width="140px" align="center">${type.id} </td>
					<td width="140px" align="center">${type.name}</td>
					<td><a href="deleteType/${type.id}">delete</a></td>
										
				</tr>
			</c:forEach>
		</tbody>
		
		
	</table>
	<br/>
<div class="newtype">
<form action="newType" method="POST">	
		<label>Type</label><br>
			<input type="text" name="nameType" value="new Type" placeholder="new Type" required><br>
			<p><button type="submit">Save</button></p>
	
	</form>	
	
	</div>	
</div>

<div class="foot">
		<div class="home">
	<a href="${pageContext.request.contextPath}/index">Home</a>
	<a href="${pageContext.request.contextPath}/adminList">Administration</a>
	
	</div>
	
</div>
</body>
</html>