<%@page import="Model.ClienteDTO"%>
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
	<title>Registrar Cliente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	
</head>
<body>
<%
String msg = (String)request.getAttribute("mensaje"); 
	if (msg==null) msg="";

	ClienteDTO cli = (ClienteDTO)request.getAttribute("cliente");
//<%=msg%> 

<body style="background: linear-gradient(to left, #2e4a6e, #5c5c6f); background-size: 100%; color: white;">
<div class="container">
        <h2 style="margin: 20px 0px">Registro de Clientes</h2>
        <form action="${pageContext.request.contextPath}/RegistrarCliente" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="row g-3 align-items-center mb-3">
                        <div class="col-auto">
                            <label for="tipo" class="col-form-label">Tipo Documento</label>
							<select class="form-select" name="tipo">
								<%
									DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                            		TipoDAO dao = fabrica.getTipoDAO();
                            		ArrayList <TipoDTO> listTipo = dao.listarTipo();
                            		out.print("<option value = '-1'>-- Seleccione</option>");
                    	    		for (TipoDTO t:listTipo){
                    	    			out.print("<option value = '"+ t.getId_tipoDoc()+"'>"+ t.getDes_tipoDoc()+"</option>");

                    	    		}
								
								%>
							</select>
                        </div>
                    </div>	
                    <div class="row g-3 align-items-center mb-3">
                        <div class="col-auto">
                            <label for="txtNumero" class="col-form-label">Numero Documento</label >
                            <input type="text" name="txtNumero" class="form-control" required="required">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtNombres" class="col-form-label">Nombres</label>
                            <input type="text" name="txtNombres" class="form-control">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtApellidoPa" class="col-form-label">Apellido Paterno</label>
                            <input type="text" name="txtApellidoPa" class="form-control">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtApellidoMa" class="col-form-label">Apellido Materno</label>
                            <input type="text" name="txtApellidoMa" class="form-control">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtFecha" class="col-form-label">Fecha Nacimiento</label>
                            <input type="date" name="txtFecha" class="form-control">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtEmail" class="col-form-label">Email</label>
                            <input type="email" name="txtEmail" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <h2>Datos Usuario</h2>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtUsuario" class="col-form-label">Usuario</label>
                            <input type="text" name="txtUsuario" class="form-control">
                        </div>
                    </div>
                    <div class="row g-3 align-items-center">
                        <div class="col-auto">
                            <label for="txtContrasena" class="col-form-label">Contraseña</label>
                            <input type="password" name="txtContrasena" class="form-control" required="required">
                        </div>
                    </div>
                    <div class="row mt-3">
		                <div class="col-md-12">
		                    <button type="submit" class="btn btn-primary" name="opcion" value="reg">Registrar</button>
		                     <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Login.jsp">Cancelar</a>	
		                </div>
            		</div>
                </div>
            </div>
            
        </form>
    </div>
</body>

</body>
</html>