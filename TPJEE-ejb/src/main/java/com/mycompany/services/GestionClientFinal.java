        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.business.GestionClientLocal;
import com.mycompany.business.GestionCompteLocal;
import com.mycompany.entities.Client;
import com.mycompany.entities.Compte;
import com.mycompany.tpjeeshared.Position;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author remil
 */
@Stateless
public class GestionClientFinal implements GestionClientFinalRemote {

    @EJB
    private GestionClientLocal gestionClient;
    @EJB
    private GestionCompteLocal gestionCompte;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void virement(Long idCli, Long idCli2, double solde){
        gestionCompte.virement(idCli, idCli2, solde);
    }
    
    public Position consulter(Long idCompte){
        return gestionCompte.consulterCompte(idCompte);
    }
    
    public Long ajouterCompte(Long id,double montant){
        Compte c = gestionCompte.ouverture(id, montant);
        return c.getId();
    }
    public Long ajouterClient(String prenom, String nom){
        Client c = gestionClient.creerClient(prenom, nom);
        return c.getId();
    }
}
