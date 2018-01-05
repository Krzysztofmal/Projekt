/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private void PressedAddNew(MouseEvent event) {
        String tytul = txTytulFilmu.getText();
        String rezyser = txRezyser.getText();
        String d = txDlFilmu.getText();
        int dl_filmu = Integer.parseInt(d);
        String gatunek = cbGatunek.getValue();
        System.out.println(tytul + " " + rezyser + " " + dl_filmu + " " + gatunek + " ");
        Stage stage = (Stage) btnAddNew.getScene().getWindow();
        stage.close();
    }

}
