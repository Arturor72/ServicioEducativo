/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.util.Util;

/**
 *
 * @author JULIO
 */
public class UsuarioServlet extends HttpServlet {

    Logger log4j = Logger.getLogger(UsuarioServlet.class);
    private final static String OPERATION_QRY = "QRY";
    private final static String OPERATION_INS = "INS";
    private final static String OPERATION_DEL = "DEL";
    private final static String OPERATION_GET = "GET";
    private final static String OPERATION_UPD = "UPD";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operation = request.getParameter("operation");
        String message = null;
        DaoUsuario daoUsuario = new DaoUsuarioImpl();
        String target = "/admin/gusuarios/admins/AdminQry.jsp";
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        if (operation != null) {
            log4j.info("The operation is: " + operation);
            if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                List<Usuario> list = daoUsuario.usuarioQry(u.getTip_usr_id(), u.getEsp_id());
                if (list == null) {
                    message = "Sin acceso a la base de datos";
                } else {
                    request.setAttribute("list", list);
                    if (Integer.valueOf(request.getParameter("tip_usr_id")) == 1) {
                        target = "/admin/gusuarios/admins/AdminQry.jsp";
                    } else if (Integer.valueOf(request.getParameter("tip_usr_id")) == 2) {
                        target = "/admin/gusuarios/tutores/TutorQry.jsp";
                    }
                }
            } else if (operation.equalsIgnoreCase(OPERATION_INS)) {
                Usuario usuario = new Usuario();
                message = valida(request, usuario);
                if (message == null) {
                    String result = daoUsuario.usuarioIns(usuario);
                    if (result == null) {
                        target = "/admin/gusuarios/admins/AdminQry.jsp";
                        request.setAttribute("mensaje", message);
                    } else {
                        message = "No se insertó correctamente";
                    }
                }
            } else if (operation.equalsIgnoreCase(OPERATION_GET)) {
                String id = request.getParameter("id");
                Usuario usuario = daoUsuario.usuarioGet(Integer.valueOf(id));
                if (usuario != null) {
                    request.setAttribute("usuario", usuario);
                    target = "usuarioUpd.jsp";
                } else {
                    message = "No existe usuario de ID: " + id;
                }
            } else if (operation.equalsIgnoreCase(OPERATION_DEL)) {
                String ids = request.getParameter("idsdel");
                List<Integer> list = Util.toids(ids);
                if (list != null) {
                    message = daoUsuario.usuarioDel(list);
                    if (message == null) {
                        target = "/admin/gusuarios/admins/AdminQry.jsp";
                    } else {
                        message = "No se elimino correctamente";
                    }
                }
            } else if (operation.equalsIgnoreCase(OPERATION_UPD)) {
            } else {
                message = "Solicitud no reconocida.";
            }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if (message != null) {
                request.setAttribute("msg", message);
                out.print("error");
                out.close();
            } else if (operation.equalsIgnoreCase(OPERATION_INS)) {
                target = "AdminQry";
                out.print(target);
                out.close();
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(target);
                dispatcher.forward(request, response);
            }
        }
    }

    // Metodos de apoyo
    private String valida(HttpServletRequest request, Usuario usuario) {

        Integer tipUsrIdx = null;
        Integer usrGenx = null;
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        String error = null;
        String usrCod = request.getParameter("usrCod");
        String tipUsrId = request.getParameter("tipUsrId");
        String usrNom = request.getParameter("usrNom");
        String usrApat = request.getParameter("usrApat");
        String usrAmat = request.getParameter("usrAmat");
        String usrDni = request.getParameter("usrDni");
        String usrGen = request.getParameter("usrGen");
        String usrCel = request.getParameter("usrCel");
        String usrMail = request.getParameter("usrMail");
        String usrUser = request.getParameter("usrUser");
        String usrPass = request.getParameter("usrPass");

        if (error == null) {
            if (usrCod == null || usrCod.trim().length() == 0) {
                error = "Debe ingresar un codigo para el usuario";
            }
        }

        if (tipUsrId != null) {
            try {
                tipUsrIdx = Integer.valueOf(tipUsrId);
            } catch (NumberFormatException e) {
                error = "Valor errado para el id del tipo de usuario";
            }
        }

        if (error == null) {
            if (usrNom == null || usrNom.trim().length() == 0) {
                error = "Debe ingresar un nombre para el usuario";
            }
        }

        if (error == null) {
            if (usrApat == null || usrApat.trim().length() == 0) {
                error = "Debe ingresar el apellido paterno para el usuario";
            }
        }

        if (error == null) {
            if (usrAmat == null || usrAmat.trim().length() == 0) {
                error = "Debe ingresar el apellido materno para el usuario";
            }
        }

        if (error == null) {
            if (usrCel == null || usrCel.trim().length() == 0) {
                error = "Debe ingresar el celular para el usuario";
            }
        }

        if (error == null) {
            if (usrDni == null || usrDni.trim().length() == 0) {
                error = "Debe ingresar el DNI para el usuario";
            }
        }

        if (usrGen != null) {
            try {
                usrGenx = Integer.valueOf(usrGen);
            } catch (NumberFormatException e) {
                error = "Valor errado para el genero de usuario";
            }
        }

        if (error == null) {
            if (usrMail == null || usrMail.trim().length() == 0) {
                error = "Debe ingresar el correo para el usuario";
            }
        }

        if (error == null) {
            if (usrUser == null || usrUser.trim().length() == 0) {
                error = "Debe ingresar el usuario para el usuario";
            }
        }

        if (error == null) {
            if (usrPass == null || usrPass.trim().length() == 0) {
                error = "Debe ingresar el password para el usuario";
            }
        }

        if (error == null) {
            usuario.setUsr_cod(usrCod);
            usuario.setTip_usr_id(tipUsrIdx);
            usuario.setUsr_nom(usrNom);
            usuario.setUsr_apat(usrApat);
            usuario.setUsr_amat(usrAmat);
            usuario.setUsr_dni(usrDni);
            usuario.setUsr_gen(usrGenx);
            usuario.setUsr_cel(usrCel);
            usuario.setUsr_mail(usrMail);
            usuario.setUsr_user(usrUser);
            usuario.setUsr_pass(usrPass);
            usuario.setUsr_est(1);
            usuario.setEsp_id(u.getEsp_id());
        }

        return error;
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
