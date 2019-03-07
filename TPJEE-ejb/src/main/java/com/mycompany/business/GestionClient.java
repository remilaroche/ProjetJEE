/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Client;
import com.mycompany.entities.Compte;
import com.mycompany.repositories.ClientFacadeLocal;
import com.mycompany.repositories.CompteFacadeLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author remil
 */
@Stateless
public class GestionClient implements GestionClientLocal {
    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private GestionCompteLocal gestionCompte;
    @EJB
    private CompteFacadeLocal compteFacade;

    @Override
    public Collection<Compte> getComptes(Long id){
        return clientFacade.find(id).LesComptes;
    }

    @Override
    public Client creerClient(String prenom, String nom) {
        Client c = new Client();
        c.setNom(nom);
        c.setPrenom(prenom);
        return clientFacade.creerClient(c);
    }
}
