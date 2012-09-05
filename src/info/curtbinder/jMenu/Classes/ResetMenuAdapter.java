package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ResetMenuAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		int ret =
				JOptionPane
						.showConfirmDialog( MenuApp.getFrame(),
											"This will reset your menu completely.\n\nAre you sure?",
											"Reset Menu",
											JOptionPane.YES_NO_OPTION );
		if ( ret == JOptionPane.NO_OPTION ) {
			return;
		}

		/*
		 * Reset the Menu, Reset the Menu Entry List, Update the Menu Label and
		 * Code windows with the first entry, Update the Menu Entry Quantity
		 */
		MainFrame f = MenuApp.getFrame();
		ControllerMenu c = MenuApp.getController();
		c.resetMenu();
		f.resetMenuLabelAndCode();
		f.resetMenuEntryList();
		f.setMenuQuantity( c.getMenuQuantity() );
	}

}
