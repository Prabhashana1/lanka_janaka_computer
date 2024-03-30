
package ui;

import database.User;
import javax.swing.JOptionPane;

/**
 *
 * @author prabhashana
 */
public class LoginFrame extends javax.swing.JFrame {

    private database.User user = new User();

    public LoginFrame() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        labaleLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabelUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(215, 251, 226));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        RightPanel.setBackground(new java.awt.Color(72, 127, 140));
        RightPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        labaleLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labaleLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot 2024-01-31 at 8.45.53 PM.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Publico Text", 0, 24)); // NOI18N
        jLabel5.setText("Lanka Janaka Computer Repairs");

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(labaleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labaleLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(RightPanel);
        RightPanel.setBounds(0, 0, 360, 360);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 30, 120, 50);

        jLabelPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelPassword.setText("Password");
        jPanel1.add(jLabelPassword);
        jLabelPassword.setBounds(370, 180, 90, 18);

        txtUserName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jPanel1.add(txtUserName);
        txtUserName.setBounds(370, 120, 310, 40);

        txtPassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jPanel1.add(txtPassword);
        txtPassword.setBounds(370, 200, 310, 40);

        btnLogin.setBackground(new java.awt.Color(164, 197, 233));
        btnLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(470, 270, 110, 40);

        jLabelUserName.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelUserName.setText("User Name");
        jPanel1.add(jLabelUserName);
        jLabelUserName.setBounds(370, 100, 80, 18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (checkFields(userName, password)) {
            if (user.verifyUser(userName, password)) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username or password incorrect", "warning", JOptionPane.WARNING_MESSAGE);
                txtClear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "All fields are mandatory", "warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtClear() {
        txtUserName.setText("");
        txtPassword.setText("");
    }

    private boolean checkFields(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            return false;

        } else {
            return true;
        }
    }

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labaleLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
