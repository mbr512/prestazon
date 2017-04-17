/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface ServiceComptableLocal {
    public void lancerFacturation(long IdCommande,long NoCompte);
}
