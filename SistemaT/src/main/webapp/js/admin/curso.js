/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function curso_QRY(path) {
    window.location = path + "/CursoServlet?operation=QRY";
}

function mostrarMensajeEliminar() {
    var ids = [];
    $('#myModalMensajeDel').html('Eliminar');
    $('#myModalMensajeUpd').html('');

    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        $('#modal-mensaje').html('Seleccione fila(s) a retirar');
        $('#myModalMensaje').modal('show');

    } else {
        $('#modal-mensaje-del').html('¿Estas seguro que quieres eliminar?');
        $('#myModalDel').modal('show');
    }
}

function guardarCurso() {

    var codigo = $("#codigo").val();
    var nombre = $("#nombre").val();
    $.ajax({
        url: '/SistemaT/CursoServlet',
        type: 'post',
        data: {
            operation: 'INS',
            codigo: codigo,
            nombre: nombre
        },
        success: function(data) {
            var ds = data.split('#');
            if (ds[0] === 'error') {
                $('#mensaje').html(ds[1]);
                $('#mensaje').addClass('alert alert-danger');
            } else {
                $('#mensaje').addClass('alert alert-success');
                $('#mensaje').html('Curso creado satisfactoriamente');
                setTimeout(function() {
                    url = "/SistemaT/CursoServlet?operation=QRY";
                    $(location).attr('href', url);
                }, 2000);
            }
        }
    });

}
function cursoUpd() {
    var id = $("input[name='UPD']:checked").val();
    $('#myModalMensajeDel').html('');
    $('#myModalMensajeUpd').html('Actualizar curso');
    if (isNaN(id)) {

        $('#modal-mensaje').html('Seleccione fila para actualizar datos');
        $('#myModalMensaje').modal('show');
    }
    else {
        $.ajax({
            url: '/SistemaT/CursoServlet',
            type: 'post',
            data: {
                operation: 'GET',
                cursoid: id
            },
            success: function(data) {
                var ds = data.split('#');
                if (ds[0] === 'error') {
                    $('#mensaje').html(ds[1]);
                    $('#mensaje').addClass('alert alert-danger');
                } else {
                    var c = data.split("#");
                    $('#idupd').val(c[0]);
                    $('#codigoupd').val(c[1]);
                    $('#nombreupd').val(c[2]);
                    $('#myModalUpd').modal('show');
                }
            }
        });
    }
}

function guardarCursoUpd() {
    var id = $("#idupd").val();
    var codigo = $("#codigoupd").val();
    var nombre = $("#nombreupd").val();
    $.ajax({
        url: '/SistemaT/CursoServlet',
        type: 'post',
        data: {
            operation: 'UPD',
            codigo: codigo,
            nombre: nombre,
            id: id
        },
        success: function(data) {
            var ds = data.split('#');
            if (ds[0] === 'error') {
                $('#mensajeupd').html(ds[1]);
                $('#mensajeupd').addClass('alert alert-danger');
            } else {
                $('#mensajeupd').html('Curso actualizado satisfactoriamente');
                $('#mensajeupd').addClass('alert alert-success');
                setTimeout(function() {
                    url = "/SistemaT/CursoServlet?operation=QRY";
                    $(location).attr('href', url);
                }, 2000);
            }
        }
    });

}

function cursoDel() {
    var ids = [];
    $('#myModalMensajeDel').html('Elimimar curso');
    $('#myModalMensajeUpd').html('');

    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        $('#modal-mensaje').html('Seleccione fila(s) a retirar');
        $('#myModalMensaje').modal('show');
    } else {
        $('#modal-mensaje-del').html('¿Estas seguro que quieres eliminar?');
        $('#myModalDel').modal('show');
    }
}
function confirm() {
    var ids = [];

    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    // if (valor==true) {
    //  alert(ids);
    $.ajax({
        url: '/SistemaT/CursoServlet',
        type: 'post',
        data: {
            operation: 'DEL',
            idsdel: ids.toString()
        },
        success: function(data) {
            if (data === 'error') {
                //alert(data)
            } else {
                $('#mensaje-del').html('Curso eliminado satisfactoriamente');
                $('#mensaje-del').addClass('alert alert-success');
                window.location = "/SistemaT/CursoServlet?operation=QRY";
            }
        }
    });
// }
}