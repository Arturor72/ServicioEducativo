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
public class TipoServicio {

    private Integer tip_ser_id;
    private String tip_ser_den;
    private Integer tip_ser_durac;

    public Integer getTip_ser_id() {
        return tip_ser_id;
    }

    public void setTip_ser_id(Integer tip_ser_id) {
        this.tip_ser_id = tip_ser_id;
    }

    public String getTip_ser_den() {
        return tip_ser_den;
    }

    public void setTip_ser_den(String tip_ser_den) {
        this.tip_ser_den = tip_ser_den;
    }

    public Integer getTip_ser_durac() {
        return tip_ser_durac;
    }

    public void setTip_ser_durac(Integer tip_ser_durac) {
        this.tip_ser_durac = tip_ser_durac;
    }
    
}
