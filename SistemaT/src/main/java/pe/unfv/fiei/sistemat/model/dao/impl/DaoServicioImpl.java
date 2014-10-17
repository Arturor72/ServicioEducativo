/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoAmbiente;
import pe.unfv.fiei.sistemat.model.dao.DaoSede;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
import pe.unfv.fiei.sistemat.model.dao.DaoTipoServicio;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Sede;
import pe.unfv.fiei.sistemat.model.dto.Servicio;
import pe.unfv.fiei.sistemat.model.dto.TipoServicio;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class DaoServicioImpl implements DaoServicio {

    private Logger log4j = Logger.getLogger(DaoEspecialidadImpl.class);
    private StConnection db;

    public DaoServicioImpl() {
        db = new StConnection();
    }

    @Override
    public List<Servicio> ServicioQry(Integer esp_id) {
        log4j.info("+init ServicioQry");
        List<Servicio> listServicio = null;
        String sql = SistemTConstants.SERVICIO_SELECT;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, esp_id);
                ResultSet rs = st.executeQuery();
                listServicio = new LinkedList<Servicio>();
                DaoAmbiente daoAmbiente = new DaoAmbienteImpl();
                DaoSede daoSede = new DaoSedeImpl();
                DaoTipoServicio daoTipoServicio = new DaoTipoServicioImpl();
                while (rs.next()) {
                    Servicio servicio = new Servicio();
                    servicio.setSer_edu_id(rs.getInt(1));
                    servicio.setSer_edu_fec(rs.getDate(2));
                    servicio.setSer_edu_hin(String.valueOf(rs.getTime(3)));

                    String csql = SistemTConstants.CURSO_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, esp_id);
                    st.setInt(2, rs.getInt(4));
                    ResultSet r2 = st.executeQuery();
                    servicio.setCur_id(getCurso(r2));

                    servicio.setAmb_id(daoAmbiente.getAmbiente(rs.getInt(5)));
                    servicio.setSed_id(daoSede.getSede(rs.getInt(6)));
                    servicio.setTip_serv_id(daoTipoServicio.getTipoServicio(rs.getInt(7)));

                    csql = SistemTConstants.USER_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, rs.getInt(8));
                    r2 = st.executeQuery();
                    servicio.setUsr_adm_id(getUser(r2));
                    csql = SistemTConstants.USER_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, rs.getInt(9));
                    r2 = st.executeQuery();
                    servicio.setUsr_tut_id(getUser(r2));
                    servicio.setSer_edu_asist(rs.getInt(10));
                    servicio.setSer_edu_desc(rs.getString(11));

                    servicio.setSer_edu_est(rs.getInt(12));
                    listServicio.add(servicio);
                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                }
            }
        }

        log4j.info("-finish ServicioQry");
        return listServicio;
    }

    @Override
    public String ServicioIns(Servicio servicio) {
        log4j.info("+init ServicioIns");
        String result = null;
        String sql = SistemTConstants.SERVICIO_INSERT;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setDate(1, servicio.getSer_edu_fec());
                psmt.setTime(2, Time.valueOf(servicio.getSer_edu_hin()));
                psmt.setInt(3, servicio.getCur_id().getCur_id());
                psmt.setInt(4, servicio.getAmb_id().getAmd_id());
                psmt.setInt(5, servicio.getSed_id().getSed_id());
                psmt.setInt(6, servicio.getTip_serv_id().getTip_ser_id());
                psmt.setInt(7, servicio.getUsr_adm_id().getUsr_id());
                psmt.setInt(8, servicio.getUsr_tut_id().getUsr_id());
                psmt.setInt(9, servicio.getSer_edu_asist());
                psmt.setString(10, servicio.getSer_edu_desc());
                psmt.setInt(11, servicio.getSer_edu_est());
                int r = psmt.executeUpdate();
                if (r <= 0) {
                    result = "No se ingreso";
                    log4j.error(result);
                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
                result = "Error: " + e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    result = "Error: " + e.getMessage();
                }
            }

        }
        log4j.info("-finish ServicioIns");
        return result;
    }

    private Curso getCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        if (rs.next()) {
            curso.setCur_id(rs.getInt(1));
            curso.setCur_cod(rs.getString(2));
            curso.setCur_nom(rs.getString(3));
            curso.setEsp_id(rs.getInt(4));
            curso.setCur_est(rs.getBoolean(4));
        }
        return curso;
    }

    private Usuario getUser(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();

        if (rs.next()) {
            u.setUsr_id(rs.getInt(1));
            u.setUsr_cod(rs.getString(2));
            u.setTip_usr_id(rs.getInt(3));
            u.setUsr_nom(rs.getString(4));
            u.setUsr_apat(rs.getString(5));
            u.setUsr_amat(rs.getString(6));
            u.setUsr_dni(rs.getString(7));
            u.setUsr_gen(rs.getInt(8));
            u.setUsr_cel(rs.getString(9));
            u.setUsr_mail(rs.getString(10));
            u.setUsr_user(rs.getString(11));
            u.setUsr_pass(rs.getString(12));
            u.setUsr_est(rs.getInt(13));
            u.setEsp_id(rs.getInt(14));

        }
        return u;
    }
}
