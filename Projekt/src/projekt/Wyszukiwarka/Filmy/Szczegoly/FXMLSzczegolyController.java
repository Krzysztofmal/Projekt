/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy.Szczegoly;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import projekt.Model.Aktor;
import projekt.Polaczenie.Polaczenie;
import projekt.Wyszukiwarka.Filmy.FXMLWyszukiwarkaFilmowController;

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
    private TableColumn<Aktor, String> columnNagrody;
    @FXML
    private Label lOpis;

    
    private ObservableList<Aktor> dataAktor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        dataAktor = FXCollections.observableArrayList();
         

         
        try {
            Connection conn = Polaczenie.Connect();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT Aktor.id_aktora,Aktor.imie_aktora,Aktor.nazwisko_aktora,Aktor.nagrody,Aktor.data_urodzenia FROM Aktor,Film_Aktor WHERE Aktor.id_aktora=Film_aktor.id_aktora AND Film_aktor.id_filmu=" + FXMLWyszukiwarkaFilmowController.idFilmu + ";");

            while (rs.next()){                
                dataAktor.add(new Aktor(rs.getInt("id_aktora"),rs.getString("imie_aktora"),rs.getString("nazwisko_aktora"),rs.getString("nagrody"),rs.getString("data_urodzenia")));                
            }
            
            
            
            ps.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSzczegolyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        columnImie.setCellValueFactory(new PropertyValueFactory<>("imie_aktora"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko_aktora"));
        columnNagrody.setCellValueFactory(new PropertyValueFactory<>("nagrody"));
        columnData.setCellValueFactory(new PropertyValueFactory<>("data_urodzenia"));
        
        tableAktorzy.setItems(null);
        tableAktorzy.setItems(dataAktor);
        
        
        


        try {
                    
         Connection conn = Polaczenie.Connect();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("SELECT Film.opis FROM Film WHERE film.id_filmu=" + FXMLWyszukiwarkaFilmowController.idFilmu + ";");

            lOpis.setText(rs.getString("opis"));
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSzczegolyController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
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
