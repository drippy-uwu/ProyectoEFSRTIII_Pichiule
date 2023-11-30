<%@page import="dao.DAOFactory"%>
<%@page import="Model.ReclamoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reclamos</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%@ include file="../comun/nav.jsp" %>

	<div class="container">
		<form action="" method="post">
			<div class="my-4">
				<h2 class="ml-10">Listado de reclamos</h2>
				<a href="${pageContext.request.contextPath}/reclamo/registrarReclamo.jsp" class="btn btn-primary">
				Nuevo Reclamo</a>
			</div>
			
			<div class="container">
				<table class="table table-hover">
					<tr>
						<th>Id</th>
						<th>Fecha</th>
						<th>Motivo</th>
						<th>Descripcion del Reclamo</th>
						<th>Accion</th>
					</tr>
						<%
						ArrayList <ReclamoDTO> lstReclamo = (ArrayList<ReclamoDTO>) request.getAttribute("listaReclamos");
						   if (lstReclamo!=null){
							 for(ReclamoDTO x : lstReclamo){
						%>
					<tr>
						<td><%=x.getId_reclamo()%></td>
						<td><%=x.getFec_reclamo()%></td>
						<td><%=x.getDes_motivo()%></td>
						<td><%=x.getDes_reclamo()%></td>
						<td>
							<a href="${pageContext.request.contextPath}/Reclamo?opcion=bus&cod=<%=x.getId_reclamo()%>" class="btn btn-info">Actualizar</a> | 
							<a href="${pageContext.request.contextPath}/Reclamo?opcion=eli&cod=<%=x.getId_reclamo()%>" class="btn btn-secondary">Eliminar</a>
						</td>
					</tr>
					<%	
				 } }
					 
						   
			%>
			
				</table>
			</div>
		</form>	
	</div>
</body>
</html>