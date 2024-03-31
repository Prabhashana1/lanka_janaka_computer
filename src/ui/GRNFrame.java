package ui;

import database.GRN;
import database.ManageStockPart;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author prabhashana
 */
public class GRNFrame extends javax.swing.JFrame {

    private database.GRN grn;
    private database.ManageStockPart magManageStockPart;
    DecimalFormat df;

    public GRNFrame() {
        this.grn = new GRN();
        this.magManageStockPart = new ManageStockPart();
        this.df = new DecimalFormat("0.00");
        initComponents();
        loadStockPart();
        loadGrnHistory();
        nextGrnId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lableGRNNo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSearchPart = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableGRNPart = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGRNHistory = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableGRN = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lablePartName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPartId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSearchGRN = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCommit = new javax.swing.JButton();
        btnClearField = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Goods Recieve Note");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GRN NO: ");

        lableGRNNo.setFont(new java.awt.Font("Helvetica Neue", 1, 25)); // NOI18N
        lableGRNNo.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(194, 194, 194)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lableGRNNo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableGRNNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel4.setText("Part ID:");

        txtPrice.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        txtPrice.setNextFocusableComponent(btnAdd);
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel7.setText("Quantity:");

        txtQuantity.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        txtQuantity.setNextFocusableComponent(txtPrice);
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel9.setText("Search Here");

        txtSearchPart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPartKeyReleased(evt);
            }
        });

        tableGRNPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part Name", "Quantity", "Price"
            }
        ));
        jScrollPane3.setViewportView(tableGRNPart);
        if (tableGRNPart.getColumnModel().getColumnCount() > 0) {
            tableGRNPart.getColumnModel().getColumn(0).setMinWidth(100);
            tableGRNPart.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableGRNPart.getColumnModel().getColumn(0).setMaxWidth(100);
            tableGRNPart.getColumnModel().getColumn(2).setMinWidth(100);
            tableGRNPart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableGRNPart.getColumnModel().getColumn(2).setMaxWidth(100);
            tableGRNPart.getColumnModel().getColumn(3).setMinWidth(100);
            tableGRNPart.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableGRNPart.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        tableGRNHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN ID", "Part Name", "Quantity", "price", "Date"
            }
        ));
        jScrollPane4.setViewportView(tableGRNHistory);
        if (tableGRNHistory.getColumnModel().getColumnCount() > 0) {
            tableGRNHistory.getColumnModel().getColumn(0).setMinWidth(50);
            tableGRNHistory.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableGRNHistory.getColumnModel().getColumn(0).setMaxWidth(50);
            tableGRNHistory.getColumnModel().getColumn(2).setMinWidth(50);
            tableGRNHistory.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableGRNHistory.getColumnModel().getColumn(2).setMaxWidth(50);
            tableGRNHistory.getColumnModel().getColumn(3).setMinWidth(100);
            tableGRNHistory.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableGRNHistory.getColumnModel().getColumn(3).setMaxWidth(100);
            tableGRNHistory.getColumnModel().getColumn(4).setMinWidth(100);
            tableGRNHistory.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableGRNHistory.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        tableGRN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part Name", "Quantity", "Price"
            }
        ));
        jScrollPane5.setViewportView(tableGRN);
        if (tableGRN.getColumnModel().getColumnCount() > 0) {
            tableGRN.getColumnModel().getColumn(0).setMinWidth(100);
            tableGRN.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableGRN.getColumnModel().getColumn(0).setMaxWidth(100);
            tableGRN.getColumnModel().getColumn(2).setMinWidth(100);
            tableGRN.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableGRN.getColumnModel().getColumn(2).setMaxWidth(100);
            tableGRN.getColumnModel().getColumn(3).setMinWidth(100);
            tableGRN.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableGRN.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel11.setText("Part Name:");

        lablePartName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel13.setText("Price:");

        txtPartId.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        txtPartId.setNextFocusableComponent(txtQuantity);
        txtPartId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPartIdFocusLost(evt);
            }
        });
        txtPartId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPartIdKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setText("Search Here");

        txtSearchGRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchGRNKeyReleased(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setNextFocusableComponent(txtPartId);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 51));
        btnDelete.setText("Delete Row");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCommit.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnCommit.setText("Commit GRN");
        btnCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommitActionPerformed(evt);
            }
        });

        btnClearField.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnClearField.setText("Clear FIeld");
        btnClearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPartId, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lablePartName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnClearField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCommit, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnAdd)))
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchPart, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchGRN, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnClearField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lablePartName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPartId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchGRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (checkfield()) {
            int partId = Integer.parseInt(txtPartId.getText());
            String partName = lablePartName.getText();
            int partQuantity = Integer.parseInt(txtQuantity.getText());
            double price = Double.parseDouble(txtPrice.getText());
            DefaultTableModel model = (DefaultTableModel) tableGRN.getModel();
            model.addRow(new Object[]{partId, partName, partQuantity, df.format(price)});
            clearField();
        } else {
            JOptionPane.showMessageDialog(rootPane, "All fields are mandatory", "warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtPartIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPartIdFocusLost
        int partId = Integer.parseInt(txtPartId.getText());
        lablePartName.setText(grn.getPartName(partId));
    }//GEN-LAST:event_txtPartIdFocusLost

    private void btnClearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldActionPerformed
        clearField();
    }//GEN-LAST:event_btnClearFieldActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tableGRN.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableGRN.getModel();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please select a row to remove", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommitActionPerformed

        grn.commitGRN();
        DefaultTableModel model = (DefaultTableModel) tableGRN.getModel();
        int rowCount = tableGRN.getRowCount();

        for (int i = 0; i < rowCount; i++) {

            int partId = Integer.parseInt(tableGRN.getValueAt(i, 0).toString());
            int quantity = Integer.parseInt(tableGRN.getValueAt(i, 2).toString());
            Double price = Double.parseDouble(tableGRN.getValueAt(i, 3).toString());

            grn.addGRNDetails(partId, quantity, price);
            grn.updateStock(partId, quantity, price);
        }

        JOptionPane.showMessageDialog(null, "GRN added successful");
        model.setRowCount(0);
        loadStockPart();
        loadGrnHistory();
        nextGrnId();

    }//GEN-LAST:event_btnCommitActionPerformed

    private void txtSearchPartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPartKeyReleased
        DefaultTableModel model = (DefaultTableModel) tableGRNPart.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tableGRNPart.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearchPart.getText().toLowerCase()));
    }//GEN-LAST:event_txtSearchPartKeyReleased

    private void txtSearchGRNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchGRNKeyReleased
        DefaultTableModel model = (DefaultTableModel) tableGRNHistory.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tableGRNHistory.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearchGRN.getText().toLowerCase()));
    }//GEN-LAST:event_txtSearchGRNKeyReleased

    private void txtPartIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPartIdKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPartIdKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void nextGrnId() {
        String id = Integer.toString(grn.nextGRNId());
        lableGRNNo.setText(id);
    }

    private void clearField() {
        txtPartId.setText("");
        lablePartName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }

    private boolean checkfield() {
        String partId = txtPartId.getText();
        String partQuantity = txtQuantity.getText();
        String name = lablePartName.getText();
        String price = txtPrice.getText();
        if (partId.isEmpty() || name == null || partQuantity.isEmpty() || price.isEmpty()) {
            return false;
        }
        return true;
    }

    private void loadStockPart() {
        ResultSet resultSet = magManageStockPart.readStockPart();
        DefaultTableModel model = (DefaultTableModel) tableGRNPart.getModel();
        model.setRowCount(0);

        try {
            while (resultSet.next()) {
                int partId = resultSet.getInt("part_id");
                String partName = resultSet.getString("name");
                int partQuantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                model.addRow(new Object[]{partId, partName, partQuantity, df.format(price)});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadGrnHistory() {
        ResultSet resultSet = grn.readGRNHistory();
        DefaultTableModel model = (DefaultTableModel) tableGRNHistory.getModel();
        model.setRowCount(0);

        try {
            while (resultSet.next()) {
                int grnId = resultSet.getInt(1);
                String partName = resultSet.getString(2);
                int partQuantity = resultSet.getInt(3);
                double price = resultSet.getDouble(4);
                Date date = resultSet.getDate(5);
                model.addRow(new Object[]{grnId, partName, partQuantity, df.format(price), date});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GRNFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearField;
    private javax.swing.JButton btnCommit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lableGRNNo;
    private javax.swing.JLabel lablePartName;
    private javax.swing.JTable tableGRN;
    private javax.swing.JTable tableGRNHistory;
    private javax.swing.JTable tableGRNPart;
    private javax.swing.JTextField txtPartId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchGRN;
    private javax.swing.JTextField txtSearchPart;
    // End of variables declaration//GEN-END:variables
}
