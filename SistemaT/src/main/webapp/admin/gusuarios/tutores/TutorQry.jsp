<%-- 
    Document   : AdminQry
    Created on : 31/08/2014, 04:25:48 PM
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


                                    <div class="col-md-2 col-xs-8" >
                                        <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal"><img src="<%= request.getContextPath()%>/img/add3.png"/> Tutor</button>
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
                                            <!--<td class="mrc"> <input type="radio" name="ed"> </td>-->
                                            <td class="mrc"> <a href=""><img data-toggle="modal" data-target="#myModal" src="<%= request.getContextPath()%>/img/edit.png" /></a> </td>
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

        
        
       
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

            <div class="modal-dialog modal-lg" style="width:60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>

                        <h3 class="modal-title" id="myModalLabel">Registro Tutor</h3>
                    </div><!-- /.model-header -->
                    <form role="form" data-toggle="validator">
                        <div class="modal-body">


                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos Personales</h4></legend>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="nombre" placeholder="Nombre" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="apellidoPat" placeholder="Apellido Paterno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-ZñÑ\s]*$" class="form-control" id="apellidoMat" placeholder="Apellido Materno" required>
                                            <div class="help-block with-errors">Solo letras</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="8" class="form-control" id="dni" placeholder="DNI" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>

                                        <div class="form-group">
                                            <input type="email" class="form-control" id="email" placeholder="e-mail" required>
                                            <div class="help-block with-errors">Formato de email</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" pattern="^[0-9]*$" maxlength="9" class="form-control" id="celular" placeholder="celular" required>
                                            <div class="help-block with-errors">Solo numeros</div>
                                        </div>


                                    </fieldset> <!-- /.fieldset -->
                                </div><!-- /.col -->
                                <div class="col-md-6 col-xs-12">
                                    <fieldset>
                                        <legend><h4>Datos de Usuario</h4></legend>

                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$"class="form-control" id="codigo" data-error="Codigo no valido" maxlength="10" placeholder="Código" data-error="" required>
                                            <div class="help-block with-errors">Solo letras y numeros</div>
                                        </div>


                                        <div class="form-group">
                                            <input type="text" pattern="^[a-zA-Z0-9]*$" class="form-control" id="usuario" placeholder="Usuario" required>
                                            <div class="help-block with-errors"></div>
                                        </div>
                                        <div class="form-group">
                                            <input type="password"   class="form-control" id="password" placeholder="Contraseña" required>
                                            <div class="help-block with-errors">No estan permitidos caracteres especiales</div>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="passwordConf" data-match="#password" data-match-error="Upss,deben coincidir" placeholder="Repita Contraseña" required>
                                            <div class="help-block with-errors"></div>
                                        </div>

                                    </fieldset><!-- /.fieldset -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->

                        </div><!-- /.modal-body -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div><!-- /.modal-footer -->


                    </form><!-- /.form -->
                </div><!-- /.model-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--fin-->

        
        
        
        
        
    </body>
</html>