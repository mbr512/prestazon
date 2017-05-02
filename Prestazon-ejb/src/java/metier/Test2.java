/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.ClientFacadeLocal;
import entities.Client;
import exception.ClientInconnuException;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author lemec
 */
@WebService(serviceName = "Test2")
@Stateless()
public class Test2 {

    @EJB
    private ClientFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "client") Client client) {
        ejbRef.create(client);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "client") Client client) {
        ejbRef.edit(client);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "client") Client client) {
        ejbRef.remove(client);
    }

    @WebMethod(operationName = "find")
    public Client find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Client> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Client> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "chercherClient")
    public long chercherClient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom) throws ClientInconnuException {
        return ejbRef.chercherClient(nom, prenom);
    }

    @WebMethod(operationName = "resultatAuthentification")
    public Client resultatAuthentification(@WebParam(name = "login") String login, @WebParam(name = "mdp") String mdp) {
        return ejbRef.resultatAuthentification(login, mdp);
    }

    @WebMethod(operationName = "listeLogin")
    public List<String> listeLogin() {
        return ejbRef.listeLogin();
    }
    
}
