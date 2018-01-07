/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLLogowanieAdminController implements Initializable {

    @FXML
    private Button btnWejdz;
    @FXML
    private PasswordField psHaslo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void PressedWejdz(MouseEvent event) throws IOException {
        String haslo = "admin";
        if (psHaslo.getText().equals(haslo)) {
            Parent tabela = FXMLLoader.load(getClass().getResource("FXMLPanelAdministratora.fxml"));
            Scene zamowienie = new Scene(tabela);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(zamowienie);
            stage.show();
            stage.setTitle("WITAJ");
            Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
            okienko.close();
        } else {
            projekt.Projekt.Alert("ZŁE HASŁO LUB LOGIN", "Niestety, wprowadzone hasło/login jest nieprawidłowe.");
        }
    }
}


