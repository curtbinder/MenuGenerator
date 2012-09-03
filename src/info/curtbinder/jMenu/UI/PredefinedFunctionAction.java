package info.curtbinder.jMenu.UI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class PredefinedFunctionAction  extends AbstractAction
 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredefinedFunctionAction () {
		 putValue(NAME, "Predefined Functions");
	}

	@Override
	public void actionPerformed ( ActionEvent e ) {
		PredefinedMenu menu = new PredefinedMenu();
		JButton b = MenuApp.getFrame().getPredefinedButton();
		menu.show( b, 0, b.getHeight() );
	}
}
