<%-- 
    Document   : indexA
    Created on : 14/09/2014, 03:14:23 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/jspf/headerLogin.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">

            <%@include file="../WEB-INF/jspf/asideMenu.jspf" %>
            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Servicio Academico
                    </h1>

                </section>
                <section class="content">







                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <ul class="timeline" id="servicio">

                                      <!--Contenido de los servicios-->
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>

            </aside>
        </div>
        <%@include file="../WEB-INF/jspf/linksfooter.jspf" %>
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

<%@include file="../WEB-INF/jspf/footerLogin.jspf" %>
<script src="<%= request.getContextPath()%>/js/admin/servicio.js"></script>

<!--Modal para editar-->

 <!--    mi modal upd-->
        <div class="modal fade" id="myModalUpd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" id="myModalLabel">Actualizar Servicio</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">

                            <input type="hidden"  id="idupd" value="${cursoget.cur_id}">
                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="codigoupd" data-error="Solo debe contener numeros y letras, no espacios" placeholder="Código" required="true" value="${cursoget.cur_cod}">
                                <div class="help-block with-errors">Solo letras y numeros</div>


                            </div>
                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z0-9\s]*$" class="form-control" id="nombreupd" data-error="Solo debe contener numeros y letras" placeholder="Nombre" required="true" value="${cursoget.cur_nom}">
                                <div class="help-block with-errors">Solo letras y numeros</div>
                            </div>
                                <div class="form-group">
                                <div id="mensajeupd"></div>
                                </div>
                        </div
                        >
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="ActualizarServicio()" >Guardar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->
       