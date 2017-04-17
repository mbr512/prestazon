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
public class ClientExistantException extends Exception {
    public ClientExistantException(){
        System.out.println("Le client existe déjà");
    }
}
