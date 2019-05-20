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
import modele.Produkty;
import modele.Uzytkownicy;
import modele.Zamowienia;

/**
 *
 * @author Arlen
 */
public class zamowieniaDAO extends HibernateUtil {
    private float cena;
    public List<Zamowienia> getAll() {
        openSessionWithTrans();
            List<Zamowienia> lista = new ArrayList<Zamowienia>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETORDERADMIN(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Zamowienia order = new Zamowienia();
                String status_zamowienia = rs.getString("status_zamowienia");
                int id_zamowienia = rs.getInt("id_zamowienia");
                

                Uzytkownicy user = new Uzytkownicy();
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                user.setImie(imie);
                user.setNazwisko(nazwisko);
                
                Produkty product = new Produkty();
                String nazwa_produktu = rs.getString("nazwa_produktu");
                product.setNazwa_produktu(nazwa_produktu);
                
                order.setProdukt(product);
                order.setStatus(status_zamowienia);
                order.setId_zamowienia(id_zamowienia);
                order.setUzytkownik(user);
                
                lista.add(order);
                }
          });         
        closeSessionWithTrans();
        return lista;
    };
    
    public List<Zamowienia> searchingOrderAdmin(String l) {
        openSessionWithTrans();
            List<Zamowienia> lista = new ArrayList<Zamowienia>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call SEARCHINGORDERADMIN(?,?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.setString(2, l);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Zamowienia order = new Zamowienia();
                String status_zamowienia = rs.getString("status_zamowienia");
                int id_zamowienia = rs.getInt("id_zamowienia");
                

                Uzytkownicy user = new Uzytkownicy();
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                user.setImie(imie);
                user.setNazwisko(nazwisko);
                
                Produkty product = new Produkty();
                String nazwa_produktu = rs.getString("nazwa_produktu");
                product.setNazwa_produktu(nazwa_produktu);
                
                order.setProdukt(product);
                order.setStatus(status_zamowienia);
                order.setId_zamowienia(id_zamowienia);
                order.setUzytkownik(user);
                
                lista.add(order);
                }
          });         
        closeSessionWithTrans();
        return lista;
    };
    
    public List<Zamowienia> getAllUser() {
         openSessionWithTrans();
            List<Zamowienia> lista = new ArrayList<Zamowienia>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETORDERUSER(?,?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.setInt(2, uzytkownicyDAO.id);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Zamowienia order = new Zamowienia();
                String status_zamowienia = rs.getString("status_zamowienia");
                
                Produkty product = new Produkty();
                String nazwa_produktu = rs.getString("nazwa_produktu");
                float cena_produktu = rs.getFloat("cena_produktu");
                product.setNazwa_produktu(nazwa_produktu);
                product.setCena_produktu(cena_produktu);
                
                order.setProdukt(product);
                order.setStatus(status_zamowienia);
                
                lista.add(order);
                }
          });         
        closeSessionWithTrans();
        return lista;
    };
    
    public List<Zamowienia> searchingOrderUser(String l) {
         openSessionWithTrans();
            List<Zamowienia> lista = new ArrayList<Zamowienia>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call SEARCHINGORDERUSER(?,?,?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.setInt(2, uzytkownicyDAO.id);
            statement.setString(3, l);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Zamowienia order = new Zamowienia();
                String status_zamowienia = rs.getString("status_zamowienia");
                
                Produkty product = new Produkty();
                String nazwa_produktu = rs.getString("nazwa_produktu");
                float cena_produktu = rs.getFloat("cena_produktu");
                product.setNazwa_produktu(nazwa_produktu);
                product.setCena_produktu(cena_produktu);
                
                order.setProdukt(product);
                order.setStatus(status_zamowienia);
                
                lista.add(order);
                }
          });         
        closeSessionWithTrans();
        return lista;
    };
    
     public void update(Zamowienia k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call CHANGEORDERSTATUS(:ajdi,:status)");
        query.setParameter("ajdi", k.getId_zamowienia());
        query.setParameter("status", k.getStatus());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public float ValueOrders(){
            openSessionWithTrans();
                getCurrentLocalSession().doWork((Connection connection) -> {
                CallableStatement statement = connection.prepareCall("{call VALUEORDERS(?,?)}");
                statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                statement.setInt(2, uzytkownicyDAO.id);
                statement.execute();
                ResultSet rs = (ResultSet)statement.getObject(1);
                while(rs.next()){
                    cena = rs.getFloat("wartosc");
                }
            
        });
            closeSessionWithTrans();
            return cena;
    }
    public zamowieniaDAO(){};
}
