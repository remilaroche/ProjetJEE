/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.entities.Compte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author remil
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> implements CompteFacadeLocal {
    @PersistenceContext(unitName = "com.mycompany_TPJEE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade() {
        super(Compte.class);
    }
    
    public void crediter(Compte c, double solde){
        c.setSolde(solde+ c.getSolde());
    }
    
    public void debiter(Compte c, double solde ){
        c.setSolde(c.getSolde()-solde);
    }
    
    public Compte creerCompte(Compte c){
        this.create(c);
        this.em.flush();
        return c;
    }
}
