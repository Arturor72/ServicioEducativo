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
import java.util.logging.Level;
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
                    usuario.setUsr_Id(rs.getInt(1));
                    usuario.setUsr_Cod(rs.getString(2));
                    usuario.setTip_Usr_Id(rs.getInt(3));
                    usuario.setUsr_Nom(rs.getString(4));
                    usuario.setUsr_Apat(rs.getString(5));
                    usuario.setUsr_Amat(rs.getString(6));
                    usuario.setUsr_Dni(rs.getString(7));
                    usuario.setUsr_Gen(rs.getInt(8));
                    usuario.setUsr_Cel(rs.getString(9));
                    usuario.setUsr_Mail(rs.getString(10));
                    usuario.setUsr_User(rs.getString(11));
                    usuario.setUsr_Pass(rs.getString(12));
                    usuario.setUsr_Est(rs.getInt(13));
                    usuario.setEsp_Id(rs.getInt(14));
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

}
