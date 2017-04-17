/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Client;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author lemec
 */
@Local
public interface ServiceCommercialLocal {
    
   //création de client
   public Client creerClient(HttpServletRequest request);
    
   //vérife si le login choisi à l'inscrption existe déjà
   public boolean verificationLogin (String Login);
    
   
        //méthodes utilitaires 
        public String getData (HttpServletRequest request, String champ);

        public void addError (String champ, String message);

        public void validationNomPrenomAdr (String nom) throws Exception;

        public void validationLogin (String login) throws Exception;

        public void validationTel (String tel) throws Exception;

        public void validationMdp (String mdp, String confirmation) throws Exception;

        public void validationMail (String mail) throws Exception;


   

   
}
