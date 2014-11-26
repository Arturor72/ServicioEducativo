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
            '<input class="center-block" name="INS" type="checkbox" value="' + Datos[i].al_id + '">'
        ]);
    }

}