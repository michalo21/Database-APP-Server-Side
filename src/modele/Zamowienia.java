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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="Zamowienia")
public class Zamowienia implements Serializable{
    
    private static final long serialVersionUID = 5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
    @SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
    @Column(name="id_zamowienia", unique=true)
    private int id_zamowienia;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Uzytkownicy uzytkownik;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Produkty produkt;
    
    @Column(name="status_zamowienia")
    private String status;

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public Uzytkownicy getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownicy uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Produkty getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkty produkt) {
        this.produkt = produkt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Zamowienia(){
        
    }
     

    
}
