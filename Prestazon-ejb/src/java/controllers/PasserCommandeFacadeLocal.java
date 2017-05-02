/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Passercommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tebibou
 */
@Local
public interface PasserCommandeFacadeLocal {

    void create(Passercommande passerCommande);

    void edit(Passercommande passerCommande);

    void remove(Passercommande passerCommande);

    Passercommande find(Object id);

    List<Passercommande> findAll();

    List<Passercommande> findRange(int[] range);

    int count();
    
}
