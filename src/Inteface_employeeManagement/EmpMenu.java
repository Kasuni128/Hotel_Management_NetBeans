/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inteface_employeeManagement;

import Interface_bookingManagement.RoomMenu;
import Interface_customerManagement.CusManagement;
import Interface_restaurant.ResManagement;
import finance.mangement.Finance_Mangemant;
import interface_inventoryManagement.Inventory_Dash;
import interface_supplierManagement.Supplier_Dashboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class EmpMenu extends javax.swing.JFrame {

    /**
     * Creates new form EmpMenu
     */
    public EmpMenu() {
        initComponents();
    }

    Connection conn;
    PreparedStatement st;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonCustomerManagement = new javax.swing.JButton();
        jButtonBillManagement = new javax.swing.JButton();
        jButtonRsManagement = new javax.swing.JButton();
        jButtonInManagement = new javax.swing.JButton();
        jButtonEmpManagement = new javax.swing.JButton();
        jButtonFinManagement = new javax.swing.JButton();
        jButtonSupMAnagement = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonempManagement = new javax.swing.JButton();
        jButtonempAtt = new javax.swing.JButton();
        jButtonempPayments = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1919, 1019));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jButtonCustomerManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonCustomerManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCustomerManagement.setText("Customer Management ");
        jButtonCustomerManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustomerManagementActionPerformed(evt);
            }
        });

        jButtonBillManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonBillManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonBillManagement.setText("Bill & Booking Management");
        jButtonBillManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBillManagementActionPerformed(evt);
            }
        });

        jButtonRsManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonRsManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonRsManagement.setText("Restuarant Management");
        jButtonRsManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRsManagementActionPerformed(evt);
            }
        });

        jButtonInManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonInManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonInManagement.setText("Inventory Management");
        jButtonInManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInManagementActionPerformed(evt);
            }
        });

        jButtonEmpManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonEmpManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEmpManagement.setText("Employee Management");

        jButtonFinManagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonFinManagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonFinManagement.setText("Finance Management");
        jButtonFinManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinManagementActionPerformed(evt);
            }
        });

        jButtonSupMAnagement.setBackground(new java.awt.Color(255, 255, 153));
        jButtonSupMAnagement.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonSupMAnagement.setText("Supplier Management");
        jButtonSupMAnagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupMAnagementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSupMAnagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFinManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEmpManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRsManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBillManagement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCustomerManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButtonCustomerManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButtonBillManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButtonRsManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButtonInManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonEmpManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButtonFinManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButtonSupMAnagement, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("                          Employee Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(548, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        jButtonempManagement.setBackground(new java.awt.Color(0, 0, 0));
        jButtonempManagement.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jButtonempManagement.setForeground(new java.awt.Color(255, 255, 255));
        jButtonempManagement.setText("Employee Management");
        jButtonempManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonempManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonempManagementActionPerformed(evt);
            }
        });

        jButtonempAtt.setBackground(new java.awt.Color(0, 0, 0));
        jButtonempAtt.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jButtonempAtt.setForeground(new java.awt.Color(255, 255, 255));
        jButtonempAtt.setText("Employee Attendance");
        jButtonempAtt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonempAtt.setPreferredSize(new java.awt.Dimension(289, 41));
        jButtonempAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonempAttActionPerformed(evt);
            }
        });

        jButtonempPayments.setBackground(new java.awt.Color(0, 0, 0));
        jButtonempPayments.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jButtonempPayments.setForeground(new java.awt.Color(255, 255, 255));
        jButtonempPayments.setText("Employee Monthly Payments");
        jButtonempPayments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonempPayments.setPreferredSize(new java.awt.Dimension(289, 41));
        jButtonempPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonempPaymentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonempPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonempAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonempManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonempManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButtonempAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jButtonempPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setPreferredSize(new java.awt.Dimension(1110, 155));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_inventoryManagement/logo1.jpg"))); // NOI18N
        jLabel14.setText("jLabel12");

        jButton18.setBackground(new java.awt.Color(0, 204, 0));
        jButton18.setFont(new java.awt.Font("Microsoft New Tai Lue", 3, 24)); // NOI18N
        jButton18.setText("LOGOUT");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Wide Latin", 0, 55)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kottawatta River Bank Resort");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel15))
                            .addComponent(jLabel14)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBillManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBillManagementActionPerformed
        // TODO add your handling code here:
        new RoomMenu().setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jButtonBillManagementActionPerformed

    private void jButtonempManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonempManagementActionPerformed
        // TODO add your handling code here:

        Add_Employee empDetails = new Add_Employee();
        empDetails.setVisible(true);
        empDetails.setLocationRelativeTo(null);
        empDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();
    }//GEN-LAST:event_jButtonempManagementActionPerformed

    private void jButtonempAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonempAttActionPerformed
        // TODO add your handling code here:

        EmpAttendance empAttDetails = new EmpAttendance();
        empAttDetails.setVisible(true);
        empAttDetails.setLocationRelativeTo(null);
        empAttDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();
    }//GEN-LAST:event_jButtonempAttActionPerformed

    private void jButtonempPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonempPaymentsActionPerformed
        // TODO add your handling code here:

        EmpPayments empPayDetails = new EmpPayments();
        empPayDetails.setVisible(true);
        empPayDetails.setLocationRelativeTo(null);
        empPayDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();
    }//GEN-LAST:event_jButtonempPaymentsActionPerformed

    private void jButtonInManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInManagementActionPerformed
        // TODO add your handling code here:
        new Inventory_Dash().setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jButtonInManagementActionPerformed

    private void jButtonFinManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinManagementActionPerformed
        // TODO add your handling code here:
        new Finance_Mangemant().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFinManagementActionPerformed

    private void jButtonSupMAnagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupMAnagementActionPerformed
        // TODO add your handling code here:
        new Supplier_Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSupMAnagementActionPerformed

    private void jButtonRsManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRsManagementActionPerformed
        // TODO add your handling code here:
        new ResManagement().setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jButtonRsManagementActionPerformed

    private void jButtonCustomerManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustomerManagementActionPerformed
        // TODO add your handling code here:
        new CusManagement().setVisible(true);
        this.setVisible(false);  
    }//GEN-LAST:event_jButtonCustomerManagementActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

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
            java.util.logging.Logger.getLogger(EmpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButtonBillManagement;
    private javax.swing.JButton jButtonCustomerManagement;
    private javax.swing.JButton jButtonEmpManagement;
    private javax.swing.JButton jButtonFinManagement;
    private javax.swing.JButton jButtonInManagement;
    private javax.swing.JButton jButtonRsManagement;
    private javax.swing.JButton jButtonSupMAnagement;
    private javax.swing.JButton jButtonempAtt;
    private javax.swing.JButton jButtonempManagement;
    private javax.swing.JButton jButtonempPayments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}