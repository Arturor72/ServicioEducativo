/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function agregarRerporTHM(Datos) {


    $('#servicio').empty();
    for (i in Datos) {

        var servicio_head = '';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-clock-o"></i> ' + Datos[i].report_mes + ' hora(s)</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].usr_tut_id + '">' + Datos[i].usr_tut_nom + ' ' + Datos[i].usr_tut_apat + ' ' + Datos[i].usr_tut_amat + '</a></h3>' +
                '<div class="timeline-body panel-collapse collapse" id="' + Datos[i].usr_tut_id + '">' +
                '<div class="callout callout-info">' +
                '<label>Codigo: </label><span> ' + Datos[i].usr_tut_cod + '</span><br/>' +
                '<label>Mail: </label><span> ' + Datos[i].usr_tut_user + '</span><br/>' +
                '</div>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#servicio').append(servicio_head + servicio_body);

    }

}


$(function() {

    $('#fecha_hora_srch').datetimepicker({
        pick12HourFormat: false,
        minuteStepping: 1,
        language: 'es',
        pickTime: false,
        useCurrent: false, //when true, picker will set the value to the current date/time     

        showToday: true
    });


});

$(function() {
    var curparametros = {
        operation: "QRYJSON"
    };
    $.ajax({
        data: curparametros,
        url: '/SistemaT/CursoServlet',
        type: 'post',
        beforeSend: function() {
            $("#servicio").html('<img  class="center-block" src="http://localhost:8084/SistemaT/img/load.GIF"/>');
        },
        success: function(response) {
            console.log(response);
            console.log("--------------->"+response);
            var Datos = JSON.parse(response);
            var mhtml="";
            for (i in Datos) {
                mhtml+="<option value=\""+Datos[i].cur_id+"\" selected>"+Datos[i].cur_nom+"</option>"
            }
            $("#cursoTC").html(mhtml);

        },
        error: function(result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
});




$(function() {

    $("#fecha_hora_srch").on("dp.change", function(e) {
        $("#servicio").css({"left": "-10px"});
        $("#servicio").css({"opacity": "0.2"});

        $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);

        var total_fecha = e.date;
        var mes = moment(total_fecha).format('MM');
        var anio = moment(total_fecha).format('YYYY');

        var operation = 'REPORT_THM';

        var parametros = {
            operation: operation,
            mes: mes,
            anio: anio

        };


        $.ajax({
            data: parametros,
            url: '/SistemaT/ReportServlet',
            type: 'post',
            beforeSend: function() {
                $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
            },
            success: function(response) {
                console.log(response);
                //   alert(response);
                var Datos = JSON.parse(response);
                //alert(Datos[0].error);
                if (Datos[0].error !== "vacio") {
                    $("#alerta").empty();
                    agregarRerporTHM(Datos);
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
            error: function(result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });


    });

});






/**TC**/

function agregarRerporTC(Datos) {


    $('#servicio').empty();
    for (i in Datos) {

        var servicio_head = '';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-folder"></i> ' + Datos[i].cur_nom + '</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].usr_tut_id + '">' + Datos[i].usr_tut_nom + ' ' + Datos[i].usr_tut_apat + ' ' + Datos[i].usr_tut_amat + '</a></h3>' +
               
                '</div>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#servicio').append(servicio_head + servicio_body);

    }

}


function selectServicio() {
    $("#servicio").css({"left": "-10px"});
    $("#servicio").css({"opacity": "0.2"});

    $("#servicio").animate({"left": "10px", "opacity": "1"}, 1000);
    var operation = 'REPORT_TC';
    var tip_serv_id = $('#servicio_ins').val();
    var cur_id = $('select[name=cursoTC]').val();
    console.log(cur_id+"CURSOOOOOOOOOOOO");

    var parametros = {
        operation: operation,
        tip_serv_id: tip_serv_id,
        cur_id: cur_id

    };

    if (tip_serv_id > 0) {
        $.ajax({
            data: parametros,
            url: '/SistemaT/ReportServlet',
            type: 'post',
            beforeSend: function() {
                var path = window.location.host;
                $("#servicio").html('<img  class="center-block" src="http://localhost:8084/SistemaT/img/load.GIF"/>');
            },
            success: function(response) {
                console.log("TCCCCCCCCCCCCCCCC"+response);

                var Datos = JSON.parse(response);
                //console.log( Datos.error);
                if (Datos.length > 0) {

                    $("#alerta").empty();
                    agregarRerporTC(Datos);
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
            error: function(result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            }
        });

    }
}



/*ACE*/
function agregarRerporACE(Datos) {


    $('#ACE').empty();
    for (i in Datos) {

        var servicio_head = '';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-user"></i> ' + Datos[i].report_total + ' asistente(s)</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].cur_id + '">' + Datos[i].cur_cod + ' - ' + Datos[i].cur_nom + '</a></h3>' +
               
                '</div>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#ACE').append(servicio_head + servicio_body);

    }

}


$(function() {
    $("#ACE").css({"left": "-10px"});
    $("#ACE").css({"opacity": "0.2"});

    $("#ACE").animate({"left": "10px", "opacity": "1"}, 1000);
    var operation = 'REPORT_ACE';



    var parametros = {
        operation: operation

    };


    $.ajax({
        data: parametros,
        url: '/SistemaT/ReportServlet',
        type: 'post',
        beforeSend: function() {
            var path = window.location.host;
            $("#ACE").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
        },
        success: function(response) {
            console.log(response);

            var Datos = JSON.parse(response);
            //console.log( Datos.error);
            if (Datos.length > 0) {

                $("#alertaACE").empty();
                agregarRerporACE(Datos);
            }

            else {
                var alerta = '<div class="callout callout-danger">' +
                        '<h4>Busqueda</h4>' +
                        '<p>No se encontraron resultados</p>' +
                        '</div>';
                $('#ACE').empty();
                $("#alertaACE").html(alerta);

                $("#alertaACE").css({"left": "-10px"});
                $("#alertaACE").css({"opacity": "0.2"});

                $("#alertaACE").animate({"left": "10px", "opacity": "1"}, 1000);
            }



        },
        error: function(result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });


});
/**AT***/


function selectServicios() {

    var serv_edu_id = $("#selectServ").val().trim();
    var operation = 'REPORT_AT';
    ///alert(serv_edu_id);
    var parametros = {
        operation: operation,
        serv_edu_id: serv_edu_id
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/ReportServlet',
        type: 'post',
        beforeSend: function() {
            // var path = window.location.host;
            //        $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
        },
        success: function(response) {
            console.log(response);
            console.log($("#selectServ option:selected").text());
            var Datos = JSON.parse(response);
            agregarRerporAT(Datos, $("#selectServ option:selected").text());


        },
        error: function(result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });




}

$(function() {
    var select = $("#selectServ");
    var operation = 'QRY';
    var parametros = {
        operation: operation
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function() {
            // var path = window.location.host;
            //        $("#servicio").html('<img  class="center-block" src="http://localhost:8084//SistemaT/img/load.GIF"/>');
        },
        success: function(response) {
            console.log(response);

            var Datos = JSON.parse(response);
            for (i in Datos) {
                select.append('<option value="' + Datos[i].ser_edu_id + '">' + Datos[i].tip_serv_den + ' - ' + Datos[i].cur_nom + '</option>');
            }

        },
        error: function(result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
});



function agregarRerporAT(Datos, taller) {


    $('#servicio').empty();
    for (i in Datos) {
        var servicio_head = '';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-user"></i> ' + Datos[i].cantidad + ' asistente(s)</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].cantidad + '">' + taller + '</a></h3>' +
                '<div class="timeline-body panel-collapse collapse" id="' + Datos[i].cantidad + '">' +
                '<div class="callout callout-info">';
        var body = "";
        for (j = 0; j < Datos[i].cantidad; j++) {
            body += '<label>Alumno: </label><span> ' + 'ALVARADO FANO JOSE' + '</span><br/>'
        }




        var final = '</div>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '</div>' +
                '</div>' +
                '</li>';
        servicio_body = servicio_body + body + final;
        $('#servicio').append(servicio_head + servicio_body);

    }

}
