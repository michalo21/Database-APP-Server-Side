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
import modele.Producent;

/**
 *
 * @author Arlen
 */
public class producentDAO extends HibernateUtil{
    
   
    public List<Producent> getAll() {
         openSessionWithTrans();
            List<Producent> lista = new ArrayList<Producent>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETPRODUCENT(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                int i = rs.getInt("id_producenta");
                String str = rs.getString("nazwa_producenta");
                Producent kat = new Producent();
                kat.setId_producenta(i);
                kat.setNazwa_producenta(str);
                lista.add(kat);
                }
          });
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
