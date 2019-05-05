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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 *
 * @author Arlen
 */
@Entity
@Table(name="Kategorie")
public class Kategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
    @SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
    @Column(name="id_kategorii", unique=true)
    private int id_kategorii;
    
    @Column(name="nazwa_kategorii")
    private String nazwa_kategorii;

    public int getId_kategorii() {
        return id_kategorii;
    }

    public void setId_kategorii(int id_kategorii) {
        this.id_kategorii = id_kategorii;
    }

    public String getNazwa_kategorii() {
        return nazwa_kategorii;
    }

    public void setNazwa_kategorii(String nazwa_kategorii) {
        this.nazwa_kategorii = nazwa_kategorii;
    }

    public Kategorie(int id_kategorii, String nazwa_kategorii) {
        this.id_kategorii = id_kategorii;
        this.nazwa_kategorii = nazwa_kategorii;
    }

    public Kategorie() {
    }
    
   


    
    
}
