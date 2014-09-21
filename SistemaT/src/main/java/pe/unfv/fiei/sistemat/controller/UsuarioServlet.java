/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class UsuarioServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(UsuarioServlet.class);
    private final static String OPERATION_LOGIN = "login";
    private final static String OPERATION_QRY = "QRY";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Here declare your DAO object*/
        DaoUsuario daoUsuario = new DaoUsuarioImpl();
        /* Here declare your DAO object*/
        response.setContentType("text/html;charset=UTF-8");
        String operation = request.getParameter("operation");
        String message = "";
        String target = "/index.jsp";
        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_LOGIN)) {
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                if (user != null && password != null) {
                    Usuario usuario = daoUsuario.Login(user, password);
                    if (usuario != null) {
                        target = "/indexAdmin.html";

                    } else {
                        message += "Usuario y/o Contraseña incorrectos\n";
                    }
                } else {
                    message += "No ingreso Usuario o Contraseña\n";
                }
            } else if(operation.equalsIgnoreCase(OPERATION_QRY)){
                Integer tip_usr_idx = Integer.valueOf(request.getParameter("tip_usr_id"));
                Integer esp_idx =  Integer.valueOf(request.getParameter("esp_id"));
                List<Usuario> list = daoUsuario.usuarioQry(tip_usr_idx, esp_idx);
                if(list == null){
                    message += "Sin acceso a la base de datos";
                }else{
                    request.setAttribute("list", list);
                    target = "AdminQry.jsp";
                }
            }

        } else {
            log4j.error("The operation is: " + operation);
            message += "La operacion no es válida\n";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
