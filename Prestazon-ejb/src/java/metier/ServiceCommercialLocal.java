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
public interface ServiceCommercialLocal {
    
    public void creerClient(String login, String mdp, String nom, String prenom, String telephone, String mail, String adresse);
    //vérife si le login choisi à l'inscrption existe déjà
    public boolean verificationLogin (String Login);
    

}
