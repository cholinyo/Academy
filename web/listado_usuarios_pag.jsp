<%-- 
    Document   : index
    Created on : 27-abr-2018, 19:02:54
    Author     : vcaruncho
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    if (session.getAttribute("login") == null) {
        response.sendRedirect("index.html");
    }
    String nombre = (String) session.getAttribute("nombre");
    String rol = (String) session.getAttribute("rol");
    
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
	<jsp:include page="vistas/cabecera.jsp" />

	<div class="container">
		<div class="panel panel-body">
			<div class="seleccion col-rs-4 panel panel-default">
				<div class="panel-heading">
					<%
						switch (rol) {

						case "admin":
							out.println("<h2>Estudiantes introducidos en el sistema </h2>");
							%>
                                                        <s:action name="listadoestudiantes" executeResult="true"/>
                                                        <%
                                                        break;
						case "profesor":
							out.println("<h2>Profesores introducidos en el sistema </h2>");
                                                        %>
                                                        <s:action name="listado_usuarios" executeResult="true"/>
							<%
                                                        break;
						}
                                                %>
				</div>

	<jsp:include page="vistas/pie.jsp" />
</body>
</html>