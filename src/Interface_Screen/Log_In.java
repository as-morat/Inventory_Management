package Interface_Screen;


import Home_Page.HomePage;
import Inventory_Main.Main;
import db.Connection_Provider;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Log_In extends javax.swing.JPanel {

    public Log_In() {
        initComponents();
//        jTextField1.setEditable(true);   
    }
    private Main main;

public Log_In(Main main) {
    this.main = main;
    initComponents();
    jTextField1.setEditable(true);

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        checkbox1 = new java.awt.Checkbox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log In");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\front user.png")); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Email Address");
        jTextField1.setBorder(null);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 280, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 280, -1));

        jPasswordField1.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setText("Password");
        jPasswordField1.setBorder(null);
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 280, 30));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 280, -1));

        checkbox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        checkbox1.setForeground(new java.awt.Color(255, 255, 255));
        checkbox1.setLabel("Remember me");
        checkbox1.setName(""); // NOI18N
        checkbox1.setPreferredSize(new java.awt.Dimension(83, 14));
        add(checkbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 110, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Forgot passwprd?");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-log-in-16.png")); // NOI18N
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 280, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\username.png")); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\password.png")); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jTextField1.setEditable(true);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getText().equals("Email Address")) {
        jTextField1.setText("");
    }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        String pass = String.valueOf(jPasswordField1.getPassword());
    if (pass.trim().isEmpty()) {
        jPasswordField1.setEchoChar((char)0);
        jPasswordField1.setText("Password");
    }
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        String pass = String.valueOf(jPasswordField1.getPassword());
    if (pass.equals("Password")) {
        jPasswordField1.setText("");
        jPasswordField1.setEchoChar('•');
    }
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().trim().isEmpty()) {
        jTextField1.setText("Email Address");
    }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginAction();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void loginAction() {
    String email = jTextField1.getText().trim();
    char[] passwordChars = jPasswordField1.getPassword();
    String password = new String(passwordChars).trim();
    
    // Clear the password array for security
    Arrays.fill(passwordChars, '0');

    // Validate if fields are blank
    if (email.isBlank() || password.isBlank()) {
        JOptionPane.showMessageDialog(this, "Please enter both email and password.");
        return;
    }

    // Validate email format
    if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
        JOptionPane.showMessageDialog(this, "Invalid email format.");
        return;
    }

    // Note: This is still vulnerable to SQL injection - see warning below
    String query = String.format("SELECT * FROM appuser WHERE email = '%s' AND password = '%s'", 
                               email.replace("'", "''"), 
                               password.replace("'", "''"));

    try {
        ResultSet rs = Connection_Provider.execute(query);
        
        if (rs != null && rs.next()) {
            String role = rs.getString("userRole");
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose(); // close the current window
            }
            new HomePage(role).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);resetInput();
        }
        
        if (rs != null) {
            rs.close();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
    }
}

    private void resetInput() {
         jTextField1.setText("Email Address");
         jPasswordField1.setText("Password");
         jPasswordField1.setEchoChar((char) 0);
    }
}