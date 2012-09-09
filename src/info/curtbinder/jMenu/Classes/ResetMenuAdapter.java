package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

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
											Messages.getString( "ResetMenuAdapter.ResetDescription" ), //$NON-NLS-1$
											Messages.getString( "ResetMenuAdapter.Reset" ), //$NON-NLS-1$
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
