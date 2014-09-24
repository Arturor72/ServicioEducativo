/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author JULIO
 */
@WebServlet(name = "Usuario", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(UsuarioServlet.class);
    private final static String OPERATION_QRY = "QRY";
    private final static String OPERATION_INS = "INS";
    private final static String OPERATION_DEL = "DEL";
    private final static String OPERATION_GET = "GET";
    private final static String OPERATION_UPD = "UPD";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String operation = request.getParameter("operation");
        String tip_usr_id = request.getParameter("tip_usr_id");
        Integer tip_usr_idx = Integer.valueOf(tip_usr_id);
        String message = null;

        String target = "/admin/gusuarios/admins/AdminQry.jsp";

        DaoUsuario daoUsuario = new DaoUsuarioImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                List<Usuario> list = daoUsuario.usuarioQry(u.getTip_usr_id(), u.getEsp_id());
                if (list == null) {
                    message = "Sin acceso a la base de datos";
                } else {
                    request.setAttribute("list", list);
                    if (tip_usr_idx == 1) {
                        target = "/admin/gusuarios/admins/AdminQry.jsp";
                    } else if (tip_usr_idx == 2) {
                        target = "/admin/gusuarios/tutores/TutorQry.jsp";
                    }
                }
            } else if (operation.equalsIgnoreCase(OPERATION_INS)) {
            } else if (operation.equalsIgnoreCase(OPERATION_GET)) {
            } else if (operation.equalsIgnoreCase(OPERATION_DEL)) {
            } else if (operation.equalsIgnoreCase(OPERATION_UPD)) {
            } else {
                message = "Solicitud no reconocida.";
            }
            if (message != null) {
                request.setAttribute("msg", message);
                target = "mensaje.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
