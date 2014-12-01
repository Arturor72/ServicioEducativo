/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.model.dto.report;

import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class ReportTHM {
    private Usuario usr_tutor;
    private Integer horas;
    private Integer mes;

    public Usuario getUsr_tutor() {
        return usr_tutor;
    }

    public void setUsr_tutor(Usuario usr_tutor) {
        this.usr_tutor = usr_tutor;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }
    
            
}
