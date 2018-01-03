/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private JFXButton bPanelAdmina;
    @FXML
    private JFXButton bWyszukiwarka;
    @FXML
    private JFXButton bWyjscie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    
    @FXML
    private void przejdzDoPaneluAdmina(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

       
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("PanelAdministratora/FXMLPanelAdministratora.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Panel administratora");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(bPanelAdmina.getScene().getWindow());
            stage.showAndWait();
        
    }

    @FXML
    private void przejdzDoWyszukiwarki(ActionEvent event) throws IOException {
        
        Stage stage;
        Parent root;

            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("Wyszukiwarka/FXMLWyszukiwarka.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Wyszukiwarka");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(bWyszukiwarka.getScene().getWindow());
            stage.showAndWait();
        
    }

    @FXML
    private void wyjscie(ActionEvent event) {
        System.exit(0);
    }
    
}
