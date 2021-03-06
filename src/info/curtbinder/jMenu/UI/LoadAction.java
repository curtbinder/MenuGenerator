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

public class LoadAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadAction () {
		putValue( NAME, Messages.getString( "LoadAction.LoadXML" ) ); //$NON-NLS-1$
	}

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		// call Load function
		MenuApp.getController().loadXML();
	}

}
