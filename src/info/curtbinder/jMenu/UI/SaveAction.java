package info.curtbinder.jMenu.UI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SaveAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaveAction () {
		putValue( NAME, "Save to XML..." );
	}

	@Override
	public void actionPerformed ( ActionEvent arg0 ) {
		// save current menu entry
		MenuApp.getController().saveCurrentEntry();
		// call Save function
		MenuApp.getController().saveXML();
	}

}
