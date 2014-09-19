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
        <%@include file="../../../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../../../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%@include file="../../../WEB-INF/jspf/asideMenu.jspf" %>

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
                                                <th>Codigo</th>
                                                <th>Nombre Servicio</th>
                                                <th>Tipo</th>
                                                <th>Tutor</th>
                                                <th>Fecha</th>
                                                <th>Hora Inicio</th>
                                                <th>Hora Fin</th>
                                                <th class="mrc"> <a href=""><img src="../../../img/suspender.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                               <tr>
                                                <td>1</td>
                                                <td>Calculo 1</td>
                                                <td>Tutoria</td>
                                                <td>Edward Flores</td>
                                                <td>12/10/2014</td>
                                                <td>1:00 pm</td>
                                                <td>2:00 pm</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Calculo 1</td>
                                                <td>Tutoria</td>
                                                <td>Edward Flores</td>
                                                <td>12/10/2014</td>
                                                <td>1:00 pm</td>
                                                <td>2:00 pm</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Calculo 1</td>
                                                <td>Tutoria</td>
                                                <td>Edward Flores</td>
                                                <td>12/10/2014</td>
                                                <td>1:00 pm</td>
                                                <td>2:00 pm</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Calculo 1</td>
                                                <td>Tutoria</td>
                                                <td>Edward Flores</td>
                                                <td>12/10/2014</td>
                                                <td>1:00 pm</td>
                                                <td>2:00 pm</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Calculo 1</td>
                                                <td>Tutoria</td>
                                                <td>Edward Flores</td>
                                                <td>12/10/2014</td>
                                                <td>1:00 pm</td>
                                                <td>2:00 pm</td>
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