package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFunctionAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		// clear the current code in the window
		MenuApp.getFrame().setMenuEntryCode( "" );
	}

}
