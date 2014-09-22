/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dto;

import java.io.Serializable;

/**
 *
 * @author Arturo
 */
public class Usuario  implements Serializable{

    private Integer usr_id;
    private Integer tip_usr_id;
    private Integer esp_id;
    private String usr_cod;
    private String usr_nom;
    private String usr_apat;
    private String usr_amat;
    private String usr_dni;
    private Integer usr_gen;
    private String usr_cel;
    private String usr_mail;
    private String usr_user;
    private String usr_pass;
    private Integer usr_est;

    public Integer getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Integer usr_id) {
        this.usr_id = usr_id;
    }

    public Integer getTip_usr_id() {
        return tip_usr_id;
    }

    public void setTip_usr_id(Integer tip_usr_id) {
        this.tip_usr_id = tip_usr_id;
    }

    public Integer getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(Integer esp_id) {
        this.esp_id = esp_id;
    }

    public String getUsr_cod() {
        return usr_cod;
    }

    public void setUsr_cod(String usr_cod) {
        this.usr_cod = usr_cod;
    }

    public String getUsr_nom() {
        return usr_nom;
    }

    public void setUsr_nom(String usr_nom) {
        this.usr_nom = usr_nom;
    }

    public String getUsr_apat() {
        return usr_apat;
    }

    public void setUsr_apat(String usr_apat) {
        this.usr_apat = usr_apat;
    }

    public String getUsr_amat() {
        return usr_amat;
    }

    public void setUsr_amat(String usr_amat) {
        this.usr_amat = usr_amat;
    }

    public String getUsr_dni() {
        return usr_dni;
    }

    public void setUsr_dni(String usr_dni) {
        this.usr_dni = usr_dni;
    }

    public Integer getUsr_gen() {
        return usr_gen;
    }

    public void setUsr_gen(Integer usr_gen) {
        this.usr_gen = usr_gen;
    }

    public String getUsr_cel() {
        return usr_cel;
    }

    public void setUsr_cel(String usr_cel) {
        this.usr_cel = usr_cel;
    }

    public String getUsr_mail() {
        return usr_mail;
    }

    public void setUsr_mail(String usr_mail) {
        this.usr_mail = usr_mail;
    }

    public String getUsr_user() {
        return usr_user;
    }

    public void setUsr_user(String usr_user) {
        this.usr_user = usr_user;
    }

    public String getUsr_pass() {
        return usr_pass;
    }

    public void setUsr_pass(String usr_pass) {
        this.usr_pass = usr_pass;
    }

    public Integer getUsr_est() {
        return usr_est;
    }

    public void setUsr_est(Integer usr_est) {
        this.usr_est = usr_est;
    }

    
}
