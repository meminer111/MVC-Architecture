package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.AdminPageController;
import model.AdminModel;

public class AdminPage extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AdminPageController controller;
	AdminModel model;
	
	JTable tourismTable;
	JTable studentTable;
	JTable jobTable;
	JTable businessTable;
	
	String addName;
	String addLocation;
	String addPrice;
	String addReview;
	String addService;
	String addPay;
	String addHours;
	String addWebsite;
	String addDescription;
	
	JButton tourismAdd;
	JButton tourismRead;
	JButton tourismUpdate;
	JButton tourismDelete;
	
	JButton studentAdd;
	JButton studentRead;
	JButton studentUpdate;
	JButton studentDelete;
	
	JButton jobAdd;
	JButton jobRead;
	JButton jobUpdate;
	JButton jobDelete;
	
	JButton businessAdd;
	JButton businessRead;
	JButton businessUpdate;
	JButton businessDelete;

	
	public AdminPage(){
		
		this.setTitle("HomePage");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		
		JPanel top = new JPanel(); // Creates the panels for put on the this
		JPanel bottom = new JPanel();
		
		top.setBackground(new Color(0,40,0)); // Sets background colour of panels
		bottom.setBackground(new Color(0,0,0));
		
		this.setLayout(new BorderLayout()); // Bordered layout used for easier placement
		top.setLayout(new FlowLayout());
		bottom.setLayout(new FlowLayout());
		
		top.setPreferredSize(new Dimension(960,520)); // Sets size of panels
		bottom.setPreferredSize(new Dimension(960,520));

		JPanel topLeft = new JPanel();
		topLeft.setPreferredSize(new Dimension(940,520));
		
		JPanel topRight = new JPanel();
		topRight.setPreferredSize(new Dimension(940,520));

		JPanel bottomLeft = new JPanel();
		bottomLeft.setPreferredSize(new Dimension(940,520));
		
		JPanel bottomRight = new JPanel();
		bottomRight.setPreferredSize(new Dimension(940,520));
		
		JScrollPane tlScrollPane = new JScrollPane(); // creates new top left scroll pane
		tlScrollPane.setPreferredSize(new Dimension(800,400));
		
		JScrollPane trScrollPane = new JScrollPane(); // creates new top right scroll pane
		trScrollPane.setPreferredSize(new Dimension(800,400));

		JScrollPane blScrollPane = new JScrollPane(); // creates new bottom left scroll pane
		blScrollPane.setPreferredSize(new Dimension(800,400));
		
		JScrollPane brScrollPane = new JScrollPane(); // creates new bottom right scroll pane
		brScrollPane.setPreferredSize(new Dimension(800,400));

		this.add(top,BorderLayout.NORTH); // Adds the pannels to the this at the top and bottom
		this.add(bottom,BorderLayout.SOUTH);
		
		top.add(topLeft);
		top.add(topRight);
		bottom.add(bottomLeft);
		bottom.add(bottomRight);
		
		tourismAdd = new JButton("Add"); // Creates new buttons 
		tourismRead = new JButton("Read");
		tourismUpdate = new JButton("Update");
		tourismDelete = new JButton("Delete");
		
		studentAdd = new JButton("Add"); // Creates new buttons 
		studentRead = new JButton("Read");
		studentUpdate = new JButton("Update");
		studentDelete = new JButton("Delete");
		
		jobAdd = new JButton("Add"); // Creates new buttons 
		jobRead = new JButton("Read");
		jobUpdate = new JButton("Update");
		jobDelete = new JButton("Delete");
		
		businessAdd = new JButton("Add"); // Creates new buttons 
		businessRead = new JButton("Read");
		businessUpdate = new JButton("Update");
		businessDelete = new JButton("Delete");
		
		JLabel toursimTitle = new JLabel("Tourism");
		
		topLeft.add(toursimTitle);
		topLeft.add(tourismAdd); // Adds buttons to top left
		topLeft.add(tourismRead);
		topLeft.add(tourismUpdate);
		topLeft.add(tourismDelete);
		
		// adds the table to the top left
		topLeft.add(tlScrollPane);
		tourismTable = new JTable();
		tlScrollPane.setViewportView(tourismTable);
		
		JLabel studentTitle = new JLabel("Student");
		
		topRight.add(studentTitle);
		topRight.add(studentAdd); // Adds buttons to top right
		topRight.add(studentRead);
		topRight.add(studentUpdate);
		topRight.add(studentDelete);
		
		// adds the table to the top right
		topRight.add(trScrollPane);
		studentTable = new JTable();
		trScrollPane.setViewportView(studentTable);
		
		JLabel jobTitle = new JLabel("Jobs");
		
		bottomLeft.add(jobTitle);
		bottomLeft.add(jobAdd); // Adds buttons to bottom left
		bottomLeft.add(jobRead);
		bottomLeft.add(jobUpdate);
		bottomLeft.add(jobDelete);
		
		// adds the table to the bottom left
		bottomLeft.add(blScrollPane);
		jobTable = new JTable();
		blScrollPane.setViewportView(jobTable);
		
		JLabel businessTitle = new JLabel("Businesses");
		
		bottomRight.add(businessTitle);
		bottomRight.add(businessAdd); // Adds buttons bottom right
		bottomRight.add(businessRead);
		bottomRight.add(businessUpdate);
		bottomRight.add(businessDelete);
		
		// adds the table to the bottom right
		bottomRight.add(brScrollPane);
		businessTable = new JTable();
		brScrollPane.setViewportView(businessTable);
		
		model = new AdminModel();
		controller = new AdminPageController(this, model);
		
		this.setVisible(true);
	}
	
	public void tourismOptionPaneAddName() {
		addName = JOptionPane.showInputDialog("What is the name of the service?");
		addLocation = JOptionPane.showInputDialog("Where is it located?");
		addPrice = JOptionPane.showInputDialog("How much does it cost?");
		addReview = JOptionPane.showInputDialog("How many stars does it have?");
		addService = JOptionPane.showInputDialog("What type of service is it?");
		try {
			tourismOptionPaneAddSuccess("tourism");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void studentOptionPaneAddName() {
		addName = JOptionPane.showInputDialog("What is the name of the service?");
		addLocation = JOptionPane.showInputDialog("Where is it located?");
		addService = JOptionPane.showInputDialog("What type of service is it?");
		try {
			tourismOptionPaneAddSuccess("student");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void jobOptionPaneAddName() {
		addName = JOptionPane.showInputDialog("What is the name of the service?");
		addLocation = JOptionPane.showInputDialog("Where is it located?");
		addPay = JOptionPane.showInputDialog("How much does it pay?");
		addHours = JOptionPane.showInputDialog("How many hours per week?");
		addWebsite = JOptionPane.showInputDialog("Whats the website link?");
		addDescription = JOptionPane.showInputDialog("Enter the job description");
		addService = JOptionPane.showInputDialog("What type of industry is the job in?");
		try {
			tourismOptionPaneAddSuccess("job");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
	
	public void businessOptionPaneAddName() {
		addName = JOptionPane.showInputDialog("What is the name of the business?");
		addLocation = JOptionPane.showInputDialog("Where is it located?");
		addWebsite = JOptionPane.showInputDialog("Whats the website link?");
		addDescription = JOptionPane.showInputDialog("Enter the business description?");
		addService = JOptionPane.showInputDialog("What type of industry is it?");
		try {
			tourismOptionPaneAddSuccess("business");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}

	public void tourismOptionPaneAddSuccess(String tblName) {

		if (tblName == "tourism") {
			controller.saveToTourism(tblName); // saves input fields into db
			controller.showTableUpdate(getTourismTable(),tblName); // updates table to show on screen 
		}if (tblName == "student") {
			controller.saveToStudent(tblName); // saves input fields into db
			controller.showTableUpdate(getStudentTable(),tblName); // updates table to show on screen 
		}if (tblName == "job") {
			controller.saveToJob(tblName); // saves input fields into db
			controller.showTableUpdate(getJobTable(),tblName); // updates table to show on screen 
		}if (tblName == "business") {
			controller.saveToBusiness(tblName); // saves input fields into db
			controller.showTableUpdate(getBusinessTable(),tblName); // updates table to show on screen 
		}
		JOptionPane.showMessageDialog(null,"Successfuly added!!");
	}

	/**
	 * @return the addPay
	 */
	public String getAddPay() {
		return addPay;
	}

	/**
	 * @param addPay the addPay to set
	 */
	public void setAddPay(String addPay) {
		this.addPay = addPay;
	}

	/**
	 * @return the addHours
	 */
	public String getAddHours() {
		return addHours;
	}

	/**
	 * @param addHours the addHours to set
	 */
	public void setAddHours(String addHours) {
		this.addHours = addHours;
	}

	/**
	 * @return the addWebsite
	 */
	public String getAddWebsite() {
		return addWebsite;
	}

	/**
	 * @param addWebsite the addWebsite to set
	 */
	public void setAddWebsite(String addWebsite) {
		this.addWebsite = addWebsite;
	}

	/**
	 * @return the addDescription
	 */
	public String getAddDescription() {
		return addDescription;
	}

	/**
	 * @param addDescription the addDescription to set
	 */
	public void setAddDescription(String addDescription) {
		this.addDescription = addDescription;
	}

	/**
	 * @return the studentTable
	 */
	public JTable getStudentTable() {
		return studentTable;
	}

	/**
	 * @param studentTable the studentTable to set
	 */
	public void setStudentTable(JTable studentTable) {
		this.studentTable = studentTable;
	}

	/**
	 * @return the jobTable
	 */
	public JTable getJobTable() {
		return jobTable;
	}

	/**
	 * @param jobTable the jobTable to set
	 */
	public void setJobTable(JTable jobTable) {
		this.jobTable = jobTable;
	}

	/**
	 * @return the businessTable
	 */
	public JTable getBusinessTable() {
		return businessTable;
	}

	/**
	 * @param businessTable the businessTable to set
	 */
	public void setBusinessTable(JTable businessTable) {
		this.businessTable = businessTable;
	}

	/**
	 * @return the tourismTable
	 */
	public JTable getTourismTable() {
		return tourismTable;
	}

	/**
	 * @param tourismTable the tourismTable to set
	 */
	public void setTourismTable(JTable tourismTable) {
		this.tourismTable = tourismTable;
	}

	/**
	 * @return the addName
	 */
	public String getAddName() {
		return addName;
	}

	/**
	 * @param addName the addName to set
	 */
	public void setAddName(String addName) {
		this.addName = addName;
	}

	/**
	 * @return the addLocation
	 */
	public String getAddLocation() {
		return addLocation;
	}

	/**
	 * @param addLocation the addLocation to set
	 */
	public void setAddLocation(String addLocation) {
		this.addLocation = addLocation;
	}

	/**
	 * @return the addPrice
	 */
	public String getAddPrice() {
		return addPrice;
	}

	/**
	 * @param addPrice the addPrice to set
	 */
	public void setAddPrice(String addPrice) {
		this.addPrice = addPrice;
	}

	/**
	 * @return the addReview
	 */
	public String getAddReview() {
		return addReview;
	}

	/**
	 * @param addReview the addReview to set
	 */
	public void setAddReview(String addReview) {
		this.addReview = addReview;
	}

	/**
	 * @return the addService
	 */
	public String getAddService() {
		return addService;
	}

	/**
	 * @param addService the addService to set
	 */
	public void setAddService(String addService) {
		this.addService = addService;
	}

	/**
	 * @return the tourismAdd
	 */
	public JButton getTourismAdd() {
		return tourismAdd;
	}

	/**
	 * @param tourismAdd the tourismAdd to set
	 */
	public void setTourismAdd(JButton tourismAdd) {
		this.tourismAdd = tourismAdd;
	}

	/**
	 * @return the tourismRead
	 */
	public JButton getTourismRead() {
		return tourismRead;
	}

	/**
	 * @param tourismRead the tourismRead to set
	 */
	public void setTourismRead(JButton tourismRead) {
		this.tourismRead = tourismRead;
	}

	/**
	 * @return the tourismUpdate
	 */
	public JButton getTourismUpdate() {
		return tourismUpdate;
	}

	/**
	 * @param tourismUpdate the tourismUpdate to set
	 */
	public void setTourismUpdate(JButton tourismUpdate) {
		this.tourismUpdate = tourismUpdate;
	}

	/**
	 * @return the tourismDelete
	 */
	public JButton getTourismDelete() {
		return tourismDelete;
	}

	/**
	 * @param tourismDelete the tourismDelete to set
	 */
	public void setTourismDelete(JButton tourismDelete) {
		this.tourismDelete = tourismDelete;
	}

	/**
	 * @return the studentAdd
	 */
	public JButton getStudentAdd() {
		return studentAdd;
	}

	/**
	 * @param studentAdd the studentAdd to set
	 */
	public void setStudentAdd(JButton studentAdd) {
		this.studentAdd = studentAdd;
	}

	/**
	 * @return the studentRead
	 */
	public JButton getStudentRead() {
		return studentRead;
	}

	/**
	 * @param studentRead the studentRead to set
	 */
	public void setStudentRead(JButton studentRead) {
		this.studentRead = studentRead;
	}

	/**
	 * @return the studentUpdate
	 */
	public JButton getStudentUpdate() {
		return studentUpdate;
	}

	/**
	 * @param studentUpdate the studentUpdate to set
	 */
	public void setStudentUpdate(JButton studentUpdate) {
		this.studentUpdate = studentUpdate;
	}

	/**
	 * @return the studentDelete
	 */
	public JButton getStudentDelete() {
		return studentDelete;
	}

	/**
	 * @param studentDelete the studentDelete to set
	 */
	public void setStudentDelete(JButton studentDelete) {
		this.studentDelete = studentDelete;
	}

	/**
	 * @return the jobAdd
	 */
	public JButton getJobAdd() {
		return jobAdd;
	}

	/**
	 * @param jobAdd the jobAdd to set
	 */
	public void setJobAdd(JButton jobAdd) {
		this.jobAdd = jobAdd;
	}

	/**
	 * @return the jobRead
	 */
	public JButton getJobRead() {
		return jobRead;
	}

	/**
	 * @param jobRead the jobRead to set
	 */
	public void setJobRead(JButton jobRead) {
		this.jobRead = jobRead;
	}

	/**
	 * @return the jobUpdate
	 */
	public JButton getJobUpdate() {
		return jobUpdate;
	}

	/**
	 * @param jobUpdate the jobUpdate to set
	 */
	public void setJobUpdate(JButton jobUpdate) {
		this.jobUpdate = jobUpdate;
	}

	/**
	 * @return the jobDelete
	 */
	public JButton getJobDelete() {
		return jobDelete;
	}

	/**
	 * @param jobDelete the jobDelete to set
	 */
	public void setJobDelete(JButton jobDelete) {
		this.jobDelete = jobDelete;
	}

	/**
	 * @return the businessAdd
	 */
	public JButton getBusinessAdd() {
		return businessAdd;
	}

	/**
	 * @param businessAdd the businessAdd to set
	 */
	public void setBusinessAdd(JButton businessAdd) {
		this.businessAdd = businessAdd;
	}

	/**
	 * @return the businessRead
	 */
	public JButton getBusinessRead() {
		return businessRead;
	}

	/**
	 * @param businessRead the businessRead to set
	 */
	public void setBusinessRead(JButton businessRead) {
		this.businessRead = businessRead;
	}

	/**
	 * @return the businessUpdate
	 */
	public JButton getBusinessUpdate() {
		return businessUpdate;
	}

	/**
	 * @param businessUpdate the businessUpdate to set
	 */
	public void setBusinessUpdate(JButton businessUpdate) {
		this.businessUpdate = businessUpdate;
	}

	/**
	 * @return the businessDelete
	 */
	public JButton getBusinessDelete() {
		return businessDelete;
	}

	/**
	 * @param businessDelete the businessDelete to set
	 */
	public void setBusinessDelete(JButton businessDelete) {
		this.businessDelete = businessDelete;
	}
}
