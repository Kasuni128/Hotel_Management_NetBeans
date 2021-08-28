/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_supplierManagement;


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
 * @author Kaveen Himanka
 */
public class OrderDetails {
MY_CONNECTION my_connection = new MY_CONNECTION();
    
     public boolean addorderdetails(int SupplierID,int ProductId, String Productname, String dateR, int Qty , String Unit){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `order`(`sid`, `pid`, `pname`, `date`, `qty`, `unit`)  VALUES ('"+SupplierID+"','"+ProductId+"','"+Productname+"','"+dateR+"','"+Qty+"','"+Unit+"' )";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    
}
     
     public void fillOrderDetailsJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `order`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[7];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
     
      public boolean updateorderdetails(int Num,int SupplierID,int ProductId, String Productname, String dateR, int Qty, String Unit){
        PreparedStatement st;
        String updateQuery = "UPDATE `order` SET `sid`=?, `pid`=?, `pname`=?, `date`=?, `qty`= ?, `unit`= ? WHERE `no`=?";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            st.setInt(1, SupplierID);
            st.setInt(2, ProductId);
            st.setString(3, Productname);
            st.setString(4, dateR);
            st.setInt(5, Qty);
            st.setString(6, Unit);
            st.setInt(7, Num);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
      
       public boolean deleteorderdetails(int Num)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `order` WHERE `no`=?";
                
        try {
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, Num);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(OrderDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
}