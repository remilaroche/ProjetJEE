/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpjeedab;

import com.mycompany.services.GestionCollaborateurRemote;
import com.mycompany.services.GestionDABRemote;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author remil
 */
public class Main {

    public void Main(){
        try{
            //Contexte de nommage pour l'accès à l'annuaire JNDI du serveur Glassfish
            Properties jNDIProperties = new Properties();
            jNDIProperties.setProperty("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
            jNDIProperties.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            jNDIProperties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext namingContext = new InitialContext(jNDIProperties);
            //Récupération d'un accès à l'EJB distant
            String uri = "lien_distant_ejb";
            GestionDABRemote DABRemoteSvc = (GestionDABRemote) namingContext.lookup(uri);
        }
        catch(NamingException ex){}
    }
}
