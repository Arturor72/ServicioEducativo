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

                                    <div class="col-md-2 col-xs-8" >
                                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"><img src="<%= request.getContextPath()%>/img/add3.png"/> Administrador</button>
                                    </div>

                                    <!--inicio-->
                                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                                    <h4 class="modal-title" id="myModalLabel">Registro Administrador</h4>
                                                </div>
                                                <form role="form" data-toggle="validator">
                                                    <div class="modal-body">

                                                        <div class="box-body">
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="codigo" data-error="Codigo no valido" placeholder="Código" required>
                                                                <div class="help-block with-errors"></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="nombre" placeholder="Nombre" required>
                                                                <div class="help-block with-errors">Solo letras</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="apellidoPat" placeholder="Apellido Paterno" required>
                                                                <div class="help-block with-errors">Solo letras</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="apellidoMat" placeholder="Apellido Materno" required>
                                                                <div class="help-block with-errors">Solo letras</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="dni" placeholder="DNI" required>
                                                                <div class="help-block with-errors">Solo numeros</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="usuario" placeholder="Usuario" required>
                                                                <div class="help-block with-errors"></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="password" data-minlength="6"  class="form-control" id="password" placeholder="Contraseña" required>
                                                                <div class="help-block with-errors">Minimo 6 caracteres</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="password" class="form-control" id="passwordConf" data-match="#password" data-match-error="Ups,deben coincidir" placeholder="Repita Contraseña" required>
                                                                <div class="help-block with-errors"></div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="email" class="form-control" id="email" placeholder="e-mail" required>
                                                                <div class="help-block with-errors">Formato de email</div>
                                                            </div>
                                                            <div class="form-group">
                                                                <input type="text" class="form-control" id="celular" placeholder="celular" required>
                                                                <div class="help-block with-errors">Solo numeros</div>
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
                                                <th>Nombre Admin</th>
                                                <th class="mrc"> <a href=""><img src="<%= request.getContextPath()%>/img/delete.png" /></a> </th>
                                                <th class="mrc"> <a href=""><img src="<%= request.getContextPath()%>/img/edit.png" /></a> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="a" items="${list}">
                                                <tr>
                                                    <td>${a.usr_cod}</td>
                                                    <td>${a.usr_nom} ${a.usr_apat} ${a.usr_amat}</td>
                                                    <td class="mrc"> <input type="checkbox" name="DEL" value="${a.usr_id}"> </td>
                                                    <td class="mrc"> <input type="radio" name="UPD" value="${a.usr_id}"> </td>
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