/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lemec
 */
@Entity
@Table(name = "produit", catalog = "prestazon", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id")
    , @NamedQuery(name = "Produit.findByLibelle", query = "SELECT p FROM Produit p WHERE p.libelle = :libelle")
    , @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation")
    , @NamedQuery(name = "Produit.findByPrixHT", query = "SELECT p FROM Produit p WHERE p.prixHT = :prixHT")
    , @NamedQuery(name = "Produit.findByTaxe", query = "SELECT p FROM Produit p WHERE p.taxe = :taxe")
    , @NamedQuery(name = "Produit.findByQuantiteTheorique", query = "SELECT p FROM Produit p WHERE p.quantiteTheorique = :quantiteTheorique")
    , @NamedQuery(name = "Produit.findByQuantiteRelle", query = "SELECT p FROM Produit p WHERE p.quantiteRelle = :quantiteRelle")
    , @NamedQuery(name = "Produit.findByVisible", query = "SELECT p FROM Produit p WHERE p.visible = :visible")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 45)
    @Column(name = "designation")
    private String designation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prixHT")
    private BigDecimal prixHT;
    @Column(name = "taxe")
    private BigDecimal taxe;
    @Column(name = "quantiteTheorique")
    private Integer quantiteTheorique;
    @Column(name = "quantiteRelle")
    private Integer quantiteRelle;
    @Column(name = "visible")
    private Short visible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitid")
    private Collection<Passercommande> passercommandeCollection;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(BigDecimal prixHT) {
        this.prixHT = prixHT;
    }

    public BigDecimal getTaxe() {
        return taxe;
    }

    public void setTaxe(BigDecimal taxe) {
        this.taxe = taxe;
    }

    public Integer getQuantiteTheorique() {
        return quantiteTheorique;
    }

    public void setQuantiteTheorique(Integer quantiteTheorique) {
        this.quantiteTheorique = quantiteTheorique;
    }

    public Integer getQuantiteRelle() {
        return quantiteRelle;
    }

    public void setQuantiteRelle(Integer quantiteRelle) {
        this.quantiteRelle = quantiteRelle;
    }

    public Short getVisible() {
        return visible;
    }
    public boolean isVisible(){
        if (visible==1){
            return true;
        }else{
            return false;
        }
    }

    public void setVisible(Short visible) {
        this.visible = visible;
    }
 public void setVisible(boolean visible) {
     if (visible){
             this.visible=1;
             }else{
         this.visible=0;
     }
 }
    @XmlTransient
    public Collection<Passercommande> getPassercommandeCollection() {
        return passercommandeCollection;
    }

    public void setPassercommandeCollection(Collection<Passercommande> passercommandeCollection) {
        this.passercommandeCollection = passercommandeCollection;
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

    @Override
    public String toString() {
        return "entities.Produit[ id=" + id + " ]";
    }
    
}
