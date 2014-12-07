<%-- 
    Document   : indexA
    Created on : 14/09/2014, 03:14:23 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/jspf/headerLogin.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../../WEB-INF/jspf/links.jspf" %>

    </head>
    <body class="skin-blue">
        <%@include file="../../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">

            <%@include file="../../WEB-INF/jspf/asideMenu.jspf" %>
            <aside class="right-side">
                <section class="content-header">
                    <h1>
                       
                        Tutores que dictaron los cursos
                    </h1>

                </section>
                <section class="content">
                    <div class="row">

                       <div class="col-md-6">
                            <div class="form-group">
                                <select name="cursoTC" id="cursoTC" class="form-control"  >
                                    <option value="0">Curso</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <select name="servicio_ins" id="servicio_ins" class="form-control" >
                                    <option value="0" selected>Tipo de servicio</option>
                                    <option value="1">Taller</option>
                                    <option value="2">Tutoria</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <button class="btn btn-primary btn btn-block" onclick="selectServicio()">Ver</button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">

                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">

                                    <ul class="timeline" id="servicio">

                                        <!--Contenido de los servicios-->
                                    </ul>
                                    <div class="row">
                                        <div id="alerta" class="col-md-12">

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>

            </aside>
        </div>
        <%@include file="../../WEB-INF/jspf/linksfooter.jspf" %>



    </body>
</html>

<%@include file="../../WEB-INF/jspf/footerLogin.jspf" %>




<script src="<%= request.getContextPath()%>/js/admin/reporte.js"></script>


