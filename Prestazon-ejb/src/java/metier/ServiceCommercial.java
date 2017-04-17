/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class ServiceCommercial implements ServiceCommercialLocal {

    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    public void creerClient(String login, String mdp, String nom, String prenom, String telephone, String mail, String adresse) {
            
    }

    @Override
    public boolean verificationLogin(String Login) {
        return true;
    }

   
}
