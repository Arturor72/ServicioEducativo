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
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class DaoUsuarioImpl implements DaoUsuario {

    static Logger log4j = Logger.getLogger(DaoUsuarioImpl.class);
    StConnection db = null;

    public DaoUsuarioImpl() {
        db = new StConnection();
    }

    @Override
    public Usuario Login(String user, String password) {
        log4j.info("+ init Login");
        Usuario usuario = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.LOGIN_SELECT;
        log4j.info("Sentence" + sql);

        if (cn != null) {
            try {

                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, user);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setUsr_id(rs.getInt(1));
                    usuario.setUsr_cod(rs.getString(2));
                    usuario.setTip_usr_id(rs.getInt(3));
                    usuario.setUsr_nom(rs.getString(4));
                    usuario.setUsr_apat(rs.getString(5));
                    usuario.setUsr_amat(rs.getString(6));
                    usuario.setUsr_dni(rs.getString(7));
                    usuario.setUsr_gen(rs.getInt(8));
                    usuario.setUsr_cel(rs.getString(9));
                    usuario.setUsr_mail(rs.getString(10));
                    usuario.setUsr_user(rs.getString(11));
                    usuario.setUsr_pass(rs.getString(12));
                    usuario.setUsr_est(rs.getInt(13));
                    usuario.setEsp_id(rs.getInt(14));
                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    log4j.error(ex.getMessage());
                }
            }
        }
        log4j.info("- finish Login");
        return usuario;
    }

    @Override
    public List<Usuario> usuarioQry(Integer tip_usr_id, Integer esp_id) {
        log4j.info("+ init usuario QRY");
        List<Usuario> list = null;
        String sql = SistemTConstants.USER_SELECT;
        log4j.info("Sentence" + sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, tip_usr_id);
                ps.setInt(2, esp_id);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<Usuario>();
                while (rs.next()) {
                    Usuario u = new Usuario();
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

                    list.add(u);
                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    log4j.error(ex.getMessage());
                }
            }
        }
        log4j.info("- finish usuario QRY");
        return list;
    }
    @Override
    public String usuarioIns(Usuario usuario) {
        log4j.info("- init usuario INSERT");
        String message = null;
        String sql = SistemTConstants.USER_INSERT;
        log4j.info("Sentence" + sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getUsr_cod());
                preparedStatement.setInt(2, usuario.getTip_usr_id());
                preparedStatement.setString(3, usuario.getUsr_nom());
                preparedStatement.setString(4, usuario.getUsr_apat());
                preparedStatement.setString(5, usuario.getUsr_amat());
                preparedStatement.setString(6, usuario.getUsr_dni());
                preparedStatement.setInt(7, usuario.getUsr_gen());
                preparedStatement.setString(8, usuario.getUsr_cel());
                preparedStatement.setString(9, usuario.getUsr_mail());
                preparedStatement.setString(10, usuario.getUsr_user());
                preparedStatement.setString(11, usuario.getUsr_pass());
                preparedStatement.setInt(12, usuario.getUsr_est());
                preparedStatement.setInt(13, usuario.getEsp_id());

                int cuantos = preparedStatement.executeUpdate();
                if (cuantos == 0) {
                    message = "0 filas afectadas";
                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
                message = "[ERROR] " + e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    message = "[ERROR] " + e.getMessage();
                }
            }
        }
        log4j.info("- finish usuario INSERT");
        return message;
    }

    @Override
    public String usuarioDel(List<Integer> ids) {
        log4j.info("- init usuario DELETE");
        String sql = SistemTConstants.USER_DELETE;
        log4j.info("Sentence" + sql);
        String message = "";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                for (Integer i : ids) {
                    preparedStatement.setInt(1, i);
                    int cuantos = preparedStatement.executeUpdate();
                    if (cuantos == 0) {
                        message = "0 filas afectadas";
                        log4j.error(message);
                    }

                }
            } catch (SQLException e) {
                log4j.error(e.getMessage());
                message = "[ERROR] " + e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    message = "[ERROR] " + e.getMessage();
                }
            }
        }
        log4j.info("- init usuario DELETE");
        return message;
    }

    @Override
    public Usuario usuarioGet(Integer idUsuario) {
        log4j.info("- init usuario GET");
        Usuario u = null;
        String sql = SistemTConstants.USER_GET;
        log4j.info("Sentence" + sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                preparedStatement.setInt(1, idUsuario);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    u = new Usuario();

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
            } catch (SQLException ex) {
                log4j.error(ex.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    log4j.error(ex.getMessage());

                }
            }

        }
        log4j.info("- finish usuario GET");
        return u;

    }

    @Override
    public String usuarioUpd(Usuario usuario) {
        log4j.info("+init usuario UPD");
        String sql = SistemTConstants.USER_UPDATE;
        log4j.info("Sentence" + sql);
        String message = "";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getUsr_cod());
                preparedStatement.setInt(2, usuario.getTip_usr_id());
                preparedStatement.setString(3, usuario.getUsr_nom());
                preparedStatement.setString(4, usuario.getUsr_apat());
                preparedStatement.setString(5, usuario.getUsr_amat());
                preparedStatement.setString(6, usuario.getUsr_dni());
                preparedStatement.setInt(7, usuario.getUsr_gen());
                preparedStatement.setString(8, usuario.getUsr_mail());
                preparedStatement.setString(9, usuario.getUsr_user());
                preparedStatement.setString(10, usuario.getUsr_pass());
                preparedStatement.setInt(11, usuario.getUsr_est());
                preparedStatement.setInt(12, usuario.getEsp_id());
                preparedStatement.setInt(13, usuario.getUsr_id());
                
                int cuantos = preparedStatement.executeUpdate();
                if(cuantos == 0){
                    message = "0 filas actualizadas";
                    log4j.error(message);
                }
                
            } catch (SQLException e) {
                log4j.error(e.getMessage());
                message = "[ERROR] " + e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    message = "[ERROR] " + e.getMessage();
                }
            }

        }
        log4j.info("+init usuario UPD");
        return message;
    }
}
