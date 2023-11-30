<%@page import="Model.TipoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Interfaces.TipoDAO"%>
<%@page import="dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos Personales</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%@ include file="../comun/nav.jsp" %>


 <div class="container">
        <h2 style="margin: 20px 0px">Mis Datos</h2>
        <form action="" method="post">
        <div class="row">
              <div class="col-md-3">
        
                    <div class="row g-3 align-items-center mb-3">
                        <div class="col-auto">
                            <label for="txtTipo" class="col-form-label">Tipo Documento</label>
                            <select class="form-select" name="tipo" disabled="disabled" id ="documento">
								<%
									DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                            		TipoDAO dao = fabrica.getTipoDAO();
                            		ArrayList <TipoDTO> listTipo = dao.listarTipo();
                            		out.print("<option value = '-1'>-- Seleccione</option>");
                    	    		for (TipoDTO t:listTipo){
                    	    			out.print("<option value = '"+ t.getId_tipoDoc()+"'>"+ t.getDes_tipoDoc()+"</option>");

                    	    		}
								
	
                    	    		%>
                    	    		<script>document.getElementById("documento").value=${datosUsu.cliente.id_tipoDoc};</script>

							</select>
                        </div>
                    </div>	
                    <div class="row g-3 align-items-center mb-3">
                        <div class="col-auto">
                            <label for="txtNumero" class="col-form-label">Numero Documento</label >
                            <input type="text" name="txtNumero" class="form-control" disabled="disabled"  value="${datosUsu.cliente.num_documento}">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtNombres" class="col-form-label">Nombres</label>
                            <input type="text" name="txtNombres" class="form-control" disabled="disabled" value="${datosUsu.cliente.nombre}">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtApellidoPa" class="col-form-label">Apellido Paterno</label>
                            <input type="text" name="txtApellidoPa" class="form-control" disabled="disabled" value="${datosUsu.cliente.ape_pat}">
                        </div>
                    </div>
                    </div>
                    <div class="col-md-6">
                    
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtApellidoMa" class="col-form-label">Apellido Materno</label>
                            <input type="text" name="txtApellidoMa" class="form-control" disabled="disabled" value="${datosUsu.cliente.ape_mat}">
                        </div>
                    </div>
                    
                    <div class="row g-3 align-items-center">
                        <div class="col-4">
                            <label for="txtFecha" class="col-form-label">Fecha Nacimiento</label>
                            <input type="date" name="txtFecha" class="form-control" disabled="disabled"  value="${datosUsu.cliente.fec_nacimiento}">
                        </div>
                    </div>
                    
                    <div class="row g-3 align-items-center">
                        <div class="col-5">
                            <label for="txtEmail" class="col-form-label">Email</label>
                            <input type="email" name="txtEmail" class="form-control" disabled="disabled" value="${datosUsu.cliente.email}">
                        </div>
                    </div>
                    </div>
                                        </div>
                    
                    </form>
                </div>

</body>
</html>