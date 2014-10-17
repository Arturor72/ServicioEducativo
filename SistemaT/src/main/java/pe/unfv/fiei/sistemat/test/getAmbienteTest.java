/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import pe.unfv.fiei.sistemat.model.dao.impl.DaoAmbienteImpl;
import pe.unfv.fiei.sistemat.model.dto.Ambiente;

/**
 *
 * @author Arturo
 */
public class getAmbienteTest {

    public static void main(String args[]) {
        Ambiente amb=new DaoAmbienteImpl().getAmbiente(1);
        System.out.println(amb.getAmb_den());
        
    }

}
