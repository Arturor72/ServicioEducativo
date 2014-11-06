/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dto;

/**
 *
 * @author JULIO
 */
public class Asistencia {
    
    private Integer ser_edu_id;
    
    private Integer al_id;
    
    private Integer ast_asist;

    public Asistencia() {
    }

    public Integer getSer_edu_id() {
        return ser_edu_id;
    }

    public void setSer_edu_id(Integer ser_edu_id) {
        this.ser_edu_id = ser_edu_id;
    }

    public Integer getAl_id() {
        return al_id;
    }

    public void setAl_id(Integer al_id) {
        this.al_id = al_id;
    }

    public Integer getAst_asist() {
        return ast_asist;
    }

    public void setAst_asist(Integer ast_asist) {
        this.ast_asist = ast_asist;
    }
    
    
    
}
