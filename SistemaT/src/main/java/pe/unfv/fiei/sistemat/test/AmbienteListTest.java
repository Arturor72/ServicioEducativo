/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import pe.unfv.fiei.sistemat.model.dao.DaoAmbiente;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoAmbienteImpl;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;
import java.util.List;

/**
 *
 * @author Arturo
 */
public class AmbienteListTest {

    public static void main(String[] args) {
        DaoAmbiente daoAmbiente = new DaoAmbienteImpl();
        List<Ambiente> list=daoAmbiente.dispAmbienteQry("2014-10-03", "16:30:00", 1, 1); 
        for (Ambiente ambiente : list) {
            System.out.println("-"+ambiente.getAmd_id()+" "+ambiente.getAmb_den());
        }
    }

}
