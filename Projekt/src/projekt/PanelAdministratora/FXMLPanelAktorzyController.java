/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private void PressedDodajAktora(MouseEvent event) throws IOException {
        Parent tabela = FXMLLoader.load(getClass().getResource("FXMLDodajAktorow.fxml"));
        Scene zamowienie = new Scene(tabela);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(zamowienie);
        stage.show();
        stage.setTitle("Dodawanie Aktorów");
    }

    @FXML
    private void PressedZamknij(MouseEvent event) {
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

}
