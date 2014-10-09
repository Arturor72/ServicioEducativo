/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.test;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoServicioImpl;
import pe.unfv.fiei.sistemat.model.dto.Servicio;

/**
 *
 * @author Arturo
 */
public class ListServicioTest {
    public static void main(String[] args) {
        DaoServicio daoServicio=new DaoServicioImpl();
        List<Servicio> list=daoServicio.ServicioQry(1);
        for (Servicio servicio : list) {
            System.out.println("************Test***********************");
            System.out.println("-"+servicio.getSer_edu_id());
            System.out.println("-"+servicio.getSer_edu_fec());
            System.out.println("-"+servicio.getSer_edu_hin());
            System.out.println("-"+servicio.getCur_id().getCur_nom());
            System.out.println("-"+servicio.getAmb_id().getAmb_den());
            System.out.println("-"+servicio.getSed_id().getSed_desc());
            System.out.println("-"+servicio.getTip_serv_id().getTip_ser_den());
            System.out.println("-"+servicio.getUsr_adm_id().getUsr_nom());
            System.out.println("-"+servicio.getUsr_tut_id().getUsr_nom());
            System.out.println("-"+servicio.getSer_edu_asist());
            System.out.println("-"+servicio.getSer_edu_desc());
            System.out.println("-"+servicio.getSer_edu_est());
           
            System.out.println("---************Test***********************");
        }
        
    }
    
}
