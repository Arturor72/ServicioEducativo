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
import pe.unfv.fiei.sistemat.model.dao.DaoAlumno;
import static pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl.log4j;
import pe.unfv.fiei.sistemat.model.dto.Alumno;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class DaoAlumnoImpl implements DaoAlumno{
 static Logger log4j = Logger.getLogger(DaoUsuarioImpl.class);
    StConnection db = null;

    public DaoAlumnoImpl() {
        db = new StConnection();
    }

    
    @Override
    public List<Alumno> alumnoQry() {
         log4j.info("+ init alumnoQRY");
        List<Alumno> list = null;
        String sql = SistemTConstants.ALUMNO_SELECT;
        log4j.info("Sentence" + sql);
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                list = new LinkedList<Alumno>();
                while (rs.next()) {
                    Alumno a = new Alumno();
                    a.setAl_id(rs.getInt(1));
                    a.setAl_cod(rs.getString(2));
                    a.setAl_nom(rs.getString(3));
                    a.setAl_apat(rs.getString(4));
                    a.setAl_amat(rs.getString(5));
                    a.setAl_cel(rs.getString(6));
                    a.setAl_mail(rs.getString(7));
                    a.setAl_susp(rs.getInt(8));
                    list.add(a);
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
        log4j.info("- finish alumnoQRY");
        return list;
    }
    
}
