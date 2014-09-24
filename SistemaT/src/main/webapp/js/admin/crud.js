/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function admin_QRY(path){
    alert(path);
    window.location = path+"/UsuarioServlet?operation=QRY";
}

function curso_QRY(path){
    alert(path);
    window.location = path+"/CursoServlet?operation=QRY";
}