<%-- 
    Document   : modifica_asignatura
    Created on : 29-may-2018, 10:28:56
    Author     : vcaruncho
--%>

<%-- 
    Document   : datos_usuario
    Created on : 28-may-2018, 17:44:34
    Author     : vcaruncho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
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
        <title>Edicion Usuarios</title>
            <link rel="stylesheet" type="text/css" href="css/theme.css">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet"
                  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
                  integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
                  crossorigin="anonymous">
    </head>
    <body> <jsp:include page="vistas/cabecera.jsp" />
        <div class="container">
            <div class="col-rs 12 panel panel-default ">
                <div class="panel-heading">
                    <h2>Modifica Asignatura</h2>
                    <button type="submit" class="btn btn-default"onclick="location.href = 'home.jsp'">Atrás</button>
                </div>
                <div class="panel panel-body">
                    <s:set name="idasignatura" value="asignatura.getIdasignatura()"/>
                    <s:set name="nombre" value="asignatura.getNombre()"/>
                    <s:set name="horario" value="asignatura.getHorario()"/>
                    <s:set name="profesor" value="asignatura.getProfesor()"/>
                    <s:form class="form-horizontal" action="modificaasignatura" namespace="/">
                        <s:textfield name="idasignatura" label="Idusuario" placeholder="%{#idasignatura}" readonly="true"/>
                        <s:textfield name="nombre" label="Usuario" placeholder="%{#nombre}"/>
                        <s:textfield name="horario" label="Nombre" placeholder="%{#horario}"/>
                        <s:textfield name="profesor" label="Profesor" placeholder="%{#profesor}" readonly="true" />
                        <s:submit class="btn btn-default" value="Enviar"/>
                        <s:url value="http://localhost:8080/Academy/home.jsp" var="urlTag"></s:url>
                    </s:form>
                </div>
            </div>
        </div>

    </body>
</html>

