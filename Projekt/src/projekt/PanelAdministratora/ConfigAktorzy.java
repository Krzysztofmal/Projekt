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
public class ConfigAktorzy {
    
    private final IntegerProperty id_aktora;
    private final StringProperty imie_aktora;
    private final StringProperty nazwisko_aktora;

    public ConfigAktorzy(int id_aktora, String imie_aktora, String nazwisko_aktora) {
        this.id_aktora = new SimpleIntegerProperty(id_aktora);
        this.imie_aktora = new SimpleStringProperty(imie_aktora);
        this.nazwisko_aktora = new SimpleStringProperty(nazwisko_aktora);
    }
    
    public int getId_aktora(){
        return id_aktora.get();
    }

    public String getImie_aktora() {
        return imie_aktora.get();
    }

    public String getNazwisko_aktora() {
        return nazwisko_aktora.get();
    }
    
    
    public void setId_aktora(int value){
        id_aktora.set(value);
    }

    public void setImie_aktora(String value) {
        imie_aktora.set(value);
    }

    public void setNazwisko_aktora(String value) {
        nazwisko_aktora.set(value);
    }
    
    public IntegerProperty id_aktora(){
        return id_aktora;
    }

    public StringProperty imie_aktora() {
        return imie_aktora;
    }

    public StringProperty nazwisko_aktora() {
        return nazwisko_aktora;
    }
}
