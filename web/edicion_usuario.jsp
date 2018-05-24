<%-- 
    Document   : edicion_usuario
    Created on : 22-may-2018, 21:24:58
    Author     : vcaruncho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1>Edicion usuario</h1>
        <s:form class="form-horizontal" action="modificausuario" namespace="/">
            <s:textfield name="login" label="Usuario" placeholder="%{#user.login}"></s:textfield></s:form>
        <h2><s:property value="usuario.idusuario" /></h2>         
    </body>
</html>
