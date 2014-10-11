<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../WEB-INF/jspf/headerLogin.jspf" %>
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
                                        <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal"><img src="<%= request.getContextPath()%>/img/add3.png"/> Curso</button>
                                    </div>



                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre </th>
                                                <th class="mrc"> <img src="<%= request.getContextPath()%>/img/delete.png" onclick="cursoDel()"/></th>
                                                <th class="mrc"> <img src="<%= request.getContextPath()%>/img/edit.png" onclick="cursoUpd()" /> </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="cu" items="${listcursos}">
                                                <tr>
                                                    <td>${cu.cur_cod}</td>
                                                    <td>${cu.cur_nom}</td>
                                                    <td class="mrc"> <input type="checkbox" name="DEL" value="${cu.cur_id}"> </td>
                                                    <!--                                                    <td class="mrc"> <a href=""><img data-toggle="modal" data-target="#myModal" src="/img/edit.png" /></a> </td>-->
                                                    <td class="mrc"> <input type="radio" name="UPD" value="${cu.cur_id}"> </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
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
        <%@include file="../../../WEB-INF/jspf/footerLogin.jspf" %>




        <!--inicio-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" id="myModalLabel">Registro Curso</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">


                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="codigo" data-error="Solo debe contener numeros y letras, no espacios" placeholder="Código" required="true">
                                <div class="help-block with-errors">Solo letras y numeros</div>


                            </div>
                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z\s]*$" class="form-control" id="nombre" data-error="Solo debe contener numeros y letras" placeholder="Nombre" required="true" >
                                <div class="help-block with-errors">Solo letras y numeros</div>
                            </div>
                                <div class="form-group">
                                <div id="mensaje"></div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="guardarCurso()" >Guardar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->

        <!--    mi modal upd-->
        <div class="modal fade" id="myModalUpd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" id="myModalLabel">Actualizar Curso</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">

                            <input type="hidden"  id="idupd" value="${cursoget.cur_id}">
                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="codigoupd" data-error="Solo debe contener numeros y letras, no espacios" placeholder="Código" required="true" value="${cursoget.cur_cod}">
                                <div class="help-block with-errors">Solo letras y numeros</div>


                            </div>
                            <div class="form-group">
                                <input type="text" pattern="^[a-zA-Z\s]*$" class="form-control" id="nombreupd" data-error="Solo debe contener numeros y letras" placeholder="Nombre" required="true" value="${cursoget.cur_nom}">
                                <div class="help-block with-errors">Solo letras y numeros</div>
                            </div>
                                <div class="form-group">
                                <div id="mensaje"></div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="guardarCursoUpd()" >Guardar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->
        
        

        
                <!--    mi modal upd-->
        <div class="modal fade" id="myModalMensaje" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        
                        <h3 class="modal-title" id="myModalMensajeDel"></h3>
                        <h3 class="modal-title" id="myModalMensajeUpd"></h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">

                      <div id="modal-mensaje">
                                
                            </div>
                        </div>
                        
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Aceptar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->

        
        
        
        
        
        
        
                <!--    mi modal del-->
        <div class="modal fade" id="myModalDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" >Eliminar Curso</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">

                      <div id="modal-mensaje-del"></div>
                        </div>
                            <div class="form-group">
                                <div id="mensaje-del"></div>
                                </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="confirm()" >Aceptar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->

    </body>
</html>
