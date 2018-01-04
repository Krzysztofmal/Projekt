/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLWyszukiwarkaController implements Initializable {

    @FXML
    private JFXButton bWybierz;
    @FXML
    private JFXButton bAnuluj;
    @FXML
    private JFXRadioButton radioFilmy;
    @FXML
    private ToggleGroup wybor;
    @FXML
    private JFXRadioButton radioAktorzy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void wybierz(ActionEvent event) throws IOException {
        if (radioFilmy.isSelected()) {

            Stage stage;
            Parent root;

            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("Filmy/FXMLWyszukiwarkaFilmow.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Wyszukiwarka filmów");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(bWybierz.getScene().getWindow());
            stage.showAndWait();

        } else if (radioAktorzy.isSelected()) {
            Stage stage;
            Parent root;

            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("Aktorzy/FXMLWyszukiwarkaAktorow.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Wyszukiwarka aktorów");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(bWybierz.getScene().getWindow());
            stage.showAndWait();
        }
    }

    @FXML
    private void anuluj(ActionEvent event) {
        Stage stage = (Stage) bAnuluj.getScene().getWindow();
        stage.close();
    }

}
