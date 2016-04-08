<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>


<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	
	<link href="<c:url value="https://fonts.googleapis.com/css?family=Playfair+Display:900italic"/>" rel='stylesheet' type='text/css'>

<title>Insert title here</title>
</head>
<body>
<header class="adminHead">
<a href="${pageContext.request.contextPath}/adminProduct">Products</a>

<a href="${pageContext.request.contextPath}/adminUsers">Users</a>

<a href="#">Orders</a>
</header>
<div>

<h2>Add Product</h2>
<div class="addProduct">
<form action="newProduct" method="POST" enctype = "multipart/form-data" >
		<div class="enterProductOne">
		<label>Name </label><br>
			<input type="text" name="nameProduct" value="name" placeholder="new Name" required><br>
			
			<label>Price </label><br>
			 <input	type="number" name="priceProduct" value="0" required min="0"><br>
			<label>Standard</label><br>
			 <input	type="text" name="standardProduct" value="stand/size" required ><br>
		
		
		</div>
		<div class="descriptionProduct">
			<label>Describe:</label><br>
			<textarea class="text-descript" rows="11" cols="50" name="description" placeholder="add Description"></textarea>
		</div>
			<div class="upload" id="uploadFile">
			
				<input type="file" title="Upload picture" name="pictureArray"
					accept="image/jpeg,image/jpg,image/gif,image/png"><br>
				<div class="fontMax">
				<p>Maximum image size 1Mb</p>
				</div>
			</div>
			<div >
			<label>Type </label> 
			
			<select class="forselects" name = "idType">
			
		   	 <c:forEach items="${typeList}" var="type">
		        <option  value="${type.id}"><c:out value="${type.name}" /></option>    
		   	 </c:forEach>
			</select> 
			</div>
			<br/>
			<p>
			<button type="submit">Add Product</button>
			</p>
		</form>
		
</div>		


</div>


</body>
</html>