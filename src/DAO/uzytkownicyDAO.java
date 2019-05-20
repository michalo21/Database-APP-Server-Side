/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;



/**
 *
 * @author Arlen
 */

public class uzytkownicyDAO extends HibernateUtil{
    public static  int id;
    
    public int authUser(String login, String passwd){
        openSessionWithTrans();
            getCurrentLocalSession().doWork((Connection connection) -> {
                CallableStatement statement = connection.prepareCall("{call AUTHUSER(?,?,?)}");
                statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
                statement.setString(2, login);
                statement.setString(3, passwd);
                statement.execute();
                ResultSet rs = (ResultSet)statement.getObject(1);
                while(rs.next()){
                    id = rs.getInt("id_uzytkownika");   
                }
            });         
        
        
        
        closeSessionWithTrans();
        return id;
        
}   
    public uzytkownicyDAO(){
    }
}

