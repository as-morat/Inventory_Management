package Home_Page;

import Category.CategoryManage;
import Customer.Customer;
import Inventory_Main.Main;
import Product.ManageProduct;
import User_manage.UserManage;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {

    private Home h;
    private UserManage u;

    public final void setHome() {
        if (h == null) {
            h = new Home(this);
            homie.add(h, "home");
        }
        ((CardLayout) homie.getLayout()).show(homie, "home");
    }

    public final void setUser() {
        if (u == null) {
            u= new UserManage();
            homie.add(u, "user");
        }
        ((CardLayout) homie.getLayout()).show(homie, "user");
    }
    
    public final void setCategory() {
    CategoryManage c = new CategoryManage();
    homie.add(c, "category");
    ((CardLayout) homie.getLayout()).show(homie, "category");
}
    public final void setCustomer() {
    Customer c = new Customer();
    homie.add(c, "customer");
    ((CardLayout) homie.getLayout()).show(homie, "customer");
}

    private void initialize(String role) {
        initComponents();
        homie.setLayout(new CardLayout());
        setLocationRelativeTo(null);
        if ("Admin".equals(role)) {
            user.setVisible(true);
        } else {
            user.setVisible(false);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Welcome - " + role);
        setHome();
    }

    public HomePage() {
        initialize("Admin");
    }

    public HomePage(String role) {
        initialize(role);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JButton();
        category = new javax.swing.JButton();
        product = new javax.swing.JButton();
        customer = new javax.swing.JButton();
        order = new javax.swing.JButton();
        view = new javax.swing.JButton();
        user = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        homie = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(204, 255, 204));
        home.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-home-25.png"))); // NOI18N
        home.setText("Home");
        home.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        home.setPreferredSize(new java.awt.Dimension(90, 30));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 110, -1));

        category.setBackground(new java.awt.Color(214, 255, 132));
        category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        category.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-category-25.png")); // NOI18N
        category.setText("Category");
        category.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        category.setPreferredSize(new java.awt.Dimension(90, 30));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        getContentPane().add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 110, -1));

        product.setBackground(new java.awt.Color(214, 255, 132));
        product.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        product.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-product-25.png")); // NOI18N
        product.setText("Product");
        product.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        product.setPreferredSize(new java.awt.Dimension(90, 30));
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });
        getContentPane().add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 110, -1));

        customer.setBackground(new java.awt.Color(214, 255, 132));
        customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customer.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-customers-25.png")); // NOI18N
        customer.setText("Customer");
        customer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        customer.setPreferredSize(new java.awt.Dimension(90, 30));
        customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerActionPerformed(evt);
            }
        });
        getContentPane().add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 110, -1));

        order.setBackground(new java.awt.Color(214, 255, 132));
        order.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        order.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-order-25.png")); // NOI18N
        order.setText("Order");
        order.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        order.setPreferredSize(new java.awt.Dimension(90, 30));
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed(evt);
            }
        });
        getContentPane().add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 110, -1));

        view.setBackground(new java.awt.Color(214, 255, 132));
        view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        view.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-view-25.png")); // NOI18N
        view.setText("View Order");
        view.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        view.setPreferredSize(new java.awt.Dimension(90, 30));
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 110, -1));

        user.setBackground(new java.awt.Color(214, 255, 132));
        user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-user-25.png")); // NOI18N
        user.setText("User");
        user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        user.setPreferredSize(new java.awt.Dimension(90, 30));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 110, -1));

        logout.setBackground(new java.awt.Color(214, 255, 132));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-log-out-25.png")); // NOI18N
        logout.setText("Log Out");
        logout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        logout.setPreferredSize(new java.awt.Dimension(90, 30));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 110, -1));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("AshBase");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-inventory-22.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 2, 10)); // NOI18N
        jLabel4.setText("Where Your Inventory Finds Order");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        homie.setBackground(new java.awt.Color(204, 255, 255));
        homie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout homieLayout = new javax.swing.GroupLayout(homie);
        homie.setLayout(homieLayout);
        homieLayout.setHorizontalGroup(
            homieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        homieLayout.setVerticalGroup(
            homieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        getContentPane().add(homie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 700, 330));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\icons8-cross-mark-button-18.png")); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Java Project\\Inventory_Management\\src\\Images\\home.jpg")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel2.setPreferredSize(new java.awt.Dimension(715, 522));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        setActiveButton(logout, user, view, order, customer, home, category, product);
        int a = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        setActiveButton(home, category, product, customer, order, view, user, logout);
        setHome();
    }//GEN-LAST:event_homeActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        setActiveButton(category, home, customer, logout, order, view, product);
    setCategory();
    }//GEN-LAST:event_categoryActionPerformed

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
    setActiveButton(product, category, home, customer, logout, order, view);
    ManageProduct manageProduct = new ManageProduct();
    manageProduct.setVisible(true);
    }//GEN-LAST:event_productActionPerformed

    private void customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerActionPerformed
        setActiveButton(customer, home, category, product, order, view, user, logout);
        setCustomer();
    }//GEN-LAST:event_customerActionPerformed

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderActionPerformed
        setActiveButton(order, customer, home, category, product, view, user, logout);
        JOptionPane.showMessageDialog(
            null, 
            "Customer module is currently under maintenance.\nWe apologize for the inconvenience.\nPlease check back soon.", 
            "Maintenance Notification", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_orderActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        setActiveButton(view, order, customer, home, category, product, user, logout);
        JOptionPane.showMessageDialog(
            null, 
            "Customer module is currently under maintenance.\nWe apologize for the inconvenience.\nPlease check back soon.", 
            "Maintenance Notification", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_viewActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Do you want to close this application?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        setActiveButton(user, view, order, customer, home, category, product, logout);
        setUser();
    }//GEN-LAST:event_userActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton category;
    private javax.swing.JButton customer;
    private javax.swing.JButton home;
    private javax.swing.JPanel homie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton order;
    private javax.swing.JButton product;
    private javax.swing.JButton user;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables

    private void setActiveButton(JButton active, JButton... others) {
        active.setBackground(new Color(204, 255, 204));
        for (JButton btn : others) {
            btn.setBackground(new Color(214, 255, 132));
        }
    }

}
