<%-- 
    Document   : matriculas
    Created on : 29-may-2018, 12:20:29
    Author     : vcaruncho
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Estudiante</title>
        <link rel="stylesheet" type="text/css" href="css/theme.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="vistas/cabecera.jsp" />
        <div class="container">
            <div class="col-rs 12 panel panel-default ">
                <button type="submit" class="btn btn-default"onclick="location.href = 'home.jsp'">Atrás</button>
                <div class="panel-heading">
                    <h2>Listado de alumnos que se pueden matricular en  <s:property value="nombre"/></h2>
                    <ul>
                        <li>cod:<s:property value="idasignatura"/></li></ul>
                    <table class="table table-striped">
                        <th>Id</th>
                        <th>Login</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Matricular</th>
                            <s:iterator value="listamatriculados">
                            <tr>
                                <td><s:property value="idusuario"></s:property></td>
                                <td><s:property value="login"></s:property></td>
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="apellidos"></s:property></td>
                                 <td><a href=" <s:url action="matricula" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="idusuario" value="idusuario">                        
                                           </s:param>
                                       </s:url>">Matricula</a></td>
                            </tr>
                        </s:iterator>    
                    </table>
                    </p>
                </div>
            </div>
        </div>
        <jsp:include page="vistas/pie.jsp" />

    </body>
</html>
