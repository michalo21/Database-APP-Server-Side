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
import modele.Podkategorie;

/**
 *
 * @author Arlen
 */
public class podkategorieDAO extends HibernateUtil {
    
    public List<Podkategorie> getAll() {
         
         List<Podkategorie> lista = openSessionWithTrans().createSQLQuery("Select * from Podkategorie").addEntity(Podkategorie.class).list();
         closeSessionWithTrans();
         return lista;
    };
    
    public void update(Podkategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call UPDATEUNDERCAT(:id,:nazwa,:kat)");
        query.setParameter("id", k.getId_podkategorii());
        query.setParameter("nazwa", k.getNazwa_podkategorii());
        query.setParameter("kat", k.getKategorie().getId_kategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void delete(Podkategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call DELETEUNDERCAT(:user)").setParameter("user", k.getId_podkategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void create(Podkategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call INSERTUNDERCAT(:name, :catname)").setParameter("name", k.getNazwa_podkategorii()).setParameter("catname", k.getKategorie().getId_kategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
  
    
       public podkategorieDAO(){};



   

    
    
}
