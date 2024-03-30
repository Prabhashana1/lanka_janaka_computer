/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class RepairItem {
    
    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;
    
    
    
    public void addRepairItem(int customerId, String type, String brand, String entyDate) {

        String sql = "INSERT INTO repair_item (customer_id, type, brand, entry_date) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setString(2, type);
            ps.setString(3, brand);
            ps.setString(4, entyDate);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Repair item Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet readRepairItem() {
        ResultSet resultSet = null;
        String sql = "SELECT r.repair_itemId, r.type, r.brand, r.entry_date, r.customer_id, c.name FROM repair_item r INNER JOIN customer c ON r.customer_id = c.customer_id";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        return resultSet;
    }
    
    
    
    public void updateRepairItem(int customerId, String type, String brand, String entyDate, int repair_itemId) {
        String sql = "UPDATE repair_item SET customer_id = ?, type = ?, brand = ?, entry_date = ? WHERE repair_itemId = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setString(2, type);
            ps.setString(3, brand);
            ps.setString(4, entyDate);
            ps.setInt(5, repair_itemId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Repair item update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Repair Item with ID " + repair_itemId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    
    public void deleteRepairItem(int repairItemId) {
        String sql = "DELETE FROM repair_item WHERE repair_itemId = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, repairItemId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Repair item delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Item with ID " + repairItemId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    
    
    
    
    
}
