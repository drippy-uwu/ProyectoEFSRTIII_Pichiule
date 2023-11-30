<%@page import="Interfaces.MotivoDAO"%>
<%@page import="Model.MotivoDTO"%>
<%@page import="Model.ReclamoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Interfaces.ReclamoDAO"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Reclamo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<% String msg = (String) request.getAttribute("mensaje");
if (msg != null) {%>
<%=msg%>
<%} %>
<%@ include file="../comun/nav.jsp" %>

 	<div class="container">
 		<form action="${pageContext.request.contextPath}/Reclamo"  method="post">
 		<br>
 			<div>
 				<h2>Nuevo Reclamo</h2>
 			</div>
 			<div class="row g-3 align-items-center mb-3">
           		<div class="col-auto">
                	<label for="txtMotivo" class="col-form-label">Motivo</label>
                   	<select class="form-select" name="motivo">
                   		<%
                    		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                			MotivoDAO dao = fabrica.getMotivoDAO();
                			ArrayList<MotivoDTO> listMotivo = dao.listarMotivo();
                    		out.print("<option value = '-1'>-- Seleccione</option>");
							for (MotivoDTO m:listMotivo){
								out.print("<option value = '"+ m.getId_motivo()+"'>"+m.getDes_motivo()+"</option>");
							}
								
						%>
                  
                   		
                   	</select>
               	</div>
           	</div>	
            <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                	<label for="txtFechaReclamo" class="col-form-label">Fecha Reclamo</label >
                    <input type="date" name="txtFechaReclamo" class="form-control">
               	</div>
           	</div>
           	<div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                	<label for="txtDescripcion" class="col-form-label">Descripcion Reclamo</label >
                   	<textarea name="txtDescripcion" class="form-control" ></textarea>
               	</div>
           	</div>
           	<div class="row mt-3">
		                <div class="col-md-12">
		                    <button type="submit" class="btn btn-primary" name="opcion" value="reg">Registrar</button>
		                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Reclamo?opcion=lis" >Cancelar</a>		                </div>
            		</div>
 		</form>
 	</div>

</body>
</html>