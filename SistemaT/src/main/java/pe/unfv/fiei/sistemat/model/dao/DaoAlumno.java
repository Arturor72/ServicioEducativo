/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Alumno;

/**
 *
 * @author Arturo
 */
public interface DaoAlumno {
 
    public List<Alumno> alumnoQry();
    
    public String alumnoSusp(List<Integer> al_id, Integer state);
        
}
