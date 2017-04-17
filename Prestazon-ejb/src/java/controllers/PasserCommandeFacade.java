/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.PasserCommande;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tebibou
 */
@Stateless
public class PasserCommandeFacade extends AbstractFacade<PasserCommande> implements PasserCommandeFacadeLocal {

    @PersistenceContext(unitName = "Prestazon-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasserCommandeFacade() {
        super(PasserCommande.class);
    }
    
}
