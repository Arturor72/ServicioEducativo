/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
    private final static String OPERATION_LOGOUT = "logout";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Here declare your DAO object*/
        DaoUsuario daoUsuario = new DaoUsuarioImpl();
        /* Here declare your DAO object*/
        String operation = request.getParameter("operation");
        String message = null;
        String message2 = "";
        String target = "/login.jsp";
        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_LOGIN)) {
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                if (user != null && password != null) {
                    Usuario usuario = daoUsuario.Login(user, password);
                    if (usuario != null) {
                        if (usuario.getTip_Usr_Id() == 1) {
                            target = "/admin/indexA.jsp";
                            log4j.info("ADMIN");
                            message2 = "admin";
                        } else if (usuario.getTip_Usr_Id() == 2) {
                            log4j.info("TUTOR");
                            target = "/p_tutor/indexT.jsp";
                            message2 = "tutor";
                        }
                        request.getSession().setAttribute("usuario", usuario);

                    } else {
                        message = "Usuario y/o Contraseña incorrectos\n";
                    }
                } else {
                    message = "No ingreso Usuario o Contraseña\n";
                }
            } else if (operation.equalsIgnoreCase(OPERATION_LOGOUT)) {
                request.getSession().removeAttribute("usuario");
                target = "/login.jsp";
                message2 = "logout";
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        } else {
            log4j.error("The operation is: " + operation);
            message2 = "logout";
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
//        response.sendRedirect("p_tutor\\indexT.jsp");
        if (!message2.equalsIgnoreCase("logout")) {
            if (message != null) {

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(message);
                out.close();
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print(message2);
                out.close();
//            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
//            dispatcher.forward(request, response);
            }
        }

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
