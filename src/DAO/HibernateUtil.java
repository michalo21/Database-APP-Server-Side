/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modele.Kategorie;
import modele.Podkategorie;
import modele.Pracownicy;
import modele.Producent;
import modele.Produkty;
import modele.Uzytkownicy;
import modele.Zamowienia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import static org.hibernate.boot.registry.StandardServiceRegistryBuilder.destroy;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Arlen
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static ServiceRegistry registry;
    private static Transaction transact;
    private static Configuration config;
    
    
    public static void StartSessionFactory(){
        try {
            config = new Configuration().configure("/HibernateConfigXML/hibernate.cfg.xml");
                          config.addAnnotatedClass(Kategorie.class);
                          config.addAnnotatedClass(Podkategorie.class);
                          config.addAnnotatedClass(Producent.class);
                          config.addAnnotatedClass(Produkty.class);
                          config.addAnnotatedClass(Uzytkownicy.class);
                          config.addAnnotatedClass(Zamowienia.class);
                          config.addAnnotatedClass(Pracownicy.class);



            registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

            sessionFactory = config.buildSessionFactory(registry);
        }   
        catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public Session openSessionWithoutTrans(){
          session = getSessionFactory().openSession();
          return session;
    }
    
    public Session openSessionWithTrans(){
           session = getSessionFactory().openSession();
           transact = session.beginTransaction();
           return session;
    }
    
    public void closeSessionWithoutTrans(){
            getCurrentLocalSession().close();
    }
    
    public void closeSessionWithTrans(){
            getCurrentLocalTransac().commit();
            getCurrentLocalSession().close();
    }
    
    public Session getCurrentLocalSession(){
        return session;
    }
    
    public Transaction getCurrentLocalTransac(){
        return transact;
    }
    
    public static void CloseConnection(){
        sessionFactory.close();
        destroy(registry);
    }
    
    public static void OpenConnection(){
        StartSessionFactory();
    }
}