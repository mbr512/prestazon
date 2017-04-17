/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Commande;
import entities.Produit;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface GestionCommandesLocal {
    public void creerCommande(long IdCommande, HashMap<Long,Long> listeProduits,long IdClient, long Nocompte);
    public void changerEtatCommande(long IdCommande, String etat);
    public HashMap<Long,Commande> ListeCommandes(String login);
    public String getEtatCommande(long IdCommande);
}
