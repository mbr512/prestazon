/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import exception.ClientInconnuException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tebibou
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "Prestazon-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public long chercherClient(String nom, String prenom) throws ClientInconnuException {
     try {
            Query q = em.createQuery(
               "select c from Client c where c.nom = :nom and c.prenom = :prenom");
            q.setParameter("nom", nom);
            q.setParameter("prenom", prenom);
            Client c = (Client) q.getSingleResult();
            return c.getId();
        } catch(NoResultException e) {
            throw new exception.ClientInconnuException();
        }
    
    }

    @Override
    public List listeLogin(){
        List listeLogin;
        try {
            Query q = em.createQuery(
               "select login from Client c "); 
            listeLogin = q.getResultList();
            return listeLogin;
        } catch(NoResultException e) {
            listeLogin = null;
            return listeLogin;
        }
    }

    @Override
    //cherche s'il existe un client avec le login et mdp fourni
    //Si client Existe alors il retourne le client  
    //Sinon un client NULL
    public Client resultatAuthentification(String login, String mdp) {
       try{
           //recherche le client avec le login et mdp saisi
           Query q= em.createQuery(
               "select c from Client c where c.login =:login and c.mdp =:mdp "); 
            q.setParameter("login", login);
            q.setParameter("mdp", mdp);
            //le client est trouvé et retourné
            Client c = (Client) q.getSingleResult();
            return c;
       }
       //la requete ne trouve pas de client avec le login et mdp
       catch(NoResultException e){
           //retourne null
           Client c = null;
           return c;
           
       }
    }

}
