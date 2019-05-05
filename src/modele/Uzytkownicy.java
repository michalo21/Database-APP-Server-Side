/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 *
 * @author Arlen
 */
@Entity
@Table(name="Uzytkownicy")
public class Uzytkownicy implements Serializable {

    private static final long serialVersionUID = 5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
    @SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
    @Column(name="id_uzytkownika", unique=true)
    private int id_uzytkownika;
    
    @Column(name="login")
    private String login;
    
    @Column(name="haslo")
    private String haslo;
    
    @Column(name="imie")
    private String imie;
    
    @Column(name="nazwisko")
    private String nazwisko;

    private String IDlogged;

    public String IDlogged() {
        return IDlogged;
    }
    
    public void setIDlogged(String IDlogged) {
        this.login = login;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getId_uzytkownika() {
        return id_uzytkownika;
    }

    public void setId_uzytkownika(int id_uzytkownika) {
        this.id_uzytkownika = id_uzytkownika;
    }   

    public Uzytkownicy() {
        
    }
    
    
}
