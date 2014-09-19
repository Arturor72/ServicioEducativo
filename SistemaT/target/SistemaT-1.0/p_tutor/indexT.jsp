<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../WEB-INF/jspf/headerT.jspf" %>
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
                        <li class="active">
                            <a href="indexT.html">
                                <i class="fa fa-dashboard"></i> <span>Servicio Académico</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Gestion Alumnos</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="ralumnos/AlumnoQry.jsp"><i class="fa fa-angle-double-right"></i> Alumnos</a></li>
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
                        Servicio Académico
                    </h1>

                </section>
                <section class="content">
                    <!-- Main row -->
                    <div class="row">

                        <section class="col-xs-12 ">
                            <div class="box box-solid box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">[Nombre de Curso]</h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-primary btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="box box-solid">
                                                <div class="box-header">
                                                </div><!-- /.box-header -->
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="col-md-8">
                                                            <p> <h4>  [SEDE] : NUEVA SEDE</h4> </p>
                                                            <p> <h4>  [AULA] : 204 - A</h4></p>
                                                            <p> <h4>  [HORA] : 12:30 p.md. </h4></p>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <p> <h5>  [Descripcion]</h5></p>
                                                        </div>
                                                    </div><!-- /.row -->
                                                </div>
                                            </div><!-- /.box -->
                                        </div><!-- ./col -->
                                    </div><!-- /.row -->
                                    <div class="row">
                                        <div class="col-xs-8"> 
                                            <button class="btn btn-primary">Registrar Alumnos</button>
                                        </div> 
                                        <div class="col-xs-4"> 
                                            <button class="btn btn-danger" style="margin-left:">Asistir</button>
                                        </div>

                                    </div> 

                                </div><!-- /.box-body -->
                            </div>
                        </section>


                        <section class="content">
                            <!-- Main row -->
                            <div class="row">

                                <section class="col-xs-12 ">
                                    <div class="box box-solid box-primary">
                                        <div class="box-header">
                                            <h3 class="box-title">[Nombre de Tutoria]</h3>
                                            <div class="box-tools pull-right">
                                                <button class="btn btn-primary btn-sm" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="box box-solid">
                                                        <div class="box-header">
                                                        </div><!-- /.box-header -->
                                                        <div class="box-body">
                                                            <div class="row">
                                                                <div class="col-md-8">
                                                                    <p> <h4>  [SEDE] : NUEVA SEDE</h4></p>
                                                                    <p> <h4>  [AULA] : 204 - A</h4></p>
                                                                    <p> <h4>  [HORA] : 12:30 p.md. </h4></p>
                                                                </div>
                                                                <div class="col-md-4">
                                                                    <p> <h5>  [Descripcion]</h5></p>
                                                                </div>
                                                            </div><!-- /.row -->
                                                        </div>
                                                    </div><!-- /.box -->
                                                </div><!-- ./col -->
                                            </div><!-- /.row -->
                                            <div class="row">
                                                <div class="col-xs-8"> 
                                                    <button class="btn btn-primary">Registrar Alumnos</button>
                                                </div> 
                                                <div class="col-xs-4"> 
                                                    <button class="btn btn-danger" style="margin-left:">Asistir</button>
                                                </div>

                                            </div> 

                                        </div><!-- /.box-body -->
                                    </div>
                                </section>

                            </div><!-- /.row (main row) -->
                        </section>

                        </aside>
                    </div>



                    <script src="../js/jquery.min.js"></script>
                    <script src="../js/bootstrap.min.js" type="text/javascript"></script>
                    <!-- DATA TABES SCRIPT -->
                    <script src="../js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
                    <script src="../js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
                    <!-- AdminLTE App -->
                    <script src="../js/AdminLTE/app.js" type="text/javascript"></script>
                    <!-- AdminLTE for demo purposes -->
                    <script src="../js/AdminLTE/demo.js" type="text/javascript"></script>
                    <!-- page script -->
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