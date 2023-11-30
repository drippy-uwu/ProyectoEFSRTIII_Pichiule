<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body style="background: linear-gradient(to right, #2e4a6e, #5c5c6f); background-size: 100%;">
	
	<% String msg = (String) request.getAttribute("mensaje");
	if (msg != null){ %>
		<%=msg%>
<%} %>

	<div class="d-flex justify-content-center align-items-center container" style="margin-top: 20px">
		<h1 style="color: white;" >VIVA SAC</h1>
	</div>
	<div class="d-flex justify-content-center align-items-center container">
	<form action="login" method="post">
		<div  style="margin: 40px 0px">
			<h2 style="color: white;">Inicie Sesion</h2>
		</div>
		<div>
			<p>
			<label for="txtUsuario" style="color: white;">Usuario </label><br>
			<input class="form-control" type="text" name="txtUsuario" placeholder="Ingrese Usuario">
			</p>
		</div>
		
		<div>
			<p>
			<label for="txtContrasena" style="color: white;">Contrasena </label><br>
			<input class="form-control" type="password" name="txtContrasena" placeholder="Ingrese Contrasena" required="required">
			</p>
		</div>
		<div>
			<button class="btn btn-dark" type="submit" name="opcion" value="ing">Ingresar</button>
		</div>
		<hr>
		<div style="color: white;">
		<!--  <p> ${mensaje}</p>-->	
			<p>Si no tiene usuario, por favor registrarse</p>
			<a href="cliente/registro.jsp">Registrar Usuario</a>
		</div>
	
	</form>
	</div>
</body>
</html>