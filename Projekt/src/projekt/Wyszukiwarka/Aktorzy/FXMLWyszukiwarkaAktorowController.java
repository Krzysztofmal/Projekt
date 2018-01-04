/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Aktorzy;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import projekt.Model.Aktor;
import projekt.Model.Film;

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
    private TableColumn<?, ?> columnKategoria;
    @FXML
    private TableColumn<?, ?> columnOcena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
