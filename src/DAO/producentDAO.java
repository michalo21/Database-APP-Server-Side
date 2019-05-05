/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modele.Kategorie;
import modele.Producent;

/**
 *
 * @author Arlen
 */
public class producentDAO extends HibernateUtil{
    
   
    public List<Producent> getAll() {
         
         List<Producent> lista = openSessionWithTrans().createSQLQuery("Select * from Producent").addEntity(Producent.class).list();
         closeSessionWithTrans();
         return lista;
    };
    
    public void update(Producent k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call UPDATEPROD(:id,:user)");
        query.setParameter("id", k.getId_producenta());
        query.setParameter("user", k.getNazwa_producenta());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void delete(Producent k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call DELETEPROD(:user)").setParameter("user", k.getId_producenta());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void create(Producent k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call INSERTPROD(:user)").setParameter("user", k.getNazwa_producenta());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    
    public producentDAO(){};




   
    
}
