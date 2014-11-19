/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    $("#servicio").css({"left": "-10px"});
    $("#servicio").css({"opacity": "0.2"});

    $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);
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
            $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
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

    var curso_upd = $('#curso_upd');
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
                curso_upd.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');
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
    var sede_upd = $('#sede_upd');
    var sede_srch = $('#sede_srch');


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
                sede_upd.append('<option value="' + Datos[i].sed_id + '">' + Datos[i].sed_desc + '</option>');
                sede_srch.append('<option value="' + Datos[i].sed_id + '">' + Datos[i].sed_desc + '</option>');

            }

        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });

});


function agregarServicios(Datos) {


    $('#servicio').empty();
    for (i in Datos) {
        var fecha=moment(Datos[i].ser_edu_fec).lang("es").format('ll');
        var servicio_head = '';
        var estado=Datos[i].ser_edu_est;
        if(estado===1){
          servicio_head = '<li class="time-label"><span class="bg-purple">' + fecha + '</span></li>';  
            
        }
        if(estado===2){
          servicio_head = '<li class="time-label"><span class="bg-yellow">' + fecha + '</span></li>';  
            
        }
        
        if(estado===3){
          servicio_head = '<li class="time-label"><span class="bg-green">' + fecha + '</span></li>';  
            
        }
        
        if(estado===4){
          servicio_head = '<li class="time-label"><span class="bg-red">' + fecha + '</span></li>';  
            
        }
        
         if(estado===5){
          servicio_head = '<li class="time-label"><span class="bg-red">' + fecha + '</span></li>';  
            
        }
        
        
        var duracion = '';
        if (Datos[i].tip_serv_id === 1) {
            duracion = '<span class="time"><i class="fa fa-clock-o"></i>' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).format('HH:mm') + ' a ' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).add(2, 'hours').format('HH:mm') + '</span>';

        }
        else {
            duracion = '<span class="time"><i class="fa fa-clock-o"></i>' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).format('HH:mm') + ' a ' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).add(1, 'hours').format('HH:mm') + '</span>';

        }

        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                duracion +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].ser_edu_id + '">' + Datos[i].tip_serv_den + ' - ' + Datos[i].cur_nom + '</a></h3>' +
                '<div class="timeline-body panel-collapse collapse" id="' + Datos[i].ser_edu_id + '">' +
                //curso, tipo de servicio, fecha y hora .... tutor, sede, tipo de ambiente, ambiente
                //texarea

                //enviar codigo de sede, fecha, y la hora codigo tipo amb
                //aula 1 , laboratorio 2

                '<div class="callout callout-info">' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_id" value="' + Datos[i].ser_edu_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-cur_id" value="' + Datos[i].cur_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-tip_serv_id" value="' + Datos[i].tip_serv_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_fec" value="' + Datos[i].ser_edu_fec + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_hin" value="' + Datos[i].ser_edu_hin + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_id" value="' + Datos[i].usr_tut_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-sed_id" value="' + Datos[i].sed_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-sed_desc" value="' + Datos[i].sed_desc + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-amb_id" value="' + Datos[i].amb_id + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_desc" value="' + Datos[i].ser_edu_desc + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_nom" value="' + Datos[i].usr_tut_nom + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_apat" value="' + Datos[i].usr_tut_apat + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_amat" value="' + Datos[i].usr_tut_amat + '" />' +
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-amb_den" value="' + Datos[i].amb_den + '" />' +
                '<label>Sede: </label><span> ' + Datos[i].sed_desc + '</span><br/>' +
                '<label>Aula/Labortorio: </label><span> ' + Datos[i].amb_den + '</span><br/>' +
                '<label>Tutor: </label><span> ' + Datos[i].usr_tut_nom + ' ' + Datos[i].usr_tut_apat + ' ' + Datos[i].usr_tut_amat + '</span><br/>' +
                '<label>Descripción: </label><span> ' + Datos[i].ser_edu_desc + '</span><br/>' +
                //'<label>Creado por: </label><span> ' + Datos[i].ser_edu_desc + '</span><br/>' +
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
    $('#fecha_hora_upd').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es'
    });


    $('#fecha_hora_ins').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es'
    });


    $('#fecha_hora_srch').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es',
        pickTime: false,
        useCurrent: false, //when true, picker will set the value to the current date/time     

        showToday: true
    });


});





function guardarFormServicio() {


    // var cur_id = $('#curso_ins:disabled');
    $('#servicio_ins').prop('disabled', true);
    $('#servicio_ins').val(0);

    $('#fecha_hora_ins').data("DateTimePicker").disable();
    $('#fecha_hora_ins').data("DateTimePicker").setDate(new Date());

    $('#fecha_hora_ins').data("DateTimePicker").setMinDate(new Date());



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
    var hora = moment(total_fecha).format('HH:mm:00');


    var sed_id = $('#sede_ins').val();
    var ambiente_ins = $('#ambiente_ins');

    var tutor_ins = $('#tutor_ins');
    var ins;
    buscarSede(operation, fecha, hora, tip_serv_id, sed_id, ambiente_ins, tutor_ins, ins);


}

function selectAmbiente() {

    var operation = "QRY_DISP";

    var tip_serv_id = $('#servicio_ins').val();

    var total_fecha = $('#fecha_hora_ins').data("DateTimePicker").getDate();
    var fecha = moment(total_fecha).format('YYYY-MM-DD');
    var hora = moment(total_fecha).format('HH:mm:00');

    var sed_id = $('#sede_ins').val();
    var amb_id = $('#ambiente_ins').val();
    var tutor_ins = $('#tutor_ins');
    var tip_user_id = 2;
    var ins;
    buscarTutor(operation, fecha, hora, tip_serv_id, tip_user_id, tutor_ins, amb_id, ins);


}


function guardarServicio() {

    var operation = "INS";

    var tipo_serv_id = $('#servicio_ins').val();

    var total_fecha = $('#fecha_hora_ins').data("DateTimePicker").getDate();
    var ser_edu_fec = moment(total_fecha).format('YYYY-MM-DD');
    var ser_edu_hin = moment(total_fecha).format('HH:mm:00');

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


                    $('#mensaje_ins').addClass('alert alert-danger');
                    $('#mensaje_ins').html('Servicio no se pudo crear');
                }
                else {
                    // alert("si registro" + response);

                    $('#mensaje_ins').addClass('alert alert-success');
                    $('#mensaje_ins').html('Servicio creado satisfactoriamente');
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




//amb_den, sed_desc
function editarFormServicio(id) {

    //seteando valores en el formulario
    //enviar codigo de sede, fecha, y la hora codigo tipo amb
    var ser_edu_id = $('#' + id + '-ser_edu_id').val();


    var cur_id = $('#' + id + '-cur_id').val();

    var tip_serv_id = $('#' + id + '-tip_serv_id').val();

    var ser_edu_fec = $('#' + id + '-ser_edu_fec').val();
    var ser_edu_hin = $('#' + id + '-ser_edu_hin').val();

    var momentDate = moment(ser_edu_fec + " " + ser_edu_hin);
    var sed_id = $('#' + id + '-sed_id').val();

    var amb_id = $('#' + id + '-amb_id').val();
    var amb_den = $('#' + id + '-amb_den').val();



    var usr_tut_id = $('#' + id + '-usr_tut_id').val();
    var usr_tut_nom = $('#' + id + '-usr_tut_nom').val();
    var usr_tut_apat = $('#' + id + '-usr_tut_apat').val();
    var usr_tut_amat = $('#' + id + '-usr_tut_amat').val();

    var ser_edu_desc = $('#' + id + '-ser_edu_desc').val();



    //curso, tipo , fecha y hora .... tutor, sede, tipo de ambiente, ambiente

    //cargando data
    $('#id_upd').val(ser_edu_id);

    $('#curso_upd').val(cur_id);
    $('#servicio_upd').val(tip_serv_id);

    $('#sede_upd').val(sed_id);

    $('#ambiente_upd').append('<option value="' + amb_id + '">' + amb_den + '</option>');
    $('#ambiente_upd').val(amb_id);

    $('#tutor_upd').append('<option value="' + usr_tut_id + '">' + usr_tut_nom + ' ' + usr_tut_apat + ' ' + usr_tut_amat + '</option>');
    $('#tutor_upd').val(usr_tut_id);


    $('#descripcion_upd').val(ser_edu_desc);

    $('#fecha_hora_upd').data("DateTimePicker").setDate(new Date(momentDate));
    $('#servicio_upd').prop('disabled', true);
    $('#fecha_hora_upd').data("DateTimePicker").disable();
    $('#fecha_hora_upd').data("DateTimePicker").setMinDate(new Date());
    $('#sede_upd').prop('disabled', true);
    $('#ambiente_upd').prop('disabled', true);
    $('#tutor_upd').prop('disabled', true);






    $('#myModalUpd').modal('show');


}


function selectCursoUpd() {
    var cur_id = $('#curso_upd').val();
    if (cur_id > 0) {
        $('#servicio_upd').prop('disabled', false);

    }

    else {
        $('#servicio_upd').prop('disabled', true);
        $('#servicio_upd').val(0);

        $('#fecha_hora_upd').data("DateTimePicker").disable();
        $('#fecha_hora_upd').data("DateTimePicker").setDate(new Date());

        $('#sede_upd').prop('disabled', true);
        $('#sede_upd').val(0);

        $('#ambiente_upd').prop('disabled', true);
        $('#ambiente_upd').val(0);

        $('#tutor_upd').prop('disabled', true);
        $('#tutor_upd').val(0);
    }
}

function selectServicioUpd() {
    var serv_id = $('#servicio_upd').val();
    if (serv_id > 0) {
        $('#fecha_hora_upd').data("DateTimePicker").enable();
        $('#sede_upd').prop('disabled', false);
    }
    else {
        $('#fecha_hora_upd').data("DateTimePicker").disable();
        $('#fecha_hora_upd').data("DateTimePicker").setDate(new Date());

        $('#sede_upd').prop('disabled', true);
        $('#sede_upd').val(0);

        $('#ambiente_upd').prop('disabled', true);
        $('#ambiente_upd').val(0);

        $('#tutor_upd').prop('disabled', true);
        $('#tutor_upd').val(0);
    }
}


//traer datos segun fecha, hora ,tipo de servicio y sede
function selectSedeUpd() {
//QRYJSON

    var operation = "QRY_DISP";
    var cur_id = $('#curso_upd').val();
    var tip_serv_id = $('#servicio_upd').val();

    var total_fecha = $('#fecha_hora_upd').data("DateTimePicker").getDate();
    var fecha = moment(total_fecha).format('YYYY-MM-DD');
    var hora = moment(total_fecha).format('HH:mm:00');


    var sed_id = $('#sede_upd').val();
    var ambiente_ins = $('#ambiente_upd');

    var tutor_ins = $('#tutor_upd');
    var ins;
    buscarSede(operation, fecha, hora, tip_serv_id, sed_id, ambiente_ins, tutor_ins, ins);


}

function selectAmbienteUpd() {

    var operation = "QRY_DISP";

    var tip_serv_id = $('#servicio_upd').val();

    var total_fecha = $('#fecha_hora_upd').data("DateTimePicker").getDate();
    var fecha = moment(total_fecha).format('YYYY-MM-DD');
    var hora = moment(total_fecha).format('HH:mm:00');

    var sed_id = $('#sede_upd').val();
    var amb_id = $('#ambiente_upd').val();
    var tutor_ins = $('#tutor_upd');
    var tip_user_id = 2;
    var ins;
    buscarTutor(operation, fecha, hora, tip_serv_id, tip_user_id, tutor_ins, amb_id, ins);


}

function editarServicio() {

    var operation = "UPD";
    var serv_edu_id = $('#id_upd').val();
    var tipo_serv_id = $('#servicio_upd').val();

    //var ser_edu_id = $('#' + id + '-ser_edu_id').val();
    // alert();
    var total_fecha = $('#fecha_hora_upd').data("DateTimePicker").getDate();
    var ser_edu_fec = moment(total_fecha).format('YYYY-MM-DD');
    var ser_edu_hin = moment(total_fecha).format('HH:mm:00');

    var sed_id = $('#sede_upd').val();
    var amb_id = $('#ambiente_upd').val();
    var usr_tut_id = $('#tutor_upd').val();
    var curso_id = $('#curso_upd').val();

    var ser_edu_desc = $('#descripcion_upd').val();


    //console.log(tip_serv_id );

    var parametros = {
        operation: operation,
        serv_edu_id: serv_edu_id,
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


                    $('#mensaje_upd').addClass('alert alert-danger');
                    $('#mensaje_upd').html('Servicio no se pudo actualizar');
                }
                else {
                    // alert("si registro" + response);

                    $('#mensaje_upd').addClass('alert alert-success');
                    $('#mensaje_upd').html('Servicio actualizado satisfactoriamente');
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


    // alert($('#curso_upd').val() + " " + $('#servicio_upd').val() + " " + $('#tutor_upd').val());


}


function buscarSede(operation, fecha, hora, tip_serv_id, sed_id, ambiente_select, tutor_select, amb_id, forma) {

    // console.log(fecha + " " + hora + " " + tip_serv_id + " " + sed_id);


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
                ambiente_select.empty();
                ambiente_select.append('<option value="0">Seleccione</option>');
                ambiente_select.prop('disabled', false);
                for (i in Datos) {
                    ambiente_select.append('<option value="' + Datos[i].amb_id + '">' + Datos[i].amb_den + '</option>');
                    //curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');



                }




            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
    if (sed_id <= 0) {
        ambiente_select.empty();
        ambiente_select.append('<option value="0">Seleccione</option>');

        ambiente_select.prop('disabled', true);
        ambiente_select.val(0);

        tutor_select.prop('disabled', true);
        tutor_select.val(0);
    }
}




function buscarTutor(operation, fecha, hora, tip_serv_id, tip_user_id, select_tutor, amb_id, forma) {

    var parametros = {
        operation: operation,
        fecha: fecha,
        hora: hora,
        tip_serv_id: tip_serv_id,
        tip_user_id: tip_user_id


    };

    if (fecha.length > 0 && hora.length > 0 && tip_serv_id > 0 && amb_id > 0) {
        select_tutor.prop('disabled', false);
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
                select_tutor.empty();
                select_tutor.append('<option value="0">Seleccione</option>');
                select_tutor.prop('disabled', false);
                for (i in Datos) {
                    select_tutor.append('<option value="' + Datos[i].usr_id + '">' + Datos[i].usr_nom + ' ' + Datos[i].usr_apat + ' ' + Datos[i].usr_amat + '</option>');
                    //curso_ins.append('<option value="' + Datos[i].cur_id + '">' + Datos[i].cur_nom + '</option>');

                }


            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
    if (amb_id <= 0) {
        select_tutor.empty();
        select_tutor.append('<option value="0">Seleccione</option>');

        select_tutor.prop('disabled', true);
        select_tutor.val(0);
    }

}





function buscarServicio() {
    $("#servicio").css({"left": "-10px"});
    $("#servicio").css({"opacity": "0.2"});

    $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);
    var operation = 'QRY';

    var parametros = {
        operation: operation
    };


    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function () {
            //    var path = window.location.host;
            //$("#servicio").html("Procesando, espere por favor...");
            // $('#servicio').append('<div class="loading-img"></div>'); 
            // $('#servicio').html('<img src="'+path+'/SistemaT/img/cargando.GIF"/>'); 
        },
        success: function (response) {
            //console.log(response);

            var Datos = JSON.parse(response);
            agregarServicios(Datos);

        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });



}





$(function () {

    $("#fecha_hora_srch").on("dp.change", function (e) {
        $("#servicio").css({"left": "-10px"});
        $("#servicio").css({"opacity": "0.2"});

        $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);

        var total_fecha = e.date;
        var ser_edu_fec = moment(total_fecha).format('YYYY-MM-DD');

        var operation = 'QRY_SEARCH';

        var parametros = {
            operation: operation,
            ser_edu_fec: ser_edu_fec

        };


        $.ajax({
            data: parametros,
            url: '/SistemaT/ServicioServlet',
            type: 'post',
            beforeSend: function () {
                $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                console.log(response);

                var Datos = JSON.parse(response);

                if (Datos.length > 0) {
                    $("#alerta").empty();
                    agregarServicios(Datos);
                }
                else {
                    var alerta = '<div class="callout callout-danger">' +
                            '<h4>Busqueda</h4>' +
                            '<p>No se encontraron resultados</p>' +
                            '</div>';
                    $('#servicio').empty();
                    $("#alerta").html(alerta);

                    $("#alerta").css({"left": "-10px"});
                    $("#alerta").css({"opacity": "0.2"});

                    $("#alerta").animate({"left": "10px", "opacity": "1"}, 1000);
                }


            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });


    });

});


function selectSedeSrch() {
    $("#servicio").css({"left": "-10px"});
    $("#servicio").css({"opacity": "0.2"});

    $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);
    var operation = 'QRY_SEARCH_SEDE';
    var sed_id = $('#sede_srch').val();


    var parametros = {
        operation: operation,
        sed_id: sed_id

    };

    if (sed_id > 0) {
        $.ajax({
            data: parametros,
            url: '/SistemaT/ServicioServlet',
            type: 'post',
            beforeSend: function () {
                var path = window.location.host;
                $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                console.log(response);

                var Datos = JSON.parse(response);
                //console.log( Datos.error);
                if (Datos.length > 0) {

                    $("#alerta").empty();
                    agregarServicios(Datos);
                }

                else {
                    var alerta = '<div class="callout callout-danger">' +
                            '<h4>Busqueda</h4>' +
                            '<p>No se encontraron resultados</p>' +
                            '</div>';
                    $('#servicio').empty();
                    $("#alerta").html(alerta);

                    $("#alerta").css({"left": "-10px"});
                    $("#alerta").css({"opacity": "0.2"});

                    $("#alerta").animate({"left": "10px", "opacity": "1"}, 1000);
                }



            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
}

