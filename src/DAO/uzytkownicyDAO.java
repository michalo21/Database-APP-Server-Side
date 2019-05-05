/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import modele.Uzytkownicy;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Arlen
 */

public class uzytkownicyDAO extends HibernateUtil{
     
    
    public List<Uzytkownicy> getAll() {
         
         List<Uzytkownicy> lista = openSessionWithTrans().createCriteria(Uzytkownicy.class).list();
         closeSessionWithTrans();
         return lista;
    };
    public boolean auth(String login, String passwd){
      List<Uzytkownicy> users = getAll();
      if(!users.isEmpty()){
        for(int i = 0; i < users.size(); i++){
             if(login.equals(users.get(i).getLogin()) && passwd.equals(users.get(i).getHaslo())){
                 return true;
              }else{
                  continue;
              }
          }
      return false;
              }else{
                return true;
               }
    }

    public uzytkownicyDAO(){};
}

