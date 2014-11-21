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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.model.dao.DaoAsistencia;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoAsistenciaImpl;
import pe.unfv.fiei.sistemat.util.Util;

/**
 *
 * @author JULIO
 */
public class AsistenciaServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(UsuarioServlet.class);
    private final static String OPERATION_INS = "INS";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operation = request.getParameter("operation");
        String message = null;
        String msg = "";
        DaoAsistencia daoAsistencia = new DaoAsistenciaImpl();


        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_INS)) {
                String serEduId = request.getParameter("serEduId");
                String alId = request.getParameter("alId");
                List<Integer> list = Util.toids(alId);
                if (list != null) {
                    message = daoAsistencia.registrarAsistenciaAlumnos(Integer.valueOf(serEduId), list, 1);
                    if (message == null) {
                       msg="Los alumno(s) han sido registrados exitosamente";
                    } else {
                        message = "No se ingreso correctamente";
                    }
                }
            } else {
                message = "Solicitud no reconocida.";
            }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (message != null) {
                request.setAttribute("msg", message);
                out.print("error#" + message);
                out.close();
            } else {
                if (operation.equals(OPERATION_INS)) {
                    out.print(msg);
                }
            }
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
