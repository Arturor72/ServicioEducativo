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
import java.util.List;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoAmbiente;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;

/**
 *
 * @author Arturo
 */
public class DaoAmbienteImpl implements DaoAmbiente {

    Logger log4j = Logger.getLogger(DaoAmbienteImpl.class);
    StConnection db;

    public DaoAmbienteImpl() {
        db = new StConnection();
    }

    @Override
    public Ambiente getAmbiente(Integer amb_id) {
        log4j.info("+init getAmbiente");
        Ambiente ambiente = null;
        String sql = SistemTConstants.AMBIENTE_GET;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, amb_id);
                ResultSet rs = psmt.executeQuery();
                if (rs.next()) {
                    ambiente = new Ambiente();
                    ambiente.setAmd_id(rs.getInt(1));
                    ambiente.setSed_id(rs.getInt(2));
                    ambiente.setAmb_den(rs.getString(3));
                    ambiente.setTip_amb_id(rs.getInt(4));
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

        log4j.info("-finish getAmbiente");
        return ambiente;
    }

    @Override
    public List<Ambiente> ambienteQry(Integer sede_id, String fec, String hora) {
        log4j.info("+init ambienteQry");
        List<Ambiente> list = null;
        String sql = "";
        Connection cn = db.getConnection();
        if (cn != null) {

        }
        log4j.info("-finish ambienteQry");
        return list;
    }

}
