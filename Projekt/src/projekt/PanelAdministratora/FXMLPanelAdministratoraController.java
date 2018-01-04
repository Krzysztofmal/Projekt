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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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
    }

    @FXML
    private void PressedAdd(MouseEvent event) {
    }

    @FXML
    private void PressedUpdate(MouseEvent event) {
    }

    @FXML
    private void PressedDelete(MouseEvent event) {
    }
    
}
