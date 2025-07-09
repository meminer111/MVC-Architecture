package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.BusinessPageController;
import model.BusinessModel;

public class BusinessPage extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox serviceSelector;
	BusinessPageController controller;
	BusinessModel model;
	
	JTable table;

	
	public BusinessPage() {

		this.setTitle("HomePage");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1920,1080);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new FlowLayout()); // Flow layout used for easier placement
		
		// Creates a combo box with these values
		String[] services = {"Finance", "Food", "Manufacturing","Ecommerce"};
		serviceSelector = new JComboBox(services);
		
		JScrollPane scrollPane = new JScrollPane(); // creates new top left scroll pane
		scrollPane.setPreferredSize(new Dimension(800,400));
		
		this.add(serviceSelector);
		// adds the table to the top left
		this.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new BusinessModel();
		controller = new BusinessPageController(this, model);

		this.setVisible(true);
	}


	/**
	 * @return the serviceSelector
	 */
	public JComboBox getServiceSelector() {
		return serviceSelector;
	}


	/**
	 * @param serviceSelector the serviceSelector to set
	 */
	public void setServiceSelector(JComboBox serviceSelector) {
		this.serviceSelector = serviceSelector;
	}


	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}


	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}
}
