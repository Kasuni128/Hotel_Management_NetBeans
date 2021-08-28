/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_inventoryManagement;

import DB.MY_CONNECTION;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kasuni Piyumali
 */
public class KitchenInventoryDetails {
    MY_CONNECTION my_connection = new MY_CONNECTION();
     public boolean addkitcheninventroies(String KItemName, String Kcategory, String dateK){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `kitcheninventory`(`KItemName`, `Kcategory`, `Kdate`) VALUES ('"+KItemName+"','"+Kcategory+"','"+dateK+"' )";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
     public void fillKitchenInventoryDetailsJTable(JTable table1){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `kitcheninventory`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[4];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
               
              
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KitchenInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
     
     
     
     
      public boolean updatekitcheninventroies(int KitemID , String KitemName, String Kcategory, String dateK){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `kitcheninventory` SET `KItemName`=?,  `Kcategory`=?, `Kdate`= ? WHERE `KItemId`=?";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, KitemName);
            st.setString(2, Kcategory);
            st.setString(3, dateK);
            st.setInt(4, KitemID);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
      
      
        public boolean deletekitcheninventories(int RItemId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `kitcheninventory` WHERE `KItemId`=?";
                
        try {
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, RItemId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
  
        
      
}

