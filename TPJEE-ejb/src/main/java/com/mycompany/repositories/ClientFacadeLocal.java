/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repositories;

import com.mycompany.entities.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author remil
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);
    
    Client creerClient(Client c);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
}
