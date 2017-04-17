/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import exception.ClientInconnuException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tebibou
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
    long chercherClient(String nom, String prenom) throws ClientInconnuException;
    
    Client resultatAuthentification (String login, String mdp);
            
    List<String> listeLogin ();
}
