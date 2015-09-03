package com.notpostman.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class NotPostmanUI {

	private JFrame frmNotpostmanV;
	private JTextField txtEnterUrlHere;
	private JTextField textField;
	private JTextField txtEnterUrlHere_1;
	private JTextField txtEnterAnyParams;

	private HttpRequest requestor = new HttpRequest();

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
		frmNotpostmanV.setBounds(100, 100, 450, 290);
		frmNotpostmanV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNotpostmanV.getContentPane().setLayout(null);

		txtEnterUrlHere_1 = new JTextField();
		txtEnterUrlHere_1.setText("Enter URL Here");
		txtEnterUrlHere_1.setBounds(6, 6, 438, 28);
		frmNotpostmanV.getContentPane().add(txtEnterUrlHere_1);
		txtEnterUrlHere_1.setColumns(10);

		JRadioButton rdbtnHttp = new JRadioButton("HTTP");
		rdbtnHttp.setBounds(6, 68, 65, 23);
		frmNotpostmanV.getContentPane().add(rdbtnHttp);

		JRadioButton rdbtnHttps = new JRadioButton("HTTPS");
		rdbtnHttps.setBounds(78, 68, 72, 23);
		frmNotpostmanV.getContentPane().add(rdbtnHttps);

		txtEnterAnyParams = new JTextField();
		txtEnterAnyParams.setText("Enter Any Params Here");
		txtEnterAnyParams.setBounds(6, 39, 438, 28);
		frmNotpostmanV.getContentPane().add(txtEnterAnyParams);
		txtEnterAnyParams.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 68, 103, 27);
		frmNotpostmanV.getContentPane().add(comboBox);
		comboBox.addItem("GET");
		comboBox.addItem("POST");

		JButton btnGo = new JButton("GO");
		btnGo.setBounds(274, 67, 117, 29);
		frmNotpostmanV.getContentPane().add(btnGo);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 103, 417, 151);
		frmNotpostmanV.getContentPane().add(textArea);

		btnGo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				//Button action goes here
				//Create request object
				//Call appropriate method
				//Set response into text area
				String method = (String) comboBox.getSelectedItem();
				String formUrl = txtEnterUrlHere_1.getText();
				String formParams = txtEnterAnyParams.getText();
				Boolean httpRadio = rdbtnHttp.isSelected();
				Boolean httpsRadio = rdbtnHttps.isSelected();

				if(method.equals("GET")){
					requestor.sendGet(formUrl);
				} else {
					requestor.sendPost(formUrl, formParams);
				}
			}
        });
	}
}
