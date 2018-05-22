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
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/theme.css"">
        <script src="js/funciones.js" type="text/javascript"></script>
        <title>Alta usuario</title>
    </head>

    <body>
        <jsp:include page="vistas/cabecera.jsp" />
        <div class="container">
            <div class="col-rs 12 panel panel-default ">
                <div class="panel-heading">
                    <h2>Alta usuario</h2>
                </div>
                <div class="panel panel-body">
                    <s:form class="form-horizontal" action="altausuario" namespace="/">
                        <s:textfield name="login" label="Usuario"/>
                        <s:textfield name="password" label="Contraseña" />
                        <s:textfield name="password2" label="Repetir contrasenya" />
                        <s:textfield name="nombre" label="Nombre" />
                        <s:textfield name="apellidos" label="Apellidos" />
                        <s:radio  list="{'admin','profesor','estudiante'}" selected="1" name="rol" label="Rol"/>
                        <s:submit class="btn btn-default" value="Enviar"/>
                        <s:url value="http://localhost:8080/Academy/home.jsp" var="urlTag"></s:url>
                        <s:a href="%{urlTag}">Atrás</s:a>
                </s:form>
            </div>
        </div>
    </div>
    <jsp:include page="vistas/pie.jsp" />
</body>
</html>