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
            alert(data);
            if (data === 'error') {
                alert(data)
            }else{
                window.location = "/SistemaT/CursoServlet?operation=QRY";
            }
        }
    });

}
