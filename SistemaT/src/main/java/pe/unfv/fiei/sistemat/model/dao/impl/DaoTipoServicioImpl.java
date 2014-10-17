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
import pe.unfv.fiei.sistemat.model.dao.DaoTipoServicio;
import pe.unfv.fiei.sistemat.model.dto.TipoServicio;

/**
 *
 * @author Arturo
 */
public class DaoTipoServicioImpl implements DaoTipoServicio {

    Logger log4j = Logger.getLogger(DaoTipoServicioImpl.class);
    StConnection db;

    public DaoTipoServicioImpl() {
        db = new StConnection();
    }

    @Override
    public TipoServicio getTipoServicio(Integer tipo_servicio_id) {
        log4j.info("+init getTipoServicio");
        TipoServicio tipoServicio = null;
        String sql = SistemTConstants.TIPO_SERVICIO_GET;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, tipo_servicio_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    tipoServicio = new TipoServicio();
                    tipoServicio.setTip_ser_id(rs.getInt(1));
                    tipoServicio.setTip_ser_den(rs.getString(2));
                    tipoServicio.setTip_ser_durac(rs.getInt(3));
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

        log4j.info("-finish getTipoServicio");
        return tipoServicio;

    }

}
