/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.tpjeeshared.Position;
import javax.ejb.Remote;

/**
 *
 * @author remil
 */
@Remote
public interface GestionClientFinalRemote {
    void virement(Long idCli, Long idCli2, double solde);
    Position consulter(Long idCompte);
    Long ajouterCompte(Long id,double montant);
    Long ajouterClient(String prenom, String nom);
}
