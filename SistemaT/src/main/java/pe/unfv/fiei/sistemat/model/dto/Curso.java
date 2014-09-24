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
public class Curso {

    private Integer cur_id;
    private String cur_cod;
    private String cur_nom;
    private Boolean cur_est;
    private Integer esp_id;

    public Integer getEsp_id() {
        return esp_id;
    }

    public String getCur_nom() {
        return cur_nom;
    }

    public void setCur_nom(String cur_nom) {
        this.cur_nom = cur_nom;
    }

    public void setEsp_id(Integer esp_id) {
        this.esp_id = esp_id;
    }

    public Integer getCur_id() {
        return cur_id;
    }

    public void setCur_id(Integer cur_id) {
        this.cur_id = cur_id;
    }

    public String getCur_cod() {
        return cur_cod;
    }

    public void setCur_cod(String cur_cod) {
        this.cur_cod = cur_cod;
    }

    public Boolean isCur_est() {
        return cur_est;
    }

    public void setCur_est(Boolean cur_est) {
        this.cur_est = cur_est;
    }

}
