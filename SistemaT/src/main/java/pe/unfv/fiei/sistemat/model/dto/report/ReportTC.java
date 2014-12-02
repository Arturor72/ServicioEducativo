/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.model.dto.report;

import pe.unfv.fiei.sistemat.model.dto.Curso;
import pe.unfv.fiei.sistemat.model.dto.Usuario;

/**
 *
 * @author Arturo
 */
public class ReportTC {
    private Usuario user_tutor;
    private Curso curso;

    public Usuario getUser_tutor() {
        return user_tutor;
    }

    public void setUser_tutor(Usuario user_tutor) {
        this.user_tutor = user_tutor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
