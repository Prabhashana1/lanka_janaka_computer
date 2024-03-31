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
public class ManageJob {
    
    
    private Connection con = DatabaseConnection.getConnection();
    private PreparedStatement ps = null;
    private ResultSet resultSet = null;
    
    
    public int getNextJobId(){
        int nextId = 1;
        String sql = "SELECT MAX(job_id) FROM repair_job";
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
    
    
    public ResultSet readJob() {
        String sql = "SELECT * FROM repair_job";
        try {
            ps = con.prepareStatement(sql);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
        return resultSet;
    }
    
    
    public void addRepairJob(int customerId, int repairItemId, String scheduleDate, String status, String description) {

        String sql = "INSERT INTO repair_job (customer_id, repair_itemId, schedule_date, status, description) VALUES (?, ?, ?, ?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setInt(2, repairItemId);
            ps.setString(3, scheduleDate);
            ps.setString(4, status);
            ps.setString(5, description);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Job Add successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    public void deleteJob(int jobId){
        String sql = "DELETE FROM repair_job WHERE job_id = ?";

        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, jobId);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Job delete successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Job with ID " + jobId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    
    public void updateJob(int customerId, int repairItemId, String scheduleDate, String status, String description, int jobId) {
        String sql = "UPDATE repair_job SET customer_id = ?, repair_itemId = ?, schedule_date = ?, status = ?, description = ? WHERE job_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.setInt(2, repairItemId);
            ps.setString(3, scheduleDate);
            ps.setString(4, status);
            ps.setString(5, description);
            ps.setInt(6, jobId);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Job update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Job with ID " + jobId + " not found.", "Warnig", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Warning", JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    
    
    
}
