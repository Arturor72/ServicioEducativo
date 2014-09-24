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
public class Especialidad {

    private Integer esp_id;
    private String esp_cod;
    private String esp_nom;
    
    public Integer getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(Integer esp_id) {
        this.esp_id = esp_id;
    }

    public String getEsp_cod() {
        return esp_cod;
    }

    public void setEsp_cod(String esp_cod) {
        this.esp_cod = esp_cod;
    }

    public String getEsp_nom() {
        return esp_nom;
    }

    public void setEsp_nom(String esp_nom) {
        this.esp_nom = esp_nom;
    }

}
