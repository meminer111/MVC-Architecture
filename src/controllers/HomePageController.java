package controllers;

import view.HomePage;
import view.JobPage;
import view.StudentPage;
import view.TourismPage;
import view.AdminPage;
import view.BusinessPage;

public class HomePageController {

	HomePage homePage;
		
	public HomePageController(HomePage homePage) {
		this.homePage = homePage;
		
		initController();
	}	
	private void initController() {		
		// Adds event listener to button
			this.homePage.getAdminButton().addActionListener((ae) -> adminButtonAction());
			this.homePage.getTourismButton().addActionListener((ae) -> tourismButtonAction());	
			this.homePage.getStudentButton().addActionListener((ae) -> studentButtonAction());
			this.homePage.getJobButton().addActionListener((ae) -> jobButtonAction());
			this.homePage.getBusinessButton().addActionListener((ae) -> businessButtonAction());
	}	
	// Called when the button is clicked.
	private void adminButtonAction() {
		homePage.getHomePage().dispose();
		AdminPage adminPage = new AdminPage();
		
	}	
	private void tourismButtonAction() {

		homePage.getHomePage().dispose();
		TourismPage tourismPage = new TourismPage();
		
	}
	private void studentButtonAction() {

		homePage.getHomePage().dispose();
		StudentPage studentPage = new StudentPage();
		
	}
	private void jobButtonAction() {

		homePage.getHomePage().dispose();
		JobPage jobPage = new JobPage();
		
	}
	private void businessButtonAction() {

		homePage.getHomePage().dispose();
		BusinessPage businessPage = new BusinessPage();
		
	}	
}
