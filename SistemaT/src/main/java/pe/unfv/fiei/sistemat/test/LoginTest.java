/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.test;

import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class LoginTest {
    public static void main(String[] args) {
        String user="lcastillo";
        String password="mypass";
        DaoUsuario daoUsuario=new DaoUsuarioImpl();
        Usuario usuario=daoUsuario.Login(user, password);
        System.out.println(""+usuario.getUsr_Nom()+usuario.getUsr_Pass());
        
        
    }
}

