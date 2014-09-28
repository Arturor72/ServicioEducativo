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
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoCursoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.util.Util;

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
                    target = "/admin/gusuarios/cursos/CursoQry.jsp";
                }
            } else if (operation.equalsIgnoreCase(OPERATION_INS)) {
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                if (codigo != null) {
                    if (nombre != null) {
                        Curso curso = new Curso();
                        curso.setCur_cod(codigo);
                        curso.setCur_nom(nombre);
                        curso.setEsp_id(u.getEsp_id());
                        curso.setCur_est(true);
                        if (validaCurso(curso).equals("")) {
                            String result = daoCurso.cursoIns(curso);
                            if (result == null) {

                                target = "/admin/gusuarios/cursos/CursoQry.jsp";
                                request.setAttribute("mensaje", message);
                            } else {
                                message = "No se insertó correctamente";
                            }

                        }

                    } else {
                        message = "nombre invalido o vacio";
                    }
                } else {
                    message = "código invalido o vacio";
                }

            } else if (operation.equalsIgnoreCase(OPERATION_GET)) {
                String cursoid = request.getParameter("cursoid");
                if (cursoid != null) {
                    try {
                        Curso curso = daoCurso.getCurso(Integer.parseInt(cursoid), u.getEsp_id());
                        request.setAttribute("cursoget", curso);
                    } catch (NumberFormatException e) {
                        message = "Formato de id Invalido";
                    }

                } else {
                    message = "código invalido o vacio";
                }
            } else if (operation.equalsIgnoreCase(OPERATION_DEL)) {
                String ids = request.getParameter("ids");
                List<Integer> list = Util.toids(ids);
                if (list != null) {
                    message = daoCurso.cursoDelete(list);
                    if (message == null) {
                        target = "/admin/gusuarios/cursos/CursoQry.jsp";
                    } else {
                        message = "No se elimino correctamente";
                    }

                }
            } else if (operation.equalsIgnoreCase(OPERATION_UPD)) {
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                if (codigo != null) {
                    if (nombre != null) {
                        Curso curso = new Curso();
                        curso.setCur_cod(codigo);
                        curso.setCur_nom(nombre);
                        curso.setEsp_id(u.getEsp_id());
                        curso.setCur_est(true);
                        if (validaCurso(curso).equals("")) {
                            String result = daoCurso.cursoUpd(curso);
                            if (result == null) {
                                target = "/admin/gusuarios/cursos/CursoQry.jsp";
                                request.setAttribute("mensaje", message);
                            } else {
                                message = "No se actualizó correctamente";
                            }
                        }

                    } else {
                        message = "nombre invalido o vacio";
                    }
                } else {
                    message = "código invalido o vacio";
                }
            } else {
                message = "Solicitud no reconocida.";
            }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (message != null) {
                request.setAttribute("msg", message);
                out.print("error");
                out.close();
            } else if (operation.equalsIgnoreCase(SistemTConstants.CURSO_INS)) {
                target = "CursoQry";
                out.print(target);
                out.close();
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(target);
                dispatcher.forward(request, response);
            }

        }
    }

    public String validaCurso(Curso curso) {
        String result = "";
        if ((Util.validaLetrasyNumeros(curso.getCur_cod()) != null)) {
            result += " * Codigo de curso inválido";
        }
        if ((Util.validaLetras(curso.getCur_nom()) != null)) {
            result += " * Nombre de curso inválido";
        }
        if ((Util.validaNum(String.valueOf(curso.getEsp_id())) != null)) {
            result += " * Id de especialidad inválido";
        }
        return result;
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
