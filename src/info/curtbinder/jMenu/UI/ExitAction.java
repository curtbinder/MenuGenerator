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

public class ExitAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed ( ActionEvent e ) {
		System.exit( 0 );
	}

	public ExitAction () {
		putValue( NAME, Messages.getString( "ExitAction.Exit" ) ); //$NON-NLS-1$
	}

}
