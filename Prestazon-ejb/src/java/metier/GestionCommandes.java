/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import controllers.CommandeFacadeLocal;
import controllers.CompteFacadeLocal;
import controllers.PasserCommandeFacadeLocal;
import entities.Commande;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionCommandes implements GestionCommandesLocal {

    @EJB
    private CompteFacadeLocal compteFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private PasserCommandeFacadeLocal passerCommandeFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @Override
    public void creerCommande(long IdCommande, HashMap<Long, Long> listeProduits, long IdClient, long Nocompte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changerEtatCommande(long IdCommande, String etat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Long, Commande> ListeCommandes(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEtatCommande(long IdCommande) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
