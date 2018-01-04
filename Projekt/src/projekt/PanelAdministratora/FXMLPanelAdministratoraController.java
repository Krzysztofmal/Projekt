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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLPanelAdministratoraController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private TableView<?> tableAll;
    @FXML
    private TableColumn<?, ?> coltytul;
    @FXML
    private TableColumn<?, ?> colrezyser;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PressedExit(MouseEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void PressedAdd(MouseEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLDodajFilm.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Dodawanie Filmu");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(btnAdd.getScene().getWindow());
        stage.showAndWait();

    }

    @FXML
    private void PressedUpdate(MouseEvent event) {
    }

    @FXML
    private void PressedDelete(MouseEvent event) {
    }

}
