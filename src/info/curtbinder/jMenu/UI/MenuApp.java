package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

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
					frame.updateDisplay();
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

	public static void displayMessageBox ( String message, String title ) {
		JOptionPane.showMessageDialog(	frame,
										message,
										title,
										JOptionPane.INFORMATION_MESSAGE );
	}

}
