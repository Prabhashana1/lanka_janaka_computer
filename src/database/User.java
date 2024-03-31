package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author prabhashana
 */
public class User {

    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;

    public void addUser(String userName, String password, String email, String phoneNo) {

        String sql = "INSERT INTO user (userName, password, email, phoneNo) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, hashPassword(password));
            ps.setString(3, email);
            ps.setString(4, phoneNo);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "User Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet readUser() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return resultSet;
    }

    public void updateUser(int userId, String userName, String password, String email, String phoneNo) {
        String sql = "UPDATE user SET username = ?, password = ?, email = ?, phoneNo = ? WHERE user_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, hashPassword(password));
            ps.setString(3, email);
            ps.setString(4, phoneNo);
            ps.setInt(5, userId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "User update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User with ID " + userId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, userId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "User delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User with ID " + userId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean verifyUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String hashedPasswordDb = resultSet.getString("password");

                if (BCrypt.checkpw(password, hashedPasswordDb)) {
                    return true;
                }
            }

        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;

    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
