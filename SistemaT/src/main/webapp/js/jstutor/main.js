/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function logout(path) {
    window.location = path+"/UsuarioServlet?operation=logout"
}


function login(operation) {

    $.ajax({
        url: "UsuarioServlet",
        data: {
            operation: operation,
            user: $("#user").val(),
            password: $("#password").val()
        },
        success: function(data) {
            if (data === "tutor") {
                window.location = "p_tutor/indexT.jsp";
            } else if (data === "admin") {
                window.location = "admin/indexA.jsp";
            } else {
                $("#result").html("<h5>" + data + "</h5>");
            }


        }
    });

}

