package controllers;

import java.sql.SQLException;

import javax.swing.JTable;

import model.AdminModel;
import view.AdminPage;

public class AdminPageController {
	AdminPage adminPage;
	AdminModel adminModel;
	
	String name;
	String location;
	String price;
	String review;
	String service;
	
	public AdminPageController(AdminPage adminPage, AdminModel adminModel) {
		this.adminPage = adminPage;
		this.adminModel = adminModel;
		
		initController();
	}
	
	private void initController() {		
		// Adds event listener to combo box
			this.adminModel.createConnection(); // Creates a connection to database
			this.adminPage.getTourismAdd().addActionListener((ae) -> tourismAdd());
			this.adminPage.getTourismRead().addActionListener((ae) -> readButton(adminPage.getTourismTable(),"tourism"));
			this.adminPage.getTourismUpdate().addActionListener((ae) -> updateData(adminPage.getTourismTable(),"tourism"));
			this.adminPage.getTourismDelete().addActionListener((ae) -> deleteData(adminPage.getTourismTable(),"tourism"));
			
			this.adminPage.getStudentAdd().addActionListener((ae) -> studentAdd()); //sssss
			this.adminPage.getStudentRead().addActionListener((ae) -> readButton(adminPage.getStudentTable(),"student"));
			this.adminPage.getStudentUpdate().addActionListener((ae) -> updateData(adminPage.getStudentTable(),"student"));
			this.adminPage.getStudentDelete().addActionListener((ae) -> deleteData(adminPage.getStudentTable(),"student"));
			
			this.adminPage.getJobAdd().addActionListener((ae) -> jobAdd()); //sssss
			this.adminPage.getJobRead().addActionListener((ae) -> readButton(adminPage.getJobTable(),"job"));
			this.adminPage.getJobUpdate().addActionListener((ae) -> updateData(adminPage.getJobTable(),"job"));
			this.adminPage.getJobDelete().addActionListener((ae) -> deleteData(adminPage.getJobTable(),"job"));
			
			this.adminPage.getBusinessAdd().addActionListener((ae) -> businessAdd()); //sssssss
			this.adminPage.getBusinessRead().addActionListener((ae) -> readButton(adminPage.getBusinessTable(),"business"));
			this.adminPage.getBusinessUpdate().addActionListener((ae) -> updateData(adminPage.getBusinessTable(),"business"));
			this.adminPage.getBusinessDelete().addActionListener((ae) -> deleteData(adminPage.getBusinessTable(),"business"));
	}	
	
	// Called when the button is clicked.
	private void tourismAdd() {
		adminPage.tourismOptionPaneAddName();
	}
	private void studentAdd() {
		adminPage.studentOptionPaneAddName();
	}
	private void jobAdd() {
		adminPage.jobOptionPaneAddName();
	}
	private void businessAdd() {
		adminPage.businessOptionPaneAddName();
	}
	private void readButton(JTable table,String tblName) {
		adminModel.populateTable(table,tblName);
	}
	private void updateData(JTable table,String tblName) {
		
		if(tblName == "tourism") {
			adminModel.updateTourismData(table);
		}if(tblName == "student") {
			adminModel.updateStudentData(table);
		}if(tblName == "job") {
			adminModel.updateJobData(table);
		}if(tblName == "business") {
			adminModel.updateBusinessData(table);
		}
	}
	private void deleteData(JTable table,String tblName) {
		adminModel.deleteData(table, tblName);
	}
	
	public void showTableUpdate(JTable table,String tblName) {
		adminModel.populateTable(table,tblName);
	}

	public void saveToTourism(String tableName) {
		String price = adminPage.getAddPrice();
		Double p = Double.parseDouble(price);

		try {
			adminModel.instertTourismData(adminPage.getAddName(),adminPage.getAddLocation(),p,adminPage.getAddReview(),adminPage.getAddService(),tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void saveToStudent(String tableName) {

		try {
			adminModel.instertStudentData(adminPage.getAddName(),adminPage.getAddLocation(),adminPage.getAddService(),tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void saveToJob(String tableName) {

		try {
			adminModel.instertJobData(adminPage.getAddName(),adminPage.getAddLocation(),adminPage.getAddDescription(),adminPage.getAddPay(),adminPage.getAddHours(),adminPage.getAddWebsite(),adminPage.getAddService(),tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void saveToBusiness(String tableName) {

		try {
			adminModel.instertBusinessData(adminPage.getAddName(),adminPage.getAddLocation(),adminPage.getAddDescription(),adminPage.getAddWebsite(),adminPage.getAddService(),tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
