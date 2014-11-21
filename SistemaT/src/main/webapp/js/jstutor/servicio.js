/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    cargarServicios();
    //  var response=$('#response').get().innerHTML;


    //  alert($('#response'));
    // alert(response);
    //var Datos=JSON.parse(response);    
    //setTimeout(displayTime(Datos), 1000);


});
function  buscarServicio() {
    cargarServicios();
}
function cargarServicios() {


    $("#servicio").css({"left": "-10px"});
    $("#servicio").css({"opacity": "0.2"});
    $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);
    //  var operation = 'QRY';
    var operation = 'QRY_BY_TUTOR';
    var parametros = {
        operation: operation
    };
    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function () {
            var path = window.location.host;
            $("#servicio").html('<img  class="center-block" src="http://' + path + '//SistemaT/img/load.GIF"/>');
        },
        success: function (response) {



            var Datos = JSON.parse(response);
            agregarServicios(Datos);
            // displayTime(Datos);


        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
}


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
            // alert(response);
            //console.log(response);

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

        var fecha = moment(Datos[i].ser_edu_fec).lang("es").format('ll');
        var servicio_head = '';
        var estado = Datos[i].ser_edu_est;
        var disabled = 'disabled';
        var confirmar = '';
        if (estado === 1) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-purple">' + fecha + '</span></li>';
            disabled = '';
            confirmar = 'Confirmar';
        }
        if (estado === 2) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-yellow">' + fecha + '</span></li>';
            disabled = 'disabled';
            confirmar = 'Confimado';
        }

        if (estado === 3) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-green">' + fecha + '</span></li>';
            disabled = 'disabled';
            confirmar = 'Confimado';
        }

        if (estado === 4) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-red">' + fecha + '</span></li>';
            disabled = 'disabled';
            confirmar = 'Confimado';
        }

        if (estado === 5) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-red">' + fecha + '</span></li>';
            disabled = 'disabled';
            confirmar = 'Confimado';
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
                '<div id="clock-' + Datos[i].ser_edu_id + '"></div>' +
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
                '<a class="btn btn-primary btn-xs" id="btnConfirm-' + Datos[i].ser_edu_id + '" onclick="confirmar(' + Datos[i].ser_edu_id + ')"  ' + disabled + '>' + confirmar + ' </a>' +
                '<a class="btn btn-primary btn-xs" onclick="registrarFormAlumno(' + Datos[i].ser_edu_id + ')"  >Registrar</a>' +
                '</div>' +
                '</div>' +
                '</li>';
        $('#servicio').append(servicio_head + servicio_body);
//displayTime(Datos[i].ser_edu_id);
    }
    var response = JSON.stringify(Datos);
    $("#servicio").append('<div  id="response">' + response + '</div>');
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
function confirmar(id) {
    var path = window.location.host;
    var btn = $('#btnConfirm-' + id);
    var head = $('#headConfirm-' + id);
//alert(tag);
    var operation = 'OPERATION_INS_ASIST';
    var ser_edu_id = id;
    var parametros = {
        operation: operation,
        ser_edu_id: ser_edu_id
    };
    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function () {

            // $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');

            //tag.html('Cargando <img  width="16px" height="auto" class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
            //tag.html('Cargando...');

            setTimeout(btn.html('Cargando<img  width="16px" height="16px" class="center-block" src="http://' + path + '//SistemaT/img/load.GIF"/>'), 5000);
            /* setTimeout(function() {
             tag.addClass('disabled');
             tag.html('Cargando <img  width="16px" height="auto" class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
             }, 1000);*/
        },
        success: function (response) {
            //console.log(response);

            var Datos = JSON.parse(response);
            if (Datos[0].respuesta === 1) {


                /*  head.animate({"opacity": "0.5"}, 3000);
                 head.removeClass('bg-purple')
                 
                 
                 head.animate({"opacity": "1"}, 3000);
                 head.addClass('bg-yellow');*/
                // head.removeClass( "bg-purple", 1000 );
                //  head.addClass( "bg-yellow", 1000 );
                //head.switchClass( "bg-purple", "bg-yellow", 1000 );

                head.addClass("bg-yellow").removeClass("bg-purple");
                //head.css({"opacity": "0.2"});
                btn.addClass('disabled');
                btn.html('Confirmado');
            }



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


function registrarFormAlumno(id) {
    cargarAlumnos();
    $('#myModalIns').modal('show');
}
function displayTime(Datos) {
    var time = moment().format('HH:mm:ss');
//$('#clock-'+id).html(time);

    for (i in Datos) {
        $('#clock-' + Datos[i].ser_edu_id).html(time);
    }

    setTimeout(displayTime(Datos), 1000);
}

$(function () {


});
function cargarAlumnos() {

    /*
     $("#servicio").css({"left": "-10px"});
     $("#servicio").css({"opacity": "0.2"});
     
     $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);*/
    //  var operation = 'QRY';
    var operation = 'QRY_ALUMNOS';
    var parametros = {
        operation: operation
    };
    $.ajax({
        data: parametros,
        url: '/SistemaT/AlumnoServlet',
        type: 'post',
        beforeSend: function () {
            /*var path = window.location.host;
             $("#servicio").html('<img  class="center-block" src="http://'+path+'//SistemaT/img/load.GIF"/>');*/
        },
        success: function (response) {



            var Datos = JSON.parse(response);
            agregarAlumnos(Datos);
            // displayTime(Datos);


        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
}


function agregarAlumnos(Datos) {
    for (i in Datos) {

        var fila = '<tr>' +
                '<td>' + Datos[i].codigo + '</td>' +
                '<td>' + Datos[i].codigo + '</td>' +
                '<td>' + Datos[i].codigo + '</td>' +
                '<td> <input type="checkbox" value="' + Datos[i].codigo + '"> </td>' +
                '</tr>';
        $('#tblAlumno').append(fila);
    }


}