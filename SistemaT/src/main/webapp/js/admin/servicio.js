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
                
                //el dia la fecha la hora..., el curso... el ambiente...profesor..id...
                
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-cur_id" value="'+Datos[i].cur_id +'" />'+
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-amb_id" value="'+Datos[i].amb_id +'" />'+
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-sed_id" value="'+Datos[i].sed_id +'" />'+
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-tip_serv_id" value="'+Datos[i].tip_serv_id +'" />'+
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-ser_edu_desc" value="'+Datos[i].ser_edu_desc +'" />'+
                
                '<input type="hidden" id="' + Datos[i].ser_edu_id + '-usr_tut_id" value="'+Datos[i].usr_tut_id +'" />'+
                
                
                'Curso: ' + Datos[i].cur_id + '<br/>' +
                'Ambiente: ' + Datos[i].amb_id + '<br/>' +
                'Sede: ' + Datos[i].sed_id + '<br/>' +
                'Tipo de servicio: ' + Datos[i].tip_serv_id + '<br/>' +
                
                'Descripcion: ' + Datos[i].ser_edu_desc + '<br/>' +
                'User Admin id : ' + Datos[i].usr_adm_id + '<br/>' +
                'Tutor id: ' + Datos[i].usr_tut_id + '<br/>' +
             
               
                'servicio estado: ' + Datos[i].ser_edu_est + '<br/>' +
                '</div>' +
                '<div class="timeline-footer">' +
                '<a class="btn btn-primary btn-xs" onclick="editarServicio('+ Datos[i].ser_edu_id +')"  >Editar</a>' +
                '</div>' +
                '</div>' +
                '</li>';

        $('#servicio').append(servicio_head + servicio_body);
    }

}

//amb_den, sed_desc
function editarServicio(id){
    
    var cur_id =$('#'+id+'-cur_id').val();
    
    $('#cur_id').val(cur_id);
    $('#myModalUpd').modal('show');
    
    
    
}

$(function () {
      var operation="QRYJSON";

      var selectCurso =  $('#select_cur');

   
        var parametros = {
          operation : operation,
      
        };

        $.ajax({
          data:  parametros,
          url:  '/SistemaT/CursoServlet',
          type:  'post',
          beforeSend: function () {
            // Nothing To do
          },
          success:  function (response) {
            var Datos=JSON.parse(response);
          
            
              /*selectCurso.options.length = 1;
              for(var i=1; i<=anio; i++){
                selectCurso.options[selectCurso.options.length] = new Option(i, i);
              }*/
            
          },
          error: function (result,f) {
            alert('ERROR ' + result.status + ' ' + result.statusText+' '+f);
          }
        });
     
    });



                    