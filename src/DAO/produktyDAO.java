/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import javax.persistence.Query;
import modele.Kategorie;
import modele.Produkty;

/**
 *
 * @author Arlen
 */
public class produktyDAO extends HibernateUtil{
    
    public List<Produkty> getAll() {
         List<Produkty> lista = openSessionWithTrans().createSQLQuery("Select * from Produkty").addEntity(Produkty.class).list();
         closeSessionWithTrans();
         return lista;
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
