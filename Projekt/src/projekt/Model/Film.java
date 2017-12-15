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
public class Film {
    
    private final IntegerProperty id_filmu;
    private final StringProperty tytuł;
    private final StringProperty rezyser;
    private final IntegerProperty dlugosc_filmu;
    private final IntegerProperty id_kategorii;
    
    public Film (Integer id_filmu, String tytuł, String rezyser, Integer dlugosc_filmu, Integer id_kategorii){
        this.id_filmu = new SimpleIntegerProperty (id_filmu);
        this.tytuł = new SimpleStringProperty (tytuł);
        this.rezyser = new SimpleStringProperty (rezyser);
        this.dlugosc_filmu = new SimpleIntegerProperty (dlugosc_filmu);
        this.id_kategorii = new SimpleIntegerProperty (id_kategorii);
    }
    
    //gettery
    
    public Integer getId_filmu(){
        return id_filmu.get();
    }
    
    public String getTytuł(){
        return tytuł.get();
    }
    
    public String getRezyser(){
        return rezyser.get();
    }
    
    public Integer getDlugosc_filmu(){
        return dlugosc_filmu.get();
    }
    
    public Integer getId_kategorii(){
        return id_kategorii.get();
    }
    
    //settery
    
    public void setTytuł(String value){
        tytuł.set(value);
    }
    
    public void setRezyser(String value){
        rezyser.set(value);
    }
    
    public void setDlugoscFilmu(Integer value){
        dlugosc_filmu.set(value);
    }
    
    public void setId_kategorii(Integer value){
        id_kategorii.set(value);
    }
    
    //property value
    
    public IntegerProperty id_filmuProperty(){
        return id_filmu;
    }
    
    public StringProperty tytułProperty(){
        return tytuł;
    }
    
    public StringProperty rezyserProperty(){
        return rezyser;
    }
    
    public IntegerProperty dlugosc_filmuProperty(){
        return dlugosc_filmu;
    }
    
    public IntegerProperty id_kategoriiProperty(){
        return id_kategorii;
    }
    
    
}
