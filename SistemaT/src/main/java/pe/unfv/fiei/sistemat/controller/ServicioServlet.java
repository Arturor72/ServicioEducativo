/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoCursoImpl;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoServicioImpl;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Sede;
import pe.unfv.fiei.sistemat.model.dto.Servicio;
import pe.unfv.fiei.sistemat.model.dto.TipoServicio;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.util.Util;

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
    private final static String OPERATION_QRY_SEARCH = "QRY_SEARCH";
    private final static String OPERATION_QRY_SEARCH_SEDE = "QRY_SEARCH_SEDE";
    private final static String OPERATION_QRY_BY_TUTOR = "QRY_BY_TUTOR";
    private final static String OPERATION_INS_ASIST = "OPERATION_INS_ASIST";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String operation = request.getParameter("operation");
        String message = null;
        String target;
        JSONObject objError = new JSONObject();
        DaoServicio daoServicio = new DaoServicioImpl();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        String msg = "";
        if (operation != null) {
            log4j.info("The operation is: " + operation);

            if (operation.equalsIgnoreCase(OPERATION_QRY)) {
                List<Servicio> list = daoServicio.ServicioQry(u.getEsp_id());

                if (list == null) {
                    objError.put("error", "Error Interno");
                    message = objError.toJSONString();
                } else {
                    request.setAttribute("listcursos", list);

                    JSONObject obj = new JSONObject();

                    for (Servicio servicio : list) {
                        obj.put("ser_edu_id", servicio.getSer_edu_id());
                        obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                        obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                        obj.put("cur_id", servicio.getCur_id().getCur_id());
                        obj.put("cur_nom", servicio.getCur_id().getCur_nom());
                        obj.put("amb_id", servicio.getAmb_id().getAmd_id());
                        obj.put("amb_den", servicio.getAmb_id().getAmb_den());
                        obj.put("sed_id", servicio.getSed_id().getSed_id());
                        obj.put("sed_desc", servicio.getSed_id().getSed_desc());
                        obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_id());
                        obj.put("tip_serv_den", servicio.getTip_serv_id().getTip_ser_den());

                        obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_id());
                        obj.put("usr_adm_cod", servicio.getUsr_adm_id().getUsr_cod());
                        obj.put("usr_adm_nom", servicio.getUsr_adm_id().getUsr_nom());
                        obj.put("usr_adm_apat", servicio.getUsr_adm_id().getUsr_apat());
                        obj.put("usr_adm_amat", servicio.getUsr_adm_id().getUsr_amat());
                        obj.put("usr_adm_user", servicio.getUsr_adm_id().getUsr_user());

                        obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_id());
                        obj.put("usr_tut_cod", servicio.getUsr_tut_id().getUsr_cod());
                        obj.put("usr_tut_nom", servicio.getUsr_tut_id().getUsr_nom());
                        obj.put("usr_tut_apat", servicio.getUsr_tut_id().getUsr_apat());
                        obj.put("usr_tut_amat", servicio.getUsr_tut_id().getUsr_amat());
                        obj.put("usr_tut_user", servicio.getUsr_tut_id().getUsr_user());

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
            } else if (operation.equals(OPERATION_INS)) {
                HashMap hm = new HashMap();
                String ser_edu_fec = request.getParameter("ser_edu_fec");
                String ser_edu_hin = request.getParameter("ser_edu_hin");
                String curso_id = request.getParameter("curso_id");
                String amb_id = request.getParameter("amb_id");
                String sed_id = request.getParameter("sed_id");
                String tipo_serv_id = request.getParameter("tipo_serv_id");
                String usr_tut_id = request.getParameter("usr_tut_id");
                String ser_edu_desc = request.getParameter("ser_edu_desc");
                Integer ser_edu_est = Integer.parseInt(SistemTConstants.STATE_ON);
                hm.put("Fecha", ser_edu_desc);
                hm.put("Hora de inicio", ser_edu_desc);
                hm.put("Curso", curso_id);
                hm.put("Ambiente", amb_id);
                hm.put("Sede", sed_id);
                hm.put("Tipo servicio", tipo_serv_id);
                hm.put("Tutor", usr_tut_id);
                hm.put("Descripcion", ser_edu_desc);
                String sAnyNull = Util.getAnyNull(hm);
                if (sAnyNull == null) {
                    Servicio servicio = new Servicio();

                    servicio.setSer_edu_fec(Date.valueOf(ser_edu_fec));
                    servicio.setSer_edu_hin(ser_edu_hin);
                    try {
                        Curso curso = new Curso();
                        curso.setCur_id(Integer.parseInt(curso_id));
                        servicio.setCur_id(curso);

                        Ambiente ambiente = new Ambiente();
                        ambiente.setAmd_id(Integer.parseInt(amb_id));
                        servicio.setAmb_id(ambiente);

                        Sede sede = new Sede();
                        sede.setSed_id(Integer.parseInt(sed_id));
                        servicio.setSed_id(sede);

                        TipoServicio tipoServicio = new TipoServicio();
                        tipoServicio.setTip_ser_id(Integer.parseInt(tipo_serv_id));
                        servicio.setTip_serv_id(tipoServicio);

                        servicio.setUsr_adm_id(u);

                        Usuario usuarioTutor = new Usuario();
                        usuarioTutor.setUsr_id(Integer.parseInt(usr_tut_id));
                        servicio.setUsr_tut_id(usuarioTutor);

                        servicio.setSer_edu_desc(ser_edu_desc);

                        servicio.setSer_edu_est(ser_edu_est);

                        servicio.setSer_edu_asist(0);

                    } catch (Exception e) {
                        log4j.error(e.getMessage());
                    }

                    String result = daoServicio.ServicioIns(servicio);
                    if (result != null) {
                        objError.put("error", "No se inserto correctamente");
                        message = objError.toJSONString();
                    }
                } else {
                    objError.put("error", sAnyNull);
                    message = objError.toJSONString();
                }

            } else if (operation.equals(OPERATION_UPD)) {
                HashMap hm = new HashMap();
                String serv_edu_id = request.getParameter("serv_edu_id");
                String ser_edu_fec = request.getParameter("ser_edu_fec");
                String ser_edu_hin = request.getParameter("ser_edu_hin");

                String curso_id = request.getParameter("curso_id");
                String amb_id = request.getParameter("amb_id");
                String sed_id = request.getParameter("sed_id");

                String tipo_serv_id = request.getParameter("tipo_serv_id");
                String usr_tut_id = request.getParameter("usr_tut_id");
                String ser_edu_desc = request.getParameter("ser_edu_desc");
                Integer ser_edu_est = Integer.parseInt(SistemTConstants.STATE_ON);

                hm.put("Id de Servicio", serv_edu_id);
                hm.put("Fecha", ser_edu_desc);
                hm.put("Hora de inicio", ser_edu_desc);

                hm.put("Curso", curso_id);
                hm.put("Ambiente", amb_id);
                hm.put("Sede", sed_id);

                hm.put("Tipo servicio", tipo_serv_id);
                hm.put("Tutor", usr_tut_id);
                hm.put("Descripcion", ser_edu_desc);

                String sAnyNull = Util.getAnyNull(hm);
                if (sAnyNull == null) {
                    Servicio servicio = new Servicio();

                    servicio.setSer_edu_id(Integer.parseInt(serv_edu_id));

                    servicio.setSer_edu_fec(Date.valueOf(ser_edu_fec));
                    servicio.setSer_edu_hin(ser_edu_hin);
                    try {
                        Curso curso = new Curso();
                        curso.setCur_id(Integer.parseInt(curso_id));
                        servicio.setCur_id(curso);

                        Ambiente ambiente = new Ambiente();
                        ambiente.setAmd_id(Integer.parseInt(amb_id));
                        servicio.setAmb_id(ambiente);

                        Sede sede = new Sede();
                        sede.setSed_id(Integer.parseInt(sed_id));
                        servicio.setSed_id(sede);

                        TipoServicio tipoServicio = new TipoServicio();
                        tipoServicio.setTip_ser_id(Integer.parseInt(tipo_serv_id));
                        servicio.setTip_serv_id(tipoServicio);

                        servicio.setUsr_adm_id(u);

                        Usuario usuarioTutor = new Usuario();
                        usuarioTutor.setUsr_id(Integer.parseInt(usr_tut_id));
                        servicio.setUsr_tut_id(usuarioTutor);

                        servicio.setSer_edu_desc(ser_edu_desc);

                        servicio.setSer_edu_est(ser_edu_est);
                        servicio.setSer_edu_asist(0);
                    } catch (Exception e) {
                        log4j.error(e.getMessage());
                        objError.put("error", "Error al convertir");
                        message = objError.toString();
                    }

                    String result = daoServicio.ServicioUpd(servicio);
                    if (result != null) {
                        objError.put("error", "No se actualizo correctamente");
                        message = objError.toJSONString();
                    }
                } else {
                    objError.put("error", sAnyNull);
                    message = objError.toJSONString();
                }

            } else if (operation.equals(OPERATION_GET)) {
                String serv_edu_id = request.getParameter("serv_edu_id");
                try {
                    Servicio servicio = daoServicio.ServicioGet(Integer.parseInt(serv_edu_id));
                    if (servicio != null) {
                        JSONObject obj = new JSONObject();

                        obj.put("ser_edu_id", servicio.getSer_edu_id());
                        obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                        obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                        obj.put("cur_id", servicio.getCur_id().getCur_id());
                        obj.put("cur_nom", servicio.getCur_id().getCur_nom());
                        obj.put("amb_id", servicio.getAmb_id().getAmd_id());
                        obj.put("amb_den", servicio.getAmb_id().getAmb_den());
                        obj.put("sed_id", servicio.getSed_id().getSed_id());
                        obj.put("sed_desc", servicio.getSed_id().getSed_desc());
                        obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_id());
                        obj.put("tip_serv_den", servicio.getTip_serv_id().getTip_ser_den());

                        obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_id());
                        obj.put("usr_adm_cod", servicio.getUsr_adm_id().getUsr_cod());
                        obj.put("usr_adm_nom", servicio.getUsr_adm_id().getUsr_nom());
                        obj.put("usr_adm_apat", servicio.getUsr_adm_id().getUsr_apat());
                        obj.put("usr_adm_amat", servicio.getUsr_adm_id().getUsr_amat());
                        obj.put("usr_adm_user", servicio.getUsr_adm_id().getUsr_user());

                        obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_id());
                        obj.put("usr_tut_cod", servicio.getUsr_tut_id().getUsr_cod());
                        obj.put("usr_tut_nom", servicio.getUsr_tut_id().getUsr_nom());
                        obj.put("usr_tut_apat", servicio.getUsr_tut_id().getUsr_apat());
                        obj.put("usr_tut_amat", servicio.getUsr_tut_id().getUsr_amat());
                        obj.put("usr_tut_user", servicio.getUsr_tut_id().getUsr_user());

                        obj.put("ser_edu_asist", servicio.getSer_edu_asist());
                        obj.put("ser_edu_desc", servicio.getSer_edu_desc());
                        obj.put("ser_edu_est", servicio.getSer_edu_est());
                        if (msg.equals("")) {
                            msg = msg + obj.toJSONString();
                        } else {
                            msg = msg + "," + obj.toJSONString();
                        }

                    } else {
                        objError.put("error", "No se pudo obtener curso");
                        message = objError.toString();
                    }
                } catch (Exception e) {
                    log4j.error(e.getMessage());
                    objError.put("error", "Error al convertir");
                    message = objError.toString();
                }

            } else if (operation.equalsIgnoreCase(OPERATION_QRY_SEARCH)) {
                String ser_edu_fec = request.getParameter("ser_edu_fec");
                if (ser_edu_fec != null) {
                    List<Servicio> list = daoServicio.ServicioQryByDate(u.getEsp_id(), ser_edu_fec);
                    if (list == null) {
                        objError.put("error", "Error Interno");
                        message = objError.toJSONString();
                    } else {
                        request.setAttribute("listcursos", list);

                        JSONObject obj = new JSONObject();

                        for (Servicio servicio : list) {
                            obj.put("ser_edu_id", servicio.getSer_edu_id());
                            obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                            obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                            obj.put("cur_id", servicio.getCur_id().getCur_id());
                            obj.put("cur_nom", servicio.getCur_id().getCur_nom());
                            obj.put("amb_id", servicio.getAmb_id().getAmd_id());
                            obj.put("amb_den", servicio.getAmb_id().getAmb_den());
                            obj.put("sed_id", servicio.getSed_id().getSed_id());
                            obj.put("sed_desc", servicio.getSed_id().getSed_desc());
                            obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_id());
                            obj.put("tip_serv_den", servicio.getTip_serv_id().getTip_ser_den());

                            obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_id());
                            obj.put("usr_adm_cod", servicio.getUsr_adm_id().getUsr_cod());
                            obj.put("usr_adm_nom", servicio.getUsr_adm_id().getUsr_nom());
                            obj.put("usr_adm_apat", servicio.getUsr_adm_id().getUsr_apat());
                            obj.put("usr_adm_amat", servicio.getUsr_adm_id().getUsr_amat());
                            obj.put("usr_adm_user", servicio.getUsr_adm_id().getUsr_user());

                            obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_id());
                            obj.put("usr_tut_cod", servicio.getUsr_tut_id().getUsr_cod());
                            obj.put("usr_tut_nom", servicio.getUsr_tut_id().getUsr_nom());
                            obj.put("usr_tut_apat", servicio.getUsr_tut_id().getUsr_apat());
                            obj.put("usr_tut_amat", servicio.getUsr_tut_id().getUsr_amat());
                            obj.put("usr_tut_user", servicio.getUsr_tut_id().getUsr_user());

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
                } else {
                    message = "Fecha nula";
                }

            } else if (operation.equalsIgnoreCase(OPERATION_QRY_SEARCH_SEDE)) {
                String sed_id = request.getParameter("sed_id");
                if (sed_id != null) {
                    List<Servicio> list = daoServicio.ServicioQryBySede(u.getEsp_id(), sed_id);
                    if (list == null) {
                        objError.put("error", "Error Interno");
                        message = objError.toJSONString();
                    } else {
                        request.setAttribute("listcursos", list);

                        JSONObject obj = new JSONObject();

                        for (Servicio servicio : list) {
                            obj.put("ser_edu_id", servicio.getSer_edu_id());
                            obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                            obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                            obj.put("cur_id", servicio.getCur_id().getCur_id());
                            obj.put("cur_nom", servicio.getCur_id().getCur_nom());
                            obj.put("amb_id", servicio.getAmb_id().getAmd_id());
                            obj.put("amb_den", servicio.getAmb_id().getAmb_den());
                            obj.put("sed_id", servicio.getSed_id().getSed_id());
                            obj.put("sed_desc", servicio.getSed_id().getSed_desc());
                            obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_id());
                            obj.put("tip_serv_den", servicio.getTip_serv_id().getTip_ser_den());

                            obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_id());
                            obj.put("usr_adm_cod", servicio.getUsr_adm_id().getUsr_cod());
                            obj.put("usr_adm_nom", servicio.getUsr_adm_id().getUsr_nom());
                            obj.put("usr_adm_apat", servicio.getUsr_adm_id().getUsr_apat());
                            obj.put("usr_adm_amat", servicio.getUsr_adm_id().getUsr_amat());
                            obj.put("usr_adm_user", servicio.getUsr_adm_id().getUsr_user());

                            obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_id());
                            obj.put("usr_tut_cod", servicio.getUsr_tut_id().getUsr_cod());
                            obj.put("usr_tut_nom", servicio.getUsr_tut_id().getUsr_nom());
                            obj.put("usr_tut_apat", servicio.getUsr_tut_id().getUsr_apat());
                            obj.put("usr_tut_amat", servicio.getUsr_tut_id().getUsr_amat());
                            obj.put("usr_tut_user", servicio.getUsr_tut_id().getUsr_user());

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
                } else {
                    message = "Sede nula";
                }

            } else if (operation.equalsIgnoreCase(OPERATION_QRY_BY_TUTOR)) {
                int ser_tut_id = u.getUsr_id();

                if (ser_tut_id > 0) {
                    List<Servicio> list = daoServicio.ServicioQryByTutor(ser_tut_id);
                    if (list == null) {
                        objError.put("error", "Error Interno");
                        message = objError.toJSONString();
                    } else {
                        JSONObject obj = new JSONObject();

                        for (Servicio servicio : list) {
                            obj.put("ser_edu_id", servicio.getSer_edu_id());
                            obj.put("ser_edu_fec", servicio.getSer_edu_fec().toString());
                            obj.put("ser_edu_hin", servicio.getSer_edu_hin());
                            obj.put("cur_id", servicio.getCur_id().getCur_id());
                            obj.put("cur_nom", servicio.getCur_id().getCur_nom());
                            obj.put("amb_id", servicio.getAmb_id().getAmd_id());
                            obj.put("amb_den", servicio.getAmb_id().getAmb_den());
                            obj.put("sed_id", servicio.getSed_id().getSed_id());
                            obj.put("sed_desc", servicio.getSed_id().getSed_desc());
                            obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_id());
                            obj.put("tip_serv_den", servicio.getTip_serv_id().getTip_ser_den());

                            obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_id());
                            obj.put("usr_adm_cod", servicio.getUsr_adm_id().getUsr_cod());
                            obj.put("usr_adm_nom", servicio.getUsr_adm_id().getUsr_nom());
                            obj.put("usr_adm_apat", servicio.getUsr_adm_id().getUsr_apat());
                            obj.put("usr_adm_amat", servicio.getUsr_adm_id().getUsr_amat());
                            obj.put("usr_adm_user", servicio.getUsr_adm_id().getUsr_user());

                            obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_id());
                            obj.put("usr_tut_cod", servicio.getUsr_tut_id().getUsr_cod());
                            obj.put("usr_tut_nom", servicio.getUsr_tut_id().getUsr_nom());
                            obj.put("usr_tut_apat", servicio.getUsr_tut_id().getUsr_apat());
                            obj.put("usr_tut_amat", servicio.getUsr_tut_id().getUsr_amat());
                            obj.put("usr_tut_user", servicio.getUsr_tut_id().getUsr_user());

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
                } else {
                    message = "Fecha nula";
                }

            } else if (operation.equalsIgnoreCase(OPERATION_INS_ASIST)) {
                String ser_edu_id = request.getParameter("ser_edu_id");

                if (ser_edu_id != null) {
                    try {
                        String result = daoServicio.ServicioInsAsist(Integer.parseInt(ser_edu_id));

                        if (result != null) {
                            objError.put("error", "Error Interno");
                            message = objError.toJSONString();
                        } else {
                            JSONObject obj = new JSONObject();
                            obj.put("respuesta", 1);
                            msg = obj.toString();
                        }
                    } catch (NumberFormatException e) {
                        message = "No es un numero ID";
                    }
                } else {
                    message = "Servicio ID nulo";
                }

            } else {
                objError.put("error", "operación no reconocida");
                message = objError.toJSONString();
            }
            if (message != null) {
                out.print("[" + message + "]");
            } else {
                if (operation.equals(OPERATION_QRY)) {
                    out.print("[" + msg + "]");
                } else if (operation.equals(OPERATION_INS)) {
                    target = "indexA.jsp";
                    out.print(target);
                    out.close();
                } else if (operation.equals(OPERATION_UPD)) {
                    target = "indexA.jsp";
                    out.print(target);
                    out.close();
                } else if (operation.equals(OPERATION_GET)) {
                    out.print("[" + msg + "]");
                } else if (operation.equalsIgnoreCase(OPERATION_QRY_SEARCH)) {
                    out.print("[" + msg + "]");
                } else if (operation.equalsIgnoreCase(OPERATION_QRY_SEARCH_SEDE)) {
                    out.print("[" + msg + "]");
                } else if (operation.equalsIgnoreCase(OPERATION_QRY_BY_TUTOR)) {
                    out.print("[" + msg + "]");
                }else if (operation.equalsIgnoreCase(OPERATION_INS_ASIST)) {
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
