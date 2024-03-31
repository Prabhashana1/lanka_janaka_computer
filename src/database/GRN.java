/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class GRN {
    
    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    public String getPartName(int id) {
        String name = null;
        String sql = "SELECT name FROM stock WHERE part_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name");
            } else {
                JOptionPane.showMessageDialog(null, "Part ID not valid or incorrect", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return name;
    }
    
    
    public ResultSet readGRNHistory() {
        String sql = "SELECT g.GRN_id, s.name, gd.quantity, gd.price, g.date FROM GRN g JOIN GRN_detail gd ON g.GRN_id = gd.GRN_id JOIN stock s ON gd.part_id = s.part_id;";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        return resultSet;
    }
    
    
    public int nextGRNId() {
        int nextId = 1;
        String sql = "SELECT MAX(GRN_id) FROM GRN";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int maxId = resultSet.getInt(1);
                nextId = maxId + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return nextId;
    }
    
    
    int grnID;
    
    public void commitGRN(){
        
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO GRN (date) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());
            ps.setDate(1, orderDate);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                grnID = generatedKeys.getInt(1);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to retrieve generated order ID", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public void addGRNDetails(int partId, int quantity, double price){
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO GRN_detail (GRN_id, part_id, quantity, price) VALUES (?, ?, ?, ?)");
            ps.setInt(1, grnID);
            ps.setInt(2, partId);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }

    }
    
    public void updateStock(int partId, int quantity, double price){
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE stock SET quantity = quantity + ?, price = ? WHERE part_id = ?");
            ps.setInt(1, quantity);
            ps.setDouble(2, price);
            ps.setInt(3, partId);
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex1, "Warning", JOptionPane.WARNING_MESSAGE);
            }
            try {
                con.commit();
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2, "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    
    
    
    
}
