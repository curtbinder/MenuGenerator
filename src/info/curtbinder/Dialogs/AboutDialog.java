package info.curtbinder.Dialogs;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

public class AboutDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2285475934781331947L;
	private static final int minWidth = 360;
	private static final int minHeight = 300;
	private JLabel lblAppIcon = new JLabel();
	private JLabel lblAppName = new JLabel( "" ); //$NON-NLS-1$
	private JLabel lblAppVersion = new JLabel( "" ); //$NON-NLS-1$
	private JLabel lblDescription = new JLabel( "" ); //$NON-NLS-1$
	private JLabel lblCopyright = new JLabel( "" ); //$NON-NLS-1$
	private JLabel lblBanner = new JLabel();
	private JLabel lblUrl = new JLabel();
	private JButton btnCredits = new JButton(
		Messages.getString( "AboutDialog.Credits" ) ); //$NON-NLS-1$
	private JButton btnLicense = new JButton(
		Messages.getString( "AboutDialog.License" ) ); //$NON-NLS-1$
	private String[] arrayCredits = new String[0];
	private String sLicense = new String();

	private AboutDialog aDlg;

	public AboutDialog ( final JFrame owner, ImageIcon appIcon, String appName,
							String description ) {
		super( owner );
		aDlg = this;
		JPanel contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BoxLayout( contentPane, BoxLayout.Y_AXIS ) );
		setContentPane( contentPane );

		// Info panel
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout( new BoxLayout( infoPanel, BoxLayout.Y_AXIS ) );
		infoPanel.setAlignmentY( Component.CENTER_ALIGNMENT );
		// add icon
		lblAppIcon.setIcon( appIcon );
		lblAppIcon.setAlignmentX( Component.CENTER_ALIGNMENT );
		infoPanel.add( lblAppIcon );
		infoPanel.add( Box.createVerticalStrut( 5 ) );
		// App Info panel - contains app name and version
		setAppName( appName );
		JPanel appInfoPanel = new JPanel();
		appInfoPanel
				.setLayout( new BoxLayout( appInfoPanel, BoxLayout.X_AXIS ) );
		appInfoPanel.setAlignmentY( Component.CENTER_ALIGNMENT );
		appInfoPanel.add( lblAppName );
		appInfoPanel.add( Box.createHorizontalStrut( 5 ) );
		appInfoPanel.add( lblAppVersion );
		infoPanel.add( appInfoPanel );
		infoPanel.add( Box.createVerticalStrut( 5 ) );
		setDescription( description );
		lblDescription.setAlignmentX( Component.CENTER_ALIGNMENT );
		lblDescription.setFont( new Font( "Dialog", Font.PLAIN, 12 ) ); //$NON-NLS-1$
		infoPanel.add( lblDescription );
		infoPanel.add( Box.createVerticalStrut( 5 ) );
		lblCopyright.setAlignmentX( Component.CENTER_ALIGNMENT );
		lblCopyright.setFont( new Font( "Dialog", Font.PLAIN, 12 ) ); //$NON-NLS-1$
		infoPanel.add( lblCopyright );
		infoPanel.add( Box.createVerticalStrut( 5 ) );
		// add banner
		lblBanner.setAlignmentX( Component.CENTER_ALIGNMENT );
		lblBanner.setBorder( BorderFactory.createLineBorder( Color.black ) );
		infoPanel.add( lblBanner );
		infoPanel.add( Box.createVerticalStrut( 5 ) );
		lblUrl.setAlignmentX( Component.CENTER_ALIGNMENT );
		lblUrl.setForeground( Color.BLUE );
		// lblUrl.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblUrl.addMouseListener( new MouseAdapter() {
			public void mouseClicked ( MouseEvent e ) {
				java.awt.Desktop d = java.awt.Desktop.getDesktop();
				java.net.URI url;
				try {
					System.out.print( "Create URL: " + lblUrl.getText() + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
					url = new java.net.URI( lblUrl.getText() );
				} catch ( URISyntaxException e1 ) {
					// invalid URL
					JOptionPane.showMessageDialog(	aDlg,
													Messages.getString( "AboutDialog.ErrorWithURL" ) //$NON-NLS-1$
															+ lblUrl.getText(),
													Messages.getString( "AboutDialog.InvalidURL" ), //$NON-NLS-1$
													JOptionPane.INFORMATION_MESSAGE );
					return;
				}
				try {
					System.out.print( "Launch browser: " + url.toString() //$NON-NLS-1$
										+ "\n" ); //$NON-NLS-1$
					d.browse( url );
				} catch ( IOException e1 ) {
					// error loading URL
					JOptionPane.showMessageDialog(	aDlg,
													Messages.getString( "AboutDialog.ErrorLoadingURL" ) //$NON-NLS-1$
															+ lblUrl.getText(),
													Messages.getString( "AboutDialog.ErrorLoading" ), //$NON-NLS-1$
													JOptionPane.INFORMATION_MESSAGE );
				}
			}
		} );
		infoPanel.add( lblUrl );

		// Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout( new BoxLayout( buttonPanel, BoxLayout.X_AXIS ) );
		buttonPanel.setAlignmentY( Component.BOTTOM_ALIGNMENT );
		btnCredits.setFont( new Font( "Dialog", Font.PLAIN, 12 ) ); //$NON-NLS-1$
		btnCredits.addActionListener( new ActionListener() {
			public void actionPerformed ( ActionEvent ev ) {
				TextDialog d =
						new TextDialog(
							aDlg,
							Messages.getString( "AboutDialog.Credits" ), Messages.getString( "AboutDialog.Contributors" ) ); //$NON-NLS-1$ //$NON-NLS-2$
				d.setWindowList( aDlg.arrayCredits );
				d.showDialog();
			}
		} );
		btnLicense.setFont( new Font( "Dialog", Font.PLAIN, 12 ) ); //$NON-NLS-1$
		btnLicense.addActionListener( new ActionListener() {
			public void actionPerformed ( ActionEvent ev ) {
				TextDialog d =
						new TextDialog(
							aDlg,
							Messages.getString( "AboutDialog.License" ), Messages.getString( "AboutDialog.LegalText" ), 300, 200 ); //$NON-NLS-1$ //$NON-NLS-2$
				d.setWindowText( aDlg.sLicense );
				d.showDialog();
			}
		} );
		JButton btnClose = new JButton( Messages.getString( "Dialog.Close" ) ); //$NON-NLS-1$
		btnClose.setFont( new Font( "Dialog", Font.PLAIN, 12 ) ); //$NON-NLS-1$
		btnClose.addActionListener( new ActionListener() {
			public void actionPerformed ( ActionEvent ev ) {
				setVisible( false );
				dispose();
			}
		} );
		buttonPanel.add( btnCredits );
		buttonPanel.add( Box.createHorizontalStrut( 5 ) );
		buttonPanel.add( btnLicense );
		buttonPanel.add( Box.createHorizontalGlue() );
		buttonPanel.add( btnClose );

		contentPane.add( infoPanel );
		contentPane.add( Box.createVerticalStrut( 5 ) );
		contentPane.add( buttonPanel );

		setMinimumSize( new Dimension( minWidth, minHeight ) );
	}

	void setAppName ( String appName ) {
		lblAppName.setText( appName );
		setTitle( Messages.getString( "AboutDialog.About" ) + appName ); //$NON-NLS-1$
	}

	public void setAppVersion ( int major, int minor, int revision, String build ) {
		String v = major + "." + minor + "." + revision; //$NON-NLS-1$ //$NON-NLS-2$
		if ( !build.isEmpty() ) {
			v += "-" + build; //$NON-NLS-1$
		}
		lblAppVersion.setText( v );
	}

	public void setDescription ( String desc ) {
		lblDescription.setText( desc );
	}

	public void setCopyright ( String copyright ) {
		lblCopyright.setText( copyright );
	}

	public void setBanner ( ImageIcon i ) {
		lblBanner.setIcon( i );
	}

	public void setURL ( String url ) {
		lblUrl.setText( url );
	}

	public void setCreditors ( String[] creditors ) {
		arrayCredits = creditors;
	}

	public void setLicense ( String s ) {
		sLicense = s;
	}

	public void showAbout ( ) {
		setLocationRelativeTo( getParent() );
		if ( lblBanner.getIcon() == null ) {
			lblBanner.setVisible( false );
		}
		if ( lblUrl.getText().isEmpty() ) {
			lblUrl.setVisible( false );
		}
		if ( arrayCredits.length == 0 ) {
			// no credits, so hide
			btnCredits.setVisible( false );
		}
		if ( sLicense.isEmpty() ) {
			btnLicense.setVisible( false );
		}
		setVisible( true );
	}
}
