<%-- 
    Document   : alta_tutoria
    Created on : 29-may-2018, 21:46:39
    Author     : vcaruncho
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <%
        String rol = (String) session.getAttribute("rol");
        switch (rol) {
            case "profesor":
                break;
            default:
                response.sendRedirect("index.jsp");
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
        <title>Alta tutorias</title>
    </head>

    <body>
        <jsp:include page="vistas/cabecera.jsp" />
        <div class="container">
            <div class="col-rs 12 panel panel-default ">
                <div class="panel-heading">
                    <h2>Alta tutorias del profesor <%=session.getAttribute("login")%></h2>
                    <li><%=session.getAttribute("idusuario")%></li>
                    <button type="submit" class="btn btn-default"onclick="location.href = 'home.jsp'">Atrás</button>
                </div>
                <div class="panel panel-body">
                    <s:form class="form-horizontal" action="altatutoria" namespace="/">
                        <s:radio  list="{'lunes','martes','miercoles','jueves','viernes'}" selected="1" name="dia" label="Dia"/>
                        <s:textfield name="hora" label="Hora" maxLength="2" />
                        <s:hidden name="idusuario" value="%{#session.idusuario}" />
                        <s:submit class="btn btn-default" value="Crear"/>
                        <s:url value="http://localhost:8080/Academy/home.jsp" var="urlTag"></s:url>
                    </s:form>
                </div>
            </div>
        </div>
        <jsp:include page="vistas/pie.jsp" />
    </body>
</html>