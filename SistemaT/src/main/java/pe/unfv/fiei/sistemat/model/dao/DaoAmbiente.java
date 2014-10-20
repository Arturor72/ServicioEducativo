/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unfv.fiei.sistemat.model.dao;

import pe.unfv.fiei.sistemat.model.dto.Ambiente;

/**
 *
 * @author Arturo
 */
public interface DaoAmbiente {

    public Ambiente getAmbiente(Integer amb_id);
}
