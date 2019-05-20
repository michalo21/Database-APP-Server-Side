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
import modele.Kategorie;
import org.hibernate.query.Query;


public class kategorieDAO extends HibernateUtil {
   
    
    public List<Kategorie> getAll() {
        
         openSessionWithTrans();
         List<Kategorie> list = new ArrayList<Kategorie>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETCAT(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Kategorie cat = new Kategorie();
                int id_kategorii = rs.getInt("id_kategorii");
                String nazwa_kategorii = rs.getString("nazwa_kategorii");
                cat.setId_kategorii(id_kategorii);
                cat.setNazwa_kategorii(nazwa_kategorii);
                
                list.add(cat);
                }
          }); 
        closeSessionWithTrans();
        
        return list;
         
    };
    
    public void update(Kategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call UPDATECAT(:id,:user)");
        query.setParameter("id", k.getId_kategorii());
        query.setParameter("user", k.getNazwa_kategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void delete(Kategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call DELETECAT(:user)").setParameter("user", k.getId_kategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void create(Kategorie k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call INSERTCAT(:user)").setParameter("user", k.getNazwa_kategorii());
        query.executeUpdate();
        closeSessionWithTrans();
    };
   
    
    public kategorieDAO(){};
}

