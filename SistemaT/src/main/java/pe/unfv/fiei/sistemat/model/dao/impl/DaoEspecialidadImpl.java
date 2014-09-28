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
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoEspecialidad;
import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Especialidad;

/**
 *
 * @author Arturo
 */
public class DaoEspecialidadImpl implements DaoEspecialidad {
    public Logger log4j=Logger.getLogger(DaoEspecialidadImpl.class);
    StConnection db;

    public DaoEspecialidadImpl() {
         db = new StConnection();
    }

    @Override
    public Especialidad getEspecialidad(Integer esp_id) {
        log4j.info("+init GetEspecialidad");
        Especialidad especialidad = null;
        String sql=SistemTConstants.ESPECIALIDAD_GET;
        Connection cn = db.getConnection();
        if (cn!=null) {
          try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, esp_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    especialidad = new Especialidad();
                    especialidad.setEsp_id(rs.getInt(1)); 
                    especialidad.setEsp_cod(rs.getString(2));
                    especialidad.setEsp_nom(rs.getString(3));
                    
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
        log4j.info("-finish GetEspecialidad");
        return especialidad;
    }

}
