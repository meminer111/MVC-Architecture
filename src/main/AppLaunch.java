package main;

import javax.swing.SwingUtilities;

import view.HomePage;

public class AppLaunch {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				try {
					new HomePage();
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});		
	}
}
