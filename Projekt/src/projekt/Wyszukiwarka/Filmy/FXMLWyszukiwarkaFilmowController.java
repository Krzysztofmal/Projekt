/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy;

import Algorytmy.Algorytmy;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.java.accessibility.util.SwingEventMonitor;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projekt.Model.Film;
import projekt.Polaczenie.Polaczenie;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLWyszukiwarkaFilmowController implements Initializable {

    @FXML
    private JFXButton bSzczegoly;
    @FXML
    private JFXTextField tfTytul;
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

    public static Integer idFilmu;
    @FXML
    private JFXButton bSzukaj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //        //bind do wyszukiwania
//
//        //columnTytul.textProperty().bind(tfTytul.textProperty());
//        //przekazac wszystkie wartosci do listy, i liste zbindować na zmiany z textfielda
//        //Pobrać wszystkie tytuły do listy, następnie ustawić na nią bind i porównywać z textfieldem 
//        //w porównywaniu ustawić algorytm który przeanalizuje dane wpisane do textfieldu
//        dataFilm = FXCollections.observableArrayList();
//
//        //moze na tf changelistenerze to zrobić
//        Connection conn = Polaczenie.Connect();
//
//        try {
//            Statement ps = conn.createStatement();
//            ResultSet rs = ps.executeQuery("SELECT * FROM film;");
//
//            tfTytul.textProperty().addListener((observable, oldValue, newValue) -> {
//                while (rs.next()) {
//                    if (Algorytmy.AlgorytmMiaryOdleglosciLevenshteina(rs.getString("tytuł"), tfTytul.getText()) < 3) {
//                        System.out.println(rs.getString("tytuł"));
//                    }
//                    //jak pierwszy nic nie znajdzie, to wtedy działa drugi algorytm
//                    Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText());
//                    if (Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText()) == 1) {
//                        System.out.println("Morrisa Pratta : " + rs.getString("tytuł"));
//                    }
//
//                }
//            });
//
//            ps.close();
//            rs.close();
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        columnTytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
//        columnRezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
//        columnKategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
//        columnDlugosc.setCellValueFactory(new PropertyValueFactory<>("dlugosc"));
//        columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));
//
//        tableFilmy.setItems(null);
//        tableFilmy.setItems(dataFilm);


//try{
//    uzupelnij();
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void szczegoly(ActionEvent event) throws IOException {

        //idFilmu = tableFilmy.getSelectionModel().getSelectedItem().getId_filmu();
        //odblokowac gdy zostanie wybrany jakiś film
        Stage stage;
        Parent root;

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Szczegoly/FXMLSzczegoly.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Wyszukiwarka filmów");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(bSzczegoly.getScene().getWindow());
        stage.showAndWait();
    }

    private void uzupelnij() throws SQLException {
        //bind do wyszukiwania

        //columnTytul.textProperty().bind(tfTytul.textProperty());
        //przekazac wszystkie wartosci do listy, i liste zbindować na zmiany z textfielda
        //Pobrać wszystkie tytuły do listy, następnie ustawić na nią bind i porównywać z textfieldem 
        //w porównywaniu ustawić algorytm który przeanalizuje dane wpisane do textfieldu
        dataFilm = FXCollections.observableArrayList();

        //moze na tf changelistenerze to zrobić
        Connection conn = Polaczenie.Connect();

        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT Film.id_filmu,Film.tytuł,Film.rezyser,Film.dlugosc_filmu,Film.gatunek,AVG(Oceny.ocena) as ocena FROM Film,Oceny WHERE Film.id_filmu=Oceny.id_filmu;");

        
        
//        tfTytul.textProperty().addListener(new ChangeListener<String>()  {
//    @Override
//    public void changed(ObservableValue<? extends String> observable,
//                        String oldValue, String newValue) {
            try {
                boolean wynik;
                while (rs.next()) {
                    wynik = false;
                    if (Algorytmy.AlgorytmMiaryOdleglosciLevenshteina(rs.getString("tytuł"), tfTytul.getText()) < 3) {
                        wynik = true;
                            dataFilm.add(new Film(rs.getInt("id_filmu"), rs.getString("tytuł"), rs.getString("rezyser"), rs.getInt("dlugosc_filmu"), rs.getString("gatunek"), rs.getDouble("ocena")));
                    } else if (wynik == false){
                        //jak pierwszy nic nie znajdzie, to wtedy działa drugi algorytm
                        //Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText());
                        if (Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText()) == 1) {
                            wynik = true;
                                dataFilm.add(new Film(rs.getInt("id_filmu"), rs.getString("tytuł"), rs.getString("rezyser"), rs.getInt("dlugosc_filmu"), rs.getString("gatunek"), rs.getDouble("ocena")));

                        }}

}
            } catch (SQLException ex) {
                Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}));
               // }});
        try {
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        columnTytul.setCellValueFactory(new PropertyValueFactory<>("tytuł"));
        columnRezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
        columnKategoria.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
        columnDlugosc.setCellValueFactory(new PropertyValueFactory<>("dlugosc_filmu"));
        columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));

        tableFilmy.setItems(null);
        tableFilmy.setItems(dataFilm);
        
    }

    @FXML
    private void wyszukajFilmy(ActionEvent event) throws SQLException {
         //bind do wyszukiwania

        //columnTytul.textProperty().bind(tfTytul.textProperty());
        //przekazac wszystkie wartosci do listy, i liste zbindować na zmiany z textfielda
        //Pobrać wszystkie tytuły do listy, następnie ustawić na nią bind i porównywać z textfieldem 
        //w porównywaniu ustawić algorytm który przeanalizuje dane wpisane do textfieldu
        dataFilm = FXCollections.observableArrayList();

        //moze na tf changelistenerze to zrobić
        Connection conn = Polaczenie.Connect();

        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT Film.id_filmu,Film.tytuł,Film.rezyser,Film.dlugosc_filmu,Film.gatunek,AVG(Oceny.ocena) as ocena FROM Film,Oceny WHERE Film.id_filmu=Oceny.id_filmu;");

        
        
//        tfTytul.textProperty().addListener(new ChangeListener<String>()  {
//    @Override
//    public void changed(ObservableValue<? extends String> observable,
//                        String oldValue, String newValue) {
            try {
                boolean wynik;
                while (rs.next()) {
                    wynik = false;
                    if (Algorytmy.AlgorytmMiaryOdleglosciLevenshteina(rs.getString("tytuł"), tfTytul.getText()) < 3) {
                        wynik = true;
                            dataFilm.add(new Film(rs.getInt("id_filmu"), rs.getString("tytuł"), rs.getString("rezyser"), rs.getInt("dlugosc_filmu"), rs.getString("gatunek"), rs.getDouble("ocena")));
                    } else if (wynik == false){
                        //jak pierwszy nic nie znajdzie, to wtedy działa drugi algorytm
                        //Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText());
                        if (Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText()) == 1) {
                            wynik = true;
                                dataFilm.add(new Film(rs.getInt("id_filmu"), rs.getString("tytuł"), rs.getString("rezyser"), rs.getInt("dlugosc_filmu"), rs.getString("gatunek"), rs.getDouble("ocena")));

                        }}

                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}));
               // }});
        try {
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLWyszukiwarkaFilmowController.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        columnTytul.setCellValueFactory(new PropertyValueFactory<>("tytuł"));
        columnRezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
        columnKategoria.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
        columnDlugosc.setCellValueFactory(new PropertyValueFactory<>("dlugosc_filmu"));
        columnOcena.setCellValueFactory(new PropertyValueFactory<>("ocena"));

        tableFilmy.setItems(null);
        tableFilmy.setItems(dataFilm);
    }

   
}
