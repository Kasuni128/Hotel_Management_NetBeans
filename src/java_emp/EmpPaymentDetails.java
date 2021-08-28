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
public class EmpPaymentDetails {
     Connectivity dbcon = new Connectivity();
    
    public boolean addEmployerPayments(String empId, String name,String jtype, String date, Double sal){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `payments` (`Emp_Id`, `Name`,`Job_Type`, `Date`, `Salary`) VALUES ('"+empId+"','"+name+"','"+jtype+"','"+date+"','"+sal+"' )";
        
        try {
            st = dbcon.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
     public void fillEmployeePaymentsJTable(JTable tb){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `payments`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)tb.getModel();
            
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
            Logger.getLogger(EmpPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
