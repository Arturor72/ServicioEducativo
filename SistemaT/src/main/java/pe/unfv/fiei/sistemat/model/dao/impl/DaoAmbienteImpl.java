/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
    public List<Ambiente> dispAmbienteQry(String fecha, String hora, Integer serv_id, Integer sed_id) {
        log4j.info("+init dispAmbienteQry");
        List<Ambiente> list = null;
        Connection cn = db.getConnection();
        String sql = SistemTConstants.AMBIENTE_GET_LIST_DISPONIBLE;
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(sql);
                cs.setString(1, fecha);
                cs.setString(2, hora);
                cs.setInt(3, serv_id);
                cs.setInt(4, sed_id);
                ResultSet rs = cs.executeQuery();
                list = new LinkedList<Ambiente>();
                while (rs.next()) {
                    if (rs.getTime(4) == null) {
                        Ambiente ambiente = new Ambiente();
                        ambiente.setAmd_id(rs.getInt(1));
                        ambiente.setSed_id(sed_id);
                        ambiente.setAmb_den(rs.getString(2));
                        list.add(ambiente);
                    }

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

        log4j.info("-finish dispAmbienteQry");
        return list;

    }

}
