<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String rol = (String) session.getAttribute("rol");
switch (rol)
{
case "profesor":
	break;
default:
	response.sendRedirect("index.html");
}
%>
	<div class="container">
	<div class="col-rs 12 panel panel-default ">
		<div class="panel-heading">
			<h2>Panel de Control Profesor</h2>
		</div>
		<div class="panel panel-body">
			<div class="seleccion col-rs-4 panel panel-default">
				<div class="panel-heading">
					<h3>Asignaturas</h3>
				</div>
				<div class="panel-body">
					<ul class="list-inline">
						<li><a href="listado_asignaturas_profesor.jsp">Ver mis asignaturas<img
								src=""></a></li>
						<li><a href="alta_tutoria.jsp">Crear Tutorias<img
								src="">
						</a></li>
						<li><a href="gestionartutorias.jsp?idprofesor=<%=session.getAttribute("id_usuario")%>">Gesionar Tutorias<img
								src=""></a></li>
					</ul>
				
				</div>
			</div>
				<div class="seleccion col-rs-4 panel panel-default">
					<jsp:include page="gestion_peticiones_tutoria.jsp" />
			
				</div>
			</div>
		</div>
	</div>
</body>
