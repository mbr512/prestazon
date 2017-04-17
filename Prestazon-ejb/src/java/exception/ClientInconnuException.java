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
public class ClientInconnuException extends Exception {

    public ClientInconnuException() {
        System.out.println("Le Client est inconnu");
    }
    
}
