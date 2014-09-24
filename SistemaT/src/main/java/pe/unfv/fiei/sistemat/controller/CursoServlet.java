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
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoCursoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class CursoServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(CursoServlet.class);
    private final static String OPERATION_QRY = "QRY";
    private final static String OPERATION_INS = "INS";
    private final static String OPERATION_DEL = "DEL";
    private final static String OPERATION_GET = "GET";
    private final static String OPERATION_UPD = "UPD";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operation = request.getParameter("operation");
        String message = null;

        String target = "/admin/gusuarios/cursos/CursoQry.jsp";

        DaoCurso daoCurso = new DaoCursoImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                List<Curso> list = daoCurso.cursoQry(u.getEsp_id());
                if (list == null) {
                    message = "Sin acceso a la base de datos";
                } else {
                    request.setAttribute("listcursos", list);
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
