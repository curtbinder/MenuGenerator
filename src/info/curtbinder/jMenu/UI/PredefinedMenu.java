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
		setLabel( "Label" ); //$NON-NLS-1$
		JMenu start = new JMenu( Messages.getString( "PredefinedMenu.Start" ) ); //$NON-NLS-1$
		JMenuItem feed =
				new JMenuItem( Messages.getString( "PredefinedMenu.Feeding" ) ); //$NON-NLS-1$
		feed.addActionListener( new AddFunctionAdapter(
			"ReefAngel.FeedingModeStart();\r\n" ) ); //$NON-NLS-1$
		JMenuItem water =
				new JMenuItem(
					Messages.getString( "PredefinedMenu.WaterChange" ) ); //$NON-NLS-1$
		water.addActionListener( new AddFunctionAdapter(
			"ReefAngel.WaterChangeModeStart();\r\n" ) ); //$NON-NLS-1$
		start.add( feed );
		start.add( water );
		JMenu clear = new JMenu( Messages.getString( "PredefinedMenu.Clear" ) ); //$NON-NLS-1$
		JMenuItem ato =
				new JMenuItem( Messages.getString( "PredefinedMenu.ATO" ) ); //$NON-NLS-1$
		ato.addActionListener( new AddFunctionAdapter(
			"ReefAngel.ATOClear();\r\n" ) ); //$NON-NLS-1$
		JMenuItem overheat =
				new JMenuItem( Messages.getString( "PredefinedMenu.Overheat" ) ); //$NON-NLS-1$
		overheat.addActionListener( new AddFunctionAdapter(
			"ReefAngel.OverheatClear();\r\n" ) ); //$NON-NLS-1$
		clear.add( ato );
		clear.add( overheat );
		JMenu calibrate =
				new JMenu( Messages.getString( "PredefinedMenu.Calibrate" ) ); //$NON-NLS-1$
		JMenuItem ph =
				new JMenuItem( Messages.getString( "PredefinedMenu.PH" ) ); //$NON-NLS-1$
		ph.addActionListener( new AddFunctionAdapter(
			"ReefAngel.SetupCalibratePH();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n" ) ); //$NON-NLS-1$
		JMenuItem salinity =
				new JMenuItem( Messages.getString( "PredefinedMenu.Salinity" ) ); //$NON-NLS-1$
		salinity.addActionListener( new AddFunctionAdapter(
			"ReefAngel.SetupCalibrateSalinity();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n" ) ); //$NON-NLS-1$
		calibrate.add( ph );
		calibrate.add( salinity );
		JMenu lights =
				new JMenu( Messages.getString( "PredefinedMenu.Lights" ) ); //$NON-NLS-1$
		JMenuItem on =
				new JMenuItem( Messages.getString( "PredefinedMenu.TurnOn" ) ); //$NON-NLS-1$
		on.addActionListener( new AddFunctionAdapter( "" + //$NON-NLS-1$
														"ReefAngel.Relay.RelayMaskOn = ReefAngel.LightsOnPorts;\r\n"
														+ //$NON-NLS-1$
														"#ifdef RelayExp\r\n"
														+ //$NON-NLS-1$
														"for ( byte i = 0; i < MAX_RELAY_EXPANSION_MODULES; i++ )\r\n"
														+ //$NON-NLS-1$
														"{\r\n"
														+ //$NON-NLS-1$
														"    ReefAngel.Relay.RelayMaskOnE[i] = ReefAngel.LightsOnPortsE[i];\r\n"
														+ //$NON-NLS-1$
														"}\r\n"
														+ //$NON-NLS-1$
														"#endif  // RelayExp\r\n"
														+ //$NON-NLS-1$
														"ReefAngel.Relay.Write();\r\n" ) ); //$NON-NLS-1$
		JMenuItem off =
				new JMenuItem( Messages.getString( "PredefinedMenu.TurnOff" ) ); //$NON-NLS-1$
		off.addActionListener( new AddFunctionAdapter( "" + //$NON-NLS-1$
														"ReefAngel.Relay.RelayMaskOn = 0;\r\n"
														+ //$NON-NLS-1$
														"#ifdef RelayExp\r\n"
														+ //$NON-NLS-1$
														"for ( byte i = 0; i < MAX_RELAY_EXPANSION_MODULES; i++ )\r\n"
														+ //$NON-NLS-1$
														"{\r\n"
														+ //$NON-NLS-1$
														"    ReefAngel.Relay.RelayMaskOnE[i] = 0;\r\n"
														+ //$NON-NLS-1$
														"}\r\n"
														+ //$NON-NLS-1$
														"#endif  // RelayExp\r\n"
														+ //$NON-NLS-1$
														"ReefAngel.Relay.Write();\r\n" ) ); //$NON-NLS-1$
		lights.add( on );
		lights.add( off );

		JMenuItem dt =
				new JMenuItem(
					Messages.getString( "PredefinedMenu.SetDateTime" ) ); //$NON-NLS-1$
		dt.addActionListener( new AddFunctionAdapter(
			"ReefAngel.SetupDateTime();\r\nReefAngel.DisplayedMenu = ALT_SCREEN_MODE;\r\n" ) ); //$NON-NLS-1$
		JMenuItem display_text = new JMenuItem( "Display Text Entry" ); //$NON-NLS-1$
		display_text.addActionListener( new AddFunctionAdapter(
			"ReefAngel.DisplayMenuEntry(\"TEXT\");\r\n" ) ); //$NON-NLS-1$
		JMenuItem display_version =
				new JMenuItem( Messages.getString( "PredefinedMenu.Version" ) ); //$NON-NLS-1$
		display_version.addActionListener( new AddFunctionAdapter(
			"ReefAngel.DisplayVersion();\r\n" ) ); //$NON-NLS-1$
		JMenuItem reset_watchdog =
				new JMenuItem(
					Messages.getString( "PredefinedMenu.ResetWatchdog" ) ); //$NON-NLS-1$
		reset_watchdog.addActionListener( new AddFunctionAdapter(
			"wdt_reset();\r\n" ) ); //$NON-NLS-1$

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
