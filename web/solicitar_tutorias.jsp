<%-- 
    Document   : solicitar_tutorias
    Created on : 30-may-2018, 13:37:24
    Author     : vcaruncho
--%>
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
                    <h2>Solicitar tutorias</h2>
                    <table class="table table-striped">
                        <th>Id</th>
                        <th>Id Profesor</th>
                        <th> Profesor</th>
                        <th>Día</th>
                        <th>Hora</th>
                            <s:iterator value="ltutorias">
                            <tr>
                                <td><s:property value="idtutoria"></s:property></td>                       
                                <td><s:property value="idprofesor"></s:property></td>
                                <td><s:property value="nombreprofesor"></s:property></td>
                                <td><s:property value="dia"></s:property></td>
                                <td><s:property value="hora"></s:property></td>
                                <td><a href=" <s:url action="actionsolicitartutoria" includeParams="get">
                                           <s:param name="idasignatura" value="idasignatura">                        
                                           </s:param>
                                           <s:param name="idprofesor" value="idprofesor">                        
                                           </s:param>
                                           <s:param name="idalumno" value="%{#session.idusuario}">                        
                                           </s:param>
                                           <s:param name="dia" value="dia">                        
                                           </s:param>
                                           <s:param name="hora" value="hora">                        
                                           </s:param>
                                       </s:url>">Solicitar tutoria</a></td>                              
                            </tr>
                        </s:iterator>
                    </table>
                </div>
            </div>
        </div>
<jsp:include page="vistas/pie.jsp" />
</body>
</html>


