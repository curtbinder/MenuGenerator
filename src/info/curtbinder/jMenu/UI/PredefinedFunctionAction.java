package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class PredefinedFunctionAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredefinedFunctionAction () {
		putValue(	NAME,
					Messages.getString( "PredefinedFunctionAction.PredefinedFunctions" ) ); //$NON-NLS-1$
	}

	@Override
	public void actionPerformed ( ActionEvent e ) {
		PredefinedMenu menu = new PredefinedMenu();
		JButton b = MenuApp.getFrame().getPredefinedButton();
		menu.show( b, 0, b.getHeight() );
	}
}
