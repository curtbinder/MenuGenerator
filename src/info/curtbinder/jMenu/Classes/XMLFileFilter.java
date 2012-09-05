package info.curtbinder.jMenu.Classes;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XMLFileFilter extends FileFilter {
	
	public static String XML_EXTENSION = "xml";

	@Override
	public boolean accept ( File f ) {
		if ( f.isDirectory() ) {
			return true;
		}

		String ext = getExtension( f );
		if ( ext != null ) {
			if ( ext.equals( XML_EXTENSION ) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getDescription ( ) {
		return "XML File (*.xml)";
	}

	public static String getExtension ( File f ) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf( '.' );

		if ( i > 0 && i < s.length() - 1 ) {
			ext = s.substring( i + 1 ).toLowerCase();
		}
		return ext;
	}

}
