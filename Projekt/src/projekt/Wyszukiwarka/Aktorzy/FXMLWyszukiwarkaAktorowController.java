/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Aktorzy;

import Algorytmy.Algorytmy;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import projekt.Model.Aktor;
import projekt.Model.Film;
import projekt.Polaczenie.Polaczenie;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLWyszukiwarkaAktorowController implements Initializable {

    @FXML
    private JFXTextField tfAktor;
    @FXML
    private TableView<Aktor> tableAktorzy;
    @FXML
    private TableColumn<Aktor, String> columnImie;
    @FXML
    private TableColumn<Aktor, String> columnNazwisko;
    @FXML
    private TableColumn<Aktor, String> columnData;
    @FXML
    private TableColumn<Aktor, String> columnNagrody;
    @FXML
    private TableView<Film> tableFilmy;
    @FXML
    private TableColumn<Film, String> columnTytul;
    @FXML
    private TableColumn<Film, String> columnRezyser;
    @FXML
    private TableColumn<Film, Integer> columnDlugosc;
    @FXML
    private TableColumn<Film, String> columnKategoria;
    @FXML
    private TableColumn<Film, Double> columnOcena;

    private ObservableList<Film> dataFilm;
    private ObservableList<Aktor> dataAktor;
    @FXML
    private JFXButton bSzukajAktora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void wyszukajAktora(ActionEvent event) throws SQLException {

        //dataFilm = FXCollections.observableArrayList();
        dataAktor = FXCollections.observableArrayList();
        dataAktor.clear();

        Connection conn = Polaczenie.Connect();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT distinct Aktor.id_aktora,Aktor.imie_aktora,Aktor.nazwisko_aktora,Aktor.nagrody,Aktor.data_urodzenia FROM Aktor,Film_Aktor WHERE Aktor.id_aktora=Film_aktor.id_aktora;");

        while (rs.next()) {
            if (tfAktor.getText().equals("")) {
                dataAktor.add(new Aktor(rs.getInt("id_aktora"), rs.getString("imie_aktora"), rs.getString("nazwisko_aktora"), rs.getString("nagrody"), rs.getString("data_urodzenia")));

            } else {
                String nazwaAktora = rs.getString("imie_aktora") + rs.getString("nazwisko_aktora");
                if (Algorytmy.porownanieZnakow(nazwaAktora.replace(" ", "").toLowerCase(), tfAktor.getText().replace(" ", "").toLowerCase()) > 83) {
                    dataAktor.add(new Aktor(rs.getInt("id_aktora"), rs.getString("imie_aktora"), rs.getString("nazwisko_aktora"), rs.getString("nagrody"), rs.getString("data_urodzenia")));

                }
            }

        }

        ps.close();
        rs.close();
        conn.close();

        columnImie.setCellValueFactory(new PropertyValueFactory<>("imie_aktora"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko_aktora"));
        columnNagrody.setCellValueFactory(new PropertyValueFactory<>("nagrody"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));

        tableAktorzy.setItems(null);
        tableAktorzy.setItems(dataAktor);

    }

    @FXML
    private void zaznaczAktora(MouseEvent event) throws SQLException {
        dataFilm = FXCollections.observableArrayList();
        dataFilm.clear();
        
        Connection conn = Polaczenie.Connect();
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT distinct film.id_filmu,film.tytuł,film.rezyser,film.dlugosc_filmu,film.gatunek,film.opis, CASE WHEN oceny.ocena is null THEN '0' ELSE AVG(Oceny.ocena) END as ocena  FROM oceny,film,film_aktor,aktor WHERE film_aktor.id_aktora=" + tableAktorzy.getSelectionModel().getSelectedItem().getId_aktora() + " AND film_aktor.id_filmu=film.id_filmu GROUP BY film.id_filmu;");

        while (rs.next()) {
            
            dataFilm.add(new Film(rs.getInt("id_filmu"), rs.getString("tytuł"), rs.getString("rezyser"), rs.getInt("dlugosc_filmu"), rs.getString("gatunek"), rs.getDouble("ocena")));

            
        }
        
        
        ps.close();
        rs.close();
        conn.close();
        
        columnTytul.setCellValueFactory(new PropertyValueFactory<>("tytuł"));
        columnRezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
        columnKategoria.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
        columnDlugosc.setCellValueFactory(new PropertyValueFactory<>("dlugosc_filmu"));
        columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));

        tableFilmy.setItems(null);
        tableFilmy.setItems(dataFilm);
        
        
        
        
    }
    
    
    
    

}
