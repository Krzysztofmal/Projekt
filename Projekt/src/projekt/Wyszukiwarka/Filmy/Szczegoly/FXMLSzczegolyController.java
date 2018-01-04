/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy.Szczegoly;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projekt.Model.Aktor;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLSzczegolyController implements Initializable {

    @FXML
    private JFXButton bOcen;
    @FXML
    private TableView<Aktor> tableAktorzy;
    @FXML
    private TableColumn<Aktor, String> columnImie;
    @FXML
    private TableColumn<Aktor, String> columnNazwisko;
    @FXML
    private TableColumn<Aktor, String> columnData;
    @FXML
    private TableColumn<Aktor, ?> columnNagrody;
    @FXML
    private Label lOpis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ocen(ActionEvent event) throws IOException {
        
        Stage stage;
            Parent root;

            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("FXMLOcena.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Oceń film");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initOwner(bOcen.getScene().getWindow());
            stage.showAndWait();
    }
    
}
