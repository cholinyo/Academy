<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    
    <%
        String rol = (String) session.getAttribute("rol");
        switch (rol) {
            case "admin":
                break;
            default:
                response.sendRedirect("index.html");
        }
    %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/theme.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
	<script type="text/javascript" src="js/sorttable.js"></script>
</head>
<body>
	<jsp:include page="Vista/cabecera.jsp" />

	<div class="container">
		<div class="panel panel-body">
			<div class="seleccion col-rs-4 panel panel-default">
				<div class="panel-heading">
					<%
						switch (request.getParameter("tipo")) {

						case "estudiante":
						listado_usuarios_pag.jsp	out.println("<h2>Estudiantes introducidos en el sistema </h2>");
							break;
						case "profesor":
							out.println("<h2>Profesores introducidos en el sistema </h2>");
							break;
						}
					%>
				</div>
				<table class="table table-striped sortable">
					<tr>
						<th>Idusuario</th>
						<th>Login</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Rol</th>
						<th>Modifica</th>
						<th>Dar de baja</th>
					</tr>
					<%
						LinkedList<Usuario> lista = ConsultaUsuarios.getUsuariostipo(rol);
						for (int i = 0; i < lista.size(); i++) {
							out.println("<tr>");
							out.println("<td>" + lista.get(i).getIdusuario() + "</td>");
							int id = lista.get(i).getIdusuario();
							out.println("<td>" + lista.get(i).getLogin() + "</td>");
							out.println("<td>" + lista.get(i).getNombre() + "</td>");
							out.println("<td>" + lista.get(i).getApellido() + "</td>");
							out.println("<td>" + lista.get(i).getRol() + "</td>");
							out.println("<td><a href='modifica_usuario.jsp?id=" + id + "'>Modifica</a></td>");
							out.println("<td><a href='baja_usuario?id=" + id + "'>Dar de baja</a></td>");
							out.println("</tr>");
						}
					%>
				</table>
				
			</div>
			<button type="submit" class="btn btn-default"onclick="history.back()">Atrás</button>
		</div>
	</div>

	<jsp:include page="Vista/pie.jsp" />
</body>
</html>