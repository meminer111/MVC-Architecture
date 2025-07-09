package controllers;

import javax.swing.JTable;

import model.JobModel;
import view.JobPage;



public class JobPageController {
	
	JobPage jobPage;
	JobModel jobModel;
		
	public JobPageController(JobPage jobPage, JobModel jobModel) {
		this.jobPage = jobPage;
		this.jobModel = jobModel;
		
		initController();
	}
	
	private void initController() {		
		// Adds event listener to combo box
			this.jobModel.createConnection(); // Creates a connection to database
			this.readTable(jobPage.getTable(),"job");
			this.jobPage.getServiceSelector().addActionListener((ae) -> comboBoxAction());
	}	
	
	// Called when the button is clicked.
	private void comboBoxAction() {
		String s = String.valueOf(this.jobPage.getServiceSelector().getSelectedItem());
		jobModel.populateSelectedService(jobPage.getTable(), "job", s);
	}
	
	private void readTable(JTable table,String tblName) {
		jobModel.populateTable(table,tblName);
	}
}

