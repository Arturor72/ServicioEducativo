package pe.unfv.fiei.sistemat.util.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;

/**
 *
 * @author Arturo
 */
public class ConfigurationTest {
    static String bdname;
    static String driver;
    static String url;
    
    public ConfigurationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        bdname=SistemTConstants.SISTEMAT_BDNAME;
        driver=SistemTConstants.SISTEMAT_DRIVER;
        url=SistemTConstants.SISTEMAT_URL;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testBDName() {
         assertEquals("dbservicio", bdname);
         assertEquals("jdbc:mysql://localhost:3306/", url);
         assertEquals("com.mysql.jdbc.Driver", driver);
         
         
     }
}
