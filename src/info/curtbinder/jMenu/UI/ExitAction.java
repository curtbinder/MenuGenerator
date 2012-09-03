package info.curtbinder.jMenu.UI;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ExitAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed ( ActionEvent e ) {
		System.exit( 0 );
	}

	public ExitAction () {
		putValue(NAME, "Exit");
	}

}
