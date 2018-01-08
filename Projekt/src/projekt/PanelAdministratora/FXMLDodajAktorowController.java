/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLDodajAktorowController implements Initializable {
    @FXML
    private TableView<?> tableAktorzy;
    @FXML
    private TableColumn<?, ?> colImie;
    @FXML
    private TableColumn<?, ?> colNazwisko;
    @FXML
    private JFXButton btnDodaj;
    @FXML
    private JFXTextField txSzukany;
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
    private void PressedDodaj(MouseEvent event) {
    }

    @FXML
    private void PressedDodajNowegoAktora(MouseEvent event) {
    }

    @FXML
    private void PressedExit(MouseEvent event) {
    }
    
}
