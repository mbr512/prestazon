/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import entities.Client;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lemec
 */
@Stateless
public class ServiceCommercial implements ServiceCommercialLocal {

    @EJB
    private ClientFacadeLocal clientFacade;
    
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_PRENOM = "prenom";
    private static final String CHAMP_LOGIN = "login";
    private static final String CHAMP_TEL = "tel";
    private static final String CHAMP_ADR = "adr";
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
        
   private String resultat;
   private Map<String, String> erreurs = new HashMap<String,String>();

    
   
    
   
    public String getResultat() {
        return resultat;
    }
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    @Override
    public boolean verificationLogin(String Login) {
        return true;
    }

    @Override
    public Client creerClient(HttpServletRequest request) {
        return null;
    }

    @Override
    public String getData(HttpServletRequest request) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addError(String champ, String message) {
           erreurs.put(champ, champ);
    }

   
}
