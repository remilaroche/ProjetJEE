/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.services.GestionClientFinalRemote;
import com.mycompany.tpjeeshared.Position;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author remil
 */
@WebService(serviceName = "WebServicesClientFinaux")
@Stateless()
public class WebServicesClientFinaux {
    @EJB
    private GestionClientFinalRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "virement")
    public void virement(@WebParam(name = "idCli") String idCli, @WebParam(name = "idCli2") String idCli2, @WebParam(name = "solde") String solde) {
        ejbRef.virement(Long.parseLong(idCli), Long.parseLong(idCli2), Long.parseLong(solde));
    }

    @WebMethod(operationName = "consulter")
    public Position consulter(@WebParam(name = "idCompte") String idCompte) {
        return ejbRef.consulter(Long.parseLong(idCompte));
    }
    
    @WebMethod(operationName = "ajouterCompte")
    public Long ajouterCompte(@WebParam(name = "idCli") String idCli, @WebParam(name = "montant") double montant) {
        return ejbRef.ajouterCompte(Long.parseLong(idCli), montant);
    }
    
    @WebMethod(operationName = "ajouterClient")
    public Long ajouterClient(@WebParam(name = "prenom") String prenom, @WebParam(name = "nom") String nom) {
        return ejbRef.ajouterClient(prenom, nom);
    }
}
