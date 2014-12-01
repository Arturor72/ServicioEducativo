/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
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
});*/





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






$(function () {

    $("#fecha_hora_srch").on("dp.change", function (e) {
        $("#servicio").css({"left": "-10px"});
        $("#servicio").css({"opacity": "0.2"});

        $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);

        var total_fecha = e.date;
        var mes = moment(total_fecha).format('MM');
        var anio = moment(total_fecha).format('YYYY');
        alert(mes +"-" +anio);
        var operation = 'REPORT_THM';

        var parametros = {
            operation: operation,
            mes:mes,
            anio:anio

        };


        $.ajax({
            data: parametros,
            url: '/SistemaT/ReportServlet',
            type: 'post',
            beforeSend: function () {
                $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                  //  console.log(response);
                 //   alert(response);
                var Datos = JSON.parse(response);
               //alert(Datos[0].error);
                if (Datos[0].error!== "vacio") {
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


