/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Compte;
import entities.Operation;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface GestionComptesLocal {
    public Compte find(long NoCompte);
    public float positionCompte(long NoCompte);
    public Operation debiter(long NoCompte, float montantCommande) throws Exception;
    public Operation crediter(long NoCompte, float montantCredite) throws Exception;
     public Vector<Operation> GetOperationFromCompte(long Id);
}
