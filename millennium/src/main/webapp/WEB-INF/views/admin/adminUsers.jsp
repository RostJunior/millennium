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


<title>Users</title>
</head>
<body>

<header class="adminHead">


<a href="${pageContext.request.contextPath}/adminProduct">Products</a>

<span class="check">
<a href="${pageContext.request.contextPath}/adminUsers">Users</a>
</span>

<a href="#">Orders</a>

</header>

<div>
 

	<h1>
		Users:
	</h1>

<table class="tableShowUser">
	
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Login</th>
				<th>Password</th>
				<th>Role</th>
				
				<th></th>
				
				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${userList}" var="user">
				<tr>
				
				
					<td>${user.idUser} </td>
					<td>${user.nameUser}</td>
					<td>${user.emailUser}</td>
					<td>${user.telephoneUser}</td>
					<td>${user.loginUser}</td>
					<td>${user.passwordUser}</td>
					<td>${user.roleUser.name}</td>
					<td class="deleteprod"><a href="deleteUser/${user.idUser}">Delete</a></td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>



<div class="addProduct">
<h2>Add User</h2>
<form action="newUser" method="POST" enctype = "multipart/form-data" >
		<div class="enterProductOne">
		
			<label>Name: </label><br>
			<input type="text" name="nameUser" value="name" placeholder="new Name" required><br>
			
			<label>Email:</label><br>
			 <input type="text" name="emailUser" value="email" placeholder="email@**.**" required><br>
			<label>Telephone:</label><br>
			 <input type="text" name="telephoneUser" value="telephone" placeholder="new Telephone" required><br>
			<label>Login:</label><br>
			<input type="text" name="loginUser" value="login" placeholder="new Login" required><br>
			<label>Password:</label><br>
			<input type="text" name="passwordUser" value="password" placeholder="new Password" required><br>
			
		
		</div>
					
			<div >
			<label>Role: </label> 
			
			<select class="forselects" name = "idRole">
			
		   	 <c:forEach items="${roleList}" var="role">
		        <option  value="${role.id}"><c:out value="${role.name}" /></option>    
		   	 </c:forEach>
			</select> 
			</div>
			<br/>
			<p>
			<button type="submit">Add User</button>
			</p>
		</form>
		
</div>		
<div class="foot">
		<div class="home">
	<a href="${pageContext.request.contextPath}/index">Home</a>
	<a href="${pageContext.request.contextPath}/adminList">Administration</a>
	
	</div>
	
</div>

</body>
</html>