<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- <head>
 Bootstrap CSS
<link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>  -->
<div class="container">
    <div class="col-rs 12 panel panel-default ">
        <div class="panel-heading">
            <h2>Panel de Control Administrador</h2>
        </div>
        <div class="panel panel-body">
            <div class="seleccion col-rs-4 panel panel-default">
                <div class="panel-heading">
                    <h3>Portal Administración Profesor</h3>
                </div>
                <div class="panel-body" >
                    <ul class="list-inline">
                        <li><a href=" <s:url action="listadoasignaturasprofesor" includeParams="get">
                                   <s:param name="idusuario" value="%{#session.idusuario}">                        
                                   </s:param>
                                   <s:param name="login" value="%{#session.login}">                        
                                   </s:param>
                               </s:url>">Ver mis asignaturas</a></li>
                        <li><a href="alta_tutoria.jsp">Crear Tutorias<img src="">
                            </a></li>
                        <li><a href="<s:url action="gestiontutorias" includeParams="get">
                                <s:param name="idusuario" value="%{#session.idusuario}">                        
                                   </s:param>
                                   <s:param name="login" value="%{#session.login}">                        
                                   </s:param>
                                </s:url>"> Gesionar Tutorias</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
