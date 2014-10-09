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

function curso_QRY(path) {
    window.location = path + "/CursoServlet?operation=QRY";
}

function guardarUsuario() {
    var usrGen;
    var usrCod = $("#usrCod").val();
    var tipUsrId = $("#tipUsrId").val();
    var usrNom = $("#usrNom").val();
    var usrApat = $("#usrApat").val();
    var usrAmat = $("#usrAmat").val();
    var usrDni = $("#usrDni").val();
    if(document.getElementById('usrGen_m').checked){
        usrGen = 0;  
    }
    if(document.getElementById('usrGen_f').checked){
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
            if (data === 'error') {
                alert(data);
            } else {
                window.location = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=1";
            }
        }
    });

}

function usuarioDel() {
    var ids = [];
    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Seleccione fila(s) a Retirar");
    } else {
        if (confirm("Retirar fila(s)?")) {
            $.ajax({
                url: '/SistemaT/UsuarioServlet',
                type: 'post',
                data: {
                    operation: 'DEL',
                    idsdel: ids.toString()
                }, 
                success: function(data) {
                    if (data === 'error') {
                        alert(data);
                    } else {
                        window.location = "/SistemaT/UsuarioServlet?operation=QRY&tip_usr_id=1";
                    }
                }
            });
        }
    }
}

function guardarCurso() {

    var codigo = $("#codigo").val();
    var nombre = $("#nombre").val();
    //        var datos=$(this).serializeArray();
    //        datos=[
    //            {name:"codigo", value:codigo},
    //            {name:"nombre", value:nombre}
    //        ];

    $.ajax({
        url: '/SistemaT/CursoServlet',
        type: 'post',
        data: {
            operation: 'INS',
            codigo: codigo,
            nombre: nombre
        }, 
        success: function(data) {
            alert(data);
            if (data === 'error') {
                alert(data)
            } else {
                window.location = "/SistemaT/CursoServlet?operation=QRY";
            }
        }
    });

}

function cursoUpd() {
    var id = $("input[name='UPD']:checked").val();
    if (isNaN(id)) {
        alert("Seleccione Fila para Actualizar Datos");
    }
    else {
        //        window.location = "CursoServlet?accion=GET&cursoid=" + id;
        $.ajax({
            url: '/SistemaT/CursoServlet',
            type: 'post',
            data: {
                operation: 'GET',
                cursoid: id
            }, 
            success: function(data) {
                if (data === 'error') {
                    alert(data);
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
    alert("abc");
    //        var datos=$(this).serializeArray();
    //        datos=[
    //            {name:"codigo", value:codigo},
    //            {name:"nombre", value:nombre}
    //        ];

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
            alert(data);
            if (data === 'error') {
                alert(data)
            } else {
                window.location = "/SistemaT/CursoServlet?operation=QRY";
            }
        }
    });

}

function cursoDel() {
    var ids = [];

    $("input[name='DEL']:checked").each(function() {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Seleccione fila(s) a Retirar");
    } else {
        if (confirm("Retirar fila(s)?")) {
            alert(ids);
            $.ajax({
                url: '/SistemaT/CursoServlet',
                type: 'post',
                data: {
                    operation: 'DEL',
                    idsdel: ids.toString()
                }, 
                success: function(data) {
                    alert(data);
                    if (data === 'error') {
                        alert(data)
                    } else {
                        window.location = "/SistemaT/CursoServlet?operation=QRY";
                    }
                }
            });
        }
    }
}
