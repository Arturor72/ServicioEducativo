/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.util.test;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.unfv.fiei.sistemat.model.connection.StConnection;

/**
 *
 * @author Arturo
 */
public class ConnectionTest {
   static  Connection cn=null;
    
    public ConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        StConnection db=new StConnection();
        cn=db.getConnection();
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
     public void TestConnection() {
         assertNotNull(cn);
     }
}
