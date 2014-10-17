/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function() {
    var operation = 'QRY';

    var parametros = {
        operation: operation
    };

    $.ajax({
        data: parametros,
        url: '/SistemaT/ServicioServlet',
        type: 'post',
        beforeSend: function() {
            //$("#resultado").html("Procesando, espere por favor...");
        },
        success: function(response) {
            var Datos = JSON.parse(response);
            agregarServicios(Datos);

        },
        error: function(result, f) {
            alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
        }
    });
});

function agregarServicios(Datos) {

    for (i in Datos) {
        var servicio_head = '<li class="time-label"><span class="bg-red">' + Datos[i].ser_edu_fec + '</span></li>';
        var servicio_body = '<li>' +
                '<i class="fa fa-envelope bg-blue"></i>' +
                '<div class="timeline-item">' +
                '<span class="time"><i class="fa fa-clock-o"></i>' + Datos[i].ser_edu_hin +' - '+Datos[i].ser_edu_hin+ '</span>' +
                '<h3 class="timeline-header panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + Datos[i].ser_edu_id + '">'+Datos[i].tip_serv_id +' - '+ Datos[i].cur_id+'</a> ...</h3>' +
                '<div class="timeline-body panel-collapse collapse" id="' + Datos[i].ser_edu_id + '">' +
                'Curso: ' + Datos[i].cur_id + '<br/>' +
                'Ambiente: ' + Datos[i].amb_id + '<br/>' +
                'Sede: ' + Datos[i].sed_id + '<br/>' +
                'Tipo de servicio: ' + Datos[i].tip_serv_id + '<br/>' +
                'Descripcion: ' + Datos[i].ser_edu_desc + '<br/>' +
                'User Admin id : ' + Datos[i].usr_adm_id + '<br/>' +
                'Tutor id: ' + Datos[i].usr_tut_id + '<br/>' +
                'servicio asistencia: ' + Datos[i].usr_tut_id + '<br/>' +
                'servicio estado: ' + Datos[i].usr_tut_id + '<br/>' +
                'servicio estado: ' + Datos[i].ser_edu_est + '<br/>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '<a class="btn btn-primary btn-xs">Editar</a>' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#servicio').append(servicio_head + servicio_body);
    }

}


function editarServicio(id){
    
    
    
}


                    