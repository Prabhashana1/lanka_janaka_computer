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
public class ManageStockPart {

    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;

    public ResultSet readStockPart() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM stock";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return resultSet;
    }

    public void addStockPart(String name, int quantity, double price) {

        String sql = "INSERT INTO stock (name, quantity, price) VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Part Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void updateStockPart(int partId, String name, int quantity, double price) {
        String sql = "UPDATE stock SET name = ?, quantity = ?, price = ? WHERE part_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.setInt(4, partId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Part details update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Part with ID " + partId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deletePart(int partId) {
        String sql = "DELETE FROM stock WHERE part_id = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, partId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Part details delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Part with ID " + partId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
