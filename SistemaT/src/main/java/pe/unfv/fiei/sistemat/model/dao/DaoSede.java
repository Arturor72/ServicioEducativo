/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Sede;

/**
 *
 * @author Arturo
 */
public interface DaoSede {

    public Sede getSede(Integer sede_id);

    public List<Sede> SedeQry();
}
