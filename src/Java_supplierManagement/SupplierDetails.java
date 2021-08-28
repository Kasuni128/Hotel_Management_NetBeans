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
public class SupplierDetails {
    MY_CONNECTION my_connection = new MY_CONNECTION();
    
     public boolean addsupplierdetails(String SupplierName,String CompanyName, String Address, int ContactNo, String Type){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `supplier`(`sname`, `cname`, `address`, `contactno`, `type`) VALUES  ('"+SupplierName+"','"+CompanyName+"','"+Address+"','"+ContactNo+"','"+Type+"' )";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
     public void fillSupplierDetailsJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `supplier`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[6];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
     
     
     public boolean updatesupplierdetails(int supplierId , String SupplierName,String CompanyName, String Address, int ContactNo, String Type){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `supplier` SET `sname`=?, `cname`=?, `address`=?, `contactno`=?, `type`= ? WHERE `sid`=?";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, SupplierName);
            st.setString(2, CompanyName);
            st.setString(3, Address);
            st.setInt(4, ContactNo);
            st.setString(5, Type);
            st.setInt(6, supplierId);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(SupplierDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
      public boolean deletesupplierdetails(int supplierId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `supplier` WHERE `sid`=?";
                
        try {
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, supplierId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(SupplierDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
  
     
}
