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
import pe.unfv.fiei.sistemat.model.dao.DaoCurso;
import pe.unfv.fiei.sistemat.model.dto.Curso;

/**
 *
 * @author Arturo
 */
public class DaoCursoImpl implements DaoCurso {

    private Logger logh4j = Logger.getLogger(DaoCursoImpl.class);
    private StConnection db;

    public DaoCursoImpl() {
        db = new StConnection();
    }

    @Override
    public List<Curso> cursoQry(Integer esp_id) {
        logh4j.info("+init cursoQry");
        List<Curso> listCursos = null;
        String sql = SistemTConstants.CURSO_SELECT;

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement psmt = cn.prepareStatement(sql);
                psmt.setInt(1, esp_id);
                ResultSet rs = psmt.executeQuery();
                listCursos = new LinkedList<Curso>();
                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setCur_id(rs.getInt(1));
                    curso.setCur_cod(rs.getString(2));
                    curso.setCur_nom(rs.getString(3));
                    curso.setEsp_id(rs.getInt(4));
                    curso.setCur_est(rs.getBoolean(5));
                    listCursos.add(curso);
                }

            } catch (SQLException e) {
                logh4j.error(e.getMessage());

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    logh4j.error(e.getMessage());
                }
            }
        }
        logh4j.info("-finish cursoQry");
        return listCursos;
    }

}
