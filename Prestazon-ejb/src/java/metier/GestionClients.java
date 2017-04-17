/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import entities.Client;
import exception.ClientExistantException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionClients implements GestionClientsLocal {

    @EJB
    private ClientFacadeLocal clientFacade;



    @Override
    //vérifie si le nomUtilisateur et motdepasse sont corrects 
    public boolean verificationLoginMdp(String nomUtilisateur, String motDePassse) {
        Client c = clientFacade.resultatAuthentification(nomUtilisateur, motDePassse);
        //client trouvé et retourne TRUE
        if (c!=null){
            return true;
        }
        return false;
    }

 }
