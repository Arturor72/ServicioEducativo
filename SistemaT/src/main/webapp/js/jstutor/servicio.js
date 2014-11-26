/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {

    cargarServicios();
    /*
     for(var i=0; i<18;i++){
     
     $('#my-clock-'+i).
     countdown("2014/11/25 22:19:00", function(event) {
     
     
     
     var duration=event.strftime('%M:%S');
     
     if(duration<='15:00'){
     
     $(this).text(duration);
     }
     
     if(duration==='00:00'){
     $(this).text('duration'); 
     } 
     
     
     
     });
     }
     */
    /* $("#clock")
     .countdown("2015/01/01", function(event) {
     $(this).text(
     event.strftime('%D days %H:%M:%S')
     );
     });
     */

    // alert("sadasd");
    //alert(moment());
    /*  var then = "21/11/2014 11:00:00";
     var now=moment();
     //var time =moment(moment(),"DD/MM/YYYY HH:mm:ss").diff(moment(then,"DD/MM/YYYY HH:mm:ss")).format("HH:mm:ss");
     
     var t1 =now.diff(then);
     alert(t1);
     var time =then.diff(now);
     
     alert(time);
     */
    /*
     //var now  = "04/09/2013 15:00:00";
     var now = moment();
     var then = "21/11/2014 11:15:00";
     
     var ms = moment(now, "DD/MM/YYYY HH:mm:ss").diff(moment(then, "DD/MM/YYYY HH:mm:ss"));
     var d = moment.duration(ms);
     //var s = Math.floor(d.asHours()) + moment.utc(ms).format(":mm:ss");
     var s = moment.utc(d.asMilliseconds()).format("HH:mm:ss");
     alert(s);
     //alert(milliseccondsToTime(time));
     */







});

function milliseccondsToTime(duration) {
    var seconds = parseInt((duration / 1000) % 60)
            , minutes = parseInt((duration / (1000 * 60)) % 60)
            , hours = parseInt((duration / (1000 * 60 * 60)) % 24)
            , days = parseInt(duration / (1000 * 60 * 60 * 24));

    var hoursDays = parseInt(days * 24);
    hours += hoursDays;
    hours = (hours < 10) ? "0" + hours : hours;
    minutes = (minutes < 10) ? "0" + minutes : minutes;
    seconds = (seconds < 10) ? "0" + seconds : seconds;
    return hours + ":" + minutes + ":" + seconds;
}



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



        },
        complete: function () {
            var response = $('#response').val();
            
            var Datos = JSON.parse(response);
            console.log("largo: " +Datos.length);    
            displayClock(Datos);
 
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
        var disabledConfirm = 'disabled';
        var disabledReg = 'disabled';
        var confirmar = '';

        if (estado === 1) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-purple">' + fecha + '</span></li>';
            disabledConfirm = 'enable';
            disabledReg = '';
            confirmar = 'Confirmar';
        }
        if (estado === 2) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-yellow">' + fecha + '</span></li>';
            disabledConfirm = 'disabled';
            disabledReg = '';
            confirmar = 'Confimado';
        }

        if (estado === 3) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-green">' + fecha + '</span></li>';
            disabledConfirm = 'disabled';
            disabledReg = 'disabled';
            confirmar = 'Confimado';
        }

        if (estado === 4) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-red">' + fecha + '</span></li>';
            disabledConfirm = 'disabled';
            disabledReg = 'disabled';
            confirmar = 'Confimado';
        }

        if (estado === 5) {
            servicio_head = '<li class="time-label"><span id="headConfirm-' + Datos[i].ser_edu_id + '" class="bg-red">' + fecha + '</span></li>';
            disabledConfirm = 'disabled';
            disabledReg = 'disabled';
            confirmar = 'Confimado';
        }




        var duracion = '';
        if (Datos[i].tip_serv_id === 1) {
            duracion = '<span class="time"><i class="fa fa-clock-o"></i>' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).format('HH:mm') + ' a ' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).add(2, 'hours').format('HH:mm') + '</span>';
        }
        else {
            duracion = '<span class="time"><i class="fa fa-clock-o"></i>' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).format('HH:mm') + ' a ' + moment(Datos[i].ser_edu_fec + ' ' + Datos[i].ser_edu_hin).add(1, 'hours').format('HH:mm') + '</span>';
        }
        var reloj = '<span id="clock-' + Datos[i].ser_edu_id + '"></span>';

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
                // + disabledConfirm +
                '<a class="btn btn-primary btn-xs" id="btnConfirm-' + Datos[i].ser_edu_id + '" onclick="confirmar(' + Datos[i].ser_edu_id + ')"  ' + disabledConfirm + '>' + reloj + ' ' + confirmar + ' </a>' +
                //'<a class="btn btn-primary btn-xs disabled" id="btnConfirm-' + Datos[i].ser_edu_id + '" onclick="confirmar(' + Datos[i].ser_edu_id + ')" >' + reloj + ' ' + confirmar + ' </a>' +
                '<a class="btn btn-primary btn-xs" onclick="registrarFormAlumno(' + Datos[i].ser_edu_id + ')"  ' + disabledReg + ' >Registrar</a>' +
                '</div>' +
                '</div>' +
                '</li>';
        $('#servicio').append(servicio_head + servicio_body);
//displayTime(Datos[i].ser_edu_id);
    }
    var response = JSON.stringify(Datos);
    $('#response').val(response);
    // $("#servicio").append('<div  id="response">' + response + '</div>');
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
        var operation = 'QRY_SEARCH_TUTOR';
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
    var operation = 'QRY_SEARCH_SEDE_TUTOR';
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

    $('#ser-id').val(id);
    //$('#myModalIns').modal('show');

    setTimeout(function () {
        $('#myModalIns').modal('show');
    }, 1000);


}







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
    var tabla = $('#tblAlumno').dataTable();
    $.ajax({
        data: parametros,
        url: '/SistemaT/AlumnoServlet',
        type: 'post',
        beforeSend: function () {
            // $('body').modalmanager('loading');
            //  var path = window.location.host;

            $('body').modalmanager('loading');

        },
        success: function (response) {

            console.log(response);

            var Datos = JSON.parse(response);
            agregarAlumnos(Datos, tabla);


        },
        complete: function () {


        },
        error: function (result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
}


function agregarAlumnos(Datos, tabla) {
    tabla.fnClearTable();
    //alert(Datos.length);
    for (i in Datos) {
        tabla.fnAddData([
            Datos[i].al_cod,
            Datos[i].al_nom,
            Datos[i].al_apat + ' ' + Datos[i].al_amat,
            '<input class="center-block" name="INS" type="checkbox" value="' + Datos[i].al_id + '">'
        ]);
    }

}
function guardarAlumnos() {
    var ids = [];

    var serEduId = $('#ser-id').val();
    $("input[name='INS']:checked").each(function () {

        ids.push($(this).val());

    });
    console.log(serEduId);


    var alId = ids.toString();
    //alert(ids.toString());
    var operation = 'INS';
    // var serEduId=;
    var parametros = {
        operation: operation,
        serEduId: serEduId,
        alId: alId

    };
    if (alId.length > 0) {
        $.ajax({
            data: parametros,
            url: '/SistemaT/AsistenciaServlet',
            type: 'post',
            beforeSend: function () {
                //var path = window.location.host;
                // $("#servicio").html('<img  class="center-block" src="http://'+path+'//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                if (response === 'error') {

                    $('#mensaje_ins').empty();
                    $('#mensaje_ins').addClass('alert alert-danger');
                    $('#mensaje_ins').html('No se pudo completar el registro');
                }
                else {
                    // alert("si registro" + response);
                    $('#mensaje_ins').empty();
                    $('#mensaje_ins').removeClass('alert alert-danger');
                    $('#mensaje_ins').addClass('alert alert-success');
                    $('#mensaje_ins').html(response);
                    setTimeout(function () {
                        url = "/SistemaT/p_tutor/indexT.jsp";
                        $(location).attr('href', url);
                    }, 2000);
                }
            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
    else {
        $('#mensaje_ins').empty();
        $('#mensaje_ins').addClass('alert alert-danger');
        $('#mensaje_ins').html('No se ha seleccionado ningun alumno');

    }
}


function relog() {


}
function displayTime(Datos) {

    var now = moment();

    for (i in Datos) {

        //var then = "21/11/2014 11:50:00";

        var then = Datos[i].ser_edu_fec + " " + Datos[i].ser_edu_hin;
        console.log("mi i" + i + "     esto es el ms=" + ms);
        var ms = moment(then, "DD/MM/YYYY HH:mm:ss").diff(moment(now, "DD/MM/YYYY HH:mm:ss"));
        console.log("..----.--");

        console.log("mi i" + i + "     esto es el ms=" + ms);
        var d = moment.duration(ms);
        var s = moment.utc(d.asMilliseconds()).format("mm:ss");
        $('#clock-' + Datos[i].ser_edu_id).html(s + " " + d);
        /*  if(d<=900000){
         
         // console.log(i+" " + s);
         //console.log("otra vez");
         
         }
         else{
         console.log(i+" " + s);
         $('#clock-' + Datos[i].ser_edu_id).html("");
         }*/

    }

    setTimeout(function () {
        displayTime(Datos)
    }, 1000);
}




function secondPassed(row) {
    var seconds = timerData[row].remaining;
    var minutes = Math.round((seconds - 30) / 60);
    var remainingSeconds = seconds % 60;
    if (remainingSeconds < 10) {
        remainingSeconds = "0" + remainingSeconds;
    }
    $('#clock' + row).html(minutes + ":" + remainingSeconds);
    //document.getElementById('clock' + row).innerHTML = minutes + ":" + remainingSeconds;
    if (seconds == 0) {
        clearInterval(timerData[row].timerId);
        //document.getElementById('clock' + row).innerHTML = "Buzz Buzz";
        $('#clock' + row).html("Buzz Buzz");
    } else {
        seconds--;
    }
    timerData[row].remaining = seconds;
}

function timer(row, min) {
    timerData[row] = {
        remaining: min * 60,
        timerId: setInterval(function () {
            secondPassed(row);
        }, 1000)
    };
}

function displayClock(Datos) {
/*


           for (i in Datos) {

                $("#clock-" + Datos[i].ser_edu_id).countdown(Datos[i].ser_edu_fec + " " + Datos[i].ser_edu_hin, function (event) {
                  
                    var duracion = event.strftime('%M:%S');
                   var btnConfirm=$('#btnConfirm-' + Datos[i].ser_edu_id);
                    //console.log("i= "+i+ "    duracion "+duracion);



                    if (duracion <= '15:00') {
                         console.log("i= "+i+ "    duracion "+duracion);
                        btnConfirm.removeClass('disabled');
                        $(this).text(duracion);

                    }


                    if (duracion === '00:00') {
                         console.log("i= "+i+ "    duracion "+duracion);
                        btnConfirm.addClass('disabled');
                        $(this).text('duration');
                      

                    }
                });
            }*/
        }