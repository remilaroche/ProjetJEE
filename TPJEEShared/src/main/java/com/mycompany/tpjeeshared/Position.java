/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpjeeshared;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author remil
 */
public class Position implements Serializable{
    private Long numCompte;
    private double solde;
    private Date date;

    public Position(Long numCompte, double solde, Date date) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.date = date;
    }

    public Long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(Long numCompte) {
        this.numCompte = numCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
