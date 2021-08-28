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
public class EmpAttendanceDetails {
    
    Connectivity dbcon = new Connectivity();
    
    public boolean addEmployerAttendance(String empId, String date,String month, String otHours){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `attendance` (`Emp_Id`, `Date`,`Month`, `OtHours`) VALUES ('"+empId+"','"+date+"','"+month+"','"+otHours+"' )";
        
        try {
            st = dbcon.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpAttendanceDetails.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
    
    public void fillEmployeeAttendanceJTable(JTable tb){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `attendance`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)tb.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpAttendanceDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public boolean updateEmployerAttendance(int attId, int empId, String date, String month, int othours)
    {
        PreparedStatement st;
        String updateQuery= "UPDATE `attendance` SET `Emp_Id`=?, `Date`=?,`Month`=?,`OtHours`=? WHERE `Attendance_Id`=?";
                
        try {
            st = dbcon.createConnection().prepareStatement(updateQuery);
            
            st.setInt(1, empId);
            st.setString(2, date);
            st.setString(3, month);
            st.setInt(4, othours);
            st.setInt(5, attId);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(EmpAttendanceDetails.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
}
