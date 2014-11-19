/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoEspecialidadImpl;

/**
 *
 * @author Fer
 */
public class changeServicioState {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Logger log4j = Logger.getLogger(DaoEspecialidadImpl.class);
    StConnection db;
    db = new StConnection();
        log4j.info("+init changeServicioState");
        int state=2;
        int serv_edu_id=54;
        String result = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.SERVICIO_CHANGE_STATE;
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, state);
                psmt.setInt(2, serv_edu_id);
                int c = psmt.executeUpdate();
                
                System.out.println("correcto");
                if (c <= 0) {
                    result = "Error al actualziar estado";
                    log4j.error(result);
                }
                try {
                    psmt.close();
                } catch (SQLException e) {
                    log4j.error(e.getMessage());
                    result = "Error: " + e.getMessage();
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
        log4j.info("-finish changeServicioState");
    }
    
}
