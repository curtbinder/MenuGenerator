package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuEntryChangedAdapter implements ItemListener {

	@Override
	public void itemStateChanged ( ItemEvent arg0 ) {
		// 2 events fired with change
		// a DESELECTED is fired first then a SELECTED is fired second
		String item = (String) arg0.getItem();
		String[] words = item.split( " " ); //$NON-NLS-1$
		int i = Integer.parseInt( words[words.length - 1] );
		ControllerMenu c = MenuApp.getController();
		MainFrame f = MenuApp.getFrame();
		if ( arg0.getStateChange() == ItemEvent.SELECTED ) {
			f.setMenuEntryLabel( c.getMenuLabel( i ) );
			f.setMenuEntryCode( c.getMenuCode( i ) );
		}
		if ( arg0.getStateChange() == ItemEvent.DESELECTED ) {
			c.setMenuLabel( i, f.getMenuEntryLabel() );
			c.setMenuCode( i, f.getMenuEntryCode() );
		}
	}

}
