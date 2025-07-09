package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminModel extends DataBaseModel{
	
	public void instertTourismData(String name,String location, Double price, String review, String service,String tblName) throws SQLException {
		String pQuery = "insert into $tableName " + "(SERVICE, NAME, LOCATION, PRICE, REVIEW) " + "values (?, ?, ?, ?, ?)";
		String query = pQuery.replace("$tableName", tblName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, service);
			ps.setString(2, name);
			ps.setString(3, location);
			ps.setDouble(4, price);
			ps.setString(5, review);
			ps.addBatch();
			
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
	public void instertStudentData(String name,String location, String service,String tblName) throws SQLException {
		String pQuery = "insert into $tableName " + "(SERVICE, NAME, LOCATION) " + "values (?, ?, ?)";
		String query = pQuery.replace("$tableName", tblName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, service);
			ps.setString(2, name);
			ps.setString(3, location);
			ps.addBatch();
			
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
	public void instertJobData(String name,String location, String description, String pay, String hours,String website,String service, String tblName) throws SQLException {
		String pQuery = "insert into $tableName " + "(SERVICE, NAME, LOCATION, DESCRIPTION, PAY, HOURS, WEBSITE) " + "values (?, ?, ?, ?, ?, ?, ?)";
		String query = pQuery.replace("$tableName", tblName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, service);
			ps.setString(2, name);
			ps.setString(3, location);
			ps.setString(4, description);
			ps.setString(5, pay);
			ps.setString(6, hours);
			ps.setString(7, website);
			ps.addBatch();
			
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
	public void instertBusinessData(String name,String location,String description,String website, String service,String tblName) throws SQLException {
		String pQuery = "insert into $tableName " + "(SERVICE, NAME, LOCATION, DESCRIPTION, WEBSITE) " + "values (?, ?, ?, ?, ?)";
		String query = pQuery.replace("$tableName", tblName);
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setString(1, service);
			ps.setString(2, name);
			ps.setString(3, location);
			ps.setString(4, description);
			ps.setString(5, website);
			ps.addBatch();
			
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
	public void updateTourismData(JTable tbl) {
		Statement st;
		DefaultTableModel model = (DefaultTableModel) tbl.getModel(); // sets the table model
		try {
			st = con.createStatement(); // creates stateement
			for(int i = 0; i < model.getRowCount(); i++){ // cycles through all the rows in the jTable

                int id = Integer.valueOf(model.getValueAt(i, 0).toString()); // gets the value of the primary key id
                String service = model.getValueAt(i,1).toString(); // gets all the values from the table
                String name = model.getValueAt(i,2).toString();
                String location = model.getValueAt(i,3).toString(); 
                String price = model.getValueAt(i,4).toString();
                String review = model.getValueAt(i,5).toString();
                
                // update query with the values at each row
                String updateQuery = "UPDATE `tourism` SET `service`='"+service+"',`name`='"+name+"',`location`='"+location+"',`price`='"+price+"',`review`='"+review+"' WHERE `Id` = " +id; 
                st.addBatch(updateQuery);
			}
			
			st.executeBatch();
			JOptionPane.showMessageDialog(null, "Updated successfully");
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudentData(JTable tbl) {
		Statement st;
		DefaultTableModel model = (DefaultTableModel) tbl.getModel(); // sets the table model
		try {
			st = con.createStatement(); // creates stateement
			for(int i = 0; i < model.getRowCount(); i++){ // cycles through all the rows in the jTable

                int id = Integer.valueOf(model.getValueAt(i, 0).toString()); // gets the value of the primary key id
                String service = model.getValueAt(i,1).toString(); // gets all the values from the table
                String name = model.getValueAt(i,2).toString();
                String location = model.getValueAt(i,3).toString(); 
                
                // update query with the values at each row
                String updateQuery = "UPDATE `student` SET `service`='"+service+"',`name`='"+name+"',`location`='"+location+"' WHERE `Id` = " +id; 
                st.addBatch(updateQuery);
			}
			
			st.executeBatch();
			JOptionPane.showMessageDialog(null, "Updated successfully");
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateJobData(JTable tbl) {
		Statement st;
		DefaultTableModel model = (DefaultTableModel) tbl.getModel(); // sets the table model
		try {
			st = con.createStatement(); // creates stateement
			for(int i = 0; i < model.getRowCount(); i++){ // cycles through all the rows in the jTable

                int id = Integer.valueOf(model.getValueAt(i, 0).toString()); // gets the value of the primary key id
                String service = model.getValueAt(i,1).toString(); // gets all the values from the table
                String name = model.getValueAt(i,2).toString();
                String location = model.getValueAt(i,3).toString(); 
                String description = model.getValueAt(i,4).toString();
                String pay = model.getValueAt(i,5).toString();
                String hours = model.getValueAt(i,6).toString();
                String website = model.getValueAt(i,7).toString();
                
                // update query with the values at each row
                String updateQuery = "UPDATE `job` SET `service`='"+service+"',`name`='"+name+"',`location`='"+location+"',`description`='"+description+"',`pay`='"+pay+"',`hours`='"+hours+"',`website`='"+website+"' WHERE `Id` = " +id; 
                st.addBatch(updateQuery);
			}
			
			st.executeBatch();
			JOptionPane.showMessageDialog(null, "Updated successfully");
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateBusinessData(JTable tbl) {
		Statement st;
		DefaultTableModel model = (DefaultTableModel) tbl.getModel(); // sets the table model
		try {
			st = con.createStatement(); // creates stateement
			for(int i = 0; i < model.getRowCount(); i++){ // cycles through all the rows in the jTable

                int id = Integer.valueOf(model.getValueAt(i, 0).toString()); // gets the value of the primary key id
                String service = model.getValueAt(i,1).toString(); // gets all the values from the table
                String name = model.getValueAt(i,2).toString();
                String location = model.getValueAt(i,3).toString(); 
                String description = model.getValueAt(i,4).toString();
                String website = model.getValueAt(i,5).toString();
                
                // update query with the values at each row
                String updateQuery = "UPDATE `business` SET `service`='"+service+"',`name`='"+name+"',`location`='"+location+"',`description`='"+description+"',`website`='"+website+"' WHERE `Id` = " +id; 
                st.addBatch(updateQuery);
			}
			
			st.executeBatch();
			JOptionPane.showMessageDialog(null, "Updated successfully");
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
