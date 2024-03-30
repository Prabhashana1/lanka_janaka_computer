/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class ManageSupplier {
    
    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;

    
    
    public void addSupplier(String name, String phoneNo, String email, String address) {

        String sql = "INSERT INTO supplier (name, phone_number, email, address) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phoneNo);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Supplier Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet readSupplier() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM supplier";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        return resultSet;
    }

    public void updateSupplier(int id, String name, String phoneNo, String email, String address) {
        String sql = "UPDATE supplier SET name = ?, phone_number = ?, email = ?, address = ? WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phoneNo);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setInt(5, id);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Supplier datails update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Supplier with ID " + id + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }

    public void deleteSupplier(int id) {
        String sql = "DELETE FROM supplier WHERE id = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Supplier delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Supplier with ID " + id + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    
    
    
}
