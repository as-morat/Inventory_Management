
package Customer;

import db.Connection_Provider;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Customer extends javax.swing.JPanel {
     private Connection con;
    private DefaultTableModel model;
    private int customerPk = 0;
    
    // For undo functionality
    private String lastOperation = "";
    private Object[] previousState = null;
    
    public Customer() {
        initComponents();
        initializeDatabase();
        setupTableModel();
        setupUI();
    }
    
    private void initializeDatabase() {
        try {
            con = Connection_Provider.getCon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void setupTableModel() {
        model = (DefaultTableModel) ctable.getModel();
        loadCustomerData();
    }
    
    private void setupUI() {
        // Set proper labels
        jLabel1.setText("Name:");
        jLabel2.setText("Phone:");
        jLabel3.setText("Email:");
        
        // Set proper button texts
        save.setText("Save");
        update.setText("Update");
        undo.setText("Undo");
        delete.setText("Delete");
        
        // Disable update/delete initially
        update.setEnabled(false);
        delete.setEnabled(false);
        
        // Clear placeholder text
        cname.setText("");
        cphone.setText("");
        cemail.setText("");
    }
    
    private void loadCustomerData() {
        try {
            model.setRowCount(0); // Clear existing data
            
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM customer")) {
                
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("customer_pk"),
                        rs.getString("name"),
                        rs.getString("mobile"),
                        rs.getString("email")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error loading customers: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private boolean validateFields() {
        // Check empty fields
        if (cname.getText().trim().isEmpty() || 
            cphone.getText().trim().isEmpty() || 
            cemail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate phone number (10 digits)
        if (!cphone.getText().matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone must be 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate email format
        if (!cemail.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void clearFields() {
        cname.setText("");
        cphone.setText("");
        cemail.setText("");
        customerPk = 0;
        save.setEnabled(true);
        update.setEnabled(false);
        delete.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ctable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        cname = new javax.swing.JTextField();
        cemail = new javax.swing.JTextField();
        cphone = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(710, 330));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        ctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Mobile No", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ctable.setAutoscrolls(false);
        ctable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ctable);
        if (ctable.getColumnModel().getColumnCount() > 0) {
            ctable.getColumnModel().getColumn(0).setMinWidth(65);
            ctable.getColumnModel().getColumn(0).setPreferredWidth(65);
            ctable.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        cname.setBackground(new java.awt.Color(255, 255, 204));
        cname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnameActionPerformed(evt);
            }
        });

        cemail.setBackground(new java.awt.Color(255, 255, 204));
        cemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cemailActionPerformed(evt);
            }
        });

        cphone.setBackground(new java.awt.Color(255, 255, 204));
        cphone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        cphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cphoneActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(153, 255, 102));
        save.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-save-18.png"))); // NOI18N
        save.setText("Save");
        save.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(153, 0, 153));
        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setForeground(java.awt.Color.white);
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-edit-18.png"))); // NOI18N
        update.setText("Update");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        undo.setBackground(new java.awt.Color(0, 255, 204));
        undo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        undo.setForeground(java.awt.Color.white);
        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-undo-18.png"))); // NOI18N
        undo.setText("Undo");
        undo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 153));
        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setForeground(java.awt.Color.white);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-delete-18 (1).png"))); // NOI18N
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mobile No.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        reset.setBackground(new java.awt.Color(255, 204, 102));
        reset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reset.setForeground(java.awt.Color.white);
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-reset-18.png"))); // NOI18N
        reset.setText("Reset");
        reset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addComponent(cphone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cemail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(update)
                    .addComponent(undo)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete)
                        .addComponent(reset)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cemailActionPerformed

    private void ctableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctableMouseClicked
        int row = ctable.getSelectedRow();
        if (row >= 0) {
            customerPk = (Integer) model.getValueAt(row, 0);
            cname.setText(model.getValueAt(row, 1).toString());
            cphone.setText(model.getValueAt(row, 2).toString());
            cemail.setText(model.getValueAt(row, 3).toString());
            
            update.setEnabled(true);
            delete.setEnabled(true);
            save.setEnabled(false);
        }
    }//GEN-LAST:event_ctableMouseClicked

    private void cnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnameActionPerformed

    private void cphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cphoneActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (!validateFields()) return;
        
        try (PreparedStatement ps = con.prepareStatement(
            "INSERT INTO customer (name, mobile, email) VALUES (?, ?, ?)", 
            Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, cname.getText().trim());
            ps.setString(2, cphone.getText().trim());
            ps.setString(3, cemail.getText().trim());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                // Store operation for undo
                lastOperation = "INSERT";
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        previousState = new Object[]{rs.getInt(1)};
                    }
                }
                
                JOptionPane.showMessageDialog(this, "Customer saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadCustomerData();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saving customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       if (customerPk == 0 || !validateFields()) return;
        
        try {
            // Store current values for undo
            try (PreparedStatement ps = con.prepareStatement(
                "SELECT name, mobile, email FROM customer WHERE customer_pk=?")) {
                ps.setInt(1, customerPk);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        previousState = new Object[]{
                            rs.getString("name"),
                            rs.getString("mobile"),
                            rs.getString("email"),
                            customerPk
                        };
                    }
                }
            }
            
            // Perform update
            try (PreparedStatement ps = con.prepareStatement(
                "UPDATE customer SET name=?, mobile=?, email=? WHERE customer_pk=?")) {
                
                ps.setString(1, cname.getText().trim());
                ps.setString(2, cphone.getText().trim());
                ps.setString(3, cemail.getText().trim());
                ps.setInt(4, customerPk);
                
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    lastOperation = "UPDATE";
                    JOptionPane.showMessageDialog(this, "Customer updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    loadCustomerData();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
               if (lastOperation.isEmpty() || previousState == null) {
            JOptionPane.showMessageDialog(this, "Nothing to undo", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        try {
            switch (lastOperation) {
                case "INSERT":
                    // Undo insert by deleting the last inserted record
                    try (PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM customer WHERE customer_pk=?")) {
                        ps.setInt(1, (Integer) previousState[0]);
                        ps.executeUpdate();
                    }
                    break;
                    
                case "UPDATE":
                    // Undo update by restoring previous values
                    try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE customer SET name=?, mobile=?, email=? WHERE customer_pk=?")) {
                        ps.setString(1, previousState[0].toString());
                        ps.setString(2, previousState[1].toString());
                        ps.setString(3, previousState[2].toString());
                        ps.setInt(4, (Integer) previousState[3]);
                        ps.executeUpdate();
                    }
                    break;
                    
                case "DELETE":
                    // Undo delete by re-inserting the record
                    try (PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO customer (customer_pk, name, mobile, email) VALUES (?, ?, ?, ?)")) {
                        ps.setInt(1, (Integer) previousState[3]);
                        ps.setString(2, previousState[0].toString());
                        ps.setString(3, previousState[1].toString());
                        ps.setString(4, previousState[2].toString());
                        ps.executeUpdate();
                    }
                    break;
            }
            
            JOptionPane.showMessageDialog(this, "Undo successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            lastOperation = "";
            previousState = null;
            loadCustomerData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error undoing operation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_undoActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (customerPk == 0) return;
        
        int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Are you sure you want to delete this customer?", 
            "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) return;
        
        try {
            // Store current values for undo
            try (PreparedStatement ps = con.prepareStatement(
                "SELECT name, mobile, email FROM customer WHERE customer_pk=?")) {
                ps.setInt(1, customerPk);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        previousState = new Object[]{
                            rs.getString("name"),
                            rs.getString("mobile"),
                            rs.getString("email"),
                            customerPk
                        };
                    }
                }
            }
            
            // Perform delete
            try (PreparedStatement ps = con.prepareStatement(
                "DELETE FROM customer WHERE customer_pk=?")) {
                
                ps.setInt(1, customerPk);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    lastOperation = "DELETE";
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearFields();
                    loadCustomerData();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
       clearFields();
    }//GEN-LAST:event_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cemail;
    private javax.swing.JTextField cname;
    private javax.swing.JTextField cphone;
    private javax.swing.JTable ctable;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JButton undo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
