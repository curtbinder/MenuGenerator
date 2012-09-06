package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar () {
		super();

		JMenu mnFile = new JMenu( "File" );
		add( mnFile );

		JMenuItem mntmExit = new JMenuItem( new ExitAction() );
		JMenuItem mntmSave = new JMenuItem( new SaveAction() );
		
		mnFile.add( mntmSave );
		mnFile.addSeparator();
		mnFile.add( mntmExit );
	}

}
