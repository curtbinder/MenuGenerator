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

public class LoadSimpleMenuAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent e ) {
		int ret =
				JOptionPane
						.showConfirmDialog( MenuApp.getFrame(),
											Messages.getString( "LoadSimpleMenuAdapter.SimpleMenuDescription" ), //$NON-NLS-1$
											Messages.getString( "LoadSimpleMenuAdapter.SimpleMenu" ), //$NON-NLS-1$
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
