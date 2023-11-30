<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bienvenido</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
	<% String msg = (String) request.getAttribute("mensaje");
	if (msg != null) {%>
	<%=msg%>
	<%} %>
<%@ include file="../comun/nav.jsp" %>
    <h5 style="text-align: center; margin-top: 150px; font-size: xxx-large;">B I E N V E N I D O</h5>

</body>
</html>