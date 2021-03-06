package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import info.curtbinder.jMenu.UI.CodeWindow;
import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class ControllerMenu {

	public static final int MAX_MENU_ENTRIES = 9;
	public static final int DEFAULT_ENTRIES = 6;
	public static final int MAX_SIMPLE_MENU_ENTRIES = 6;

	private int iMenuQuantity;
	private String[] saLabels;
	private String[] saCode;

	public ControllerMenu () {
		iMenuQuantity = DEFAULT_ENTRIES;
		saLabels = new String[MAX_MENU_ENTRIES];
		saCode = new String[MAX_MENU_ENTRIES];
		for ( int i = 0; i < MAX_MENU_ENTRIES; i++ ) {
			saLabels[i] = new String();
			saCode[i] = new String();
		}
		loadInitialMenu();
	}

	public void setMenuQuantity ( int qty ) {
		iMenuQuantity = qty;
	}

	public int getMenuQuantity ( ) {
		return iMenuQuantity;
	}

	public DefaultComboBoxModel getMenuEntryComboList ( ) {
		String[] l = new String[iMenuQuantity];
		String s;
		for ( int i = 0; i < iMenuQuantity; i++ ) {
			s =
					String.format(	Messages.getString( "ControllerMenu.MenuEntryFormat" ), i + 1 ); //$NON-NLS-1$
			l[i] = s;
		}
		DefaultComboBoxModel aModel = new DefaultComboBoxModel( l );
		return aModel;
	}

	public String getMenuLabel ( int position ) {
		// 1 based index
		return saLabels[position - 1];
	}

	public void setMenuLabel ( int position, String label ) {
		// 1 based index
		saLabels[position - 1] = label;
	}

	public String getMenuCode ( int position ) {
		// 1 based index
		return saCode[position - 1];
	}

	public void setMenuCode ( int position, String code ) {
		// 1 based index
		saCode[position - 1] = code;
	}

	public void saveCurrentEntry ( ) {
		// call before generating or saving file
		// save current menu entry
		MainFrame f = MenuApp.getFrame();
		int i = f.getCurrentMenuEntry();
		setMenuLabel( i, f.getMenuEntryLabel() );
		setMenuCode( i, f.getMenuEntryCode() );
	}

	// add in Load / Save
	public void loadXML ( ) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		chooser.setAcceptAllFileFilterUsed( false );
		chooser.addChoosableFileFilter( new XMLFileFilter() );
		int option = chooser.showOpenDialog( MenuApp.getFrame() );
		if ( option == JFileChooser.APPROVE_OPTION ) {
			// clicked Save
			File f = chooser.getSelectedFile();
			System.out.println( "Chose file: " + f.getAbsolutePath() );

			FileReader fr;
			try {
				// open the file
				fr = new FileReader( f );
				BufferedReader in = new BufferedReader( fr );

				// parse through XML file handler
				LoadXMLHandler xf = new LoadXMLHandler();
				if ( parseXML( xf, in ) ) {
					// successful parsing
					// save the menu
					setMenuQuantity( xf.getMenuQuantity() );
					for ( int i = 1; i <= xf.getMenuQuantity(); i++ ) {
						setMenuLabel( i, xf.getLabel( i ) );
						setMenuCode( i, xf.getCode( i ) );
					}
					// reload the menu
					MenuApp.getFrame().resetMenuLabelAndCode();
					MenuApp.getFrame().resetMenuEntryList();
					MenuApp.getFrame().setMenuQuantity( xf.getMenuQuantity() );
				}

				if ( in != null ) {
					in.close();
				}
				if ( fr != null ) {
					fr.close();
				}
			} catch ( FileNotFoundException e ) {
				e.printStackTrace();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	private boolean parseXML ( LoadXMLHandler xf, BufferedReader in ) {
		boolean fRet = false;
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = null;
		XMLReader xr = null;
		try {
			sp = spf.newSAXParser();
			xr = sp.getXMLReader();
			xr.setContentHandler( (ContentHandler) xf );
			xr.setErrorHandler( (ErrorHandler) xf );
			xr.parse( new InputSource( in ) );
			fRet = true;
		} catch ( ParserConfigurationException e ) {
			e.printStackTrace();
		} catch ( SAXException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return fRet;
	}

	public void saveXML ( ) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		chooser.setAcceptAllFileFilterUsed( false );
		chooser.addChoosableFileFilter( new XMLFileFilter() );
		int option = chooser.showSaveDialog( MenuApp.getFrame() );
		if ( option == JFileChooser.APPROVE_OPTION ) {
			// clicked Save
			File f = chooser.getSelectedFile();
			String path = f.getPath();
			String ext = XMLFileFilter.getExtension( f );
			if ( ext == null ) {
				// didn't give an extension, add the extension
				path += "." + XMLFileFilter.XML_EXTENSION; //$NON-NLS-1$
			}

			if ( f.exists() ) {
				String s =
						String.format(	Messages.getString( "ControllerMenu.OverwriteFileFormat" ), //$NON-NLS-1$
										path );
				int ret =
						JOptionPane
								.showConfirmDialog( MenuApp.getFrame(),
													s,
													Messages.getString( "ControllerMenu.OverwriteFile" ), //$NON-NLS-1$
													JOptionPane.YES_NO_OPTION );
				if ( ret == JOptionPane.NO_OPTION ) {
					return;
				}
			}

			boolean fComplete = false;
			try {
				OutputStream os;
				os = new FileOutputStream( path );
				XMLOutputFactory of = XMLOutputFactory.newInstance();
				XMLStreamWriter w = of.createXMLStreamWriter( os, "utf-8" ); //$NON-NLS-1$
				w.writeStartDocument( "utf-8", "1.0" ); //$NON-NLS-1$ //$NON-NLS-2$
				w.writeStartElement( Constants.xmlMenuStart );

				String pos;
				for ( int i = 0; i < iMenuQuantity; i++ ) {
					pos = String.format( "%d", i + 1 ); //$NON-NLS-1$
					w.writeStartElement( Constants.xmlMenu );
					w.writeAttribute( Constants.xmlAtributePosition, pos );
					w.writeAttribute( Constants.xmlAttributeLabel, saLabels[i] );
					w.writeCharacters( saCode[i] );
					w.writeEndElement();
				}

				w.writeEndElement();
				w.writeEndDocument();
				w.flush();
				w.close();
				os.close();
				fComplete = true;
			} catch ( FileNotFoundException e ) {
				e.printStackTrace();
			} catch ( XMLStreamException e ) {
				e.printStackTrace();
			} catch ( IOException e ) {
				e.printStackTrace();
			}

			String msg;
			if ( fComplete ) {
				msg =
						Messages.getString( "ControllerMenu.SuccessullySaved" ) + path; //$NON-NLS-1$
			} else {
				msg =
						Messages.getString( "ControllerMenu.FailedToSave" ) + path; //$NON-NLS-1$
			}
			MenuApp.displayMessageBox( msg, Messages
					.getString( "ControllerMenu.SavedFile" ) ); //$NON-NLS-1$
		}
	}

	public void resetMenu ( ) {
		iMenuQuantity = DEFAULT_ENTRIES;
		loadInitialMenu();
	}

	private void loadInitialMenu ( ) {
		String s;
		for ( int i = 0; i < MAX_MENU_ENTRIES; i++ ) {
			s =
					String.format(	Messages.getString( "ControllerMenu.MenuEntryFormat" ), i + 1 ); //$NON-NLS-1$
			saLabels[i] = s;
			s = String.format( "ReefAngel.DisplayMenuEntry(\"Item %d\");", //$NON-NLS-1$
								i + 1 );
			saCode[i] = s;
		}
	}

	public void loadSimpleMenu ( ) {
		iMenuQuantity = DEFAULT_ENTRIES;
		saLabels[0] = Messages.getString( "ControllerMenu.FeedingFunction" ); //$NON-NLS-1$
		saCode[0] = "ReefAngel.FeedingModeStart();\r\n"; //$NON-NLS-1$
		saLabels[1] = Messages.getString( "ControllerMenu.WaterChangeFunction" ); //$NON-NLS-1$
		saCode[1] = "ReefAngel.WaterChangeModeStart();\r\n"; //$NON-NLS-1$
		saLabels[2] = Messages.getString( "ControllerMenu.ATOClearFunction" ); //$NON-NLS-1$
		saCode[2] =
				"ReefAngel.ATOClear();\r\nReefAngel.DisplayMenuEntry(\"Clear ATO Timeout\");\r\n"; //$NON-NLS-1$
		saLabels[3] =
				Messages.getString( "ControllerMenu.OverheatClearFunction" ); //$NON-NLS-1$
		saCode[3] =
				"ReefAngel.OverheatClear();\r\nReefAngel.DisplayMenuEntry(\"Clear Overheat\");\r\n"; //$NON-NLS-1$
		saLabels[4] =
				Messages.getString( "ControllerMenu.PHCalibrationFunction" ); //$NON-NLS-1$
		saCode[4] =
				"ReefAngel.SetupCalibratePH();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n"; //$NON-NLS-1$
		saLabels[5] = Messages.getString( "ControllerMenu.VersionFunction" ); //$NON-NLS-1$
		saCode[5] = "ReefAngel.DisplayVersion();\r\n"; //$NON-NLS-1$
	}

	public void generateCode ( ) {
		// generate the output code for the menus
		StringBuilder sb = new StringBuilder( 8192 );
		StringBuilder sbCode = new StringBuilder( 4096 );
		String sLabels = ""; //$NON-NLS-1$
		String sMenus = "PROGMEM const char *menu_items[] = {\r\n"; //$NON-NLS-1$
		String s;
		sb.append( "#include <avr/pgmspace.h>\r\n" ); //$NON-NLS-1$
		for ( int i = 0; i < iMenuQuantity; i++ ) {
			s =
					String.format(	"prog_char menu%d_label[] PROGMEM = \"%s\";\r\n", //$NON-NLS-1$
									i, saLabels[i] );
			sLabels += s;
			s = String.format( "menu%d_label%c ", i, //$NON-NLS-1$
								(i + 1 == iMenuQuantity) ? ' ' : ',' );
			sMenus += s;
			s = String.format( "void MenuEntry%d()\r\n{\r\n", i + 1 ); //$NON-NLS-1$
			sbCode.append( s );
			sbCode.append( saCode[i] );
			sbCode.append( "\r\n}\r\n" ); //$NON-NLS-1$
		}
		sMenus += "};\r\n\r\n"; //$NON-NLS-1$

		sb.append( sLabels );
		sb.append( sMenus );
		sb.append( sbCode );

		String sInit =
				"// Initialize the menu\r\nReefAngel.InitMenu(pgm_read_word(&(menu_items[0])),SIZE(menu_items));"; //$NON-NLS-1$
		CodeWindow cw = null;
		boolean canProceed = true;
		Window[] dialogs = JDialog.getWindows();
		for ( Window dlg : dialogs ) {
			if ( dlg.getClass().equals( CodeWindow.class ) ) {
				if ( dlg.isDisplayable() ) {
					cw = (CodeWindow) dlg;
					canProceed = false;
				}
				if ( !canProceed ) {
					break;
				}
			}
		}
		if ( canProceed ) {
			cw = new CodeWindow( MenuApp.getFrame() );
		}
		cw.setCodeText( sb );
		cw.setCodeSetup( sInit );
		cw.setLocationRelativeTo( cw.getParent() );
		cw.setVisible( true );
	}
}
