/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.dao.DaoAsistencia;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.model.connection.StConnection;

/**
 *
 * @author JULIO
 */
public class DaoAsistenciaImpl implements DaoAsistencia{
    
    static Logger log4j = Logger.getLogger(DaoUsuarioImpl.class);
    StConnection db = null;

    public DaoAsistenciaImpl() {
        db = new StConnection();
    }

    @Override
    public String registrarAsistenciaAlumnos(Integer serEduId, List<Integer> alId, Integer estAsist) {
        log4j.info("- init asistencia alumnos INSERT");
        String sql = SistemTConstants.ASISTENCIA_INSERT;
        log4j.info("Sentence" + sql);
        String message = null;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement preparedStatement = cn.prepareStatement(sql);
                for (Integer i : alId) {
                    preparedStatement.setInt(1, serEduId);
                    preparedStatement.setInt(2, i);
                    preparedStatement.setInt(3, estAsist);
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
        log4j.info("- init asistencia alumnos INSERT");
        return message;
    }
    
}
