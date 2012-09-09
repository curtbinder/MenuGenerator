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

import javax.swing.AbstractAction;

public class AddFunctionAdapter extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code = ""; //$NON-NLS-1$

	public AddFunctionAdapter ( String code ) {
		this.code = code;
	}

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		MenuApp.getFrame().updateMenuEntryCode( code );
	}

}
