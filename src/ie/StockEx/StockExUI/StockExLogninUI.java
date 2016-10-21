package ie.StockEx.StockExUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;

public class StockExLogninUI extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton registerButton;

	/**
	 * Create the frame.
	 */
	public StockExLogninUI() {
		setTitle("StockEX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		setContentPane(contentPane);

		// ------------Login Panel---------------------------------
		JPanel loginPanel = new JPanel();

		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(212, 110, 35, 14);
		userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(185, 135, 62, 14);
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		userField = new JTextField();
		userField.setBounds(260, 106, 86, 20);
		userField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(260, 132, 86, 20);

		loginButton = new JButton("Login");
		loginButton.setBounds(231, 163, 86, 23);

		registerButton = new JButton("Register");
		registerButton.setBounds(231, 197, 86, 23);
		loginPanel.setLayout(null);
		loginPanel.add(passwordLabel);
		loginPanel.add(userLabel);
		loginPanel.add(userField);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);
		loginPanel.add(registerButton);
		contentPane.add(loginPanel, "name_174509783095651");
		// --------------------------------------------------------
	}

	public String getUserName() {
		return userField.getText();
	}
	
	public char[] getPassword() {
		return passwordField.getPassword();
	}
	
	public void init() {
		userField.setText("");
		passwordField.setText("");
	}

	public void addLoginButtonListener(ActionListener inLis) {
		loginButton.addActionListener(inLis);
	}

}
