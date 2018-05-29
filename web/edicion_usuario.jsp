<%-- 
    Document   : edicion_usuario
    Created on : 22-may-2018, 21:24:58
    Author     : vcaruncho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
        <title>Edicion usuario</title>
        <link rel="stylesheet" type="text/css" href="css/theme.css">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet"
                  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
                  integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
                  crossorigin="anonymous">
        
    </head> 
             <s:action name="datosusario" executeResult="true"/>
</html>
