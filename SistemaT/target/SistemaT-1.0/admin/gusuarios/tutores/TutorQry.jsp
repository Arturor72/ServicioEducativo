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
                        Gestión de tutores
                    </h1>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">

                                    <div class="row">
                                        <div class="col-md-10 col-xs-6">
                                            <h3 class="box-title">Tutores</h3>
                                        </div>

                                        <div class="col-md-2 col-xs-6" >
                                            <div class="box-footer">
                                                <button class="btn btn-primary btn-sm btn-block" data-toggle="modal" data-target="#myModal"><img class="btn-tutor" src="<%= request.getContextPath()%>/img/tutor.png"/> Tutor</button>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /.box-header -->

                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th class="mrc">Apellidos y nombres</th>
                                                <th class="mrc">C&oacute;digo</th>
                                                <th class="mrc">Alias</th>
                                                <th class="mrc">Correo electr&oacute;nico</th>
                                                <th class="mrc">M&oacute;vil</th>
                                                <th class="mrc"> <img src="<%= request.getContextPath()%>/img/delete.png" onclick="mostrarMensajeEliminar()"/></th>
                                                <th class="mrc"> <img src="<%= request.getContextPath()%>/img/edit.png" onclick="solicitarUsuarioId()"/></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="a" items="${list}">
                                                <tr>
                                                    <td>${a.usr_apat} ${a.usr_amat}, ${a.usr_nom} </td>
                                                    <td class="mrc">${a.usr_cod}</td>
                                                    <td class="mrc">${a.usr_user}</td>
                                                    <td>${a.usr_mail}</td>
                                                    <td class="mrc">${a.usr_cel}</td>
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
        <%@include file="../../../WEB-INF/jspf/footerLogin.jspf" %>

        <!-- Modal INS -->

        <!--inicio-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" style="width:60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" id="myModalLabel">Nuevo tutor</h3>
                    </div><!-- /.model-header -->
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">
                            <input type="hidden" id="tipUsrId" value="2">
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos personales</h4></legend>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrNom" placeholder="Nombre" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrApat" placeholder="Apellido Paterno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrAmat" placeholder="Apellido Materno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>

                                        <div class="form-group">
                                            Sexo &nbsp;&nbsp;
                                            <input type="radio" id="usrGen_f" name="usrGen" required value="0"> Femenino
                                            &nbsp;<input type="radio" id="usrGen_m" name="usrGen" required value="1"> Masculino
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="8" class="form-control" id="usrDni" placeholder="DNI" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="email" class="form-control" id="usrMail" placeholder="e-mail" required>
                                            <div class="help-block with-errors">Formato de email</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="9" class="form-control" id="usrCel" placeholder="celular" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>
                                    </fieldset> <!-- /.fieldset -->
                                </div><!-- /.col -->
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos de la cuenta de usuario</h4></legend>

                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$"class="form-control" id="usrCod" data-error="Codigo no valido" maxlength="10" placeholder="Código" data-error="" required>
                                            <div class="help-block with-errors">Solo letras y numeros</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="usrUser" placeholder="Usuario" required>
                                            <div class="help-block with-errors"></div>
                                        </div>

                                        <div class="form-group">
                                            <input type="password"   class="form-control" id="usrPass" placeholder="Contraseña" required>
                                            <div class="help-block with-errors">No estan permitidos caracteres especiales</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="password" class="form-control" id="usrPassConf" data-match="#usrPass" data-match-error="Upss,deben coincidir" placeholder="Repita Contraseña" required>
                                            <div class="help-block with-errors"></div>
                                        </div>

                                    </fieldset><!-- /.fieldset -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                            <div class="form-group">
                                <div id="mensaje"></div>
                            </div>
                        </div><!-- /.modal-body -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="guardarTutor()">Guardar</button>
                        </div><!-- /.modal-footer -->
                    </form><!-- /.form -->
                </div><!-- /.model-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--fin-->

        <!-- Modal UPD -->

        <!-- Inicio -->
        <div class="modal fade" id="myModalUpd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" id="myModalLabel">Actualizar tutor</h3>
                    </div>
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">
                            <input type="hidden" id="usrIdUPD" value="${usuarioGET.usr_id}">
                            <input type="hidden" id="tipUsrIdUPD" value="${usuarioGET.tip_usr_id}">
                            <input type="hidden" id="usrEspUPD" value="${usuarioGET.esp_id}">
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos personales</h4></legend>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrNomUPD" required data-error="Solo debe contener numeros y letras, no espacios" placeholder="Nombre" required="true" value="${usuarioGET.usr_nom}">
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrApatUPD" placeholder="Apellido Paterno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="usrAmatUPD" placeholder="Apellido Materno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="8" class="form-control" id="usrDniUPD" placeholder="DNI" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>

                                        <div class="form-group">
                                            Sexo &nbsp;&nbsp;
                                            <input type="radio" id="usrGen_fUPD" name="usrGenUPD" required> Femenino
                                            &nbsp;<input type="radio" id="usrGen_mUPD" name="usrGenUPD" required> Masculino
                                        </div>

                                        <div class="form-group">
                                            <input type="email" class="form-control" id="usrMailUPD" placeholder="e-mail" required>
                                            <div class="help-block with-errors">Formato de email</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="9" class="form-control" id="usrCelUPD" placeholder="celular" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>
                                    </fieldset> <!-- /.fieldset -->
                                </div><!-- /.col -->
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos de usuario</h4></legend>

                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$"class="form-control" id="usrCodUPD" data-error="Codigo no valido" maxlength="10" placeholder="Código" data-error="" required>
                                            <div class="help-block with-errors">Solo letras y numeros</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="usrUserUPD" placeholder="Usuario" required>
                                            <div class="help-block with-errors"></div>
                                        </div>

                                        <div class="form-group">
                                            <input type="password" class="form-control" id="usrPassUPD" placeholder="Contraseña" required>
                                            <div class="help-block with-errors">No estan permitidos caracteres especiales</div>
                                        </div>
                                    </fieldset><!-- /.fieldset -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                            <div class="form-group">
                                <div id="mensajeUPD"></div>
                            </div>
                        </div><!-- /.modal-body -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="guarda" onclick="actualizarTutor()">Guardar</button>
                        </div><!-- /.modal-footer -->
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->
        <!--fin-->


        <!-- Modal MSG -->
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

        <!-- Modal DEL -->
        <div class="modal fade" id="myModalDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title" >Eliminar tutor</h3>
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
                            <button type="button" class="btn btn-primary" id="guarda" onclick="eliminarTutor()" >Aceptar</button>
                        </div>
                    </form> <!-- /.form -->
                </div><!-- /.modal content -->
            </div><!-- /.modal dialog -->
        </div><!-- /.modal -->
        <!--fin-->
    </body>
</html>