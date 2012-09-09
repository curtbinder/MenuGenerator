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
				new AboutDialog( MenuApp.getFrame(), null, Constants.appTitle,
					Messages.getString( "AboutAction.AppDescription" ) ); //$NON-NLS-1$
		d.setAppVersion(	Constants.versionMajor, Constants.versionMinor,
							Constants.versionRevision, Constants.versionBuild );
		d.setCopyright( Messages.getString( "AboutAction.Copyright" ) ); //$NON-NLS-1$
		d.setBanner( new ImageIcon( MainFrame.class
				.getResource( Constants.bannerIconName ) ) );
		d.setURL( "http://curtbinder.info/" ); //$NON-NLS-1$
		d.setCreditors( new String[] { "Curt Binder" } ); //$NON-NLS-1$
		d.setLicense( Messages.getString( "AboutAction.License1" ) //$NON-NLS-1$
						+ Messages.getString( "AboutAction.License2" ) //$NON-NLS-1$
						+ Messages.getString( "AboutAction.License3" ) ); //$NON-NLS-1$
		d.showAbout();
	}

	public AboutAction () {
		putValue( NAME, Messages.getString( "AboutAction.About" ) ); //$NON-NLS-1$
	}

}
