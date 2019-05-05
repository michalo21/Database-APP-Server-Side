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
@Table(name="Producent")
public class Producent implements Serializable {

    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
    @SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
    @Column(name="id_producenta", unique=true)
    private int id_producenta;
    
    @Column(name="nazwa_producenta")
    private String nazwa_producenta;

    public int getId_producenta() {
        return id_producenta;
    }

    public void setId_producenta(int id_producenta) {
        this.id_producenta = id_producenta;
    }

    public String getNazwa_producenta() {
        return nazwa_producenta;
    }

    public void setNazwa_producenta(String nazwa_producenta) {
        this.nazwa_producenta = nazwa_producenta;
    }

    public Producent(int id_producenta, String nazwa_producenta) {
        this.id_producenta = id_producenta;
        this.nazwa_producenta = nazwa_producenta;
    }

    public Producent() {
    }
    
}
