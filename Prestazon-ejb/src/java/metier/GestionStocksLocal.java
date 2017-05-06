/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Produit;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface GestionStocksLocal {
    
    public List<Produit> verifierStock(HashMap<Long,Integer> listeProduitsQuantites);
    public void incrementerStock(HashMap<Produit,Integer> listeProduitsQuantites);
    public void decrementerStock(Produit p,int qte);
    public void decrementerStockTemp(Produit p, int qte);
}
