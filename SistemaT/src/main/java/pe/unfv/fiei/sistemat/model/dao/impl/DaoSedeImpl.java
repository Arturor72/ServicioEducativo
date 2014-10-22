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
import pe.unfv.fiei.sistemat.model.dao.DaoSede;

import pe.unfv.fiei.sistemat.model.dto.Sede;

/**
 *
 * @author Arturo
 */
public class DaoSedeImpl implements DaoSede {

    Logger log4j = Logger.getLogger(DaoSedeImpl.class);
    StConnection db;

    public DaoSedeImpl() {
        db = new StConnection();
    }

    @Override
    public Sede getSede(Integer sede_id) {
        log4j.info("+init getSede");
        Sede sede = null;
        String sql = SistemTConstants.SEDE_GET;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setInt(1, sede_id);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    sede = new Sede();
                    sede.setSed_id(rs.getInt(1));
                    sede.setSed_desc(rs.getString(2));
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
        log4j.info("-finish getSede");
        return sede;
    }

    public List<Sede> SedeQry() {
        log4j.info("+init sedeQry");
        List<Sede> listSedes = null;
        String sql = SistemTConstants.SEDE_QRY;

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                listSedes = new LinkedList<Sede>();
                while (rs.next()) {
                    Sede sede = new Sede();
                    sede.setSed_id(rs.getInt(1));
                    sede.setSed_desc(rs.getString(2));
                    listSedes.add(sede);
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
        log4j.info("-finish sedeQry");
        return listSedes;
    }
}
