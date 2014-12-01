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
import org.json.simple.JSONObject;
import pe.unfv.fiei.sistemat.model.dao.DaoAlumno;
import pe.unfv.fiei.sistemat.model.dao.DaoAsistencia;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoAlumnoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoAsistenciaImpl;
import pe.unfv.fiei.sistemat.model.dto.Alumno;
import pe.unfv.fiei.sistemat.model.dto.Servicio;
import pe.unfv.fiei.sistemat.util.Util;

/**
 *
 * @author Arturo
 */
public class AlumnoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Logger log4j = Logger.getLogger(UsuarioServlet.class);
    private final static String OPERATION_QRY_ALUMNOS = "QRY_ALUMNOS";
    private final static String OPERATION_SUSP_ALUMNOS = "SUSP_ALUMNOS";
    private final static String OPERATION_NOR_ALUMNOS = "NOR_ALUMNOS";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        String message = null;
        String msg = "";
        JSONObject objError = new JSONObject();
        DaoAlumno daoAlumno = new DaoAlumnoImpl();

        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_QRY_ALUMNOS)) {
                List<Alumno> list = daoAlumno.alumnoQry();
                if (list != null) {
                    JSONObject obj = new JSONObject();

                    for (Alumno alumno : list) {

                        obj.put("al_id", alumno.getAl_id());
                        obj.put("al_cod", alumno.getAl_cod());
                        obj.put("al_nom", alumno.getAl_nom());
                        obj.put("al_apat", alumno.getAl_apat());
                        obj.put("al_amat", alumno.getAl_amat());
                        obj.put("al_cel", alumno.getAl_cel());
                        obj.put("al_mail", alumno.getAl_mail());
                        obj.put("al_susp", alumno.getAl_susp());

                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
                } else {
                    message = "Lista nula o vacia de alumnos.";
                }
            } else if (operation.equalsIgnoreCase(OPERATION_SUSP_ALUMNOS)) {
                String alId = request.getParameter("al_id");
                List<Integer> list = Util.toids(alId);
                if (list != null) {
                    message = daoAlumno.alumnoSusp(list, 0);
                    if (message == null) {
                        msg = "Los alumno(s) han sido suspendidos exitosamente";
                    } else {

                        objError.put("error", "No se realizo la suspension correctamente");
                        message = objError.toJSONString();

                    }
                }

            } else if (operation.equals(OPERATION_NOR_ALUMNOS)) {
                String alId = request.getParameter("al_id");
                List<Integer> list = Util.toids(alId);
                if (list != null) {
                    message = daoAlumno.alumnoSusp(list, 1);
                    if (message == null) {
                        msg = "Los alumno(s) no estan suspendidos";
                    } else {
                        objError.put("error", "No se realizo el levantamiento de suspension correctamente");
                        message = objError.toJSONString();
                    }
                }

            } else {

                objError.put("error", "Solicitud no reconocida.");
                message = objError.toJSONString();
            }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (message != null) {
                out.print("[" + message + "]");
            } else {
                if (operation.equals(OPERATION_QRY_ALUMNOS) || operation.equals(OPERATION_SUSP_ALUMNOS)) {
                    out.print("[" + msg + "]");
                }
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
