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
                    <h2>Edición usuario</h2>
                    <button type="submit" class="btn btn-default"onclick="location.href = 'home.jsp'">Atrás</button>
                </div>
                <div class="panel panel-body">
                    <s:set name="id" value="usuario.getIdusuario()"/>
                    <s:set name="login" value="usuario.getLogin()"/>
                    <s:set name="nombre" value="usuario.getNombre()"/>
                    <s:set name="apellidos" value="usuario.getApellidos()"/>
                    <s:set name="baja" value="usuario.getBaja()"/>
                    <s:form class="form-horizontal" action="modificausuario" namespace="/">
                        <s:textfield name="idusuario" label="Idusuario" placeholder="%{#id}" readonly="true"/>
                        <s:textfield name="login" label="Usuario" placeholder="%{#login}"/>
                        <s:textfield name="nombre" label="Nombre" placeholder="%{#nombre}"/>
                        <s:textfield name="apellidos" label="Apellidos" placeholder="%{#apellidos}"/>
                        <s:textfield name="baja" label="Baja" placeholder="%{#estado}" readonly="true"/>
                        <s:submit class="btn btn-default" value="Enviar"/>
                        <s:url value="http://localhost:8080/Academy/home.jsp" var="urlTag"></s:url>
                    </s:form>
                </div>
            </div>
        </div>

    </body>
</html>
