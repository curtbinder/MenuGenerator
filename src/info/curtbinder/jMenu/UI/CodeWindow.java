package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class CodeWindow extends JDialog implements ClipboardOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2086654583810433708L;
	private JTextArea textCode;
	private JTextArea setupCode;

	public CodeWindow ( JFrame mainFrame ) {
		super( mainFrame );
		setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
		setMinimumSize( new Dimension( 500, 400 ) );
		setTitle( Messages.getString( "CodeWindow.OutputCode" ) ); //$NON-NLS-1$
		getContentPane().setLayout( new BoxLayout( getContentPane(),
										BoxLayout.X_AXIS ) );

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		getContentPane().add( verticalBox );

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add( horizontalBox );

		JLabel lblGlobalCode =
				new JLabel( Messages.getString( "CodeWindow.OutputDescription" ) ); //$NON-NLS-1$
		horizontalBox.add( lblGlobalCode );

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add( horizontalGlue );

		JButton btnCopyToClipboard =
				new JButton( Messages.getString( "CodeWindow.CopyClipboard" ) ); //$NON-NLS-1$
		btnCopyToClipboard.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent e ) {
				copyText( true );
			}
		} );
		horizontalBox.add( btnCopyToClipboard );

		Component rigidArea_2 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_2 );

		JScrollPane codeWindow = new JScrollPane();
		codeWindow
				.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		codeWindow.setAutoscrolls( true );
		verticalBox.add( codeWindow );
		textCode = new JTextArea();
		codeWindow.setViewportView( textCode );
		textCode.setAutoscrolls( false );
		textCode.setTabSize( 4 );
		textCode.setLineWrap( true );
		textCode.setEditable( false );

		Component rigidArea = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea );

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add( horizontalBox_1 );

		JLabel lblSetupCode =
				new JLabel( Messages.getString( "CodeWindow.SetupCode" ) ); //$NON-NLS-1$
		horizontalBox_1.add( lblSetupCode );

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add( horizontalGlue_1 );

		JButton btnCopyToClipboard_1 =
				new JButton( Messages.getString( "CodeWindow.CopyClipboard" ) ); //$NON-NLS-1$
		btnCopyToClipboard_1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed ( ActionEvent e ) {
				copyText( false );
			}
		} );
		horizontalBox_1.add( btnCopyToClipboard_1 );

		Component rigidArea_3 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_3 );

		JScrollPane initWindow = new JScrollPane();
		initWindow.setPreferredSize( new Dimension( 23, 50 ) );
		initWindow.setMaximumSize( new Dimension( 32767, 50 ) );
		initWindow.setMinimumSize( new Dimension( 23, 50 ) );
		initWindow
				.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		initWindow.setAutoscrolls( true );
		verticalBox.add( initWindow );
		setupCode = new JTextArea();
		initWindow.setViewportView( setupCode );
		setupCode.setAutoscrolls( false );
		setupCode.setTabSize( 4 );
		setupCode.setLineWrap( true );
		setupCode.setEditable( false );

		Component rigidArea_1 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_1 );

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add( horizontalBox_2 );

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add( horizontalGlue_2 );

		JButton btnClose =
				new JButton( Messages.getString( "CodeWindow.Close" ) ); //$NON-NLS-1$
		btnClose.addActionListener( new ActionListener() {
			public void actionPerformed ( ActionEvent ev ) {
				setVisible( false );
				dispose();
			}
		} );
		horizontalBox_2.add( btnClose );
	}

	public void setCodeText ( StringBuilder sb ) {
		textCode.setText( sb.toString() );
	}

	public void setCodeSetup ( String s ) {
		setupCode.setText( s );
	}

	@Override
	public void lostOwnership ( Clipboard arg0, Transferable arg1 ) {
	}

	protected void copyText ( boolean fCodeText ) {
		StringSelection sel = null;
		if ( fCodeText )
			sel = new StringSelection( textCode.getText() );
		else
			sel = new StringSelection( setupCode.getText() );

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents( sel, this );
	}
}
