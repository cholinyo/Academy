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
                    <h2>Asignaturas impartidas por: <%=session.getAttribute("login") %> </h2>
                    <table class="table table-striped">
                        <th>Id</th>
                        <th>Asignatura</th>
                        <th>Horario</th>
                        <th>Estado</th>
                        <th>Alumnos matriculados</th>
                            <s:iterator value="listaasignaturas">
                            <tr>
                                <td><s:property value="idasignatura"></s:property></td>
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="horario"></s:property></td>
                                <td><s:property value="estado"></s:property></td>
                                <td><a href=" <s:url action="editaasignaturas" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="profesor" value="profesor">                        
                                           </s:param>
                                       </s:url>">Ver alumnos</a></td> 
                            
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

