/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.test;

import pe.unfv.fiei.sistemat.model.dao.impl.DaoAlumnoImpl;
import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Alumno;
/**
 *
 * @author Arturo
 */
public class AlumnoTest {
    public static void main(String[] args) {
        
        List<Alumno> list=new DaoAlumnoImpl().alumnoQry();
        for (Alumno alumno : list) {
            System.out.println(""+alumno.getAl_apat());
        }
    }
}
