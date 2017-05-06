/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import controllers.CommandeFacadeLocal;
import controllers.CompteFacadeLocal;
import controllers.PasserCommandeFacadeLocal;
import entities.Commande;
import entities.Passercommande;
import entities.Produit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionCommandes implements GestionCommandesLocal {

    @EJB
    private CompteFacadeLocal compteFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private PasserCommandeFacadeLocal passerCommandeFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;
    
    @EJB
    private GestionProduitsLocal gestionProduitsFacade;
    
    @EJB
    private GestionClients gestionClientsFacade;

    @Override
    public void creerCommande(long IdCommande, HashMap<Long, Long> listeProduits, long IdClient, long Nocompte) {
        //Création commande
        Commande c = new Commande();
        c.setClient(gestionClientsFacade.find(IdClient));
        List<Produit> listeTousLesProduits = gestionProduitsFacade.afficherTousLesProduits();
        ArrayList<Passercommande> ListeQuantites = new ArrayList<Passercommande>();
        Passercommande pc;
        for (Produit p : listeTousLesProduits){
            if (listeProduits.containsKey(p.getId().longValue())){
             pc=new Passercommande();
             pc.setCommande(c);
             pc.setQte(listeProduits.get(p.getId().longValue()).intValue());
             pc.setProduitid(p);
             ListeQuantites.add(pc);
            }
        c.setPassercommandeCollection(ListeQuantites);
        }        
        commandeFacade.create(c);
        
    }

    @Override
    public void changerEtatCommande(long IdCommande, String etat) {
       Commande c = find(IdCommande);
      if (c !=null){ c.setEtat(etat);
       commandeFacade.edit(c);}
    }

    @Override
    public HashMap<Long, Commande> ListeCommandes(String login) {
        HashMap<Long, Commande> resultat = new  HashMap<Long, Commande>();
        List<Commande> commandes = commandeFacade.findAll();
        int i;
        for (i=0;i<commandes.size();i++){
            if (commandes.get(i).getClient().getLogin().equals(login)){
                resultat.put(commandes.get(i).getId().longValue(), commandes.get(i));
            }
        }
        return resultat;
    }

    @Override
    public String getEtatCommande(long IdCommande) {
        Commande c = find(IdCommande);
        if (c !=null){
            return c.getEtat();
        }
        else
            return null;
    }

    @Override
    public float getMontantTotal(Long IdCommande) {
       float montant = 0;
        Commande c = find(IdCommande);
        Iterator<Passercommande> listeQuantitesCommandes = c.getPassercommandeCollection().iterator();
        Passercommande ps;
        Produit p;
        while (listeQuantitesCommandes.hasNext()){
            ps = listeQuantitesCommandes.next();
            p = gestionProduitsFacade.find(ps.getProduitid().getId());
             montant+=(ps.getQte().floatValue() * (p.getPrixHT().floatValue() * p.getTaxe().floatValue()/100));
        }
        
        return montant;
    }

    @Override
    public Commande find(long IdCommande) {
     Commande c = null;
     List<Commande> listeCommandes = commandeFacade.findAll();
     int i=0;
     while ((i<listeCommandes.size()) && (c == null)){
         if ((listeCommandes.get(i).getId()) == IdCommande ){
             c=listeCommandes.get(i);
         };
         i++;
     };
     return c;
    }
    
    
}
