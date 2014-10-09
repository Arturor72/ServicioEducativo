/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.model.dto;

/**
 *
 * @author Arturo
 */
public class Ambiente {
    private Integer amd_id;
    private Integer sed_id;
    private String amb_den;
    private Integer tip_amb_id;

    public Integer getAmd_id() {
        return amd_id;
    }

    public void setAmd_id(Integer amd_id) {
        this.amd_id = amd_id;
    }

    public Integer getSed_id() {
        return sed_id;
    }

    public void setSed_id(Integer sed_id) {
        this.sed_id = sed_id;
    }

    public String getAmb_den() {
        return amb_den;
    }

    public void setAmb_den(String amb_den) {
        this.amb_den = amb_den;
    }

    public Integer getTip_amb_id() {
        return tip_amb_id;
    }

    public void setTip_amb_id(Integer tip_amb_id) {
        this.tip_amb_id = tip_amb_id;
    }
    
    
}
