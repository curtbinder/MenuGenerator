package info.curtbinder.jMenu.Classes;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LoadXMLHandler extends DefaultHandler {

	// private static final String TAG = LoadXMLHandler.class.getSimpleName();
	private boolean fValidFile;
	private boolean fValidEntry;
	private String currentElement = "";
	private int currentPosition = -1;
	private int menuQty = 0;
	private String[] saLabel;
	private String[] saCode;

	public LoadXMLHandler () {
		fValidFile = false;
		saLabel = new String[ControllerMenu.MAX_MENU_ENTRIES];
		saCode = new String[ControllerMenu.MAX_MENU_ENTRIES];
		for ( int i = 0; i < ControllerMenu.MAX_MENU_ENTRIES; i++ ) {
			saLabel[i] = new String();
			saCode[i] = new String();
		}
	}

	public String getLabel ( int position ) {
		return saLabel[position - 1];
	}

	public void setLabel ( int position, String label ) {
		saLabel[position - 1] = label;
	}

	public String getCode ( int position ) {
		return saCode[position - 1];
	}

	public void setCode ( int position, String code ) {
		saCode[position - 1] = code;
	}

	public int getMenuQuantity ( ) {
		return menuQty;
	}
	
	@Override
	public void endDocument ( ) throws SAXException {
		System.out.println("Loaded " + menuQty + " menu entries.");
	}

	@Override
	public void characters ( char[] ch, int start, int length )
			throws SAXException {
		String s = new String( ch, start, length );
		currentElement += s;
	}

	@Override
	public void endElement ( String uri, String localName, String qName )
			throws SAXException {
		String tag;
		if ( !qName.equals( "" ) ) {
			tag = qName;
		} else {
			tag = localName;
		}

		if ( fValidFile ) {
			if ( tag.equals( Constants.xmlMenu ) ) {
				if ( fValidEntry ) {
					setCode( currentPosition, currentElement );
				}
			}
		}
		currentElement = "";
		currentPosition = -1;
	}

	@Override
	public void startElement (
			String uri,
			String localName,
			String qName,
			Attributes attr ) throws SAXException {
		String tag;
		if ( !qName.equals( "" ) ) {
			tag = qName;
		} else {
			tag = localName;
		}

		if ( tag.equals( Constants.xmlMenuStart ) ) {
			fValidFile = true;
		}

		// set to false with each starting element
		fValidEntry = false;

		// make sure it's a valid file before we start to process
		// must contain the <ramenu> at the start of the file
		if ( fValidFile ) {
			if ( tag.equals( Constants.xmlMenu ) ) {
				// we have a menu entry
				// pull out the attributes
				if ( attr.getLength() > 0 ) {
					String s;
					s = attr.getValue( Constants.xmlAtributePosition );
					if ( s != null ) {
						currentPosition = Integer.parseInt( s );
					}
					s = attr.getValue( Constants.xmlAttributeLabel );
					if ( (s != null) && (currentPosition != -1) ) {
						setLabel( currentPosition, s );
						// valid if we have a label and a position
						fValidEntry = true;
						// update the menu quantity count
						menuQty++;
					}
				}
			}
		}
	}

}
