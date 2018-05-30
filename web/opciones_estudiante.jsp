<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String rol = (String) session.getAttribute("rol");
    switch (rol) {
        case "estudiante":
            break;
        default:
            response.sendRedirect("index.html");
    }
%>
<div class="container">
    <div class="col-rs 12 panel panel-default ">
        <div class="panel-heading">
            <h2>Panel de Control Estudiante</h2>
        </div>
        <div class="panel panel-body">
            <div class="seleccion col-rs-4 panel panel-default">
                <div class="panel-heading">
                    <h3>Asignaturas</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-inline">
                        <li><a href="<s:url action="listadoasignaturasalumno" includeParams="get">
                               <s:param name="idusuario" value="idusuario">                        
                                </s:param>
                                <s:param name="login" value="%{#session.login}">                        
                                </s:param>
                                </s:url>">Ver mis asignaturas</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
