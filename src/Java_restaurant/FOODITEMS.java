package Java_restaurant;




import DB.Connectivity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Interface_restaurant.ResManagement;
import javax.swing.JComboBox;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maduka-PC
 */
public class FOODITEMS {
    
    Connectivity my_connection = new Connectivity();
    
     public boolean addfooditems(String itemName,int quanitity,double price,double total,double billAmount){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `fooditems`(`item_name`, `qty`, `price`, `total`, `billAmount`) VALUES ('"+itemName+"', '"+quanitity+"', '"+price+"', '"+total+"', '"+billAmount+"')";
        
        try {
            st = Connectivity.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
      public boolean addmenuitems(String itemName,double price){
        
        PreparedStatement st;
        String addQue = "INSERT INTO `menuitems`(`item_name`, `price`) VALUES ('"+itemName+"','"+price+"')";
        
        try {
            st = Connectivity.createConnection().prepareStatement(addQue);
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                
    }
     
    /**
     *
     * @param table
     */
    public void fillFOODITEMSJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `fooditems`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getDouble(4);
                row[4]= rs.getDouble(5);
                row[5] = rs.getDouble(6);
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void fillMENUITEMSJTable(JTable table){
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `menuitems`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getDouble(3);
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    /**
     *
     * @param itemID
     * @param itemName
     * @param quanitity
     * @param price
     * @return
     */
    public boolean updatefooditems(int itemID , String itemName,int quanitity,double price,double total,double billAmount){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `fooditems` SET `item_name`=?, `qty`=?, `price`=?, `total`=?, `billAmount`=?,";
        
        try {
            st = Connectivity.createConnection().prepareStatement(updateQuery);
            
            
            st.setString(1, itemName);
            st.setInt(2, quanitity);
            st.setDouble(3 ,price);
            st.setDouble(4 ,total);
            st.setDouble(5 ,billAmount);
            
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
  
      public boolean updatemenuitems(int itemID, String itemName,double price){
        
        PreparedStatement st;
        String updateQuery = "UPDATE `menuitems` SET  `item_name`=?,`price`=? WHERE `item_id`=?";
       
        
        try {
            st = Connectivity.createConnection().prepareStatement(updateQuery);
            
            st.setString(1, itemName);
            st.setDouble(2 ,price);
            st.setDouble(3 ,itemID);
            
            return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
  
     }
  
     
     public boolean deletefooditems(int ItemId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `fooditems` WHERE `item_id`=?";
                
        try {
            st = Connectivity.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, ItemId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
  
      public boolean deletemenuitems(int ItemId)
    {
        PreparedStatement st;
        String deleteQuery= "DELETE FROM `menuitems` WHERE `item_id`=?";
                
        try {
            st = Connectivity.createConnection().prepareStatement(deleteQuery);
            
            st.setInt(1, ItemId);
            
                return (st.executeUpdate() > 0);
                        
            } 
            catch (SQLException ex) {
                Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
   public void jcomboupdate(){
    PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `menuitems`";
        
        try {
            ps = Connectivity.createConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
       while(rs.next()){
       ResManagement.jComboBox1.addItem(rs.getString("item_Name"));
       }
           
   }    catch (SQLException ex) { 
      Logger.getLogger(FOODITEMS.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
}}
