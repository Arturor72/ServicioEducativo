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
                        Gestión de Tutores
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <div class="col-md-10 col-xs-7">
                                        <h3 class="box-title">Tutores</h3>
                                    </div>
                                    <div class="col-md-2 col-xs-4" style="top: 5px">
                                        <button class="btn btn-primary"><img src="../../../img/add3.png">Tutor</button>      
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre Tutor</th>
                                                <th class="mrc"> <a href=""><img src="../../../img/delete.png" /></a> </th>
                                                <th class="mrc"> <a href=""><img src="../../../img/edit.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Edward Flores</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Jose Pastor</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Jose Alvarado</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Claudia Marchand</td>
                                                <td class="mrc"> <input type="checkbox"> </td>
                                                <td class="mrc"> <input type="radio" name="ed"> </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Jose Sanchez</td>
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



        <%@include file="../../../WEB-INF/jspf/linksfooter.jspf" %>
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