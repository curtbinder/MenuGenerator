package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetMenuAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		MenuApp.displayMessageBox( "Reset Button pressed" );
	}

}
