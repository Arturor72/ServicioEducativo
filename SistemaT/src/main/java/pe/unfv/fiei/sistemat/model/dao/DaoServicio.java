/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Servicio;

/**
 *
 * @author Arturo
 */
public interface DaoServicio {

    public List<Servicio> ServicioQry(Integer esp_id);

    public String ServicioIns(Servicio servicio);

    public Servicio ServicioGet(Integer serv_id);

    public String ServicioUpd(Servicio servicio);

    public String ServicioDel(List<Integer> ids);
    
    public List<Servicio> ServicioQryByDate(Integer esp_id, String ser_edu_fec);
    
    public List<Servicio> ServicioQryBySede(Integer esp_id, String sed_id);
    
    public List<Servicio> ServicioQryByTutor(Integer tut_id);
    
    public String ServicioInsAsist(Integer serv_edu_id);
    
    public String changeServicioState(Integer serv_edu_id, Integer state);
    
    public String UpdateStateService();
}
