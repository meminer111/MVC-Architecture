package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controllers.HomePageController;



public class HomePage extends JFrame{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JButton adminButton;
		JButton tourismButton;
		JButton studentButton;
		JButton jobButton;
		JButton businessButton;
	
		HomePageController controller;
		
		public HomePage() {

			this.setTitle("HomePage");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(1920,1080);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout()); // Bordered layout used for easier placement

			JPanel top = new JPanel(); // Creates the panels for put on the this
			JPanel center = new JPanel();

			top.setPreferredSize(new Dimension(100,100)); // Sets size of panels
			center.setPreferredSize(new Dimension(100,100));
			top.setBackground(new Color(0,40,0)); // Sets background colour of panels
			center.setBackground(new Color(0,0,0));
			top.setLayout(new FlowLayout()); // sets the layout for the top panel as flow layout
			
			this.add(top,BorderLayout.NORTH); // Adds the pannels to the this at the top and center
			this.add(center,BorderLayout.CENTER);

			// adds the background as image logo
			JLabel l1 = new JLabel(""); // creates a new image and scales it to correct size
			ImageIcon image = new ImageIcon(new ImageIcon("Images/icons/Background.jpg").getImage().getScaledInstance(1980, 980, Image.SCALE_DEFAULT)); 
			l1.setIcon(image);
			center.add(l1);
			
			adminButton = new JButton("Admin"); // Creates new buttons for the home page
			adminButton.setPreferredSize(new Dimension(200, 80));
			adminButton.setBackground(Color.gray);
			adminButton.setFocusPainted(false);
			adminButton.setFont(new Font("Arial", Font.BOLD, 20));
			adminButton.setForeground(Color.WHITE);

			
			tourismButton = new JButton("Tourism info");
			tourismButton.setPreferredSize(new Dimension(200, 80));
			tourismButton.setBackground(Color.gray);
			tourismButton.setFocusPainted(false);
			tourismButton.setFont(new Font("Arial", Font.BOLD, 18));
			tourismButton.setForeground(Color.WHITE);
			
			studentButton = new JButton("Student info");
			studentButton.setPreferredSize(new Dimension(200, 80));
			studentButton.setBackground(Color.gray);
			studentButton.setFocusPainted(false);
			studentButton.setFont(new Font("Arial", Font.BOLD, 18));
			studentButton.setForeground(Color.WHITE);
			
			jobButton = new JButton("Job info");
			jobButton.setPreferredSize(new Dimension(200, 80));
			jobButton.setBackground(Color.gray);
			jobButton.setFocusPainted(false);
			jobButton.setFont(new Font("Arial", Font.BOLD, 18));
			jobButton.setForeground(Color.WHITE);
			
			businessButton = new JButton("Business info");
			businessButton.setPreferredSize(new Dimension(200, 80));
			businessButton.setBackground(Color.gray);
			businessButton.setFocusPainted(false);
			businessButton.setFont(new Font("Arial", Font.BOLD, 18));
			businessButton.setForeground(Color.WHITE);

			top.add(adminButton); // Adds buttons to top layer
			top.add(tourismButton);
			top.add(studentButton);
			top.add(jobButton);
			top.add(businessButton);

			controller = new HomePageController(this); // creates controller
		
			this.setVisible(true);
		}
		
		public JFrame getHomePage() {
			return this;
		}
		
		public JButton getAdminButton() {
			return adminButton;
		}

		public void setAdminButton(JButton adminButton) {
			this.adminButton = adminButton;
		}
		
		public JButton getTourismButton() {
			return tourismButton;
		}

		public void setTourismButton(JButton tourismButton) {
			this.tourismButton = tourismButton;
		}
		
		public JButton getStudentButton() {
			return studentButton;
		}

		public void setStudentButton(JButton studentButton) {
			this.studentButton = studentButton;
		}
		
		public JButton getJobButton() {
			return jobButton;
		}

		public void setJobButton(JButton jobButton) {
			this.jobButton = jobButton;
		}
		
		public JButton getBusinessButton() {
			return businessButton;
		}

		public void setBusinessButton(JButton businessButton) {
			this.businessButton = businessButton;
		}

}
