package info.curtbinder.jMenu.UI;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

import info.curtbinder.jMenu.Classes.AddFunctionAdapter;

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
		JMenuItem feed = new JMenuItem( "Feeding Mode" );
		feed.addActionListener( new AddFunctionAdapter("ReefAngel.FeedingModeStart();\r\n") );
		JMenuItem water = new JMenuItem( "Water Change" );
		water.addActionListener( new AddFunctionAdapter("ReefAngel.WaterChangeModeStart();\r\n") );
		start.add( feed );
		start.add( water );
		JMenu clear = new JMenu( "Clear" );
		JMenuItem ato = new JMenuItem( "ATO" );
		ato.addActionListener( new AddFunctionAdapter("ReefAngel.ATOClear();\r\n") );
		JMenuItem overheat = new JMenuItem( "Overheat" );
		overheat.addActionListener( new AddFunctionAdapter("ReefAngel.OverheatClear();\r\n") );
		clear.add( ato );
		clear.add( overheat );
		JMenu calibrate = new JMenu( "Calibrate" );
		JMenuItem ph = new JMenuItem( "PH" );
		ph.addActionListener( new AddFunctionAdapter("ReefAngel.SetupCalibratePH();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n") );
		JMenuItem salinity = new JMenuItem( "Salinity" );
		salinity.addActionListener( new AddFunctionAdapter("ReefAngel.SetupCalibrateSalinity();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n") );
		calibrate.add( ph );
		calibrate.add( salinity );
		JMenu lights = new JMenu( "Lights" );
		JMenuItem on = new JMenuItem( "Turn On" );
		on.addActionListener( new AddFunctionAdapter("" +
"ReefAngel.Relay.RelayMaskOn = ReefAngel.LightsOnPorts;\r\n" +
"#ifdef RelayExp\r\n" +
"for ( byte i = 0; i < MAX_RELAY_EXPANSION_MODULES; i++ )\r\n" +
"{\r\n" +
"    ReefAngel.Relay.RelayMaskOnE[i] = ReefAngel.LightsOnPortsE[i];\r\n" +
"}\r\n" +
"#endif  // RelayExp\r\n" +
"ReefAngel.Relay.Write();\r\n") );
		JMenuItem off = new JMenuItem( "Turn Off" );
		off.addActionListener( new AddFunctionAdapter("" +
"ReefAngel.Relay.RelayMaskOn = 0;\r\n" +
"#ifdef RelayExp\r\n" +
"for ( byte i = 0; i < MAX_RELAY_EXPANSION_MODULES; i++ )\r\n" +
"{\r\n" +
"    ReefAngel.Relay.RelayMaskOnE[i] = 0;\r\n" +
"}\r\n" +
"#endif  // RelayExp\r\n" +
"ReefAngel.Relay.Write();\r\n") );
		lights.add( on );
		lights.add( off );

		JMenuItem dt = new JMenuItem( "Set Date / Time" );
		dt.addActionListener( new AddFunctionAdapter("ReefAngel.SetupDateTime();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n") );
		JMenuItem display_text = new JMenuItem( "Display Text Entry" );
		display_text.addActionListener( new AddFunctionAdapter("ReefAngel.DisplayMenuEntry(\"TEXT\");\r\n") );
		JMenuItem display_version = new JMenuItem( "Display Version" );
		display_version.addActionListener( new AddFunctionAdapter("ReefAngel.DisplayVersion();\r\n") );
		JMenuItem reset_watchdog = new JMenuItem( "Reset Watchdog" );
		reset_watchdog.addActionListener( new AddFunctionAdapter("wdt_reset();\r\n") );

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
