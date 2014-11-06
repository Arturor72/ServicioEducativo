/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;

/**
 *
 * @author JULIO
 */
public interface DaoAsistencia {
    
    public String registrarAsistenciaAlumnos(Integer serEduId, List<Integer> alId, Integer astAsist);
    
}
