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
        <%@include file="../../../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="../../../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="../../../css/mycss.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="skin-blue">
        <%@include file="../../../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%@include file="../../../WEB-INF/jspf/asideMenu.jspf" %>

            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Gestión de Administradores
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">

                                    <div class="col-md-10 col-xs-6">
                                        <h3 class="box-title">Administradores</h3>
                                    </div>
                                    <div class="col-md-2 col-xs-8" style="top: 5px">
                                        <button class="btn btn-primary"> <img src="../../../img/add3.png">  Administrador</button>      
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre Admin</th>
                                                <th>Sede</th>
                                                <th class="mrc"> <a href=""><img src="../../../img/delete.png" /></a> </th>
                                                <th class="mrc"> <a href=""><img src="../../../img/edit.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Edward Flores</td>
                                                <td>Miraflores 1</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jose Pastor</td>
                                                <td>Miraflores 2</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Jose Alvarado</td>
                                                <td>San Isidro</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Claudia Marchand</td>
                                                <td>Miraflores 1</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Jose Sanchez</td>
                                                <td>Miraflores 1</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
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