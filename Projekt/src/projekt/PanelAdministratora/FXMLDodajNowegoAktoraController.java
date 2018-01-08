/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLDodajNowegoAktoraController implements Initializable {

    @FXML
    private JFXButton btnAkceptuj;
    @FXML
    private JFXTextField txImie;
    @FXML
    private JFXTextField txNazwisko;
    @FXML
    private JFXTextField txDataUr;
    @FXML
    private JFXTextArea txaNagrody;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PressedAkceptuj(MouseEvent event) throws IOException {
        try {
            Connection con = projekt.Polaczenie.Polaczenie.Connect();
            if (txImie.getText().isEmpty() || txNazwisko.getText().isEmpty() || txDataUr.getText().isEmpty() || txaNagrody.getText().isEmpty()) {
                projekt.Projekt.Alert("NIEPOPRAWNE DANE", "Uzupełnij wszystkie pola odpowiednimi danymi.");
            } else {
                con.createStatement().executeUpdate("INSERT INTO Aktor(imie_aktora,nazwisko_aktora, data_urodzenia, nagrody) Values " + "('"
                        + txImie.getText() + "','" + txNazwisko.getText() + "','" + txDataUr.getText() + "','" + txaNagrody.getText() + "')");
                con.close();
                Parent tabela = FXMLLoader.load(getClass().getResource("FXMLDodajAktorow.fxml"));
                Scene zamowienie = new Scene(tabela);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(zamowienie);
                stage.show();
                stage.setTitle("Panel Aktorów");
                Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
                okienko.close();

            }
        } catch (SQLException e) {
            System.err.println("ERROR" + e);

        }
    }
}
