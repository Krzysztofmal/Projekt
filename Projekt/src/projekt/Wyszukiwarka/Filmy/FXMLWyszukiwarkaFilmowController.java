/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projekt.Model.Film;

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
    private TableColumn<Film, ?> columnOcena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void szczegoly(ActionEvent event) throws IOException {

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

}
