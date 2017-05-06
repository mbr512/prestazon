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
public class GestionStocks implements GestionStocksLocal {

    @EJB
    private ProduitFacadeLocal produitFacade;

    @Override
    public List<Produit> verifierStock(HashMap<Long, Integer> listeProduitsQuantites) {
        List<Produit> resultat = produitFacade.findAll();
        int i;
        for (i=resultat.size()-1;i>=0;i--){
            if (listeProduitsQuantites.containsKey(resultat.get(i).getId())){
                if (resultat.get(i).getQuantiteRelle()>=listeProduitsQuantites.get(resultat.get(i).getId()))
                    resultat.remove(i);
            }else{
                resultat.remove(i);
            }
            
        }
        return resultat;
        
    }

    @Override
    public void incrementerStock(HashMap<Produit, Integer> listeProduitsQuantites) {
      List<Produit> listeProduits = produitFacade.findAll();
        int i,qte;
        Produit ProduitActuel;
        for (i=listeProduits.size()-1;i>=0;i--){
            ProduitActuel=listeProduits.get(i);
            if (listeProduitsQuantites.containsKey(ProduitActuel)){
                qte=listeProduitsQuantites.get(ProduitActuel);
                if (qte>0){
                    ProduitActuel.setQuantiteRelle(ProduitActuel.getQuantiteRelle()+qte);
                    ProduitActuel.setQuantiteTheorique(ProduitActuel.getQuantiteTheorique()+qte);
                    produitFacade.edit(ProduitActuel);
                }
            }
    }
    }

    @Override
    public void decrementerStock(Produit p, int qte) {
       if ((qte>0) && (qte>p.getQuantiteRelle())){
        p.setQuantiteRelle(p.getQuantiteRelle() - qte);
        produitFacade.edit(p);
    }
    }

    @Override
    public void decrementerStockTemp(Produit p, int qte) {
        if ((qte>0) && (qte>p.getQuantiteTheorique())){
        p.setQuantiteTheorique(p.getQuantiteTheorique() - qte);
        produitFacade.edit(p);
    }
    }



   
}
