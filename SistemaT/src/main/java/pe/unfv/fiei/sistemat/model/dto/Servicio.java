/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dto;

import java.sql.Date;

/**
 *
 * @author Arturo
 */
public class Servicio {

    private Integer ser_edu_id;
    private Date ser_edu_fec;
    private String ser_edu_hin;
    private Curso cur_id;
    private Ambiente amb_id;
    private Sede sed_id;
    private TipoServicio tip_serv_id;
    private Usuario usr_adm_id;
    private Usuario usr_tut_id;
    private Integer ser_edu_asist;
    private String ser_edu_desc;
    private Integer ser_edu_est;

    public Integer getSer_edu_id() {
        return ser_edu_id;
    }

    public void setSer_edu_id(Integer ser_edu_id) {
        this.ser_edu_id = ser_edu_id;
    }

    public Date getSer_edu_fec() {
        return ser_edu_fec;
    }

    public void setSer_edu_fec(Date ser_edu_fec) {
        this.ser_edu_fec = ser_edu_fec;
    }

    public String getSer_edu_hin() {
        return ser_edu_hin;
    }

    public void setSer_edu_hin(String ser_edu_hin) {
        this.ser_edu_hin = ser_edu_hin;
    }

    public Curso getCur_id() {
        return cur_id;
    }

    public void setCur_id(Curso cur_id) {
        this.cur_id = cur_id;
    }

    public Ambiente getAmb_id() {
        return amb_id;
    }

    public void setAmb_id(Ambiente amb_id) {
        this.amb_id = amb_id;
    }

    public Sede getSed_id() {
        return sed_id;
    }

    public void setSed_id(Sede sed_id) {
        this.sed_id = sed_id;
    }

    public TipoServicio getTip_serv_id() {
        return tip_serv_id;
    }

    public void setTip_serv_id(TipoServicio tip_serv_id) {
        this.tip_serv_id = tip_serv_id;
    }

    public Usuario getUsr_adm_id() {
        return usr_adm_id;
    }

    public void setUsr_adm_id(Usuario usr_adm_id) {
        this.usr_adm_id = usr_adm_id;
    }

    public Usuario getUsr_tut_id() {
        return usr_tut_id;
    }

    public void setUsr_tut_id(Usuario usr_tut_id) {
        this.usr_tut_id = usr_tut_id;
    }

    public Integer getSer_edu_asist() {
        return ser_edu_asist;
    }

    public void setSer_edu_asist(Integer ser_edu_asist) {
        this.ser_edu_asist = ser_edu_asist;
    }

    public String getSer_edu_desc() {
        return ser_edu_desc;
    }

    public void setSer_edu_desc(String ser_edu_desc) {
        this.ser_edu_desc = ser_edu_desc;
    }

    public Integer getSer_edu_est() {
        return ser_edu_est;
    }

    public void setSer_edu_est(Integer ser_edu_est) {
        this.ser_edu_est = ser_edu_est;
    }

    
}
