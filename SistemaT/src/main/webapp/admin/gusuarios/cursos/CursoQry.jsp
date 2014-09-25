<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        Gestión de Cursos
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <div class="col-md-10 col-xs-4">
                                        <h3 class="box-title">Cursos</h3>
                                    </div>


                                    <div class="col-md-2 col-xs-8" >
                                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"><img src="<%= request.getContextPath()%>/img/add3.png"/> Curso</button>
                                    </div>

                                    <!--inicio-->
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                    <h4 class="modal-title" id="myModalLabel">Registro Curso</h4>
                                                </div>
                                                <form role="form">
                                                    <div class="modal-body">

                                                        <div class="box-body">
                                                            <div class="form-group">
                                                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Código">
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Nombre">
                                                            </div>
                                                        </div><!-- /.box-body -->
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                        <button type="button" class="btn btn-primary">Guardar</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <!--fin-->

                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre </th>
                                                <th class="mrc"> <a href=""><img src="<%= request.getContextPath()%>/img/delete.png" /></a> </th>
                                                <th class="mrc"> <a href=""><img src="<%= request.getContextPath()%>/img/edit.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="cu" items="${listcursos}">
                                                <tr>
                                                    <td>${cu.cur_cod}</td>
                                                    <td>${cu.cur_nom}</td>
                                                    <td class="mrc"> <input type="checkbox" name="DEL" value="${cu.cur_id}"> </td>
                                                    <td class="mrc"> <input type="radio" name="UPD" value="${cu.cur_id}"> </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
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