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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Config> tableAll;
    @FXML
    private TableColumn<String, Config> coltytul;
    @FXML
    private TableColumn<String, Config> colrezyser;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<String, Config> colDlugosc;
    @FXML
    private TableColumn<String, Config> colGatunek;
    private ObservableList<Config> data;
    @FXML
    private TableColumn<String, Config> colOpis;
    @FXML
    private JFXButton btnSzczegoly;
    public static int idfilmu;

    /**
     * Initializes the controller class.
     */
    public void Refresh() {
        try {
            Connection con = projekt.Polaczenie.Polaczenie.Connect();
            data = FXCollections.observableArrayList();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Film");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(new Config(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXMLPanelAdministratoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
        coltytul.setCellValueFactory(new PropertyValueFactory<>("tytul"));
        colrezyser.setCellValueFactory(new PropertyValueFactory<>("rezyser"));
        colDlugosc.setCellValueFactory(new PropertyValueFactory<>("dlugosc_filmu"));
        colGatunek.setCellValueFactory(new PropertyValueFactory<>("gatunek"));
        colOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));

        tableAll.setItems(null);
        tableAll.setItems(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Refresh();

    }

    @FXML
    private void PressedExit(MouseEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void PressedAdd(MouseEvent event) throws IOException {
        Parent tabela = FXMLLoader.load(getClass().getResource("FXMLDodajFilm.fxml"));
        Scene zamowienie = new Scene(tabela);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(zamowienie);
        stage.show();
        stage.setTitle("Dodawanie nowego filmu");
        Stage okienko = (Stage) ((Node) event.getSource()).getScene().getWindow();
        okienko.close();
    }

    @FXML
    private void PressedDelete(MouseEvent event) {

        if (tableAll.getSelectionModel().getSelectedItem() == null) {
            projekt.Projekt.Alert("NIE WYBRANO FILMU", "Proszę wybrać film do usunięcia.");
        } else {
            try {

                Connection con = projekt.Polaczenie.Polaczenie.Connect();
                int rs = con.createStatement().executeUpdate("delete from Film where id_filmu = " + tableAll.getSelectionModel().getSelectedItem().getId_filmu());

                Refresh();
                con.close();
            } catch (SQLException e) {
                System.err.println("ERROR" + e);
            }
        }

    }

    @FXML
    private void PressedSzczegoly(MouseEvent event) throws IOException {
        if (tableAll.getSelectionModel().getSelectedItem() == null) {
            projekt.Projekt.Alert("NIE WYBRANO FILMU", "Proszę wybrać film, którego szczegóły mają zostać wyświetlone.");
        } else {
            idfilmu = tableAll.getSelectionModel().getSelectedItem().getId_filmu();
            Parent tabela = FXMLLoader.load(getClass().getResource("FXMLPanelAktorzy.fxml"));
            Scene zamowienie = new Scene(tabela);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(zamowienie);
            stage.show();
            stage.setTitle("Szczegóły filmu");
        }
    }

}
