/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Curso;

/**
 *
 * @author Arturo
 */
public interface DaoCurso {

    public List<Curso> cursoQry(Integer esp_id);

    public Curso getCurso(Integer cur_id,Integer esp_id);
    
    public String cursoIns(Curso curso);
    
    public String cursoUpd(Curso curso);
    
    public String cursoDelete(List<Integer> lst);
            

}
