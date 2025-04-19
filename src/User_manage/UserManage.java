package User_manage;

import Home_Page.HomePage;
import db.Connection_Provider;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UserManage extends javax.swing.JPanel {
    private Object[] backupRowData = null;
    private int backupRowIndex = -1;

    public UserManage() {
        initComponents();
        loadUserData();
    }

    public UserManage(HomePage homePage) {
    initComponents();
    loadUserData(); 
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        undo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "EMAIL", "PHONE", "ADDRESS", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        edit.setBackground(new java.awt.Color(204, 255, 204));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-edit-18.png"))); // NOI18N
        edit.setText("Edit");
        edit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 204, 204));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-delete-18.png"))); // NOI18N
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        undo.setBackground(new java.awt.Color(153, 255, 204));
        undo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-undo-18.png"))); // NOI18N
        undo.setText("Undo");
        undo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(undo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(edit)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addGap(18, 18, 18)
                .addComponent(undo)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
          int row = table.getSelectedRow();
    if (row >= 0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] newValues = new String[6];

        for (int i = 1; i < 5; i++) {
            newValues[i] = JOptionPane.showInputDialog(this, "Edit " + table.getColumnName(i), model.getValueAt(row, i));
            if (newValues[i] == null) return; // If cancelled
        }

        String[] statusOptions = { "Active", "Inactive" };
        String currentStatus = model.getValueAt(row, 5).toString();
        JComboBox<String> statusCombo = new JComboBox<>(statusOptions);
        statusCombo.setSelectedItem(currentStatus);
        int result = JOptionPane.showConfirmDialog(this, statusCombo, "Edit Status", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            newValues[5] = (String) statusCombo.getSelectedItem(); // store status
        } else {
            return; 
        }

        backupRowData = model.getDataVector().elementAt(row).toArray();
        backupRowIndex = row;

        try {
            String query = "UPDATE appuser SET name=?, email=?, mobileNumber=?, address=?, status=? WHERE appuser_pk=?";
            PreparedStatement pst = Connection_Provider.getCon().prepareStatement(query);
            for (int i = 1; i < 6; i++) pst.setString(i, newValues[i]);
            pst.setInt(6, (Integer) model.getValueAt(row, 0)); // ID
            pst.executeUpdate();

            for (int i = 1; i < 6; i++) model.setValueAt(newValues[i], row, i);

            JOptionPane.showMessageDialog(this, "User updated!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Update failed: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int row = table.getSelectedRow();
    if (row >= 0) {
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this user?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Backup for undo
            backupRowData = model.getDataVector().elementAt(row).toArray();
            backupRowIndex = row;

            int userId = (Integer) model.getValueAt(row, 0);

            try {
                PreparedStatement pst = Connection_Provider.getCon().prepareStatement("DELETE FROM appuser WHERE appuser_pk=?");
                pst.setInt(1, userId);
                pst.executeUpdate();
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "User deleted!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Delete failed: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_deleteActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        if (backupRowData != null && backupRowIndex >= 0) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        try {
            PreparedStatement pst = Connection_Provider.getCon().prepareStatement(
                "REPLACE INTO appuser (appuser_pk, name, email, mobileNumber, address, status) VALUES (?, ?, ?, ?, ?, ?)"
            );
            for (int i = 0; i < 6; i++) {
                pst.setObject(i + 1, backupRowData[i]);
            }
            pst.executeUpdate();

            model.insertRow(backupRowIndex, backupRowData);
            JOptionPane.showMessageDialog(this, "Undo successful!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Undo failed: " + e.getMessage());
        }

        backupRowData = null;
        backupRowIndex = -1;
    }
    }//GEN-LAST:event_undoActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            edit.setEnabled(true);
            delete.setEnabled(true);
        }
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables

    private void loadUserData() {
       try {
        String query = "SELECT appuser_pk, name, email, mobileNumber, address, status FROM appuser";
        ResultSet rs = Connection_Provider.execute(query);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("appuser_pk"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("mobileNumber"),
                rs.getString("address"),
                rs.getString("status")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading user data: " + e.getMessage());
        }
    }
}

