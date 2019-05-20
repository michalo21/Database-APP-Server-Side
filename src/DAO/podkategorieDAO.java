/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
         
         openSessionWithTrans();
            List<Podkategorie> list = new ArrayList<Podkategorie>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETUNDERCAT(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Kategorie cat = new Kategorie();
                int kategorie_id_kategorii = rs.getInt("kategorie_id_kategorii");
                String nazwa_kategorii = rs.getString("nazwa_kategorii");
                cat.setId_kategorii(kategorie_id_kategorii);
                cat.setNazwa_kategorii(nazwa_kategorii);
                
                
                Podkategorie undercat = new Podkategorie();
                int id_podkategorii = rs.getInt("id_podkategorii");
                String nazwa_podkategorii = rs.getString("nazwa_podkategorii");
                undercat.setId_podkategorii(id_podkategorii);
                undercat.setNazwa_podkategorii(nazwa_podkategorii);
                undercat.setKategorie(cat);
                
                list.add(undercat);
                }
          }); 
            closeSessionWithTrans();
         return list;
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
