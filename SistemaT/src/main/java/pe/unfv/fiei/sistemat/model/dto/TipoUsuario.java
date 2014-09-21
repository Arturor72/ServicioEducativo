/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author JULIO
 */
public class TipoUsuario {
    private Set<Usuario> tip_usr_id = new HashSet<Usuario>();
    private String tip_usr_desc;

    public Set<Usuario> getTip_usr_id() {
        return tip_usr_id;
    }

    public void setTip_usr_id(Set<Usuario> tip_usr_id) {
        this.tip_usr_id = tip_usr_id;
    }

    public String getTip_usr_desc() {
        return tip_usr_desc;
    }

    public void setTip_usr_desc(String tip_usr_desc) {
        this.tip_usr_desc = tip_usr_desc;
    }
    
    
}
