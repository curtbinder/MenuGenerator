package info.curtbinder.jMenu.UI;

import info.curtbinder.jMenu.Classes.ControllerMenu;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class MenuApp {

	private static MainFrame frame;
	private static ControllerMenu controller;

	/**
	 * Launch the application.
	 */
	public static void main ( String[] args ) {
		controller = new ControllerMenu();
		
		EventQueue.invokeLater( new Runnable() {
			public void run ( ) {
				try {
					frame = new MainFrame();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}
	
	public static MainFrame getFrame ( ) {
		return frame;
	}
	
	public static ControllerMenu getController ( ) {
		return controller;
	}

	public static void displayMessageBox ( String message ) {
		JOptionPane.showMessageDialog(	frame,
										message,
										"Message",
										JOptionPane.INFORMATION_MESSAGE );
	}

}
