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


<title>Kitchen</title>
</head>
<body>
<header>
				
			<div>
			<h1>Millennium Kitchen</h1>
			</div>
			
</header>
<div class="kit-all">
<div class="kit-img">
<img alt="kitchen" src="<c:url value="/resources/img/syroedenie3.jpg"/>">
</div>
<h2>Orders:</h2>

<h3>
<a href="kitchenListWait">WAIT</a>
</h3>

<h3>
<a href="kitchenListDone">DONE</a>
</h3>

</div>

	<div class="home">
	<a href="index">Home</a>
	</div>
</html>