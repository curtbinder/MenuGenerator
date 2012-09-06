package info.curtbinder.jMenu.UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class CodeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2086654583810433708L;
	private JTextArea textCode;
	private JTextArea setupCode;

	public CodeWindow ( JFrame mainFrame ) {
		super( mainFrame );
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setMinimumSize( new Dimension( 500, 400 ) );
		setTitle( "Output Code" );
		getContentPane().setLayout( new BoxLayout( getContentPane(),
										BoxLayout.X_AXIS ) );

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		getContentPane().add( verticalBox );

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add( horizontalBox );

		JLabel lblGlobalCode =
				new JLabel( "Enter this code in the Globals section:" );
		horizontalBox.add( lblGlobalCode );

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add( horizontalGlue );

		JScrollPane codeWindow = new JScrollPane();
		codeWindow
				.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		codeWindow.setAutoscrolls( true );
		verticalBox.add( codeWindow );
		textCode = new JTextArea();
		codeWindow.setViewportView( textCode );
		textCode.setAutoscrolls( false );
		textCode.setTabSize( 4 );
		textCode.setLineWrap( true );
		textCode.setEditable( false );

		Component rigidArea = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea );

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add( horizontalBox_1 );

		JLabel lblSetupCode =
				new JLabel(
					"Enter this code in the setup function after ReefAngel.init():" );
		horizontalBox_1.add( lblSetupCode );

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add( horizontalGlue_1 );

		JScrollPane initWindow = new JScrollPane();
		initWindow.setPreferredSize(new Dimension(23, 50));
		initWindow.setMaximumSize(new Dimension(32767, 50));
		initWindow.setMinimumSize(new Dimension(23, 50));
		initWindow
				.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		initWindow.setAutoscrolls( true );
		verticalBox.add( initWindow );
		setupCode = new JTextArea();
		initWindow.setViewportView( setupCode );
		setupCode.setAutoscrolls( false );
		setupCode.setTabSize( 4 );
		setupCode.setLineWrap( true );
		setupCode.setEditable( false );

		Component rigidArea_1 = Box.createRigidArea( new Dimension( 5, 5 ) );
		verticalBox.add( rigidArea_1 );

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add( horizontalBox_2 );

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_2.add( horizontalGlue_2 );

		JButton btnClose = new JButton( "Close" );
		btnClose.addActionListener( new ActionListener() {
			public void actionPerformed ( ActionEvent ev ) {
				setVisible( false );
				dispose();
			}
		} );
		horizontalBox_2.add( btnClose );
	}
	
	public void setCodeText ( StringBuilder sb ) {
		textCode.setText( sb.toString() );
	}
	
	public void setCodeSetup ( String s ) {
		setupCode.setText( s );
	}
}
