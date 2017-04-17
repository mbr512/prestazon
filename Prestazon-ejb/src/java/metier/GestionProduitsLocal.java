/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface GestionProduitsLocal {
    public List<Produit> afficherVitrine();
}
