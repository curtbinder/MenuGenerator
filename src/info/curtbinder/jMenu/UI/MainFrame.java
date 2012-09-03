package info.curtbinder.jMenu.UI;

import info.curtbinder.jMenu.Classes.ClearFunctionAdapter;
import info.curtbinder.jMenu.Classes.GenerateAdapter;
import info.curtbinder.jMenu.Classes.LoadSimpleMenuAdapter;
import info.curtbinder.jMenu.Classes.MenuEntryChangedAdapter;
import info.curtbinder.jMenu.Classes.MenuQuantityChangedAdapter;
import info.curtbinder.jMenu.Classes.ResetMenuAdapter;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7616347540723215322L;
	private JPanel contentPane;
	private JTextArea textCode;
	private JTextField txtLabel;
	private JComboBox cboMenuEntry;
	private JButton btnPredefinedFunctions;

	public MainFrame () {
		setMinimumSize( new Dimension( 450, 300 ) );
		setTitle( "Menu Generator" );
		setBounds( 100, 100, 600, 435 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		setJMenuBar( new MenuBar() );
		contentPane = new JPanel();
		contentPane.setLayout( new BoxLayout( contentPane, BoxLayout.X_AXIS ) );

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.add( verticalBox );
		setContentPane( contentPane );

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add( horizontalBox );

		JLabel lblMenuEntries = new JLabel( "Menu Entries:" );
		horizontalBox.add( lblMenuEntries );

		Component rigidArea = Box.createRigidArea( new Dimension( 5, 5 ) );
		horizontalBox.add( rigidArea );

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount( 9 );
		comboBox.setModel( new DefaultComboBoxModel( new String[] { "1",
																	"2",
																	"3",
																	"4",
																	"5",
																	"6",
																	"7",
																	"8",
																	"9" } ) );
		comboBox.setSelectedIndex( 5 );
		comboBox.setMaximumSize( new Dimension( 60, 20 ) );
		comboBox.setPreferredSize( new Dimension( 60, 20 ) );
		comboBox.addItemListener( new MenuQuantityChangedAdapter() );
		horizontalBox.add( comboBox );

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add( horizontalGlue );

		JButton btnReset = new JButton( "Reset Menu" );
		btnReset.addActionListener( new ResetMenuAdapter() );
		horizontalBox.add( btnReset );

		Component rigidArea_1 = Box.createRigidArea( new Dimension( 5, 5 ) );
		horizontalBox.add( rigidArea_1 );

		JButton btnLoadSimpleMenu = new JButton( "Load Simple Menu" );
		btnLoadSimpleMenu.addActionListener( new LoadSimpleMenuAdapter() );
		horizontalBox.add( btnLoadSimpleMenu );

		Component rigidArea_2 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_2 );

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setAlignmentX( Component.CENTER_ALIGNMENT );
		verticalBox.add( verticalBox_1 );

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add( horizontalBox_1 );

		cboMenuEntry = new JComboBox();
		MenuEntryChangedAdapter mec = new MenuEntryChangedAdapter();
		cboMenuEntry.addItemListener( mec );
		cboMenuEntry.setModel( MenuApp.getController().getMenuEntryComboList() );
		cboMenuEntry.setMaximumRowCount( 9 );
		cboMenuEntry.setPreferredSize( new Dimension( 200, 20 ) );
		cboMenuEntry.setMaximumSize( new Dimension( 260, 20 ) );
		horizontalBox_1.add( cboMenuEntry );

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add( horizontalGlue_1 );

		Component rigidArea_7 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox_1.add( rigidArea_7 );

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentY( Component.CENTER_ALIGNMENT );
		verticalBox_1.add( horizontalBox_2 );

		JLabel lblMenuLabel = new JLabel( "Menu Label:" );
		lblMenuLabel.setAlignmentX( Component.CENTER_ALIGNMENT );
		horizontalBox_2.add( lblMenuLabel );

		Component rigidArea_3 = Box.createRigidArea( new Dimension( 5, 5 ) );
		horizontalBox_2.add( rigidArea_3 );

		txtLabel = new JTextField();
		txtLabel.setPreferredSize( new Dimension( 120, 20 ) );
		txtLabel.setMaximumSize( new Dimension( 240, 20 ) );
		horizontalBox_2.add( txtLabel );
		txtLabel.setColumns( 16 );

		Component rigidArea_4 = Box.createRigidArea( new Dimension( 5, 5 ) );
		horizontalBox_2.add( rigidArea_4 );

		JLabel lblmaxCharacters =
				new JLabel( "(Max of 20 characters for label)" );
		lblmaxCharacters.setAlignmentX( Component.CENTER_ALIGNMENT );
		horizontalBox_2.add( lblmaxCharacters );

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add( horizontalGlue_2 );

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_1.add( horizontalBox_3 );

		JLabel lblEnterMenuCode = new JLabel( "Enter menu code below:" );
		lblEnterMenuCode.setAlignmentY( Component.TOP_ALIGNMENT );
		horizontalBox_3.add( lblEnterMenuCode );

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_3.add( horizontalGlue_3 );

		btnPredefinedFunctions = new JButton( new PredefinedFunctionAction() );
		horizontalBox_3.add( btnPredefinedFunctions );

		Component rigidArea_5 = Box.createRigidArea( new Dimension( 5, 5 ) );
		horizontalBox_3.add( rigidArea_5 );

		JButton btnClearFunction = new JButton( "Clear Function" );
		btnClearFunction.addActionListener( new ClearFunctionAdapter() );
		horizontalBox_3.add( btnClearFunction );

		Component rigidArea_8 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox_1.add( rigidArea_8 );

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		scrollPane.setAutoscrolls( true );
		verticalBox_1.add( scrollPane );

		textCode = new JTextArea();
		scrollPane.setViewportView( textCode );
		textCode.setAutoscrolls( false );
		textCode.setTabSize( 4 );
		textCode.setLineWrap( true );

		Component rigidArea_6 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_6 );

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add( horizontalBox_4 );

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_4.add( horizontalGlue_4 );

		JButton btnGenerate = new JButton( "Generate" );
		btnGenerate.addActionListener( new GenerateAdapter() );
		horizontalBox_4.add( btnGenerate );
	}

	public int getCurrentMenuEntry ( ) {
		// getSelectedIndex is 0 based, return 1 based for use elsewhere
		return cboMenuEntry.getSelectedIndex() + 1;
	}

	public void resetMenuEntryList ( ) {
		cboMenuEntry.removeAllItems();
		cboMenuEntry.setModel( MenuApp.getController().getMenuEntryComboList() );
		cboMenuEntry.setSelectedIndex( 0 );
	}

	public String getMenuEntryCode ( ) {
		return textCode.getText();
	}

	public void setMenuEntryCode ( String code ) {
		textCode.setText( code );
	}

	public String getMenuEntryLabel ( ) {
		return txtLabel.getText();
	}

	public void setMenuEntryLabel ( String label ) {
		txtLabel.setText( label );
	}

	public JButton getPredefinedButton ( ) {
		return btnPredefinedFunctions;
	}
}
