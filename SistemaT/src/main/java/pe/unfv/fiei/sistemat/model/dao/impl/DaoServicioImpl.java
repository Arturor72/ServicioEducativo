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
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
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
                listServicio=new LinkedList<Servicio>();
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

                    csql = SistemTConstants.AMBIENTE_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, rs.getInt(5));
                    r2 = st.executeQuery();
                    servicio.setAmb_id(getAmbiente(r2));

                    csql = SistemTConstants.SEDE_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, rs.getInt(6));
                    r2 = st.executeQuery();
                    servicio.setSed_id(getSede(r2));

                    csql = SistemTConstants.TIPO_SERVICIO_GET;
                    st = cn.prepareStatement(csql);
                    st.setInt(1, rs.getInt(7));
                    r2 = st.executeQuery();
                    servicio.setTip_serv_id(getTipoServicio(r2));

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

    private Ambiente getAmbiente(ResultSet rs) throws SQLException {
        Ambiente ambiente = new Ambiente();
        if (rs.next()) {
            ambiente.setAmd_id(rs.getInt(1));
            ambiente.setSed_id(rs.getInt(2));
            ambiente.setAmb_den(rs.getString(3));
            ambiente.setTip_amb_id(rs.getInt(4));
        }

        return ambiente;
    }

    private Sede getSede(ResultSet rs) throws SQLException {
        Sede sede = new Sede();
        if (rs.next()) {
            sede.setSed_id(rs.getInt(1));
            sede.setSed_desc(rs.getString(2));
        }

        return sede;
    }

    private TipoServicio getTipoServicio(ResultSet rs) throws SQLException {
        TipoServicio tipoServicio = new TipoServicio();
        if (rs.next()) {
            tipoServicio.setTip_ser_id(rs.getInt(1));
            tipoServicio.setTip_ser_den(rs.getString(2));
            tipoServicio.setTip_ser_durac(rs.getInt(3));
        }

        return tipoServicio;
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
