package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		// save current menu entry
		MenuApp.getController().saveCurrentEntry();
		// generate code
		MenuApp.getController().generateCode();
	}

}
