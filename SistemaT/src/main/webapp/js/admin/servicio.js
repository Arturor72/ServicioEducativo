/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    var operation = 'QRY';

    var parametros = {
        operation: operation
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function () {
            var path = window.location.host;
            //$("#resultado").html("Procesando, espere por favor...");
            // $('#servicio').append('<div class="loading-img"></div>'); 
            // $('#servicio').html('<img src="'+path+'/SistemaT/img/cargando.GIF"/>'); 
        },
        success: function (response) {
            console.log(response);

            var Datos = JSON.parse(response);
            agregarServicios(Datos);

        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
});




$(function () {
    var operation = "QRYJSON";

    var selectCurso = $('#select_cur');
    var curso_ins = $('#curso_ins');


    var parametros = {
        operation: operation
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/CursoServlet',
        type: 'post',
        beforeSend: function () {

        },
        success: function (response) {
            //  alert(response);
            console.log(response);

            var Datos = JSON.parse(response);

            for (i in Datos) {
                selectCurso.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');
                curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');

            }

        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });

});

//cargando sedes
$(function () {
    var operation = "QRYJSON";


    var sede_ins = $('#sede_ins');


    var parametros = {
        operation: operation
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/SedeServlet',
        type: 'post',
        beforeSend: function () {

        },
        success: function (response) {
            //  alert(response);
            console.log(response);

            var Datos = JSON.parse(response);

            for (i in Datos) {
                sede_ins.append('<option value="' + Datos[i].sed_id + '">' + Datos[i].sed_desc + '</option>');
                //curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');

            }

        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });

});


function agregarServicios(Datos) {



    for (i in Datos) {
        var servicio_head = '<li class="time-label"><span class="bg-red">' + moment(Datos[i].ser_edu_fec).lang("es").format('ll') + '</span></li>';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-clock-o"></i>' + Datos[i].ser_edu_hin + ' - ' + Datos[i].ser_edu_hin + '</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].ser_edu_id + '">' + Datos[i].tip_serv_den + ' - ' + Datos[i].cur_nom + '</a> ...</h3>' +
                '<div class="timeline-body panel-collapse collapse" id="' + Datos[i].ser_edu_id + '">' +
                //curso, tipo de servicio, fecha y hora .... tutor, sede, tipo de ambiente, ambiente
                //texarea

                //enviar codigo de sede, fecha, y la hora codigo tipo amb
                //aula 1 , laboratorio 2

                '<div class="callout callout-info">' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-cur_id" value="' + Datos[i].cur_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-tip_serv_id" value="' + Datos[i].tip_serv_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_fec" value="' + Datos[i].ser_edu_fec + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_hin" value="' + Datos[i].ser_edu_hin + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_id" value="' + Datos[i].usr_tut_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-sed_id" value="' + Datos[i].sed_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-sed_desc" value="' + Datos[i].sed_desc + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-amb_id" value="' + Datos[i].amb_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_desc" value="' + Datos[i].ser_edu_desc + '" />' +
                '<label>Sede: </label><span> ' + Datos[i].sed_desc + '</span><br/>' +
                '<label>Aula/Labortorio: </label><span> ' + Datos[i].amb_den + '</span><br/>' +
                '<label>Tutor: </label><span> ' + Datos[i].usr_tut_nom + ' ' + Datos[i].usr_tut_apat + ' ' + Datos[i].usr_tut_amat + '</span><br/>' +
                '<label>Descripcion: </label><span> ' + Datos[i].ser_edu_desc + '</span><br/>' +
                '<label>Creado por: </label><span> ' + Datos[i].ser_edu_desc + '</span><br/>' +
                '</div>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '<a class="btn btn-primary btn-xs" onclick="editarFormServicio(' + Datos[i].ser_edu_id + ')"  >Editar</a>' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#servicio').append(servicio_head + servicio_body);
    }

}


$(function () {
    $('#datetimepicker1').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es'
    });


    $('#fecha_hora_ins').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es'
    });


    //$('#datetimepicker1').data("DateTimePicker").setTime(new Time());
    //$('#datetimepicker1').data("DateTimePicker").setMinDate(new Date("june 12, 2014"));

});


//amb_den, sed_desc
function editarFormServicio(id) {

    //seteando valores en el formulario
    //enviar codigo de sede, fecha, y la hora codigo tipo amb
    var cur_id = $('#' + id + '-cur_id').val();

    var tip_serv_id = $('#' + id + '-tip_serv_id').val();

    var ser_edu_fec = $('#' + id + '-ser_edu_fec').val();
    var ser_edu_hin = $('#' + id + '-ser_edu_hin').val();

    var momentDate = moment(ser_edu_fec + " " + ser_edu_hin);
    var sed_id = $('#' + id + '-sed_id').val();

    var usr_tut_id = $('#' + id + '-usr_tut_id').val();


    //curso, tipo , fecha y hora .... tutor, sede, tipo de ambiente, ambiente

    $('#select_cur').val(cur_id);
    $('#select_tip_serv').val(tip_serv_id);

    $('#select_usr_tut').val(usr_tut_id);

    $('#datetimepicker1').data("DateTimePicker").setDate(new Date(momentDate));


    $('#myModalUpd').modal('show');




}
function actualizarServicio() {

    alert($('#select_cur').val() + " " + $('#select_tip_serv').val() + " " + $('#select_usr_tut').val());


}




function guardarFormServicio() {


    // var cur_id = $('#curso_ins:disabled');
    $('#servicio_ins').prop('disabled', true);
    $('#servicio_ins').val(0);

    $('#fecha_hora_ins').data("DateTimePicker").disable();
    $('#fecha_hora_ins').data("DateTimePicker").setDate(new Date());

    $('#sede_ins').prop('disabled', true);
    $('#sede_ins').val(0);

    $('#ambiente_ins').prop('disabled', true);
    $('#ambiente_ins').val(0);

    $('#tutor_ins').prop('disabled', true);
    $('#tutor_ins').val(0);

    $('#myModalIns').modal('show');



}

function selectCurso() {
    var cur_id = $('#curso_ins').val();
    if (cur_id > 0) {
        $('#servicio_ins').prop('disabled', false);
    }

    else {
        $('#servicio_ins').prop('disabled', true);
        $('#servicio_ins').val(0);

        $('#fecha_hora_ins').data("DateTimePicker").disable();
        $('#fecha_hora_ins').data("DateTimePicker").setDate(new Date());

        $('#sede_ins').prop('disabled', true);
        $('#sede_ins').val(0);

        $('#ambiente_ins').prop('disabled', true);
        $('#ambiente_ins').val(0);

        $('#tutor_ins').prop('disabled', true);
        $('#tutor_ins').val(0);
    }
}

function selectServicio() {
    var serv_id = $('#servicio_ins').val();
    if (serv_id > 0) {
        $('#fecha_hora_ins').data("DateTimePicker").enable();
        $('#sede_ins').prop('disabled', false);
    }
    else {
        $('#fecha_hora_ins').data("DateTimePicker").disable();
        $('#fecha_hora_ins').data("DateTimePicker").setDate(new Date());

        $('#sede_ins').prop('disabled', true);
        $('#sede_ins').val(0);

        $('#ambiente_ins').prop('disabled', true);
        $('#ambiente_ins').val(0);

        $('#tutor_ins').prop('disabled', true);
        $('#tutor_ins').val(0);
    }
}


//traer datos segun fecha, hora ,tipo de servicio y sede
function selectSede() {
//QRYJSON

    var operation = "QRY_DISP";
    var cur_id = $('#curso_ins').val();
    var tip_serv_id = $('#servicio_ins').val();

    var total_fecha = $('#fecha_hora_ins').data("DateTimePicker").getDate();
    var fecha = moment(total_fecha).format('YYYY-MM-DD');
    var hora = moment(total_fecha).format('HH:mm:ss');


    var sed_id = $('#sede_ins').val();
    var ambiente_ins = $('#ambiente_ins');



    console.log(fecha + " " + hora + " " + tip_serv_id + " " + sed_id);


    var parametros = {
        operation: operation,
        fecha: fecha,
        hora: hora,
        tip_serv_id: tip_serv_id,
        sed_id: sed_id


    };

    if (fecha.length > 0 && hora.length > 0 && tip_serv_id > 0 && sed_id > 0) {

        $.ajax({
            data: parametros,
            url: '/SistemaT/AmbienteServlet',
            type: 'post',
            beforeSend: function () {

            },
            success: function (response) {
                //alert(response);
                console.log(response);

                var Datos = JSON.parse(response);
                ambiente_ins.empty();
                ambiente_ins.append('<option value="0">Seleccione</option>');
                ambiente_ins.prop('disabled', false);
                for (i in Datos) {
                    ambiente_ins.append('<option value="' + Datos[i].amb_id + '">' + Datos[i].amb_den + '</option>');
                    //curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');

                }


            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
    if (sed_id <= 0) {
        ambiente_ins.empty();
        ambiente_ins.append('<option value="0">Seleccione</option>');

        ambiente_ins.prop('disabled', true);
        ambiente_ins.val(0);

        $('#tutor_ins').prop('disabled', true);
        $('#tutor_ins').val(0);
    }
}

function selectAmbiente() {

    var operation = "QRY_DISP";

    var tip_serv_id = $('#servicio_ins').val();

    var total_fecha = $('#fecha_hora_ins').data("DateTimePicker").getDate();
    var fecha = moment(total_fecha).format('YYYY-MM-DD');
    var hora = moment(total_fecha).format('HH:mm:ss');
    var sed_id = $('#sede_ins').val();
    var amb_id = $('#ambiente_ins').val();
    var tutor_ins = $('#tutor_ins');
    var tip_user_id = 2;


    // console.log(fecha + " " + hora + " " + " tipo serv: " + tip_serv_id + " aamb " + amb_id);


    var parametros = {
        operation: operation,
        fecha: fecha,
        hora: hora,
        tip_serv_id: tip_serv_id,
        tip_user_id: tip_user_id


    };

    if (fecha.length > 0 && hora.length > 0 && tip_serv_id > 0 && amb_id > 0) {
        tutor_ins.prop('disabled', false);
        $.ajax({
            data: parametros,
            url: '/SistemaT/UsuarioServlet',
            type: 'post',
            beforeSend: function () {

            },
            success: function (response) {
                // alert(response);
                //console.log(response);

                var Datos = JSON.parse(response);
                tutor_ins.empty();
                tutor_ins.append('<option value="0">Seleccione</option>');
                tutor_ins.prop('disabled', false);
                for (i in Datos) {
                    tutor_ins.append('<option value="' + Datos[i].usr_id + '">' + Datos[i].usr_nom + ' ' + Datos[i].usr_apat + ' ' + Datos[i].usr_amat + '</option>');
                    //curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');

                }


            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
    if (amb_id <= 0) {
        tutor_ins.empty();
        tutor_ins.append('<option value="0">Seleccione</option>');

        tutor_ins.prop('disabled', true);
        tutor_ins.val(0);
    }
}


function guardarServicio() {

    var operation = "INS";

    var tipo_serv_id = $('#servicio_ins').val();

    var total_fecha = $('#fecha_hora_ins').data("DateTimePicker").getDate();
    var ser_edu_fec = moment(total_fecha).format('YYYY-MM-DD');
    var ser_edu_hin = moment(total_fecha).format('HH:mm:ss');

    var sed_id = $('#sede_ins').val();
    var amb_id = $('#ambiente_ins').val();
    var usr_tut_id = $('#tutor_ins').val();
    var curso_id = $('#curso_ins').val();

    var ser_edu_desc = $('#descripcion_ins').val();


    //console.log(tip_serv_id );

    var parametros = {
        operation: operation,
        ser_edu_fec: ser_edu_fec,
        ser_edu_hin: ser_edu_hin,
        curso_id: curso_id,
        amb_id: amb_id,
        sed_id: sed_id,
        tipo_serv_id: tipo_serv_id,
        usr_tut_id: usr_tut_id,
        ser_edu_desc: ser_edu_desc


    };

    if (ser_edu_fec.length > 0 &&
            ser_edu_hin.length > 0 &&
            tipo_serv_id > 0 &&
            curso_id > 0 &&
            amb_id > 0 &&
            sed_id > 0 &&
            usr_tut_id > 0
            ) {
        $.ajax({
            data: parametros,
            url: '/SistemaT/ServicioServlet',
            type: 'post',
            beforeSend: function () {

            },
            success: function (response) {

                if (response === 'error') {

                    alert("no registro" + response);
                }
                else {
                    alert("si registro" + response);

                    $('#mensaje').addClass('alert alert-success');
                    $('#mensaje').html('Curso creado satisfactoriamente');
                    setTimeout(function () {
                        url = "/SistemaT/admin/indexA.jsp";
                        $(location).attr('href', url);
                    }, 2000);
                }



            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });
    }
}

