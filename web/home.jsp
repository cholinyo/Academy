<%-- 
    Document   : home
    Created on : 29-abr-2018, 10:57:46
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
        <h1>Hello World!</h1>
        <s:property value="usuario"/>
        <%
         out.println(session.getAttribute("rol"));
        %>
    </body>
</html>
