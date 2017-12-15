/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jkero
 */
public class Aktor {
    
    private final IntegerProperty id_aktora;
    private final StringProperty imie_aktora;
    private final StringProperty nazwisko_aktora;
    private final StringProperty nagrody;
    private final StringProperty data_urodzenia;
    
    public Aktor (Integer id_aktora, String imie_aktora, String nazwisko_aktora, String nagrody, String data_urodzenia) {
        
        this.id_aktora = new SimpleIntegerProperty(id_aktora);
        this.imie_aktora = new SimpleStringProperty(imie_aktora);
        this.nazwisko_aktora = new SimpleStringProperty(nazwisko_aktora);
        this.nagrody = new SimpleStringProperty(nagrody);
        this.data_urodzenia = new SimpleStringProperty(data_urodzenia);
        
    }
    
    
    //gettery
    
    public Integer getId_aktora(){
        return id_aktora.get();
    }
    
    public String getImie_aktora(){
        return imie_aktora.get();
    }
    
    public String getNazwisko_aktora(){
        return nazwisko_aktora.get();
    }
    
    public String getNagrody(){
        return nagrody.get();
    }
    
    public String getData_urodzenia(){
        return data_urodzenia.get();
    }
    
    //settery
    
    public void setImie_aktora(String value){
        imie_aktora.set(value);
    }
    
    public void setNazwisko_aktora(String value){
        nazwisko_aktora.set(value);
    }
    
    public void setNagrody(String value){
        nagrody.set(value);
    }
    
    public void setData_urodzenia(String value){
        data_urodzenia.set(value);
    }
    
    
    
    //property value
    
    public IntegerProperty id_aktoraProperty(){
        return id_aktora;
    }
    
    public StringProperty imie_aktoraProperty(){
        return imie_aktora;
    }
    
    public StringProperty nazwisko_aktoraProperty(){
        return nazwisko_aktora;
    }
    
    public StringProperty nagrodyProperty(){
        return nagrody;
    }
    
    public StringProperty data_urodzeniaProperty(){
        return data_urodzenia;
    }
    
    
    
}
