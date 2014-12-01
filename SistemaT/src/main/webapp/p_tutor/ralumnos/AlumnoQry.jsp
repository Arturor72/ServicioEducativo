<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/jspf/headerLoginTutor.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <%@include file="../../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../../WEB-INF/jspf/headerT.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <div class="user-panel">
                        <div class="pull-left image">
                        </div>
                        <div class="pull-left info">
                            <p>[NOMBRE TUTOR]</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Conectado(a)</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">
                        <li >
                            <a href="../indexT.jsp">
                                <i class="fa fa-dashboard"></i> <span>Servicio Académico</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Gestion Alumnos</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="../ralumnos/AlumnoQry.jsp"><i class="fa fa-angle-double-right"></i> Alumnos</a></li>
                            </ul>
                        </li>
                        <li class="">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Reportes</span>
                            </a>
                        </li>

                    </ul>
                </section>

            </aside>

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
                                    <table id="tblAlumno" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nombre</th>
                                                <th>Apellidos</th>
                                                <th>Estado</th>
                                               <!-- <th class="mrc"> <img  onclick="mostrarMensajeSuspender()" src="../../img/suspender.png" /></th>-->
                                                 
                                            </tr>
                                        </thead>
                                       
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                </section>

            </aside>
        </div>



        <%@include file="../../WEB-INF/jspf/linksfooter.jspf" %>
        
      
        <%@include file="../../WEB-INF/jspf/footerLoginTutor.jspf" %>
<script src="<%= request.getContextPath()%>/js/jstutor/alumno.js"></script>
  <script type="text/javascript">
            $(function() {
                $("#tblAlumno").dataTable();
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





 <!--    mi modal upd-->
        <div class="modal fade" id="myModalMensaje" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

          <!--  <div class="modal-dialog">
                <div class="modal-content">-->
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
               <!-- </div><!-- /.modal content -->
            <!--</div><!-- /.modal dialog -->
        </div><!-- /.modal -->

        <!--fin-->

<!--    mi modal del-->
        <div class="modal fade" id="myModalSus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

          <!--  <div class="modal-dialog">
                <div class="modal-content">-->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" >Suspender Alumnos</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">

                            <div id="modal-mensaje-del"></div>
                        </div>
                        <div class="form-group">
                            <div id="mensaje_ins"></div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="suspenderAlumnos()" >Aceptar</button>
                        </div>
                    </form> <!-- /.form -->
               <!-- </div><!-- /.modal content -->
           <!-- </div><!-- /.modal dialog -->
        </div><!-- /.modal -->
