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
public class Invoice {

    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;

    int invoiceId;

    public void makeInvoice(int customerId, int jobId) {

        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO invoice (customer_id, job_id,invoice_date) VALUES (?, ?,?)", Statement.RETURN_GENERATED_KEYS);
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            ps.setInt(1, customerId);
            ps.setInt(2, jobId);
            ps.setDate(3, date);
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                invoiceId = generatedKeys.getInt(1);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to retrieve generated invoice ID", "Warning", JOptionPane.WARNING_MESSAGE);
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

    public void addInvoiceDetail(int partId, int quantity, double price) {
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO invoice_details (invoice_id, part_id, quantity, price) VALUES (?, ?, ?, ?)");
            ps.setInt(1, invoiceId);
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

    public void updateStock(int partId, int quantity) {
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE stock SET quantity = quantity - ? WHERE part_id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, partId);
            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex1, "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    public void updateJobStatus(int jobId) {
        String status = "Paid";
        try {
            con.setAutoCommit(false);
            ps = con.prepareStatement("UPDATE repair_job SET status = ? WHERE job_id = ?");
            ps.setString(1, status);
            ps.setInt(2, jobId);
            ps.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
            try {
                con.rollback();
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, ex1, "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

    public String getPartPrice(int id) {
        String price = null;
        String sql = "SELECT price FROM stock WHERE part_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                price = resultSet.getString("price");
            } else {
                JOptionPane.showMessageDialog(null, "Part ID not valid or incorrect", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return price;
    }

    public int stockQuantityCheck(int partId) {
        int quantity = 0;
        String sql = "SELECT quantity FROM stock WHERE part_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, partId);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                quantity = resultSet.getInt("quantity");
            } else {
                JOptionPane.showMessageDialog(null, "Part ID not valid or incorrect", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return quantity;
    }
    
    public int verifyCustomerId(int jobId){
        int customerId = 0;
        String sql = "SELECT customer_id FROM repair_job WHERE job_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, jobId);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                customerId = resultSet.getInt("customer_id");
            } else {
                JOptionPane.showMessageDialog(null, "Job ID not valid or incorrect", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return customerId;
    }

}
