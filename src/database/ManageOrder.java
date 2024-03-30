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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void confirmOrder() {

        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO orders (order_date) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());
            ps.setDate(1, orderDate);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
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

    public void addOrderDetail(int partId, int quantity) {
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO order_detail (order_id, part_id, quantity) VALUES (?, ?, ?)");
            ps.setInt(1, orderId);
            ps.setInt(2, partId);
            ps.setInt(3, quantity);
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

    public void addOrderSupplier(int supplierId) {
        String sql2 = "INSERT INTO order_supplier (order_id, supplier_id) VALUES (?, ?)";
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql2);
            ps.setInt(1, orderId);
            ps.setInt(2, supplierId);
            ps.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Order confimed");
        } catch (SQLException ex) {
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex1, "Warning", JOptionPane.WARNING_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
