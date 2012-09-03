package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		// save current menu entry
		ControllerMenu c = MenuApp.getController();
		MainFrame f = MenuApp.getFrame(); 
		int i = f.getCurrentMenuEntry();
		c.setMenuLabel( i, f.getMenuEntryLabel() );
		c.setMenuCode( i, f.getMenuEntryCode() );
		
		// generate code
		c.generateCode();
	}

}
