package Product;

import Home_Page.HomePage;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import db.Connection_Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageProduct extends javax.swing.JFrame {
    private int productPk = 0;
    private int totalQuantity = 0;
    Connection con;
    DefaultTableModel model;
    private int product_pk;


   public ManageProduct() {
        initComponents();
        setLocationRelativeTo(null);
        con = Connection_Provider.getCon();
        model = (DefaultTableModel) form.getModel();
        getAllCategory();
        loadProductData();
    }
   private void getAllCategory() {
        try {
            if (con == null || con.isClosed()) {
                con = Connection_Provider.getCon();
            }
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            category.removeAllItems();
            category.addItem("Select");
            
            while (rs.next()) {
                category.addItem(rs.getString("category_pk") + "-" + rs.getString("name"));
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading categories: " + e.getMessage());
            e.printStackTrace();
        }
    }
   private void loadProductData() {
        try {
            if (con == null || con.isClosed()) {
                con = Connection_Provider.getCon();
            }
            
            model.setRowCount(0); // Clear existing rows
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.*, c.name as category_name FROM product p INNER JOIN category c ON p.category_fk = c.category_pk");
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_pk"), 
                    rs.getString("name"), 
                    rs.getString("quantity"), 
                    rs.getString("price"), 
                    rs.getString("description"), 
                    rs.getString("category_fk"), 
                    rs.getString("category_name") 
                });
            }
            
            rs.close();
            st.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading products: " + e.getMessage());
            e.printStackTrace();
        }
    }
   private boolean validationField(String type) {
        if (type.equals("edit") && 
            !name.getText().trim().isEmpty() && 
            !price.getText().trim().isEmpty() && 
            !description.getText().trim().isEmpty()) {
            return true;
        } else if (type.equals("new") && 
                   !name.getText().trim().isEmpty() && 
                   !price.getText().trim().isEmpty() && 
                   !description.getText().trim().isEmpty() && 
                   !quantity.getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        form = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        back = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(710, 522));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Product");

        form.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "Co. ID", "Co. Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        form.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        form.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(form);
        if (form.getColumnModel().getColumnCount() > 0) {
            form.getColumnModel().getColumn(0).setMinWidth(50);
            form.getColumnModel().getColumn(0).setPreferredWidth(50);
            form.getColumnModel().getColumn(0).setMaxWidth(50);
            form.getColumnModel().getColumn(1).setMinWidth(100);
            form.getColumnModel().getColumn(1).setPreferredWidth(100);
            form.getColumnModel().getColumn(1).setMaxWidth(100);
            form.getColumnModel().getColumn(2).setMinWidth(75);
            form.getColumnModel().getColumn(2).setPreferredWidth(75);
            form.getColumnModel().getColumn(2).setMaxWidth(75);
            form.getColumnModel().getColumn(3).setMinWidth(75);
            form.getColumnModel().getColumn(3).setPreferredWidth(75);
            form.getColumnModel().getColumn(3).setMaxWidth(75);
            form.getColumnModel().getColumn(4).setMinWidth(100);
            form.getColumnModel().getColumn(4).setPreferredWidth(100);
            form.getColumnModel().getColumn(4).setMaxWidth(100);
            form.getColumnModel().getColumn(5).setMinWidth(50);
            form.getColumnModel().getColumn(5).setPreferredWidth(50);
            form.getColumnModel().getColumn(5).setMaxWidth(50);
            form.getColumnModel().getColumn(6).setMinWidth(100);
            form.getColumnModel().getColumn(6).setPreferredWidth(100);
            form.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        name.setText("name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        price.setText("price");
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        quantity.setText("quantity");
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        description.setText("descript");
        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        delete.setText("jButton1");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(save)
                .addGap(108, 108, 108)
                .addComponent(update)
                .addGap(51, 51, 51)
                .addComponent(reset)
                .addGap(35, 35, 35)
                .addComponent(delete)
                .addGap(35, 35, 35)
                .addComponent(back))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(update)
                        .addComponent(reset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(delete)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        clearFields();
    }//GEN-LAST:event_resetActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getAllCategory();
        DefaultTableModel model = (DefaultTableModel) form.getModel();
        model.setRowCount(0); // Clear existing rows
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM product INNER JOIN category ON product.category_fk = category.category_pk");
            
            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_pk"), 
                    rs.getString("name"), 
                    rs.getString("quantity"), 
                    rs.getString("price"), 
                    rs.getString("description"), 
                    rs.getString("category_fk"), 
                    rs.getString(8) 
                });
            }
            
            rs.close();
            st.close();
            con.close();
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        update.setEnabled(false);

    }//GEN-LAST:event_formComponentShown

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try {
        if(con == null || con.isClosed()) {
            con = Connection_Provider.getCon();
        }
    } catch (SQLException ex) {
        Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
    }

    String txtname = name.getText();
    String txtprice = price.getText().trim();
    String txtquantity = quantity.getText().trim();
    String txtdescription = description.getText().trim();
    String combocategory = (String)category.getSelectedItem();
    
    if(combocategory.equals("Select")) {
        JOptionPane.showMessageDialog(null, "Please select a category");
        return;
    }
    
    // Validate numeric fields
    if (!isNumeric(txtprice) || !isNumeric(txtquantity)) {
        JOptionPane.showMessageDialog(null, "Price and Quantity must be numeric values");
        return;
    }
    
    String[] categoryID = combocategory.split("-");
    
    if(!validationField("new")) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }
    
    try {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO product (name, quantity, price, description, category_fk) VALUES (?,?,?,?,?)");
        
        ps.setString(1, txtname);
        ps.setInt(2, Integer.parseInt(txtquantity));
        ps.setDouble(3, Double.parseDouble(txtprice));
        ps.setString(4, txtdescription);
        ps.setInt(5, Integer.parseInt(categoryID[0]));
        
        int rows = ps.executeUpdate();
        if(rows > 0) {
            JOptionPane.showMessageDialog(null, "Product Added Successfully!");
            clearFields();
            loadProductData();
        }
        
        ps.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error saving product: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_saveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        new HomePage().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       try {
        if (con == null || con.isClosed()) {
            con = Connection_Provider.getCon();
        }
    } catch (SQLException ex) {
        Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }

    String txtname = name.getText().trim();
    String txtprice = price.getText().trim();
    String txtquantity = quantity.getText().trim();
    String txtdescription = description.getText().trim();
    String combocategory = (String) category.getSelectedItem();

    // Check if category is selected
    if (combocategory.equals("Select")) {
        JOptionPane.showMessageDialog(null, "Please select a category");
        return;
    }

    // Validate all required fields
    if (!validationField("edit") || txtquantity.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }

    if (!isNumeric(txtprice) || !isNumeric(txtquantity)) {
        JOptionPane.showMessageDialog(null, "Price and Quantity must be numeric");
        return;
    }
    String[] categoryID = combocategory.split("-");
    int categoryId = Integer.parseInt(categoryID[0]);

    try {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE product SET name=?, quantity=?, price=?, description=?, category_fk=? WHERE product_pk=?"
        );

        ps.setString(1, txtname);
        ps.setInt(2, Integer.parseInt(txtquantity));
        ps.setDouble(3, Double.parseDouble(txtprice));
        ps.setString(4, txtdescription);
        ps.setInt(5, categoryId);
        ps.setInt(6, productPk);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Product Updated Successfully!");
            clearFields();
            loadProductData();
        }

        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error updating product: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_updateActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int row = form.getSelectedRow();
    model = (DefaultTableModel) form.getModel();

    // 1. Set product ID for update
    String id = model.getValueAt(row, 0).toString();
    productPk = Integer.parseInt(id);

    // 2. Fill form fields with data from the selected row
    name.setText(model.getValueAt(row, 1).toString());
    quantity.setText(model.getValueAt(row, 2).toString());
    price.setText(model.getValueAt(row, 3).toString());
    description.setText(model.getValueAt(row, 4).toString());

    // 3. Match and select the category in the combo box
    String categoryId = model.getValueAt(row, 5).toString();
    String categoryName = model.getValueAt(row, 6).toString();
    String comboValue = categoryId + "-" + categoryName;

    for (int i = 0; i < category.getItemCount(); i++) {
        if (category.getItemAt(i).equals(comboValue)) {
            category.setSelectedIndex(i);
            break;
        }
    }

    // 4. Enable Update button and disable Save
    update.setEnabled(true);
    save.setEnabled(false);
    }//GEN-LAST:event_formMouseClicked

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        String selectedCategory = (String) category.getSelectedItem();

    if (selectedCategory != null && !selectedCategory.equals("Select")) {
        try {
            if (con == null || con.isClosed()) {
                con = Connection_Provider.getCon();
            }
            
            model.setRowCount(0);
            
            String[] categoryParts = selectedCategory.split("-");
            int categoryId = Integer.parseInt(categoryParts[0]);
            
            PreparedStatement ps = con.prepareStatement(
                "SELECT p.*, c.name as category_name FROM product p " +
                "INNER JOIN category c ON p.category_fk = c.category_pk " +
                "WHERE p.category_fk = ?");
            ps.setInt(1, categoryId);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_pk"), 
                    rs.getString("name"), 
                    rs.getString("quantity"), 
                    rs.getString("price"), 
                    rs.getString("description"), 
                    rs.getString("category_fk"), 
                    rs.getString("category_name")
                });
            }
            
            rs.close();
            ps.close();
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error filtering products by category: " + e.getMessage());
            e.printStackTrace();
                }
           } else if (selectedCategory != null && selectedCategory.equals("Select")) {
        loadProductData();
        }
    }//GEN-LAST:event_categoryActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       if (productPk == 0) {
        JOptionPane.showMessageDialog(null, "Please select a product to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        null,
        "Are you sure you want to delete this product?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return; // User cancelled
    }

    try {
        if (con == null || con.isClosed()) {
            con = Connection_Provider.getCon();
        }

        PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE product_pk = ?");
        ps.setInt(1, productPk);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Product deleted successfully!");
            clearFields();       // clear form
            loadProductData();   // reload table
        } else {
            JOptionPane.showMessageDialog(null, "No product found with the selected ID.");
        }

        ps.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error deleting product: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_deleteActionPerformed

    private void clearFields() {
        name.setText("");
        quantity.setText("");
        price.setText("");
        description.setText("");
        category.setSelectedIndex(0);
        productPk = 0;
        save.setEnabled(true);
        update.setEnabled(false);
    }
    private boolean isNumeric(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
}
  
    public static void main(String args[]) {
      FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new ManageProduct().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JButton delete;
    private javax.swing.JTextField description;
    private javax.swing.JTable form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
