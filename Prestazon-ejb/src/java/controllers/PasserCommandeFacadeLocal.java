/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.PasserCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tebibou
 */
@Local
public interface PasserCommandeFacadeLocal {

    void create(PasserCommande passerCommande);

    void edit(PasserCommande passerCommande);

    void remove(PasserCommande passerCommande);

    PasserCommande find(Object id);

    List<PasserCommande> findAll();

    List<PasserCommande> findRange(int[] range);

    int count();
    
}
