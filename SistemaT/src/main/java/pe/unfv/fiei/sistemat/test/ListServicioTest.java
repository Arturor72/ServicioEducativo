/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import java.util.List;
import org.json.simple.JSONObject;
import pe.unfv.fiei.sistemat.model.dao.DaoServicio;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoServicioImpl;
import pe.unfv.fiei.sistemat.model.dto.Servicio;

/**
 *
 * @author Arturo
 */
public class ListServicioTest {

    public static void main(String[] args) {
        DaoServicio daoServicio = new DaoServicioImpl();
        List<Servicio> list = daoServicio.ServicioQryByDate(1, "2014-10-01");
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
        JSONObject objall = new JSONObject();
        int i=0;
        for (Servicio servicio : list) {
            System.out.println(""+servicio.getSer_edu_id());
            JSONObject obj = new JSONObject();
            obj.put("ser_edu_id", servicio.getSer_edu_id());
            obj.put("ser_edu_fec", servicio.getSer_edu_fec());
            obj.put("ser_edu_hin", servicio.getSer_edu_hin());
            obj.put("cur_id", servicio.getCur_id().getCur_nom());
            obj.put("amb_id", servicio.getAmb_id().getAmb_den());
            obj.put("sed_id", servicio.getSed_id().getSed_desc());
            obj.put("tip_serv_id", servicio.getTip_serv_id().getTip_ser_den());
            obj.put("usr_adm_id", servicio.getUsr_adm_id().getUsr_user());
            obj.put("usr_tut_id", servicio.getUsr_tut_id().getUsr_user());
            obj.put("ser_edu_asist", servicio.getSer_edu_asist());
            obj.put("ser_edu_desc", servicio.getSer_edu_desc());
            obj.put("ser_edu_est", servicio.getSer_edu_est());
            objall.put("id-"+i, obj);
            i++;
        }
        System.out.println("----->"+objall.toJSONString());
    }

}
