/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modele.Zamowienia;

/**
 *
 * @author Arlen
 */
public class zamowieniaDAO extends HibernateUtil {
    
    
    public List<Zamowienia> getAll() {
         List<Zamowienia> lista = openSessionWithTrans().createSQLQuery("Select * from Zamowienia").addEntity(Zamowienia.class).list();
         closeSessionWithTrans();
         return lista;
    };
    
    public List<Zamowienia> getAllUser() {
         List<Zamowienia> lista = openSessionWithTrans().createSQLQuery("Select * from Zamowienia").addEntity(Zamowienia.class).list();
         closeSessionWithTrans();
         return lista;
    };
    
    
}
