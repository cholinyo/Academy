<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- <head>
 Bootstrap CSS
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>  -->
	<div class="container">
		<div class="col-rs 12 panel panel-default ">
			<div class="panel-heading">
				<h2>Panel de Control Administrador</h2>
			</div>
			<div class="panel panel-body">
				<div class="seleccion col-rs-4 panel panel-default">
					<div class="panel-heading">
						<h3>Usuarios</h3>
					</div>
					<div class="panel-body">
						<ul class="list-inline">
							<li><a href="alta_usuario.jsp">Altas usuarios<img src=""></a></li>
                                                        <li><a href="<s:url action="listadoestudiantes"  />">Gestion de Alumnos<img src="">
							</a></li>
							<li><a href="listado_usuarios.jsp?tipo=profesor">Gestion
									de Profesores<img src="">
							</a></li>
						</ul>
					</div>
				</div>
				<div class="seleccion col-rs-4 panel panel-default">
					<div class="panel-heading">
						<h3>Asignaturas</h3>
					</div>
					<div class="panel-body">
						<ul class="list-inline">
							<li><a href="alta_asingatura.jsp">Altas Asignaturas<img
									src=""></a></li>
							<li><a href="gestionasignaturas.jsp">Gestion de
									Asignaturas<img src="">
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>
<!--
</body> -->