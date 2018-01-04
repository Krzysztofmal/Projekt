/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy.Szczegoly;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLOcenaController implements Initializable {

    @FXML
    private JFXButton bOcen;
    @FXML
    private JFXButton bAnuluj;
    @FXML
    private JFXComboBox<String> cbOcena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbOcena.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );        
        cbOcena.setStyle("-fx-font: 18px \"System\";");
        
    }

    @FXML
    private void ocen(ActionEvent event) {

    }

    @FXML
    private void anuluj(ActionEvent event) {
        Stage stage = (Stage) bAnuluj.getScene().getWindow();
        stage.close();
    }

}
