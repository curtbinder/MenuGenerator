package info.curtbinder.jMenu.Classes;

/*
 * Copyright (c) 2012 by Curt Binder (http://curtbinder.info)
 *
 * This work is made available under the terms of the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * http://creativecommons.org/licenses/by-nc-sa/3.0/
 */

public class Constants {

	public static final String appTitle = Messages
			.getString( "Constants.appTitle" ); //$NON-NLS-1$

	public static final int versionMajor = 1;
	public static final int versionMinor = 0;
	public static final int versionRevision = 0;
	public static final String versionBuild = Messages
			.getString( "Constants.versionBuild" ); //$NON-NLS-1$

	public static final String bannerIconName =
			"/images/cb_h_banner-medium.png"; //$NON-NLS-1$
	public static final String appIconName = 
			"/images/Menu.png"; //$NON-NLS-1$

	public static String xmlMenuStart = "ramenu"; //$NON-NLS-1$
	public static String xmlMenu = "menu"; //$NON-NLS-1$
	public static String xmlAttributeLabel = "label"; //$NON-NLS-1$
	public static String xmlAtributePosition = "position"; //$NON-NLS-1$

	public static String xmlFunctionStart = "functions"; //$NON-NLS-1$
	public static String xmlSection = "section"; //$NON-NLS-1$
	public static String xmlItem = "item"; //$NON-NLS-1$
}
