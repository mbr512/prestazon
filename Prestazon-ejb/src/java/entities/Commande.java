/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lemec
 */
@Entity
@Table(name = "commande", catalog = "prestazon", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findById", query = "SELECT c FROM Commande c WHERE c.commandePK.id = :id")
    , @NamedQuery(name = "Commande.findByDateLiv", query = "SELECT c FROM Commande c WHERE c.dateLiv = :dateLiv")
    , @NamedQuery(name = "Commande.findByDateFact", query = "SELECT c FROM Commande c WHERE c.dateFact = :dateFact")
    , @NamedQuery(name = "Commande.findByEtat", query = "SELECT c FROM Commande c WHERE c.etat = :etat")
    , @NamedQuery(name = "Commande.findByClientid", query = "SELECT c FROM Commande c WHERE c.commandePK.clientid = :clientid")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandePK commandePK;
    @Column(name = "dateLiv")
    @Temporal(TemporalType.DATE)
    private Date dateLiv;
    @Column(name = "dateFact")
    @Temporal(TemporalType.DATE)
    private Date dateFact;
    @Size(max = 45)
    @Column(name = "etat")
    private String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<Passercommande> passercommandeCollection;
    @JoinColumn(name = "Client_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;

    public Commande() {
    }

    public Commande(CommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public Commande(int id, int clientid) {
        this.commandePK = new CommandePK(id, clientid);
    }

    public CommandePK getCommandePK() {
        return commandePK;
    }

    public void setCommandePK(CommandePK commandePK) {
        this.commandePK = commandePK;
    }

    public Date getDateLiv() {
        return dateLiv;
    }

    public void setDateLiv(Date dateLiv) {
        this.dateLiv = dateLiv;
    }

    public Date getDateFact() {
        return dateFact;
    }

    public void setDateFact(Date dateFact) {
        this.dateFact = dateFact;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public Collection<Passercommande> getPassercommandeCollection() {
        return passercommandeCollection;
    }

    public void setPassercommandeCollection(Collection<Passercommande> passercommandeCollection) {
        this.passercommandeCollection = passercommandeCollection;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandePK != null ? commandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.commandePK == null && other.commandePK != null) || (this.commandePK != null && !this.commandePK.equals(other.commandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ commandePK=" + commandePK + " ]";
    }
    
}
