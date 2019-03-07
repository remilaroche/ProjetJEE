/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Client;
import com.mycompany.entities.Compte;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author remil
 */
@Local
public interface GestionClientLocal {
    Collection<Compte> getComptes(Long id);
    Client creerClient(String prenom, String nom);
}

