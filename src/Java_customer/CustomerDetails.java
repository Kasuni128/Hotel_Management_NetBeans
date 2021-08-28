/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_customer;

import DB.Connectivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class CustomerDetails {

   Connectivity connectivity = new Connectivity();

    public boolean addcustomerdetails(String cusName, String nic, String email, String address,int contactNo) {
        
        PreparedStatement st;
        String addQue = "INSERT INTO `customer`( `CustomerName`, `NIC`, `Email`, `Address`, `ContactNumber`) VALUES ( '"+cusName+"', '"+nic+"', '"+email+"', '"+address+"', '"+contactNo+"')";
        
          
        try {
            st = connectivity.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
               
        
                
    } 
    
    public void fillCustomerDetailsJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `customer`";
        
        try {
            ps = connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getInt(6);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public boolean updateCustomer(int customerId, String cusName, String nic, String address, String email, int contactNo) {
      
        PreparedStatement st;
        String updateQuery= "UPDATE `customer` SET `CustomerName`=?,`NIC`=?,`Email`=?,`Address`=?,`ContactNumber`=? WHERE `CustomerID`=?";
                
        try {
            st = connectivity.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, cusName);
            st.setString(2, nic);
            st.setString(3, address);
            st.setString(4, email);
            st.setInt(5, contactNo);
            st.setInt(6, customerId);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
        
    }

    public boolean deleteCustomer(int customerId) {
          PreparedStatement st;
        String deleteQuery= "DELETE FROM `customer` WHERE `CustomerID`=?";
                
        try {
            st = connectivity.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, customerId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    }
 
            
           

