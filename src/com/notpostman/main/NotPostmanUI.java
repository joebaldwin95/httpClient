package com.notpostman.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class NotPostmanUI {

	private JFrame frmNotpostmanV;
	private JTextField txtEnterUrlHere;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotPostmanUI window = new NotPostmanUI();
					window.frmNotpostmanV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NotPostmanUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNotpostmanV = new JFrame();
		frmNotpostmanV.setTitle("NotPostman v0.1");
		frmNotpostmanV.setBounds(100, 100, 450, 300);
		frmNotpostmanV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNotpostmanV.getContentPane().setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		txtEnterUrlHere = new JTextField();
		txtEnterUrlHere.setToolTipText("You should enter the URL you intend to GET from here.");
		txtEnterUrlHere.setText("Enter URL Here");
		frmNotpostmanV.getContentPane().add(txtEnterUrlHere, "flowx,cell 0 0,alignx left");
		txtEnterUrlHere.setColumns(27);
		
		JButton btnGo = new JButton("Go");
		frmNotpostmanV.getContentPane().add(btnGo, "cell 0 0");
		
		JTextPane txtpnResponse = new JTextPane();
		txtpnResponse.setText("Response...");
		txtpnResponse.setEditable(false);
		frmNotpostmanV.getContentPane().add(txtpnResponse, "cell 0 1,grow");
	}

}
