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
    private final StringProperty gatunek;
    private final DoubleProperty ocena;
    
    public Film (Integer id_filmu, String tytuł, String rezyser, Integer dlugosc_filmu, String gatunek, Double ocena){
        this.id_filmu = new SimpleIntegerProperty (id_filmu);
        this.tytuł = new SimpleStringProperty (tytuł);
        this.rezyser = new SimpleStringProperty (rezyser);
        this.dlugosc_filmu = new SimpleIntegerProperty (dlugosc_filmu);
        this.gatunek = new SimpleStringProperty (gatunek);
        this.ocena = new SimpleDoubleProperty (ocena);
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
    
    public String getGatunek(){
        return gatunek.get();
    }
    
    public Double getOcena(){
        return ocena.get();
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
    
    public void setGatunek(String value){
        gatunek.set(value);
    }
    
    public void setOcena(Double value){
        ocena.set(value);
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
    
    public StringProperty gatunekProperty(){
        return gatunek;
    }
    
    public DoubleProperty ocenaProperty(){
        return ocena;
    }
    
}
