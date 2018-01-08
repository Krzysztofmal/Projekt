/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLPanelAktorzyController implements Initializable {
    @FXML
    private Label lOpis;
    @FXML
    private TableView<?> tableAktorzy;
    @FXML
    private TableColumn<?, ?> colImie;
    @FXML
    private TableColumn<?, ?> colNazwisko;
    @FXML
    private TableColumn<?, ?> colDataUr;
    @FXML
    private TableColumn<?, ?> colNagrody;
    @FXML
    private JFXButton btnDodajAktora;
    @FXML
    private JFXButton btnZamknij;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PressedDodajAktora(MouseEvent event) {
    }

    @FXML
    private void PressedZamknij(MouseEvent event) {
    }
    
}
