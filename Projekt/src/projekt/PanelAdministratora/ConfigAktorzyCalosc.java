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
public class ConfigAktorzyCalosc {

    private final IntegerProperty id_aktora;
    private final StringProperty imie_aktora;
    private final StringProperty nazwisko_aktora;
    private final StringProperty data_urodzenia;
    private final StringProperty nagrody;

    public ConfigAktorzyCalosc(int id_aktora, String imie_aktora, String nazwisko_aktora, String data_urodzenia, String nagrody) {
        this.id_aktora = new SimpleIntegerProperty(id_aktora);
        this.imie_aktora = new SimpleStringProperty(imie_aktora);
        this.nazwisko_aktora = new SimpleStringProperty(nazwisko_aktora);
        this.data_urodzenia = new SimpleStringProperty(data_urodzenia);
        this.nagrody = new SimpleStringProperty(nagrody);
    }

    public int getId_aktora() {
        return id_aktora.get();
    }

    public String getImie_aktora() {
        return imie_aktora.get();
    }

    public String getNazwisko_aktora() {
        return nazwisko_aktora.get();
    }

    public String getData_urodzenia() {
        return data_urodzenia.get();
    }

    public String getNagrody() {
        return nagrody.get();
    }

    public void setId_aktora(int value) {
        id_aktora.set(value);
    }

    public void setImie_aktora(String value) {
        imie_aktora.set(value);
    }

    public void setNazwisko_aktora(String value) {
        nazwisko_aktora.set(value);
    }

    public void setData_urodzenia(String value) {
        data_urodzenia.set(value);
    }

    public void setNagrody(String value) {
        nagrody.set(value);
    }

    public IntegerProperty id_aktora() {
        return id_aktora;
    }

    public StringProperty imie_aktora() {
        return imie_aktora;
    }

    public StringProperty nazwisko_aktora() {
        return nazwisko_aktora;
    }

    public StringProperty data_urodzenia() {
        return data_urodzenia;
    }

    public StringProperty nagrody() {
        return nagrody;
    }
}
