
package Category;

import Home_Page.HomePage;
import db.Connection_Provider;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class CategoryManage extends javax.swing.JPanel {
    private Connection con;
    private DefaultTableModel model;
    private int categoryPk = 0;
    public CategoryManage() {
        initComponents();
    con = Connection_Provider.getCon(); // Optional: initialize DB here
    model = (DefaultTableModel) catetable.getModel(); // <-- this is required!
    loadCategoryData(); 
    }

    private void loadCategoryData() {
        try {
            if (con == null || con.isClosed()) {
                con = Connection_Provider.getCon();
            }
            
            model.setRowCount(0); // Clear existing rows
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("category_pk"), 
                    rs.getString("name")
                });
            }
            
            rs.close();
            st.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading categories: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean validateFields() {
        return !name.getText().trim().isEmpty();
    }

    private void clearFields() {
        name.setText("");
        categoryPk = 0;
        save.setEnabled(true);
        update.setEnabled(false);
        delete.setEnabled(false);
        undo.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        catetable = new javax.swing.JTable();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        back = new javax.swing.JButton();

        catetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        catetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(catetable);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        save.setText("jButton1");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setText("jButton2");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("jButton3");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        undo.setText("jButton4");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        back.setText("jButton1");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(update)
                                    .addGap(50, 50, 50)
                                    .addComponent(delete)
                                    .addGap(43, 43, 43)
                                    .addComponent(undo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addGap(421, 421, 421)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(undo)
                    .addComponent(back))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (!validateFields()) {
        JOptionPane.showMessageDialog(null, "Category name is required");
        return;
    }

    try {
        if (con == null || con.isClosed()) {
            con = Connection_Provider.getCon(); // Ensure connection here
        }

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO category (name) VALUES (?)");

        ps.setString(1, name.getText().trim());

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Category Added Successfully!");
            clearFields();
            loadCategoryData();
        }

        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error saving category: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (!validateFields()) {
            JOptionPane.showMessageDialog(null, "Category name is required");
            return;
        }

        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE category SET name=? WHERE category_pk=?");
            
            ps.setString(1, name.getText().trim());
            ps.setInt(2, categoryPk);
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Category Updated Successfully!");
                clearFields();
                loadCategoryData();
            }
            
            ps.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error updating category: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         int confirm = JOptionPane.showConfirmDialog(null, 
            "Are you sure you want to delete this category?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM category WHERE category_pk=?");
            
            ps.setInt(1, categoryPk);
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Category Deleted Successfully!");
                clearFields();
                loadCategoryData();
            }
            
            ps.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error deleting category: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
         clearFields();
    }//GEN-LAST:event_undoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void catetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catetableMouseClicked
       int row = catetable.getSelectedRow();
        categoryPk = Integer.parseInt(model.getValueAt(row, 0).toString());
        name.setText(model.getValueAt(row, 1).toString());
        
        save.setEnabled(false);
        update.setEnabled(true);
        delete.setEnabled(true);
        undo.setEnabled(true);
    }//GEN-LAST:event_catetableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable catetable;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton save;
    private javax.swing.JButton undo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
