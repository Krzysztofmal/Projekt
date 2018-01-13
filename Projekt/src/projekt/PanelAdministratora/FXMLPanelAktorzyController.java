/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.PanelAdministratora;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<ConfigAktorzyCalosc> tableAktorzy;
    @FXML
    private TableColumn<String, ConfigAktorzyCalosc> colImie;
    @FXML
    private TableColumn<String, ConfigAktorzyCalosc> colNazwisko;
    @FXML
    private TableColumn<String, ConfigAktorzyCalosc> colDataUr;
    @FXML
    private TableColumn<String, ConfigAktorzyCalosc> colNagrody;
    @FXML
    private JFXButton btnDodajAktora;
    @FXML
    private JFXButton btnZamknij;

    private ObservableList<ConfigAktorzyCalosc> data;
    @FXML
    private TextArea taOpis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Connection con = projekt.Polaczenie.Polaczenie.Connect();
            data = FXCollections.observableArrayList();
            PreparedStatement ps = con.prepareStatement("SELECT id_aktora FROM Film_Aktor where id_filmu =" + FXMLPanelAdministratoraController.idfilmu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PreparedStatement ps3 = con.prepareStatement("SELECT * from Aktor where id_aktora =" + rs.getInt(1));
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next()) {
                    data.add(new ConfigAktorzyCalosc(rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getString(5), rs3.getString(4)));
                }
            }
            PreparedStatement ps2 = con.prepareStatement("SELECT opis from Film where id_filmu = " + FXMLPanelAdministratoraController.idfilmu);
            ResultSet rs2 = ps2.executeQuery();

            taOpis.setText(rs2.getString(1));
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDodajAktorowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colImie.setCellValueFactory(new PropertyValueFactory<>("imie_aktora"));
        colNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko_aktora"));
        colDataUr.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        colNagrody.setCellValueFactory(new PropertyValueFactory<>("nagrody"));

        tableAktorzy.setItems(null);
        tableAktorzy.setItems(data);

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
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

    @FXML
    private void PressedZamknij(MouseEvent event
    ) {
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

}
