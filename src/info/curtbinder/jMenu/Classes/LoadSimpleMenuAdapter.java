package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoadSimpleMenuAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		int ret =
				JOptionPane
						.showConfirmDialog( MenuApp.getFrame(),
											"This will replace your menu with the simple menu.\n\nAre you sure?",
											"Load Simple Menu",
											JOptionPane.YES_NO_OPTION );
		if ( ret == JOptionPane.NO_OPTION ) {
			return;
		}

		// load the simple menu
		MainFrame f = MenuApp.getFrame();
		ControllerMenu c = MenuApp.getController();
		c.loadSimpleMenu();
		f.resetMenuLabelAndCode();
		f.resetMenuEntryList();
		f.setMenuQuantity( c.getMenuQuantity() );
	}

}
