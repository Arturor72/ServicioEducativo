/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.test;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dao.DaoUsuario;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoUsuarioImpl;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class UsuarioTest {

    public static void main(String[] args) {
        DaoUsuario daoUsuario = new DaoUsuarioImpl();
        
        List<Usuario> list = daoUsuario.dispUsuarioQry("2014-10-03", "17:00:00", 1, 2, 1);
        for (Usuario usuario : list) {
            System.out.println(""+usuario.getUsr_nom());
        }
    }
}
