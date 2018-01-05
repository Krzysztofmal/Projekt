/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Łukasz
 */
public class Config {

    private final IntegerProperty id_filmu;
    private final StringProperty tytul;
    private final StringProperty rezyser;
    private final IntegerProperty dlugosc_filmu;
    private final StringProperty gatunek;

    public Config(int id_filmu, String tytul, String rezyser, int dlugosc_filmu, String gatunek) {
        this.id_filmu = new SimpleIntegerProperty(id_filmu);
        this.tytul = new SimpleStringProperty(tytul);
        this.rezyser = new SimpleStringProperty(rezyser);
        this.dlugosc_filmu = new SimpleIntegerProperty(dlugosc_filmu);
        this.gatunek = new SimpleStringProperty(gatunek);

    }

    //getters
    
    public int getId_filmu(){
        return id_filmu.get();
    }
    
    public String getTytul() {
        return tytul.get();
    }

    public String getRezyser() {
        return rezyser.get();
    }

    public int getDlugosc_filmu() {
        return dlugosc_filmu.get();
    }

    public String getGatunek() {
        return gatunek.get();
    }

    //setters
    
    public void setId_filmu(int value){
        id_filmu.set(value);
    }
    
    public void setTytul(String value) {
        tytul.set(value);
    }

    public void setRezyser(String value) {
        rezyser.set(value);
    }

    public void setDlugosc_filmu(int value) {
        dlugosc_filmu.set(value);
    }

    public void setGatunek(String value) {
        gatunek.set(value);
    }

    //property
    
    public IntegerProperty id_filmu(){
        return id_filmu;
    }
    
    public StringProperty tytul() {
        return tytul;
    }

    public StringProperty rezyser() {
        return rezyser;
    }

    public IntegerProperty dlugosc_filmu() {
        return dlugosc_filmu;
    }

    public StringProperty gatunek() {
        return gatunek;
    }

}


