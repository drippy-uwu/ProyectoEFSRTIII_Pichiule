<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<nav class="navbar bg-body-tertiary" style="background: linear-gradient(70deg, #2e4a6e, #5c5c6f)">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="${pageContext.request.contextPath}/Index.jsp"  style="color: white;">VIVA SAC</a>
  		</div>
	</nav>
	
	<div style="margin: 50px 0px 0px 50px">
		<p>Usted está logeado como:  <strong>${datosUsu.cliente.nombre} ${datosUsu.cliente.ape_pat}</strong></p>
	</div>
	
	 <div class="container">
        <div class="row">
            <div class="col-md-6">
                <a href="${pageContext.request.contextPath}/cliente/datos.jsp" class="card btn btn-primary">
                    <div class="card-body">
                        <h5 class="card-title">Mis Datos Personales</h5>
                    </div>
                </a>
            </div>
            <div class="col-md-6">
                <a href="${pageContext.request.contextPath}/Reclamo?opcion=lis" class="card btn btn-primary">
                    <div class="card-body">
                        <h5 class="card-title">Reclamos</h5>
                    </div>
                </a>
            </div>
        </div>
    </div>

</body>
</html>