<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/jspf/headerLoginTutor.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../../WEB-INF/jspf/headerT.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                        </div>
                        <div class="pull-left info">
                            <p>[NOMBRE TUTOR]</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Conectado(a)</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li >
                            <a href="../indexT.html">
                                <i class="fa fa-dashboard"></i> <span>Servicio Académico</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Gestion Alumnos</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="../ralumnos/AlumnoQry.jsp"><i class="fa fa-angle-double-right"></i> Alumnos</a></li>
                            </ul>
                        </li>
                        <li class="">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Reportes</span>
                            </a>
                        </li>

                    </ul>
                </section>

            </aside>

            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Gestión de Alumnos
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Alumnos</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nombre</th>
                                                <th>Apellidos</th>
                                                <th class="mrc"> <a href=""><img src="../../img/suspender.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Julio</td>
                                                <td>Carranza</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Fernando</td>
                                                <td>Tupac Yupanqui</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Allison</td>
                                                <td>Arana</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Claudia</td>
                                                <td>Marchand </td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                </section>

            </aside>
        </div>



        <%@include file="../../WEB-INF/jspf/linksfooter.jspf" %>
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
        <%@include file="../../WEB-INF/jspf/footerLoginTutor.jspf" %>

    </body>
</html>