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
import pe.unfv.fiei.sistemat.model.dao.DaoReportes;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoReportesImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.model.dto.report.ReportACE;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTC;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTHM;

/**
 *
 * @author Arturo
 */
public class ReportServlet extends HttpServlet {

    private Logger log4j = Logger.getLogger(ReportServlet.class);
    private final static String REPORT_THM = "REPORT_THM";
    private final static String REPORT_AT = "REPORT_AT";
    private final static String REPORT_ACE = "REPORT_ACE";
    private final static String REPORT_TC = "REPORT_TC";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String msg = "";
        String message = null;
        JSONObject objError = new JSONObject();
        String operacion = request.getParameter("operation");
        DaoReportes daoReportes = new DaoReportesImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        if (operacion != null) {
            if (operacion.equalsIgnoreCase(REPORT_THM)) {
                List<ReportTHM> listReport = null;
                try {
                    Integer mes = Integer.parseInt(request.getParameter("mes"));
                    Integer anio = Integer.parseInt(request.getParameter("anio"));
                    listReport = daoReportes.ReportTHMQry(mes, u.getEsp_id(), anio);
                } catch (NumberFormatException e) {
                    log4j.error(e.getMessage());
                    objError.put("error", e.getMessage());
                    message = objError.toString();
                }
                if (listReport != null) {

                    JSONObject obj = new JSONObject();

                    for (ReportTHM reportTHM : listReport) {
                        obj.put("usr_tut_id", reportTHM.getUsr_tutor().getUsr_id());
                        obj.put("usr_tut_cod", reportTHM.getUsr_tutor().getUsr_cod());
                        obj.put("usr_tut_nom", reportTHM.getUsr_tutor().getUsr_nom());
                        obj.put("usr_tut_apat", reportTHM.getUsr_tutor().getUsr_apat());
                        obj.put("usr_tut_amat", reportTHM.getUsr_tutor().getUsr_amat());
                        obj.put("usr_tut_user", reportTHM.getUsr_tutor().getUsr_user());
                        obj.put("report_mes", reportTHM.getMes());
                        obj.put("report_horas", reportTHM.getHoras());
                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
                } else {
                    objError.put("error", "vacio");
                    message = objError.toString();
                    log4j.error(message);
                }

            } else if (operacion.equalsIgnoreCase(REPORT_AT)) {
                try {
                    log4j.error(request.getParameter("serv_edu_id"));
                    Integer serv_edu_id = Integer.parseInt(request.getParameter("serv_edu_id"));
                    
                    Integer cantidad = Integer.parseInt(daoReportes.ReportATQry(serv_edu_id, u.getEsp_id()));
                    JSONObject obj = new JSONObject();
                    obj.put("cantidad", cantidad);
                    msg = obj.toJSONString();

                } catch (NumberFormatException e) {
                    log4j.error(e.getMessage());
                    message = "Error al convertir de tipo";
                    objError.put("error", message);
                }
            } else if (operacion.equalsIgnoreCase(REPORT_ACE)) {
                List<ReportACE> listReport = null;
                try {
                    listReport = daoReportes.ReportACEQry(u.getEsp_id());
                } catch (NumberFormatException e) {
                    log4j.error(e.getMessage());
                    objError.put("error", e.getMessage());
                    message = objError.toString();
                }
                if (listReport != null) {

                    JSONObject obj = new JSONObject();

                    for (ReportACE reportACE : listReport) {
                        obj.put("cur_id", reportACE.getCurso().getCur_id());
                        obj.put("cur_cod", reportACE.getCurso().getCur_cod());
                        obj.put("cur_nom", reportACE.getCurso().getCur_nom());
                        obj.put("esp_id", reportACE.getCurso().getEsp_id());
                        obj.put("cur_est", reportACE.getCurso().getEsp_id());
                        obj.put("report_total", reportACE.getTotal());

                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
                } else {
                    objError.put("error", "vacio");
                    message = objError.toString();
                    log4j.error(message);
                }

            }
            if (operacion.equalsIgnoreCase(REPORT_TC)) {
                List<ReportTC> listReport = null;
                try {
                    Integer tip_serv_id = Integer.parseInt(request.getParameter("tip_serv_id"));
                    Integer cur_id = Integer.parseInt(request.getParameter("cur_id"));
                    listReport = daoReportes.ReportTCQry(cur_id, tip_serv_id);
                } catch (NumberFormatException e) {
                    log4j.error(e.getMessage());
                    objError.put("error", e.getMessage());
                    message = objError.toString();
                }
                if (listReport != null) {

                    JSONObject obj = new JSONObject();

                    for (ReportTC reportTC : listReport) {
                        obj.put("usr_tut_id", reportTC.getUser_tutor().getUsr_id());
                        obj.put("usr_tut_cod", reportTC.getUser_tutor().getUsr_cod());
                        obj.put("usr_tut_nom", reportTC.getUser_tutor().getUsr_nom());
                        obj.put("usr_tut_apat", reportTC.getUser_tutor().getUsr_apat());
                        obj.put("usr_tut_amat", reportTC.getUser_tutor().getUsr_amat());
                        obj.put("usr_tut_user", reportTC.getUser_tutor().getUsr_user());
                        obj.put("cur_id", reportTC.getCurso().getCur_id());
                        obj.put("cur_cod", reportTC.getCurso().getCur_cod());
                        obj.put("cur_nom", reportTC.getCurso().getCur_nom());
                        obj.put("esp_id", reportTC.getCurso().getEsp_id());
                        obj.put("cur_est", reportTC.getCurso().getEsp_id());
                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
                } else {
                    objError.put("error", "vacio");
                    message = objError.toString();
                    log4j.error(message);
                }

            }

            if (message != null) {
                out.print("[" + message + "]");
            } else {
                if (operacion.equals(REPORT_THM)
                        || operacion.equalsIgnoreCase(REPORT_AT)
                        || operacion.equalsIgnoreCase(REPORT_ACE)
                        || operacion.equalsIgnoreCase(REPORT_TC)) {
                    out.print("[" + msg + "]");
                }
            }
        } else {
            JSONObject obj = new JSONObject();
            obj.put("error", "operación no reconocida");
            message = obj.toJSONString();
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
