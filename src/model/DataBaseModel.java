package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataBaseModel {
	
	protected static Connection con;
	
	public static void main(String[] args) {
		DataBaseModel database = new DataBaseModel();
        //Get the connection
		database.createConnection() ;
	}

    // Database inputs
    private static final String URL = "jdbc:mysql://localhost:3306/citydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // connect
    public void createConnection() {
        try {
            // Establish the database connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to db");
        }
    }


	// populates the table
	public void populateTable(JTable tbl,String tblName) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String pQuery = "SELECT * FROM $tableName";
		String query = pQuery.replace("$tableName", tblName);
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery(query); // executes a query
			tbl.setModel(DbUtils.resultSetToTableModel(rs)); // uses a library to write table data
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();	
			} catch(Exception e) {
			}
		}
	}
	public void populateSelectedService(JTable tbl,String tblName, String service) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		System.out.println(service);
		String pQuery = "SELECT * FROM $tableName WHERE service = '"+service+"'" ; // uses inputted variable to find where it matches

		String query = pQuery.replace("$tableName", tblName); // replaces the tableName varibale with java variable
		
		try {
			pst = con.prepareStatement(query); // prepares the query to be executed
			rs = pst.executeQuery(query); // executes a query
			tbl.setModel(DbUtils.resultSetToTableModel(rs)); // uses a library to write table data
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();	
			} catch(Exception e) {
			}
		}
	}
	
	public void deleteData(JTable tbl,String tblName) { // Deletes data
		DefaultTableModel model = (DefaultTableModel) tbl.getModel();
		int row = tbl.getSelectedRow(); // Gets row selected by user
		String cell = model.getValueAt(row, 0).toString();
		String pQuery = "DELETE FROM $tableName WHERE id = " + cell; // uses tablename where id = row selected by user
		String query = pQuery.replace("$tableName", tblName); // replaces variable $tablename with tablename for sql query
		if(tbl.getSelectedRowCount()==1) {
			try {
				PreparedStatement pst = con.prepareStatement(query); // preps statement
				pst.execute();
				JOptionPane.showMessageDialog(null, "Deleted successfully");
				populateTable(tbl, tblName);
			} catch (SQLException e){    // if sql error then show option pane
				JOptionPane.showMessageDialog(null, e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please select a single row");
		}
	}
}
