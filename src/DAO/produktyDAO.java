/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import javax.persistence.Query;
import modele.Kategorie;
import modele.Podkategorie;
import modele.Produkty;
import modele.Producent;

/**
 *
 * @author Arlen
 */
public class produktyDAO extends HibernateUtil{
    
    public List<Produkty> getAll() {
         openSessionWithTrans();
         List<Produkty> list = new ArrayList<Produkty>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call GETPRODUCT(?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Produkty product = new Produkty();
                int id_produktu = rs.getInt("id_produktu");
                String nazwa_produktu = rs.getString("nazwa_produktu");
                String parametry_produktu = rs.getString("parametry_produktu");
                String opis_produktu = rs.getString("opis_produktu");
                float cena = rs.getFloat("cena_produktu");
                byte[] zdjecie_produktu = rs.getBytes("zdjecie_produktu");
                
                
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
                
               
                Producent producent = new Producent();
                int id_producenta = rs.getInt("id_producenta");
                String nazwa_producenta = rs.getString("nazwa_producenta");
                producent.setId_producenta(id_producenta);
                producent.setNazwa_producenta(nazwa_producenta);
                
               
                product.setCena_produktu(cena);
                product.setId_produktu(id_produktu);
                product.setNazwa_produktu(nazwa_produktu);
                product.setOpis_produktu(opis_produktu);
                product.setParametry_produktu(parametry_produktu);
                product.setPodkategorie(undercat);
                product.setProducent(producent);
                product.setZdjecie_produktu(zdjecie_produktu);
                list.add(product);
                }
          }); 
         closeSessionWithTrans();
         return list;
    };
    
    public void update(Produkty k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call UPDATEPRODUCT(:id,:cena,:nazwa,:opis,:para,:zdj,:underc,:prod)");
        query.setParameter("id", k.getId_produktu());
        query.setParameter("cena", k.getCena_produktu());
        query.setParameter("nazwa", k.getNazwa_produktu());
        query.setParameter("opis", k.getOpis_produktu());
        query.setParameter("para", k.getParametry_produktu());
        query.setParameter("zdj", k.getZdjecie_produktu());
        query.setParameter("underc", k.getPodkategorie());
        query.setParameter("prod", k.getProducent());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void delete(Produkty k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call DELETEPRODUCT(:user)").setParameter("user", k.getId_produktu());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void create(Produkty k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call INSERTPRODUCT(:cena,:nazwa,:opis,:para,:zdj,:underc, :prod)");
        query.setParameter("cena", k.getCena_produktu());
        query.setParameter("nazwa", k.getNazwa_produktu());
        query.setParameter("opis", k.getOpis_produktu());
        query.setParameter("para", k.getParametry_produktu());
        query.setParameter("zdj", k.getZdjecie_produktu());
        query.setParameter("underc", k.getPodkategorie());
        query.setParameter("prod", k.getProducent());
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public void buyProduct(Produkty k){
        openSessionWithTrans();
        Query query = getCurrentLocalSession().createSQLQuery("call BUYPRODUCT(:id_produktu,:id_uzytkownika)");
        query.setParameter("id_produktu", k.getId_produktu());
        query.setParameter("id_uzytkownika", uzytkownicyDAO.id);
        query.executeUpdate();
        closeSessionWithTrans();
    };
    public List searchingProduct(String l){
        openSessionWithTrans();
         List<Produkty> list = new ArrayList<Produkty>();
            getCurrentLocalSession().doWork((Connection connection) -> {
            CallableStatement statement = connection.prepareCall("{call SEARCHINGPRODUCT(?,?)}");
            statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            statement.setString(2, l);
            statement.execute();
            ResultSet rs = (ResultSet)statement.getObject(1);
            
            while(rs.next()){
                Produkty product = new Produkty();
                int id_produktu = rs.getInt("id_produktu");
                String nazwa_produktu = rs.getString("nazwa_produktu");
                String parametry_produktu = rs.getString("parametry_produktu");
                String opis_produktu = rs.getString("opis_produktu");
                float cena = rs.getFloat("cena_produktu");
                byte[] zdjecie_produktu = rs.getBytes("zdjecie_produktu");
                
                
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
                
               
                Producent producent = new Producent();
                int id_producenta = rs.getInt("id_producenta");
                String nazwa_producenta = rs.getString("nazwa_producenta");
                producent.setId_producenta(id_producenta);
                producent.setNazwa_producenta(nazwa_producenta);
                
               
                product.setCena_produktu(cena);
                product.setId_produktu(id_produktu);
                product.setNazwa_produktu(nazwa_produktu);
                product.setOpis_produktu(opis_produktu);
                product.setParametry_produktu(parametry_produktu);
                product.setPodkategorie(undercat);
                product.setProducent(producent);
                product.setZdjecie_produktu(zdjecie_produktu);
                list.add(product);
                }
          }); 
         closeSessionWithTrans();
         return list;
    }
    
    public byte[] insertPhoto(TextArea g){
            File file = new File(g.getText());
            byte[] image = new byte[(int)file.length()];
            FileInputStream inputStream = null;
            try{
              inputStream = new FileInputStream(file);
              inputStream.read(image);
            } catch(IOException e){   
            } finally{
                try{
                   if(inputStream!=null){
                      inputStream.close();
                   }
                } catch (IOException e){ 
                }
            }
            return image;
         }         
    
    public produktyDAO(){};


    
    
}
