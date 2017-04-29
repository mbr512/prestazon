/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exception.*;
import controllers.CommandeFacadeLocal;
import controllers.CompteFacadeLocal;
import controllers.PasserCommandeFacadeLocal;
import entities.Compte;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class ServiceComptable implements ServiceComptableLocal {

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @EJB
    private PasserCommandeFacadeLocal passerCommandeFacade;

    @EJB
    private GestionComptesLocal gestionComptes;

    
    
    @Override
    public void lancerFacturation(long IdCommande, long NoCompte) throws  CompteInconnuException, SoldeInsuffisantException{
        Compte cpt = gestionComptes.find(NoCompte);
        float montantCommande=0; // REMPLACER LE MONTANT DE LA COMMANDE ICI
       if (cpt != null){
           if (montantCommande > gestionComptes.positionCompte(NoCompte)){
               throw new SoldeInsuffisantException();
           }else
           {
               try {
                   gestionComptes.debiter(NoCompte, montantCommande);
               } catch (Exception ex) {
               }
           }
       }else throw new CompteInconnuException();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
