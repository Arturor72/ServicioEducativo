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
                        <div class="col-md-8">
                            <!-- select fecha y hora-->
                            <div class="form-group">

                                <div class="input-group date" id="fecha_hora_srch">
                                    <input  type="text" placeholder="Buscar..." class="form-control" data-date-format="DD/MM/YYYY" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>


                        
                         <div class="col-md-2">
                            <div class="form-group">
                                <button class="btn btn-primary btn btn-block" onclick="buscarServicio()">Buscar</button>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group">
                                <button class="btn btn-primary btn btn-block" onclick="guardarFormServicio()">Agregar servicio</button>
                            </div>
                        </div>
                    </div>
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
            $(function () {
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



                    <!-- select -->
                    <div class="form-group">
                        <label>Curso</label>
                        <select name="curso_upd" id="curso_upd" class="form-control">
                            <option value="0" selected>Seleccione</option>
                        </select>
                    </div>

                    <!-- select -->
                    <div class="form-group">
                        <label>Tipo de servicio</label>
                        <select name="servicio_upd" id="servicio_upd" class="form-control">
                            <option value="0" selected>Seleccione</option>
                            <option value="1">Taller</option>
                            <option value="2">Tutoria</option>
                        </select>
                    </div>




                    <!-- Date -->
                    <div class="form-group">
                        <label>Fecha y Hora</label>
                        <div class="input-group date" id="fecha_hora_upd">
                            <input type='text' class="form-control" data-date-format="DD/MM/YYYY HH:mm"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>





                    <!-- select -->
                    <div class="form-group">
                        <label>Sede</label>
                        <select name="sede_upd" id="sede_upd" class="form-control">
                            <option value="0" selected>Seleccione</option>
                        </select>
                    </div>



                    <!-- select -->
                    <div class="form-group">
                        <label>Ambiente</label>
                        <select name="ambiente_upd" id="ambiente_upd" class="form-control">
                            <option value="0" selected>Seleccione</option>
                        </select>
                    </div>




                    <!-- select -->
                    <div class="form-group">
                        <label>Tutor</label>
                        <select name="tutor_upd" id="tutor_upd" class="form-control">
                            <option value="0" selected>Seleccione</option>
                        </select>
                    </div>


                    <div class="form-group">
                        <label>Descripción</label>
                        <textarea class="form-control" rows="3" placeholder="...." id="descripcion_upd"></textarea>
                    </div>

                    <div class="form-group">
                        <div id="mensaje_upd"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" id="guarda" onclick="actualizarServicio()" >Guardar</button>
                </div>
            </form> <!-- /.form -->
        </div><!-- /.modal content -->
    </div><!-- /.modal dialog -->
</div><!-- /.modal -->

<!--fin-->


<!-- <div class="input-group-btn">
                                   <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">Action <span class="fa fa-caret-down"></span></button>
                                   <ul class="dropdown-menu">
                                       <li><a href="#">Action</a></li>
                                       <li><a href="#">Another action</a></li>
                                       <li><a href="#">Something else here</a></li>
                                       <li class="divider"></li>
                                       <li><a href="#">Separated link</a></li>
                                   </ul>
                               </div><!-- /btn-group -->



<!--    mi modal upd-->
<div class="modal fade" id="myModalIns" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h3 class="modal-title" id="myModalLabel">Crear Servicio</h3>
            </div>
            <form role="form" data-toggle="validator">
                <div class="modal-body">


                    <!-- select curso-->
                    <div class="form-group">
                        <label>Curso</label>
                        <select name="curso_ins" id="curso_ins" class="form-control" onchange="selectCurso()">
                            <option value="0" selected>Seleccione</option>
                        </select>
                    </div>

                    <!-- select servicio tipo-->
                    <div class="form-group">
                        <label>Tipo de servicio</label>
                        <select name="servicio_ins" id="servicio_ins" class="form-control" onchange="selectServicio()">
                            <option value="0" selected>Seleccione</option>
                            <option value="1">Taller</option>
                            <option value="2">Tutoria</option>
                        </select>
                    </div>


                    <!-- select fecha y hora-->
                    <div class="form-group">
                        <label>Fecha y hora</label>
                        <div class="input-group date" id="fecha_hora_ins">
                            <input  type="text" class="form-control" data-date-format="DD/MM/YYYY HH:mm" />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>





                    <!-- select sede -->
                    <div class="form-group">
                        <label>Sede</label>
                        <select name="sede_ins" id="sede_ins" class="form-control" onchange="selectSede()">
                            <option value="0" selected>Seleccione</option>

                        </select>
                    </div>


                    <!-- select -->
                    <div class="form-group">
                        <label>Ambiente</label>
                        <select name="ambiente_ins" id="ambiente_ins" class="form-control" onchange="selectAmbiente()">
                            <option value="0" selected>Seleccione</option>

                        </select>
                    </div>




                    <!-- select -->
                    <div class="form-group">
                        <label>Tutor</label>
                        <select name="tutor_ins" id="tutor_ins" class="form-control" >
                            <option value="0" selected>Seleccione</option>       
                        </select>
                    </div>


                    <div class="form-group">
                        <label>Descripción</label>
                        <textarea class="form-control" rows="3" placeholder="...." id="descripcion_ins"></textarea>
                    </div>



                    <div class="form-group">
                        <div id="mensaje_ins"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary"  onclick="guardarServicio()" >Guardar</button>
                </div>
            </form> <!-- /.form -->
        </div><!-- /.modal content -->
    </div><!-- /.modal dialog -->
</div><!-- /.modal -->

<!--fin-->