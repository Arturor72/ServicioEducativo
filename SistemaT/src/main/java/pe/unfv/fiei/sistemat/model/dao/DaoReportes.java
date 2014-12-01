/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTHM;

/**
 *
 * @author Arturo
 */
public interface DaoReportes {
    public List<ReportTHM> ReportTHMQry(Integer mes, Integer esp_id);
    
    public String ReportATQry(Integer serv_id, Integer esp_id);
        
}
