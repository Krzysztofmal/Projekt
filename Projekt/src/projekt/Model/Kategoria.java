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
public class Kategoria {
    
    private final IntegerProperty id_kategorii;
    private final StringProperty typ;
    
    
    public Kategoria (Integer id_kategorii, String typ){
        this.id_kategorii = new SimpleIntegerProperty(id_kategorii);
        this.typ = new SimpleStringProperty(typ);
    }
    
    //gettery
    
    public Integer getId_kategorii(){
        return id_kategorii.get();
    }
    
    public String getTyp(){
        return typ.get();
    }
    
    //settery
    
    public void setTyp(String value){
        typ.set(value);
    }
    
    //property value
    
    public IntegerProperty id_kategoriiProperty(){
        return id_kategorii;
    }
    
    public StringProperty typProperty(){
        return typ;
    }
    
}
