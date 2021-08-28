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
public class increaseinventory {
        MY_CONNECTION my_connection = new MY_CONNECTION();
    
     public boolean addproduct(String proname,int Quanitity){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `kitchen`(`pname`, `qty`) VALUES ('"+proname+"','"+Quanitity+"' )";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(increaseinventory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
      public boolean updateproduct(String Product , int Qty){
        
        PreparedStatement st;
        String updateQuery = "UPDATE kitchen SET qty=qty+'"+Qty+"' where pname='"+Product+"'";
         
        
                //+ "qty=qty+'"+qty+"' WHERE `product='"+product+"'";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            //st.setInt(1, qty);
            //st.setString(2, product);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(increaseinventory.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
      
       public boolean decreaseproduct(String Product , int Qty){
        
        PreparedStatement st;
        String updateQuery = "UPDATE kitchen SET qty=qty-'"+Qty+"' where pname='"+Product+"'";
         
        
                //+ "qty=qty+'"+qty+"' WHERE `product='"+product+"'";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            //st.setInt(1, qty);
            //st.setString(2, product);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(increaseinventory.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
      
      public void fillKitchenInventoryProductDetailsJTable(JTable table1){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `kitchen`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[2];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
               
              
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KitchenInventoryDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
      
      
     
}
