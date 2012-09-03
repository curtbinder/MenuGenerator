package info.curtbinder.jMenu.UI;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PredefinedMenu extends JPopupMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PredefinedMenu () {
		setLabel( "Label" );
		JMenu start = new JMenu( "Start" );
		JMenuItem feed = new JMenuItem("Feeding Mode");
		JMenuItem water = new JMenuItem("Water Change");
		start.add(feed);
		start.add( water );
		JMenu clear = new JMenu( "Clear" );
		JMenuItem ato = new JMenuItem("ATO");
		JMenuItem overheat = new JMenuItem("Overheat");
		clear.add(ato);
		clear.add( overheat );
		JMenu calibrate = new JMenu( "Calibrate" );
		JMenuItem ph = new JMenuItem("PH");
		JMenuItem salinity = new JMenuItem("Salinity");
		calibrate.add( ph );
		calibrate.add( salinity );
		JMenu lights = new JMenu( "Lights" );
		JMenuItem on = new JMenuItem("Turn On");
		JMenuItem off = new JMenuItem("Turn Off");
		lights.add(on);
		lights.add(off);

		JMenuItem dt = new JMenuItem( "Set Date / Time" );
		JMenuItem display_text = new JMenuItem( "Display Text Entry" );
		JMenuItem display_version = new JMenuItem( "Display Version" );
		JMenuItem reset_watchdog = new JMenuItem( "Reset Watchdog" );

		add( start );
		add( clear );
		add( calibrate );
		add( lights );
		add( dt );
		add( display_text );
		add( display_version );
		add( reset_watchdog );
	}
}
