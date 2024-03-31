package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;

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

    public ResultSet readHistory() {
        String sql = "SELECT o.order_id, o.order_date, s.name AS stock_name, od.quantity, su.name AS supplier_name FROM orders o JOIN order_detail od ON o.order_id = od.order_id JOIN stock s ON od.part_id = s.part_id JOIN order_supplier os ON o.order_id = os.order_id JOIN supplier su ON os.supplier_id = su.id;";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return resultSet;
    }

    public int nextOrderId() {
        int nextId = 1;
        String sql = "SELECT MAX(order_id) FROM orders";
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

    public String getSupplierName(int supplierID) {
        String name = null;
        String sql = "SELECT name FROM supplier WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, supplierID);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name");
            } else {
                JOptionPane.showMessageDialog(null, "name not found relevent with supplier ID: " + supplierID, "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return name;
    }

}
