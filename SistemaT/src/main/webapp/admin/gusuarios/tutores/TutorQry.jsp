<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SISED</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="../../../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="skin-blue">
        <header class="header">
            <a href="../../indexA.html" class="logo">
                SISED
            </a>
            <nav class="navbar navbar-static-top" role="navigation">
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>[NOMBRE] <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header bg-light-blue">
                                    <p>
                                        [NOMBRE] - [FUNCION]
                                        <small>[ESPECIALIDAD]</small>
                                    </p>
                                    <br><br>
                                    <a href="#" class="btn btn-default btn-flat">Desconectar</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                        </div>
                        <div class="pull-left info">
                            <p>[NOMBRE ADMIN]</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Conectado(a)</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li >
                            <a href="../../indexA.html">
                                <i class="fa fa-dashboard"></i> <span>Servicio Académico</span>
                            </a>
                        </li>

                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Gestion Usuarios</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu ">
                                <li><a href="../admins/AdminQry.jsp"><i class="fa fa-angle-double-right"></i> Administradores</a></li>
                                <li class="active"><a href="../tutores/TutorQry.jsp"><i class="fa fa-angle-double-right"></i> Tutores</a></li>
                                <li><a href="../alumnos/AlumnoQry.jsp"><i class="fa fa-angle-double-right"></i> Alumnos</a></li>
                                <li><a href="../cursos/CursoQry.jsp"><i class="fa fa-angle-double-right"></i> Cursos</a></li>
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
                        Gestión de Tutores
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <div class="col-md-11 col-xs-7">
                                        <h3 class="box-title">Tutores</h3>
                                    </div>
                                    <div class="col-md-1 col-xs-4" style="top: 5px">
                                        <button class="btn btn-primary">Insertar</button>      
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Codigo</th>
                                                <th>Nombre Tutor</th>
                                                <th>Especialidad</th>
                                                <th> <a href="">E</a> </th>
                                                <th> <a href="">Ed</a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Edward Flores</td>
                                                <td>Matematica</td>
                                                <td> <input type="checkbox"> </td>
                                                <td> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jose Pastor</td>
                                                <td>Matematica</td>
                                                <td> <input type="checkbox"> </td>
                                                <td> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Jose Alvarado</td>
                                                <td>Matematica</td>
                                                <td> <input type="checkbox"> </td>
                                                <td> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Claudia Marchand</td>
                                                <td>Matematica</td>
                                                <td> <input type="checkbox"> </td>
                                                <td> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Jose Sanchez</td>
                                                <td>Matematica</td>
                                                <td> <input type="checkbox"> </td>
                                                <td> <input type="radio" name="ed"> </td>
                                            </tr>


                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                </section>

            </aside>
        </div>



        <script src="../../../js/jquery.min.js"></script>
        <script src="../../../js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="../../../js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../../../js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../../js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../../../js/AdminLTE/demo.js" type="text/javascript"></script>
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