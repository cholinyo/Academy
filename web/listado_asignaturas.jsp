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
                    <h2>Asignaturas introducidas en el sistema </h2>
                    <table class="table table-striped">
                        <th>Id</th>
                        <th>Asignatura</th>
                        <th>Horario</th>
                        <th>Profesor</th>
                        <th>Estado</th>
                        <th>Editar</th>
                        <th>Matricular</th>
                         <th>Desmatricular</th>
                        <th>Dar de alta</th>
                        <th>Dar de baja</th>
                            <s:iterator value="listaasignaturas">

                            <tr>
                                <td><s:property value="idasignatura"></s:property></td>
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="horario"></s:property></td>
                                <td><s:property value="profesor"></s:property></td>
                                <td><s:property value="estado"></s:property></td>
                                <td><a href=" <s:url action="editaasignaturas" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="profesor" value="profesor">                        
                                           </s:param>
                                       </s:url>">Editar</a></td>
                                <td><a href=" <s:url action="listanomatriculados" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="nombre" value="nombre">                        
                                           </s:param>
                                       </s:url>">Matricular Alumnos</a></td>
                                <td><a href=" <s:url action="listamatriculados" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="nombre" value="nombre">                        
                                           </s:param>
                                       </s:url>">Desmatricular Alumnos</a></td>
                                <td><a href=" <s:url action="activaasignatura" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                       </s:url>">Activa</a></td>
                                <td><a href=" <s:url action="bajaasignatura" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                       </s:url>">Desactiva</a></td>
                            </tr>
                        </s:iterator>    
                    </table>
                    <p>
                        <s:if test="anterior>-1">
                            <s:url action="listadoasignaturas" var="ant">
                                <s:param name="npage">
                                    <s:property value="anterior" />
                                </s:param>
                            </s:url>
                            <a href="<s:property value="#ant" />"><</a>
                        </s:if>
                        <s:else>
                            <
                        </s:else>
                        ...
                        <s:if test="posterior>-1">
                            <s:url action="listadoasignaturas" var="sig">
                                <s:param name="npage">
                                    <s:property value="posterior"/>
                                </s:param>
                            </s:url>
                            <a href="<s:property value="#sig" />">></a>
                        </s:if> 
                        <s:else>
                            >
                        </s:else>
                    </p>
                </div>
            </div>
        </div>
        <jsp:include page="vistas/pie.jsp" />
    </body>
</html>

