/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.Polaczenie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jkero
 */
public class Polaczenie {

public static Connection Connect(){
        try {
            String url = "jdbc:sqlite:BazaFilmow";
            
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
           
            System.out.println("error" + e);
        }
        return null;
    }
    
}

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        connect();
//    }

