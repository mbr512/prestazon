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

     
    @Override
    public Client creerClient(HttpServletRequest request) {
         
         //récupération des données saisies
         String nom = getData(request, CHAMP_NOM);
         String prenom = getData(request, CHAMP_PRENOM);
         String login = getData(request, CHAMP_LOGIN);
         String tel = getData(request, CHAMP_TEL);
         String mail = getData(request, CHAMP_EMAIL);
         String adr = getData(request, CHAMP_ADR);
         String mdp = getData(request, CHAMP_PASS);
         
         //création d'un nouveau client
         Client newClient = new Client();
         
         //validation des informations saisies
         
         //validation du nom 
         try{
              
         }
         catch(Exception e){
             
         }
         
         return null;
    }

    @Override
    public String getData(HttpServletRequest request , String champ) {     
        String valeur = request.getParameter( champ );
            if ( valeur == null || valeur.trim().length() == 0 ) {
                return null;
            } 
            else {
                return valeur.trim();
            }
    }
    
    @Override
    public void addError(String champ, String message) {
           erreurs.put(champ, champ);
    }
    
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
    public void validationNomPrenomAdr(String nom) throws Exception {
        if ( nom != null && nom.length() < 8 ) 
        {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }   

    @Override
    //vérf
    public void validationLogin(String nom) throws Exception {
       if ( nom != null && nom.length() < 3 ) 
        {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }     
    }

    @Override
    //vérifie si le téléphone saisi est bien un entier composé de 10 chiffres
    public void validationTel(String tel) throws Exception {
      if ( isNumeric(tel)== false && tel.length() < 11 ) 
        {
            throw new Exception( "Le format du téléphone n'est pas respecté" );
        }
        
    }

    @Override
    //vérifie que le mot de passe et la confirmation sont renseigné
    //vérifie que mdp et confirmation sont identique
    //vérifie que la longueur du mot de passe est sup à 3
    public void validationMdp(String mdp, String confirmation ) throws Exception {
       // 
       if ( mdp != null && confirmation != null ) {
            if ( !mdp.equals( confirmation ) ) {
                    throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
             } else if ( mdp.length() < 3 ) {
                    throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
                    }
               } else {
                    throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
                 }          
    }
    
    @Override
    //vérifie que le mail a bien le format d'un adresse mail
    public void validationMail(String email) throws Exception {
      if ( email != null ) {
            if ( !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                    throw new Exception( "Merci de saisir une adresse mail valide." );
                     }
      } 
      else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }
   
   public static boolean isNumeric(String str){  
    try{  
        double d = Double.parseDouble(str);  
     }  
    catch(NumberFormatException nfe){  
        return false;  
     }  
    return true;  
   }
   
}   
