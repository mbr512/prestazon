/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CommandeFacadeLocal;
import controllers.CompteFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class ServiceComptable implements ServiceComptableLocal {

    @EJB
    private GestionComptesLocal gestionComptes;

    
    
    @Override
    public void lancerFacturation(long IdCommande, long NoCompte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
