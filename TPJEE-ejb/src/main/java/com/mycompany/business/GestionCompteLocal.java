/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Client;
import com.mycompany.entities.Compte;
import com.mycompany.tpjeeshared.Position;
import javax.ejb.Local;

/**
 *
 * @author remil
 */
@Local
public interface GestionCompteLocal {
 
    void crediter(Long id, double solde);
    void debiter(Long id, double solde);
    void virement(Long id,Long id2, double solde);
    void fermeture(Long id);
    Compte ouverture(Long idcli, double somme);
    Position consulterCompte(Long id);
    
}
