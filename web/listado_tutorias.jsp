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
            case "profesor":
                break;
            default:
                response.sendRedirect("index.html");
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Estudiantes</title>
        <link rel="stylesheet" type="text/css" href="css/theme.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">


    </head>

    <body>
        <h2>Horario actual de Tutorias</h2>
        <table class="table table-striped">
            <th>Id</th>
            <th>Día</th>
            <th>Hora</th>

            <s:iterator value="listatutorias">
                <tr>
                    <td><s:property value="dia"></s:property></td>
                    <td><s:property value="hora"></s:property></td>
                    </tr>            
            </s:iterator>    
        </table>
    </body>
</html>
