/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fema.util;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas
 */
public class JPAUtil {
    
    //Padrão Singleton
    
    private JPAUtil(){
    }
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocalizaPU");
    
    public static EntityManagerFactory getEmf(){
        return emf;
    }
    
}
