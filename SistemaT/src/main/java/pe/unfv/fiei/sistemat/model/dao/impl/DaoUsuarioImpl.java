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
        List<Usuario> list = null;
        String sql = SistemTConstants.USER_SELECT;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, tip_usr_id);
                ps.setInt(2, esp_id);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<Usuario>();
                while(rs.next()){
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
            } catch (SQLException ex) {  
            } finally{
                try {
                    cn.close();
                } catch (SQLException ex) { 
                }
            }
        }
        return list;
    }
}
