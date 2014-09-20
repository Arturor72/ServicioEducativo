/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;

/**
 *
 * @author Arturo
 */
public class StConnection {

    public static Logger log4j = Logger.getLogger(StConnection.class);

    public StConnection() {

    }

    public Connection getConnection() {
        log4j.info("+ Init getConnection");
        Connection cn = null;
        try {
            Class.forName(SistemTConstants.SISTEMAT_DRIVER).newInstance();
            cn = DriverManager.getConnection(SistemTConstants.SISTEMAT_URL + SistemTConstants.SISTEMAT_BDNAME,
                    SistemTConstants.SISTEMAT_USER, SistemTConstants.SISTEMAT_PASSWORD);
            log4j.info("Connection succesful !!!");
        } catch (ClassNotFoundException ex) {
            log4j.error(ex.getMessage());
        } catch (InstantiationException ex) {
            log4j.error(ex.getMessage());
        } catch (IllegalAccessException ex) {
            log4j.error(ex.getMessage());
        } catch (SQLException ex) {
            log4j.error(ex.getMessage());
        }
        log4j.info("- Finish getConnection");
        return cn;
    }

}
