package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.CodeWindow;
import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

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
			s = String.format( "Menu Entry %d", i + 1 );
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
		System.out.println( "save current entry" );
		// call before generating or saving file
		// save current menu entry
		MainFrame f = MenuApp.getFrame();
		int i = f.getCurrentMenuEntry();
		setMenuLabel( i, f.getMenuEntryLabel() );
		setMenuCode( i, f.getMenuEntryCode() );
	}

	// add in Load / Save
	public void loadXML ( ) {

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
				path += "." + XMLFileFilter.XML_EXTENSION;
			}

			if ( f.exists() ) {
				String s =
						"'"
								+ path
								+ "' exists\n\nDo you wish to overwrite this file?";
				int ret =
						JOptionPane
								.showConfirmDialog( MenuApp.getFrame(), s,
													"Overwrite file",
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
				XMLStreamWriter w = of.createXMLStreamWriter( os, "utf-8" );
				w.writeStartDocument( "utf-8", "1.0" );
				w.writeStartElement( Constants.xmlMenuStart );

				String pos;
				for ( int i = 0; i < iMenuQuantity; i++ ) {
					pos = String.format( "%d", i + 1 );
					w.writeStartElement( Constants.xmlMenu );
					w.writeAttribute( Constants.xmlAtributePosition, pos );
					w.writeAttribute( Constants.xmlAttributeLabel, saLabels[i] );
					w.writeCharacters( saCode[i] );
					w.writeEndElement();
				}

				w.writeEndElement();
				w.writeEndDocument();
				w.flush();
				fComplete = true;
			} catch ( FileNotFoundException e ) {
				e.printStackTrace();
			} catch ( XMLStreamException e ) {
				e.printStackTrace();
			}

			String msg;
			if ( fComplete ) {
				msg = "Successfully saved:\n\n " + path;
			} else {
				msg = "Failed to save:\n\n" + path;
			}
			MenuApp.displayMessageBox( msg, "Saved file" );
		}
	}

	public void resetMenu ( ) {
		System.out.println( "Reset Menu" );
		iMenuQuantity = DEFAULT_ENTRIES;
		loadInitialMenu();
	}

	private void loadInitialMenu ( ) {
		String s;
		for ( int i = 0; i < MAX_MENU_ENTRIES; i++ ) {
			s = String.format( "Menu Entry %d", i + 1 );
			saLabels[i] = s;
			s =
					String.format(	"ReefAngel.DisplayMenuEntry(\"Item %d\");",
									i + 1 );
			saCode[i] = s;
		}
	}

	public void loadSimpleMenu ( ) {
		System.out.println( "Load simple menu" );
		iMenuQuantity = DEFAULT_ENTRIES;
		saLabels[0] = "Feeding";
		saCode[0] = "ReefAngel.FeedingModeStart();\r\n";
		saLabels[1] = "Water Change";
		saCode[1] = "ReefAngel.WaterChangeModeStart();\r\n";
		saLabels[2] = "ATO Clear";
		saCode[2] =
				"ReefAngel.ATOClear();\r\nReefAngel.DisplayMenuEntry(\"Clear ATO Timeout\");\r\n";
		saLabels[3] = "Overheat Clear";
		saCode[3] =
				"ReefAngel.OverheatClear();\r\nReefAngel.DisplayMenuEntry(\"Clear Overheat\");\r\n";
		saLabels[4] = "PH Calibration";
		saCode[4] =
				"ReefAngel.SetupCalibratePH();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n";
		saLabels[5] = "Version";
		saCode[5] = "ReefAngel.DisplayVersion();\r\n";
	}

	public void generateCode ( ) {
		// generate the output code for the menus
		StringBuilder sb = new StringBuilder( 8192 );
		StringBuilder sbCode = new StringBuilder( 4096 );
		String sLabels = "";
		String sMenus = "PROGMEM const char *menu_items[] = {\r\n";
		String s;
		sb.append( "#include <avr/pgmspace.h>\r\n" );
		for ( int i = 0; i < iMenuQuantity; i++ ) {
			s =
					String.format(	"prog_char menu%d_label[] PROGMEM = \"%s\";\r\n",
									i, saLabels[i] );
			sLabels += s;
			s =
					String.format(	"menu%d_label%c ", i,
									(i + 1 == iMenuQuantity) ? ' ' : ',' );
			sMenus += s;
			s = String.format( "void MenuEntry%d()\r\n{\r\n", i + 1 );
			sbCode.append( s );
			sbCode.append( saCode[i] );
			sbCode.append( "\r\n}\r\n" );
		}
		sMenus += "};\r\n\r\n";

		sb.append( sLabels );
		sb.append( sMenus );
		sb.append( sbCode );

		String sInit =
				"// Initialize the menu\r\nReefAngel.InitMenu(pgm_read_word(&(menu_items[0])),SIZE(menu_items));";
		CodeWindow cw = null;
		boolean canProceed = true;
		Window[] dialogs = JDialog.getWindows();
		for ( Window dlg : dialogs ) {
			if ( dlg.getClass().equals( CodeWindow.class ) ) {
				if ( dlg.isDisplayable() ) {
					System.out.println( "found textdialog" );
					cw = (CodeWindow) dlg;
					canProceed = false;
				}
				if ( !canProceed ) {
					break;
				}
			}
		}
		if ( canProceed ) {
			cw = new CodeWindow ( MenuApp.getFrame() );
		}
		cw.setCodeText( sb );
		cw.setCodeSetup( sInit );
		cw.setLocationRelativeTo( cw.getParent() );
		cw.setVisible( true );
	}
}
