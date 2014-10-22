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
import org.json.simple.JSONObject;
import pe.unfv.fiei.sistemat.model.dao.DaoAmbiente;
import pe.unfv.fiei.sistemat.model.dao.DaoSede;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoAmbienteImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoSedeImpl;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;
import pe.unfv.fiei.sistemat.model.dto.Sede;

/**
 *
 * @author Arturo
 */
public class SedeServlet extends HttpServlet {

    private final static String OPERATION_QRY_DISP = "QRYJSON";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String operation = request.getParameter("operation");
        String message = null;
        String msg = "";
        if (operation != null) {
            DaoSede daoSede = new DaoSedeImpl();
            if (operation.equalsIgnoreCase(OPERATION_QRY_DISP)) {

                List<Sede> list = daoSede.SedeQry();
                if (list == null) {
                    message = "error#Sin acceso a la base de datos";
                } else {
                    JSONObject obj = new JSONObject();
                    for (Sede sede : list) {
                        obj.put("sed_id", sede.getSed_id());
                        obj.put("sed_desc", sede.getSed_desc());
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
                if (operation.equalsIgnoreCase(OPERATION_QRY_DISP)) {
                    out.print("[" + msg + "]");
                }
            }

        } else {
            message = "error#Operación nula";
        }
        if (message != null) {
            out.print(message);
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
