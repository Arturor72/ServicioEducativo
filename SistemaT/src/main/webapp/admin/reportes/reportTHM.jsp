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
                        Horas trabajadas por tutor por mes
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-md-2">
                          
                        </div>



                        <div class="col-md-4">

                        </div>

                        <div class="col-md-2">
                        </div>
                        <div class="col-md-4">
                              <!-- select fecha y hora-->
                            <div class="form-group">

                                <div class="input-group date" id="fecha_hora_srch"  >
                                    <input  type="text" placeholder="Fecha.." class="form-control" data-date-format="MM/YYYY" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
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


