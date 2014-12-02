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
import pe.unfv.fiei.sistemat.model.dao.DaoReportes;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Usuario;
import pe.unfv.fiei.sistemat.model.dto.report.ReportACE;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTC;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTHM;

/**
 *
 * @author Arturo
 */
public class DaoReportesImpl implements DaoReportes {

    private Logger log4j = Logger.getLogger(DaoReportesImpl.class);
    private StConnection db;

    public DaoReportesImpl() {
        db = new StConnection();
    }

    @Override
    public List<ReportTHM> ReportTHMQry(Integer mes, Integer esp_id, Integer anio) {
        log4j.info("+init ReportTHMQry");
        List<ReportTHM> list = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.REPORT_THM;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareCall(sql);
                psmt.setInt(1, mes);
                psmt.setInt(2, esp_id);
                psmt.setInt(3, anio);
                ResultSet rs = psmt.executeQuery();
                list = new LinkedList<ReportTHM>();
                while (rs.next()) {
                    ReportTHM report = new ReportTHM();
                    Usuario u = new Usuario();
                    u.setUsr_id(rs.getInt(1));
                    u.setUsr_cod(rs.getString(2));
                    u.setTip_usr_id(rs.getInt(3));
                    u.setUsr_nom(rs.getString(4));
                    u.setUsr_apat(rs.getString(5));
                    u.setUsr_amat(rs.getString(6));
                    u.setUsr_dni(rs.getString(7));
                    u.setUsr_cel(rs.getString(8));
                    u.setUsr_mail(rs.getString(9));
                    u.setUsr_user(rs.getString(10));
                    u.setEsp_id(rs.getInt(13));
                    report.setUsr_tutor(u);
                    report.setHoras(rs.getInt(14));
                    report.setMes(rs.getInt(15));
                    list.add(report);
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
        log4j.info("-finish ReportTHMQry");
        return list;
    }

    @Override
    public String ReportATQry(Integer serv_id, Integer esp_id) {
        log4j.info("+init  ReportATQry");
        String result = null;
        String sql = SistemTConstants.REPORT_AT;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareCall(sql);
                psmt.setInt(1, serv_id);
                psmt.setInt(2, esp_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    result = String.valueOf(rs.getInt(1));
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
        log4j.info("-finish  ReportATQry");
        return result;
    }

    @Override
    public List<ReportACE> ReportACEQry(Integer esp_id) {
        log4j.info("+init ReportACEQry");
        List<ReportACE> list = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.REPORT_ACE;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareCall(sql);
                psmt.setInt(1, esp_id);

                ResultSet rs = psmt.executeQuery();
                list = new LinkedList<ReportACE>();
                while (rs.next()) {
                    ReportACE report = new ReportACE();
                    Curso c = new Curso();
                    c.setCur_id(rs.getInt(1));
                    c.setCur_cod(rs.getString(2));
                    c.setCur_nom(rs.getString(3));
                    c.setEsp_id(rs.getInt(4));
                    c.setCur_est(rs.getBoolean(5));
                    report.setCurso(c);
                    report.setTotal(rs.getInt(6));
                    list.add(report);
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
        log4j.info("-finish ReportACEQry");
        return list;
    }

    @Override
    public List<ReportTC> ReportTCQry(Integer esp_id, Integer tip_serv_id) {
        log4j.info("+init ReportTCQry");
        List<ReportTC> list = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.REPORT_TC;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareCall(sql);
                psmt.setInt(1, esp_id);
                psmt.setInt(2, tip_serv_id);
                ResultSet rs = psmt.executeQuery();
                list = new LinkedList<ReportTC>();
                while (rs.next()) {
                    ReportTC report = new ReportTC();
                    Usuario u = new Usuario();
                    u.setUsr_id(rs.getInt(1));
                    u.setUsr_cod(rs.getString(2));
                    u.setTip_usr_id(rs.getInt(3));
                    u.setUsr_nom(rs.getString(4));
                    u.setUsr_apat(rs.getString(5));
                    u.setUsr_amat(rs.getString(6));
                    u.setUsr_dni(rs.getString(7));
                    u.setUsr_cel(rs.getString(9));
                    u.setUsr_mail(rs.getString(10));
                    u.setUsr_user(rs.getString(11));
                    u.setEsp_id(rs.getInt(14));
                    Curso c = new Curso();
                    c.setCur_id(rs.getInt(15));
                    c.setCur_cod(rs.getString(16));
                    c.setCur_nom(rs.getString(17));
                    c.setEsp_id(rs.getInt(18));
                    c.setCur_est(rs.getBoolean(19));
                    report.setUser_tutor(u);
                    report.setCurso(c);
                    list.add(report);
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
        log4j.info("-finish ReportTCQry");
        return list;
    }

}
