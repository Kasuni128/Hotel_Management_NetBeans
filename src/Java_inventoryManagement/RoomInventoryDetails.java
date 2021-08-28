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
public class RoomInventoryDetails {
    
    MY_CONNECTION my_connection = new MY_CONNECTION();
    
     public boolean addroominventroies(String RItemName, String Rcategory, String dateR){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `roominventory`(`RItemName`, `Rcategory`, `Rdate`) VALUES ('"+RItemName+"','"+Rcategory+"','"+dateR+"' )";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
     
    public void fillRoomInventoryDetailsJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `roominventory`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
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
            Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
     public boolean updateroominventroies(int RitemID , String RitemName, String Rcategory, String dateR){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `roominventory` SET `RItemName`=?,  `Rcategory`=?, `Rdate`= ? WHERE `RItemId`=?";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, RitemName);
            st.setString(2, Rcategory);
            st.setString(3, dateR);
            st.setInt(4, RitemID);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(RoomInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
  
     
     
     public boolean deleteroominventories(int RItemId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `roominventory` WHERE `RItemId`=?";
                
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
