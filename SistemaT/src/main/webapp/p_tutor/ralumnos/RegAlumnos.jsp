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
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <link href="../../css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <link href="../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
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
                        <li class="active">
                            <a href="../indexT.html">
                                <i class="fa fa-dashboard"></i> <span>Tus Servicios</span>
                            </a>
                        </li>
   
                    </ul>
                </section>

            </aside>

            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Registro de Asistencia
                    </h1>

                </section>
                <section class="content">
                     <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Alumnos - [TUTORIA O TALLER]</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nombre</th>
                                                <th>Apellidos</th>
                                                <th>Asistió</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Julio</td>
                                                <td>Carranza</td>
                                                <td><input type="checkbox"/></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Fernando</td>
                                                <td>Tupac Yupanqui</td>
                                                <td><input type="checkbox"/></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Allison</td>
                                                <td>Arana</td>
                                                <td><input type="checkbox"/></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Claudia</td>
                                                <td>Marchand </td>
                                                <td><input type="checkbox"/></td>
                                            </tr>

                                    </table>
                                    
                                    <div class="row">
                                    
                                    <div class="col-xs-12">
                                               <div class="form-group">
                                            <label>Descripción</label>
                                            <textarea class="form-control" rows="3" placeholder="Enter ..."></textarea>
                                        </div>
                                    </div>
                                    
                                    </div>
                                    <div class="row">
                                    <div class="col-md-3 col-xs-1"></div>
                                    <div class="col-md-5 col-xs-6"><button class="btn btn-primary ">Registrar Alumnos</button></div>
                                    <div class="col-md-4 col-xs-3"><button class="btn btn-danger ">Cancelar</button></div>
                                    </div>
                                    
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                </section>

            </aside>
        </div>



        <script src="../../js/jquery.min.js"></script>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="../../js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../../js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../../js/AdminLTE/demo.js" type="text/javascript"></script>
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