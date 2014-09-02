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
                                <li class="active"><a href="../admins/AdminQry.jsp"><i class="fa fa-angle-double-right"></i> Administradores</a></li>
                                <li><a href="../tutores/TutorQry.jsp"><i class="fa fa-angle-double-right"></i> Tutores</a></li>
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
                        <!-- left column -->
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <!-- general form elements -->
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Registro Tutor</h3>
                                </div><!-- /.box-header -->
                                <!-- form start -->
                                <form role="form">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Código">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Nombre">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Apellido Paterno">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Apellido Materno">
                                        </div>
                                        <div class="form-group">
                                            <label>Especialidad</label>
                                            <select class="form-control">
                                                <option>Matematica</option>
                                                <option>Especilidad 2</option>
                                                <option>Especialidad 3</option>
                                            </select>
                                        </div>
                                    </div><!-- /.box-body -->

                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                        &nbsp;&nbsp;
                                        <button type="submit" class="btn btn-danger">Cancelar</button>
                                    </div>
                                </form>
                            </div><!-- /.box -->
                        </div><!--/.col (left) -->
                        <!-- right column -->
                        <div class="col-md-2">

                        </div><!--/.col (right) -->
                    </div>   <!-- /.row -->
                </section><!-- /.content -->

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