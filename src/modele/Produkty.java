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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Arlen
 */
@Entity
@Table(name="Produkty")
public class Produkty implements Serializable {

    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
    @SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
    @Column(name="id_produktu", unique = true)
    private int id_produktu;
    
    @Column(name="nazwa_produktu")
    private String nazwa_produktu;
    
    @Column(name="cena_produktu")
    private Float cena_produktu;
    
    @Column(name="opis_produktu")
    private String opis_produktu;
    
    @Column(name="parametry_produktu")
    private String parametry_produktu;
    
    @Lob
    @Column(name="zdjecie_produktu",length=100000000)
    private byte[] zdjecie_produktu;
    
    @ManyToOne
    private Podkategorie podkategorie;
    
    @ManyToOne
    private Producent producent;
    
    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getNazwa_produktu() {
        return nazwa_produktu;
    }

    public void setNazwa_produktu(String nazwa_produktu) {
        this.nazwa_produktu = nazwa_produktu;
    }

    public Float getCena_produktu() {
        return cena_produktu;
    }

    public void setCena_produktu(Float cena_produktu) {
        this.cena_produktu = cena_produktu;
    }

    public String getOpis_produktu() {
        return opis_produktu;
    }

    public void setOpis_produktu(String opis_produktu) {
        this.opis_produktu = opis_produktu;
    }

    public String getParametry_produktu() {
        return parametry_produktu;
    }

    public void setParametry_produktu(String parametry_produktu) {
        this.parametry_produktu = parametry_produktu;
    }

    public byte[] getZdjecie_produktu() {
        return zdjecie_produktu;
    }

    public void setZdjecie_produktu(byte[] zdjecie_produktu) {
        this.zdjecie_produktu = zdjecie_produktu;
    }

    public Podkategorie getPodkategorie() {
        return podkategorie;
    }

    public void setPodkategorie(Podkategorie podkategorie) {
        this.podkategorie = podkategorie;
    }

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Produkty(int id_produktu, String nazwa_produktu, Float cena_produktu, String opis_produktu, String parametry_produktu, byte[] zdjecie_produktu, Kategorie kategorie, Podkategorie podkategorie, Producent producent) {
        this.id_produktu = id_produktu;
        this.nazwa_produktu = nazwa_produktu;
        this.cena_produktu = cena_produktu;
        this.opis_produktu = opis_produktu;
        this.parametry_produktu = parametry_produktu;
        this.zdjecie_produktu = zdjecie_produktu;
        this.podkategorie = podkategorie;
        this.producent = producent;
    }

    
    
    public Produkty() {
    }

}
