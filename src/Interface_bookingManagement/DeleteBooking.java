/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_bookingManagement;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import DB.Connectivity;
import Interface.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Rajitha_PC
 */
public class DeleteBooking extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    PreparedStatement pst4 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    
    //Access static single object created in SingleConnection
    Connectivity sinObj = Connectivity.getSinconobj();
    public DeleteBooking() throws SQLException, ClassNotFoundException {
        initComponents();
        con = sinObj.createConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jC_Panal = new javax.swing.JPanel();
        jInLabel2 = new javax.swing.JLabel();
        jCheckButton = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonCost = new javax.swing.JButton();
        txtRoomNo = new javax.swing.JTextField();
        jButtonClr = new javax.swing.JButton();
        jInLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jInLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jInLabel3 = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        jButtonNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        jUButton.setText("UPDATE");
        jUButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setLocation(new java.awt.Point(50, 50));
        setPreferredSize(new java.awt.Dimension(1930, 1086));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1111, 611));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1086));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DELETE BOOKING");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(718, 718, 718)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jC_Panal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jInLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jInLabel2.setText("Room No :");

        jCheckButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckButton.setText("Received Rooms");
        jCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckButtonActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 51, 51));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Delete");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonCost.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCost.setText("Search");
        jButtonCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostActionPerformed(evt);
            }
        });

        jButtonClr.setBackground(new java.awt.Color(0, 51, 51));
        jButtonClr.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonClr.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClr.setText("Clear");
        jButtonClr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClrActionPerformed(evt);
            }
        });

        jInLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jInLabel5.setText("ID :");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jInLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jInLabel4.setText("Check-In Date :");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jInLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jInLabel3.setText("Check-Out Date :");

        javax.swing.GroupLayout jC_PanalLayout = new javax.swing.GroupLayout(jC_Panal);
        jC_Panal.setLayout(jC_PanalLayout);
        jC_PanalLayout.setHorizontalGroup(
            jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jC_PanalLayout.createSequentialGroup()
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jC_PanalLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jC_PanalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jInLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jInLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jInLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jInLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRoomNo)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(jButtonCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jC_PanalLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jButtonClr, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jC_PanalLayout.setVerticalGroup(
            jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jC_PanalLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jCheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jInLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jC_PanalLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jInLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jC_PanalLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButtonCost, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jC_PanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClr, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        jButtonUpdate.setBackground(new java.awt.Color(0, 51, 51));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update Bookings");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonNew.setBackground(new java.awt.Color(0, 51, 51));
        jButtonNew.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonNew.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNew.setText("New Booking");
        jButtonNew.setToolTipText("");
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });

        roomTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        roomTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room No", "Room Type", "Room Size", "Room Price", "Room Status"
            }
        ));
        jScrollPane1.setViewportView(roomTable);

        roomTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        roomTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        roomTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Room No", "Check-In Date", "Check-Out Date", "Total Price(Rs.)"
            }
        ));
        jScrollPane2.setViewportView(roomTable2);

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setPreferredSize(new java.awt.Dimension(1110, 155));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interface_inventoryManagement/logo1.jpg"))); // NOI18N
        jLabel16.setText("jLabel12");

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
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
                            .addComponent(jLabel16)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jC_Panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(jButtonUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(373, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1922, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1922, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNew, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jC_Panal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1922, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckButtonActionPerformed
           
        String sql = "SELECT * FROM `booking` WHERE `room_status`='Received'";
                   
          try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
    
            DefaultTableModel  n_table;
            n_table =(DefaultTableModel)roomTable.getModel();
            n_table.setRowCount(0);
            //JOptionPane.showMessageDialog(null,"test","TestingBox: ",JOptionPane.INFORMATION_MESSAGE);
            while(rs.next()){
                Object o[]={rs.getString("room_no"), rs.getString("room_type"), rs.getString("room_size"), rs.getString("room_price"), rs.getString("room_status")};
                n_table.addRow(o);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() , "Search Details", JOptionPane.ERROR_MESSAGE);
        }         
                   
              
              
    }//GEN-LAST:event_jCheckButtonActionPerformed
 
    private void jUButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUButtonActionPerformed
   
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
            // TODO add your handling code here:
            String id = txtId.getText();
            String sqlDelete = "DELETE FROM checkout WHERE id='"+id+"'";
            
            String roomNo = txtRoomNo.getText();
            String sqlStatus = "UPDATE booking SET room_status='Available' WHERE room_no='"+roomNo+"'";
            try {
                pst3 = con.prepareStatement(sqlDelete);
                pst4 = con.prepareStatement(sqlStatus);
                pst3.execute();
                pst4.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Deleted Successfully...!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            this.dispose();
            UpdateBooking nwindow = new UpdateBooking();
            nwindow.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostActionPerformed
        // TODO add your handling code here:
        String inDate = "";
        String outDate = "";
        String roomNo = txtRoomNo.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        inDate = sdf.format(jDateChooser1.getDate());
        outDate = sdf.format(jDateChooser2.getDate());
       
        String sqlSearch = "SELECT * FROM checkout WHERE room_no='"+roomNo+"' AND in_date='"+inDate+"' OR out_date='"+outDate+"'";
           
        try {
            pst2 = con.prepareStatement(sqlSearch);
            rs2 = pst2.executeQuery();
    
            DefaultTableModel  n_table;
            n_table =(DefaultTableModel)roomTable2.getModel();
            n_table.setRowCount(0);
            //JOptionPane.showMessageDialog(null,"test","TestingBox: ",JOptionPane.INFORMATION_MESSAGE);
            while(rs2.next()){
                Object o[]={rs2.getString("id"), rs2.getString("room_no"), rs2.getString("in_date"), rs2.getString("out_date"), rs2.getString("total_price")};
                n_table.addRow(o);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage() , "Search Details", JOptionPane.ERROR_MESSAGE);
        }       
    }//GEN-LAST:event_jButtonCostActionPerformed

    private void jButtonClrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClrActionPerformed
        // TODO add your handling code here:
        txtRoomNo.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }//GEN-LAST:event_jButtonClrActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            this.dispose();
            RoomBooking nwindow = new RoomBooking();
            nwindow.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonNewActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);              // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(DeleteBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DeleteBooking().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClr;
    private javax.swing.JButton jButtonCost;
    private javax.swing.JButton jButtonNew;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JPanel jC_Panal;
    private javax.swing.JButton jCheckButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jInLabel2;
    private javax.swing.JLabel jInLabel3;
    private javax.swing.JLabel jInLabel4;
    private javax.swing.JLabel jInLabel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jUButton;
    private javax.swing.JTable roomTable;
    private javax.swing.JTable roomTable2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtRoomNo;
    // End of variables declaration//GEN-END:variables
}
