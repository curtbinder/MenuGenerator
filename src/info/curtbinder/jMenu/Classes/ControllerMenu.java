package info.curtbinder.jMenu.Classes;

import javax.swing.DefaultComboBoxModel;

public class ControllerMenu {

	public static final int MAX_MENU_ENTRIES = 9;
	public static final int DEFAULT_ENTRIES = 6;

	private int iMenuQuantity;
	private String[] saLabels;
	private String[] saCode;

	public ControllerMenu () {
		iMenuQuantity = DEFAULT_ENTRIES;
		saLabels = new String[MAX_MENU_ENTRIES];
		saCode = new String[MAX_MENU_ENTRIES];
	}

	public void setMenuQuantity ( int qty ) {
		iMenuQuantity = qty;
	}

	public int getMenuQuantity ( ) {
		return iMenuQuantity;
	}
	
	public DefaultComboBoxModel getMenuEntryComboList ( ) {
		String[] l = new String[iMenuQuantity];
		String s;
		for ( int i = 0; i < iMenuQuantity; i++ ) {
			s = String.format( "Menu Entry %d", i + 1);
			l[i] = s;
		}
		DefaultComboBoxModel aModel = new DefaultComboBoxModel(l);
		return aModel;
	}

	public String getMenuLabel ( int position ) {
		// 1 based index
		return saLabels[position - 1];
	}

	public void setMenuLabel ( int position, String label ) {
		// 1 based index
		saLabels[position - 1] = label;
	}

	public String getMenuCode ( int position ) {
		// 1 based index
		return saCode[position - 1];
	}

	public void setMenuCode ( int position, String code ) {
		// 1 based index
		saCode[position - 1] = code;
	}

	// add in Load / Save
	public void loadXML ( ) {
		
	}
	
	public void saveXML ( ) {
		
	}

	public void generateCode ( ) {
		// generate the output code for the menus
	}
}
