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
             '<input class="center-check" name="SUS" type="checkbox" value="' + Datos[i].al_id + '"/>'
        ]);
    }

}


function suspenderAlumnos(){
    
    
     var ids = [];

    //var serEduId = $('#ser-id').val();
     $("input[name='SUS']:checked").each(function() {
        ids.push($(this).val());
        alert("asd");
    });
    //console.log(serEduId);


    var alId = ids.toString();
    //alert(ids.toString());
    var operation = 'SUSP_ALUMNOS';
    // var serEduId=;
    var parametros = {
        operation: operation,
        al_id: alId

    };
    console.log("holaaa");
    
    //alert("jj");
    //alert(alId);
    if (alId.length > 0){
        $.ajax({
            data: parametros,
            url: '/SistemaT/AlumnoServlet',
            type: 'post',
            beforeSend: function () {
                //var path = window.location.host;
                // $("#servicio").html('<img  class="center-block" src="http://'+path+'//SistemaT/img/load.GIF"/>');
            },
            success: function (response) {
                
                alert("dentro del response "+response);
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
                        url = "/SistemaT/p_tutor/ralumnos/AlumnoQry.jsp";
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