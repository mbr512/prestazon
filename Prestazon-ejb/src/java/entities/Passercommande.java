/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lemec
 */
@Entity
@Table(name = "passercommande", catalog = "prestazon", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passercommande.findAll", query = "SELECT p FROM Passercommande p")
    , @NamedQuery(name = "Passercommande.findById", query = "SELECT p FROM Passercommande p WHERE p.id = :id")
    , @NamedQuery(name = "Passercommande.findByQte", query = "SELECT p FROM Passercommande p WHERE p.qte = :qte")})
public class Passercommande implements Serializable {

    @JoinColumn(name = "Commande_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Commande commandeid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "qte")
    private Integer qte;
    @JoinColumns({
        @JoinColumn(name = "Commande_id", referencedColumnName = "id")
        , @JoinColumn(name = "Commande_Client_id", referencedColumnName = "Client_id")})
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "Produit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit produitid;

    public Passercommande() {
    }

    public Passercommande(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduitid() {
        return produitid;
    }

    public void setProduitid(Produit produitid) {
        this.produitid = produitid;
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
        if (!(object instanceof Passercommande)) {
            return false;
        }
        Passercommande other = (Passercommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Passercommande[ id=" + id + " ]";
    }

    public Commande getCommandeid() {
        return commandeid;
    }

    public void setCommandeid(Commande commandeid) {
        this.commandeid = commandeid;
    }
    
}
