/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import modele.Kategorie;
import oracle.jdbc.OracleTypes;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

/**
 *
 * @author Arlen
 */
public class kategorieDAO extends HibernateUtil {
     
    public List<Kategorie> getAll() {
         /*ProcedureCall call =  openSessionWithTrans().createStoredProcedureCall("GETALLCAT");
         call.registerParameter(1, Kategorie.class, ParameterMode.REF_CURSOR);
         call.addSynchronizedEntityClass(Kategorie.class);         
         Output output = call.getOutputs().getCurrent();
         List<Kategorie> lista = ((ResultSetOutput)output).getResultList();*/
         List<Kategorie> lista = openSessionWithTrans().createSQLQuery("Select * from Kategorie").addEntity(Kategorie.class).list();
         closeSessionWithTrans();
         return lista;
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
