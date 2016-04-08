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

<span class="check">
<a href="${pageContext.request.contextPath}/adminProduct">Products</a>
</span>

<a href="#">Users</a>


<a href="#">Orders</a>

</header>

<div class="editPageProduct">

<h2>Product edit</h2> 


<h3 class="for-id">ID ${editProduct.id}</h3>



<form action="${editProduct.id}" method="POST" enctype = "multipart/form-data" >
		
		<div class="edit-Photo-Product">
			
		<img src="<c:url value="/resources/img/${editProduct.namePhoto}"/>" alt="${editProduct.namePhoto}" title="${editProduct.namePhoto}"/>
					
		</div>
		<div class="enter-Product-One">
		<label>Name </label><br>
			<input type="text" name="newNameProduct" value="${editProduct.name}" placeholder="new Name" required><br>
			<label>Standard </label><br>
			<input type="text" name="newStandardProduct" value="${editProduct.standart}" placeholder="new standart/size" required><br>
			
			<label>Price </label><br>
			 <input	type="number" name="newPriceProduct" value="${editProduct.price}" required><br>
		</div>
		
		<div class="descriptionProduct">
			<label>Describe:</label><br>
			<textarea class="text-descript" rows="11" cols="50" name="newdescription" placeholder="add Description">${editProduct.describe}</textarea>
		</div>
		
		
		<div class="upload-to-edit" id="uploadFile">
			<h3>new Photo:</h3>
				<input type="file" title="Upload picture" name="pictureArrays"
					accept="image/jpeg,image/jpg,image/gif,image/png">
				<div class="fontMax">
				<h6>Maximum 1Mb</h6>
				</div>
			</div>
		
		
		
		
			
			<div class="for-selects">
			<label>Type </label> 
			
			<select class="for-select" name = "newIdType">
			
		   	 <c:forEach items="${allTyps}" var="type">
		        <option  value="${type.id}"><c:out value="${type.name}" /></option>    
		   	 </c:forEach>	
			</select> 
			</div>
			<br/>
			<p>
			<button type="submit">Save</button>
			</p>
		</form>
		


</div>


</body>
</html>