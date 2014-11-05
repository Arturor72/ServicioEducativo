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
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dto.Curso;

/**
 *
 * @author Arturo
 */
public class DaoCursoImpl implements DaoCurso {

    private Logger log4j = Logger.getLogger(DaoCursoImpl.class);
    private StConnection db;

    public DaoCursoImpl() {
        db = new StConnection();
    }

    @Override
    public List<Curso> cursoQry(Integer esp_id) {
        log4j.info("+init cursoQry");
        List<Curso> listCursos = null;
        String sql = SistemTConstants.CURSO_SELECT;

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, esp_id);
                ResultSet rs = psmt.executeQuery();
                listCursos = new LinkedList<Curso>();
                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setCur_id(rs.getInt(1));
                    curso.setCur_cod(rs.getString(2));
                    curso.setCur_nom(rs.getString(3));
                    curso.setEsp_id(rs.getInt(4));
                    curso.setCur_est(rs.getBoolean(5));
                    listCursos.add(curso);
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
        log4j.info("-finish cursoQry");
        return listCursos;
    }

    @Override
    public Curso getCurso(Integer cur_id, Integer esp_id) {
        log4j.info("+init GetCurso");
        Curso curso = null;
        String sql = SistemTConstants.CURSO_GET;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, esp_id);
                psmt.setInt(2, cur_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    curso = new Curso();
                    curso.setCur_id(rs.getInt(1));
                    curso.setCur_cod(rs.getString(2));
                    curso.setCur_nom(rs.getString(3));
                    curso.setEsp_id(rs.getInt(4));
                    curso.setCur_est(rs.getBoolean(5));
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
        log4j.info("-finish GetCurso");
        return curso;
    }

    @Override
    public String cursoUpd(Curso curso) {
        log4j.info("+init cursoUpd");
        String sql = SistemTConstants.CURSO_UPDATE;
        Connection cn = db.getConnection();
        String result = null;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setString(1, curso.getCur_cod());
                psmt.setString(2, curso.getCur_nom());
                psmt.setInt(3, curso.getEsp_id());
                psmt.setBoolean(4, curso.isCur_est());
                psmt.setInt(5, curso.getCur_id());
                int r = psmt.executeUpdate();
                if (r <= 0) {
                    result = "No se actualizo";
                    log4j.error(result);
                }

            } catch (SQLException e) {
                log4j.error(e.getMessage());
                if (e.getErrorCode() == Integer.parseInt(SistemTConstants.ERROR_UNIQUE_FIELD)) {
                    if (e.getMessage().contains("cur_cod")) {
                        result = "El codigo de curso ingresado ya existe";
                    }
                    if (e.getMessage().contains("cur_nom")) {
                        result = "Ya existe un curso con ese nombre";
                    }
                } else {
                    result = "El curso no pudo crearse";
                }
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    result = "Error: " + e.getMessage();

                }
            }
        }
        log4j.info("-finish cursoUpd");
        return result;
    }

    @Override
    public String cursoIns(Curso curso) {
        log4j.info("+init cursoIns");
        String sql = SistemTConstants.CURSO_INS;
        Connection cn = db.getConnection();
        String result = null;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setString(1, curso.getCur_cod());
                psmt.setString(2, curso.getCur_nom());
                psmt.setInt(3, curso.getEsp_id());
                psmt.setBoolean(4, curso.isCur_est());
                int r = psmt.executeUpdate();
                if (r <= 0) {
                    result = "No se ingreso";
                    log4j.error(result);
                }

            } catch (SQLException e) {
                log4j.error(e.getMessage() + " ERROR: " + e.getErrorCode());
                if (e.getErrorCode() == Integer.parseInt(SistemTConstants.ERROR_UNIQUE_FIELD)) {
                    if (e.getMessage().contains("cur_cod")) {
                        result = "El codigo de curso ingresado ya existe";
                    }
                    if (e.getMessage().contains("cur_nom")) {
                        result = "Ya existe un curso con ese nombre";
                    }
                } else {
                    result = "El curso no pudo crearse";
                }

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    result = "Error: " + e.getMessage();

                }
            }
        }
        log4j.info("-finish cursoIns");
        return result;
    }

    @Override
    public String cursoDelete(List<Integer> lst) {
        log4j.info("+init cursoDelete");
        String sql = SistemTConstants.CURSO_DELETE;
        Connection cn = db.getConnection();
        String result = null;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                for (Integer x : lst) {
                    psmt.setInt(1, x);
                    int r = psmt.executeUpdate();
                    if (r == 0) {
                        result = "No se actualizo" + x;
                        log4j.error(result);
                    }
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
        log4j.info("-finish cursoDelete");
        return result;
    }

}
