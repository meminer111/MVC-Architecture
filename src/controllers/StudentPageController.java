package controllers;

import javax.swing.JTable;

import model.StudentModel;

import view.StudentPage;


public class StudentPageController {
	StudentPage studentPage;
	StudentModel studentModel;
		
	public StudentPageController(StudentPage studentPage, StudentModel studentModel) {
		this.studentPage = studentPage;
		this.studentModel = studentModel;
		
		initController();
	}
	
	private void initController() {		
		// Adds event listener to combo box
			this.studentModel.createConnection(); // Creates a connection to database
			this.readTable(studentPage.getTable(),"student");
			this.studentPage.getServiceSelector().addActionListener((ae) -> comboBoxAction());
	}	
	
	// Called when the button is clicked.
	private void comboBoxAction() {
		String s = String.valueOf(this.studentPage.getServiceSelector().getSelectedItem());
		System.out.println(s);
		studentModel.populateSelectedService(studentPage.getTable(), "student", s);
	}
	
	private void readTable(JTable table,String tblName) {
		studentModel.populateTable(table,tblName);
	}
}
