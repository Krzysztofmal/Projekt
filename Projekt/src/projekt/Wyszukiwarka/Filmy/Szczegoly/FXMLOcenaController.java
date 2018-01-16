/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Wyszukiwarka.Filmy.Szczegoly;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import projekt.Polaczenie.Polaczenie;
import projekt.Wyszukiwarka.Filmy.FXMLWyszukiwarkaFilmowController;

/**
 * FXML Controller class
 *
 * @author BlackHawk
 */
public class FXMLOcenaController implements Initializable {

    @FXML
    private JFXButton bOcen;
    @FXML
    private JFXButton bAnuluj;
    @FXML
    private JFXComboBox<String> cbOcena;

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbOcena.getItems().addAll(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        );        
        cbOcena.setStyle("-fx-font: 18px \"System\";");
        
    }

    @FXML
    private void ocen(ActionEvent event) throws SQLException {
        
        //FXMLWyszukiwarkaFilmowController.idFilmu;
        
         Connection conn = Polaczenie.Connect();
        
         //Uniemożliwić głosowanie jak jakieś pole ma własność false, (przy uruchomieniu wyszukiwarki filmów zmieniać na true
        
        Statement ps = conn.createStatement();
        ps.executeUpdate("INSERT INTO Oceny (id_filmu, ocena) VALUES (" + FXMLWyszukiwarkaFilmowController.idFilmu + ", " + cbOcena.getSelectionModel().getSelectedItem().toString() + ");");
        
        
        
    }

    @FXML
    private void anuluj(ActionEvent event) {
        Stage stage = (Stage) bAnuluj.getScene().getWindow();
        stage.close();
    }

}
