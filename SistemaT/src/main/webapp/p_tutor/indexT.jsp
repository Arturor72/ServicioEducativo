<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../WEB-INF/jspf/headerLoginTutor.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
        <%@include file="../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../WEB-INF/jspf/headerT.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%@include file="../WEB-INF/jspf/asideMenuT.jspf" %>

            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Servicio Académico
                    </h1>

                </section>


                <section class="content">
                    <div class="row">
                        <span id="clock1" class="timer"></span>
                         <span id="clock2" class="timer"></span>
 
                        <div class="col-md-4">
                            <!-- select fecha y hora-->
                            <div class="form-group">

                                <div class="input-group date" id="fecha_hora_srch"  >
                                    <input  type="text" placeholder="Fecha.." class="form-control" data-date-format="DD/MM/YYYY" />
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>



                        <div class="col-md-4">
                            <div class="form-group">
                                <select name="sede_srch" id="sede_srch" class="form-control" onchange="selectSedeSrch()" >
                                    <option value="0" selected>Sede</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <button class="btn btn-primary btn btn-block" onclick="buscarServicio()">Todos</button>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-12">

                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                <input type="hidden" id="response"  />
                                    <ul class="timeline" id="servicio">

                                        <!--Contenido de los servicios-->
                                    </ul>
                                    <div class="row">
                                        <div id="alerta" class="col-md-12">

                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>






            </aside>
        </div>






        <%@include file="../WEB-INF/jspf/linksfooter.jspf" %>
        <!-- page script -->
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
        <%@include file="../WEB-INF/jspf/footerLoginTutor.jspf" %>
        
        <script src="<%= request.getContextPath()%>/js/jstutor/servicio.js"></script>
       

    </body>
</html>




<!--    mi modal upd-->
<div class="modal fade" id="myModalIns" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h3 class="modal-title" id="myModalLabel">Registrar alumnos</h3>
            </div>

            <input type="hidden" id="ser-id"  />


            <div class="modal-body table-responsive">

                <table id="tblAlumno" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th class="mrc">Asistió</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>

                </table>







                <div class="form-group">
                    <div id="mensaje_ins"></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary"  onclick="guardarAlumnos()" >Guardar</button>
            </div>

        </div><!-- /.modal content -->
    </div><!-- /.modal dialog -->
</div><!-- /.modal -->