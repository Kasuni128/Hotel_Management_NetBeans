/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_emp;

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
 * @author ASUS
 */
public class EmployeeDetails {
    
    Connectivity dbcon = new Connectivity();
    
    public boolean addEmployer(String empName,String nic, String address, String email, String contactNo, String jbType){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `add_employee` (`Name`, `NIC`, `Address`, `Email`, `Contact_No`, `Job_Type`) VALUES ('"+empName+"','"+nic+"','"+address+"','"+email+"','"+contactNo+"','"+jbType+"' )";
        
        try {
            st = dbcon.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public boolean blackListEmployer(int empId, String empName,String nic, String address, String email, String contactNo, String jbType){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `blacklist_employee` (`Emp_Id`, `Name`, `NIC`, `Address`, `Email`, `Contact_No`, `Job_Type`) VALUES ('"+empId+"','"+empName+"','"+nic+"','"+address+"','"+email+"','"+contactNo+"','"+jbType+"' )";
        
        try {
            st = dbcon.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    
    public void fillEmployeeDetailsJTable(JTable tb){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `add_employee`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)tb.getModel();
            
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
            Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fillEmployeeBlackListDetailsJTable(JTable tb){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `blacklist_employee`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)tb.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[8];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean updateEmployer(int empId, String empName,String nic, String address, String email, String contactNo, String jbType)
    {
        PreparedStatement st;
        String updateQuery= "UPDATE `add_employee` SET `Name`=?,`NIC`=?,`Address`=?,`Email`=?,`Contact_No`=?, `Job_Type`=? WHERE `Emp_Id`=?";
                
        try {
            st = dbcon.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, empName);
            st.setString(2, nic);
            st.setString(3, address);
            st.setString(4, email);
            st.setString(5, contactNo);
            st.setString(6, jbType);
            st.setInt(7, empId);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    public boolean deleteEmployer(int empId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `add_employee` WHERE `Emp_Id`=?";
                
        try {
            st = dbcon.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, empId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    
}   
