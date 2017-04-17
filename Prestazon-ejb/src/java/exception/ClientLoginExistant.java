/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author tebibou
 */
public class ClientLoginExistant extends Exception {

    public ClientLoginExistant() {
        System.out.println("Le login choisi est déjà utilisé");
    }
    
}
