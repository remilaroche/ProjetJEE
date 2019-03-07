/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.entities.Compte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author remil
 */
@Local
public interface CompteFacadeLocal {

    void create(Compte compte);

    void edit(Compte compte);

    void remove(Compte compte);
    
    void crediter(Compte c, double solde);
    
    void debiter(Compte c, double solde);

    Compte find(Object id);

    List<Compte> findAll();

    List<Compte> findRange(int[] range);

    int count();
    
}
