/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.session;

import com.tienda.entidades.Cargo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author erick
 */
@Stateless
public class CargoFacade extends AbstractFacade<Cargo> implements CargoFacadeLocal {

    @PersistenceContext(unitName = "TIENDAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargoFacade() {
        super(Cargo.class);
    }
    
}
