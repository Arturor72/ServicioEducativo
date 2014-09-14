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
        <%@include file="../../WEB-INF/jspf/title.jspf" %>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="../../WEB-INF/jspf/links.jspf" %>
    </head>
    <body class="skin-blue">
        <%@include file="../../WEB-INF/jspf/header.jspf" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%@include file="../../WEB-INF/jspf/asideMenu.jspf" %>

            <aside class="right-side">
                <section class="content-header">
                    <h1>
                        Servicio Académico
                    </h1>

                </section>
                <section class="content">
                    <div class="row">
                        <!-- left column -->
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <!-- general form elements -->
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Registro Servicio</h3>
                                </div><!-- /.box-header -->
                                <!-- form start -->
                                <form role="form">
                                    <div class="box-body">
                                        <div class="form-group">
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Código">
                                        </div>
                                        <div class="form-group">
                                            <label>Curso</label>
                                            <select class="form-control">
                                                <option>Curso 1</option>
                                                <option>Especilidad 2</option>
                                                <option>Especialidad 3</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Sede</label>
                                            <select class="form-control">
                                                <option>Sede 1</option>
                                                <option>Especilidad 2</option>
                                                <option>Especialidad 3</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Aula</label>
                                            <select class="form-control">
                                                <option>101 A</option>
                                                <option>102 B</option>
                                                <option>103 C</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Tipo</label>
                                            <select class="form-control">
                                                <option>Taller</option>
                                                <option>Tutoria</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Tutor</label>
                                            <select class="form-control">
                                                <option>Tutor1</option>

                                            </select>
                                        </div>
                                         <div class="form-group">
                                        <label>Fecha y Hora</label>
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-clock-o"></i>
                                            </div>
                                            <input type="text" class="form-control pull-right" id="reservationtime"/>
                                        </div><!-- /.input group -->
                                    </div><!-- /.form group -->
                                    </div><!-- /.box-body -->
                               
                                    <div class="box-footer">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                        &nbsp;&nbsp;
                                        <button type="submit" class="btn btn-danger">Cancelar</button>
                                        
                                    </div>
                                </form>
                            </div><!-- /.box -->
                        </div><!--/.col (left) -->
                        <!-- right column -->
                        <div class="col-md-2">
                            
                        </div><!--/.col (right) -->
                    </div>   <!-- /.row -->
                </section><!-- /.content -->

            </aside>
        </div>



        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../../js/AdminLTE/demo.js" type="text/javascript"></script>
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <!-- InputMask -->
        <script src="../../js/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
        <script src="../../js/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
        <script src="../../js/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
        <!-- date-range-picker -->
        <script src="../../js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- bootstrap color picker -->
        <script src="../../js/plugins/colorpicker/bootstrap-colorpicker.min.js" type="text/javascript"></script>
        <!-- bootstrap time picker -->
        <script src="../../js/plugins/timepicker/bootstrap-timepicker.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="../../js/AdminLTE/demo.js" type="text/javascript"></script>
        <!-- Page script -->
        <script type="text/javascript">
            $(function() {
                //Datemask dd/mm/yyyy
                $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
                //Datemask2 mm/dd/yyyy
                $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
                //Money Euro
                $("[data-mask]").inputmask();

                //Date range picker
                $('#reservation').daterangepicker();
                //Date range picker with time picker
                $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
                //Date range as a button
                $('#daterange-btn').daterangepicker(
                        {
                            ranges: {
                                'Today': [moment(), moment()],
                                'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                                'Last 7 Days': [moment().subtract('days', 6), moment()],
                                'Last 30 Days': [moment().subtract('days', 29), moment()],
                                'This Month': [moment().startOf('month'), moment().endOf('month')],
                                'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                            },
                            startDate: moment().subtract('days', 29),
                            endDate: moment()
                        },
                function(start, end) {
                    $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
                );

                //iCheck for checkbox and radio inputs
                $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                    checkboxClass: 'icheckbox_minimal',
                    radioClass: 'iradio_minimal'
                });
                //Red color scheme for iCheck
                $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                    checkboxClass: 'icheckbox_minimal-red',
                    radioClass: 'iradio_minimal-red'
                });
                //Flat red color scheme for iCheck
                $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                    checkboxClass: 'icheckbox_flat-red',
                    radioClass: 'iradio_flat-red'
                });

                //Colorpicker
                $(".my-colorpicker1").colorpicker();
                //color picker with addon
                $(".my-colorpicker2").colorpicker();

                //Timepicker
                $(".timepicker").timepicker({
                    showInputs: false
                });
            });
        </script>        


    </body>
</html>