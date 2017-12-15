/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import Algorytmy.Algorytmy;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import projekt.Polaczenie.Polaczenie;

/**
 *
 * @author jkero
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField tfTytul;
    

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        Connection conn = Polaczenie.Connect();
        
        
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery("SELECT * FROM film;");
        
        
        
        while (rs.next()){
            if (Algorytmy.AlgorytmMiaryOdleglosciLevenshteina(rs.getString("tytuł"), tfTytul.getText()) < 3){
                System.out.println(rs.getString("tytuł"));
            }
            Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText());
            if ( Algorytmy.AlgorytmKnuthaMorrisaPratta(rs.getString("tytuł"), tfTytul.getText()) == 1 ) {
                System.out.println("Morrisa Pratta : " + rs.getString("tytuł"));
            }
            
        }
        
        
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
        
        
        
        ps.close();
        rs.close();
        conn.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        
        
    }    
    
}
