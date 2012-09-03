package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadSimpleMenuAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		MenuApp.displayMessageBox( "Load Simple Menu Button pressed" );
	}

}
