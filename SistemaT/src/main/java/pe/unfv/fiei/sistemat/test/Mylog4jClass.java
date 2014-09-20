/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import org.apache.log4j.Logger;

/**
 *
 * @author Arturo
 */
public class Mylog4jClass {

    final static Logger log4j = Logger.getLogger(Mylog4jClass.class);

    public static void main(String[] args) {

        Mylog4jClass obj = new Mylog4jClass();
        obj.runMe("Arturo");
    }
    private void runMe(String parameter) {
        if (log4j.isDebugEnabled()) {
            log4j.debug("This is debug : " + parameter);
        }
        if (log4j.isInfoEnabled()) {
            log4j.info("This is info : " + parameter);
        }
        log4j.warn("This is warn : " + parameter);
        log4j.error("This is error : " + parameter);
        log4j.fatal("This is fatal : " + parameter);
    }

}
