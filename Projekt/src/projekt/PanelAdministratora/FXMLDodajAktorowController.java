/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Łukasz
 */
public class FXMLDodajAktorowController implements Initializable {

    @FXML
    private TableView<ConfigAktorzy> tableAktorzy;
    @FXML
    private TableColumn<String, ConfigAktorzy> colImie;
    @FXML
    private TableColumn<String, ConfigAktorzy> colNazwisko;
    @FXML
    private JFXButton btnDodaj;
    @FXML
    private JFXButton btnDodajAktora;
    @FXML
    private JFXButton btnZamknij;

    private ObservableList<ConfigAktorzy> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Refresh();
        // TODO
    }

    public void Refresh() {
        try {
            Connection con = projekt.Polaczenie.Polaczenie.Connect();
            data = FXCollections.observableArrayList();
            PreparedStatement ps = con.prepareStatement("SELECT id_aktora, imie_aktora, nazwisko_aktora FROM Aktor");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new ConfigAktorzy(rs.getInt(1),rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLDodajAktorowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colImie.setCellValueFactory(new PropertyValueFactory<>("imie_aktora"));
        colNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko_aktora"));

        tableAktorzy.setItems(null);
        tableAktorzy.setItems(data);

    }

    @FXML
    private void PressedDodaj(MouseEvent event) {
    }

    @FXML
    private void PressedDodajNowegoAktora(MouseEvent event) throws IOException {
        Parent tabela = FXMLLoader.load(getClass().getResource("FXMLDodajNowegoAktora.fxml"));
        Scene zamowienie = new Scene(tabela);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(zamowienie);
        stage.show();
        stage.setTitle("Dodawanie Aktorów");
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

    @FXML
    private void PressedExit(MouseEvent event) {
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

}
