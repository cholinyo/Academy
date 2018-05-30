<%-- 
    Document   : asignaturas_matriculado
    Created on : 30-may-2018, 12:51:23
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
                    <h2>Asignaturas en las que estás matriculado</h2>
                    <table class="table table-striped">
                        <th>Id</th>
                        <th>Asignatura</th>
                        <th>Horario</th>
                        <th>Profesor</th>
                        <th>Solicitar tutoria</th>
                        <th>Dar de baja</th>
                            <s:iterator value="listamatriculadas">

                            <tr>
                                <td><s:property value="idasignatura"></s:property></td>
                                <td><s:property value="nombre"></s:property></td>
                                <td><s:property value="horario"></s:property></td>
                                <td><s:property value="profesor"></s:property></td>
                                <td><a href=" <s:url action="solicitartutoria" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="profesor" value="profesor">                        
                                           </s:param>
                                       </s:url>">Solicitar tutoria</a></td>                              
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


