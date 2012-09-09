package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XMLFileFilter extends FileFilter {

	public static String XML_EXTENSION = "xml"; //$NON-NLS-1$

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
		return "XML File (*.xml)"; //$NON-NLS-1$
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
