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
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoCursoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Servicio;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.util.Util;

/**
 *
 * @author Arturo
 */
public class CursoServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(CursoServlet.class);
    private final static String OPERATION_QRY = "QRY";
    private final static String OPERATION_QRY_JSON = "QRYJSON";
    private final static String OPERATION_INS = "INS";
    private final static String OPERATION_DEL = "DEL";
    private final static String OPERATION_GET = "GET";
    private final static String OPERATION_UPD = "UPD";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String operation = request.getParameter("operation");
        String message = null;
        String msg = "";
        String target = "/admin/gusuarios/cursos/CursoQry.jsp";
        DaoCurso daoCurso = new DaoCursoImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        Curso cursoget = null;
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
            } else if (operation.equalsIgnoreCase(OPERATION_QRY_JSON)) {
                List<Curso> list = daoCurso.cursoQry(u.getEsp_id());
                if (list == null) {
                    message = "Sin acceso a la base de datos";
                } else {
                    JSONObject obj = new JSONObject();
                    for (Curso curso : list) {
                        obj.put("cur_id", curso.getCur_id());
                        obj.put("cur_nom", curso.getCur_cod());
                        obj.put("cur_nom", curso.getCur_nom());
                        obj.put("esp_id", curso.getEsp_id());
                        obj.put("cur_est", curso.isCur_est());
                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }
                    }
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
                            }else if (result.equalsIgnoreCase(SistemTConstants.ERROR_UNIQUE_FIELD)) {
                                message = "El código ya existe";
                            } else {
                                message = "No se insertó correctamente";
                            }
                        } else {
                            message = validaCurso(curso);
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
                        cursoget = daoCurso.getCurso(Integer.parseInt(cursoid), u.getEsp_id());
                        request.setAttribute("cursoget", cursoget);
                    } catch (NumberFormatException e) {
                        message = "Formato de id Invalido";
                    }

                } else {
                    message = "código invalido o vacio";
                }
            } else if (operation.equalsIgnoreCase(OPERATION_DEL)) {
                String ids = request.getParameter("idsdel");
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
                String id = request.getParameter("id");
                if (codigo != null) {
                    if (nombre != null) {
                        Curso curso = new Curso();
                        curso.setCur_id(Integer.parseInt(id));
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
            PrintWriter out = response.getWriter();
            if (message != null) {
                request.setAttribute("msg", message);
                out.print("error#" + message);
                out.close();
            } else if (operation.equalsIgnoreCase(SistemTConstants.CURSO_INS)) {
                target = "CursoQry";
                out.print(target);
                out.close();
            } else if (operation.equalsIgnoreCase(OPERATION_GET)) {
                if (cursoget != null) {
                    target = cursoget.getCur_id() + "#" + cursoget.getCur_cod() + "#" + cursoget.getCur_nom();
                } else {
                    target = "null";
                }
                out.print(target);
                out.close();
            } else if (operation.equalsIgnoreCase(OPERATION_QRY_JSON)) {
                out.print("[" + msg + "]");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(target);
                dispatcher.forward(request, response);
            }

        }
    }

    public String validaCurso(Curso curso) {
        String result = "";
        if ((Util.validaLetrasyNumeros(curso.getCur_cod()) != null) || curso.getCur_cod().trim().equalsIgnoreCase("")) {
            result += "*  Codigo de curso inválido\n";
        }
        if ((Util.validaLetrasyNumeros(curso.getCur_nom()) != null)) {
            result += "*  Nombre de curso inválido\n";
        }
        if ((Util.validaNum(String.valueOf(curso.getEsp_id())) != null)) {
            result += "*  Id de especialidad inválido\n";
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
