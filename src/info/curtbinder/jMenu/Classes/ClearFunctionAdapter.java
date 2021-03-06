package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFunctionAdapter implements ActionListener {

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		// clear the current code in the window
		MenuApp.getFrame().setMenuEntryCode( "" ); //$NON-NLS-1$
	}

}
