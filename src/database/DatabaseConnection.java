/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class DatabaseConnection {
    
    private static final String url = "jdbc:mysql://localhost:3306/janaka_computer";
    private static final String username = "root";
    private static final String password = "";
    private static Connection connection;

   
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e, "warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public static Connection getConnection(){
        return connection;
    }
    
    
    
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}
