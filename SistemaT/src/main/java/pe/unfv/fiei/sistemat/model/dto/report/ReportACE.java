/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dto.report;

import pe.unfv.fiei.sistemat.model.dto.Curso;

/**
 *
 * @author Arturo
 */
public class ReportACE {

    private Curso curso;
    private Integer total;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
