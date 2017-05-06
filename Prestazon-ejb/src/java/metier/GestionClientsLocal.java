/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.Client;
import exception.ClientExistantException;
import javax.ejb.Local;

/**
 *
 * @author lemec
 */
@Local
public interface GestionClientsLocal {
    
    //vérifie l'adéquation login et mdp
    public boolean verificationLoginMdp(String nomUtilisateur, String motDePassse);
    public Client find(long id);
    
}
