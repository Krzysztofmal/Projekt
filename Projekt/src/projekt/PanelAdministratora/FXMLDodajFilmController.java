/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLDodajFilmController implements Initializable {

    @FXML
    private TextField txTytulFilmu;
    @FXML
    private TextField txRezyser;
    @FXML
    private TextField txDlFilmu;
    @FXML
    private ComboBox<String> cbGatunek;
    @FXML
    private Button btnAddNew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbGatunek.getItems().addAll(
                "Komedia",
                "Komedia romantyczna",
                "Komedia kryminalna",
                "Horror",
                "Film dokumentalny",
                "Film przygodowy",
                "Film wojenny",
                "Kryminał",
                "Thriller",
                "Western"
        );
    }

    @FXML
    private void PressedAddNew(MouseEvent event) throws IOException {
        try {
            Connection con = projekt.Polaczenie.Polaczenie.Connect();
            if (txTytulFilmu.getText().isEmpty() || txRezyser.getText().isEmpty() || txDlFilmu.getText().isEmpty() || cbGatunek.getValue().isEmpty()) {
                projekt.Projekt.Alert("NIEPOPRAWNE DANE", "Uzupełnij wszystkie pola odpowiednimi danymi.");
            } else {
                con.createStatement().executeUpdate("INSERT INTO Film(tytuł,rezyser, dlugosc_filmu, gatunek) Values " + "('"
                        + txTytulFilmu.getText() + "','" + txRezyser.getText() + "','" + txDlFilmu.getText() + "','" + cbGatunek.getValue() + "')");
                con.close();
                Stage stage = (Stage) btnAddNew.getScene().getWindow();
                stage.close();
                
            }
        } catch (SQLException e) {
            System.err.println("ERROR" + e);

        }
    }

}
