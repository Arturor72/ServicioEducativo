/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao.impl;

import java.sql.Connection;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.model.connection.StConnection;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class DaoUsuarioImpl implements DaoUsuario {

    static Logger log4j = Logger.getLogger(DaoUsuarioImpl.class);

    StConnection db;

    public DaoUsuarioImpl() {
        db = new StConnection();
    }

    @Override
    public Usuario Login(String user, String password) {
        log4j.info("+ init Login");
        Usuario usuario = null;
        Connection cn = db.getConnection();
        if (cn != null) {
            try {

            } catch (Exception e) {
            }
        }
        log4j.info("- finish Login");
        return usuario;
    }

}
