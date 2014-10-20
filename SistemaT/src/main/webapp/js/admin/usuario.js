/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function admin_QRY(path) {
    window.location = path + "/UsuarioServlet?operation=QRY&tip_usr_id=1";
}

function tutor_QRY(path) {
    window.location = path + "/UsuarioServlet?operation=QRY&tip_usr_id=2";
}

function guardarAdmin() {
    var usrGen;
    var usrCod = $("#usrCod").val();
    var tipUsrId = $("#tipUsrId").val();
    var usrNom = $("#usrNom").val();
    var usrApat = $("#usrApat").val();
    var usrAmat = $("#usrAmat").val();
    var usrDni = $("#usrDni").val();
    if (document.getElementById('usrGen_m').checked) {
        usrGen = 0;
    }
    if (document.getElementById('usrGen_f').checked) {
        usrGen = 1;
    }
    var usrCel = $("#usrCel").val();
    var usrMail = $("#usrMail").val();
    var usrUser = $("#usrUser").val();
    var usrPass = $("#usrPass").val();

    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'INS',
            usrCod: usrCod,
            tipUsrId: tipUsrId,
            usrNom: usrNom,
            usrApat: usrApat,
            usrAmat: usrAmat,
            usrDni: usrDni,
            usrGen: usrGen,
            usrCel: usrCel,
            usrMail: usrMail,
            usrUser: usrUser,
            usrPass: usrPass
        },
        success: function(data) {
            var e = data.split("#");
            if (e[0] === 'error') {
                $('#mensaje').html(e[1]);
                $('#mensaje').addClass('alert alert-danger');
            } else {
                $('#mensaje').html('Creado satisfactoriamente');
                $('#mensaje').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=1"; $(location).attr('href', url);}, 2000);
            }
        }
    });
}

function guardarTutor() {
    var usrGen;
    var usrCod = $("#usrCod").val();
    var tipUsrId = $("#tipUsrId").val();
    var usrNom = $("#usrNom").val();
    var usrApat = $("#usrApat").val();
    var usrAmat = $("#usrAmat").val();
    var usrDni = $("#usrDni").val();
    if (document.getElementById('usrGen_m').checked) {
        usrGen = 0;
    }
    if (document.getElementById('usrGen_f').checked) {
        usrGen = 1;
    }
    var usrCel = $("#usrCel").val();
    var usrMail = $("#usrMail").val();
    var usrUser = $("#usrUser").val();
    var usrPass = $("#usrPass").val();

    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'INS',
            usrCod: usrCod,
            tipUsrId: tipUsrId,
            usrNom: usrNom,
            usrApat: usrApat,
            usrAmat: usrAmat,
            usrDni: usrDni,
            usrGen: usrGen,
            usrCel: usrCel,
            usrMail: usrMail,
            usrUser: usrUser,
            usrPass: usrPass
        },
        success: function(data) {
            var e = data.split("#");
            if (e[0] === 'error') {
                $('#mensaje').html(e[1]);
                $('#mensaje').addClass('alert alert-danger');
            } else {
                $('#mensaje').html('Creado satisfactoriamente');
                $('#mensaje').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=2"; $(location).attr('href', url);}, 2000);
            }
        }
    });
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

function eliminarAdmin() {
    var ids = [];
    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'DEL',
            idsdel: ids.toString()
        },
        success: function(data) {
            if (data === 'error') {
            } else {
                $('#mensaje-del').html('Administrador eliminado satisfactoriamente');
                $('#mensaje-del').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=1"; $(location).attr('href', url);}, 2000);
            }
        }
    });
}

function eliminarTutor() {
    var ids = [];
    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'DEL',
            idsdel: ids.toString()
        },
        success: function(data) {
            if (data === 'error') {
            } else {
                $('#mensaje-del').html('administrador eliminado satisfactoriamente');
                $('#mensaje-del').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=2"; $(location).attr('href', url);}, 2000);
            }
        }
    });
}

function solicitarUsuarioId() {
    var usrId = $("input[name='UPD']:checked").val();
    $('#myModalMensajeDel').html('');
    $('#myModalMensajeUpd').html('Actualizar');
    if (isNaN(usrId)) {
        $('#modal-mensaje').html('Seleccione fila para actualizar datos');
        $('#myModalMensaje').modal('show');
    }
    else {
        $.ajax({
            url: '/SistemaT/UsuarioServlet',
            type: 'post',
            data: {
                operation: 'GET',
                usrId: usrId
            },
            success: function(data) {
                if (data === 'error') {
                    alert(data);
                } else {
                    var u = data.split("#");
                    $('#usrIdUPD').val(u[0]);
                    $('#tipUsrIdUPD').val(u[1]);
                    $('#usrEspUPD').val(u[2]);
                    $('#usrCodUPD').val(u[3]);
                    $('#usrNomUPD').val(u[4]);
                    $('#usrApatUPD').val(u[5]);
                    $('#usrAmatUPD').val(u[6]);
                    $('#usrDniUPD').val(u[7]);
                    if (u[8] == "1") {
                        $('#usrGen_fUPD').attr('checked', true);
                    }
                    if (u[8] == "0") {
                        $('#usrGen_mUPD').attr('checked', true);
                    }
                    $('#usrCelUPD').val(u[9]);
                    $('#usrMailUPD').val(u[10]);
                    $('#usrUserUPD').val(u[11]);
                    $('#usrPassUPD').val(u[12]);
                    $('#usrEstUPD').val(u[13]);
                    $('#myModalUpd').modal('show');
                }
            }
        });
    }
}

function actualizarAdmin() {
    var usrGen;
    var usrId = $("#usrIdUPD").val();
    var usrCod = $("#usrCodUPD").val();
    var tipUsrId = $("#tipUsrIdUPD").val();
    var usrNom = $("#usrNomUPD").val();
    var usrApat = $("#usrApatUPD").val();
    var usrAmat = $("#usrAmatUPD").val();
    var usrDni = $("#usrDniUPD").val();
    if (document.getElementById('usrGen_mUPD').checked) {
        usrGen = 0;
    }
    if (document.getElementById('usrGen_fUPD').checked) {
        usrGen = 1;
    }
    var usrCel = $("#usrCelUPD").val();
    var usrMail = $("#usrMailUPD").val();
    var usrUser = $("#usrUserUPD").val();
    var usrPass = $("#usrPassUPD").val();
    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'UPD',
            usrId: usrId,
            usrCod: usrCod,
            tipUsrId: tipUsrId,
            usrNom: usrNom,
            usrApat: usrApat,
            usrAmat: usrAmat,
            usrDni: usrDni,
            usrGen: usrGen,
            usrCel: usrCel,
            usrMail: usrMail,
            usrUser: usrUser,
            usrPass: usrPass
        },
        success: function(data) {
            var e = data.split("#");
            if (e[0] === 'error') {
                $('#mensajeUPD').html(e[1]);
                $('#mensajeUPD').addClass('alert alert-danger');
            } else {
                $('#mensajeUPD').html('Actualizado satisfactoriamente');
                $('#mensajeUPD').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=1"; $(location).attr('href', url);}, 2000);
            }
        }
    });
}

function actualizarTutor() {
    var usrGen;
    var usrId = $("#usrIdUPD").val();
    var usrCod = $("#usrCodUPD").val();
    var tipUsrId = $("#tipUsrIdUPD").val();
    var usrNom = $("#usrNomUPD").val();
    var usrApat = $("#usrApatUPD").val();
    var usrAmat = $("#usrAmatUPD").val();
    var usrDni = $("#usrDniUPD").val();
    if (document.getElementById('usrGen_mUPD').checked) {
        usrGen = 0;
    }
    if (document.getElementById('usrGen_fUPD').checked) {
        usrGen = 1;
    }
    var usrCel = $("#usrCelUPD").val();
    var usrMail = $("#usrMailUPD").val();
    var usrUser = $("#usrUserUPD").val();
    var usrPass = $("#usrPassUPD").val();
    $.ajax({
        url: '/SistemaT/UsuarioServlet',
        type: 'post',
        data: {
            operation: 'UPD',
            usrId: usrId,
            usrCod: usrCod,
            tipUsrId: tipUsrId,
            usrNom: usrNom,
            usrApat: usrApat,
            usrAmat: usrAmat,
            usrDni: usrDni,
            usrGen: usrGen,
            usrCel: usrCel,
            usrMail: usrMail,
            usrUser: usrUser,
            usrPass: usrPass
        },
        success: function(data) {
            var e = data.split("#");
            if (e[0] === 'error') {
                $('#mensajeUPD').html(e[1]);
                $('#mensajeUPD').addClass('alert alert-danger');
            } else {
                $('#mensajeUPD').html('Actualizado satisfactoriamente');
                $('#mensajeUPD').addClass('alert alert-success');
                setTimeout( function() { url = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=2"; $(location).attr('href', url);}, 2000);
            }
        }
    });
}

function confirm() {
    var ids = [];

    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    $.ajax({
        url: '/SistemaT/CursoServlet',
        type: 'post',
        data: {
            operation: 'DEL',
            idsdel: ids.toString()
        },
        success: function(data) {
            if (data === 'error') {
            } else {
                $('#mensaje-del').html('Curso eliminado satisfactoriamente');
                $('#mensaje-del').addClass('alert alert-success');
                window.location = "/SistemaT/CursoServlet?operation=QRY";
            }
        }
    });
}





















