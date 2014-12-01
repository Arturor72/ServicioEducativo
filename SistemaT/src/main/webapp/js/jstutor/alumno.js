/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {
    
    
 

    setTimeout(function () {
       cargarAlumnos();   
    }, 1000);




                  
               
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
    var tabla = $('#tblAlumno').dataTable();
    $.ajax({
        data: parametros,
        url: '/SistemaT/AlumnoServlet',
        type: 'post',
        beforeSend: function () {
            // $('body').modalmanager('loading');
            //  var path = window.location.host;

            //$('#tblAlumno').modalmanager('loading');

        },
        success: function (response) {
        $('#tblAlumno').find('tbody').empty();
            console.log(response);

            var Datos = JSON.parse(response);
            agregarAlumnos(Datos, tabla);


        },
        complete: function () {
              /*   var btn= $('#btn-411');
                 if(btn.hasClass("label-danger")){
                    btn.hover(function(){
                             btn.addClass("label-success").removeClass("label-danger");
                             btn.html("Regular");
                         },function(){
                           btn.addClass("label-danger").removeClass("label-success");
                            btn.html("Suspendido");
                            });
                            }
                   if(btn.hasClass("label-success")){
                    btn.hover(function(){
                             btn.addClass("label-danger").removeClass("label-success");
                             btn.html("Suspendido");
                         },function(){
                           btn.addClass("label-success").removeClass("label-danger");
                            btn.html("Regular");
                            });
     
     }*/
            
            
          
                
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
       
        var estado='';
        var inputs=  '';
        var boton='';
        if(Datos[i].al_susp===1){
    
           estado='<div class="label label-success botonest" id="btn-'+Datos[i].al_id +'" onclick="estadoAlumnos('+Datos[i].al_id +',1)">Regular</div>';
           //inputs= '<input class="center-check" name="SUS" type="checkbox" value="' + Datos[i].al_id + '" />'
           
        
        }
        else{
            estado='<div class="label label-danger botonest"  id="btn-'+Datos[i].al_id +'" onclick="estadoAlumnos('+Datos[i].al_id +',0)">Suspendido</div>';
             ///inputs= '<input class="center-check" name="SUS" type="checkbox" value="' + Datos[i].al_id + '" checked  />'
        }
        
        tabla.fnAddData([
            Datos[i].al_cod,
            Datos[i].al_nom,
            Datos[i].al_apat + ' ' + Datos[i].al_amat,
            estado//,
          //  inputs
        ]);
    }

}


function estadoAlumnos(id,est){
    var btn=$("#btn-"+id);
   
    var path = window.location.host;
    var operation = '';
    
 if(est===1){
    operation = 'SUSP_ALUMNOS';
  
   }
   
  if(est===0){
    operation = 'NOR_ALUMNOS';
   
   }
    var parametros = {
        operation: operation,
        al_id: id

    };
 
    if (id > 0){
        $.ajax({
            data: parametros,
            url: '/SistemaT/AlumnoServlet',
            type: 'post',
            beforeSend: function () {
        
                btn.html('Cargando<img  width="8px" height="8px" class="center-block" src="http://' + path + '//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                 
                console.log(id+" estado "+est);
                if(est===1){
                      btn.attr('onclick','estadoAlumnos('+id+',0)');
                      btn.addClass("label-danger").removeClass("label-success");
            
                         btn.html('Suspendido');
                }
                
                 if(est===0){
                      btn.attr('onclick','estadoAlumnos('+id+',1)');
                      btn.addClass("label-success").removeClass("label-danger");
            
                         btn.html('Regular');
                }
                
                
              
                
                
            
            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            },
            complete: function () {
                
              
        
 
        },
        });

    }
    else {
        $('#mensaje_ins').empty();
        $('#mensaje_ins').addClass('alert alert-danger');
        $('#mensaje_ins').html('No se ha seleccionado ningun alumno');

    }
    
}

function normalizarAlumnos(id){
    var btn=$("#btn-"+id);
    var path = window.location.host;
   //  var ids = [];

    //var serEduId = $('#ser-id').val();
    /* $("input[name='SUS']:checked").each(function() {
        ids.push($(this).val());
        
    });*/
    //console.log(serEduId);


    //var alId = ids.toString();
    //alert(ids.toString());
 var operation = 'NOR_ALUMNOS';
    // var serEduId=;
    
   // alert(id);
    var parametros = {
        operation: operation,
        al_id: id

    };
    
    
    //alert("jj");
    //alert(alId);
    if (id > 0){
        $.ajax({
            data: parametros,
            url: '/SistemaT/AlumnoServlet',
            type: 'post',
            beforeSend: function () {
                //var path = window.location.host;
                // $("#servicio").html('<img  class="center-block" src="http://'+path+'//SistemaT/img/load.GIF"/>');
                btn.html('Cargando<img  width="16px" height="16px" class="center-block" src="http://' + path + '//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                
              //  alert("dentro del response "+response);
                console.log(id);
                
                 btn.addClass("label-success").removeClass("label-danger");
                //head.css({"opacity": "0.2"});
              //  btn.addClass('disabled');
                btn.html('Regular');
                
                
                //alert("se ha cambiado el estado " + id)
               // alert(alId);
                //alert(response);
                /*
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
                    $('#mensaje_ins').html("Alumno(s) suspendido(s) satisfactoriamente");
                    setTimeout(function () {
                        url = "/SistemaT/p_tutor/ralumnos/AlumnoQry.jsp";
                        $(location).attr('href', url);
                    }, 2000);
                }*/
            },
            error: function (result, f) {
                alert('ERROR ' + result.status + ' ' + result.statusText + ' ' + f);
            },
            complete: function () {
                
              
        
 
        },
        });

    }
    else {
       
    }
    
}


function mostrarMensajeSuspender() {
    var ids = [];
    $('#myModalMensajeDel').html('Suspender');
    $('#myModalMensajeUpd').html('');

    $("input[name='SUS']:checked").each(function() {
   
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        $('#modal-mensaje').html('Seleccione alumno(s) a suspender');
        $('#myModalMensaje').modal('show');

    } else {
        $('#modal-mensaje-del').html('¿Estas seguro que quieres suspender?');
        $('#myModalSus').modal('show');
    }
}