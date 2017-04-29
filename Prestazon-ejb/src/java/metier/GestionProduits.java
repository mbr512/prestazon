/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ProduitFacadeLocal;
import entities.Produit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionProduits implements GestionProduitsLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;
    
    @Override
     public List<Produit> afficherVitrine() {
       ArrayList<Produit> listeProduitsAffiches  = new  ArrayList<Produit>();
       List<Produit> listeTousLesProduits = afficherTousLesProduits();
       int i;
       Produit ProduitActuel;
       for( i=0;i < listeTousLesProduits.size() -1;i++){
           ProduitActuel = listeTousLesProduits.get(i);
           if (ProduitActuel.isVisible()){
               listeProduitsAffiches.add(ProduitActuel);
           }
      
       }
        return listeProduitsAffiches;
    }
   
     

    @Override
    public List<Produit> afficherTousLesProduits() {
        return produitFacade.findAll();
    }

    @Override
    public Produit find(long id) {
        return produitFacade.find(id);
    }

    @Override
    public void ActiverVisibilite(HashMap<Long, Boolean> listeIdProduits) {
        List<Produit> listeTousLesProduits = afficherTousLesProduits();
        Produit ProduitActuel;
        int i;
        for (i=0;i<listeTousLesProduits.size() - 1;i++){
            ProduitActuel = listeTousLesProduits.get(i);
            if (listeIdProduits.containsKey(ProduitActuel.getId())){
                    ProduitActuel.setVisible(listeIdProduits.get(ProduitActuel.getId()));
                    produitFacade.edit(ProduitActuel);
            }
        }
    }
}
