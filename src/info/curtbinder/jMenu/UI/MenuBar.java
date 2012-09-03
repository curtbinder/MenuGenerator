package info.curtbinder.jMenu.UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuBar() {
		super();
		
		JMenu mnFile = new JMenu("File");
		add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem(new ExitAction());
		mnFile.add(mntmExit);
	}

}
