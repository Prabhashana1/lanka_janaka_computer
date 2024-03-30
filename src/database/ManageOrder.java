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
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class ManageOrder {

    private final Connection con = DatabaseConnection.getConnection();
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

int orderId;

    public void confirmOrder(int supplierId) throws SQLException {

        try {
            con.setAutoCommit(false);
            try {
                ps = con.prepareStatement("INSERT INTO orders (order_date) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());
                ps.setDate(1, orderDate);
                ps.executeUpdate();

                try {
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1);
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Failed to retrieve generated order ID" + e, "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
            }
            

            try {
                String sql2 = "INSERT INTO order_supplier (order_id, supplier_id) VALUES (?, ?)";
                ps = con.prepareStatement(sql2);
                ps.setInt(1, orderId);
                ps.setInt(2, supplierId);
                ps.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
            }

            con.commit();
            JOptionPane.showMessageDialog(null, "Order confimed");

        } catch (SQLException e) {
            if (con != null) {
                con.rollback();
            }
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

}
