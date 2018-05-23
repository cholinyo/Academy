<%-- 
    Document   : listado_usuarios_rol.jsp
    Created on : 19-may-2018, 13:00:53
    Author     : vcaruncho
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <h2>Estudiantes introducidos en el sistema </h2>
        <table>
            <th>Id</th>
            <th>Usuario</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Baja</th>
            <s:iterator value="listaestudiantes">
                
                <tr>
                <td><s:property value="idusuario"></s:property></td>
                <td><s:property value="login"></s:property></td>
                <td><s:property value="nombre"></s:property></td>
                <td><s:property value="apellidos"></s:property></td>
                <td><s:property value="baja"></s:property></td>
                <td><a href="<s:url action="edicion_usuario.jsp" ><s:param name="idusuario"><s:property value="#idusuario"/></s:param></s:url>  />  ">Editar</a></td>
                </tr>
            </s:iterator>    
        </table>
        <p>
            <s:if test="anterior>-1">
                <s:url action="listadoestudiantes" var="ant">
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
                        <s:url action="listadoestudiantes" var="sig">
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
    </body>
</html>
