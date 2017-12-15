/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author jkero
 */
public class Oceny {
    
    private final IntegerProperty id_filmu;
    private final DoubleProperty ocena;
    
    
    public Oceny (Integer id_filmu, Double ocena){
        this.id_filmu = new SimpleIntegerProperty(id_filmu);
        this.ocena = new SimpleDoubleProperty(ocena);
    }
    
    //gettery
    
    public Integer getId_filmu(){
        return id_filmu.get();
    }
    
    public Double getOcena(){
        return ocena.get();
    }
    
    //settery
    
    public void setOcena(Double value){
        ocena.set(value);
    }
    
    //property value
    
    public IntegerProperty id_filmuProperty(){
        return id_filmu;
    }
    
    public DoubleProperty ocenaProperty(){
        return ocena;
    }
    
    
    
}
