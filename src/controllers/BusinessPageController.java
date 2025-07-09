package controllers;

import javax.swing.JTable;

import model.BusinessModel;
import view.BusinessPage;



public class BusinessPageController {
	BusinessPage businessPage;
	BusinessModel businessModel;
		
	public BusinessPageController(BusinessPage businessPage, BusinessModel businessModel) {
		this.businessPage = businessPage;
		this.businessModel = businessModel;
		
		initController();
	}
	
	private void initController() {		
		// Adds event listener to combo box
			this.businessModel.createConnection(); // Creates a connection to database
			this.readTable(businessPage.getTable(),"business");
			this.businessPage.getServiceSelector().addActionListener((ae) -> comboBoxAction());
	}	
	
	// Called when the button is clicked.
	private void comboBoxAction() {
		String s = String.valueOf(this.businessPage.getServiceSelector().getSelectedItem());
		businessModel.populateSelectedService(businessPage.getTable(), "business", s);
	}
	
	private void readTable(JTable table,String tblName) {
		businessModel.populateTable(table,tblName);
	}
}
