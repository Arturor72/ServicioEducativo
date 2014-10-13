<%-- 
    Document   : indexA
    Created on : 14/09/2014, 03:14:23 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/jspf/headerLogin.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">

            <%@include file="../WEB-INF/jspf/asideMenu.jspf" %>
            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Servicio Academico
                    </h1>

                </section>
                <section class="content">







                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <ul class="timeline">

                                        <!-- Por item se fabrican dos li 
                                        uno pertenece a la fecha y el otro
                                        pertenece al contenido del servicio
                                        -->
                                        <!-- timeline time label -->
                                        <li class="time-label">
                                            <span class="bg-red">
                                                10 Feb. 2014
                                            </span>
                                        </li>
                                        <!-- /.timeline-label -->

                                        <!-- timeline item -->
                                        <li>
                                            <!-- timeline icon -->
                                            <i class="fa fa-envelope bg-blue"></i>
                                            <div class="timeline-item">
                                                <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                                                <h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#id1">Servicio 1</a> ...</h3>

                                                <div class="timeline-body panel-collapse collapse in" id="id1">
                                                    ...
                                                    Content goes here
                                                </div>

                                                <div class='timeline-footer'>
                                                    <a class="btn btn-primary btn-xs">...</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="time-label">
                                            <span class="bg-red">
                                                10 Feb. 2014 la fecha de mierda
                                            </span>
                                        </li>
                                        <li>
                                            <!-- timeline icon -->
                                            <i class="fa fa-envelope bg-blue"></i>
                                            <div class="timeline-item">
                                                <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                                                <h3 class="timeline-header"><a data-toggle="collapse" data-parent="#accordion" href="#id2">Servicio 1</a> ...</h3>

                                                <div  class="timeline-body panel-collapse collapse in" id="id2">
                                                    ...
                                                    Content goes here
                                                </div>

                                                <div class='timeline-footer'>
                                                    <a class="btn btn-primary btn-xs">...</a>
                                                </div>
                                            </div>
                                        </li>



                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>

            </aside>
        </div>
        <%@include file="../WEB-INF/jspf/linksfooter.jspf" %>
        <script type="text/javascript">
            $(function() {
                $("#example1").dataTable();
                $('#example2').dataTable({
                    "bPaginate": true,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bSort": true,
                    "bInfo": true,
                    "bAutoWidth": false
                });
            });
        </script>


    </body>
</html>
<%@include file="../WEB-INF/jspf/footerLogin.jspf" %>
<script src="<%= request.getContextPath()%>/js/admin/servicio.js"></script>