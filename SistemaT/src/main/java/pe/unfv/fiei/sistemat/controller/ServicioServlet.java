/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoCursoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoServicioImpl;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Servicio;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class ServicioServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(CursoServlet.class);
    private final static String OPERATION_QRY = "QRY";
    private final static String OPERATION_INS = "INS";
    private final static String OPERATION_DEL = "DEL";
    private final static String OPERATION_GET = "GET";
    private final static String OPERATION_UPD = "UPD";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String operation = request.getParameter("operation");
        String message = null;
        String target = "/admin/gusuarios/cursos/CursoQry.jsp";
        DaoServicio daoServicio = new DaoServicioImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        JSONObject objall = new JSONObject();
        String msg = "";
        if (operation != null) {
            log4j.info("The operation is: " + operation);

            if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                List<Servicio> list = daoServicio.ServicioQry(u.getEsp_id());
                if (list == null) {
                    message = "Sin acceso a la base de datos";
                } else {
                    request.setAttribute("listcursos", list);

                    JSONObject obj = new JSONObject();

                    for (Servicio servicio : list) {
                        System.out.println("" + servicio.getSer_edu_id());
                        obj.put("ser_edu_id", servicio.getSer_edu_id());
                        obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                        obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                        obj.put("cur_id", servicio.getCur_id().getCur_nom());
                        obj.put("amb_id", servicio.getAmb_id().getAmb_den());
                        obj.put("sed_id", servicio.getSed_id().getSed_desc());
                        obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_den());
                        obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_user());
                        obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_user());
                        obj.put("ser_edu_asist", servicio.getSer_edu_asist());
                        obj.put("ser_edu_desc", servicio.getSer_edu_desc());
                        obj.put("ser_edu_est", servicio.getSer_edu_est());
                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
                }
            }
            if (message != null) {
                out.print(message);
            } else {
                if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                    out.print("["+msg+"]");
                }
            }
        } else {
            message = "error";
        }
        if (message != null) {
            out.print(message);
        }
        out.close();
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
