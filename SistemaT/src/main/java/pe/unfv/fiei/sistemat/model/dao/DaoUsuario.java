/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public interface DaoUsuario {

    public Usuario Login(String user, String password);

    public List<Usuario> usuarioQry(Integer tip_usr_id, Integer esp_id);

    public String usuarioIns(Usuario usuario);

    public String usuarioDel(List<Integer> ids);

    public Usuario usuarioGet(Integer idUsuario);

    public String usuarioUpd(Usuario usuario);
    
    public List<Usuario> dispUsuarioQry(String fecha, String hora, Integer tip_serv_id, Integer tip_user_id, Integer esp_id);
}
