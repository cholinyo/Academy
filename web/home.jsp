<%--
    Document   : home
    Created on : 29-abr-2018, 10:57:46
    Author     : vcaruncho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    if (session.getAttribute("login") == null) {
        response.sendRedirect("index.jsp");
    }
    String nombre = (String) session.getAttribute("nombre");
%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Zona Privada</title>
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">
</head>

<jsp:include page="vistas/cabecera.jsp" />
<s:set name="rol" value="#session.rol"/>
<s:if test="%{#rol=='admin'}">
    <jsp:include page="opciones_admin.jsp" />
</s:if>
<s:elseif test="%{#rol=='profesor'}">
    <jsp:include page="opciones_profesor.jsp" /> 
</s:elseif>
<s:elseif test="%{#rol=='estudiante'}">
    <jsp:include page="opciones_estudiante.jsp" /> 
</s:elseif>

<jsp:include page="vistas/pie.jsp" />
</html>