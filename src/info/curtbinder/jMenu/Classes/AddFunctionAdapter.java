package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AddFunctionAdapter extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code = ""; 
	
	public AddFunctionAdapter( String code ) {
		this.code = code;
	}

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		MenuApp.getFrame().updateMenuEntryCode( code );
	}

}
