package Java_financeManagement;

import DB.MY_CONNECTIONs;
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
public class UTILITY_BILL {
    
    MY_CONNECTIONs my_connection = new MY_CONNECTIONs();
    
     public boolean addutility(String category, String amount, String billname, String dateR){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `utility_bill`( `catergory`, `amount`, `name`, `date`) VALUES ('"+category+"','"+amount+"','"+billname+"','"+dateR+"')";
        
        try {
            st = my_connection.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(UTILITY_BILL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
     public boolean deleteutility(int Id)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `utility_bill` WHERE `id`=?";
                
        try {
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, Id);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(UTILITY_BILL.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
     
     public boolean updateutility(int ID ,String category, String amount, String billname, String dateR){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `utility_bill` SET `catergory`=?, `amount`=?, `name`=?, `date`=? WHERE `id`=?";
        
        try {
            st = my_connection.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, category);
            st.setString(2, amount);
            st.setString(3, billname);
            st.setString(4, dateR);
            st.setInt(5, ID);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(UTILITY_BILL.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
}
     public void fillutilityDetailsJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `utility_bill`";
        
        try {
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
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
            Logger.getLogger(UTILITY_BILL.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}