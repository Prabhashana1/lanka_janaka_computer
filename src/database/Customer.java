package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author prabhashana
 */
public class Customer {

    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;

    public void addCustomer(String name, String email, String phoneNo) {

        String sql = "INSERT INTO customer (name, email, phoneNo) VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phoneNo);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Customer Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet readCustomer() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM customer";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return resultSet;
    }

    public void updateCustomer(int customerId, String name, String email, String phoneNo) {
        String sql = "UPDATE customer SET name = ?, email = ?, phoneNo = ? WHERE customer_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phoneNo);
            ps.setInt(4, customerId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "User update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User with ID " + customerId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, customerId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "User delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User with ID " + customerId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    String email;

    public String getCustomerEmail(int customerId) {
        String sql = "SELECT email FROM customer WHERE customer_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                email = resultSet.getString("email");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return email;
    }

}
