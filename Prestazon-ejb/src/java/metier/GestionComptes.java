/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CompteFacadeLocal;
import entities.Compte;
import entities.Operation;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionComptes implements GestionComptesLocal {

    @EJB
    private CompteFacadeLocal compteFacade;

    @Override
    public Compte find(long NoCompte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float positionCompte(long NoCompte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operation debiter(long NoCompte, float montantCommande) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operation crediter(long NoCompte, float montantCredite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
