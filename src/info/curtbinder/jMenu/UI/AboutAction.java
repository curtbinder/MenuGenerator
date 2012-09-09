package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import info.curtbinder.Dialogs.AboutDialog;
import info.curtbinder.jMenu.Classes.Constants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class AboutAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed ( ActionEvent e ) {
		AboutDialog d =
				new AboutDialog( MenuApp.getFrame(), null,
					"Menu Generator", "Generates a custom menu for the Reef Angel" );
		d.setAppVersion(	Constants.versionMajor, Constants.versionMinor,
		                	Constants.versionRevision, Constants.versionBuild );
		d.setCopyright( "Copyright 2012 Curt Binder" );
		//d.setBanner( new ImageIcon( MainFrame.class.getResource( Globals.bannerIconName ) ) );
		d.setURL( "http://curtbinder.info/" );
		d.setCreditors( new String[] { "Curt Binder" } );
		d.setLicense( "License Text" );
		d.showAbout();
	}

	public AboutAction () {
		putValue( NAME, "About" );
	}

}
