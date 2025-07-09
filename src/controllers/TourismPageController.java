package controllers;

import javax.swing.JTable;

import model.TourismModel;
import view.TourismPage;



public class TourismPageController{

	TourismPage tourismPage;
	TourismModel tourismModel;
		
	public TourismPageController(TourismPage tourismPage, TourismModel tourismModel) {
		this.tourismPage = tourismPage;
		this.tourismModel = tourismModel;
		
		initController();
	}
	
	private void initController() {		
		// Adds event listener to combo box
			this.tourismModel.createConnection(); // Creates a connection to database
			this.readTable(tourismPage.getTable(),"tourism");
			this.tourismPage.getServiceSelector().addActionListener((ae) -> tourismComboBoxAction());
	}	
	
	// Called when the button is clicked.
	private void tourismComboBoxAction() {
		String s = String.valueOf(this.tourismPage.getServiceSelector().getSelectedItem());
		tourismModel.populateSelectedService(tourismPage.getTable(), "tourism", s);
	}
	
	private void readTable(JTable table,String tblName) {
		tourismModel.populateTable(table,tblName);
	}

}
