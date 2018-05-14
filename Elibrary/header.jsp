<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>

<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
</head>
<body>
<div id="header" >
    <h1> ELibrary</h1>
</div>
<header id="menu-wrapper">
		<nav id="menu" >
			<ul class="topnav">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="admin.jsp">Admin</a></li>
				<li><a href="librarian.jsp">Librarian</a></li>
             </ul>
		</nav>
</header>

	
</body>
</html>