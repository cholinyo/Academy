<%-- 
    Document   : listado_peticion_tutorias
    Created on : 30-may-2018, 18:08:35
    Author     : vcaruncho
--%>

<%-- 
    Document   : listado_usuarios_rol.jsp
    Created on : 19-may-2018, 13:00:53
    Author     : vcaruncho
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String rol = (String) session.getAttribute("rol");
        switch (rol) {
            case "estudiante":
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estado Peticiones realizadas</title>
        <link rel="stylesheet" type="text/css" href="css/theme.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">


    </head>

    <jsp:include page="vistas/cabecera.jsp" />
        <div class="container">
            <div class="col-rs 12 panel panel-default ">
                <button type="submit" class="btn btn-default"onclick="location.href = 'home.jsp'">Atrás</button>
                <div class="panel-heading">
                    <h2>Estado petición tutorias realizadas </h2>
        <table class="table table-striped">
            
            <th>Id</th>
            <th>Profesor</th>
            <th>Día</th>
            <th>Hora</th>
            <th>Estado</th>
            <s:iterator value="listapeticiones">
                <tr>
                    <td><s:property value="idtutoria"></s:property></td>
                    <td><s:property value="idprofesor"></s:property></td>
                    <td><s:property value="dia"></s:property></td>
                    <td><s:property value="hora"></s:property></td>
                    <td><s:property value="estado"></s:property></td>
                    </tr>            
            </s:iterator>    
        </table>
                    </div>
            </div>
        </div>
        <jsp:include page="vistas/pie.jsp" />
    </body>
</html>
