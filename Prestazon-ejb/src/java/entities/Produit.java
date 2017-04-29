/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lemec
 */
@Entity
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String libelle;
    private String designation;
    private double prixHT;
    private double taxe;
    private int quantiteTheorique;
    private int quantiteReelle;
    private boolean visible;

    public int getQuantiteTheorique() {
        return quantiteTheorique;
    }

    public void setQuantiteTheorique(int quantiteTheorique) {
        this.quantiteTheorique = quantiteTheorique;
    }

    public int getQuantiteReelle() {
        return quantiteReelle;
    }

    public void setQuantiteReelle(int quantiteReelle) {
        this.quantiteReelle = quantiteReelle;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public double getTaxe() {
        return taxe;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    
    @Override
    public String toString() {
        return "entities.Produit[ id=" + id + " ]";
    }
    
}
