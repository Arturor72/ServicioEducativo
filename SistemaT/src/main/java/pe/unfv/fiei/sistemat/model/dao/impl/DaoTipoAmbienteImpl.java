/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao.impl;

import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoTipoAmbiente;
import pe.unfv.fiei.sistemat.model.dto.TipoAmbiente;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Arturo
 */
public class DaoTipoAmbienteImpl implements DaoTipoAmbiente {

    Logger log4j = Logger.getLogger(DaoTipoAmbienteImpl.class);
    StConnection db;

    public DaoTipoAmbienteImpl() {
        db = new StConnection();
    }

    @Override
    public TipoAmbiente getTipoAmbiente(Integer tipo_amb_id) {
        log4j.info("+init getTipoAmbiente");
        TipoAmbiente tipoAmbiente = null;
        String sql = SistemTConstants.TIPO_AMBIENTE_GET;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, tipo_amb_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    tipoAmbiente = new TipoAmbiente();
                    tipoAmbiente.setTip_amb_id(rs.getInt(1));
                    tipoAmbiente.setTip_amb_den(rs.getString(2));
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

        log4j.info("-finish getTipoAmbiente");
        return tipoAmbiente;
    }

}
