<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Elibrary</title>
<link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
<%@ include file="headernavlibrarian.jsp" %> 
</head>
<body style="background-image:url(images/admin2.jpg)">
<%
		if (session != null) {
			if (session.getAttribute("email") != null) {
				String name = (String) session.getAttribute("email");
				
			} else {
				response.sendRedirect("index.jsp");
			}
		}
	%>
</body>
</html>