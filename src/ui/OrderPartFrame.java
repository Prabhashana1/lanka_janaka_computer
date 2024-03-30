/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import database.ManageOrder;
import database.ManageStockPart;
import database.ManageSupplier;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author prabhashana
 */
public class OrderPartFrame extends javax.swing.JFrame {

    private final database.ManageStockPart stockPart;
    private final database.ManageSupplier manageSupplier;
    private final database.ManageOrder manageOrder;

    /**
     * Creates new form OrderPartFrame
     */
    public OrderPartFrame() {
        this.manageSupplier = new ManageSupplier();
        this.stockPart = new ManageStockPart();
        this.manageOrder = new ManageOrder();
        initComponents();
        loadStockPart();
        loadSupplier();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtSearchPartOrder = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableOrderPart = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableOrderSupplier = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtSearchSupplierOrder = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableOrderDetail = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lableOrderID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEnterSupplier = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOrderPartId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lableOrderPartName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnConfirmOrder = new javax.swing.JButton();
        btnUpdateDeletePart = new javax.swing.JButton();
        btnDeletePart = new javax.swing.JButton();
        btnClearField = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtSearchOrder = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setText("Search Part:");

        txtSearchPartOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchPartOrderActionPerformed(evt);
            }
        });
        txtSearchPartOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchPartOrderKeyReleased(evt);
            }
        });

        tableOrderPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part Name", "Current Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableOrderPart);
        if (tableOrderPart.getColumnModel().getColumnCount() > 0) {
            tableOrderPart.getColumnModel().getColumn(0).setMinWidth(100);
            tableOrderPart.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableOrderPart.getColumnModel().getColumn(0).setMaxWidth(100);
            tableOrderPart.getColumnModel().getColumn(2).setMinWidth(100);
            tableOrderPart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableOrderPart.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        tableOrderSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableOrderSupplier);
        if (tableOrderSupplier.getColumnModel().getColumnCount() > 0) {
            tableOrderSupplier.getColumnModel().getColumn(0).setMinWidth(100);
            tableOrderSupplier.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableOrderSupplier.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setText("Search Supplier:");

        txtSearchSupplierOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSupplierOrderKeyReleased(evt);
            }
        });

        tableOrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Date", "Part Name", "Orded Quantity", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableOrderDetail);
        if (tableOrderDetail.getColumnModel().getColumnCount() > 0) {
            tableOrderDetail.getColumnModel().getColumn(0).setMinWidth(100);
            tableOrderDetail.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableOrderDetail.getColumnModel().getColumn(0).setMaxWidth(100);
            tableOrderDetail.getColumnModel().getColumn(3).setMinWidth(100);
            tableOrderDetail.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableOrderDetail.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Order ");

        lableOrderID.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        lableOrderID.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Order ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(321, 321, 321)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lableOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addComponent(lableOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Enter Supplier ID:");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Part ID:");

        txtOrderPartId.setNextFocusableComponent(txtOrderQuantity);
        txtOrderPartId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrderPartIdFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setText("Part Name:");

        lableOrderPartName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lableOrderPartName.setForeground(new java.awt.Color(0, 0, 153));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setText("Quantity:");

        txtOrderQuantity.setNextFocusableComponent(btnAdd);
        txtOrderQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrderQuantityFocusLost(evt);
            }
        });
        txtOrderQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrderQuantityKeyPressed(evt);
            }
        });

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Part ID", "Part Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tableOrder);

        btnConfirmOrder.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnConfirmOrder.setText("Confirm Order");
        btnConfirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmOrderActionPerformed(evt);
            }
        });

        btnUpdateDeletePart.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnUpdateDeletePart.setText("Update Existing Part");

        btnDeletePart.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnDeletePart.setForeground(new java.awt.Color(255, 0, 51));
        btnDeletePart.setText("Delete Existing Part");

        btnClearField.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnClearField.setText("Clear Fileds");
        btnClearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel11.setText("Search Order:");

        txtSearchOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchOrderKeyReleased(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setNextFocusableComponent(txtOrderPartId);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnterSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOrderPartId, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnConfirmOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lableOrderPartName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12)
                                .addComponent(txtOrderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdateDeletePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeletePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(22, 22, 22)))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchPartOrder))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSearchSupplierOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchPartOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEnterSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtOrderPartId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lableOrderPartName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtOrderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirmOrder)
                            .addComponent(btnUpdateDeletePart)
                            .addComponent(btnDeletePart)
                            .addComponent(btnClearField))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchSupplierOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSearchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchPartOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchPartOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPartOrderActionPerformed

    private void txtSearchPartOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPartOrderKeyReleased
        DefaultTableModel model = (DefaultTableModel) tableOrderPart.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tableOrderPart.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearchPartOrder.getText().toLowerCase()));
    }//GEN-LAST:event_txtSearchPartOrderKeyReleased

    private void txtSearchSupplierOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSupplierOrderKeyReleased
        DefaultTableModel model = (DefaultTableModel) tableOrderSupplier.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tableOrderSupplier.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearchSupplierOrder.getText().toLowerCase()));
    }//GEN-LAST:event_txtSearchSupplierOrderKeyReleased

    private void txtSearchOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchOrderKeyReleased
        DefaultTableModel model = (DefaultTableModel) tableOrderDetail.getModel();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tableOrderDetail.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearchOrder.getText().toLowerCase()));
    }//GEN-LAST:event_txtSearchOrderKeyReleased

    private void btnClearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldActionPerformed
        clearField();
    }//GEN-LAST:event_btnClearFieldActionPerformed

    private void txtOrderQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderQuantityKeyPressed

    }//GEN-LAST:event_txtOrderQuantityKeyPressed

    private void txtOrderQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderQuantityFocusLost

    }//GEN-LAST:event_txtOrderQuantityFocusLost

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed

    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (checkField()) {
            String partId = txtOrderPartId.getText();
            String partName = lableOrderPartName.getText();
            String quantity = txtOrderQuantity.getText();
            DefaultTableModel model = (DefaultTableModel) tableOrder.getModel();
            model.addRow(new Object[]{partId, partName, quantity});
            txtOrderPartId.setText("");
            lableOrderPartName.setText("");
            txtOrderQuantity.setText("");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtOrderPartIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderPartIdFocusLost
        int partId = Integer.parseInt(txtOrderPartId.getText());
        lableOrderPartName.setText(manageOrder.getPartName(partId));
    }//GEN-LAST:event_txtOrderPartIdFocusLost

    private void btnConfirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmOrderActionPerformed

        

    }//GEN-LAST:event_btnConfirmOrderActionPerformed

    public void loadStockPart() {
       ResultSet resultSet = stockPart.readStockPart();
        DefaultTableModel model = (DefaultTableModel) tableOrderPart.getModel();
        model.setRowCount(0);

        try {
            while (resultSet.next()) {
                int partId = resultSet.getInt("part_id");
                String partName = resultSet.getString("name");
                int partQuantity = resultSet.getInt("quantity");
                model.addRow(new Object[]{partId, partName, partQuantity});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void loadSupplier() {
        ResultSet resultSet = manageSupplier.readSupplier();
        DefaultTableModel model = (DefaultTableModel) tableOrderSupplier.getModel();
        model.setRowCount(0);

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                model.addRow(new Object[]{id, name, email});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e, "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean checkField() {
        String supplierId = txtEnterSupplier.getText();
        String partId = txtOrderPartId.getText();
        String partName = lableOrderPartName.getText();
        String quantity = txtOrderQuantity.getText();
        if (supplierId.isEmpty() || partId.isEmpty() || partName.isEmpty() || quantity.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "All fields are mandatory", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;

        }
    }

    private void clearField() {
        txtEnterSupplier.setText("");
        txtOrderPartId.setText("");
        lableOrderPartName.setText("");
        txtOrderQuantity.setText("");
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderPartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderPartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearField;
    private javax.swing.JButton btnConfirmOrder;
    private javax.swing.JButton btnDeletePart;
    private javax.swing.JButton btnUpdateDeletePart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lableOrderID;
    private javax.swing.JLabel lableOrderPartName;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableOrderDetail;
    private javax.swing.JTable tableOrderPart;
    private javax.swing.JTable tableOrderSupplier;
    private javax.swing.JTextField txtEnterSupplier;
    private javax.swing.JTextField txtOrderPartId;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtSearchOrder;
    private javax.swing.JTextField txtSearchPartOrder;
    private javax.swing.JTextField txtSearchSupplierOrder;
    // End of variables declaration//GEN-END:variables
}
