package info.curtbinder.jMenu.Classes;

import info.curtbinder.jMenu.UI.MainFrame;
import info.curtbinder.jMenu.UI.MenuApp;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuQuantityChangedAdapter implements ItemListener {

	@Override
	public void itemStateChanged ( ItemEvent arg0 ) {
		// 2 events fired with change
		// a DESELECTED is fired first then a SELECTED is fired second
		int i = Integer.parseInt( (String) arg0.getItem() );
		if ( arg0.getStateChange() == ItemEvent.SELECTED ) {
			ControllerMenu c = MenuApp.getController();
			MainFrame f = MenuApp.getFrame();
			c.setMenuQuantity( i );
			f.resetMenuEntryList();
			// reload the code window
			f.resetMenuLabelAndCode();
		}
	}
}
