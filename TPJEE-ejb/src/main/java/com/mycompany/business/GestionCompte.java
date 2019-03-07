/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Client;
import com.mycompany.entities.Compte;
import com.mycompany.entities.Operation;
import com.mycompany.repositories.ClientFacadeLocal;
import com.mycompany.repositories.CompteFacadeLocal;
import com.mycompany.tpjeeshared.Position;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author remil
 */
@Stateless
public class GestionCompte implements GestionCompteLocal {
    @EJB
    private ClientFacadeLocal clientFacade;
    @EJB
    private CompteFacadeLocal compteFacade;

    @Override
   public void crediter(Long id, double montant){
       Compte compte = compteFacade.find(id);
       compteFacade.crediter(compte, montant);
       compte.operations.add(new Operation("Créditer", compte, montant, new Date()));
       
   }
   
    @Override
   public void debiter(Long id, double montant){
       Compte compte = compteFacade.find(id);
       compteFacade.debiter(compte, montant);
       compte.operations.add(new Operation("Débiter", compte, montant, new Date()));
   }
   
    @Override
   public void virement(Long id,Long id2, double montant){
       Compte compte = compteFacade.find(id);
       Compte compte2 = compteFacade.find(id2);
       compteFacade.debiter(compte, montant);
       compte.operations.add(new Operation("Débiter", compte, montant, new Date()));
       compteFacade.crediter(compte2, montant);
       compte.operations.add(new Operation("Créditer", compte2, montant, new Date()));
   }
   
   public Position consulterCompte(Long id){
       Compte compte = compteFacade.find(id);
       return new Position(id, compte.getSolde(), new Date());
   }
   
   @Override
   public void fermeture(Long id){
       Compte compte = compteFacade.find(id);
       compte.client.LesComptes.remove(compte);
       compteFacade.remove(compte);
   }
   
    @Override
   public Compte ouverture(Long idcli, double somme){
       Client cli = this.clientFacade.find(idcli);
       Compte compte = new Compte();
       compte.setSolde(somme);
       compte.setClient(cli);
       compteFacade.create(compte);
       return compte;
   }
}
