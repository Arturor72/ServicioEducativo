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
        }, success: function(data) {
           // alert(data);
            if (data === 'error') {
                //alert(data)
                    $('#mensaje').html('No se pudo crear');
                $('#mensaje').addClass('alert alert-danger');
            } else {
                 $('#mensaje').html('Curso creado satisfactoriamente');
                $('#mensaje').addClass('alert alert-success');
                window.location = "/SistemaT/CursoServlet?operation=QRY";
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
        //alert("Seleccione Fila para Actualizar Datos");
       
               // $('#mensaje').addClass('alert alert-success');
        
    }
    else {
//        window.location = "CursoServlet?accion=GET&cursoid=" + id;
        $.ajax({
            url: '/SistemaT/CursoServlet',
            type: 'post',
            data: {
                operation: 'GET',
                cursoid: id
            }, success: function(data) {
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
 //   alert("abc");
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
        }, success: function(data) {
            //alert(data);
            if (data === 'error') {
                //alert(data);
                $('#mensaje').html('No se pudo actualizar');
                $('#mensaje').addClass('alert alert-danger');
            } else {
                //alert("goaskdlakjsdl");
                //alert(data);
                //$('#mensaje').html('<h5 class="alert alert-success" role="alert">Curso actualizado satisfactoriamente</h5>');
                $('#mensaje').html('Curso actualizado satisfactoriamente');
                $('#mensaje').addClass('alert alert-success');
                window.location = "/SistemaT/CursoServlet?operation=QRY";
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
        
        //alert("Seleccione fila(s) a Retirar");
    } else {
        $('#modal-mensaje-del').html('¿Estas seguro que quieres eliminar?');
        $('#myModalDel').modal('show');
      //var val= confirm(0);
      //alert(val);
//        if (val) {
//            alert(ids);
//            $.ajax({
//                url: '/SistemaT/CursoServlet',
//                type: 'post',
//                data: {
//                    operation: 'DEL',
//                    idsdel: ids.toString()
//                }, success: function(data) {
//                    //alert(data);
//                    if (data === 'error') {
//                        //alert(data)
//                    } else {
//                        window.location = "/SistemaT/CursoServlet?operation=QRY";
//                    }
//                }
//            });
//        }
    }
}

function confirm(){
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
                }, success: function(data) {
                    //alert(data);
                    if (data === 'error') {
                        //alert(data)
                    } else {
                        window.location = "/SistemaT/CursoServlet?operation=QRY";
                    }
                }
            });
       // }
}